package testcases.ib.settings;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.internetBanking.SettingsPage;

public class E2E06_Verify_User_able_to_Manage_Transaction_Limit extends wrappers.ProjectWrappers{
	
	public E2E06_Verify_User_able_to_Manage_Transaction_Limit() throws IOException {
	}
	
	@BeforeClass
	public void setData() {
		TestCaseName="E2E06_Verify_User_able_to_Manage_Transaction_Limit";
		TestDescription="E2E06_Verify_User_able_to_Manage_Transaction_Limit";
		browserName="chrome";
		Application="Mobeix Retail Banking - IB";
		Authors="Automation Team";
	}
	
	@Test(enabled = true)
	public void verifyAuthScreen() throws Exception
	{
	  System.out.println("E2E06_Verify_User_able_to_Manage_Transaction_Limit Execution Started:");
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
	  	.clickManageTransactionLimit()
	  	.clickUpdateButton()
	  	.enterChannelLimit()
	  	.enterTransactionLimit()
	  	.clickNextBtn()
	  	.clickConfirmButton()
	  	.enterSMSOTP()
	  	.clickSubmitBtn2FAPage()
	  	.verifyManageTransactionSuccessMessage()
	  	.userLogOut();
		System.out.println("E2E06_Verify_User_able_to_Manage_Transaction_Limit Executed sucessfully");
	}
}
