package testcases.ib.login;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.internetBanking.LoginPage;

public class E2E04_Verify_Forgot_Username_Using_Credit_Card_Details extends wrappers.ProjectWrappers{
	
	public E2E04_Verify_Forgot_Username_Using_Credit_Card_Details() throws IOException {
	}
	
	@BeforeClass
	public void setData() {
		TestCaseName="E2E04_Verify_Forgot_Username_Using_Credit_Card_Details";
		TestDescription="E2E04_Verify_Forgot_Username_Using_Credit_Card_Details";
		browserName="chrome";
		Application="Mobeix Retail Banking - IB";
		Authors="Automation Team";
	}
	
	@Test(enabled = true)
	public void verifyAuthScreen() throws Exception
	{
	  System.out.println("E2E04_Verify_Forgot_Username_Using_Credit_Card_Details Execution Started:");
	  new LoginPage(driver, test)
	  	.clickForgotUsername()
	  	.selectRegisterType("credit")
	  	.enterCreditCardNumber("4214406170983156")
	  	.selectCardExpiryDate("Mar", "2025")
	  	.enterCreditCardCVV()
	  	.clickNextBtn()
//	  	.select2FAType("SMS OTP")
	  	.enterSMSOTP()
	  	.clickSubmitBtn2FAPage()
	  	.verifyForgotUserNameSuccessMessage();
		System.out.println("E2E04_Verify_Forgot_Username_Using_Credit_Card_Details Executed sucessfully");
	}
}
