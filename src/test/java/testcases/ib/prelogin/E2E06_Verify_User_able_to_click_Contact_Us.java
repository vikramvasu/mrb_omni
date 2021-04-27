package testcases.ib.prelogin;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.internetBanking.PreLoginPage;

public class E2E06_Verify_User_able_to_click_Contact_Us extends wrappers.ProjectWrappers{
	
	public E2E06_Verify_User_able_to_click_Contact_Us() throws IOException {
	}
	
	@BeforeClass
	public void setData() {
		TestCaseName="E2E06_Verify_User_able_to_click_Contact_Us";
		TestDescription="E2E06_Verify_User_able_to_click_Contact_Us";
		browserName="chrome";
		Application="Mobeix Retail Banking - IB";
		Authors="Automation Team";
	}
	
	@Test(enabled = true)
	public void verifyAuthScreen() throws Exception
	{
	  System.out.println("E2E06_Verify_User_able_to_click_Contact_Us Execution Started:");
	  new PreLoginPage(driver, test)
	  	.clickContactUsTab();
		System.out.println("E2E06_Verify_User_able_to_click_Contact_Us Executed sucessfully");
	}
}
