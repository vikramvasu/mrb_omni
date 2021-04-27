package  pages.internetBanking;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

public class BillPaymentsPage extends wrappers.ProjectWrappers  {
		
	public BillPaymentsPage(RemoteWebDriver driver, ExtentTest test)throws Exception{
		this.driver = driver;
		this.test = test;
		openQAIBApplication();
	}
	
	public BillPaymentsPage loginUsingSMS() throws InterruptedException {
		enterUserName()
	  	.enterPassword()
	  	.takeMeDirectlyTo("Dashboard")
	  	.clickSignInBtn()
	  	.select2FAType("SMS OTP")
	  	.enterSMSOTP()
	  	.clickSubmitBtn2FAPage();
		return this;
	}
		
	public BillPaymentsPage clickUserName() throws InterruptedException{
		System.out.println("Click the User Name");
		Thread.sleep(3000);
		clickById("login_input_username");
		return this;
	}
	
	public BillPaymentsPage enterUserName() throws InterruptedException{
		System.out.println("Enter the User Name");
		Thread.sleep(3000);
		enterByXpath("(//input[@placeholder='Enter'])[1]", "vikram444");
		return this;
	}
	
	public BillPaymentsPage clickPassword(){
		System.out.println("Click the Password");
		clickById("login_input_password");
		return this;
	}
	
	public BillPaymentsPage enterPassword(){
		System.out.println("Enter the Password");
		enterByXpath("(//input[@placeholder='Enter'])[2]", "Password12");
		return this;
	}
	
	public BillPaymentsPage takeMeDirectlyTo(String page)
	{
		System.out.println("Select any one take me directly option");
		clickByXpath("//mat-select[@formcontrolname='directTo']");
	    clickByXpath("//span[@class='mat-option-text'][contains(text(),'"+page+"')]");
		return this;
	}

	public BillPaymentsPage clickSignInBtn()
	{
		System.out.println("Click Sign In button");
		clickByXpath("//button[@type='submit']");
		return this;
	}
		
	public BillPaymentsPage clickNextBtn()
	{
		System.out.println("Click Next button");
		clickByXpath("//button/span[text()='Next']");
		return this;
	}	
	
	public BillPaymentsPage select2FAType(String auth)
	{
		System.out.println("Select 2FA Type");
		clickByXpath("//div//span[contains(text(),'Select')]");
	    clickByXpath("//span[@class='mat-option-text'][contains(text(),'"+auth+"')]");
		return this;
	}
	
	public BillPaymentsPage enterSMSOTP() throws InterruptedException
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

	public BillPaymentsPage clickResendCodeLink()
	{
		System.out.println("Click Resend Code Link");
		clickByXpath("//span[contains(text(),'Resend code')]");
		return this;
	}
	
	public BillPaymentsPage clickSubmitBtn2FAPage()
	{
		System.out.println("Click Submit button");
		clickByXpath("//button/span[contains(text(),'Submit')]");
		return this;
	}
	
	public BillPaymentsPage verifyDashboardTitle() throws InterruptedException
	{
		System.out.println("Verify Dashboard title");
		Thread.sleep(4000);
		verifyElementisPresent("//span[contains(text(), 'Dashboard')]", "Dashboard");
		return this;
	}
	
	public BillPaymentsPage clickTransfersTab() throws InterruptedException
	{
		System.out.println("Click Transfers Tab");
		clickByXpath("//span[contains(text(),'Transfers')]");
		Thread.sleep(4000);
		return this;
	}

	public BillPaymentsPage selectTransferType(String type)
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
	
	public BillPaymentsPage selectPaymentCurrency(String Currency)
	{
		System.out.println("Select Payment Currency");
		clickByXpath("//mat-select[@formcontrolname='paymentcurrency']");
	    clickByXpath("//span[@class='mat-option-text'][contains(text(),'"+Currency+"')]");
		return this;
	}
	
	public BillPaymentsPage enterPaymentAmount() throws InterruptedException
	{
		System.out.println("Enter Payment Amount");
		enterByXpath("//input[@placeholder='Payment Amount']", "100");	
		return this;
	}
	
