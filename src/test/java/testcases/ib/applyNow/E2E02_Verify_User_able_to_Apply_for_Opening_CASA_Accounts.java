package testcases.ib.applyNow;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.internetBanking.ApplyNowPage;

public class E2E02_Verify_User_able_to_Apply_for_Opening_CASA_Accounts extends wrappers.ProjectWrappers{
	
	public E2E02_Verify_User_able_to_Apply_for_Opening_CASA_Accounts() throws IOException {
	}
	
	@BeforeClass
	public void setData() {
		TestCaseName="E2E02_Verify_User_able_to_Apply_for_Opening_CASA_Accounts";
		TestDescription="E2E02_Verify_User_able_to_Apply_for_Opening_CASA_Accounts";
		browserName="chrome";
		Application="Mobeix Retail Banking - IB";
		Authors="Automation Team";
	}
	
	@Test(enabled = true)
	public void verifyAuthScreen() throws Exception
	{
	  System.out.println("E2E02_Verify_User_able_to_Apply_for_Opening_CASA_Accounts Execution Started:");
	  new ApplyNowPage(driver, test)
	  	.enterUserName()
	  	.enterPassword()
	  	.takeMeDirectlyTo("Dashboard")
	  	.clickSignInBtn()
	  	.select2FAType("SMS OTP")
	  	.enterSMSOTP()
	  	.clickSubmitBtn2FAPage()
	  	.verifyDashboardTitle()
	  	.clickApplyNowArrow()
	  	.clickOpenCASAAccountMenu()
	  	.clickApplyNowBtn()
	  	.selectCountryCode("+91")
	  	.enterContactNumber()
	  	.clickSubmitBtn()
	  	.clickConfirmBtn()
	  	.enterSMSOTP()
	  	.clickSubmitButton()
	  	.verifyCASASuccessMessage();
		System.out.println("E2E02_Verify_User_able_to_Apply_for_Opening_CASA_Accounts Executed sucessfully");
	}
}
