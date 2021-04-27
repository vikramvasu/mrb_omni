package testcases.ib.transfers.managePayees;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.internetBanking.PayeePage;

public class E2E14_Verify_User_able_to_Select_Bank_and_Branch_for_Local extends wrappers.ProjectWrappers{
	
	public E2E14_Verify_User_able_to_Select_Bank_and_Branch_for_Local() throws IOException {
	}
	
	@BeforeClass
	public void setData() {
		TestCaseName="E2E14_Verify_User_able_to_Select_Bank_and_Branch_for_Local";
		TestDescription="E2E14_Verify_User_able_to_Select_Bank_and_Branch_for_Local";
		browserName="chrome";
		Application="Mobeix Retail Banking - IB";
		Authors="Automation Team";
	}
	 
	@Test(enabled = true)
	public void verifyAuthScreen() throws Exception
	{
	  System.out.println("E2E14_Verify_User_able_to_Select_Bank_and_Branch_for_Local Execution Started:");
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
	  	.selectBankAndBranch()
	  	.clickOKbtn()
	  	.userLogOut();
		System.out.println("E2E14_Verify_User_able_to_Select_Bank_and_Branch_for_Local Executed sucessfully");
	}
}