	public BillPaymentsPage clickPaymentWhen(String When) throws InterruptedException
	{
		System.out.println("Click Payment When");
		clickByXpath("//button/div[contains(text(),'"+When+"')]");
		return this;
	}
		
	public BillPaymentsPage clickConfirmBtn()
	{
		System.out.println("Click Confirm button");
		clickByXpath("//button/span[text()='Confirm & Transfer']");
		return this;
	}	
	
	public BillPaymentsPage verifyFundTransferSuccessMessage() throws InterruptedException {
		System.out.println("Verify Fund Transfer Success Message");
		waitForLoad();
		Thread.sleep(4000);
		String Message = getTextByXpath("//h3[contains(text(),'Your request for Fund Transfer submitted successfully')]");
		verifyTextByXpath("//h3[contains(text(),'Your request for Fund Transfer submitted successfully')]", Message);
		return this;
	}

	public BillPaymentsPage clickSubmitBtn()
	{
		System.out.println("Click Submit button");
		clickByXpath("//button/span[contains(text(),'Submit')]");
		return this;
	}
	
	public BillPaymentsPage clickCancelBtn()
	{
		System.out.println("Click Cancel button");
		clickByXpath("//button/span[text()='Cancel']");
		return this;
	}
	
	public BillPaymentsPage verifyCaneclPopUp()
	{
		System.out.println("Verify Canecl Pop Up");
		verifyElementisPresent("//p[contains(text(),'Are you sure you want to discard the changes?')]", "Cancel Pop Up");
		verifyTextByXpath("//p[contains(text(),'Are you sure you want to discard the changes?')]", "Are you sure you want to discard the changes?");
		return this;
	}
	
	public BillPaymentsPage clickYesbtn() {
		System.out.println("Click YES button");
		clickByXpath("//button/span[contains(text(),'Yes')]");
		return this;
	}
	
	public BillPaymentsPage clickOKbtn() {
		System.out.println("Click OK button");
		clickByXpath("//button/span[contains(text(),'OK')]");
		return this;
	}
	
