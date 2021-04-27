package testcases.ib.settings;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.internetBanking.SettingsPage;

public class E2E02_Verify_User_able_to_Add_or_Link_Accounts_Using_Debit_Card_Details extends wrappers.ProjectWrappers{
	
	public E2E02_Verify_User_able_to_Add_or_Link_Accounts_Using_Debit_Card_Details() throws IOException {
	}
	
	@BeforeClass
	public void setData() {
		TestCaseName="E2E02_Verify_User_able_to_Add_or_Link_Accounts_Using_Debit_Card_Details";
		TestDescription="E2E02_Verify_User_able_to_Add_or_Link_Accounts_Using_Debit_Card_Details";
		browserName="chrome";
		Application="Mobeix Retail Banking - IB";
		Authors="Automation Team";
	}
	
	@Test(enabled = true)
	public void verifyAuthScreen() throws Exception
	{
	  System.out.println("E2E02_Verify_User_able_to_Add_or_Link_Accounts_Using_Debit_Card_Details Execution Started:");
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
	  	.selectAddAccountType("debit")
	  	.enterDebitCardNumber()
	  	.enterDebitCardPin()
	  	.clickNextBtn()
	  	.clickConfirmButton()
	  	.enterSMSOTP()
	  	.clickSubmitBtn2FAPage()
	  	.verifyAccountLinkingSuccessMessage();
		System.out.println("E2E02_Verify_User_able_to_Add_or_Link_Accounts_Using_Debit_Card_Details Executed sucessfully");
	}
}
