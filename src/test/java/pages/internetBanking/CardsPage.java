package  pages.internetBanking;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

public class CardsPage extends wrappers.ProjectWrappers  {
		
	public CardsPage(RemoteWebDriver driver, ExtentTest test)throws Exception{
		this.driver = driver;
		this.test = test;
		openQAIBApplication();
	}
	
	public CardsPage loginUsingSMS() throws InterruptedException {
		enterUserName()
	  	.enterPassword()
	  	.takeMeDirectlyTo("Dashboard")
	  	.clickSignInBtn()
	  	.select2FAType("SMS OTP")
	  	.enterSMSOTP()
	  	.clickSubmitBtn2FAPage();
		return this;
	}
		
	public CardsPage clickUserName() throws InterruptedException{
		System.out.println("Click the User Name");
		Thread.sleep(3000);
		clickById("login_input_username");
		return this;
	}
	
	public CardsPage enterUserName() throws InterruptedException{
		System.out.println("Enter the User Name");
		Thread.sleep(8000);
		enterByXpath("(//input[@placeholder='Enter'])[1]", "autouser111");
		return this;
	}
	
	public CardsPage clickPassword(){
		System.out.println("Click the Password");
		clickById("login_input_password");
		return this;
	}
	
	public CardsPage enterPassword(){
		System.out.println("Enter the Password");
		enterByXpath("(//input[@placeholder='Enter'])[2]", "Password12");
		return this;
	}
	
	public CardsPage takeMeDirectlyTo(String page)
	{
		System.out.println("Select any one take me directly option");
		clickByXpath("//mat-select[@formcontrolname='directTo']");
	    clickByXpath("//span[@class='mat-option-text'][contains(text(),'"+page+"')]");
		return this;
	}

	public CardsPage clickSignInBtn()
	{
		System.out.println("Click Sign In button");
		clickByXpath("//button[@type='submit']");
		return this;
	}
		
	public CardsPage clickNextBtn()
	{
		System.out.println("Click Next button");
		clickByXpath("//button/span[contains(text(),'Next')]");
		return this;
	}	
	
	public CardsPage select2FAType(String auth)
	{
		System.out.println("Select 2FA Type");
		clickByXpath("//div//span[contains(text(),'Select')]");
	    clickByXpath("//span[@class='mat-option-text'][contains(text(),'"+auth+"')]");
		return this;
	}
	
	public CardsPage enterSMSOTP() throws InterruptedException
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

	public CardsPage clickResendCodeLink()
	{
		System.out.println("Click Resend Code Link");
		clickByXpath("//span[contains(text(),'Resend code')]");
		return this;
	}
	
	public CardsPage clickSubmitBtn2FAPage()
	{
		System.out.println("Click Submit button");
		clickByXpath("//button/span[contains(text(),'Submit')]");
		return this;
	}
	
	public CardsPage clickOKBtn()
	{
		System.out.println("Click OK button");
		clickByXpath("//button/span[contains(text(),'Ok')]");
		return this;
	}	
	
	
	public CardsPage verifyDashboardTitle() throws InterruptedException
	{
		System.out.println("Verify Dashboard title");
		Thread.sleep(4000);
		verifyElementisPresent("//span[contains(text(), 'Dashboard')]", "Dashboard");
		return this;
	}
	
	
	
	public CardsPage clickConfirmButton()
	{
		System.out.println("Click Confirm Button");
		clickByXpath("//span[contains(text(),'Confirm')]");
		return this;
	}
	
	public CardsPage clickCardsMenu()
	{
		System.out.println("Click Cards Menu");
		clickByXpath("//a[starts-with(@class, 'menu-button')]/span[contains(text(),'Cards')]");
		doubleClickByXpath("//a[starts-with(@class, 'menu-button')]/span[contains(text(),'Cards')]");
		return this;
	}
	
	public CardsPage clickCardsArrow()
	{
		System.out.println("Click Cards Arrow");
		clickByXpath("(//a[starts-with(@class, 'menu-button')]/span/span)[4]");
		return this;
	}
	
	public CardsPage clickCreditCards()
	{
		System.out.println("Click Credit Cards");
		clickByXpath("//span[contains(text(),'Credit Cards')]");
		return this;
	}
	
	// Temp and Permanent Block Cards
	public CardsPage clickManageCards()
	{
		System.out.println("Click Manage Cards");
		clickByXpath("//span[contains(text(),'Manage Cards')]");
		return this;
	}
	
	public CardsPage clickBlockCardSwitch()
	{
		System.out.println("Click Block Card Switch");
		clickByXpath("//div[@class='mat-button-toggle-label-content' and contains(text(),'ON')]");
		return this;
	}
	
