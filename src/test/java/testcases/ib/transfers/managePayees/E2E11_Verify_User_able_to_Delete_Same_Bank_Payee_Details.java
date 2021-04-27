package testcases.ib.transfers.managePayees;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.internetBanking.PayeePage;

public class E2E11_Verify_User_able_to_Delete_Same_Bank_Payee_Details extends wrappers.ProjectWrappers{
	
	public E2E11_Verify_User_able_to_Delete_Same_Bank_Payee_Details() throws IOException {
	}
	
	@BeforeClass
	public void setData() {
		TestCaseName="E2E11_Verify_User_able_to_Delete_Same_Bank_Payee_Details";
		TestDescription="E2E11_Verify_User_able_to_Delete_Same_Bank_Payee_Details";
		browserName="chrome";
		Application="Mobeix Retail Banking - IB";
		Authors="Automation Team";
	}
	 
	@Test(enabled = true)
	public void verifyAuthScreen() throws Exception
	{
	  System.out.println("E2E11_Verify_User_able_to_Delete_Same_Bank_Payee_Details Execution Started:");
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
	  	.searchSameBankPayee()
	  	.clickDeleteLink()
	  	.clickDeletePayeeButton()
	  	.enterSMSOTP()
	  	.clickSubmitBtn2FAPage()
	  	.verifyPayeeDeleteSuccessMessage()
	  	.userLogOut();
		System.out.println("E2E11_Verify_User_able_to_Delete_Same_Bank_Payee_Details Executed sucessfully");
	}
}
