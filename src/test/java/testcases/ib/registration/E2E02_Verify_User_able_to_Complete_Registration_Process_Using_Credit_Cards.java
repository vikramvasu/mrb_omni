package testcases.ib.registration;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.internetBanking.RegistrationPage;

public class E2E02_Verify_User_able_to_Complete_Registration_Process_Using_Credit_Cards extends wrappers.ProjectWrappers{
	
	public E2E02_Verify_User_able_to_Complete_Registration_Process_Using_Credit_Cards() throws IOException {
	}
	
	@BeforeClass
	public void setData() {
		TestCaseName="E2E02_Verify_User_able_to_Complete_Registration_Process_Using_Credit_Cards";
		TestDescription="E2E02_Verify_User_able_to_Complete_Registration_Process_Using_Credit_Cards";
		browserName="chrome";
		Application="Mobeix Retail Banking - IB";
		Authors="Automation Team";
	}
	
	@Test(enabled = true)
	public void registerUsingCreditCard() throws Exception
	{
	  System.out.println("E2E02_Verify_User_able_to_Complete_Registration_Process_Using_Credit_Cards Execution Started:");
	  new RegistrationPage(driver, test)
	  	.clickRegisterNowBtn()
	  	.clickAgreeBtn()
	  	.selectRegisterType("credit")
	  	.verifyFieldsInCCDetailsPage()
	  	.enterCreditCardNumber()
	  	.selectCardExpiryDate("Mar", "2025")
	  	.enterCreditCardCVV()
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
	  	System.out.println("E2E02_Verify_User_able_to_Complete_Registration_Process_Using_Credit_Cards Executed sucessfully");
	}
}
