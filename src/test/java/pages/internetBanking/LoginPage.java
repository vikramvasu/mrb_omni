package  pages.internetBanking;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

public class LoginPage extends wrappers.ProjectWrappers  {
	
	public static String SetForgotPassword;
	public static String LoginDebitCardNumber;
	
	public LoginPage(RemoteWebDriver driver, ExtentTest test)throws Exception{
		this.driver = driver;
		this.test = test;
//		openQAApplication();
		openQAIBApplication();
	}
	
	public LoginPage loginUsingSMS() throws InterruptedException {
		enterUserName()
		.enterPassword()
		.clickSignInBtn()
		.select2FAType("SMS OTP")
		.enterSMSOTP()
		.clickSubmitBtn2FAPage();
		return this;
	}
	
	public LoginPage loginUsingDebitCard() throws InterruptedException {
		enterUserName()
		.enterPassword()
		.clickSignInBtn()
		.select2FAType("Debit Card")
		.enterDebitCardNumber("3211351918895246")
		.enterDebitCardPin()
		.clickSubmitBtn2FAPage();
		return this;
	}
	
	public LoginPage verifyLoginToIBHeading()
	{
		System.out.println("Verify Login To IB Heading");
		verifyElementisPresentById("login_label_internetbanking", "Login to Internet Banking Heading");
		verifyTextById("login_label_internetbanking", "Login to Internet Banking");
		return this;
	}	

	public LoginPage verifyUsernameHeading()
	{
		System.out.println("Verify Username Heading");
		verifyElementisPresentById("login_label_username", "Username Heading");
		verifyTextById("login_label_username", "Username");
		return this;
	}	

	public LoginPage enterUserName() throws InterruptedException{
		System.out.println("Enter the User Name");
		Thread.sleep(3000);
		enterByXpath("(//input[@placeholder='Enter'])[1]", "autouser111");
//		enterByXpath("(//input[@placeholder='Enter'])[1]", "debituser23");
		return this;
	}
	
	public LoginPage enterUserName(String uname) throws InterruptedException{
		System.out.println("Enter the User Name");
		Thread.sleep(3000);
		enterByXpath("(//input[@placeholder='Enter'])[1]", uname);
		return this;
	}
	
	public LoginPage enterForgotPasswordUserName(String name){
		System.out.println("Enter Forgot Password User Name");
		enterByXpath("//input[@formcontrolname='username']", name);
		return this;
	}
	
	public LoginPage enterIncorrectUserName(){
		System.out.println("Enter the User Name");
		enterByXpath("//input[@formcontrolname='username']", "abcdef");
		return this;
	}
	
	public LoginPage verifyUserNameMandatoryMsg() {
		System.out.println("Verify UserName Mandatory Msg");
		verifyTextById("login_error_username", "Username is mandatory");
		return this;
	}
	
	public LoginPage verifyPasswordHeading()
	{
		System.out.println("Verify Password Heading");
		verifyElementisPresentById("login_label_password", "Password Heading");
		verifyTextById("login_label_password", "Password");
		return this;
	}
	
	public LoginPage enterPassword(){
		System.out.println("Enter the Password");
		enterByXpath("(//input[@placeholder='Enter'])[2]", "Password12");
//		enterByXpath("(//input[@placeholder='Enter'])[2]", "Qwerty789");
		return this;
	}
	
	public LoginPage enterPassword(String pwd){
		System.out.println("Enter the Password");
		enterByXpath("(//input[@placeholder='Enter'])[2]", pwd);
		return this;
	}
	
	public LoginPage verifyandClickPasswordEyeIcon() throws InterruptedException{
		System.out.println("Verify Password Eye Icon");
		Thread.sleep(2000);
		verifyElementisPresent("//span[@class='mxPassword pwdShow']", "Password Eye Icon");
		System.out.println("Click Password Eye Icon");
		clickByXpath("//span[@class='mxPassword pwdShow']");
		return this;
	}
	
