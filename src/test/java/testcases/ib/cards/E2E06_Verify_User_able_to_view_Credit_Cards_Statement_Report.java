package testcases.ib.cards;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.internetBanking.CardsPage;

public class E2E06_Verify_User_able_to_view_Credit_Cards_Statement_Report extends wrappers.ProjectWrappers{
	
	public E2E06_Verify_User_able_to_view_Credit_Cards_Statement_Report() throws IOException {
	}
	
	@BeforeClass
	public void setData() {
		TestCaseName="E2E06_Verify_User_able_to_view_Credit_Cards_Statement_Report";
		TestDescription="E2E06_Verify_User_able_to_view_Credit_Cards_Statement_Report";
		browserName="chrome";
		Application="Mobeix Retail Banking - IB";
		Authors="Automation Team";
	}
	
	@Test(enabled = true)
	public void verifyAuthScreen() throws Exception
	{
	  System.out.println("E2E06_Verify_User_able_to_view_Credit_Cards_Statement_Report Execution Started:");
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
//	  	.verifyCardsOverview()
//	  	.verifyCreditCard()
//	  	.verifyVisaTitanimCard()
	  	.clickCreditCardStatementLink()
//	  	.verifyCreditCardStatementPageElements()
	  	.selectStartDate("1", "Jan", "2021")
	  	.selectEndDate("1", "Apr", "2021")
	  	.clickDownloadCreditCardStatement()
//	  	.clickBackButton()
	  	.userLogOut();
		System.out.println("E2E06_Verify_User_able_to_view_Credit_Cards_Statement_Report Executed sucessfully");
	}
}
