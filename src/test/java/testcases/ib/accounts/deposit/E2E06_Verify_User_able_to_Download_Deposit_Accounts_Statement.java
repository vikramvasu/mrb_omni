package testcases.ib.accounts.deposit;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.internetBanking.AccountsPage;

public class E2E06_Verify_User_able_to_Download_Deposit_Accounts_Statement extends wrappers.ProjectWrappers{
	
	public E2E06_Verify_User_able_to_Download_Deposit_Accounts_Statement() throws IOException {
	}
	
	@BeforeClass
	public void setData() {
		TestCaseName="E2E06_Verify_User_able_to_Download_Deposit_Accounts_Statement";
		TestDescription="E2E06_Verify_User_able_to_Download_Deposit_Accounts_Statement";
		browserName="chrome";
		Application="Mobeix Retail Banking - IB";
		Authors="Automation Team";
	}
	
	@Test(enabled = true)
	public void verifyAuthScreen() throws Exception
	{
	  System.out.println("E2E06_Verify_User_able_to_Download_Deposit_Accounts_Statement Execution Started:");
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
	  	.clickDepositTransactionsLink()
	  	.verifyDepositTransactionsDetailsHeading()
	  	.clickLast10Btn()
//	  	.clickLast30Btn()
//	  	.clickLast3MonthsBtn()
//	  	.selectCustomStatement()
//	  	.clickViewStatementBtn()
	  	.downloadStatement()
	  	.userLogOut();
		System.out.println("E2E06_Verify_User_able_to_Download_Deposit_Accounts_Statement Executed sucessfully");
	}
}