	public LoginPage enterIncorrectPassword(){
		System.out.println("Enter the Password");
		enterById("login_input_password", "123456");
		return this;
	}
	
	public LoginPage enterPasswordForForgotPwd() throws InterruptedException{
		System.out.println("Enter the Password for Forgot Pwd");
		Thread.sleep(2000);
		SetForgotPassword = enterByXpathWithRandomNumber("//input[@formcontrolname='psw']", "Password");
		objprop("SetForgotPassword", SetForgotPassword);
		return this;
	}
	
	public LoginPage enterForgotPwdConfirmPassword(){
		System.out.println("Enter the Forgot Pwd Confirm Password");
		enterByXpath("//input[@formcontrolname='confirmPsw']", SetForgotPassword);
//		enterByXpath("//input[@formcontrolname='confirmPsw']", getobjprop("SetForgotPassword"));
		return this;
	}
	
	public LoginPage verifyPasswordChangedSuccessMessage() throws InterruptedException {
		System.out.println("Verify Password changed Success Message");
		waitForLoad();
		Thread.sleep(2000);
		verifyTextByXpath("//*[contains(text(),'Password changed successfully.')]", "Success! Password changed successfully.");
		return this;
	}
	
	public LoginPage verifyPasswordMandatoryMsg() {
		System.out.println("Verify Password Mandatory Msg");
		verifyTextById("login_error_password", "Password is mandatory");
		return this;
	}
	
	public LoginPage verifyTakeMeDirectlyToHeading()
	{
		System.out.println("Verify Take Me Directly To Heading");
		verifyElementisPresent("//mat-select[@formcontrolname='directTo']", "Take Me Directly To Heading");
//		verifyTextByXpath("//mat-select[@formcontrolname='directTo']", "Take Me Directly To");
		return this;
	}	
		
	public LoginPage takeMeDirectlyTo(String page)
	{
		System.out.println("Select any one take me directly option");
		clickByXpath("//mat-select[@formcontrolname='directTo']");
	    clickByXpath("//span[@class='mat-option-text'][contains(text(),'"+page+"')]");
//	    clickById("login_select_Dashboard");
//	    clickById("login_select_Manage Cards");    
		return this;
	}
	
	public LoginPage clickForgotUsername() throws InterruptedException
	{
		System.out.println("Click Forgot Username");
		Thread.sleep(2000);
		clickByXpath("//span[contains(text(),'Username')]");
		return this;
	}
	
	public LoginPage selectRegisterType(String type)
	{
		System.out.println("Select Register Type");
		if(type.equalsIgnoreCase("account")) {
			clickByXpath("//div[contains(text(),'With account details')]");
		}
		else if(type.equalsIgnoreCase("credit")) {
			clickByXpath("//div[contains(text(),'With credit card details')]");
		}
		else if(type.equalsIgnoreCase("debit")) {
			clickByXpath("//div[contains(text(),'With debit card details')]");
		}
		return this;
	}
	
	public LoginPage selectAccountType(String type) throws InterruptedException
	{
		System.out.println("Select Account Type");
		clickByXpath("//div//span[text()='Select']");
		if(type.equalsIgnoreCase("casa")) {
			clickByXpath("//span[@class='mat-option-text'][contains(text(),'Current or Savings')]");
			Thread.sleep(2000);
		}
		else if(type.equalsIgnoreCase("deposit")) {
			clickByXpath("//span[@class='mat-option-text'][contains(text(),'Deposit')]");
			Thread.sleep(2000);
		}
		else if(type.equalsIgnoreCase("loan")) {
			clickByXpath("//span[@class='mat-option-text'][contains(text(),'Loan')]");
			Thread.sleep(2000);
		}
		return this;
	}
	
	public LoginPage enterAccountNumber(String AccNum)
	{
		System.out.println("Enter Account Number");
		enterByXpath("//input[@formcontrolname='an']", AccNum);
		return this;
	}
	
