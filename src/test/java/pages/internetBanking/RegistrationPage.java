package  pages.internetBanking;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

public class RegistrationPage extends wrappers.ProjectWrappers  {
	
	public static String reference;
	public static String RegistrationUserName;	
	public static String RegistrationPassword;
	public static String RegistrationCreditCardNumber;
	public static String RegistrationAccountNumber;
	public static String RegistrationDebitCardNumber;
	
	
	public RegistrationPage(RemoteWebDriver driver, ExtentTest test)throws Exception{
		this.driver = driver;
		this.test = test;
//		openQAApplication();
		openQAIBApplication();
	}
	
	public RegistrationPage verifyRegisterNowBtn()
	{
		System.out.println("Verify Register Now button");
		verifyElementisPresent("//button//span[contains(text(), 'Register')]", "Register Now button");
		return this;
	}
	
	public RegistrationPage clickRegisterNowBtn() throws InterruptedException
	{
		System.out.println("Click Register Now button");
		waitForLoad();
		Thread.sleep(6000);
		clickByXpath("//button//span[contains(text(), 'Register')]");
		return this;
	}
	
	public RegistrationPage verifyRegisterScreenHeading()
	{
		System.out.println("Verify T&C Heading");
		driver.switchTo().frame(0);
		verifyElementisPresent("//h1[contains(text(),'Terms')]", "Terms & Conditions");
		verifyTextByXpath("//h1[contains(text(),'Terms')]", "Terms & Conditions");
		return this;
	}
	
	public RegistrationPage verifyTnCTitle()
	{
		System.out.println("Verify T&C Title");
		verifyElementisPresent("//h3[contains(text(),'Register for Mobeix Internet Banking')]", "Register for Mobeix");
//		verifyTextById("//h3[contains(text(),'Register for Mobeix Internet Banking')]", "Register for Mobeix Internet Banking");
		return this;
	}
		
	public RegistrationPage verifyAgreeNDisagreeBtn()
	{
		System.out.println("Verify Agree and Disagree button");
		verifyElementisPresent("//button/span[contains(text(),'I Agree')]","I Agree");
		verifyElementisPresent("//button/span[contains(text(),'Disagree')]","Disagree");
		return this;
	}
	
	public RegistrationPage clickAgreeBtn()
	{
		System.out.println("Click Agree button");
		clickByXpath("//button/span[contains(text(),'I Agree')]");
		return this;
	}
	
	public RegistrationPage clickDisagreeBtn()
	{
		System.out.println("Click Disagree button");
		clickByXpath("//button/span[contains(text(),'Disagree')]");
		return this;
	}

	public RegistrationPage verifyRegisterTypeText()
	{
		System.out.println("Verify Select how you would like to register Heading");
		verifyElementisPresentById("shared_stripmenu_label_methodheader", "Register Type");
		verifyTextById("shared_stripmenu_label_methodheader", "Select how you would like to register:");
		return this;
	}
	
	public RegistrationPage selectRegisterType(String type)
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
	
	public RegistrationPage selectAccountType(String type) throws InterruptedException
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
	
	public RegistrationPage enterAccountNumber()
	{
		System.out.println("Enter Account Number");
		RegistrationAccountNumber = enterByXpathWithRandomNumbers("//input[@formcontrolname='an']", "144", "6");
		objprop("RegistrationAccountNumber", RegistrationAccountNumber);
		return this;
	}
				
	public RegistrationPage verifyEnterCCDetailsText()
	{
		System.out.println("Verify Enter Your Credit Card Details to Register Heading");
		verifyElementisPresentById("shared_creditcard_title_carddetail", "Enter Your Credit Card Details Title");
//		verifyTextById("shared_creditcard_title_carddetail", "Enter Your Credit Card Details to Register");
		return this;
	}
	
	public RegistrationPage verifyCCDetailsHightlight() 
	{
		String DefaultColor = driver.findElement(By.id("registration_label_registrationmethods")).getCssValue("color");
		String HightlightedColor = driver.findElement(By.id("registration_label_carddetail")).getCssValue("color");
		System.out.println(DefaultColor);
		System.out.println(HightlightedColor);
		if(!DefaultColor.equals(HightlightedColor))
		{
			System.out.println("Credit Card Details Text is highlighted!");
			reportStep("Credit Card Details  Text is highlighted!", "PASS");
		}
		else
		{
			System.out.println("Credit Card Details  Text is not highlighted!");
			reportStep("Credit Card Details  Text is not highlighted!", "FAIL");
		}
		return this;
	}
	
