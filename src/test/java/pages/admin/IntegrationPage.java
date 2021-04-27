package pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

public class IntegrationPage extends wrappers.ProjectWrappers  {
	
	public static String reference;
		
	public IntegrationPage(RemoteWebDriver driver, ExtentTest test)throws Exception{
		this.driver = driver;
		this.test = test;
		openQAAdminApplication();
	}
	
	public IntegrationPage loginMaker() throws InterruptedException {
		enterUserName("qamaker123")
	  	.enterPassword()
	  	.clickSignInBtn();
		return this;
	}
	
	public IntegrationPage loginChecker() throws InterruptedException {
		enterUserName("qachecker123")
	  	.enterPassword()
	  	.clickSignInBtn();
		return this;
	}
		
	public IntegrationPage enterUserName(String userName) throws InterruptedException{
		System.out.println("Enter the User Name");
		Thread.sleep(3000);
		enterByXpath("//input[@formcontrolname='userId']", userName);
		return this;
	}
	
	public IntegrationPage enterPassword(){
		System.out.println("Enter the Password");
		enterByXpath("//input[@formcontrolname='password']", "Password@12");
		return this;
	}
	
	public IntegrationPage clickSignInBtn()
	{
		System.out.println("Click Sign In button");
		clickByXpath("//button/span[contains(text(),'Sign in')]");
//		clickByXpath("//button[@type='submit']");
		return this;
	}
	
	public IntegrationPage verifyMobeixAdminHeader()
	{
		System.out.println("Verify Mobeix Admin Header");
		verifyElementisPresent("//header//h1[contains(text(),'Mobeix')]", "Mobeix Admin Header");
		return this;
	}
	 
	public IntegrationPage clickApplicationMenu()
	{
		System.out.println("Click Application Menu");
		clickByXpath("//li[@aria-label='Applications']");
		return this;
	}
	
	public IntegrationPage clickRetailBankingIcon() throws InterruptedException
	{
		System.out.println("Click Retail Banking Icon");
		Thread.sleep(2000);
		clickByXpath("//span[contains(text(),'MobeixRetailBanking')]");
		return this;
	}
	
	public IntegrationPage clickIntegrationMenu()
	{
		System.out.println("Click Integration Menu");
		clickByXpath("//li[@aria-label='Integration']");
		return this;
	}
	
	public IntegrationPage verifyIntegrationSubMenus()
	{
		System.out.println("Verify Integration Sub Menus");
		verifyElementisPresent("//span[contains(text(),'Workflows') and starts-with(@class,'mx-ac')]", "Workflows Menu");
		verifyElementisPresent("//span[contains(text(),'Deep Linking') and starts-with(@class,'mx-ac')]", "Deep Linking Menu");
		return this;
	}
	
	//Workflows flow
	public IntegrationPage clickWorkflowsMenu() throws InterruptedException
	{
		System.out.println("Click Workflows Menu");
		Thread.sleep(3000);
		clickByXpath("//span[contains(text(),'Workflows') and starts-with(@class,'mx-ac')]");
		return this;
	}
	
	public IntegrationPage clickAddWorkflowsIcon(String value) throws InterruptedException
	{
		System.out.println("Click Add Workflows Icon");
		clickByXpath("//mat-icon[contains(text(),'add')]");
		return this;
	}	
	
	public IntegrationPage enterSearchField(String value) throws InterruptedException
	{
		System.out.println("Enter Search Field");
		enterByXpath("//input[@placeholder='Search ']", value);
		clickByXpath("//mat-icon[contains(text(),'search')]");
		return this;
	}
	
	public IntegrationPage clickComponentActionBtn() throws InterruptedException
	{
		System.out.println("Click Component Action Btn");
		clickByXpath("(//div/following::mat-icon[contains(text(),'more_vert')])[1]");
		return this;
	}
	
	public IntegrationPage verifyWorkflowsActionButtons() throws InterruptedException
	{
		System.out.println("Vverify Workflows Action Buttons");
		verifyElementisPresent("//button/span[contains(text(),'Edit')]", "Edit Menu");
		verifyElementisPresent("//button/span[contains(text(),'Change Logo')]", "Change Logo Menu");
		verifyElementisPresent("//button/span[contains(text(),'Preview')]", "Preview Menu");
		verifyElementisPresent("//button/span[contains(text(),'Delete')]", "Delete Menu");
		return this;
	}
	
	public IntegrationPage clickEdit() throws InterruptedException
	{
		System.out.println("Click Edit");
		clickByXpath("//button/span[contains(text(),'Edit')]");
		return this;
	}
	
	public IntegrationPage clickChangeLogo() throws InterruptedException
	{
		System.out.println("Click Change Logo");
		clickByXpath("//button/span[contains(text(),'Change Logo')]");
		return this;
	}
	
	public IntegrationPage clickChooseFileBtnToUploadLogo() throws InterruptedException
	{
		System.out.println("Click Choose File Btn To Upload Logo");
		clickByXpath("//span[contains(text(),'Choose File')]");
		return this;
	}
	
