package testcases.ib.accounts.casa;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.internetBanking.AccountsPage;

public class E2E10_Verify_User_able_to_view_Operative_Accounts extends wrappers.ProjectWrappers{
	
	public E2E10_Verify_User_able_to_view_Operative_Accounts() throws IOException {
	}
	
	@BeforeClass
	public void setData() {
		TestCaseName="E2E10_Verify_User_able_to_view_Operative_Accounts";
		TestDescription="E2E10_Verify_User_able_to_view_Operative_Accounts";
		browserName="chrome";
		Application="Mobeix Retail Banking - IB";
		Authors="Automation Team";
	}
	
	@Test(enabled = true)
	public void verifyAuthScreen() throws Exception
	{
	  System.out.println("E2E10_Verify_User_able_to_view_Operative_Accounts Execution Started:");
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
	  	.verifyCASAAccountSummary()
	  	.userLogOut();
		System.out.println("E2E10_Verify_User_able_to_view_Operative_Accounts Executed sucessfully");
	}
}
