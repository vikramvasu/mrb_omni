package testcases.ib.login;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.internetBanking.LoginPage;

public class E2E02_Verify_User_able_to_Login_into_MRB_with_Valid_Credentials_Using_Debit_Card_Auth extends wrappers.ProjectWrappers{
	
	public E2E02_Verify_User_able_to_Login_into_MRB_with_Valid_Credentials_Using_Debit_Card_Auth() throws IOException {
	}
	
	@BeforeClass
	public void setData() {
		TestCaseName="E2E02_Verify_User_able_to_Login_into_MRB_with_Valid_Credentials_Using_Debit_Card_Auth";
		TestDescription="E2E02_Verify_User_able_to_Login_into_MRB_with_Valid_Credentials_Using_Debit_Card_Auth";
		browserName="chrome";
		Application="Mobeix Retail Banking - IB";
		Authors="Automation Team";
	}
	
	@Test(enabled = true)
	public void verifyAuthScreen() throws Exception
	{
	  System.out.println("E2E02_Verify_User_able_to_Login_into_MRB_with_Valid_Credentials_Using_Debit_Card_Auth Execution Started:");
	  new LoginPage(driver, test)
	  	.enterUserName("autoqa3969")
	  	.enterPassword("Password3164")
	  	.takeMeDirectlyTo("Dashboard")
	  	.clickSignInBtn()
	  	.select2FAType("Debit Card")
	  	.enterDebitCardNumber("3211351918895246")
	  	.enterDebitCardPin()
	  	.clickSubmitBtn2FAPage()
	  	.verifyDashboardTitle();
		System.out.println("E2E02_Verify_User_able_to_Login_into_MRB_with_Valid_Credentials_Using_Debit_Card_Auth Executed sucessfully");
	}
}
