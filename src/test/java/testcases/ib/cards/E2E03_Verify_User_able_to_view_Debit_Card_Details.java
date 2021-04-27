package testcases.ib.cards;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.internetBanking.CardsPage;

public class E2E03_Verify_User_able_to_view_Debit_Card_Details extends wrappers.ProjectWrappers{
	
	public E2E03_Verify_User_able_to_view_Debit_Card_Details() throws IOException {
	}
	
	@BeforeClass
	public void setData() {
		TestCaseName="E2E03_Verify_User_able_to_view_Debit_Card_Details";
		TestDescription="E2E03_Verify_User_able_to_view_Debit_Card_Details";
		browserName="chrome";
		Application="Mobeix Retail Banking - IB";
		Authors="Automation Team";
	}
	
	@Test(enabled = true)
	public void verifyAuthScreen() throws Exception
	{
	  System.out.println("E2E03_Verify_User_able_to_view_Debit_Card_Details Execution Started:");
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
	  	.verifyDebitCard()
	  	.verifyGoldDebitCard()
	  	.clickDebitCardDetailsLink()
	  	.verifyDebitCardDetails()
	  	.clickBackButton()
	  	.userLogOut();
		System.out.println("E2E03_Verify_User_able_to_view_Debit_Card_Details Executed sucessfully");
	}
}
