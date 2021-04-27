package testcases.ib.transfers.managePayees;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.internetBanking.PayeePage;

public class E2E01_Verify_User_able_to_access_Manage_Payees extends wrappers.ProjectWrappers{
	
	public E2E01_Verify_User_able_to_access_Manage_Payees() throws IOException {
	}
	
	@BeforeClass
	public void setData() {
		TestCaseName="E2E01_Verify_User_able_to_access_Manage_Payees";
		TestDescription="E2E01_Verify_User_able_to_access_Manage_Payees";
		browserName="chrome";
		Application="Mobeix Retail Banking - IB";
		Authors="Automation Team";
	}
	
	@Test(enabled = true)
	public void verifyAuthScreen() throws Exception
	{
	  System.out.println("E2E01_Verify_User_able_to_access_Manage_Payees Execution Started:");
	  new PayeePage(driver, test)
	  	.enterUserName()
	  	.enterPassword()
	  	.takeMeDirectlyTo("Dashboard")
	  	.clickSignInBtn()
	  	.select2FAType("SMS OTP")
	  	.enterSMSOTP()
	  	.clickSubmitBtn2FAPage()
//	  	.verifyDashboardTitle()
	  	.clickTransfersTab()
	  	.clickTransfersArrow()
	  	.selectManagePayee()
	  	.verifyManagePayeeHeading()
	  	.userLogOut();
		System.out.println("E2E01_Verify_User_able_to_access_Manage_Payees Executed sucessfully");
	}
}
