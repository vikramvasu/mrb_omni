package  pages.internetBanking;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

public class FundTransferPage extends wrappers.ProjectWrappers  {
		
	public FundTransferPage(RemoteWebDriver driver, ExtentTest test)throws Exception{
		this.driver = driver;
		this.test = test;
		openQAIBApplication();
	}
	
	public FundTransferPage loginUsingSMS() throws InterruptedException {
		enterUserName()
	  	.enterPassword()
	  	.takeMeDirectlyTo("Dashboard")
	  	.clickSignInBtn()
	  	.select2FAType("SMS OTP")
	  	.enterSMSOTP()
	  	.clickSubmitBtn2FAPage();
		return this;
	}
		
	public FundTransferPage clickUserName() throws InterruptedException{
		System.out.println("Click the User Name");
		Thread.sleep(3000);
		clickById("login_input_username");
		return this;
	}
	
	public FundTransferPage enterUserName() throws InterruptedException{
		System.out.println("Enter the User Name");
		Thread.sleep(3000);
		enterByXpath("(//input[@placeholder='Enter'])[1]", "debituser23");
		return this;
	}
	
	public FundTransferPage clickPassword(){
		System.out.println("Click the Password");
		clickById("login_input_password");
		return this;
	}
	
	public FundTransferPage enterPassword(){
		System.out.println("Enter the Password");
		enterByXpath("(//input[@placeholder='Enter'])[2]", "Qwerty789");
		return this;
	}
	
	public FundTransferPage takeMeDirectlyTo(String page)
	{
		System.out.println("Select any one take me directly option");
		clickByXpath("//mat-select[@formcontrolname='directTo']");
	    clickByXpath("//span[@class='mat-option-text'][contains(text(),'"+page+"')]");
		return this;
	}

	public FundTransferPage clickSignInBtn()
	{
		System.out.println("Click Sign In button");
		clickByXpath("//button[@type='submit']");
		return this;
	}
		
	public FundTransferPage clickNextBtn()
	{
		System.out.println("Click Next button");
		clickByXpath("//button/span[text()='Next']");
		return this;
	}	
	
	public FundTransferPage select2FAType(String auth)
	{
		System.out.println("Select 2FA Type");
		clickByXpath("//div//span[contains(text(),'Select')]");
	    clickByXpath("//span[@class='mat-option-text'][contains(text(),'"+auth+"')]");
		return this;
	}
	
	public FundTransferPage enterSMSOTP() throws InterruptedException
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

	public FundTransferPage clickResendCodeLink()
	{
		System.out.println("Click Resend Code Link");
		clickByXpath("//span[contains(text(),'Resend code')]");
		return this;
	}
	
	public FundTransferPage clickSubmitBtn2FAPage()
	{
		System.out.println("Click Submit button");
		clickByXpath("//button/span[contains(text(),'Submit')]");
		return this;
	}
	
	public FundTransferPage verifyDashboardTitle() throws InterruptedException
	{
		System.out.println("Verify Dashboard title");
		Thread.sleep(4000);
		verifyElementisPresent("//span[contains(text(), 'Dashboard')]", "Dashboard");
		return this;
	}
	
	public FundTransferPage clickTransfersTab() throws InterruptedException
	{
		System.out.println("Click Transfers Tab");
		clickByXpath("//span[contains(text(),'Transfers')]");
		Thread.sleep(4000);
		return this;
	}

	public FundTransferPage selectTransferType(String type)
	{
		System.out.println("Select Transfer Type");
		if(type.equalsIgnoreCase("local")) {
			clickByXpath("//div[contains(text(),'Local Bank Transfer')]");
		}
		else if(type.equalsIgnoreCase("onetime")) {
			clickByXpath("//div[contains(text(),'One Time Transfer')]");
		}
		else if(type.equalsIgnoreCase("international")) {
			clickByXpath("//div[contains(text(),'International Transfer')]");
		}
		else if(type.equalsIgnoreCase("recent")) {
			clickByXpath("//div[contains(text(),'Favourite & Recent Transaction')]");
		}
		return this;
	}
	
	public FundTransferPage clickTransfersFrom() throws InterruptedException
	{
		System.out.println("Click Transfers From");
		clickByXpath("(//span[@class='ng-arrow-wrapper'])[1]");
		clickByXpath("(//div[@class='ng-option ng-star-inserted'])[1]");	
		return this;
	}
	
