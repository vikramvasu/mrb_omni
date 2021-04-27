package testcases.ib.transfers.managePayees;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.internetBanking.PayeePage;

public class E2E07_Verify_User_able_to_View_International_Payee extends wrappers.ProjectWrappers{
	
	public E2E07_Verify_User_able_to_View_International_Payee() throws IOException {
	}
	
	@BeforeClass
	public void setData() {
		TestCaseName="E2E07_Verify_User_able_to_View_International_Payee";
		TestDescription="E2E07_Verify_User_able_to_View_International_Payee";
		browserName="chrome";
		Application="Mobeix Retail Banking - IB";
		Authors="Automation Team";
	}
	 
	@Test(enabled = true)
	public void verifyAuthScreen() throws Exception
	{
	  System.out.println("E2E07_Verify_User_able_to_View_International_Payee Execution Started:");
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
//	  	.verifyManagePayeeHeading()
	  	.searchInternationalBankPayee()
	  	.clickPayeeViewLink()
	  	.verifyInternationalBankPayeeDetails()
	  	.clickBackButton()
	  	.userLogOut();
		System.out.println("E2E07_Verify_User_able_to_View_International_Payee Executed sucessfully");
	}
}
