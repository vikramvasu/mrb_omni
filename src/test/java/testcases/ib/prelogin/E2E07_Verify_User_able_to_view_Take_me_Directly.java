package testcases.ib.prelogin;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.internetBanking.PreLoginPage;

public class E2E07_Verify_User_able_to_view_Take_me_Directly extends wrappers.ProjectWrappers{
	
	public E2E07_Verify_User_able_to_view_Take_me_Directly() throws IOException {
	}
	
	@BeforeClass
	public void setData() {
		TestCaseName="E2E07_Verify_User_able_to_view_Take_me_Directly";
		TestDescription="E2E07_Verify_User_able_to_view_Take_me_Directly";
		browserName="chrome";
		Application="Mobeix Retail Banking - IB";
		Authors="Automation Team";
	}
	
	@Test(enabled = true)
	public void verifyAuthScreen() throws Exception
	{
	  System.out.println("E2E07_Verify_User_able_to_view_Take_me_Directly Execution Started:");
	  new PreLoginPage(driver, test)
	  	.verifyTakeMeDirectlyToHeading();
		System.out.println("E2E07_Verify_User_able_to_view_Take_me_Directly Executed sucessfully");
	}
}
