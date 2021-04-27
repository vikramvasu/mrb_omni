package  pages.internetBanking;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

public class ApplyNowPage extends wrappers.ProjectWrappers  {
		
	public ApplyNowPage(RemoteWebDriver driver, ExtentTest test)throws Exception{
		this.driver = driver;
		this.test = test;
		openQAIBApplication();
	}
	
	public ApplyNowPage loginUsingSMS() throws InterruptedException {
		enterUserName()
	  	.enterPassword()
	  	.takeMeDirectlyTo("Dashboard")
	  	.clickSignInBtn()
	  	.select2FAType("SMS OTP")
	  	.enterSMSOTP()
	  	.clickSubmitBtn2FAPage();
		return this;
	}
		
	public ApplyNowPage clickUserName() throws InterruptedException{
		System.out.println("Click the User Name");
		Thread.sleep(3000);
		clickById("login_input_username");
		return this;
	}
	
	public ApplyNowPage enterUserName() throws InterruptedException{
		System.out.println("Enter the User Name");
		Thread.sleep(3000);
		enterByXpath("(//input[@placeholder='Enter'])[1]", "debituser23");
		return this;
	}
	
	public ApplyNowPage clickPassword(){
		System.out.println("Click the Password");
		clickById("login_input_password");
		return this;
	}
	
	public ApplyNowPage enterPassword(){
		System.out.println("Enter the Password");
		enterByXpath("(//input[@placeholder='Enter'])[2]", "Qwerty789");
		return this;
	}
	
	public ApplyNowPage takeMeDirectlyTo(String page)
	{
		System.out.println("Select any one take me directly option");
		clickByXpath("//mat-select[@formcontrolname='directTo']");
	    clickByXpath("//span[@class='mat-option-text'][contains(text(),'"+page+"')]");
		return this;
	}

	public ApplyNowPage clickSignInBtn()
	{
		System.out.println("Click Sign In button");
		clickByXpath("//button[@type='submit']");
		return this;
	}
		
	public ApplyNowPage select2FAType(String auth)
	{
		System.out.println("Select 2FA Type");
		clickByXpath("//div//span[contains(text(),'Select')]");
	    clickByXpath("//span[@class='mat-option-text'][contains(text(),'"+auth+"')]");
		return this;
	}
	
	public ApplyNowPage enterSMSOTP() throws InterruptedException
	{
		System.out.println("Entered the OTP");
		Thread.sleep(3000);
		enterByXpath("(//input[@formcontrolname='input'])[1]","1");
		enterByXpath("(//input[@formcontrolname='input'])[2]","2");
		enterByXpath("(//input[@formcontrolname='input'])[3]","3");
		enterByXpath("(//input[@formcontrolname='input'])[4]","4");
		enterByXpath("(//input[@formcontrolname='input'])[5]","5");
		enterByXpath("(//input[@formcontrolname='input'])[6]","6");
		return this;
	}

	public ApplyNowPage clickResendCodeLink()
	{
		System.out.println("Click Resend Code Link");
		clickByXpath("//span[contains(text(),'Resend code')]");
		return this;
	}
	
	public ApplyNowPage clickSubmitBtn2FAPage()
	{
		System.out.println("Click Submit button");
		clickByXpath("//button/span[contains(text(),'Submit')]");
		return this;
	}
	
	public ApplyNowPage verifyDashboardTitle() throws InterruptedException
	{
		System.out.println("Verify Dashboard title");
		Thread.sleep(4000);
		verifyElementisPresent("//span[contains(text(), 'Dashboard')]", "Dashboard");
		return this;
	}	
	// Apply Now Page Flows
	
	public ApplyNowPage clickApplyNowArrow() throws InterruptedException
	{
		System.out.println("Click Apply Now Arrow");
		Thread.sleep(2000);
		clickByXpath("//a//span[contains(text(),'Apply')]//following-sibling::span/span");
		return this;
	}
	
	public ApplyNowPage clickOpenOverDraftAccountMenu() throws InterruptedException
	{
		System.out.println("Click Open OverDraft Account Menu");
		Thread.sleep(2000);
		clickByXpath("//span[contains(text(),'Open Overdraft Account')]");
		return this;
	}
	
	public ApplyNowPage clickOpenCASAAccountMenu() throws InterruptedException
	{
		System.out.println("Click Open CASA Account Menu");
		Thread.sleep(2000);
		clickByXpath("//span[contains(text(),'Open CASA Account')]");
		return this;
	}
	
	public ApplyNowPage clickOpenFixedDepositMenu() throws InterruptedException
	{
		System.out.println("Click Open Fixed Deposit Menu");
		Thread.sleep(2000);
		clickByXpath("//span[contains(text(),'Open Fixed Deposit')]");
		return this;
	}
	