	public LoginPage enterAccountNumber()
	{
		System.out.println("Enter Account Number");
		enterByXpath("//input[@formcontrolname='an']", getobjprop("RegistrationAccountNumber"));
		objprop("LoginAccountNumber", getobjprop("RegistrationAccountNumber"));
		return this;
	}
	
	public LoginPage selectDOB(String Date, String Month, String Year)
	{
		System.out.println("Select DOB");
		clickByXpath("//mat-icon[contains(text(),'date_range')]");
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
	
	public LoginPage verifyForgotUserNameSuccessMessage() throws InterruptedException {
		System.out.println("Verify Forgot User Name Success Message");
		waitForLoad();
		Thread.sleep(5000);
		String Message = getTextByXpath("//h3[contains(text(),'Success ! Username sent successfully')]");
		verifyTextByText(Message, "Success ! Username sent successfully");
//		reportStep(Message, "PASS");
		return this;
	}
	
	public LoginPage enterCreditCardNumber(String CreditNum)
	{
		System.out.println("Enter Credit Card Number");
		enterByXpath("//input[@formcontrolname='cn']", CreditNum);
		return this;
	}
	
	public LoginPage enterCreditCardNumber()
	{
		System.out.println("Enter Credit Card Number");
		enterByXpath("//input[@formcontrolname='cn']", getobjprop("RegistrationCreditCardNumber"));
		objprop("LoginCreditCardNumber", getobjprop("RegistrationCreditCardNumber"));
		return this;
	}
	
	public LoginPage selectCardExpiryDate(String Month, String Year)
	{
		System.out.println("Select Credit Card Expiry Date");
		clickByXpath("//input[@formcontrolname='ed']");
		clickByXpath("//div[@class='dropdowns ng-star-inserted'][2]");
		clickByXpath("//span[@class='mat-option-text'][contains(text(),'"+Year+"')]");
		clickByXpath("//div[@class='dropdowns ng-star-inserted'][1]");
		clickByXpath("//span[@class='mat-option-text'][contains(text(),'"+Month+"')]");
		return this;
	}
	
	public LoginPage enterCreditCardCVV()
	{
		System.out.println("Enter Credit Card CVV");
		enterByXpath("(//input[@formcontrolname='input'])[1]", "1");
		enterByXpath("(//input[@formcontrolname='input'])[2]", "2");
		enterByXpath("(//input[@formcontrolname='input'])[3]", "3");
		return this;
	}
	
	public LoginPage enterDebitCardNumber(String DebNum)
	{
		System.out.println("Enter Debit Card Number");
		enterByXpath("//input[@formcontrolname='cn']", DebNum);
		return this;
	}
	
	public LoginPage enterDebitCardNumber()
	{
		System.out.println("Enter Debit Card Number");
		enterByXpath("//input[@formcontrolname='cn']", getobjprop("RegistrationDebitCardNumber"));
		objprop("LoginDebitCardNumber", getobjprop("RegistrationDebitCardNumber"));
		return this;
	}
	
	public LoginPage enterDebitCardPin()
	{
		System.out.println("Enter Debit Card Pin");
		enterByXpath("(//input[@formcontrolname='input'])[1]", "1");
		enterByXpath("(//input[@formcontrolname='input'])[2]", "2");
		enterByXpath("(//input[@formcontrolname='input'])[3]", "3");
		enterByXpath("(//input[@formcontrolname='input'])[4]", "4");
		return this;
	}
	
	public LoginPage verifyForgotPassword()
	{
		System.out.println("Verify Forgot Password");
		verifyElementisPresent("//span[contains(text(),'Password')]", "Forgot Password");
		return this;
	}
	
	public LoginPage clickForgotPassword() throws InterruptedException
	{
		System.out.println("Click Forgot Password");
		Thread.sleep(2000);
		clickByXpath("//span[contains(text(),'Password')]");
		return this;
	}
	
	public LoginPage clickForgotPasswordNextBtn()
	{
		System.out.println("Click Forgot Password Next button");
//		clickByXpath("//button/span[text()='Next']");
		clickById("forgotpassword_button_next");
		return this;
	}
	
	public LoginPage selectAuthTypeForgotPassword(String auth)
	{
		System.out.println("select Auth Type for Forgot Password");
		clickByXpath("//div[contains(text(),'"+auth+"')]");
//		clickById("login_select_'"+auth+"')]");
		return this;
	}
	
	public LoginPage selectForgotPasswordDOB(String Date, String Month, String Year)
	{
		System.out.println("Select Forgot Password DOB");
		clickById("shared_creditcard_input_daterange");
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
		
	public LoginPage verifySignInBtn()
	{
		System.out.println("Verify Sign In button");
		verifyElementisPresentById("login_button_login", "Sign In");
		return this;
	}
		
	public LoginPage clickSignInBtn()
	{
		System.out.println("Click Sign In button");
		clickByXpath("//button[@type='submit']");
		return this;
	}
	
	public LoginPage verifyInvalidUserIDorPasswordErrorMsg() {
		System.out.println("Verify Invalid UserID or Password Error Msg");
		verifyTextById("login_hint_username", "Invalid user ID or password. You are left with four more attempts.");
		return this;
	}
	
	public LoginPage verifyAccountLockedMsg() {
		System.out.println("Verify Account Locked Msg");
		verifyTextById("login_label_AccountLocked", "Your user account has been locked. Please contact bank administator.");
		return this;
	}
	
	public LoginPage verifyCoolingPeriodEnabledErrorMsg() {
		System.out.println("Verify Cooling Period Enabled Error Msg");
		verifyTextById("login_label_Cooling_Period_Enabled", "Cooling Period is not over. Please try to login after Cooling Period.");
		return this;
	}
		
	public LoginPage verifyOTACHeading()
	{
		System.out.println("Verify OTAC Heading");
//		verifyElementisPresent("//h3[contains(text(),'One Time Authentication Code')]", "One Time Authentication Code Heading");
		verifyElementisPresentById("FirstTimeLogin_label_One_Time_Authentication_Code", "One Time Authentication Code Heading");
//		verifyTextByXpath("//h3[contains(text(),'One Time Authentication Code')]", "One Time Authentication Code");
		verifyTextById("FirstTimeLogin_label_One_Time_Authentication_Code", "One Time Authentication Code");
		return this;
	}	
	
	public LoginPage verifyOTACSentToEmailMsg()
	{
		System.out.println("Verify OTAC sent to Email Msg");
		verifyElementisPresentById("FirstTimeLogin_label_For your security, we have sent a one time Activation code to your registered email id", "OTAC to email message");
		verifyTextById("FirstTimeLogin_label_For your security, we have sent a one time Activation code to your registered email id", "For your security, we have sent a one time Activation code to your registered email id");
		return this;
	}
	
	public LoginPage verifyEnterAuthCodeLabel()
	{
		System.out.println("Verify OTAC Auth Code Label");
		verifyElementisPresentById("FirstTimeLogin_label_Enter_Authentication_Code", "Auth Code Label");
		verifyTextById("FirstTimeLogin_label_Enter_Authentication_Code", "Enter Authentication Code");
		return this;
	}
	
	public LoginPage entertOTACAuthCode()
	{
		System.out.println("Verify Incorrect OTAC Auth Code");
		enterById("FirstTimeLogin_input_authCode", "123456");
		return this;
	}
	
	public LoginPage enterExpiredOTACAuthCode(String AuthCode)
	{
		System.out.println("Verify Expired OTAC Auth Code");
		enterById("FirstTimeLogin_input_Expired_authCode", AuthCode);
		return this;
	}
	
	public LoginPage enterIncorrectOTACAuthCode(String AuthCode)
	{
		System.out.println("Verify Incorrect OTAC Auth Code");
		enterById("FirstTimeLogin_input_Incorrect_authCode", AuthCode);
		return this;
	}
	
	public LoginPage clickNextBtn()
	{
		System.out.println("Click Next button");
		clickByXpath("//button/span[text()='Next']");
		return this;
	}	
		
	public LoginPage verifyExpiredOTACErrorMsg() {
		verifyTextById("FirstTimeLogin_label_Expired_OTAC", "Expired OTAC. OTAC has expired. Please contact bank adminstrator");
		return this;
	}
	
	public LoginPage verifyOTACUnsuccessfulAttemptsErrorMsg() {
		verifyTextById("FirstTimeLogin_label_OTAC_Unsuccessful_Attempts", "Incorrect OTAC. You have only 3 more attempts pending");
		return this;
	}
		
	public LoginPage verifyAuthenticationHeading()
	{
		System.out.println("Verify Authentication Heading");
		verifyElementisPresent("shared_login_2fa_label_authentication", "Authentication Heading");
		verifyTextById("shared_login_2fa_label_authentication", "Authentication");
		return this;
	}
	
	public LoginPage select2FAType(String auth)
	{
		System.out.println("Select 2FA Type");
		clickByXpath("//div//span[contains(text(),'Select')]");
	    clickByXpath("//span[@class='mat-option-text'][contains(text(),'"+auth+"')]");
		return this;
	}
	
	public LoginPage enterSMSOTP() throws InterruptedException
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
	
	public LoginPage verifyFieldsInCCDetailsPage()
	{
		System.out.println("Verify the Fields in the Credit Card Details");
		verifyElementisPresentById("shared_creditcard_input_cardno", "Credit Card Number Input");
		verifyElementisPresent("(//input[@formcontrolname='input'])[1]", "CVV Input");
//		verifyElementisPresentById("registration_input_card_expiry", "Card Expiry Input");
		verifyElementisPresentById("shared_creditcard_input_daterange", "DOB Input");
//		verifyElementisPresentById("registration_input_card_limit", "Credit Card Limit Input");
		verifyElementisPresentById("shared_creditcard_button_next", "Next Button");		
		return this;
	}
	
	public LoginPage clickCreditCardNumber()
	{
		System.out.println("Click Credit Card Number");
		clickById("shared_creditcard_input_cardno");
		return this;
	}
		
	public LoginPage enterIncorrectCreditCardCVV()
	{
		System.out.println("Enter Credit Card CVV");
		enterByXpath("(//input[@formcontrolname='input'])[1]", "3");
		enterByXpath("(//input[@formcontrolname='input'])[2]", "2");
		enterByXpath("(//input[@formcontrolname='input'])[3]", "1");
		return this;
	}
	
	public LoginPage verifyCreditCardCVVLimit()
	{
		System.out.println("Verify Credit Card CVV Limit");
		verifyElementisPresentById("(//input[@formcontrolname='input'])[1]", "CVV Input 1");
		verifyElementisPresentById("(//input[@formcontrolname='input'])[2]", "CVV Input 2");
		verifyElementisPresentById("(//input[@formcontrolname='input'])[3]", "CVV Input 3");
		return this;
	}
	
	public LoginPage blankCardExpiryDate()
	{
		System.out.println("Blank Credit Card Expiry Date");
//		clickByXpath("(//mat-icon[contains(text(),'date_range')])[1]");
		clickById("login_input_card_expiry");
		clickEscapeButton();
		return this;
	}
	
	public LoginPage verifyCardExpiryDate()
	{
		System.out.println("verify Card Expiry Date Format");
		verifyElementisPresentById("registration_input_card_expiry", "DOB Input");
		String ExpiryDate = getTextById("registration_input_card_expiry");
		verifyTextById("registration_input_card_expiry", ExpiryDate);		
		return this;
	}
		
	public LoginPage verifyCreditCardEmptyErrorMsg() {
		verifyTextByXpath("//mat-error[contains(text(),'Credit card number is mandatory')]", "Credit card number is mandatory");
		return this;
	}

	public LoginPage verifyCVVEmptyErrorMsg() {
//		verifyTextByXpath("//mat-error[contains(text(),'CVV is mandatory')]", "CVV is mandatory");
		verifyTextById("login_label_CVV_is_mandatory", "CVV is mandatory");
		return this;
	}
	
	public LoginPage verifyCreditCardInvalidErrorMsg() {
		System.out.println("Verify Credit Card Invalid Error Msg");
		verifyTextByXpath("//h2[contains(text(),'Invalid credit Card details')]", "Invalid credit Card details");
		clickOKbtn();
		return this;
	}
	
	public LoginPage verifyExpiryDateEmptyErrorMsg() {
//		verifyTextByXpath("//mat-error[contains(text(),'Expiry Date is mandatory')]", "Expiry Date is mandatory");
		verifyTextById("login_label_Expiry_Date_is_mandatory", "Expiry Date is mandatory");
		return this;
	}
	
	public LoginPage clickResendCodeLink()
	{
		System.out.println("Click Resend Code Link");
		clickById("shared_login_2fa_label_resendcode");
		return this;
	}
	
	public LoginPage verifyResendCodeLink()
	{
		System.out.println("Verify Resend Code Link");
		verifyElementisPresentById("shared_login_2fa_label_resendcode", "Resend Code");
		verifyTextById("shared_login_2fa_label_resendcode", "Resend code");
		return this;
	}
		
	public LoginPage clickSubmitBtn2FAPage()
	{
		System.out.println("Click Submit button");
		clickByXpath("//button/span[contains(text(),'Submit')]");
//		clickById("shared_login_2fa_button_submitotp");
		return this;
	}
	
	public LoginPage verifyDashboardTitle() throws InterruptedException
	{
		System.out.println("Verify Dashboard title");
		Thread.sleep(4000);
		verifyElementisPresent("//span[contains(text(), 'Dashboard')]", "Dashboard");
		return this;
	}
	
	public LoginPage clickSubmitBtn()
	{
		System.out.println("Click Submit button");
		clickByXpath("//button/span[contains(text(),'Submit')]");
//		clickById("login_button_submit");
		return this;
	}
	
	public LoginPage clickCancelBtn()
	{
		System.out.println("Click Cancel button");
//		clickByXpath("//button/span[text()='Cancel']");
		clickById("shared_login_2fa_button_cancel");
		return this;
	}
	
	public LoginPage verifyNotesTextArea()
	{
		System.out.println("Verify Notes Text area");
//		verifyElementisPresent("//h2[contains(text(),'Notes')]", "Notes");
		verifyElementisPresentById("login_label_note", "Notes");
//		verifyTextByXpath("//h2[contains(text(),'Notes')]", "Notes");
		verifyTextById("login_label_note", "Notes");
		return this;
	}
	
	public LoginPage verifyCaneclPopUp()
	{
		System.out.println("Verify Canecl Pop Up");
		verifyElementisPresent("//p[contains(text(),'Are you sure you want to discard the changes?')]", "Cancel Pop Up");
		verifyTextByXpath("//p[contains(text(),'Are you sure you want to discard the changes?')]", "Are you sure you want to discard the changes?");
		return this;
	}
	
	public LoginPage clickYesbtn() {
		System.out.println("Click YES button");
		clickByXpath("//button/span[text()=' Yes ']");
		return this;
	}
	
	public LoginPage clickOKbtn() {
		System.out.println("Click OK button");
		clickByXpath("//button/span[contains(text(),'OK')]");
//		clickById("login_button_OK");
		return this;
	}
	
	public LoginPage clickEscapeButton()
	{
		System.out.println("Click Escape Button");
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ESCAPE).build().perform();
		return this;
	}
	
	public LoginPage userLogOut() throws InterruptedException {
		System.out.println("Logout the User");
		Thread.sleep(2000);
		clickByXpath("(//span[contains(text(), 'Logout')])[2]");
		return this;
	}
}
