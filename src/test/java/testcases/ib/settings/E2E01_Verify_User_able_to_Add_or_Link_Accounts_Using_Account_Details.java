package testcases.ib.settings;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.internetBanking.SettingsPage;

public class E2E01_Verify_User_able_to_Add_or_Link_Accounts_Using_Account_Details extends wrappers.ProjectWrappers{
	
	public E2E01_Verify_User_able_to_Add_or_Link_Accounts_Using_Account_Details() throws IOException {
	}
	
	@BeforeClass
	public void setData() {
		TestCaseName="E2E01_Verify_User_able_to_Add_or_Link_Accounts_Using_Account_Details";
		TestDescription="E2E01_Verify_User_able_to_Add_or_Link_Accounts_Using_Account_Details";
		browserName="chrome";
		Application="Mobeix Retail Banking - IB";
		Authors="Automation Team";
	}
	
	@Test(enabled = true)
	public void verifyAuthScreen() throws Exception
	{
	  System.out.println("E2E01_Verify_User_able_to_Add_or_Link_Accounts_Using_Account_Details Execution Started:");
	  new SettingsPage(driver, test)
	  	.enterUserName()
	  	.enterPassword()
	  	.takeMeDirectlyTo("Dashboard")
	  	.clickSignInBtn()
	  	.select2FAType("SMS OTP")
	  	.enterSMSOTP()
	  	.clickSubmitBtn2FAPage()
	  	.verifyDashboardTitle()
	  	.clickSettingsArrow()
	  	.clickAddLinkAccounts()
	  	.selectAddAccountType("account")
	  	.selectAccountType("casa")
	  	.enterAccountNumber()
	  	.selectDOB("5", "Feb", "1980")
	  	.clickNextBtn()
	  	.clickConfirmButton()
	  	.enterSMSOTP()
	  	.clickSubmitBtn2FAPage()
	  	.verifyAccountLinkingSuccessMessage();
		System.out.println("E2E01_Verify_User_able_to_Add_or_Link_Accounts_Using_Account_Details Executed sucessfully");
	}
}
