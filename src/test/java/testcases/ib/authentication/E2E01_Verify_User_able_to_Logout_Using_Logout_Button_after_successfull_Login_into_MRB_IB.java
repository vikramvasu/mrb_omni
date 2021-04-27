package testcases.ib.authentication;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.internetBanking.LoginPage;

public class E2E01_Verify_User_able_to_Logout_Using_Logout_Button_after_successfull_Login_into_MRB_IB extends wrappers.ProjectWrappers{
	
	public E2E01_Verify_User_able_to_Logout_Using_Logout_Button_after_successfull_Login_into_MRB_IB() throws IOException {
	}
	
	@BeforeClass
	public void setData() {
		TestCaseName="E2E01_Verify_User_able_to_Logout_Using_Logout_Button_after_successfull_Login_into_MRB_IB";
		TestDescription="E2E01_Verify_User_able_to_Logout_Using_Logout_Button_after_successfull_Login_into_MRB_IB";
		browserName="chrome";
		Application="Mobeix Retail Banking - IB";
		Authors="Automation Team";
	}
	
	@Test(enabled = true)
	public void verifyLogout() throws Exception
	{
	  System.out.println("E2E01_Verify_User_able_to_Logout_Using_Logout_Button_after_successfull_Login_into_MRB_IB Execution Started:");
	  new LoginPage(driver, test)
	  	.enterUserName()
	  	.enterPassword()
	  	.takeMeDirectlyTo("Dashboard")
	  	.clickSignInBtn()
	  	.select2FAType("SMS OTP")
	  	.enterSMSOTP()
	  	.clickSubmitBtn2FAPage()
	  	.verifyDashboardTitle()
	  	.userLogOut();
		System.out.println("E2E01_Verify_User_able_to_Logout_Using_Logout_Button_after_successfull_Login_into_MRB_IB Executed sucessfully");
	}
}