	public ApplyNowPage verifyApplyNowContextLinks() throws InterruptedException
	{
		System.out.println("Verify Apply Now Context Links");
		Thread.sleep(2000);
		verifyElementisPresent("//div[contains(text(),'Open Overdraft Account') and @fxlayoutalign='start center']", "Overdraft Account");
		verifyElementisPresent("//div[contains(text(),'Open CASA Account') and @fxlayoutalign='start center']", "CASA Account");
		verifyElementisPresent("//div[contains(text(),'Open Fixed Deposit') and @fxlayoutalign='start center']", "Fixed Deposit");
		return this;
	}
	
	
	public ApplyNowPage clickOpenOverDraftAccountContextLink() throws InterruptedException
	{
		System.out.println("Click Open OverDraft Account Context Link");
		Thread.sleep(2000);
		clickByXpath("//div[contains(text(),'Open Overdraft Account') and @fxlayoutalign='start center']");
		return this;
	}
	
	public ApplyNowPage clickOpenCASAAccountContextLink() throws InterruptedException
	{
		System.out.println("Click Open CASA Account Context Link");
		Thread.sleep(2000);
		clickByXpath("//div[contains(text(),'Open CASA Account') and @fxlayoutalign='start center']");
		return this;
	}
	
	public ApplyNowPage clickOpenFixedDepositContextLink() throws InterruptedException
	{
		System.out.println("Click Open Fixed Deposit Context Link");
		Thread.sleep(2000);
		clickByXpath("//div[contains(text(),'Open Fixed Deposit') and @fxlayoutalign='start center']");
		return this;
	}
	
	public ApplyNowPage clickApplyNowBtn() throws InterruptedException
	{
		System.out.println("Click ApplyNowBtn");
		Thread.sleep(2000);
		clickByXpath("//button/span[contains(text(),'Apply')]");
		return this;
	}
	
	public ApplyNowPage selectCountryCode(String Code) throws InterruptedException
	{
		System.out.println("Select Country Code");
		Thread.sleep(2000);
		clickByXpath("//mat-select//child::span/span");
		clickByXpath("//mat-option//span[contains(text(),'"+Code+"')]");
		return this;
	}
	
	public ApplyNowPage enterContactNumber() throws InterruptedException
	{
		System.out.println("Enter Contact Number");
		enterByXpath("//input[@formcontrolname='cno']","8939613337");
		return this;
	}
	
	public ApplyNowPage verifySuccessPageDetails() throws InterruptedException
	{
		System.out.println("Verify Success Page Details");
		Thread.sleep(2000);
		String Ref = getTextByXpath("(//span[contains(text(),'Host Reference')]/following::span)[1]");
		verifyTextByXpath("(//span[contains(text(),'Host Reference')]/following::span)[1]", Ref);	
		String prodType = getTextByXpath("(//span[contains(text(),'Product')]/following::span)[1]");
		verifyTextByXpath("(//span[contains(text(),'Product')]/following::span)[1]", prodType);
		return this;
	}
	
	public ApplyNowPage verifyOverDraftSuccessMessage()
	{
		System.out.println("Verify Over Draft Success Message");
		verifyElementisPresent("//*[contains(text(),'Success! The request for overdraft account opening has been placed successfully')]", "Over Draft Account Success Message");
		verifyTextByXpath("//*[contains(text(),'Success! The request for overdraft account opening has been placed successfully')]", "Success! The request for overdraft account opening has been placed successfully");
		return this;
	}
	
	public ApplyNowPage verifyCASASuccessMessage()
	{
		System.out.println("Verify CASA Success Message");
		verifyElementisPresent("//*[contains(text(),'Success ! Your request for opening CASA Account has been placed successfully!')]", "CASA Account Success Message");
		verifyTextByXpath("//*[contains(text(),'Success ! Your request for opening CASA Account has been placed successfully!')]", "Success ! Your request for opening CASA Account has been placed successfully!");
		return this;
	}
	
	public ApplyNowPage selectDebitAccount() throws InterruptedException
	{
		System.out.println("Select Debit Account");
		Thread.sleep(2000);
		clickByXpath("(//div[@class='ng-value ng-star-inserted'])[1]");
		Actions debitAccount = new Actions(driver);
		debitAccount.moveToElement(driver.findElement(By.xpath("(//div[@class='ng-star-inserted']/following::div[contains(text(),'INR')])[1]"))).click().perform();
//		clickByXpath("(//div[@class='ng-star-inserted']/following::div[contains(text(),'INR')])[1]");
		return this;
	}
	
	public ApplyNowPage enterDebitAmount() throws InterruptedException
	{
		System.out.println("Enter Debit Amount");
		enterByXpath("//input[@formcontrolname='da']","1000");
		return this;
	}
	
