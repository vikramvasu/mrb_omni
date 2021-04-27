package testcases.ib.prelogin;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.internetBanking.PreLoginPage;

public class E2E10_Verify_User_able_to_View_Locate_Us_Branch extends wrappers.ProjectWrappers{
	
	public E2E10_Verify_User_able_to_View_Locate_Us_Branch() throws IOException {
	}
	
	@BeforeClass
	public void setData() {
		TestCaseName="E2E10_Verify_User_able_to_View_Locate_Us_Branch";
		TestDescription="E2E10_Verify_User_able_to_View_Locate_Us_Branch";
		browserName="chrome";
		Application="Mobeix Retail Banking - IB";
		Authors="Automation Team";
	}
	
	@Test(enabled = true)
	public void verifyAuthScreen() throws Exception
	{
	  System.out.println("E2E10_Verify_User_able_to_View_Locate_Us_Branch Execution Started:");
	  new PreLoginPage(driver, test)
	  	.clickLocateUsTab()
	  	.selectLocateUsCategory("BRANCH")
	  	.enterSearchLocation();
		System.out.println("E2E10_Verify_User_able_to_View_Locate_Us_Branch Executed sucessfully");
	}
}