	public IntegrationPage clickPreview() throws InterruptedException
	{
		System.out.println("Click Preview");
		clickByXpath("//button/span[contains(text(),'Preview')]");
		return this;
	}
	
	public IntegrationPage selectWorkflowsPreviewService() throws InterruptedException
	{
		System.out.println("Select Workflows Preview Service");
		clickByXpath("//mat-select[@formcontrolname='service']");
		clickByXpath("(//span[@class='mat-option-text'])[1]");		
		return this;
	}
	
	public IntegrationPage clickPreviewGoButton() throws InterruptedException
	{
		System.out.println("Click Preview Go Button");
		Thread.sleep(3000);
		clickByXpath("//button//span[contains(text(),'Go')]");
		return this;
	}
	
	public IntegrationPage clickDelete() throws InterruptedException
	{
		System.out.println("Click Delete");
		clickByXpath("//button/span[contains(text(),'Delete')]");
		return this;
	}
	
	public IntegrationPage verifyDeletePopUp()
	{
		System.out.println("Verify Delete Pop Up");
		verifyElementisPresent("//span[contains(text(),'Are you sure want to delete?')]", "Delete Pop Up");
		return this;
	}
	
		public IntegrationPage deleteWorkflows() throws InterruptedException
	{
		System.out.println("Delete Workflows");
		Thread.sleep(3000);
		clickByXpath("//button/span[contains(text(),'Delete')]");
		clickByXpath("//button//span[contains(text(),'Ok')]");
		return this;
	}
	
	//Deep Linking flow
	public IntegrationPage clickDeepLinkingMenu() throws InterruptedException
	{
		System.out.println("Click Deep Linking Menu");
		Thread.sleep(3000);
		clickByXpath("//span[contains(text(),'Deep Linking') and starts-with(@class,'mx-ac')]");
		return this;
	}
	
	public IntegrationPage verifyDeepLinkingSubMenus()
	{
		System.out.println("Verify Deep Linking Sub Menus");
		verifyElementisPresent("//span[contains(text(),'Modules') and starts-with(@class,'mx-ac')]", "Modules Menu");
		verifyElementisPresent("//span[contains(text(),'Groups') and starts-with(@class,'mx-ac')]", "Groups Menu");
		verifyElementisPresent("//span[contains(text(),'Link Groups') and starts-with(@class,'mx-ac')]", "Link Groups Menu");
		return this;
	}
	
	
	
	public IntegrationPage clickCIFNumberLink() throws InterruptedException
	{
		System.out.println("Click CIF Number Link");
		Thread.sleep(3000);
		clickByXpath("(//mat-cell/a)[1]");
		return this;
	}
	
	public IntegrationPage verifyCustomerMngmntUserDetails() throws InterruptedException
	{
		System.out.println("Verify Customer Mngmnt User Details");
		Thread.sleep(2000);
		String Uname = getTextByXpath("(//span[contains(text(),'Username')]/following::div/span)[1]");
		verifyTextByXpath("(//span[contains(text(),'Username')]/following::div/span)[1]", Uname);
		
		String CIF = getTextByXpath("(//span[contains(text(),'CIF')]/following::div/span)[1]");
		verifyTextByXpath("(//span[contains(text(),'CIF')]/following::div/span)[1]", CIF);

		verifyTextByXpath("(//span[contains(text(),'Marital ')]/following::div/span)[1]", "Single");
		scrollDown("(//span[contains(text(),'State')]/following::div/span)[1] ");		
		verifyTextByXpath("(//span[contains(text(),'State')]/following::div/span)[1]", "Singapore");
		verifyTextByXpath("(//span[contains(text(),'Country')]/following::div/span)[1]", "Singapore");
		verifyTextByXpath("(//span[contains(text(),'Postal ')]/following::div/span)[1]", "486006");
		return this;
	}
	
	public IntegrationPage clickBackBtn()
	{
		System.out.println("Click Back button");
		clickByXpath("//button/span[text()='Back']");
		return this;
	}	
	
	public IntegrationPage clickWorkflowManagementMenu() throws InterruptedException
	{
		System.out.println("Click Workflow Management Menu");
		Thread.sleep(3000);
		clickByXpath("//span[contains(text(),'Workflow Management') and starts-with(@class,'mx-ac')]");
		return this;
	}
				
	public IntegrationPage clickMakerSuspendActionButton() throws InterruptedException
	{
		System.out.println("Click Maker Suspend Action Button");
		Thread.sleep(5000);
//		clickByXpath("(//button[@aria-label='Action Button']/child::span)[1]/child::mat-icon");
		clickByXpath("((//mat-cell//div[text()='Active'])[2]/following::span)[1]");
		return this;
	}
	
	public IntegrationPage clickSuspendMenu() throws InterruptedException
	{
		System.out.println("Click Suspend Menu");
		Thread.sleep(1000);
		clickByXpath("//span[contains(text(),'Suspend')]");
		return this;
	}
	
