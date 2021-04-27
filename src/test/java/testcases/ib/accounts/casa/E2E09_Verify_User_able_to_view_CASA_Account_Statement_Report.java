package testcases.ib.accounts.casa;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.internetBanking.AccountsPage;

public class E2E09_Verify_User_able_to_view_CASA_Account_Statement_Report extends wrappers.ProjectWrappers{
	
	public E2E09_Verify_User_able_to_view_CASA_Account_Statement_Report() throws IOException {
	}
	
	@BeforeClass
	public void setData() {
		TestCaseName="E2E09_Verify_User_able_to_view_CASA_Account_Statement_Report";
		TestDescription="E2E09_Verify_User_able_to_view_CASA_Account_Statement_Report";
		browserName="chrome";
		Application="Mobeix Retail Banking - IB";
		Authors="Automation Team";
	}
	
	@Test(enabled = true)
	public void verifyAuthScreen() throws Exception
	{
	  System.out.println("E2E09_Verify_User_able_to_view_CASA_Account_Statement_Report Execution Started:");
	  new AccountsPage(driver, test)
	  	.enterUserName()
	  	.enterPassword()
	  	.takeMeDirectlyTo("Dashboard")
	  	.clickSignInBtn()
	  	.select2FAType("SMS OTP")
	  	.enterSMSOTP()
	  	.clickSubmitBtn2FAPage()
//	  	.verifyDashboardTitle()
	  	.clickAccountsTab()
	  	.verifyAccountOverviewHeading()
//	  	.verifyAccountOverviewPageElements()
//	  	.verifyAccountSummary()
	  	.clickAccountSummaryArrowLink()
	  	.clickAccountTransactionDetailsLink()
	  	.verifyAccountTransactionsDetailsHeading()
	  	.clickLast10Btn()
	  	.clickLast30Btn()
	  	.clickLast3MonthsBtn()
	  	.selectCustomStatement()
	  	.clickViewStatementBtn()
	  	.downloadStatement()
	  	.userLogOut();
		System.out.println("E2E09_Verify_User_able_to_view_CASA_Account_Statement_Report Executed sucessfully");
	}
}