	public BillPaymentsPage clickEscapeButton()
	{
		System.out.println("Click Escape Button");
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ESCAPE).build().perform();
		return this;
	}
	
	public BillPaymentsPage enterRemarks() 
	{
		System.out.println("Enter Remarks");
		enterByXpath("//*[@formcontrolname='remarks']", "test");	
		return this;
	}
	
	
	public BillPaymentsPage clickNextButton()
	{
		System.out.println("Click Next Button");
		clickByXpath("//span[contains(text(),'Next')]/parent::button");
		return this;
	}
	
	
	public BillPaymentsPage clickBillPaymentsButton()
	{
		System.out.println("Click Bill Payments Button");
		clickByXpath("//span[contains(text(),'Bill Payments')]");
		return this;
	}
	
	public BillPaymentsPage cliclAddBillerButton()
	{
		System.out.println("Click Add Biller Button");
		clickByXpath("//div[contains(text(),'Add Biller')]");
		return this;
	}
	
	public BillPaymentsPage clickScheduledBillerButton()
	{
		System.out.println("Click Schedule Biller Button");
		clickByXpath("//div[contains(text(),'Scheduled Billers')]");
		return this;
	}
	
	// Add Biller Flow
	
	public BillPaymentsPage selectBillerCategory(String billerCategory)
	{
		System.out.println("Select Biller Category");
		clickByXpath("//input[@role='combobox']");
		clickByXpath("//span[contains(text(),'"+billerCategory+"')]");
		
		return this;
	}
	
	public BillPaymentsPage selectBillerName(String billerName)
	{
		System.out.println("Select Biller Name");
		clickByXpath("(//div[contains(text(),'Select')]/parent::div/parent::div/parent::ng-select[@role='listbox'])[2]");
		clickByXpath("//div[contains(text(),'"+billerName+"')]");
		
		return this;
	}
	
	public BillPaymentsPage enterNickName() throws InterruptedException{
		System.out.println("Enter Nick Name");
		Thread.sleep(3000);
		enterByXpath("//input[@appinputtype='alphaNumericWS']", "Diljith");
		return this;
	}
	
	public BillPaymentsPage clickBillerCategory()
	{
		System.out.println("Click Biller Category");
		clickByXpath("//span[contains(text(),'Biller Category')]");
		return this;
	}
	
	public BillPaymentsPage verifyAddBillerSuccessMessage()  {
		System.out.println("Verify Add Biller Success Message");
		verifyElementisPresent("//*[contains(text(),'Success ! Biller Added Successfully!')]", "Success ! Biller Added Successfully!");
		return this;
	}
	
	public BillPaymentsPage clickBillPaymentsDropdown()
	{
		System.out.println("Click Bill Payments Drop Down");
		clickByXpath("(//span[contains(text(),'Bill Payments')]/parent::a/child::span)[2]");
		return this;
	}
	
	public BillPaymentsPage clickPayBills()
	{
		System.out.println("Click Pay Bills");
		clickByXpath("//span[contains(text(),'Pay Bills')]");
		return this;
	}
	
	public BillPaymentsPage clickAdhocBillPayment()
	{
		System.out.println("Click Adhoc Bill Payment");
		clickByXpath("//span[contains(text(),'Adhoc Bill Payment')]");
		return this;
	}
	
	public BillPaymentsPage clickRecentTransactions()
	{
		System.out.println("Click Recent Transactions");
		clickByXpath("//span[contains(text(),'Recent Transactions')]");
		return this;
	}
	
	public BillPaymentsPage clickPayLink()
	{
		System.out.println("Click Pay Link");
		// Click the First Pay link
		clickByXpath("(//div[starts-with(@class,'mx-rb-action')]/span/span[contains(text(),'Pay')])[1]");
		return this;
	}
	
	public BillPaymentsPage clickPaymentType()
	{
		System.out.println("Click Payment Type");
		clickByXpath("//*[contains(text(),'Payment Type')]/following::mx-debit-payment-method/div/ng-select");
		return this;
	}
	
	public BillPaymentsPage selectBillPaymentCurrency(String Currency)
	{
		System.out.println("Select Bill Payments Payment Currency");
		clickByXpath("//*[@formcontrolname='currency']");
		clickByXpath("//span[contains(text(),'"+Currency+"')]");
		return this;
	}
	
	public BillPaymentsPage verifyBillPaymentSuccessMessage()  {
		System.out.println("Verify Bill Payment Success Message");
		verifyElementisPresent("//*[contains(text(),'Success ! Your request for payment submitted successfully.')]", "Success ! Your request for payment submitted successfully.");
		return this;
	}
	
	public BillPaymentsPage clickConfirmPayBtn()
	{
		System.out.println("Click Confirm & Pay button");
		clickByXpath("//span[contains(text(),'Confirm & Pay')]");
		return this;
	}
	
	// Recurring Flow
	public BillPaymentsPage enterPaymentInstallments() 
	{
		System.out.println("Enter Payment Installments");
		enterByXpath("//*[@formcontrolname='PaymentInstallments']", "1");	
		return this;
	}
	
	public BillPaymentsPage clickPaymentFrequency()
	{
		System.out.println("Click Payment Frequency");
		clickByXpath("//*[@formcontrolname='PaymentFrequency']");
		return this;
	}
	
	public BillPaymentsPage selectPaymentFrequencyTime(String paymentTime)
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
	
	public BillPaymentsPage clickOneTimeOption()
	{
		System.out.println("Click One Time Option");
		clickByXpath("//div[contains(text(),'One Time')]");
		return this;
	}
	
	public BillPaymentsPage clickRecurringOption()
	{
		System.out.println("Click Recurring Option");
		clickByXpath("//div[contains(text(),'Recurring')]");
		return this;
	}
	
	public BillPaymentsPage clickLaterOption()
	{
		System.out.println("Click Later Option");
		clickByXpath("//div[contains(text(),'Later')]");
		return this;
	}
	
	public BillPaymentsPage enterScheduleDate(String scheduleDate) throws InterruptedException{
		System.out.println("Enter Schedule Date");
		Thread.sleep(3000);
		enterByXpath("//input[@formcontrolname='scheduleDate']", scheduleDate);
		return this;
	}
	
	//Labels
	
	public BillPaymentsPage verifyBillerNameLabel()  {
		System.out.println("Verify Biller Name Label ");
		verifyElementisPresent("//span[contains(text(),'Biller Name')]", "Biller Name");
		return this;
	}
	
	public BillPaymentsPage verifyPaymentMethodLabel()  {
		System.out.println("Verify Payment Method Label ");
		verifyElementisPresent("//span[contains(text(),'Payment Method')]", "Payment Method");
		return this;
	}
	
	public BillPaymentsPage verifyPaymentDateLabel()  {
		System.out.println("Verify Payment Date Label ");
		verifyElementisPresent("//span[contains(text(),'Payment Date')]", "Payment Date");
		return this;
	}
	
	public BillPaymentsPage verifyPaymentTypeLabel()  {
		System.out.println("Verify Payment Type Label ");
		verifyElementisPresent("//span[contains(text(),'Payment Type')]", "Payment Type");
		return this;
	}
	
	public BillPaymentsPage verifyWhenLabel()  {
		System.out.println("Verify When Label");
		verifyElementisPresent("//span[contains(text(),'When')]", "When");
		return this;
	}
	
	public BillPaymentsPage verifyMobileNumberLabel()  {
		System.out.println("Verify Mobile Number Label ");
		verifyElementisPresent("//span[contains(text(),'Mobile Number')]", "Mobile Number");
		return this;
	}
	
	// Schedule Payments
	
	public BillPaymentsPage clickViewLink()
	{
		System.out.println("Click View Link");
		clickByXpath("//span[contains(text(),'View')]");
		return this;
	}
	
	public BillPaymentsPage clickStopLink()
	{
		System.out.println("Click Stop Link");
		clickByXpath("//span[contains(text(),'Stop')]");
		return this;
	}
	
	public BillPaymentsPage clickRescheduleLink()
	{
		System.out.println("Click Reschedule Link");
		clickByXpath("//span[contains(text(),'Reschedule')]");
		return this;
	}
	
	public BillPaymentsPage clickRescheduleButton()
	{
		System.out.println("Click Reschedule Button");
		clickByXpath("//span[contains(text(),'Reschedule Payment')]");
		return this;
	}
	
	public BillPaymentsPage clickBackButton()
	{
		System.out.println("Click Back Button");
		clickByXpath("//span[contains(text(),'Back')]");
		return this;
	}
	
	public BillPaymentsPage clickBackHomeButton()
	{
		System.out.println("Click Back Home Button");
		clickByXpath("//*[contains(text(),'Back Home')]");
		return this;
	}
	
	// stop the Recurring Payment
	public BillPaymentsPage selectStopPaymentCheckbox(String stopPaymentCheckbox)
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
	
	public BillPaymentsPage verifyPaymentStoppedMessage()  {
		System.out.println("Verify Payment Stopped Message ");
		verifyElementisPresent("//*[contains(text(),'Success! Your payment has been stopped.')]", "Success! Your payment has been stopped.");
		return this;
	}
	
	public BillPaymentsPage verifySchedulePaymentSuccessMessage()  {
		System.out.println("Verify Schedule Payment Success Message ");
		verifyElementisPresent("//*[contains(text(),'Success! The changes in your scheduled payment has been updated successfully. ')]", "Success! The changes in your scheduled payment has been updated successfully.");
		return this;
	}
	
	
	public BillPaymentsPage userLogOut() throws InterruptedException {
		System.out.println("Logout the User");
		Thread.sleep(2000);
		clickByXpath("(//span[contains(text(), 'Logout')])[2]");
		return this;
	}
}
