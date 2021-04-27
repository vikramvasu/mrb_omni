package testcases.ib.transfers.ownAccount;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.internetBanking.FundTransferPage;

public class E2E04_Verify_User_able_to_Transfer_to_Own_Account_Using_Same_Currency extends wrappers.ProjectWrappers{
	
	public E2E04_Verify_User_able_to_Transfer_to_Own_Account_Using_Same_Currency() throws IOException {
	}
	
	@BeforeClass
	public void setData() {
		TestCaseName="E2E04_Verify_User_able_to_Transfer_to_Own_Account_Using_Same_Currency";
		TestDescription="E2E04_Verify_User_able_to_Transfer_to_Own_Account_Using_Same_Currency";
		browserName="chrome";
		Application="Mobeix Retail Banking - IB";
		Authors="Automation Team";
	}
	
	@Test(enabled = true)
	public void verifyAuthScreen() throws Exception
	{
	  System.out.println("E2E04_Verify_User_able_to_Transfer_to_Own_Account_Using_Same_Currency Execution Started:");
	  new FundTransferPage(driver, test)
	  	.loginUsingSMS()
	  	.verifyDashboardTitle()
	  	.clickTransfersTab()
	  	.selectTransferType("local")
	  	.clickTransfersFrom()
	  	.clickOwnBankTransfersTo()
	  	.selectPaymentCurrency("INR")
	  	.enterPaymentAmount()
	  	.clickPaymentWhen("Now")
	  	.clickNextBtn()
	  	.clickConfirmBtn()
	  	.verifyFundTransferSuccessMessage();
		System.out.println("E2E04_Verify_User_able_to_Transfer_to_Own_Account_Using_Same_Currency Executed sucessfully");
	}
}
