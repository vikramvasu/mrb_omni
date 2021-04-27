package testcases.ib.accounts.casa;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.internetBanking.AccountsPage;

public class E2E05_Verify_User_able_to_Transfer_CASA_Account_Funds extends wrappers.ProjectWrappers{
	
	public E2E05_Verify_User_able_to_Transfer_CASA_Account_Funds() throws IOException {
	}
	
	@BeforeClass
	public void setData() {
		TestCaseName="E2E05_Verify_User_able_to_Transfer_CASA_Account_Funds";
		TestDescription="E2E05_Verify_User_able_to_Transfer_CASA_Account_Funds";
		browserName="chrome";
		Application="Mobeix Retail Banking - IB";
		Authors="Automation Team";
	}
	
	@Test(enabled = true)
	public void verifyAuthScreen() throws Exception
	{
	  System.out.println("E2E05_Verify_User_able_to_Transfer_CASA_Account_Funds Execution Started:");
	  new AccountsPage(driver, test)
	  	.enterUserName()
	  	.enterPassword()
	  	.takeMeDirectlyTo("Dashboard")
	  	.clickSignInBtn()
	  	.select2FAType("SMS OTP")
	  	.enterSMSOTP()
	  	.clickSubmitBtn2FAPage()
//	  	.verifyDashboardTitle()
	  	.clickAccountsTab()
	  	.verifyAccountOverviewHeading()
//	  	.verifyAccountOverviewPageElements()
//	  	.verifyAccountSummary()
	  	.clickTransfer()
	  	.clickTransfersFrom()
	  	.enterPayeeName()
	  	.enterPayeeActNum()
	  	.reenterPayeeActNum()
	  	.selectBankAndBranch()
	  	.selectPaymentCurrency("USD")
	  	.enterPaymentAmount()
	  	.clickPaymentWhen("Now")
	  	.clickNextBtn()
	  	.clickConfirmAndTransferBtn()
	  	.enterSMSOTP()
	  	.clickSubmitBtn2FAPage()
	  	.verifyTransferSuccessMessage()
//	  	.clickSavePayeeBtn()
//	  	.clickNewTransfersBtn()
	  	.userLogOut();
		System.out.println("E2E05_Verify_User_able_to_Transfer_CASA_Account_Funds Executed sucessfully");
	}
}
