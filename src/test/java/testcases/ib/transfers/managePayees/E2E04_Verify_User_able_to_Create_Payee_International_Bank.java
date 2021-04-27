package testcases.ib.transfers.managePayees;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.internetBanking.PayeePage;

public class E2E04_Verify_User_able_to_Create_Payee_International_Bank extends wrappers.ProjectWrappers{
	
	public E2E04_Verify_User_able_to_Create_Payee_International_Bank() throws IOException {
	}
	
	@BeforeClass
	public void setData() {
		TestCaseName="E2E04_Verify_User_able_to_Create_Payee_International_Bank";
		TestDescription="E2E04_Verify_User_able_to_Create_Payee_International_Bank";
		browserName="chrome";
		Application="Mobeix Retail Banking - IB";
		Authors="Automation Team";
	}
	 
	@Test(enabled = true)
	public void verifyAuthScreen() throws Exception
	{
	  System.out.println("E2E04_Verify_User_able_to_Create_Payee_International_Bank Execution Started:");
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
	  	.clickInternationalPayee()
	  	.enterInternationalBankPayeeName()
	  	.enterInternationalBankAccountNumber()
	  	.reenterInternationalBankAccountNumber()
	  	.enterIntAddress1("Shollinganallur")
	  	.enterIntAddress2("Chennai")
	  	.selectIntCountry("India")
	  	.selectIntMobileNumber("+91", "9876543210")
	  	.selectInternationalPayeeBank()
	  	.clickOKbtn()
	  	.enterInternationalBankPayeeNickName()
	  	.clickNextBtn()
	  	.clickConfirmBtn()
	  	.enterSMSOTP()
	  	.clickSubmitBtn2FAPage()
	  	.verifyPayeeSuccessMessage()
//	  	.clickAnotherPayeeButton()
//	  	.clickNewTransferButton()
	  	.userLogOut();
		System.out.println("E2E04_Verify_User_able_to_Create_Payee_International_Bank Executed sucessfully");
	}
}
