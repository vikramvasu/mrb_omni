package testcases.ib.prelogin;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.internetBanking.PreLoginPage;

public class E2E01_Verify_User_able_to_click_FAQs_link extends wrappers.ProjectWrappers{
	
	public E2E01_Verify_User_able_to_click_FAQs_link() throws IOException {
	}
	
	@BeforeClass
	public void setData() {
		TestCaseName="E2E01_Verify_User_able_to_click_FAQs_link";
		TestDescription="E2E01_Verify_User_able_to_click_FAQs_link";
		browserName="chrome";
		Application="Mobeix Retail Banking - IB";
		Authors="Automation Team";
	}
	
	@Test(enabled = true)
	public void verifyAuthScreen() throws Exception
	{
	  System.out.println("E2E01_Verify_User_able_to_click_FAQs_link Execution Started:");
	  new PreLoginPage(driver, test)
	  	.clickFAQTab();
		System.out.println("E2E01_Verify_User_able_to_click_FAQs_link Executed sucessfully");
	}
}
