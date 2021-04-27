package testcases.ib.accounts.casa;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.internetBanking.AccountsPage;

public class E2E03_Verify_User_able_to_view_CASA_Account_Details extends wrappers.ProjectWrappers{
	
	public E2E03_Verify_User_able_to_view_CASA_Account_Details() throws IOException {
	}
	
	@BeforeClass
	public void setData() {
		TestCaseName="E2E03_Verify_User_able_to_view_CASA_Account_Details";
		TestDescription="E2E03_Verify_User_able_to_view_CASA_Account_Details";
		browserName="chrome";
		Application="Mobeix Retail Banking - IB";
		Authors="Automation Team";
	}
	
	@Test(enabled = true)
	public void verifyAuthScreen() throws Exception
	{
	  System.out.println("E2E03_Verify_User_able_to_view_CASA_Account_Details Execution Started:");
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
	  	.clickAccountDetails()
	  	.verifyAccountDetailsPageElements()
	  	.verifyAccountDetailsData()
	  	.clickBackBtn()
	  	.userLogOut();
		System.out.println("E2E03_Verify_User_able_to_view_CASA_Account_Details Executed sucessfully");
	}
}
