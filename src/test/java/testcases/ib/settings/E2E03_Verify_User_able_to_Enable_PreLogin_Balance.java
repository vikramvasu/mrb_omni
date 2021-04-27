package testcases.ib.settings;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.internetBanking.SettingsPage;

public class E2E03_Verify_User_able_to_Enable_PreLogin_Balance extends wrappers.ProjectWrappers{
	
	public E2E03_Verify_User_able_to_Enable_PreLogin_Balance() throws IOException {
	}
	
	@BeforeClass
	public void setData() {
		TestCaseName="E2E03_Verify_User_able_to_Enable_PreLogin_Balance";
		TestDescription="E2E03_Verify_User_able_to_Enable_PreLogin_Balance";
		browserName="chrome";
		Application="Mobeix Retail Banking - IB";
		Authors="Automation Team";
	}
	
	@Test(enabled = true)
	public void verifyAuthScreen() throws Exception
	{
	  System.out.println("E2E03_Verify_User_able_to_Enable_PreLogin_Balance Execution Started:");
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
	  	.clickPreLoginBalance()
	  	.EnableDisablePrLoginBalance("enable");
		System.out.println("E2E03_Verify_User_able_to_Enable_PreLogin_Balance Executed sucessfully");
	}
}
