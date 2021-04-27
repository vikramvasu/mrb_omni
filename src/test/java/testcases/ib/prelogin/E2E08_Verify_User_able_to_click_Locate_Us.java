package testcases.ib.prelogin;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.internetBanking.PreLoginPage;

public class E2E08_Verify_User_able_to_click_Locate_Us extends wrappers.ProjectWrappers{
	
	public E2E08_Verify_User_able_to_click_Locate_Us() throws IOException {
	}
	
	@BeforeClass
	public void setData() {
		TestCaseName="E2E08_Verify_User_able_to_click_Locate_Us";
		TestDescription="E2E08_Verify_User_able_to_click_Locate_Us";
		browserName="chrome";
		Application="Mobeix Retail Banking - IB";
		Authors="Automation Team";
	}
	
	@Test(enabled = true)
	public void verifyAuthScreen() throws Exception
	{
	  System.out.println("E2E08_Verify_User_able_to_click_Locate_Us Execution Started:");
	  new PreLoginPage(driver, test)
	  	.clickLocateUsTab();
		System.out.println("E2E08_Verify_User_able_to_click_Locate_Us Executed sucessfully");
	}
}
