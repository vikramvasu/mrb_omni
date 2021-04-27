package testcases.ib.cards;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.internetBanking.CardsPage;

public class E2E11_Verify_User_able_to_Pay_Credit_Card extends wrappers.ProjectWrappers{
	
	public E2E11_Verify_User_able_to_Pay_Credit_Card() throws IOException {
	}
	
	@BeforeClass
	public void setData() {
		TestCaseName="E2E11_Verify_User_able_to_Pay_Credit_Card";
		TestDescription="E2E11_Verify_User_able_to_Pay_Credit_Card";
		browserName="chrome";
		Application="Mobeix Retail Banking - IB";
		Authors="Automation Team";
	}
	
	@Test(enabled = true)
	public void verifyAuthScreen() throws Exception
	{
	  System.out.println("E2E11_Verify_User_able_to_Pay_Credit_Card Execution Started:");
	  new CardsPage(driver, test)
	  	.enterUserName()
	  	.enterPassword()
	  	.takeMeDirectlyTo("Dashboard")
	  	.clickSignInBtn()
	  	.select2FAType("SMS OTP")
	  	.enterSMSOTP()
	  	.clickSubmitBtn2FAPage()
//	  	.verifyDashboardTitle()
	  	.clickCardsMenu()
	  	.verifyCardsOverview()
	  	.verifyCreditCard()
	  	.verifyVisaTitanimCard()
	  	.clickPayCreditCardLink()
	  	.userLogOut();
		System.out.println("E2E11_Verify_User_able_to_Pay_Credit_Card Executed sucessfully");
	}
}
