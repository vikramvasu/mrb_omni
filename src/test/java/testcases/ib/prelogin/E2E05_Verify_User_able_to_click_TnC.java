package testcases.ib.prelogin;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.internetBanking.PreLoginPage;

public class E2E05_Verify_User_able_to_click_TnC extends wrappers.ProjectWrappers{
	
	public E2E05_Verify_User_able_to_click_TnC() throws IOException {
	}
	
	@BeforeClass
	public void setData() {
		TestCaseName="E2E05_Verify_User_able_to_click_TnC";
		TestDescription="E2E05_Verify_User_able_to_click_TnC";
		browserName="chrome";
		Application="Mobeix Retail Banking - IB";
		Authors="Automation Team";
	}
	
	@Test(enabled = true)
	public void verifyAuthScreen() throws Exception
	{
	  System.out.println("E2E05_Verify_User_able_to_click_TnC Execution Started:");
	  new PreLoginPage(driver, test)
	  	.clickSecurityAndPrivacyLink();
		System.out.println("E2E05_Verify_User_able_to_click_TnC Executed sucessfully");
	}
}
