package testcases.admin.login;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.admin.CustomerManagementPage;

public class E2E02_Verify_User_able_to_Logout_from_MRB_Admin_After_Successful_Login extends wrappers.ProjectWrappers{
	
	public E2E02_Verify_User_able_to_Logout_from_MRB_Admin_After_Successful_Login() throws IOException {
	}
	
	@BeforeClass
	public void setData() {
		TestCaseName="E2E02_Verify_User_able_to_Logout_from_MRB_Admin_After_Successful_Login";
		TestDescription="E2E02_Verify_User_able_to_Logout_from_MRB_Admin_After_Successful_Login";
		browserName="chrome";
		Application="Mobeix Retail Banking - Admin";
		Authors="Automation Team";
	}
	
	@Test(enabled = true)
	public void verifyAuthScreen() throws Exception
	{
	  System.out.println("E2E02_Verify_User_able_to_Logout_from_MRB_Admin_After_Successful_Login Execution Started:");
	  new CustomerManagementPage(driver, test)
	  	.enterUserName("qamaker123")
	  	.enterPassword()
	  	.clickSignInBtn()
//	  	.verifyMobeixAdminHeader()
	  	.clickProfileButton()
	  	.userLogOut();
		System.out.println("E2E02_Verify_User_able_to_Logout_from_MRB_Admin_After_Successful_Login Executed sucessfully");
	}
}
