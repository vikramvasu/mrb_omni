package testcases.ib.dashboard;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.internetBanking.DashboardPage;

public class E2E04_Verify_User_able_to_View_Scheduled_Payment_Widget extends wrappers.ProjectWrappers{
	
	public E2E04_Verify_User_able_to_View_Scheduled_Payment_Widget() throws IOException {
	}
	
	@BeforeClass
	public void setData() {
		TestCaseName="E2E04_Verify_User_able_to_View_Scheduled_Payment_Widget";
		TestDescription="E2E04_Verify_User_able_to_View_Scheduled_Payment_Widget";
		browserName="chrome";
		Application="Mobeix Retail Banking - IB";
		Authors="Automation Team";
	}
	
	@Test(enabled = true)
	public void verifyAuthScreen() throws Exception
	{
	  System.out.println("E2E04_Verify_User_able_to_View_Scheduled_Payment_Widget Execution Started:");
	  new DashboardPage(driver, test)
	  	.enterUserName()
	  	.enterPassword()
	  	.takeMeDirectlyTo("Dashboard")
	  	.clickSignInBtn()
	  	.select2FAType("SMS OTP")
	  	.enterSMSOTP()
	  	.clickSubmitBtn2FAPage()
	  	.verifyDashboardTitle()
	  	.verifyScheduleWidget()
	  	.userLogOut();
		System.out.println("E2E04_Verify_User_able_to_View_Scheduled_Payment_Widget Executed sucessfully");
	}
}
