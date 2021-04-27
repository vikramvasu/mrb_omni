package testcases.ib.cards;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.internetBanking.CardsPage;

public class E2E10_Verify_User_able_to_Manage_Card_Limit extends wrappers.ProjectWrappers{
	
	public E2E10_Verify_User_able_to_Manage_Card_Limit() throws IOException {
	}
	
	@BeforeClass
	public void setData() {
		TestCaseName="E2E10_Verify_User_able_to_Manage_Card_Limit";
		TestDescription="E2E10_Verify_User_able_to_Manage_Card_Limit";
		browserName="chrome";
		Application="Mobeix Retail Banking - IB";
		Authors="Automation Team";
	}
	
	@Test(enabled = true)
	public void verifyAuthScreen() throws Exception
	{
	  System.out.println("E2E10_Verify_User_able_to_Manage_Card_Limit Execution Started:");
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
	  	.clickManageLimitArrow()
	  	.clickUpdateButton()
	  	.enterPOSLimit()
	  	.enterTransLimit()
	  	.clickNextBtn()
	  	.clickConfirmButton()
	  	.enterSMSOTP()
	  	.clickSubmitBtn2FAPage()
//	  	.verifyLimitUpdatedSuccessMessage()
	  	.userLogOut();
		System.out.println("E2E10_Verify_User_able_to_Manage_Card_Limit Executed sucessfully");
	}
}
