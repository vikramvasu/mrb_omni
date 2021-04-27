package testcases.ib.userProfile;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.internetBanking.ProfilePage;

public class E2E05_Verify_User_able_to_Upload_Profile_Picture extends wrappers.ProjectWrappers{
	
	public E2E05_Verify_User_able_to_Upload_Profile_Picture() throws IOException {
	}
	
	@BeforeClass
	public void setData() {
		TestCaseName="E2E05_Verify_User_able_to_Upload_Profile_Picture";
		TestDescription="E2E05_Verify_User_able_to_Upload_Profile_Picture";
		browserName="chrome";
		Application="Mobeix Retail Banking - IB";
		Authors="Automation Team";
	}
	
	@Test(enabled = true)
	public void verifyAuthScreen() throws Exception
	{
	  System.out.println("E2E05_Verify_User_able_to_Upload_Profile_Picture Execution Started:");
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
	  	.clickProfileIcon()
	  	.uploadProfilePic()
	  	.clickSaveButton()
	  	.verifyProfilePicUploadedSuccessMessage()
	  	.clickOKButton()
	  	.userLogOut();
		System.out.println("E2E05_Verify_User_able_to_Upload_Profile_Picture Executed sucessfully");
	}
}
