package testcases.ib.cards;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.internetBanking.CardsPage;

public class E2E08_Verify_User_able_to_Permanently_Block_Cards extends wrappers.ProjectWrappers{
	
	public E2E08_Verify_User_able_to_Permanently_Block_Cards() throws IOException {
	}
	
	@BeforeClass
	public void setData() {
		TestCaseName="E2E08_Verify_User_able_to_Permanently_Block_Cards";
		TestDescription="E2E08_Verify_User_able_to_Permanently_Block_Cards";
		browserName="chrome";
		Application="Mobeix Retail Banking - IB";
		Authors="Automation Team";
	}
	
	@Test(enabled = true)
	public void verifyAuthScreen() throws Exception
	{
	  System.out.println("E2E08_Verify_User_able_to_Permanently_Block_Cards Execution Started:");
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
	  	.clickBlockCardSwitch()
	  	.selectBlockType("Permanent")
	  	.selectTemporayBlockReason("Lost")
	  	.clickNextBtn()
	  	.clickConfirmButton()
	  	.enterSMSOTP()
	  	.clickSubmitBtn2FAPage()
	  	.verifyPermanentlyBlockedSuccessMessage()
	  	.clickOKBtn()
	  	.userLogOut();
		System.out.println("E2E08_Verify_User_able_to_Permanently_Block_Cards Executed sucessfully");
	}
}