	public ApplyNowPage selectPaymentDate(String Date, String Month, String Year)
	{
		System.out.println("Select Payment Date");
		clickByXpath("//input[@formcontrolname='pd']");
		clickByXpath("//div[@class='dropdowns ng-star-inserted'][2]");
		clickByXpath("//span[@class='mat-option-text'][contains(text(),'"+Year+"')]");
		clickByXpath("//div[@class='dropdowns ng-star-inserted'][1]");
		clickByXpath("//span[@class='mat-option-text'][contains(text(),'"+Month+"')]");
		Actions DOB = new Actions(driver);
		DOB.moveToElement(driver.findElement(By.xpath("//tbody/tr//td//span[contains(text(),'"+Date+"')]"))).click().perform();
//		clickByXpath("//td[@class='active available end-date in-range start-date today ng-star-inserted']");
		return this;
	}
	
	public ApplyNowPage selectPaymentDate()
	{
		System.out.println("Select Payment Date");
		clickByXpath("//input[@formcontrolname='pd']");
		Actions DOB = new Actions(driver);
		DOB.moveToElement(driver.findElement(By.xpath("//td[@class='active available end-date in-range start-date today ng-star-inserted']"))).click().perform();
		return this;
	}
	
	public ApplyNowPage selectTenure() throws InterruptedException
	{
		System.out.println("Select Tenure");
		Thread.sleep(2000);
		clickByXpath("(//div[@class='ng-value ng-star-inserted'])[2]");
//		clickByXpath("(//div[@class='ng-option ng-option-selected ng-option-marked ng-star-inserted'])[1]");
		clickByXpath("(//div[@class='ng-option ng-star-inserted'])[1]");
		return this;
	}
	
	public ApplyNowPage selectCreditAccount() throws InterruptedException
	{
		System.out.println("Select Credit Account");
		Thread.sleep(2000);
		clickByXpath("(//div[@class='ng-value ng-star-inserted'])[3]");
//		clickByXpath("(//div[@class='ng-option ng-option-marked ng-star-inserted'])[1]");
//		clickByXpath("(//div[@class='ng-star-inserted']/following::div[contains(text(),'INR')])[1]");
		Actions debitAccount = new Actions(driver);
		debitAccount.moveToElement(driver.findElement(By.xpath("(//div[@class='ng-star-inserted']/following::div[contains(text(),'INR')])[1]"))).click().perform();
		return this;
	}
	
	public ApplyNowPage selectMaturityOptions() throws InterruptedException
	{
		System.out.println("Select Maturity Options");
		Thread.sleep(2000);
		clickByXpath("(//div[@class='ng-value ng-star-inserted'])[4]");
		clickByXpath("(//div[@class='ng-option ng-option-selected ng-option-marked ng-star-inserted'])[1]");
		return this;
	}

	public ApplyNowPage verifyFixedDepositSuccessMessage()
	{
		System.out.println("Verify Fixed Deposit Success Message");
		verifyElementisPresent("//*[contains(text(),'Success ! Fixed Deposit request has been sent successfully.')]", "Fixed Deposit Success Message");
		verifyTextByXpath("//*[contains(text(),'Success ! Fixed Deposit request has been sent successfully.')]", "Success ! Fixed Deposit request has been sent successfully.");
		return this;
	}
	
	public ApplyNowPage clickNextBtn()
	{
		System.out.println("Click Next button");
		clickByXpath("//button/span[contains(text(),'Next')]");
		return this;
	}
	
	public ApplyNowPage clickSubmitButton()
	{
		System.out.println("Click Submit button");
		clickByXpath("(//button/span[contains(text(),'Submit')])[2]");
		return this;
	}
	
	public ApplyNowPage clickSubmitBtn()
	{
		System.out.println("Click Submit button");
		clickByXpath("//button/span[contains(text(),'Submit')]");
		return this;
	}
	
	public ApplyNowPage clickCancelBtn()
	{
		System.out.println("Click Cancel button");
		clickByXpath("//button/span[contains(text(),'Cancel')]");
		return this;
	}
	
	public ApplyNowPage clickConfirmBtn()
	{
		System.out.println("Click Confirm button");
		clickByXpath("//button/span[contains(text(),'Confirm')]");
		return this;
	}	
	
	public ApplyNowPage clickBackBtn()
	{
		System.out.println("Click Back button");
		clickByXpath("//button/span[contains(text(),'Back')]");
		return this;
	}
	
	public ApplyNowPage clickOkBtn()
	{
		System.out.println("Click Ok button");
		clickByXpath("//button/span[contains(text(),'Ok')]");
		return this;
	}	
		
	public ApplyNowPage userLogOut() throws InterruptedException {
		System.out.println("Logout the User");
		Thread.sleep(2000);
		clickByXpath("(//span[contains(text(), 'Logout')])[2]");
		return this;
	}
}
