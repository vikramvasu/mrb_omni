package testcases.ib.login;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.internetBanking.LoginPage;

public class E2E01_Verify_User_able_to_Login_into_MRB_with_Valid_Credentials_Using_SMS_OTP extends wrappers.ProjectWrappers{
	
	public E2E01_Verify_User_able_to_Login_into_MRB_with_Valid_Credentials_Using_SMS_OTP() throws IOException {
	}
	
	@BeforeClass
	public void setData() {
		TestCaseName="E2E01_Verify_User_able_to_Login_into_MRB_with_Valid_Credentials_Using_SMS_OTP";
		TestDescription="E2E01_Verify_User_able_to_Login_into_MRB_with_Valid_Credentials_Using_SMS_OTP";
		browserName="chrome";
		Application="Mobeix Retail Banking - IB";
		Authors="Automation Team";
	}
	
	@Test(enabled = true)
	public void verifyAuthScreen() throws Exception
	{
	  System.out.println("E2E01_Verify_User_able_to_Login_into_MRB_with_Valid_Credentials_Using_SMS_OTP Execution Started:");
	  new LoginPage(driver, test)
	  	.enterUserName()
	  	.enterPassword()
	  	.takeMeDirectlyTo("Dashboard")
	  	.clickSignInBtn()
	  	.select2FAType("SMS OTP")
	  	.enterSMSOTP()
	  	.clickSubmitBtn2FAPage()
	  	.verifyDashboardTitle();
		System.out.println("E2E01_Verify_User_able_to_Login_into_MRB_with_Valid_Credentials_Using_SMS_OTP Executed sucessfully");
	}
}
