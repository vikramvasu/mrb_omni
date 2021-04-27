package testcases.ib.accounts.loans;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.internetBanking.AccountsPage;

public class E2E09_Verify_User_able_to_Edit_Loan_Account_Nickname extends wrappers.ProjectWrappers{
	
	public E2E09_Verify_User_able_to_Edit_Loan_Account_Nickname() throws IOException {
	}
	
	@BeforeClass
	public void setData() {
		TestCaseName="E2E09_Verify_User_able_to_Edit_Loan_Account_Nickname";
		TestDescription="E2E09_Verify_User_able_to_Edit_Loan_Account_Nickname";
		browserName="chrome";
		Application="Mobeix Retail Banking - IB";
		Authors="Automation Team";
	}
	
	@Test(enabled = true)
	public void verifyAuthScreen() throws Exception
	{
	  System.out.println("E2E09_Verify_User_able_to_Edit_Loan_Account_Nickname Execution Started:");
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
	  	.clickLoanDetails()
	  	.clickEditAccountNickname()
	  	.enterNickName()
	  	.clickUpdateButton()
	  	.verifyNicknameUpdatedSuccessMessage()
	  	.clickOKbtn()
	  	.userLogOut();
		System.out.println("E2E09_Verify_User_able_to_Edit_Loan_Account_Nickname Executed sucessfully");
	}
}