	public IntegrationPage clickMakerActivateActionButton() throws InterruptedException
	{
		System.out.println("Click Maker Activate Action Button");
		Thread.sleep(5000);
//		clickByXpath("(//button[@aria-label='Action Button']/child::span)[1]/child::mat-icon");
		clickByXpath("(//mat-cell//div[text()='Suspended']/following::span)[1]");
		return this;
	}
	
	public IntegrationPage clickActivateMenu() throws InterruptedException
	{
		System.out.println("Click Activate Menu");
		Thread.sleep(1000);
		clickByXpath("//span[contains(text(),'Activate')]");
		return this;
	}
	
	public IntegrationPage clickCheckerSuspendActionButton() throws InterruptedException
	{
		System.out.println("Click Checker Suspend Action Button");
		Thread.sleep(5000);
//		clickByXpath("(//button[@aria-label='Action Button']/child::span)[1]/child::mat-icon");
//		clickByXpath("((//mat-cell//div[contains(text(),'Pending Approval')])[2]/following::span)[1]");
		clickByXpath("(//mat-cell//div[contains(text(),'Suspend Customer')]/following::span)[1]");
		return this;
	}
	
	public IntegrationPage clickCheckerActivateActionButton() throws InterruptedException
	{
		System.out.println("Click Checker Activate Action Button");
		Thread.sleep(5000);
//		clickByXpath("(//button[@aria-label='Action Button']/child::span)[1]/child::mat-icon");
//		clickByXpath("((//mat-cell//div[contains(text(),'Pending Approval')])[2]/following::span)[1]");
		clickByXpath("(//mat-cell//div[contains(text(),'Activate Customer')]/following::span)[1]");
		return this;
	}
	
	public IntegrationPage clickApproveMenu() throws InterruptedException
	{
		System.out.println("Click Approve Menu");
		Thread.sleep(1000);
		clickByXpath("//span[contains(text(),'Approve')]");
		return this;
	}
	
	public IntegrationPage clickApproveButton() throws InterruptedException
	{
		System.out.println("Click Approve Button");
		Thread.sleep(1000);
		scrollDown("(//span[contains(text(),'Approve')])[2]");
		clickByXpath("(//span[contains(text(),'Approve')])[2]");
		return this;
	}
		
	public IntegrationPage clickRejectMenu() throws InterruptedException
	{
		System.out.println("Click Reject Menu");
		Thread.sleep(1000);
		clickByXpath("//span[contains(text(),'Reject')]");
		return this;
	}
	
	public IntegrationPage enterRejectRemarks() throws InterruptedException{
		System.out.println("Enter the Reject Remarks");
		Thread.sleep(2000);
		scrollDown("//textarea[@formcontrolname='remark']");
		enterByXpath("//textarea[@formcontrolname='remark']", "test");
		return this;
	}
	
	public IntegrationPage clickRejectButton() throws InterruptedException
	{
		System.out.println("Click Reject Button");
		Thread.sleep(1000);
		clickByXpath("(//span[contains(text(),'Reject')])[2]");
		return this;
	}
	
	public IntegrationPage clickYesButton() throws InterruptedException
	{
		System.out.println("Click Yes Button");
		Thread.sleep(1000);
		clickByXpath("//span[contains(text(),'YES')]/parent::button");
		return this;
	}
	
	public IntegrationPage enterRemarks() throws InterruptedException{
		System.out.println("Enter the Remarks");
		Thread.sleep(2000);
		enterByXpath("//textarea[@formcontrolname='feedback']", "test");
		return this;
	}
	
	public IntegrationPage clickSubmitButton()
	{
		System.out.println("Click Submit Button");
		clickByXpath("//span[contains(text(),'SUBMIT')]/parent::button");
		return this;
	}
	
	public IntegrationPage SuccessMessage()
	{
		System.out.println("verify success Message");
		verifyElementisPresent("//h2[contains(text(),'Success')]", "Success");
		return this;
	}
	
	public IntegrationPage getReferenceNumber() {
		String ori = driver.findElement(By.xpath("//div[@class='mx-dg-successMsg']/child::span")).getText();
		try {
//			String[] str = ori.split(":");
//			reference = str[1].trim();
			reference = ori.trim();
			System.out.println("Reference number:" + reference);
			reportStep("The reference number is fetched successfully and the referencenumber is: " + reference, "PASS");
		} catch (Exception e) {
			System.out.println("error");
			reportStep("The reference number is not fetched ", "FAIL");
		}
		return this;
	}
	
	public IntegrationPage clickOkButton()
	{
		System.out.println("Click Ok Button");
		clickByXpath("//span[contains(text(),'OK')]/parent::button");
		return this;
	}
	
	public IntegrationPage clickProfileButton()
	{
		System.out.println("Click Profile Button");
		clickByXpath("//button[@aria-label='Settings']/following-sibling::button");
		return this;
	}
	
	public IntegrationPage userLogOut() throws InterruptedException {
		System.out.println("Logout the User");
		Thread.sleep(2000);
		clickByXpath("//button[@aria-label='Logout']");
		return this;
	}
	
	
}
