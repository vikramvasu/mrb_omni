package testcases.ib.transfers.ownAccount;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.internetBanking.FundTransferPage;

public class E2E03_Verify_User_able_to_Transfer_to_Own_Account_Using_Recurring_option extends wrappers.ProjectWrappers{
	
	public E2E03_Verify_User_able_to_Transfer_to_Own_Account_Using_Recurring_option() throws IOException {
	}
	
	@BeforeClass
	public void setData() {
		TestCaseName="E2E03_Verify_User_able_to_Transfer_to_Own_Account_Using_Recurring_option";
		TestDescription="E2E03_Verify_User_able_to_Transfer_to_Own_Account_Using_Recurring_option";
		browserName="chrome";
		Application="Mobeix Retail Banking - IB";
		Authors="Automation Team";
	}
	
	@Test(enabled = true)
	public void verifyAuthScreen() throws Exception
	{
	  System.out.println("E2E03_Verify_User_able_to_Transfer_to_Own_Account_Using_Recurring_option Execution Started:");
	  new FundTransferPage(driver, test)
	  	.loginUsingSMS()
	  	.verifyDashboardTitle()
	  	.clickTransfersTab()
	  	.selectTransferType("local")
	  	.clickTransfersFrom()
	  	.clickOwnBankTransfersTo()
	  	.selectPaymentCurrency("INR")
	  	.enterPaymentAmount()
	  	.clickPaymentWhen("Recurring")
	  	.selectRecurringPaymentDate("29", "Apr", "2021")
	  	.clickPaymentFrequency()
	  	.selectPaymentFrequencyTime("onetime")
	  	.enterPaymentInstallments()
	  	.clickNextBtn()
	  	.clickConfirmBtn()
	  	.verifyFundTransferSuccessMessage();
		System.out.println("E2E03_Verify_User_able_to_Transfer_to_Own_Account_Using_Recurring_option Executed sucessfully");
	}
}
