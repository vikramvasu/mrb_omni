package testcases.ib.prelogin;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.internetBanking.PreLoginPage;

public class E2E09_Verify_User_able_to_View_Locate_Us_ATM extends wrappers.ProjectWrappers{
	
	public E2E09_Verify_User_able_to_View_Locate_Us_ATM() throws IOException {
	}
	
	@BeforeClass
	public void setData() {
		TestCaseName="E2E09_Verify_User_able_to_View_Locate_Us_ATM";
		TestDescription="E2E09_Verify_User_able_to_View_Locate_Us_ATM";
		browserName="chrome";
		Application="Mobeix Retail Banking - IB";
		Authors="Automation Team";
	}
	
	@Test(enabled = true)
	public void verifyAuthScreen() throws Exception
	{
	  System.out.println("E2E09_Verify_User_able_to_View_Locate_Us_ATM Execution Started:");
	  new PreLoginPage(driver, test)
	  	.clickLocateUsTab()
	  	.selectLocateUsCategory("ATM")
	  	.enterSearchLocation();
		System.out.println("E2E09_Verify_User_able_to_View_Locate_Us_ATM Executed sucessfully");
	}
}
