package testcases.ib.dashboard;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.internetBanking.DashboardPage;

public class E2E05_Verify_User_able_to_View_Accounts_Widgets extends wrappers.ProjectWrappers{
	
	public E2E05_Verify_User_able_to_View_Accounts_Widgets() throws IOException {
	}
	
	@BeforeClass
	public void setData() {
		TestCaseName="E2E05_Verify_User_able_to_View_Accounts_Widgets";
		TestDescription="E2E05_Verify_User_able_to_View_Accounts_Widgets";
		browserName="chrome";
		Application="Mobeix Retail Banking - IB";
		Authors="Automation Team";
	}
	
	@Test(enabled = true)
	public void verifyAuthScreen() throws Exception
	{
	  System.out.println("E2E05_Verify_User_able_to_View_Accounts_Widgets Execution Started:");
	  new DashboardPage(driver, test)
	  	.enterUserName()
	  	.enterPassword()
	  	.takeMeDirectlyTo("Dashboard")
	  	.clickSignInBtn()
	  	.select2FAType("SMS OTP")
	  	.enterSMSOTP()
	  	.clickSubmitBtn2FAPage()
	  	.verifyDashboardTitle()
	  	.verifyAccountWidget()
	  	.verifyOperativeLabel()
	  	.verifyLoanLabel()
	  	.verifyDepositsLabel()
	  	.verifySwipingCard()
	  	.userLogOut();
		System.out.println("E2E05_Verify_User_able_to_View_Accounts_Widgets Executed sucessfully");
	}
}
