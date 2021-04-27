package testcases.ib.userProfile;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.internetBanking.ProfilePage;

public class E2E02_Verify_User_able_to_Update_Email_ID extends wrappers.ProjectWrappers{
	
	public E2E02_Verify_User_able_to_Update_Email_ID() throws IOException {
	}
	
	@BeforeClass
	public void setData() {
		TestCaseName="E2E02_Verify_User_able_to_Update_Email_ID";
		TestDescription="E2E02_Verify_User_able_to_Update_Email_ID";
		browserName="chrome";
		Application="Mobeix Retail Banking - IB";
		Authors="Automation Team";
	}
	
	@Test(enabled = true)
	public void verifyAuthScreen() throws Exception
	{
	  System.out.println("E2E02_Verify_User_able_to_Update_Email_ID Execution Started:");
	  new ProfilePage(driver, test)
	  	.enterUserName()
	  	.enterPassword()
	  	.takeMeDirectlyTo("Dashboard")
	  	.clickSignInBtn()
	  	.select2FAType("SMS OTP")
	  	.enterSMSOTP()
	  	.clickSubmitBtn2FAPage()
	  	.verifyDashboardTitle()
	  	.clickProfileArrow()
	  	.clickProfile()
	  	.clickUpdateEmailLink()
	  	.enterEmail()
	  	.clickNextBtn()
	  	.clickConfirmBtn()
	  	.enterSMSOTP()
	  	.clickSubmitBtn2FAPage()
	  	.verifyEmailUpdatedSuccessMessage();
		System.out.println("E2E02_Verify_User_able_to_Update_Email_ID Executed sucessfully");
	}
}
