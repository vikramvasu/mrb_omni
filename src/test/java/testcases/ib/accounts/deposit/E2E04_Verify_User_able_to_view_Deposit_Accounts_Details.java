package testcases.ib.accounts.deposit;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.internetBanking.AccountsPage;

public class E2E04_Verify_User_able_to_view_Deposit_Accounts_Details extends wrappers.ProjectWrappers{
	
	public E2E04_Verify_User_able_to_view_Deposit_Accounts_Details() throws IOException {
	}
	
	@BeforeClass
	public void setData() {
		TestCaseName="E2E04_Verify_User_able_to_view_Deposit_Accounts_Details";
		TestDescription="E2E04_Verify_User_able_to_view_Deposit_Accounts_Details";
		browserName="chrome";
		Application="Mobeix Retail Banking - IB";
		Authors="Automation Team";
	}
	
	@Test(enabled = true)
	public void verifyAuthScreen() throws Exception
	{
	  System.out.println("E2E04_Verify_User_able_to_view_Deposit_Accounts_Details Execution Started:");
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
	  	.clickTermDepositDetails()
	  	.verifyTermDepositPageElements()
	  	.verifyTermDepositData()
	  	.clickBackBtn()
	  	.userLogOut();
		System.out.println("E2E04_Verify_User_able_to_view_Deposit_Accounts_Details Executed sucessfully");
	}
}