	public RegistrationPage verifyPrevStepMarkedTick() 
	{
		verifyElementisPresent("//mat-icon[contains(text(),'check')]", "Prev Step marked Check");
		return this;
	}
	
	public RegistrationPage verifyFieldsInCCDetailsPage()
	{
		System.out.println("Verify the Fields in the Credit Card Details");
		verifyElementisPresent("//input[@formcontrolname='cn']", "Credit Card Number Input");
		verifyElementisPresent("(//input[@formcontrolname='input'])[1]", "CVV Input");
		verifyElementisPresent("//input[@formcontrolname='ed']", "Card Expiry Input");
		verifyElementisPresent("//mat-icon[contains(text(),'date_range')]", "Card Expiry icon");
//		verifyElementisPresent("shared_creditcard_input_daterange", "DOB Input");
//		verifyElementisPresent("registration_input_card_limit", "Credit Card Limit Input");
		verifyElementisPresent("//button//span[contains(text(),'Next')]", "Next Button");	
		verifyElementisPresent("//button//span[contains(text(),'Back')]", "Back Button");	
		return this;
	}
		
	public RegistrationPage clickCreditCardNumber()
	{
		System.out.println("Click Credit Card Number");
		clickByXpath("//input[@formcontrolname='cn']");
		return this;
	}
	
	public RegistrationPage enterCreditCardNumber()
	{
		System.out.println("Enter Credit Card Number");
		RegistrationCreditCardNumber = enterByXpathWithRandomNumbers("//input[@formcontrolname='cn']", "421", "6");
		objprop("RegistrationCreditCardNumber", RegistrationCreditCardNumber);
		return this;
	}
	
	public RegistrationPage clearAndEnterCreditCardNumber() throws InterruptedException
	{
		System.out.println("Clear And Enter Credit Card Number");
		driver.findElement(By.xpath("//input[@formcontrolname='cn']")).clear();
		enterByXpathWithRandomNumbers("//input[@formcontrolname='cn']", "4", "6");
		Thread.sleep(2000);
		return this;
	}
	
	public RegistrationPage enterIncorrectCreditCardNumber()
	{
		System.out.println("Enter Incorrect Credit Card Number");
		enterByXpath("//input[@formcontrolname='cn']", "2632587412321");
		return this;
	}
	
	public RegistrationPage enterCreditCardCVV()
	{
		System.out.println("Enter Credit Card CVV");
		enterByXpath("(//input[@formcontrolname='input'])[1]", "1");
		enterByXpath("(//input[@formcontrolname='input'])[2]", "2");
		enterByXpath("(//input[@formcontrolname='input'])[3]", "3");
//		enterByXpath("(//input[@formcontrolname='input'])[4]", "4");
		return this;
	}
	
	public RegistrationPage enterInvalidCreditCardCVV()
	{
		System.out.println("Enter Credit Card CVV");
		enterByXpath("(//input[@formcontrolname='input'])[1]", "1");
		enterByXpath("(//input[@formcontrolname='input'])[2]", "1");
		enterByXpath("(//input[@formcontrolname='input'])[3]", "1");
		enterByXpath("(//input[@formcontrolname='input'])[4]", "1");
		return this;
	}
	
	public RegistrationPage selectCardExpiryDate(String Month, String Year)
	{
		System.out.println("Select Credit Card Expiry Date");
		
//		clickByXpath("(//mat-icon[contains(text(),'date_range')])[1]");
		clickByXpath("//input[@formcontrolname='ed']");
//		verifyElementisPresent("//div[@class='calendar-table']", "Calendar Pop Up");
		
		clickByXpath("//div[@class='dropdowns ng-star-inserted'][2]");
		clickByXpath("//span[@class='mat-option-text'][contains(text(),'"+Year+"')]");
		clickByXpath("//div[@class='dropdowns ng-star-inserted'][1]");
		clickByXpath("//span[@class='mat-option-text'][contains(text(),'"+Month+"')]");

		return this;
	}
	
	public RegistrationPage verifyCardExpiryDate()
	{
		System.out.println("verify Card Expiry Date Format");
		verifyElementisPresent("//input[@formcontrolname='ed']", "DOB Input");
		String ExpiryDate = getTextById("//input[@formcontrolname='ed']");
		verifyTextById("//input[@formcontrolname='ed']", ExpiryDate);		
		return this;
	}
	
