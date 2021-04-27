package testcases.ib.registration;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.internetBanking.RegistrationPage;

public class E2E03_Verify_User_able_to_Complete_Registration_Process_Using_Debit_Cards extends wrappers.ProjectWrappers{
	
	public E2E03_Verify_User_able_to_Complete_Registration_Process_Using_Debit_Cards() throws IOException {
	}
	
	@BeforeClass
	public void setData() {
		TestCaseName="E2E03_Verify_User_able_to_Complete_Registration_Process_Using_Debit_Cards";
		TestDescription="E2E03_Verify_User_able_to_Complete_Registration_Process_Using_Debit_Cards";
		browserName="chrome";
		Application="Mobeix Retail Banking - IB";
		Authors="Automation Team";
	}
	
	@Test(enabled = true)
	public void registerUsingDebitCard() throws Exception
	{
	  System.out.println("E2E03_Verify_User_able_to_Complete_Registration_Process_Using_Debit_Cards Execution Started:");
	  new RegistrationPage(driver, test)
	  	.clickRegisterNowBtn()
	  	.clickAgreeBtn()
	  	.selectRegisterType("debit")
	  	.verifyFieldsInDebitCardDetailsPage()
	  	.enterDebitCardNumber()
	  	.enterDebitCardPin()
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
	  	System.out.println("E2E03_Verify_User_able_to_Complete_Registration_Process_Using_Debit_Cards Executed sucessfully");
	}
}
