package testcases.ib.dashboard;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.internetBanking.DashboardPage;

public class E2E02_Verify_User_able_to_View_Two_Dynamic_Widgets extends wrappers.ProjectWrappers{
	
	public E2E02_Verify_User_able_to_View_Two_Dynamic_Widgets() throws IOException {
	}
	
	@BeforeClass
	public void setData() {
		TestCaseName="E2E02_Verify_User_able_to_View_Two_Dynamic_Widgets";
		TestDescription="E2E02_Verify_User_able_to_View_Two_Dynamic_Widgets";
		browserName="chrome";
		Application="Mobeix Retail Banking - IB";
		Authors="Automation Team";
	}
	
	@Test(enabled = true)
	public void verifyAuthScreen() throws Exception
	{
	  System.out.println("E2E02_Verify_User_able_to_View_Two_Dynamic_Widgets Execution Started:");
	  new DashboardPage(driver, test)
	  	.enterUserName()
	  	.enterPassword()
	  	.takeMeDirectlyTo("Dashboard")
	  	.clickSignInBtn()
	  	.select2FAType("SMS OTP")
	  	.enterSMSOTP()
	  	.clickSubmitBtn2FAPage()
	  	.verifyDashboardTitle()
	  	.verifyDynamicWidgets()
	  	.userLogOut();
		System.out.println("E2E02_Verify_User_able_to_View_Two_Dynamic_Widgets Executed sucessfully");
	}
}