	public RegistrationPage verifyDOBDatePicker()
	{
		System.out.println("verify DOB Date Picker");
		verifyElementisPresentById("shared_creditcard_input_daterange", "DOB Input");
		mouseOverById("shared_creditcard_input_daterange");
		return this;
	}
	
	public RegistrationPage verifyCalendarPopUpButtons()
	{
		System.out.println("verify Calendar Pop Up Buttons");
		clickById("shared_creditcard_input_daterange");
		verifyElementisPresent("//div[@class='calendar-table']", "Calendar Pop Up");
		clickByXpath("//div[@class='dropdowns ng-star-inserted'][2]");
		clickEscapeButton();
		clickByXpath("//div[@class='dropdowns ng-star-inserted'][1]");
		clickEscapeButton();
//		clickByXpath("//button//span/span[@class='calendar-icon calendar-icon--left']");
//		clickByXpath("//button//span/span[@class='calendar-icon calendar-icon--right']");
		clickByXpath("//td[@class='active available end-date start-date today ng-star-inserted']");
		return this;
	}
	
	public RegistrationPage clickDOB()
	{
		System.out.println("Click DOBr");
		clickById("shared_creditcard_input_daterange");
		clickEscapeButton();
		return this;
	}
	
	public RegistrationPage selectDOB(String Date, String Month, String Year)
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
	
	public RegistrationPage verifyDOBDate()
	{
		System.out.println("verify DOB Date Format");
		verifyElementisPresentById("shared_creditcard_input_daterange", "DOB Input");
//		String DOB = getTextById("shared_creditcard_input_daterange");
//		verifyTextById("shared_creditcard_input_daterange", DOB);		
		return this;
	}
	
	public RegistrationPage enterCreditCardLimit(String limit)
	{
		System.out.println("Enter Credit Card Limit");
//		enterByXpath("(//input[@formcontrolname='input'])[1]", limit);
		enterById("registration_input_card_limit", limit);
		return this;
	}
	
	public RegistrationPage verifyCreditCardEmptyErrorMsg() {
		System.out.println("Verify Credit Card Empty Error Msg");
		verifyElementisPresent("//mat-error[contains(text(),'Credit card number is mandatory')]", "Credit card number is mandatory");
//		verifyTextByXpath("//mat-error[contains(text(),'Credit card number is mandatory')]", "Credit card number is mandatory");
		return this;
	}
	
	public RegistrationPage verifyCreditCardInvalidErrorMsg() {
		System.out.println("Verify Credit Card Invalid Error Msg");
		verifyTextByXpath("//p[contains(text(),'Please use valid card details to complete registration')]", "Please use valid card details to complete registration");
//		verifyTextById("registration_label_provide_proper_Credit_card_details", "Please use the valid credit card details");
		clickOKbtn();
		return this;
	}
	
	public RegistrationPage verifyCreditCardLimitErrorMsg() {
		System.out.println("Verify Credit Card Limit Error Msg");
		verifyElementisPresent("//mat-error[contains(text(),'minimum length is')]", "Credit card number minimum length is 16");
//		verifyTextByXpath("//mat-error[contains(text(),'minimum length is')]", "Credit card number minimum length is 16");
		return this;
	}
	
	public RegistrationPage verifyCVVEmptyErrorMsg() {
		System.out.println("Verify CVV Empty Error Msg");
//		verifyTextByXpath("//mat-error[contains(text(),'CVV is mandatory')]", "CVV is mandatory");
		verifyTextById("registration_label_CVV_is_mandatory", "CVV is mandatory");
		return this;
	}
	
	public RegistrationPage verifyExpiryDateEmptyErrorMsg() {
		System.out.println("Verify Expiry Date Empty Error Msg");
//		verifyTextByXpath("//mat-error[contains(text(),'Expiry Date is mandatory')]", "Expiry Date is mandatory");
		verifyTextById("registration_label_Expiry Date_is_mandatory", "Expiry Date is mandatory");
		return this;
	}
	
	public RegistrationPage verifyDOBAgeErrorMsg() {
		System.out.println("Verify DOB Age Error Msg");
//		verifyTextByXpath("//mat-error[contains(text(),'Age must be 18 years to proceed with registration')]", "Age must be 18 years to proceed with registration");
		verifyTextById("registration_label_Age_must_be_18_years_to_proceed_with_registration", "Age must be 18 years to proceed with registration");
		return this;
	}
	
