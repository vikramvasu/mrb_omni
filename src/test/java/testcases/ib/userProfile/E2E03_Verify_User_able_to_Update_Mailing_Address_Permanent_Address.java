package testcases.ib.userProfile;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.internetBanking.ProfilePage;

public class E2E03_Verify_User_able_to_Update_Mailing_Address_Permanent_Address extends wrappers.ProjectWrappers{
	
	public E2E03_Verify_User_able_to_Update_Mailing_Address_Permanent_Address() throws IOException {
	}
	
	@BeforeClass
	public void setData() {
		TestCaseName="E2E03_Verify_User_able_to_Update_Mailing_Address_Permanent_Address";
		TestDescription="E2E03_Verify_User_able_to_Update_Mailing_Address_Permanent_Address";
		browserName="chrome";
		Application="Mobeix Retail Banking - IB";
		Authors="Automation Team";
	}
	
	@Test(enabled = true)
	public void verifyAuthScreen() throws Exception
	{
	  System.out.println("E2E03_Verify_User_able_to_Update_Mailing_Address_Permanent_Address Execution Started:");
	  new ProfilePage(driver, test)
	  	.enterUserName()
	  	.enterPassword()
	  	.takeMeDirectlyTo("Dashboard")
	  	.clickSignInBtn()
	  	.select2FAType("SMS OTP")
	  	.enterSMSOTP()
	  	.clickSubmitBtn2FAPage()
	  	.verifyDashboardTitle()
	  	.clickProfileArrow()
	  	.clickProfile()
	  	.clickUpdateMailingAddressButton()
	  	.clickMailingAddressSameChkbx()
	  	.clickNextBtn()
	  	.clickConfirmBtn()
	  	.enterSMSOTP()
	  	.clickSubmitBtn2FAPage()
	  	.verifyAddressUpdatedSuccessMessage();
		System.out.println("E2E03_Verify_User_able_to_Update_Mailing_Address_Permanent_Address Executed sucessfully");
	}
}
