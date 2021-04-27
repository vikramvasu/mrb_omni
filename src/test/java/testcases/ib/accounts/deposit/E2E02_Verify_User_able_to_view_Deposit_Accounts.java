package testcases.ib.accounts.deposit;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.internetBanking.AccountsPage;

public class E2E02_Verify_User_able_to_view_Deposit_Accounts extends wrappers.ProjectWrappers{
	
	public E2E02_Verify_User_able_to_view_Deposit_Accounts() throws IOException {
	}
	
	@BeforeClass
	public void setData() {
		TestCaseName="E2E02_Verify_User_able_to_view_Deposit_Accounts";
		TestDescription="E2E02_Verify_User_able_to_view_Deposit_Accounts";
		browserName="chrome";
		Application="Mobeix Retail Banking - IB";
		Authors="Automation Team";
	}
	
	@Test(enabled = true)
	public void verifyAuthScreen() throws Exception
	{
	  System.out.println("E2E02_Verify_User_able_to_view_Deposit_Accounts Execution Started:");
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
	  	.clickTermDeposits()
	  	.verifyTermDepositsElements()
	  	.userLogOut();
		System.out.println("E2E02_Verify_User_able_to_view_Deposit_Accounts Executed sucessfully");
	}
}
