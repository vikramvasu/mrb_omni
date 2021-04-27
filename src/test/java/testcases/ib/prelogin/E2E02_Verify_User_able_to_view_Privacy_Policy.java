package testcases.ib.prelogin;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.internetBanking.PreLoginPage;

public class E2E02_Verify_User_able_to_view_Privacy_Policy extends wrappers.ProjectWrappers{
	
	public E2E02_Verify_User_able_to_view_Privacy_Policy() throws IOException {
	}
	
	@BeforeClass
	public void setData() {
		TestCaseName="E2E02_Verify_User_able_to_view_Privacy_Policy";
		TestDescription="E2E02_Verify_User_able_to_view_Privacy_Policy";
		browserName="chrome";
		Application="Mobeix Retail Banking - IB";
		Authors="Automation Team";
	}
	
	@Test(enabled = true)
	public void verifyAuthScreen() throws Exception
	{
	  System.out.println("E2E02_Verify_User_able_to_view_Privacy_Policy Execution Started:");
	  new PreLoginPage(driver, test)
	  	.clickSecurityAndPrivacyLink();
		System.out.println("E2E02_Verify_User_able_to_view_Privacy_Policy Executed sucessfully");
	}
}