	public CardsPage selectBlockType(String TempOrPerm)
	{
		System.out.println("Select Card Block Type");
		clickByXpath("//div[@class='mat-button-toggle-label-content' and contains(text(),'"+TempOrPerm+"')]");
		return this;
	}
	
	public CardsPage selectTemporayBlockReason(String Reason)
	{
		System.out.println("Select Temporay Block Reason");
		clickByXpath("//mat-select[@formcontrolname='rs']");
		clickByXpath("//span[@class='mat-option-text' and contains(text(),'"+Reason+"')]");
		return this;
	}
	
	public CardsPage verifyTempBlockedSuccessMessage()
	{
		System.out.println("Verify Card Temporarily Blocked Success Message");
		verifyTextByXpath("//*[contains(text(),'Success ! Card has been temporarily blocked')]", "Success ! Card has been temporarily blocked");
		return this;
	}
	
	public CardsPage verifyPermanentlyBlockedSuccessMessage()
	{
		System.out.println("Verify Card Permanently Blocked Success Message");
		verifyTextByXpath("//*[contains(text(),'Success ! Card has been blocked successfully')]", "Success ! Card has been blocked successfully");
		return this;
	}
	
	// Reset Card Pin
	public CardsPage clickResetCardPinArrow()
	{
		System.out.println("Click Reset Card Pin Arrow");
		clickByXpath("(//div[@class='mx-rb-arrow-right-icon-class mx-rb-cur-pointer mx-rb-arrow-right-icon'])[1]");
		return this;
	}
	
	public CardsPage enterCreditCardCVV()
	{
		System.out.println("Enter Credit Card CVV");
		enterByXpath("//input[@formcontrolname='enccvv']", "555");
		return this;
	}
	
	public CardsPage selectDOB(String Date, String Month, String Year)
	{
		System.out.println("Select Credit Card User DOB");
		clickByXpath("//mat-icon[contains(text(),'date_range')]");		
		clickByXpath("//div[@class='dropdowns ng-star-inserted'][2]");
		clickByXpath("//span[@class='mat-option-text'][contains(text(),'"+Year+"')]");
		clickByXpath("//div[@class='dropdowns ng-star-inserted'][1]");
		clickByXpath("//span[@class='mat-option-text'][contains(text(),'"+Month+"')]");
		Actions DOB = new Actions(driver);
		DOB.moveToElement(driver.findElement(By.xpath("//tbody/tr//td//span[contains(text(),'"+Date+"')]"))).click().perform();
		return this;
	}
	
	public CardsPage enterPin() throws InterruptedException
	{
		System.out.println("Enter Pin");
		Thread.sleep(3000);
		enterByXpath("//input[@formcontrolname='encpin']", "Password12");
		return this;
	}
	
	public CardsPage comfirmPin()
	{
		System.out.println("Re-enter Comfirmed Pin");
		enterByXpath("//input[@formcontrolname='confirmEncpin']", "Password12");
		return this;
	}
	
	public CardsPage verifyResetPinSuccessMessage()
	{
		System.out.println("Verify Reset Pin Success Message");
		verifyTextByXpath("//*[contains(text(),'Success! PIN has been regenerated successfully')]", "Success! PIN has been regenerated successfully");
		return this;
	}
	
	//Manage Limit
	public CardsPage clickManageLimitArrow()
	{
		System.out.println("Click Manage Limit Arrow");
		clickByXpath("(//div[@class='mx-rb-arrow-right-icon-class mx-rb-cur-pointer mx-rb-arrow-right-icon'])[2]");
		return this;
	}
	
	public CardsPage clickUpdateButton()
	{
		System.out.println("Click Update Button");
		clickByXpath("//button//span[contains(text(),'Update')]");
		return this;
	}
	
	public CardsPage enterPOSLimit()
	{
		System.out.println("Enter POS Limit");
		enterByXpath("//input[@formcontrolname='posField']", "20000");
		return this;
	}
	
	public CardsPage enterTransLimit()
	{
		System.out.println("Enter Transaction Limit");
		enterByXpath("//input[@formcontrolname='transactionField']", "20000");
		return this;
	}
	
	public CardsPage verifyLimitUpdatedSuccessMessage()
	{
		System.out.println("Verify Limit Updated Success Message");
		verifyTextByXpath("//*[contains(text(),'Success! PIN has been regenerated successfully')]", "Success! PIN has been regenerated successfully");
		return this;
	}
							
	public CardsPage clickBackButton()
	{
		System.out.println("Click Back Button");
		clickByXpath("//button/span[text()='Back']");
		return this;
	}
	