	public RegistrationPage verifyDOBEmptyErrorMsg() {
		System.out.println("Verify DOB Empty Error Msg");
		verifyElementisPresent("//mat-error[contains(text(),' Date of Birth')]", "Date of Birth");
//		verifyTextByXpath("//mat-error[contains(text(),'DOB is mandatory')]", "DOB is mandatory");
//		verifyTextById("registration_label_DOB_is_mandatory", "DOB is mandatory");
		return this;
	}	
	
	public RegistrationPage verifyFieldsInDebitCardDetailsPage()
	{
		System.out.println("Verify the Fields in the Debit Card Details");
		verifyElementisPresent("//input[@formcontrolname='cn']", "Debit Card Number Input");
		verifyElementisPresent("(//input[@formcontrolname='input'])[1]", "Pin Input");
		verifyElementisPresent("//button//span[contains(text(),'Next')]", "Next Button");	
		verifyElementisPresent("//button//span[contains(text(),'Back')]", "Back Button");	
		return this;
	}
	
	public RegistrationPage enterDebitCardNumber()
	{
		System.out.println("Enter Debit Card Number");
		RegistrationDebitCardNumber = enterByXpathWithRandomNumbers("//input[@formcontrolname='cn']", "321", "6");
		objprop("RegistrationDebitCardNumber", RegistrationDebitCardNumber);
		return this;
	}
	
	public RegistrationPage enterDebitCardPin()
	{
		System.out.println("Enter Debit Card Pin");
		enterByXpath("(//input[@formcontrolname='input'])[1]", "1");
		enterByXpath("(//input[@formcontrolname='input'])[2]", "2");
		enterByXpath("(//input[@formcontrolname='input'])[3]", "3");
		enterByXpath("(//input[@formcontrolname='input'])[4]", "4");
		return this;
	}
	
	public RegistrationPage clickNextBtn()
	{
		System.out.println("Click Next button");
		clickByXpath("//button//span[contains(text(),'Next')]");
		return this;
	}
	
	public RegistrationPage clickBackBtn()
	{
		System.out.println("Click Back button");
		clickById("shared_creditcard_button_back");
		return this;
	}	
	
	public RegistrationPage verifyBackButton() 
	{
		verifyElementisPresent("//button/span[text()='Back']", "Back button");
		mouseOverByXpath("//button/span[text()='Back']");
		return this;
	}
	
	public RegistrationPage verifyAuthenticationHeading()
	{
		System.out.println("Verify Authentication Heading");
		verifyElementisPresentById("shared_2fa_label_authentication", "Authentication Heading");
		verifyTextById("shared_2fa_label_authentication", "Authentication");
		return this;
	}
	
	public RegistrationPage verifyAuthHightlight() 
	{
		waitForLoad();
		String DefaultColor = driver.findElement(By.id("registration_label_carddetail")).getCssValue("color");
		String HightlightedColor = driver.findElement(By.id("registration_label_authentication")).getCssValue("color");
		System.out.println(DefaultColor);
		System.out.println(HightlightedColor); 
		if(!DefaultColor.equals(HightlightedColor))
		{
			System.out.println("Authentication Text is highlighted!");
			reportStep("Authentication Text is highlighted!", "PASS");
		}
		else
		{
			System.out.println("Authentication Text is not highlighted!");
			reportStep("Authentication Text is not highlighted!", "FAIL");
		}
		return this;
	}
		
	public RegistrationPage verify2FALabel()
	{
		System.out.println("Verify 2FA Label");
		verifyElementisPresentById("shared_login_2fa_label_select2fa", "Select 2FA Label");
		verifyTextByXpath("shared_login_2fa_label_select2fa", "Select 2FA");
		return this;
	}
	
	public RegistrationPage authTypes()
	{
		System.out.println("View 2FA Types");
		clickByXpath("//div//span[text()='Select']");
		List<WebElement> AuthType = driver.findElements(By.xpath("//span[@class='mat-option-text']"));
		for (WebElement comps : AuthType) {
			System.out.println("Auth Types => " + comps.getText());
		}
		return this;
	}
	
	public RegistrationPage select2FAType(String auth)
	{
		System.out.println("Select 2FA Type");
		clickByXpath("//div//span[text()='SMS OTP']");
	    clickByXpath("//span[@class='mat-option-text'][contains(text(),'"+auth+"')]");
		return this;
	}
		
