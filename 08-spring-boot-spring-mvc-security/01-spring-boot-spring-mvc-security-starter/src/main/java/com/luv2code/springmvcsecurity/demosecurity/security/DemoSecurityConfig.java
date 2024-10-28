package com.luv2code.springmvcsecurity.demosecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig
{
    /* We started out using hard-coded UserDetails but later added database support, so
    this is no longer needed
    @Bean
    public InMemoryUserDetailsManager userDetailsManager()
    {
        UserDetails mike = User.builder()
                .username("mike")
                .password("{noop}test123")
                .roles("Employee")
                .build();

        UserDetails madison = User.builder()
                .username("madison")
                .password("{noop}test123")
                .roles("Employee", "Manager")
                .build();

        UserDetails jessica = User.builder()
                .username("jessica")
                .password("{noop}test123")
                .roles("Employee", "Manager", "Admin")
                .build();

        return new InMemoryUserDetailsManager(mike,madison,jessica);
    }
    */

    @Bean
    // Inject data source to be auto-configured by Spring Boot
    // Removes the need for hard-coded users
    public UserDetailsManager userDetailsManager(DataSource source)
    {
        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(source);

        // This sets up our own custom queries for the custom table names we made
        // as opposed to the default names that Spring Security is looking for
        // The ? is actually a parameter that will be passed in, it will be the user who is logged in
        userDetailsManager.setUsersByUsernameQuery("select user_id, pw, active from members where user_id=?");
        userDetailsManager.setAuthoritiesByUsernameQuery("select user_id, role from roles where user_id=?");

        // Tell Spring to use JDBC Authentication with our data source
        return userDetailsManager;
    }


    // Configure spring security to make use of our custom login form
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
    {
        http.authorizeHttpRequests(configurer ->
                configurer
                        // Request matching roles for each page. This effectively restricts access based on Role
                        .requestMatchers("/").hasRole("EMPLOYEE")
                        .requestMatchers("/leaders/**").hasRole("MANAGER")
                        .requestMatchers("/systems/**").hasRole("ADMIN")
                        .anyRequest().authenticated()) // Any request to the app must be authenticated
                .formLogin(form -> // Customize the login process
                        form
                                .loginPage("/showMyLoginPage") // Show our custom form at the request mapping /showMyLoginPage
                                .loginProcessingUrl("/authenticateTheUser") // Login form should POST data to this URL for processing (check user id and password)
                                // No controller Request Mapping required for the processing URL, Spring gives us this for free
                                .permitAll() // Anyone can see the login page, no need to be logged in
                )
                .logout(logout -> logout.permitAll() // Allow anyone to see the logout page at default URL /logout
                )
                .exceptionHandling(configurer ->
                        configurer.accessDeniedPage("/access-denied"));

        return http.build();

    }


}
