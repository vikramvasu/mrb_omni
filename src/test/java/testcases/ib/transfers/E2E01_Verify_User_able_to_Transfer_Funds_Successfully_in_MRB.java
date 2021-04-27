package testcases.ib.transfers;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.internetBanking.FundTransferPage;

public class E2E01_Verify_User_able_to_Transfer_Funds_Successfully_in_MRB extends wrappers.ProjectWrappers{
	
	public E2E01_Verify_User_able_to_Transfer_Funds_Successfully_in_MRB() throws IOException {
	}
	
	@BeforeClass
	public void setData() {
		TestCaseName="E2E01_Verify_User_able_to_Transfer_Funds_Successfully_in_MRB";
		TestDescription="E2E01_Verify_User_able_to_Transfer_Funds_Successfully_in_MRB";
		browserName="chrome";
		Application="Mobeix Retail Banking - IB";
		Authors="Automation Team";
	}
	
	@Test(enabled = true)
	public void verifyAuthScreen() throws Exception
	{
	  System.out.println("E2E01_Verify_User_able_to_Transfer_Funds_Successfully_in_MRB Execution Started:");
	  new FundTransferPage(driver, test)
	  	.loginUsingSMS()
	  	.verifyDashboardTitle()
	  	.clickTransfersTab()
	  	.selectTransferType("local")
	  	.clickTransfersFrom()
	  	.clickTransfersTo()
	  	.selectPaymentCurrency("INR")
	  	.enterPaymentAmount()
	  	.clickPaymentWhen("Now")
	  	.clickNextBtn()
	  	.clickConfirmBtn()
	  	.verifyFundTransferSuccessMessage();
		System.out.println("E2E01_Verify_User_able_to_Transfer_Funds_Successfully_in_MRB Executed sucessfully");
	}
}
