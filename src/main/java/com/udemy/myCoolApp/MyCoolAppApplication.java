package com.udemy.myCoolApp;

import com.udemy.myCoolApp.dao.AccountDAO;
import com.udemy.myCoolApp.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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

			demoTheBeforeAdvice(theAccountDAO, theMembershipDAO);
		};
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
		theAccountDAO.setServiceCode("silver");

		String name = theAccountDAO.getName();
		String code = theAccountDAO.getServiceCode();

		//call the membership business method
		theMembershipDAO.addSillyMember();
		theMembershipDAO.goToSleep();

	}

}
