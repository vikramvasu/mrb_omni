package pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

public class CustomerManagementPage extends wrappers.ProjectWrappers  {
	
	public static String reference;
		
	public CustomerManagementPage(RemoteWebDriver driver, ExtentTest test)throws Exception{
		this.driver = driver;
		this.test = test;
		openQAAdminApplication();
	}
	
	public CustomerManagementPage loginMaker() throws InterruptedException {
		enterUserName("qamaker123")
	  	.enterPassword()
	  	.clickSignInBtn();
		return this;
	}
	
	public CustomerManagementPage loginChecker() throws InterruptedException {
		enterUserName("qachecker123")
	  	.enterPassword()
	  	.clickSignInBtn();
		return this;
	}
		
	public CustomerManagementPage enterUserName(String userName) throws InterruptedException{
		System.out.println("Enter the User Name");
		Thread.sleep(3000);
		enterByXpath("//input[@formcontrolname='userId']", userName);
		return this;
	}
	
	public CustomerManagementPage enterPassword(){
		System.out.println("Enter the Password");
		enterByXpath("//input[@formcontrolname='password']", "Password@12");
		return this;
	}
	
	public CustomerManagementPage clickSignInBtn()
	{
		System.out.println("Click Sign In button");
		clickByXpath("//button/span[contains(text(),'Sign in')]");
//		clickByXpath("//button[@type='submit']");
		return this;
	}
	
	public CustomerManagementPage verifyMobeixAdminHeader()
	{
		System.out.println("Verify Mobeix Admin Header");
		verifyElementisPresent("//header//h1[contains(text(),'Mobeix')]", "Mobeix Admin Header");
		return this;
	}
	 
	public CustomerManagementPage clickApplicationMenu()
	{
		System.out.println("Click Application Menu");
		clickByXpath("//li[@aria-label='Applications']");
		return this;
	}
	
	
	public CustomerManagementPage clickRetailBankingIcon() throws InterruptedException
	{
		System.out.println("Click Retail Banking Icon");
		Thread.sleep(2000);
		clickByXpath("//span[contains(text(),'MobeixRetailBanking')]");
		return this;
	}
	
	public CustomerManagementPage clickRetailAdminMenu()
	{
		System.out.println("Click Retail Admin Menu");
		clickByXpath("//span[contains(text(),'Retail Admin')]/parent::li");
		return this;
	}
	
	public CustomerManagementPage clickCustomerManagementMenu() throws InterruptedException
	{
		System.out.println("Click Customer Management Menu");
		Thread.sleep(3000);
		clickByXpath("//span[contains(text(),'Customer Management') and starts-with(@class,'mx-ac')]");
		return this;
	}

	public CustomerManagementPage clickCIFNumberLink() throws InterruptedException
	{
		System.out.println("Click CIF Number Link");
		Thread.sleep(3000);
		clickByXpath("(//mat-cell/a)[1]");
		return this;
	}
	
	public CustomerManagementPage verifyCustomerMngmntUserDetails() throws InterruptedException
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
	
	public CustomerManagementPage clickBackBtn()
	{
		System.out.println("Click Back button");
		clickByXpath("//button/span[text()='Back']");
		return this;
	}	
	
	public CustomerManagementPage clickWorkflowManagementMenu() throws InterruptedException
	{
		System.out.println("Click Workflow Management Menu");
		Thread.sleep(3000);
		clickByXpath("//span[contains(text(),'Workflow Management') and starts-with(@class,'mx-ac')]");
		return this;
	}
				
	public CustomerManagementPage clickMakerSuspendActionButton() throws InterruptedException
	{
		System.out.println("Click Maker Suspend Action Button");
		Thread.sleep(5000);
//		clickByXpath("(//button[@aria-label='Action Button']/child::span)[1]/child::mat-icon");
		clickByXpath("((//mat-cell//div[text()='Active'])[2]/following::span)[1]");
		return this;
	}
	
	public CustomerManagementPage clickSuspendMenu() throws InterruptedException
	{
		System.out.println("Click Suspend Menu");
		Thread.sleep(1000);
		clickByXpath("//span[contains(text(),'Suspend')]");
		return this;
	}
	
	public CustomerManagementPage clickMakerActivateActionButton() throws InterruptedException
	{
		System.out.println("Click Maker Activate Action Button");
		Thread.sleep(5000);
//		clickByXpath("(//button[@aria-label='Action Button']/child::span)[1]/child::mat-icon");
		clickByXpath("(//mat-cell//div[text()='Suspended']/following::span)[1]");
		return this;
	}
	
