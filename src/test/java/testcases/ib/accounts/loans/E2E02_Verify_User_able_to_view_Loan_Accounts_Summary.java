package testcases.ib.accounts.loans;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.internetBanking.AccountsPage;

public class E2E02_Verify_User_able_to_view_Loan_Accounts_Summary extends wrappers.ProjectWrappers{
	
	public E2E02_Verify_User_able_to_view_Loan_Accounts_Summary() throws IOException {
	}
	
	@BeforeClass
	public void setData() {
		TestCaseName="E2E02_Verify_User_able_to_view_Loan_Accounts_Summary";
		TestDescription="E2E02_Verify_User_able_to_view_Loan_Accounts_Summary";
		browserName="chrome";
		Application="Mobeix Retail Banking - IB";
		Authors="Automation Team";
	}
	
	@Test(enabled = true)
	public void verifyAuthScreen() throws Exception
	{
	  System.out.println("E2E02_Verify_User_able_to_view_Loan_Accounts_Summary Execution Started:");
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
	  	.clickLoanAccounts()
//	  	.verifyLoanAccountsElements()
	  	.verifyLoanAccountSummary()
	  	.userLogOut();
		System.out.println("E2E02_Verify_User_able_to_view_Loan_Accounts_Summary Executed sucessfully");
	}
}
