package testcases.admin.customerManagement;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.admin.CustomerManagementPage;

public class E2E02_Verify_User_able_to_Activate_and_Approve_User_Successfully_in_Admin extends wrappers.ProjectWrappers{
	
	public E2E02_Verify_User_able_to_Activate_and_Approve_User_Successfully_in_Admin() throws IOException {
	}
	
	@BeforeClass
	public void setData() {
		TestCaseName="E2E02_Verify_User_able_to_Activate_and_Approve_User_Successfully_in_Admin";
		TestDescription="E2E02_Verify_User_able_to_Activate_and_Approve_User_Successfully_in_Admin";
		browserName="chrome";
		Application="Mobeix Retail Banking - Admin";
		Authors="Automation Team";
	}
	
	@Test(enabled = true, priority = 1)
	public void verifyActivateScreen() throws Exception
	{
	  System.out.println("E2E02_Verify_User_able_to_Activate_User_Successfully_in_Admin Execution Started:");
	  TestCaseName="E2E02_Verify_User_able_to_Activate_User_Successfully_in_Admin";
	  new CustomerManagementPage(driver, test)
	  	.loginMaker()
	  	.clickApplicationMenu()
	  	.clickRetailBankingIcon()
	  	.clickRetailAdminMenu()
	  	.clickCustomerManagementMenu()
	  	.clickMakerActivateActionButton()
	  	.clickActivateMenu()
	  	.clickYesButton()
	  	.SuccessMessage()
	  	.getReferenceNumber()
	  	.clickOkButton()
	  	.clickProfileButton()
	  	.userLogOut();
	  System.out.println("E2E02_Verify_User_able_to_Activate_User_Successfully_in_Admin Executed sucessfully");
	}  	
	
	@Test(enabled = true, priority = 2)
	public void verifyActivateApproveScreen() throws Exception
	{
		System.out.println("E2E02_Verify_User_able_to_Approve_Activate_User_Successfully_in_Admin Executed sucessfully");
		TestCaseName="E2E02_Verify_User_able_to_Approve_Activate_User_Successfully_in_Admin";
		new CustomerManagementPage(driver, test)
	  	.loginChecker()
	  	.clickApplicationMenu()
	  	.clickRetailBankingIcon()
	  	.clickRetailAdminMenu()
	  	.clickWorkflowManagementMenu()
	  	.clickCheckerActivateActionButton()
	  	.clickApproveMenu()
	  	.clickApproveButton()
	  	.SuccessMessage()
	  	.clickProfileButton()
	  	.userLogOut();
		System.out.println("E2E02_Verify_User_able_to_Approve_Activate_User_Successfully_in_Admin Executed sucessfully");
	}
}
