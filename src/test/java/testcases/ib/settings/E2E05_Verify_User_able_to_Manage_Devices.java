package testcases.ib.settings;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.internetBanking.SettingsPage;

public class E2E05_Verify_User_able_to_Manage_Devices extends wrappers.ProjectWrappers{
	
	public E2E05_Verify_User_able_to_Manage_Devices() throws IOException {
	}
	
	@BeforeClass
	public void setData() {
		TestCaseName="E2E05_Verify_User_able_to_Manage_Devices";
		TestDescription="E2E05_Verify_User_able_to_Manage_Devices";
		browserName="chrome";
		Application="Mobeix Retail Banking - IB";
		Authors="Automation Team";
	}
	
	@Test(enabled = true)
	public void verifyAuthScreen() throws Exception
	{
	  System.out.println("E2E05_Verify_User_able_to_Manage_Devices Execution Started:");
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
	  	.clickManageDevice()
	  	.selectDeviceCheckbox()
	  	.clickDeregisterButton()
	  	.clickNextBtn()
	  	.enterSMSOTP()
	  	.clickSubmitBtn2FAPage();
//	  	.verifyDeRegisterSuccessMessage();  	
		System.out.println("E2E05_Verify_User_able_to_Manage_Devices Executed sucessfully");
	}
}