	public FundTransferPage clickTransfersTo() throws InterruptedException
	{
		System.out.println("Click Transfers To");
		clickByXpath("(//span[@class='ng-arrow-wrapper'])[2]");
		clickByXpath("(//div[@role='option'])[1]");	
		return this;
	}
	
	public FundTransferPage clickOwnBankTransfersTo() throws InterruptedException
	{
		System.out.println("Click Own Bank Transfer To Account");
		clickByXpath("(//span[@class='ng-arrow-wrapper'])[2]");
		clickByXpath("(//div[contains(text(),'Self Account')]/parent::div/following-sibling::div)[1]");	
		return this;
	}
	
	public FundTransferPage selectPaymentCurrency(String Currency)
	{
		System.out.println("Select Payment Currency");
		clickByXpath("//mat-select[@formcontrolname='paymentcurrency']");
	    clickByXpath("//span[@class='mat-option-text'][contains(text(),'"+Currency+"')]");
		return this;
	}
	
	public FundTransferPage enterPaymentAmount() throws InterruptedException
	{
		System.out.println("Enter Payment Amount");
		enterByXpath("//input[@placeholder='Payment Amount']", "100");	
		return this;
	}
	
	public FundTransferPage clickPaymentWhen(String When) throws InterruptedException
	{
		System.out.println("Click Payment When");
		clickByXpath("//button/div[contains(text(),'"+When+"')]");
		return this;
	}
	
	public FundTransferPage selectLaterPaymentDate(String Date, String Month, String Year)
	{
		System.out.println("Select Later Payment Date");
		clickByXpath("//input[@formcontrolname='paymentDate']");
		verifyElementisPresent("//div[@class='calendar-table']", "Calendar Pop Up");
		clickByXpath("//div[@class='dropdowns ng-star-inserted'][2]");
		clickByXpath("//span[@class='mat-option-text'][contains(text(),'"+Year+"')]");
		clickByXpath("//div[@class='dropdowns ng-star-inserted'][1]");
		clickByXpath("//span[@class='mat-option-text'][contains(text(),'"+Month+"')]");
		verifyElementisPresent("//*[@class='drp-animate ng-star-inserted']", "Week Days Body in Calendar");
		Actions DOB = new Actions(driver);
		DOB.moveToElement(driver.findElement(By.xpath("//tbody/tr//td//span[contains(text(),'"+Date+"')]"))).click().perform();
//		clickByXpath("//td[@class='active available end-date start-date today ng-star-inserted']");
		return this;
	}
	
	public FundTransferPage selectRecurringPaymentDate(String Date, String Month, String Year)
	{
		System.out.println("Select Recurring Payment Date");
		clickByXpath("//input[@formcontrolname='paymentDate']");
		verifyElementisPresent("//div[@class='calendar-table']", "Calendar Pop Up");
		clickByXpath("//div[@class='dropdowns ng-star-inserted'][2]");
		clickByXpath("//span[@class='mat-option-text'][contains(text(),'"+Year+"')]");
		clickByXpath("//div[@class='dropdowns ng-star-inserted'][1]");
		clickByXpath("//span[@class='mat-option-text'][contains(text(),'"+Month+"')]");
		verifyElementisPresent("//*[@class='drp-animate ng-star-inserted']", "Week Days Body in Calendar");
		Actions DOB = new Actions(driver);
		DOB.moveToElement(driver.findElement(By.xpath("//tbody/tr//td//span[contains(text(),'"+Date+"')]"))).click().perform();
//		clickByXpath("//td[@class='active available end-date start-date today ng-star-inserted']");
		return this;
	}
		
	public FundTransferPage clickConfirmBtn()
	{
		System.out.println("Click Confirm button");
		clickByXpath("//button/span[text()='Confirm & Transfer']");
		return this;
	}	
	
	public FundTransferPage verifyFundTransferSuccessMessage() throws InterruptedException {
		System.out.println("Verify Fund Transfer Success Message");
		waitForLoad();
		Thread.sleep(4000);
		String Message = getTextByXpath("//h3[contains(text(),'Your request for Fund Transfer submitted successfully')]");
		verifyTextByText(Message, "Your request for Fund Transfer has been submitted successfully");
		return this;
	}

	public FundTransferPage clickSubmitBtn()
	{
		System.out.println("Click Submit button");
		clickByXpath("//button/span[contains(text(),'Submit')]");
		return this;
	}
	
