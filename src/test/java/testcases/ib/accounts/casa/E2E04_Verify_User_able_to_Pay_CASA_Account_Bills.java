package testcases.ib.accounts.casa;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.internetBanking.AccountsPage;

public class E2E04_Verify_User_able_to_Pay_CASA_Account_Bills extends wrappers.ProjectWrappers{
	
	public E2E04_Verify_User_able_to_Pay_CASA_Account_Bills() throws IOException {
	}
	
	@BeforeClass
	public void setData() {
		TestCaseName="E2E04_Verify_User_able_to_Pay_CASA_Account_Bills";
		TestDescription="E2E04_Verify_User_able_to_Pay_CASA_Account_Bills";
		browserName="chrome";
		Application="Mobeix Retail Banking - IB";
		Authors="Automation Team";
	}
	
	@Test(enabled = true)
	public void verifyAuthScreen() throws Exception
	{
	  System.out.println("E2E04_Verify_User_able_to_Pay_CASA_Account_Bills Execution Started:");
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
	  	.clickPayBills()
	  	.searchPayBill()
	  	.verifyPayBillPageElements()
	  	.clickPayLink()
	  	.verifyPayBillDetails()
	  	.selectCurrency()
	  	.clickNowBtn()
	  	.clickConfirmAndPayBtn()
//	  	.clickEnableAutopayLink()
	  	.verifyPayBillSuccessMessage()
	  	.userLogOut();
		System.out.println("E2E04_Verify_User_able_to_Pay_CASA_Account_Bills Executed sucessfully");
	}
}