	public CardsPage clickViewButton()
	{
		System.out.println("Click View Button");
		clickByXpath("//span[contains(text(),'View')]");
		return this;
	}
	
	//Debit Card flow in Cards Overiew
	public CardsPage verifyCardsOverview()
	{
		System.out.println("Verify Cards Overview");
		verifyElementisPresent("//*[contains(text(),'Cards Overview')]", "Cards Overview");
		return this;
	}
	
	public CardsPage verifyDebitCard()
	{
		System.out.println("Verify Debit Card");
		verifyElementisPresent("//*[contains(text(),'Debit card')]", "Debit Card");
		return this;
	}
	
	public CardsPage verifyGoldDebitCard()
	{
		System.out.println("Verify Gold Debit Card");
		verifyElementisPresent("//*[contains(text(),'Gold Debit Card')]", "Gold Debit Card");
		return this;
	}
	
	public CardsPage clickDebitCardDetailsLink()
	{
		System.out.println("Click Debit Card Details Link");
//		clickByXpath("//div[contains(text(),'Card Details')]/preceding::h4[contains(text(),'Debit')]");
		clickByXpath("(//div[contains(text(),'Card Details')])[1]");
		return this;
	}
	
	public CardsPage verifyDebitCardDetails()
	{
		System.out.println("Verify Debit Card Details");
		verifyElementisPresent("//div[contains(text(),'Card Type')]", "Card Type");
		verifyElementisPresent("//div[contains(text(),'Card Name')]", "Card Name");
		verifyElementisPresent("//div[contains(text(),'Card Number')]", "Card Number");
		return this;
	}
	
	//Credit Card Statement and Report in Cards Overiew
	public CardsPage verifyCreditCard()
	{
		System.out.println("Verify Credit Card");
		verifyElementisPresent("//*[contains(text(),'Credit card')]", "Credit Card");
		return this;
	}
	
	public CardsPage verifyVisaTitanimCard()
	{
		System.out.println("Verify Visa Titanium Card");
		verifyElementisPresent("//*[contains(text(),'Visa Titanium Card')]", "Visa Titanium Card");
		return this;
	}
	
	public CardsPage clickCreditCardDetailsLink()
	{
		System.out.println("Click Credit Card Details Link");
//		clickByXpath("//div[contains(text(),'Card Details')]/preceding::h4[contains(text(),'Debit')]");
		clickByXpath("(//div[contains(text(),'Card Details')])[2]");
		return this;
	}
	
	public CardsPage verifyCreditCardDetails()
	{
		System.out.println("Verify Credit Card Details");
		verifyElementisPresent("//div[contains(text(),'Card Type')]", "Card Type");
		verifyElementisPresent("//div[contains(text(),'Card Name')]", "Card Name");
		verifyElementisPresent("//div[contains(text(),'Card Number')]", "Card Number");
		verifyElementisPresent("//div[contains(text(),'Available Credit Limit')]", "Available Credit Limit");
		verifyElementisPresent("//div[text()=' Credit Limit ']", "Credit Limit");
		verifyElementisPresent("//div[contains(text(),'Total Amount Due')]", "Total Amount Due");
		verifyElementisPresent("//div[contains(text(),'Minimum')]", "Minimum Amount Due");
		verifyElementisPresent("//div[contains(text(),'Previous')]", "Previous Balance");
		return this;
	}
	
	public CardsPage clickCreditCardStatementLink()
	{
		System.out.println("Click Credit Card Statement Link");
//		clickByXpath("//div[contains(text(),'Card Statement')]/preceding::h4[contains(text(),'Debit')]");
		clickByXpath("(//div[contains(text(),'Card Statement')])[1]");
		return this;
	}
	
	public CardsPage verifyCreditCardStatementPageElements()
	{
		System.out.println("Verify Customer ID");
		verifyElementisPresent("//input[@placeholder='Search description']", "Search Input");
		verifyElementisPresent("//div[contains(text(),'All')]", "All Button");
		verifyElementisPresent("//div[contains(text(),'Billed')]", "Billed Button");
		verifyElementisPresent("//div[contains(text(),'Unbilled')]", "Unbilled Button");
		verifyElementisPresent("//input[@formcontrolname='sd']", "Start Date Input");
		verifyElementisPresent("//input[@formcontrolname='ed']", "End Date Input");
		verifyElementisPresent("//button/span[contains(text(),'View')]", "View Button");
		verifyElementisPresent("//span[contains(text(),'Download Transactions Report')]", "Download Transactions Report");
		return this;
	}
	