	public RegistrationPage verifyEnterOTPLabel()
	{
		System.out.println("Verify Enter OTP Label");
		verifyElementisPresentById("shared_login_2fa_label_enterotp", "Enter OTP Label");
		verifyTextById("shared_login_2fa_label_enterotp", "Enter OTP");
		return this;
	}
	
	public RegistrationPage verifyAuthCodeLabel()
	{
		System.out.println("Verify Auth Code Label");
		verifyElementisPresentById("registration_label_EnterOTP", "Authentication Code Label");
		verifyTextById("registration_label_EnterOTP", "Please provide your authentication code");
		return this;
	}	
	
	public RegistrationPage verifyFAOTPSentMsg()
	{
		System.out.println("Verify 2FA OTP Sent Msg");
		verifyElementisPresentById("shared_login_2fa_label_mobilenumbercescription", "2FA OTP Sent Msg");
		verifyTextById("shared_login_2fa_label_mobilenumbercescription", "For your security, we have sent a OTP to your registered mobile number *********12341");
		return this;
	}	
	
	public RegistrationPage verifyEnterOTPField()
	{
		System.out.println("Verify Enter OTP Field");
		verifyElementisPresent("(//input[@formcontrolname='input'])[1]", "Enter OTP Field");
		return this;
	}
	
	public RegistrationPage enterSMSOTP()
	{
		System.out.println("Entered the OTP");
		enterByXpath("(//input[@formcontrolname='input'])[1]","1");
		enterByXpath("(//input[@formcontrolname='input'])[2]","2");
		enterByXpath("(//input[@formcontrolname='input'])[3]","3");
		enterByXpath("(//input[@formcontrolname='input'])[4]","4");
		enterByXpath("(//input[@formcontrolname='input'])[5]","5");
		enterByXpath("(//input[@formcontrolname='input'])[6]","6");
		return this;
	}
	
	public RegistrationPage enterIncorrectSMSOTP()
	{
		System.out.println("Entered the Incorrect OTP");
		enterByXpath("(//input[@formcontrolname='input'])[1]","1");
		enterByXpath("(//input[@formcontrolname='input'])[2]","2");
		enterByXpath("(//input[@formcontrolname='input'])[3]","3");
		enterByXpath("(//input[@formcontrolname='input'])[4]","3");
		enterByXpath("(//input[@formcontrolname='input'])[5]","3");
		enterByXpath("(//input[@formcontrolname='input'])[6]","6");
		return this;
	}
	
	public RegistrationPage enterInvalidCharsSMSOTP()
	{
		System.out.println("Entered the Incorrect OTP");
		enterByXpath("(//input[@formcontrolname='input'])[1]","*");
		enterByXpath("(//input[@formcontrolname='input'])[2]","-");
		enterByXpath("(//input[@formcontrolname='input'])[3]","+");
		enterByXpath("(//input[@formcontrolname='input'])[4]","/");
		enterByXpath("(//input[@formcontrolname='input'])[5]","&");
		enterByXpath("(//input[@formcontrolname='input'])[6]","@");
		return this;
	}
	
	public RegistrationPage enterAlphabetsInSMSOTP()
	{
		System.out.println("Entered the Incorrect OTP");
		enterByXpath("(//input[@formcontrolname='input'])[1]","A");
		enterByXpath("(//input[@formcontrolname='input'])[2]","B");
		enterByXpath("(//input[@formcontrolname='input'])[3]","C");
		enterByXpath("(//input[@formcontrolname='input'])[4]","D");
		enterByXpath("(//input[@formcontrolname='input'])[5]","E");
		enterByXpath("(//input[@formcontrolname='input'])[6]","F");
		return this;
	}
	
	public RegistrationPage click2faNextBtn()
	{
		System.out.println("Click 2FA Next button");
		clickByXpath("//button//span[contains(text(),'Next')]");
		return this;
	}
	
	public RegistrationPage verifyEnterOTPErrorMsg() {
		verifyTextById("registration_label_Enter_OTP", "Enter OTP");
		return this;
	}
	
	public RegistrationPage verifyInvalidOTPErrorMsg() {
		verifyElementisPresent("//p[contains(text(),'Invalid OTP.')]", "Invalid OTP.");
		String error = getTextByXpath("//p[contains(text(),'Invalid OTP.')]");
		verifyTextByXpath("//p[contains(text(),'Invalid OTP.')]", error);
//		verifyTextByXpath("//p[contains(text(),'Invalid OTP.')]", "Invalid OTP.");
		clickOKbtn();
		return this;
	}
	
