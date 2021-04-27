package testcases.ib.applyNow;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.internetBanking.ApplyNowPage;

public class E2E01_Verify_User_able_to_Apply_for_Opening_Fixed_Deposit extends wrappers.ProjectWrappers{
	
	public E2E01_Verify_User_able_to_Apply_for_Opening_Fixed_Deposit() throws IOException {
	}
	
	@BeforeClass
	public void setData() {
		TestCaseName="E2E01_Verify_User_able_to_Apply_for_Opening_Fixed_Deposit";
		TestDescription="E2E01_Verify_User_able_to_Apply_for_Opening_Fixed_Deposit";
		browserName="chrome";
		Application="Mobeix Retail Banking - IB";
		Authors="Automation Team";
	}
	
	@Test(enabled = true)
	public void verifyAuthScreen() throws Exception
	{
	  System.out.println("E2E01_Verify_User_able_to_Apply_for_Opening_Fixed_Deposit Execution Started:");
	  new ApplyNowPage(driver, test)
	  	.enterUserName()
	  	.enterPassword()
	  	.takeMeDirectlyTo("Dashboard")
	  	.clickSignInBtn()
	  	.select2FAType("SMS OTP")
	  	.enterSMSOTP()
	  	.clickSubmitBtn2FAPage()
	  	.verifyDashboardTitle()
	  	.clickApplyNowArrow()
	  	.clickOpenFixedDepositMenu()
	  	.clickApplyNowBtn()
	  	.selectDebitAccount()
	  	.enterDebitAmount()
	  	.selectPaymentDate("20", "Apr", "2021")
	  	.selectTenure()
	  	.selectCreditAccount()
	  	.selectMaturityOptions()
	  	.clickNextBtn()
	  	.clickConfirmBtn()
	  	.enterSMSOTP()
	  	.clickSubmitBtn2FAPage()
	  	.verifyFixedDepositSuccessMessage();
		System.out.println("E2E01_Verify_User_able_to_Apply_for_Opening_Fixed_Deposit Executed sucessfully");
	}
}
