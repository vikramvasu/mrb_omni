package testcases.ib.dashboard;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.internetBanking.DashboardPage;

public class E2E01_Verify_User_able_to_Search_in_Dashboard extends wrappers.ProjectWrappers{
	
	public E2E01_Verify_User_able_to_Search_in_Dashboard() throws IOException {
	}
	
	@BeforeClass
	public void setData() {
		TestCaseName="E2E01_Verify_User_able_to_Search_in_Dashboard";
		TestDescription="E2E01_Verify_User_able_to_Search_in_Dashboard";
		browserName="chrome";
		Application="Mobeix Retail Banking - IB";
		Authors="Automation Team";
	}
	
	@Test(enabled = true)
	public void verifyAuthScreen() throws Exception
	{
	  System.out.println("E2E01_Verify_User_able_to_Search_in_Dashboard Execution Started:");
	  new DashboardPage(driver, test)
	  	.enterUserName()
	  	.enterPassword()
	  	.takeMeDirectlyTo("Dashboard")
	  	.clickSignInBtn()
	  	.select2FAType("SMS OTP")
	  	.enterSMSOTP()
	  	.clickSubmitBtn2FAPage()
	  	.verifyDashboardTitle()
	  	.clickSearchIcon()
	  	.enterDetails("local transfer")
	  	.userLogOut();
		System.out.println("E2E01_Verify_User_able_to_Search_in_Dashboard Executed sucessfully");
	}
}
