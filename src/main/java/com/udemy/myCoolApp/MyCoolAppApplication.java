package com.udemy.myCoolApp;

import com.udemy.myCoolApp.dao.AccountDAO;
import com.udemy.myCoolApp.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

/*scanBasePackages = {"com.udemy.myCoolApp",
		"com.udemy.util"})
 */
@SpringBootApplication
public class MyCoolAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyCoolAppApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO  theAccountDAO, MembershipDAO  theMembershipDAO) {
		return runner -> {

			//demoTheBeforeAdvice(theAccountDAO, theMembershipDAO);
			//demoTheAfterReturningAdvice(theAccountDAO);
			//demoTheAfterThrowingAdvice(theAccountDAO);
			demoTheAfterAdvice(theAccountDAO);
		};
	}

	private void demoTheAfterAdvice(AccountDAO theAccountDAO) {

		List<Account> theAccounts = null;

		try {
			// add a boolean flag to simulate exceptions
			boolean tripWire = false;
			theAccounts = theAccountDAO.findAccounts(tripWire);

		} catch (Exception exc) {
			System.out.println("\n\nMain Program ... caught exception: " + exc);
		}
		// display the accounts
		System.out.println("\n\nMain Program: AfterThrowingAdvice");
		System.out.println("-------");

		System.out.println(theAccounts);

		System.out.println("\n");
	}

	private void demoTheAfterThrowingAdvice(AccountDAO theAccountDAO) {

		List<Account> theAccounts = null;

		try {
			// add a boolean flag to simulate exceptions
			boolean tripWire = true;
			theAccounts = theAccountDAO.findAccounts(tripWire);

		} catch (Exception exc) {
			System.out.println("\n\nMain Program ... caught exception: " + exc);
		}
		// display the accounts
		System.out.println("\n\nMain Program: AfterThrowingAdvice");
		System.out.println("-------");

		System.out.println(theAccounts);

		System.out.println("\n");
	}

	private void demoTheAfterReturningAdvice(AccountDAO theAccountDAO) {

		//call method  to find the accounts
		List<Account> theAccounts = theAccountDAO.findAccounts();

		//display the accounts
		System.out.println("\n\nMain Program: AfterReturningAdvice");
		System.out.println("-------");

		System.out.println(theAccounts);

		System.out.println("\n");
	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {

		//call the business method
		Account myAccount = new Account();
		myAccount.setName("sercan");
		myAccount.setLevel("junior");

		theAccountDAO.addAccount(myAccount, true);
		theAccountDAO.doWork();

		//call the accountdao getter/setter methods
		theAccountDAO.setName("sercan");
		theAccountDAO.setServiceCode("senior");

		String name = theAccountDAO.getName();
		String code = theAccountDAO.getServiceCode();

		//call the membership business method
		theMembershipDAO.addSillyMember();
		theMembershipDAO.goToSleep();

	}

}
