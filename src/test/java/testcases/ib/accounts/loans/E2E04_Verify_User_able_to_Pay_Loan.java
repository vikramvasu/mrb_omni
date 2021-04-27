package testcases.ib.accounts.loans;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.internetBanking.AccountsPage;

public class E2E04_Verify_User_able_to_Pay_Loan extends wrappers.ProjectWrappers{
	
	public E2E04_Verify_User_able_to_Pay_Loan() throws IOException {
	}
	
	@BeforeClass
	public void setData() {
		TestCaseName="E2E04_Verify_User_able_to_Pay_Loan";
		TestDescription="E2E04_Verify_User_able_to_Pay_Loan";
		browserName="chrome";
		Application="Mobeix Retail Banking - IB";
		Authors="Automation Team";
	}
	
	@Test(enabled = true)
	public void verifyAuthScreen() throws Exception
	{
	  System.out.println("E2E04_Verify_User_able_to_Pay_Loan Execution Started:");
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
	  	.clickPayNow()
	  	.enterLoanPaymentAmount()
	  	.clickConfirmBtn()
	  	.verifyLoanSuccessMessage()
	  	.userLogOut();
		System.out.println("E2E04_Verify_User_able_to_Pay_Loan Executed sucessfully");
	}
}
