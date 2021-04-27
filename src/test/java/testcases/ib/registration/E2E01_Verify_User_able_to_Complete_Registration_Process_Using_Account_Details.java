package testcases.ib.registration;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.internetBanking.RegistrationPage;

public class E2E01_Verify_User_able_to_Complete_Registration_Process_Using_Account_Details extends wrappers.ProjectWrappers{
	
	public E2E01_Verify_User_able_to_Complete_Registration_Process_Using_Account_Details() throws IOException {
	}
	
	@BeforeClass
	public void setData() {
		TestCaseName="E2E01_Verify_User_able_to_Complete_Registration_Process_Using_Account_Details";
		TestDescription="E2E01_Verify_User_able_to_Complete_Registration_Process_Using_Account_Details";
		browserName="chrome";
		Application="Mobeix Retail Banking - IB";
		Authors="Automation Team";
	}
	
	@Test(enabled = true)
	public void registerUsingAccountType() throws Exception
	{
	  System.out.println("E2E01_Verify_User_able_to_Complete_Registration_Process_Using_Account_Details Execution Started:");
	  new RegistrationPage(driver, test)
	  	.clickRegisterNowBtn()
	  	.clickAgreeBtn()
	  	.selectRegisterType("account")
	  	.selectAccountType("casa")
	  	.enterAccountNumber()
	  	.selectDOB("5", "Feb", "1980")
	  	.clickNextBtn()
	  	.select2FAType("SMS OTP")
	  	.enterSMSOTP()
	  	.clickSubmitBtn()
	  	.enterUserName()		
	  	.clickSubmitBtn()	  	
	  	.verifyUsernameTick()
	  	.enterPassword()
	  	.clickSubmitBtn()
		.verifyandClickPasswordEyeIcon()
	  	.enterConfirmPassword()
	  	.clickSubmitBtn()
	  	.verifyRegistrationSuccessMessage();
	  	System.out.println("E2E01_Verify_User_able_to_Complete_Registration_Process_Using_Account_Details Executed sucessfully");
	}
}
