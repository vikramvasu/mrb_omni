package testcases.ib.login;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.internetBanking.LoginPage;

public class E2E06_Verify_Forgot_Password_Using_Account_Details extends wrappers.ProjectWrappers{
	
	public E2E06_Verify_Forgot_Password_Using_Account_Details() throws IOException {
	}
	
	@BeforeClass
	public void setData() {
		TestCaseName="E2E06_Verify_Forgot_Password_Using_Account_Details";
		TestDescription="E2E06_Verify_Forgot_Password_Using_Account_Details";
		browserName="chrome";
		Application="Mobeix Retail Banking - IB";
		Authors="Automation Team";
	}
	
	@Test(enabled = true)
	public void verifyAuthScreen() throws Exception
	{
	  System.out.println("E2E06_Verify_Forgot_Password_Using_Account_Details Execution Started:");
	  new LoginPage(driver, test)
	  	.clickForgotPassword()
	  	.enterForgotPasswordUserName("autouser9876")
	  	.clickNextBtn()
//	  	.clickForgotPasswordNextBtn()
	  	.selectRegisterType("account")
	  	.selectAccountType("casa")
	  	.enterAccountNumber("144563698745638")
	  	.selectDOB("5", "Feb", "1980")
	  	.clickNextBtn()
//	  	.select2FAType("SMS OTP")
	  	.enterSMSOTP()
	  	.clickSubmitBtn2FAPage()
	  	.enterPasswordForForgotPwd()
	  	.verifyandClickPasswordEyeIcon()
	  	.enterForgotPwdConfirmPassword()
	  	.clickSubmitBtn()
	  	.verifyPasswordChangedSuccessMessage();
		System.out.println("E2E06_Verify_Forgot_Password_Using_Account_Details Executed sucessfully");
	}
}