	public RegistrationPage verifyUnsuccessfulAttemptsErrorMsg() {
		verifyTextByXpath("//p[contains(text(),'You have exceeded the limit allowed for invalid attempts')]", "You have exceeded the limit allowed for invalid attempts, please initiate the registration again");
		clickOKbtn();
		return this;
	}
	
	public RegistrationPage clickResendCodeLink()
	{
		System.out.println("Click Resend Code Link");
		clickById("shared_login_2fa_label_resendcode");
		return this;
	}
		
	public RegistrationPage verifyResendCodeLink()
	{
		System.out.println("Verify Resend Code Link");
		verifyElementisPresentById("shared_login_2fa_label_resendcode", "Resend Code");
		verifyTextById("shared_login_2fa_label_resendcode", "Resend code");
		return this;
	}
	
	public RegistrationPage verifyOTPTimerLabel()
	{
		System.out.println("verify OTP Timer");
		verifyElementisPresent("//div[@class='timer']", "OTP Timer");
		return this;
	}
	
	public RegistrationPage verifyOTPTimer()
	{
		System.out.println("verify OTP Timer");
		verifyElementisPresent("//div[@class='timer']", "OTP Timer");
//		verifyTextById("//div[@class='timer']", "00:30");
		return this;
	}
	
	public RegistrationPage verifyTimerColor() throws InterruptedException 
	{
		String DefaultColor = driver.findElement(By.id("registration_label_Timer_color")).getCssValue("stroke");
		System.out.println(DefaultColor);
		if(DefaultColor.equalsIgnoreCase("red"))
		{
			System.out.println("Timer color is verified!");
			reportStep("Timer color is verified!", "PASS");
		}
		else
		{
			System.out.println("Timer color verification failed!");
			reportStep("Timer color verification failed!", "FAIL");
		}
		return this;
	}
	
	public RegistrationPage verifyTimerColorAfterValidity() throws InterruptedException 
	{
		Thread.sleep(35000);
		String DefaultColor = driver.findElement(By.id("registration_label_Timer_color")).getCssValue("#fff");
		String HightlightedColor = driver.findElement(By.id("registration_label_Timer_color")).getCssValue("#00bdcd");
		System.out.println(DefaultColor);
		System.out.println(HightlightedColor);
		if(!DefaultColor.equals(HightlightedColor))
		{
			System.out.println("Timer color after validity is verified!");
			reportStep("Timer color after validity is verified!", "PASS");
		}
		else
		{
			System.out.println("Timer color after validity verification failed!");
			reportStep("Timer color after validity verification failed!", "FAIL");
		}
		return this;
	}
		
	public RegistrationPage clickSubmitBtn2FAPage()
	{
		System.out.println("Click Submit button");
		clickById("shared_login_2fa_button_submitotp");
		return this;
	}
	
	public RegistrationPage clickSubmitBtn()
	{
		System.out.println("Click Submit button");
		clickByXpath("//button/span[contains(text(),'Submit')]");
		return this;
	}
	
	public RegistrationPage clickCancelBtn()
	{
		System.out.println("Click Cancel button");
//		clickByXpath("//button/span[contains(text(),'Cancel')]");
		clickById("registration_button_cancel");
		return this;
	}
	
	public RegistrationPage verifyNotesTextArea()
	{
		System.out.println("Verify Notes Text area");
		verifyElementisPresent("//h3[contains(text(),'Notes')]", "Notes");
		verifyElementisPresent("//div[@class='notes-description']", "Notes Description");
		return this;
	}
	
	public RegistrationPage verifyCreateYourUsernameHeading()
	{
		System.out.println("Verify Create your username and password Heading");
		verifyElementisPresent("//h4[@id='registration_label_userdetail']", "Create your username and password Heading");
		verifyTextByXpath("//h4[@id='registration_label_userdetail']", "Create your username and password");
		return this;
	}
	
	public RegistrationPage enterUserName(){
		System.out.println("Enter the User Name");
		RegistrationUserName = enterByXpathWithRandomNumber("//input[@formcontrolname='un']", "autoqa");		
		objprop("RegistrationUserName", RegistrationUserName);
		return this;
	}
	
	public RegistrationPage verifyUsernameTick()
	{
		System.out.println("verify Username Tick");
		verifyElementisPresent("//mat-icon[text()='done']", "Username Tick");
		return this;
	}
		
