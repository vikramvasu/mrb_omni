package testcases.ib.transfers.ownAccount;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.internetBanking.FundTransferPage;

public class E2E02_Verify_User_able_to_Transfer_to_Own_Account_Using_Later_option extends wrappers.ProjectWrappers{
	
	public E2E02_Verify_User_able_to_Transfer_to_Own_Account_Using_Later_option() throws IOException {
	}
	
	@BeforeClass
	public void setData() {
		TestCaseName="E2E02_Verify_User_able_to_Transfer_to_Own_Account_Using_Later_option";
		TestDescription="E2E02_Verify_User_able_to_Transfer_to_Own_Account_Using_Later_option";
		browserName="chrome";
		Application="Mobeix Retail Banking - IB";
		Authors="Automation Team";
	}
	
	@Test(enabled = true)
	public void verifyAuthScreen() throws Exception
	{
	  System.out.println("E2E02_Verify_User_able_to_Transfer_to_Own_Account_Using_Later_option Execution Started:");
	  new FundTransferPage(driver, test)
	  	.loginUsingSMS()
	  	.verifyDashboardTitle()
	  	.clickTransfersTab()
	  	.selectTransferType("local")
	  	.clickTransfersFrom()
	  	.clickOwnBankTransfersTo()
	  	.selectPaymentCurrency("INR")
	  	.enterPaymentAmount()
	  	.clickPaymentWhen("Later")
	  	.selectLaterPaymentDate("29", "Apr", "2021")
	  	.clickNextBtn()
	  	.clickConfirmBtn()
	  	.verifyFundTransferSuccessMessage();
		System.out.println("E2E02_Verify_User_able_to_Transfer_to_Own_Account_Using_Later_option Executed sucessfully");
	}
}
