package testcases.ib.transfers.managePayees;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.internetBanking.PayeePage;

public class E2E02_Verify_User_able_to_Create_Payee_Same_Bank extends wrappers.ProjectWrappers{
	
	public E2E02_Verify_User_able_to_Create_Payee_Same_Bank() throws IOException {
	}
	
	@BeforeClass
	public void setData() {
		TestCaseName="E2E02_Verify_User_able_to_Create_Payee_Same_Bank";
		TestDescription="E2E02_Verify_User_able_to_Create_Payee_Same_Bank";
		browserName="chrome";
		Application="Mobeix Retail Banking - IB";
		Authors="Automation Team";
	}
	 
	@Test(enabled = true)
	public void verifyAuthScreen() throws Exception
	{
	  System.out.println("E2E02_Verify_User_able_to_Create_Payee_Same_Bank Execution Started:");
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
	  	.clickNewPayeeButton()
	  	.clickSameBankPayee()
	  	.enterSameBankAccountNumber()
	  	.enterSameBankPayeeNickName()
	  	.clickNextBtn()
	  	.clickConfirmBtn()
	  	.enterSMSOTP()
	  	.clickSubmitBtn2FAPage()
	  	.verifyPayeeSuccessMessage()
//	  	.clickAnotherPayeeButton()
//	  	.clickNewTransferButton()
	  	.userLogOut();
		System.out.println("E2E02_Verify_User_able_to_Create_Payee_Same_Bank Executed sucessfully");
	}
}