	public CustomerManagementPage clickActivateMenu() throws InterruptedException
	{
		System.out.println("Click Activate Menu");
		Thread.sleep(1000);
		clickByXpath("//span[contains(text(),'Activate')]");
		return this;
	}
	
	public CustomerManagementPage clickCheckerSuspendActionButton() throws InterruptedException
	{
		System.out.println("Click Checker Suspend Action Button");
		Thread.sleep(5000);
//		clickByXpath("(//button[@aria-label='Action Button']/child::span)[1]/child::mat-icon");
//		clickByXpath("((//mat-cell//div[contains(text(),'Pending Approval')])[2]/following::span)[1]");
		clickByXpath("(//mat-cell//div[contains(text(),'Suspend Customer')]/following::span)[1]");
		return this;
	}
	
	public CustomerManagementPage clickCheckerActivateActionButton() throws InterruptedException
	{
		System.out.println("Click Checker Activate Action Button");
		Thread.sleep(5000);
//		clickByXpath("(//button[@aria-label='Action Button']/child::span)[1]/child::mat-icon");
//		clickByXpath("((//mat-cell//div[contains(text(),'Pending Approval')])[2]/following::span)[1]");
		clickByXpath("(//mat-cell//div[contains(text(),'Activate Customer')]/following::span)[1]");
		return this;
	}
	
	public CustomerManagementPage clickApproveMenu() throws InterruptedException
	{
		System.out.println("Click Approve Menu");
		Thread.sleep(1000);
		clickByXpath("//span[contains(text(),'Approve')]");
		return this;
	}
	
	public CustomerManagementPage clickApproveButton() throws InterruptedException
	{
		System.out.println("Click Approve Button");
		Thread.sleep(1000);
		scrollDown("(//span[contains(text(),'Approve')])[2]");
		clickByXpath("(//span[contains(text(),'Approve')])[2]");
		return this;
	}
		
	public CustomerManagementPage clickRejectMenu() throws InterruptedException
	{
		System.out.println("Click Reject Menu");
		Thread.sleep(1000);
		clickByXpath("//span[contains(text(),'Reject')]");
		return this;
	}
	
	public CustomerManagementPage enterRejectRemarks() throws InterruptedException{
		System.out.println("Enter the Reject Remarks");
		Thread.sleep(2000);
		scrollDown("//textarea[@formcontrolname='remark']");
		enterByXpath("//textarea[@formcontrolname='remark']", "test");
		return this;
	}
	
	public CustomerManagementPage clickRejectButton() throws InterruptedException
	{
		System.out.println("Click Reject Button");
		Thread.sleep(1000);
		clickByXpath("(//span[contains(text(),'Reject')])[2]");
		return this;
	}
	
	public CustomerManagementPage clickYesButton() throws InterruptedException
	{
		System.out.println("Click Yes Button");
		Thread.sleep(1000);
		clickByXpath("//span[contains(text(),'YES')]/parent::button");
		return this;
	}
	
	public CustomerManagementPage enterRemarks() throws InterruptedException{
		System.out.println("Enter the Remarks");
		Thread.sleep(2000);
		enterByXpath("//textarea[@formcontrolname='feedback']", "test");
		return this;
	}
	
	public CustomerManagementPage clickSubmitButton()
	{
		System.out.println("Click Submit Button");
		clickByXpath("//span[contains(text(),'SUBMIT')]/parent::button");
		return this;
	}
	
	public CustomerManagementPage SuccessMessage()
	{
		System.out.println("verify success Message");
		verifyElementisPresent("//h2[contains(text(),'Success')]", "Success");
		return this;
	}
	
	public CustomerManagementPage getReferenceNumber() {
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
	
	public CustomerManagementPage clickOkButton()
	{
		System.out.println("Click Ok Button");
		clickByXpath("//span[contains(text(),'OK')]/parent::button");
		return this;
	}
	
	public CustomerManagementPage clickProfileButton()
	{
		System.out.println("Click Profile Button");
		clickByXpath("//button[@aria-label='Settings']/following-sibling::button");
		return this;
	}
	
	public CustomerManagementPage userLogOut() throws InterruptedException {
		System.out.println("Logout the User");
		Thread.sleep(2000);
		clickByXpath("//button[@aria-label='Logout']");
		return this;
	}
	
	
}
