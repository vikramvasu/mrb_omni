package testcases.ib.prelogin;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.internetBanking.PreLoginPage;

public class E2E04_Verify_User_able_to_click_View_Demo extends wrappers.ProjectWrappers{
	
	public E2E04_Verify_User_able_to_click_View_Demo() throws IOException {
	}
	
	@BeforeClass
	public void setData() {
		TestCaseName="E2E04_Verify_User_able_to_click_View_Demo";
		TestDescription="E2E04_Verify_User_able_to_click_View_Demo";
		browserName="chrome";
		Application="Mobeix Retail Banking - IB";
		Authors="Automation Team";
	}
	
	@Test(enabled = true)
	public void verifyAuthScreen() throws Exception
	{
	  System.out.println("E2E04_Verify_User_able_to_click_View_Demo Execution Started:");
	  new PreLoginPage(driver, test)
	  	.clickViewDemoTab();
		System.out.println("E2E04_Verify_User_able_to_click_View_Demo Executed sucessfully");
	}
}