	public FundTransferPage clickCancelBtn()
	{
		System.out.println("Click Cancel button");
		clickByXpath("//button/span[text()='Cancel']");
		return this;
	}
	
	public FundTransferPage verifyCaneclPopUp()
	{
		System.out.println("Verify Canecl Pop Up");
		verifyElementisPresent("//p[contains(text(),'Are you sure you want to discard the changes?')]", "Cancel Pop Up");
		verifyTextByXpath("//p[contains(text(),'Are you sure you want to discard the changes?')]", "Are you sure you want to discard the changes?");
		return this;
	}
	
	public FundTransferPage clickYesbtn() {
		System.out.println("Click YES button");
		clickByXpath("//button/span[contains(text(),'Yes')]");
		return this;
	}
	
	
	
	public FundTransferPage clickEscapeButton()
	{
		System.out.println("Click Escape Button");
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ESCAPE).build().perform();
		return this;
	}
	
		
	// ONE TIME TRANSFER
	public FundTransferPage enterPayeeName() 
	{
		System.out.println("Enter Payee Name");
		enterByXpath("//input[@formcontrolname='creditpayname']", "Dhoni");	
		return this;
	}
	
	public FundTransferPage enterPayeeAccountNumber() 
	{
		System.out.println("Enter Payee Account Number");
		enterByXpath("//input[@formcontrolname='creditaccountnumber']", "144123456789");	
		return this;
	}
	
	public FundTransferPage enterReenterPayeeAccountNumber() 
	{
		System.out.println("Enter Re Enter Payee Account Number");
		enterByXpath("//input[@formcontrolname='creditconfirmaccountnumber']", "144123456789");	
		return this;
	}
	
	public FundTransferPage clickPayeeBank()
	{
		System.out.println("Click Payee Bank");
		clickByXpath("//input[@formcontrolname='payeebanksearch']");
		return this;
	}	
	
	public FundTransferPage enterBankName(String bankName) 
	{
		System.out.println("Enter Bank Name");
		enterByXpath("//input[@formcontrolname='qs']", bankName);	
		return this;
	}
	
	public FundTransferPage clickSearchButton()
	{
		System.out.println("Click Search Button");
		clickByXpath("//span[contains(text(),'Search')]/parent::button");
		return this;
	}	
	
	
	public FundTransferPage enterRemarks() 
	{
		System.out.println("Enter Remarks");
		enterByXpath("//*[@formcontrolname='remarks']", "test");	
		return this;
	}
	
	public FundTransferPage clickConfirmPayBtn()
	{
		System.out.println("Click Confirm & Pay button");
		clickByXpath("//span[contains(text(),'Confirm & Pay')]");
		return this;
	}
	
	public FundTransferPage clickOKbtn() {
		System.out.println("Click OK button");
		clickByXpath("//button/span[contains(text(),'OK')]");
		return this;
	}
	
	
	
	public FundTransferPage clickNextButton()
	{
		System.out.println("Click Next Button");
		clickByXpath("//span[contains(text(),'Next')]/parent::button");
		return this;
	}
	
	public FundTransferPage clickConfirmTransferButton()
	{
		System.out.println("Click Confirm Transfer Button");
		clickByXpath("//button/span[text()='Confirm & Transfer']");
		return this;
	}
	
	// ONe TIme success message
	public FundTransferPage verifyOneTimeFundTransferSuccessMessage() throws InterruptedException {
		System.out.println("Verify One Time Fund Transfer Success Message");
		waitForLoad();
		Thread.sleep(4000);
		verifyElementisPresent("//*[contains(text(),'Success! Your request for Fund Transfer submitted successfully')]", "Success! Your request for Fund Transfer submitted successfully");
		return this;
	}
	
	public FundTransferPage clickDownloadReceiptButton()
	{
		System.out.println("Click Download Receipt Button");
		clickByXpath("//*[contains(text(),'Download Receipt')]");
		return this;
	}
	
	public FundTransferPage clickSavePayeeButton()
	{
		System.out.println("Click Save Payee Button");
		clickByXpath("//*[contains(text(),'Save Payee')]/parent");
		return this;
	}
	
	public FundTransferPage clickNewTransferButton()
	{
		System.out.println("Click New Transfer Button");
		clickByXpath("//*[contains(text(),'New Transfer')]/parent::button");
		return this;
	}
	
	
	public FundTransferPage verifyTransferToLabel() throws InterruptedException {
		System.out.println("Verify Transfer To Label");
		Thread.sleep(2000);
		verifyElementisPresent("//span[contains(text(),'Transfer TO')]", "Transfer To");
		return this;
	}
	
	public FundTransferPage verifyBankCodeLabel()  {
		System.out.println("Verify Bank Code Label");
		verifyElementisPresent("//span[contains(text(),'Bank Code')]", "Bank Code");
		return this;
	}
	
	public FundTransferPage verifyPaymentCurrencyLabel()  {
		System.out.println("Verify Payment Currency Label");
		verifyElementisPresent("//span[contains(text(),'Payment Currency')]", "Payment Currency");
		return this;
	}
	
	
	public FundTransferPage verifyPaymentDateLabel()  {
		System.out.println("Verify Payment Date Label");
		verifyElementisPresent("//span[contains(text(),'Payment Date')]", "Payment Date");
		return this;
	}
	
	public FundTransferPage enterPaymentDate(String paymentDate) throws InterruptedException
	{
		System.out.println("Enter Payment Date");
		Thread.sleep(2000);
		enterByXpath("//input[@formcontrolname='paymentDate']", paymentDate);	
		return this;
	}
	
	// Cross Currency flows
	public FundTransferPage enterFxcContract() 
	{
		System.out.println("Enter Fxc Contract");
		enterByXpath("//input[@formcontrolname='fxc']", "12312");	
		return this;
	}
	
	public FundTransferPage enterDebitAmount() 
	{
		System.out.println("Enter Debit Amount");
		enterByXpath("//*[@formcontrolname='debitAmount']", "120");	
		return this;
	}
	
	// Recurring Flow
	public FundTransferPage enterPaymentInstallments() 
	{
		System.out.println("Enter Payment Installments");
		enterByXpath("//*[@formcontrolname='PaymentInstallments']", "6");	
		return this;
	}
	
	public FundTransferPage clickPaymentFrequency()
	{
		System.out.println("Click Payment Frequency");
		clickByXpath("//*[@formcontrolname='PaymentFrequency']");
		return this;
	}
	
	public FundTransferPage selectPaymentFrequencyTime(String paymentTime)
	{
		// Payment Time like weekly monthly
		System.out.println("Select Payment Time");
		if(paymentTime.equalsIgnoreCase("local")) {
			clickByXpath("//span[contains(text(),'Weekly')]");
		}
		else if(paymentTime.equalsIgnoreCase("onetime")) {
			clickByXpath("//span[contains(text(),'Monthly')]");
		}
		
		return this;
	}
	
	
	
	// INTERNATIONAL FLOW 
	public FundTransferPage enterInternationalPaymentAmount()
	{
		System.out.println("International Payment Amount");
		enterByXpath("//input[@formcontrolname='paymentamount']", "230");
		return this;
	}
	
	public FundTransferPage selectPaymentPolicy() throws InterruptedException
	{
		System.out.println("Click International Payment Policy");
		clickByXpath("//*[@formcontrolname='chargesBroneBy' and @role='listbox']");
		Thread.sleep(2000);
		// Selecting the Ben from the Drop down
		clickByXpath("//span[contains(text(),'BEN')]");
		
		return this;
	}
	
	public FundTransferPage selectPurposeofPayment() throws InterruptedException
	{
		System.out.println("Click International Purpose of Payment");
		clickByXpath("//*[@formcontrolname='perpusOfPayment' and @role='listbox']");
		Thread.sleep(2000);
		// Selecting the Educational Support Option from the Drop down
		clickByXpath("//span[contains(text(),'Educational Support')]");
		return this;
	}
	
	public FundTransferPage enterInternationalPaymentDetailsFirst() 
	{
		System.out.println("Enter International Payment Details 1");
		enterByXpath("//*[@formcontrolname='paymentDtsLine1']", "Burg KHalifaa");	
		return this;
	}
	
	public FundTransferPage enterInternationalPaymentDetailsSecond() 
	{
		System.out.println("Enter International Payment Details 2");
		enterByXpath("//*[@formcontrolname='paymentDtsLine2']", "Dubai");	
		return this;
	}
	
	
	public FundTransferPage clickViewLink()
	{
		System.out.println("Click View Link");
		clickByXpath("//span[contains(text(),'View')]");
		return this;
	}
	
	public FundTransferPage clickStopLink()
	{
		System.out.println("Click Stop Link");
		clickByXpath("//span[contains(text(),'Stop')]");
		return this;
	}
	
	public FundTransferPage clickRescheduleLink()
	{
		System.out.println("Click Reschedule Link");
		clickByXpath("//span[contains(text(),'Reschedule')]");
		return this;
	}
	
	public FundTransferPage clickRescheduleButton()
	{
		System.out.println("Click Reschedule Button");
		clickByXpath("//span[contains(text(),'Reschedule Payment')]");
		return this;
	}
	
	public FundTransferPage clickBackButton()
	{
		System.out.println("Click Back Button");
		clickByXpath("//span[contains(text(),'Back')]");
		return this;
	}
	
	public FundTransferPage clickBackHomeButton()
	{
		System.out.println("Click Back Home Button");
		clickByXpath("//*[contains(text(),'Back Home')]");
		return this;
	}
	
	// stop the Recurring Payment
	public FundTransferPage selectStopPaymentCheckbox(String stopPaymentCheckbox)
	{
		System.out.println("Select Stop Payment Check box");
		// It will select the first all option to do stop the Recurring option
		if(stopPaymentCheckbox.equalsIgnoreCase("all")) {
			clickByXpath("(//input[@type='checkbox'])[2]");
		}
		else if(stopPaymentCheckbox.equalsIgnoreCase("FirstOption")) {
			clickByXpath("(//input[@type='checkbox'])[3]");  // It will select the First Option and stop the first Recurring option
		}
		return this;
	}
	
	
	// Stop the Recurring Payment and Later Payment
	
	public FundTransferPage verifyPaymentStoppedMessage()  {
		System.out.println("Verify Payment Stopped Message ");
		verifyElementisPresent("//*[contains(text(),'Success! Your payment has been stopped.')]", "Success! Your payment has been stopped.");
		return this;
	}
	
	public FundTransferPage verifySchedulePaymentSuccessMessage()  {
		System.out.println("Verify Schedule Payment Success Message ");
		verifyElementisPresent("//*[contains(text(),'Success! The changes in your scheduled payment has been updated successfully. ')]", "Success! The changes in your scheduled payment has been updated successfully.");
		return this;
	}
	
	public FundTransferPage selectScheduleDate(String Date, String Month, String Year)
	{
		System.out.println("Select Schedule Date");
		clickByXpath("//input[@formcontrolname='scheduledDate']");
		verifyElementisPresent("//div[@class='calendar-table']", "Calendar Pop Up");
		clickByXpath("//div[@class='dropdowns ng-star-inserted'][2]");
		clickByXpath("//span[@class='mat-option-text'][contains(text(),'"+Year+"')]");
		clickByXpath("//div[@class='dropdowns ng-star-inserted'][1]");
		clickByXpath("//span[@class='mat-option-text'][contains(text(),'"+Month+"')]");
		verifyElementisPresent("//*[@class='drp-animate ng-star-inserted']", "Week Days Body in Calendar");
		Actions DOB = new Actions(driver);
		DOB.moveToElement(driver.findElement(By.xpath("//tbody/tr//td//span[contains(text(),'"+Date+"')]"))).click().perform();
//		clickByXpath("//td[@class='active available end-date start-date today ng-star-inserted']");
		return this;
	}
	
	public FundTransferPage clickStopPaymentButton()
	{
		System.out.println("Click Stop Payment Button");
		clickByXpath("//button/span[contains(text(),'Stop Payment')]");
		return this;
	}
	
	
	public FundTransferPage verifyScheduledDateLabel()  {
		System.out.println("Verify Scheduled Date Label ");
		verifyElementisPresent("//span[contains(text(),'Scheduled Date')]", "Scheduled Date");
		return this;
	}
	
	public FundTransferPage verifyTransferScheduledDateLabel()  {
		System.out.println("Verify Transfer Scheduled Date Label ");
		verifyElementisPresent("//span[contains(text(),'Transaction Schedule')]", "Transfer Schedule");
		return this;
	}
	
	public FundTransferPage verifyTransferTypeLabel()  {
		System.out.println("Verify Transfer Type ");
		verifyElementisPresent("//span[contains(text(),'Transfer Type')]", "Transfer Type");
		return this;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
	public FundTransferPage userLogOut() throws InterruptedException {
		System.out.println("Logout the User");
		Thread.sleep(2000);
		clickByXpath("(//span[contains(text(), 'Logout')])[2]");
		return this;
	}
}