	public CardsPage selectStartDate(String Date, String Month, String Year)
	{
		System.out.println("Select Credit Card Statement Start Date");
		clickByXpath("//input[@formcontrolname='sd']");		
		clickByXpath("//div[@class='dropdowns ng-star-inserted'][2]");
		clickByXpath("//span[@class='mat-option-text'][contains(text(),'"+Year+"')]");
		clickByXpath("//div[@class='dropdowns ng-star-inserted'][1]");
		clickByXpath("//span[@class='mat-option-text'][contains(text(),'"+Month+"')]");
		Actions DOB = new Actions(driver);
		DOB.moveToElement(driver.findElement(By.xpath("//tbody/tr//td//span[contains(text(),'"+Date+"')]"))).click().perform();
		return this;
	}
	
	public CardsPage selectEndDate(String Date, String Month, String Year)
	{
		System.out.println("Select Credit Card Statement End Date");
		clickByXpath("//input[@formcontrolname='ed']");
		clickByXpath("//div[@class='dropdowns ng-star-inserted'][2]");
		clickByXpath("//span[@class='mat-option-text'][contains(text(),'"+Year+"')]");
		clickByXpath("//div[@class='dropdowns ng-star-inserted'][1]");
		clickByXpath("//span[@class='mat-option-text'][contains(text(),'"+Month+"')]");
		Actions DOB = new Actions(driver);
		DOB.moveToElement(driver.findElement(By.xpath("//tbody/tr//td//span[contains(text(),'"+Date+"')]"))).click().perform();
		return this;
	}
	
	public CardsPage clickDownloadCreditCardStatement()
	{
		System.out.println("Click Download Card Statement Link");
		clickByXpath("//span[contains(text(),'Download Transactions Report')]");
		return this;
	}
	
	//Pay Credit Card
	public CardsPage clickPayCreditCardLink()
	{
		System.out.println("Click Pay Credit Card Link");
		clickByXpath("(//div[contains(text(),'Pay Credit Card')])[1]");
		return this;
	}
	
	
	
	
		
	public CardsPage verifyCustomerID()
	{
		System.out.println("Verify Customer ID");
		verifyElementisPresent("//*[contains(text(),'Customer ID')]", "Customer ID");
		return this;
	}
	
	public CardsPage verifyHoldingType()
	{
		System.out.println("Verify Holding Type");
		verifyElementisPresent("//*[contains(text(),'Holding Type')]", "Holding Type");
		return this;
	}
	
	public CardsPage verifyDebitCardLinked()
	{
		System.out.println("Verify Debit Card Linked");
		verifyElementisPresent("//*[contains(text(),'Debit Card Linked')]", "Debit Card Linked");
		return this;
	}
	
	public CardsPage verifyCreditLimit()
	{
		System.out.println("Verify Credit Limit");
		verifyElementisPresent("//div[contains(text(),'Credit Limit')]", "Credit Limit");
		return this;
	}
	
	public CardsPage verifyAvailableCreditLimit()
	{
		System.out.println("Verify Available Credit Limit");
		verifyElementisPresent("//div[contains(text(),'Available Credit Limit')]", "Available Credit Limit");
		return this;
	}
	
	public CardsPage verifyTotalRewardPointsAvailable()
	{
		System.out.println("Verify Total Reward Points Available");
		verifyElementisPresent("//span[contains(text(),'Total Reward Points Available')]", "Total Reward Points Available");
		return this;
	}
	
	public CardsPage verifyRedeemedRewardpoints()
	{
		System.out.println("Verify Redeemed Reward points");
		verifyElementisPresent("//span[contains(text(),'Redeemed Reward points')]", "Redeemed Reward points");
		return this;
	}
	
	public CardsPage verifyCardNumberLabel()
	{
		System.out.println("Verify Card Number");
		verifyElementisPresent("//span[contains(text(),'Card Number')]", "Card Number");
		return this;
	}
	
	public CardsPage verifyCardTypeLabel()
	{
		System.out.println("Verify Card Type");
		verifyElementisPresent("//span[contains(text(),'Card Type')]", "Card Type");
		return this;
	}
	
	public CardsPage verifyReasonForUnblockLabel()
	{
		System.out.println("Verify Reason For Unblock Label");
		verifyElementisPresent("//span[contains(text(),'Reason For Unblock')]", "Reason For Unblock");
		return this;
	}
	
	public CardsPage verifyUnblockSuccessMessage()
	{
		System.out.println("Verify Unblock Success Message");
		verifyElementisPresent("//*[contains(text(),'Success ! Card has been unblocked successfully')]", "Success ! Card has been unblocked successfully");
		return this;
	}
				
	public CardsPage userLogOut() throws InterruptedException {
		System.out.println("Logout the User");
		Thread.sleep(2000);
		clickByXpath("(//span[contains(text(), 'Logout')])[2]");
		return this;
	}
}
