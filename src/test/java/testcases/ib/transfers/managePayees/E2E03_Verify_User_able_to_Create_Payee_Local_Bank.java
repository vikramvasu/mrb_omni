package testcases.ib.transfers.managePayees;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.internetBanking.PayeePage;

public class E2E03_Verify_User_able_to_Create_Payee_Local_Bank extends wrappers.ProjectWrappers{
	
	public E2E03_Verify_User_able_to_Create_Payee_Local_Bank() throws IOException {
	}
	
	@BeforeClass
	public void setData() {
		TestCaseName="E2E03_Verify_User_able_to_Create_Payee_Local_Bank";
		TestDescription="E2E03_Verify_User_able_to_Create_Payee_Local_Bank";
		browserName="chrome";
		Application="Mobeix Retail Banking - IB";
		Authors="Automation Team";
	}
	 
	@Test(enabled = true)
	public void verifyAuthScreen() throws Exception
	{
	  System.out.println("E2E03_Verify_User_able_to_Create_Payee_Local_Bank Execution Started:");
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
	  	.clickLocalBankPayee()
	  	.enterLocalBankPayeeName()
	  	.enterLocalBankAccountNumber()
	  	.reenterLocalBankAccountNumber()
	  	.selectLocalPayeeBank()
	  	.clickOKbtn()
	  	.enterLocalBankPayeeNickName()
	  	.clickNextBtn()
	  	.clickConfirmBtn()
	  	.enterSMSOTP()
	  	.clickSubmitBtn2FAPage()
	  	.verifyPayeeSuccessMessage()
//	  	.clickAnotherPayeeButton()
//	  	.clickNewTransferButton()
	  	.userLogOut();
		System.out.println("E2E03_Verify_User_able_to_Create_Payee_Local_Bank Executed sucessfully");
	}
}
