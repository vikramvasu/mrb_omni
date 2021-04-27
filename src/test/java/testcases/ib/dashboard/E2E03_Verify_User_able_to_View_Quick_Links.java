package testcases.ib.dashboard;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.internetBanking.DashboardPage;

public class E2E03_Verify_User_able_to_View_Quick_Links extends wrappers.ProjectWrappers{
	
	public E2E03_Verify_User_able_to_View_Quick_Links() throws IOException {
	}
	
	@BeforeClass
	public void setData() {
		TestCaseName="E2E03_Verify_User_able_to_View_Quick_Links";
		TestDescription="E2E03_Verify_User_able_to_View_Quick_Links";
		browserName="chrome";
		Application="Mobeix Retail Banking - IB";
		Authors="Automation Team";
	}
	
	@Test(enabled = true)
	public void verifyAuthScreen() throws Exception
	{
	  System.out.println("E2E03_Verify_User_able_to_View_Quick_Links Execution Started:");
	  new DashboardPage(driver, test)
	  	.enterUserName()
	  	.enterPassword()
	  	.takeMeDirectlyTo("Dashboard")
	  	.clickSignInBtn()
	  	.select2FAType("SMS OTP")
	  	.enterSMSOTP()
	  	.clickSubmitBtn2FAPage()
	  	.verifyDashboardTitle()
	  	.verifyQuickLinkWidget()
	  	.verifyOneTimeTransferLabel()
	  	.verifyPayBillsLabel()
	  	.verifyAddBillerLabel()
	  	.verifyManageCardsLabel()
	  	.userLogOut();
		System.out.println("E2E03_Verify_User_able_to_View_Quick_Links Executed sucessfully");
	}
}
