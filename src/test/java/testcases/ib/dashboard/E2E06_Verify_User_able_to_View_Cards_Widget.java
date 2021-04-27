package testcases.ib.dashboard;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.internetBanking.DashboardPage;

public class E2E06_Verify_User_able_to_View_Cards_Widget extends wrappers.ProjectWrappers{
	
	public E2E06_Verify_User_able_to_View_Cards_Widget() throws IOException {
	}
	
	@BeforeClass
	public void setData() {
		TestCaseName="E2E06_Verify_User_able_to_View_Cards_Widget";
		TestDescription="E2E06_Verify_User_able_to_View_Cards_Widget";
		browserName="chrome";
		Application="Mobeix Retail Banking - IB";
		Authors="Automation Team";
	}
	
	@Test(enabled = true)
	public void verifyAuthScreen() throws Exception
	{
	  System.out.println("E2E06_Verify_User_able_to_View_Cards_Widget Execution Started:");
	  new DashboardPage(driver, test)
	  	.enterUserName()
	  	.enterPassword()
	  	.takeMeDirectlyTo("Dashboard")
	  	.clickSignInBtn()
	  	.select2FAType("SMS OTP")
	  	.enterSMSOTP()
	  	.clickSubmitBtn2FAPage()
	  	.verifyDashboardTitle()
	  	.verifyCardWidget()
	  	.verifyCardsLabel()
	  	.verifyMonitor()
	  	.userLogOut();
		System.out.println("E2E06_Verify_User_able_to_View_Cards_Widget Executed sucessfully");
	}
}