	public RegistrationPage enterInvalidUserName(){
		System.out.println("Enter Invalid User Name");
		enterByXpath("//input[@formcontrolname='un']", "Test123");
		return this;
	}
	
	public RegistrationPage verifyPasswordAndConfirmPassword(){
		System.out.println("Verify Password And Confirm Password");
		verifyElementisPresent("//input[@formcontrolname='psw']", "Password Field");
		verifyElementisPresent("//input[@formcontrolname='confirmPsw']", "Confirm Password Field");
		return this;
	}
	
	public RegistrationPage enterPassword(){
		System.out.println("Enter the Password");
		RegistrationPassword = "Password12";
		enterByXpath("//input[@formcontrolname='psw']", RegistrationPassword);
		objprop("RegistrationPassword", RegistrationPassword);
		return this;
	}
	
	public RegistrationPage enterConfirmPassword(){
		System.out.println("Enter the Confirm Password");
		enterByXpath("//input[@formcontrolname='confirmPsw']", getobjprop("RegistrationPassword"));
		return this;
	}
	
	public RegistrationPage enterInvalidConfirmPassword() throws InterruptedException{
		System.out.println("Enter Invalid Confirm Password");
		waitForLoad();
		Thread.sleep(3000);
		enterByXpath("//input[@formcontrolname='confirmPsw']", "pass123456");
		return this;
	}
	
	public RegistrationPage verifyandClickPasswordEyeIcon() throws InterruptedException{
		System.out.println("Verify and Click Password Eye Icon");
		Thread.sleep(3000);
		verifyElementisPresent("//span[@class='mxPassword pwdShow']", "Password Eye Icon");
		clickByXpath("//span[@class='mxPassword pwdShow']");
		return this;
	}
	
	public RegistrationPage verifyMinimumPassword() throws InterruptedException{
		System.out.println("Verify Minimum Password");
		enterByXpath("//input[@formcontrolname='psw']", "Pass1234");
		clickSubmitBtn();
		verifyandClickPasswordEyeIcon();
		enterByXpath("//input[@formcontrolname='confirmPsw']", "Pass1234");
		return this;
	}
	
	public RegistrationPage verifyMaximumPassword() throws InterruptedException{
		System.out.println("Verify Maximum Password");
		enterByXpath("//input[@formcontrolname='psw']", "Password1234");
		clickSubmitBtn();
		verifyandClickPasswordEyeIcon();
		enterByXpath("//input[@formcontrolname='confirmPsw']", "Password1234");
		return this;
	}
	
	public RegistrationPage enterInvalidPassword(){
		System.out.println("Enter Invalid Password");
		enterByXpath("//input[@formcontrolname='psw']", "password12*&");
		enterByXpath("//input[@formcontrolname='confirmPsw']", "password12*&");
		return this;
	}
	
	public RegistrationPage verifyPasswordDoesntMatchErrorMsg() {
		verifyTextByXpath("//mat-error[contains(text(),'Password and Confirm Password')]", "Password and Confirm Password do not match 123home");
//		verifyTextById("registration_label_Password_does_not_match", "Password does not match");
		return this;
	}
	
	public RegistrationPage enterSameCreditCardDetails()
	{
		System.out.println("Enter Same Credit Card Details");
		enterById("shared_creditcard_input_cardno", getobjprop("RegistrationCreditCardNumber"));
		enterCreditCardCVV();
		selectDOB("05", "12", "1995");
		return this;
	}
	
	public RegistrationPage verifyUsernameExistErrorMsg() {
		verifyTextByXpath("//h2[contains(text(),'User is already registered')]", "User is already registered");
//		verifyTextById("registration_label_Username_already_exist", "User is already registered");
		clickOKbtn();
		return this;
	}
	
	public RegistrationPage verifyRegistrationFailedErrorMsg() {
//		verifyTextByXpath("//mat-error[contains(text(),'Your registration has failed')]", "Your registration has failed already exist");
		verifyTextById("registration_label_Your_registration_has_failed", "Your registration has failed");
		return this;
	}
	
	public RegistrationPage verifyRegistrationSuccessMessage() throws InterruptedException {
		System.out.println("Verify Registration Success Message");
		waitForLoad();
		Thread.sleep(4000);
		String Message = getTextByXpath("//h3[contains(text(),'Registration completed successfully.')]");
		verifyTextByText(Message, "Success ! Registration completed successfully.");
//		reportStep(Message, "PASS");
		return this;
	}
	
