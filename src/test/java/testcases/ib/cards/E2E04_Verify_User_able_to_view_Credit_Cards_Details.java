package testcases.ib.cards;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.internetBanking.CardsPage;

public class E2E04_Verify_User_able_to_view_Credit_Cards_Details extends wrappers.ProjectWrappers{
	
	public E2E04_Verify_User_able_to_view_Credit_Cards_Details() throws IOException {
	}
	
	@BeforeClass
	public void setData() {
		TestCaseName="E2E04_Verify_User_able_to_view_Credit_Cards_Details";
		TestDescription="E2E04_Verify_User_able_to_view_Credit_Cards_Details";
		browserName="chrome";
		Application="Mobeix Retail Banking - IB";
		Authors="Automation Team";
	}
	
	@Test(enabled = true)
	public void verifyAuthScreen() throws Exception
	{
	  System.out.println("E2E04_Verify_User_able_to_view_Credit_Cards_Details Execution Started:");
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
	  	.clickCreditCardDetailsLink()
	  	.verifyCreditCardDetails()
	  	.clickBackButton()
	  	.userLogOut();
		System.out.println("E2E04_Verify_User_able_to_view_Credit_Cards_Details Executed sucessfully");
	}
}
