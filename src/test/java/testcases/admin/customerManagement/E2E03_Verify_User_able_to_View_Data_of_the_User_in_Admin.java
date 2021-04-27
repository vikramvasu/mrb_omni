package testcases.admin.customerManagement;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.admin.CustomerManagementPage;

public class E2E03_Verify_User_able_to_View_Data_of_the_User_in_Admin extends wrappers.ProjectWrappers{
	
	public E2E03_Verify_User_able_to_View_Data_of_the_User_in_Admin() throws IOException {
	}
	
	@BeforeClass
	public void setData() {
		TestCaseName="E2E03_Verify_User_able_to_View_Data_of_the_User_in_Admin";
		TestDescription="E2E03_Verify_User_able_to_View_Data_of_the_User_in_Admin";
		browserName="chrome";
		Application="Mobeix Retail Banking - Admin";
		Authors="Automation Team";
	}
	
	@Test(enabled = true, priority = 1)
	public void verifySuspendScreen() throws Exception
	{
	  System.out.println("E2E03_Verify_User_able_to_View_Data_of_the_User_in_Admin Execution Started:");
	  new CustomerManagementPage(driver, test)
	  	.loginMaker()
	  	.clickApplicationMenu()
	  	.clickRetailBankingIcon()
	  	.clickRetailAdminMenu()
	  	.clickCustomerManagementMenu()
	  	.clickCIFNumberLink()
	  	.verifyCustomerMngmntUserDetails()
	  	.clickBackBtn();
//	  	.clickProfileButton()
//	  	.userLogOut();
	  System.out.println("E2E03_Verify_User_able_to_View_Data_of_the_User_in_Admin Executed sucessfully");
	}  
}
