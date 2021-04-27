package testcases.ib.cards;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.internetBanking.CardsPage;

public class E2E09_Verify_User_able_to_Reset_Card_Pin extends wrappers.ProjectWrappers{
	
	public E2E09_Verify_User_able_to_Reset_Card_Pin() throws IOException {
	}
	
	@BeforeClass
	public void setData() {
		TestCaseName="E2E09_Verify_User_able_to_Reset_Card_Pin";
		TestDescription="E2E09_Verify_User_able_to_Reset_Card_Pin";
		browserName="chrome";
		Application="Mobeix Retail Banking - IB";
		Authors="Automation Team";
	}
	
	@Test(enabled = true)
	public void verifyAuthScreen() throws Exception
	{
	  System.out.println("E2E09_Verify_User_able_to_Reset_Card_Pin Execution Started:");
	  new CardsPage(driver, test)
	  	.enterUserName()
	  	.enterPassword()
	  	.takeMeDirectlyTo("Dashboard")
	  	.clickSignInBtn()
	  	.select2FAType("SMS OTP")
	  	.enterSMSOTP()
	  	.clickSubmitBtn2FAPage()
//	  	.verifyDashboardTitle()
	  	.clickCardsArrow()
	  	.clickManageCards()
	  	.clickResetCardPinArrow()
	  	.enterCreditCardCVV()
	  	.selectDOB("5", "Feb", "1980")
	  	.clickNextBtn()
	  	.enterPin()
	  	.comfirmPin()
	  	.clickNextBtn()
	  	.enterSMSOTP()
	  	.clickSubmitBtn2FAPage()
	  	.verifyResetPinSuccessMessage()
	  	.userLogOut();
		System.out.println("E2E09_Verify_User_able_to_Reset_Card_Pin Executed sucessfully");
	}
}