	public RegistrationPage verifyRegistrationSuccessMessageColor() throws InterruptedException {
		System.out.println("Verify Registration Success Message Color and Tick symbol");
		waitForLoad();
		Thread.sleep(5000);
		
		String DefaultColor = driver.findElement(By.xpath("//h3[contains(text(),'Registration completed successfully.')]")).getCssValue("color");
		System.out.println(DefaultColor);
		if(DefaultColor.equals("rgba(88, 186, 50, 1)"))
		{
			System.out.println("Registration Success Message Color is Green!");
			reportStep("Registration Success Message Color is Green!", "PASS");
		}
		else
		{
			System.out.println("Registration Success Message Color is not Green!");
			reportStep("Registration Success Message Color is not Green!", "FAIL");
		}
				
		verifyElementisPresent("//span[@class='icon iconClass']", "Green Tick Icon");
		return this;
	}
	
	public RegistrationPage reviewRegistrationScreenDetails() throws InterruptedException {
		System.out.println("Review Registration Screen Details");
		Thread.sleep(5000);
		verifyElementisPresent("//span[contains(text(),'Date')]/following-sibling::span", "Date");
//		verifyElementisPresentById("registration_label_verify_date ", "Date");
		verifyTextByXpath("//span[contains(text(),'username')]/following-sibling::span", getobjprop("RegistrationUserName"));
//		verifyTextById("registration_label_verify_username", getobjprop("RegistrationUserName"));
		return this;
	}
	
	public RegistrationPage verifySignIntoIB() throws InterruptedException
	{
		System.out.println("Verify Sign In To Internet Banking button in Success Screen");
		Thread.sleep(5000);
		verifyElementisPresent("//button//span[contains(text(),'Sign in to Internet Banking')]", "Sign in to Internet Banking");
//		verifyElementisPresentById("registration_button_sign_in_internet_banking", "Sign in to Internet Banking");
		return this;
	}
	
	public RegistrationPage clickSignIntoIB()
	{
		System.out.println("Click Sign In To Internet Banking button");
		clickByXpath("//button//span[contains(text(),'Sign in to Internet Banking')]");
//		clickById("registration_button_sign_in_internet_banking");
		return this;
	}
	
	public RegistrationPage getReferenceNumber() {
		String ori = driver.findElement(By.id("registration_label_reference")).getText();
		try {
			String[] str = ori.split(":");
			reference = str[1].trim();
			System.out.println("Reference number:" + reference);
			objprop("RegistrationReferenceNumber", reference);
			reportStep("The reference number is fetched successfully and the referencenumber is: " + reference, "PASS");
		} catch (Exception e) {
			System.out.println("error");
			reportStep("The reference number is not fetched ", "FAIL");
		}
		return this;
	}
	
	public RegistrationPage validateUniqueReferenceID() throws InterruptedException {
		System.out.println("Validate Unique Reference ID is generating every time");
		getReferenceNumber();
		String ref1=reference;
		System.out.println("Reference 1 :"+ ref1);
		
		clickCancelBtn();
		clickRegisterNowBtn();
		clickAgreeBtn();
		
		getReferenceNumber();
		String ref2=reference;
		System.out.println("Reference 2 :"+ ref2);
		if(ref1!=ref2)
		{
			System.out.println("Unique Reference ID is generating every time");
		}
		return this;
	}
	
	public RegistrationPage verifyCaneclPopUp()
	{
		System.out.println("Verify Canecl Pop Up");
		verifyElementisPresent("//p[contains(text(),'Are you sure you want to discard the changes?')]", "Cancel Pop Up");
		verifyTextByXpath("//p[contains(text(),'Are you sure you want to discard the changes?')]", "Are you sure you want to discard the changes?");
		return this;
	}
	
	public RegistrationPage clickYesbtn() {
		System.out.println("Click YES button");
		clickByXpath("//button/span[text()=' Yes ']");
		return this;
	}
	
	public RegistrationPage clickOKbtn() {
		System.out.println("Click OK button");
		clickByXpath("//button/span[contains(text(),'OK')]");
		return this;
	}
		
	public RegistrationPage clickEscapeButton()
	{
		System.out.println("Click Escape Button");
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ESCAPE).build().perform();
		return this;
	}
	
	public RegistrationPage userLogOut() throws InterruptedException {
		System.out.println("Logout the User");
		clickByXpath("(//span[contains(text(), 'Logout')])[2]");
		return this;
	}
	
}
