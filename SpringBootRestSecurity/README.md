# SpringBootRestSecurity
Projects demonstrating the use of Spring Security to secure endpoints, both declaratively and programatically

Here we’ve added security to our REST endpoints using Spring Security. We leveraged the http.authorizeHttpRequests and a lambda expression that I didn’t fully understand to set access restrictions based on role. For example, only a user with role ADMIN can perform a DELETE operation. We tested these operations using Postman.

Next, we removed the hard-coded user creation section and instead allowed JDBC to handle the creation of users in our database. We first had to create the database schema and tables with the script provided. These MUST match the intended syntax because it’s what Spring Security is looking for.
Next up, we stopped using ugly and unsafe plain text passwords and instead replaced it with bcrypt so that our passwords would be encrypted. This is a one-way encryption, which means that the passwords cannot be de-crypted once they have been encrypted. We validate them by comparing encrypted version to encrypted version to preserve privacy. 
