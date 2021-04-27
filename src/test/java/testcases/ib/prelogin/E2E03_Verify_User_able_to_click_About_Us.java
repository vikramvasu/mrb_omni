package testcases.ib.prelogin;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.internetBanking.PreLoginPage;

public class E2E03_Verify_User_able_to_click_About_Us extends wrappers.ProjectWrappers{
	
	public E2E03_Verify_User_able_to_click_About_Us() throws IOException {
	}
	
	@BeforeClass
	public void setData() {
		TestCaseName="E2E03_Verify_User_able_to_click_About_Us";
		TestDescription="E2E03_Verify_User_able_to_click_About_Us";
		browserName="chrome";
		Application="Mobeix Retail Banking - IB";
		Authors="Automation Team";
	}
	
	@Test(enabled = true)
	public void verifyAuthScreen() throws Exception
	{
	  System.out.println("E2E03_Verify_User_able_to_click_About_Us Execution Started:");
	  new PreLoginPage(driver, test)
	  	.clickAboutUsTab();
		System.out.println("E2E03_Verify_User_able_to_click_About_Us Executed sucessfully");
	}
}
