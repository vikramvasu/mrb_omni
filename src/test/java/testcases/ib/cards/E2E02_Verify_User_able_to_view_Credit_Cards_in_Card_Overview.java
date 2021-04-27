package testcases.ib.cards;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.internetBanking.CardsPage;

public class E2E02_Verify_User_able_to_view_Credit_Cards_in_Card_Overview extends wrappers.ProjectWrappers{
	
	public E2E02_Verify_User_able_to_view_Credit_Cards_in_Card_Overview() throws IOException {
	}
	
	@BeforeClass
	public void setData() {
		TestCaseName="E2E02_Verify_User_able_to_view_Credit_Cards_in_Card_Overview";
		TestDescription="E2E02_Verify_User_able_to_view_Credit_Cards_in_Card_Overview";
		browserName="chrome";
		Application="Mobeix Retail Banking - IB";
		Authors="Automation Team";
	}
	
	@Test(enabled = true)
	public void verifyAuthScreen() throws Exception
	{
	  System.out.println("E2E02_Verify_User_able_to_view_Credit_Cards_in_Card_Overview Execution Started:");
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
	  	.userLogOut();
		System.out.println("E2E02_Verify_User_able_to_view_Credit_Cards_in_Card_Overview Executed sucessfully");
	}
}
