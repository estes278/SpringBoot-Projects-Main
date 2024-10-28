package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import com.luv2code.aopdemo.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication
{

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO,
											   MembershipDAO membershipDAO,
											   TrafficFortuneService trafficFortuneService)
	{
		return runner ->
		{
			// demoTheBeforeAdvice(accountDAO, membershipDAO);
			// demoTheAfterReturningAdvice(accountDAO);
			// demoTheAfterThrowingAdvice(accountDAO);
			// demoTheAfterAdvice(accountDAO);
			// demoTheAroundAdvice(trafficFortuneService);
			// demoTheAroundAdviceHandleException(trafficFortuneService);
			demoTheAroundAdviceRethrowException(trafficFortuneService);

		};
	}

	private void demoTheAroundAdviceRethrowException(TrafficFortuneService trafficFortuneService)
	{
		System.out.println("\n\nMain Program: demoAroundAdviceRethrowException");
		System.out.println("Calling getFortune().......");

		boolean tripWire = true;
		String data = null;
		try
		{
			data = trafficFortuneService.getFortune(tripWire);
		}
		catch (Exception ex)
		{
			System.out.println("Exception Caught in Main Application: " + ex.getMessage());
			data = "Failed to retrieve";
		}

		System.out.println("\nMy fortune is: " + data);
		System.out.println("Finished");
	}

	private void demoTheAroundAdviceHandleException(TrafficFortuneService trafficFortuneService)
	{
		System.out.println("\n\nMain Program: demoAroundAdviceHandleException");
		System.out.println("Calling getFortune().......");

		boolean tripWire = true;
		String data = trafficFortuneService.getFortune(tripWire);

		System.out.println("\nMy fortune is: " + data);
		System.out.println("Finished");
	}

	private void demoTheAroundAdvice(TrafficFortuneService trafficFortuneService)
	{
		System.out.println("\n\nMain Program: demoAroundAdvice");
		System.out.println("Calling getFortune().......");
		String data = trafficFortuneService.getFortune();
		System.out.println("\nMy fortune is: " + data);
		System.out.println("Finished");
	}

	private void demoTheAfterAdvice(AccountDAO accountDAO)
	{
		// call method to find accounts
		List<Account> accounts = null;

		try
		{
			// add a boolean flag to simulate exceptions
			boolean tripWire = false;
			accounts = accountDAO.findAccounts(tripWire);
		}
		catch (Exception ex)
		{
			System.out.println("\n\nMain Program ==> Exception Caught! Details: " + ex);
		}

		// display the accounts
		System.out.println("\n\nMain Program: ===> demoTheAfterThrowingAdvice");
		System.out.println("===================");
		System.out.println(accounts);
		System.out.println("\n\n");
	}

	private void demoTheAfterThrowingAdvice(AccountDAO accountDAO)
	{
		// call method to find accounts
		List<Account> accounts = null;

		try
		{
			// add a boolean flag to simulate exceptions
			boolean tripWire = true;
			accounts = accountDAO.findAccounts(tripWire);
		}
		catch (Exception ex)
		{
			System.out.println("\n\nMain Program ==> Exception Caught! Details: " + ex);
		}

		// display the accounts
		System.out.println("\n\nMain Program: ===> demoTheAfterThrowingAdvice");
		System.out.println("===================");
		System.out.println(accounts);
		System.out.println("\n\n");
	}

	private void demoTheAfterReturningAdvice(AccountDAO accountDAO)
	{
		// call method to find accounts
		List<Account> accounts = accountDAO.findAccounts();

		// display the accounts
		System.out.println("\n\nMain Program: ===> demoTheAfterReturningAdvice");
		System.out.println("===================");
		System.out.println(accounts);
		System.out.println("\n\n");
	}

	private void demoTheBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO)
	{
		accountDAO.addAccount(new Account("Nico", "Top Gun"), true);
		membershipDAO.addAccount();

		accountDAO.setFirstName("Trevor");
		accountDAO.getFirstName();
		accountDAO.setServiceCode("117");
		accountDAO.getServiceCode();

	}

}
