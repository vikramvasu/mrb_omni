package  pages.internetBanking;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

public class PayeePage extends wrappers.ProjectWrappers  {
	
	public static String SameBankPayeeAccountNumber;
	public static String SameBankPayeeNickName;
	public static String LocalBankPayeeAccountNumber;
	public static String LocalBankPayeeName;
	public static String LocalBankPayeeNickName;
	public static String InternationalBankPayeeName;
	public static String InternationalBankPayeeAccountNumber;
	public static String InternationalBankPayeeNickName;
		
	public PayeePage(RemoteWebDriver driver, ExtentTest test)throws Exception{
		this.driver = driver;
		this.test = test;
		openQAIBApplication();
	}
	
	public PayeePage loginUsingSMS() throws InterruptedException {
		enterUserName()
	  	.enterPassword()
	  	.takeMeDirectlyTo("Dashboard")
	  	.clickSignInBtn()
	  	.select2FAType("SMS OTP")
	  	.enterSMSOTP()
	  	.clickSubmitBtn2FAPage();
		return this;
	}
		
	public PayeePage clickUserName() throws InterruptedException{
		System.out.println("Click the User Name");
		Thread.sleep(3000);
		clickById("login_input_username");
		return this;
	}
	
	public PayeePage enterUserName() throws InterruptedException{
		System.out.println("Enter the User Name");
		Thread.sleep(4000);
//		enterByXpath("(//input[@placeholder='Enter'])[1]", "deposituser12");
		enterByXpath("(//input[@placeholder='Enter'])[1]", "daverichard04");
		return this;
	}
	
	public PayeePage clickPassword(){
		System.out.println("Click the Password");
		clickById("login_input_password");
		return this;
	}
	
	public PayeePage enterPassword(){
		System.out.println("Enter the Password");
//		enterByXpath("(//input[@placeholder='Enter'])[2]", "Qwerty321");
		enterByXpath("(//input[@placeholder='Enter'])[2]", "Password12");
		return this;
	}
	
	public PayeePage takeMeDirectlyTo(String page)
	{
		System.out.println("Select any one take me directly option");
		clickByXpath("//mat-select[@formcontrolname='directTo']");
	    clickByXpath("//span[@class='mat-option-text'][contains(text(),'"+page+"')]");
		return this;
	}

	public PayeePage clickSignInBtn()
	{
		System.out.println("Click Sign In button");
		clickByXpath("//button[@type='submit']");
		return this;
	}
		
	public PayeePage clickNextBtn()
	{
		System.out.println("Click Next button");
		clickByXpath("//button/span[text()='Next']");
		return this;
	}	
	
	public PayeePage select2FAType(String auth)
	{
		System.out.println("Select 2FA Type");
		clickByXpath("//div//span[contains(text(),'Select')]");
	    clickByXpath("//span[@class='mat-option-text'][contains(text(),'"+auth+"')]");
		return this;
	}
	
	public PayeePage enterSMSOTP() throws InterruptedException
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

	public PayeePage clickResendCodeLink()
	{
		System.out.println("Click Resend Code Link");
		clickByXpath("//span[contains(text(),'Resend code')]");
		return this;
	}
	
	public PayeePage clickSubmitBtn2FAPage()
	{
		System.out.println("Click Submit button");
		clickByXpath("//button/span[contains(text(),'Submit')]");
		return this;
	}
	
	public PayeePage verifyDashboardTitle() throws InterruptedException
	{
		System.out.println("Verify Dashboard title");
		Thread.sleep(4000);
		verifyElementisPresent("//span[contains(text(), 'Dashboard')]", "Dashboard");
		return this;
	}
	
	public PayeePage clickTransfersTab() throws InterruptedException
	{
		System.out.println("Click Transfers Tab");
		clickByXpath("//span[contains(text(),'Transfers')]");
		Thread.sleep(4000);
		return this;
	}
	
	public PayeePage clickTransfersArrow() throws InterruptedException
	{
		System.out.println("Click Transfers Arrow");
		clickByXpath("//span[contains(text(),'Transfers')]/parent::a/child::span/span");
		Thread.sleep(4000);
		return this;
	}
	
	public PayeePage selectManagePayee()
	{
		System.out.println("Select Manage Payee");
		clickByXpath("//span[contains(text(),'Manage Payee')]");
		return this;
	}
	
	public PayeePage verifyManagePayeeHeading() throws InterruptedException
	{
		System.out.println("Verify Manage Payee Heading");
		clickByXpath("//div[@class='mx-rb-page-sub-title' and contains(text(),'Manage Payees')]");
		return this;
	}
		
	public PayeePage clickNewPayeeButton()
	{
		System.out.println("Click New Payee Button");
		clickByXpath("//button/span/span[contains(text(),'New Payee')]");
		return this;
	}
	
	public PayeePage clickSameBankPayee()
	{
		System.out.println("Click Same Bank Payee");
		clickByXpath("//button/span[contains(text(),'Same Bank Payee')]");
		return this;
	}
	
	public PayeePage enterSameBankAccountNumber()
	{
		System.out.println("Enter Same Bank Account Number");
		SameBankPayeeAccountNumber = enterByXpathWithRandomNumbers("//input[@formcontrolname='encan']", "144", "6");
		objprop("SameBankPayeeAccountNumber", SameBankPayeeAccountNumber);
		return this;
	}
	
	public PayeePage enterSameBankPayeeNickName()
	{
		System.out.println("Enter Same Bank Payee Nick Name");
		SameBankPayeeNickName = enterByXpathWithRandomNumber("//input[@formcontrolname='pnn']", "SBPNN");
		objprop("SameBankPayeeNickName", SameBankPayeeNickName);
		return this;
	}	

	public PayeePage clickLocalBankPayee()
	{
		System.out.println("Click Local Bank Payee");
		clickByXpath("//button/span[contains(text(),'Local Bank Payee')]");
		return this;
	}	
	
	public PayeePage enterLocalBankPayeeName() throws InterruptedException
	{
		System.out.println("Enter Local Bank Payee Name");
		Thread.sleep(4000);
		LocalBankPayeeName = enterByXpathWithRandomNumber("//input[@formcontrolname='pn']", "LBPN");
		objprop("LocalBankPayeeName", LocalBankPayeeName);
		return this;
	}	
		
	public PayeePage enterLocalBankAccountNumber()
	{
		System.out.println("Enter Local Bank Account Number");
		LocalBankPayeeAccountNumber = enterByXpathWithRandomNumbers("//input[@formcontrolname='encan']", "144", "7");
		objprop("LocalBankPayeeAccountNumber", LocalBankPayeeAccountNumber);
		return this;
	}
	
	public PayeePage reenterLocalBankAccountNumber()
	{
		System.out.println("Re-enter Local Bank Account Number");
		enterByXpath("//input[@formcontrolname='rean']", getobjprop("LocalBankPayeeAccountNumber"));
		return this;
	}
	
	public PayeePage selectLocalPayeeBank()
	{
		System.out.println("Select Local Payee Bank");
		clickByXpath("//input[@formcontrolname='pbc']");
//		enterByXpath("//input[@formcontrolname='qs']", bankName);
		enterByXpath("//input[@formcontrolname='qs']", "Mobeix");		
//		clickByXpath("//span[contains(text(),'Select')]/preceding::h4[text()='Bank']");
//		clickByXpath("//span[@class='mat-option-text' and contains(text(),'Bank of Sydney')]");
//		clickByXpath("//span[contains(text(),'Select')]/preceding::h4[contains(text(),'City')]");
//		clickByXpath("//span[@class='mat-option-text' and contains(text(),'Chennai')]");
//		clickByXpath("//span[contains(text(),'Select')]/preceding::h4[text()='Branch']");
//		clickByXpath("//span[@class='mat-option-text' and contains(text(),'')]");					
		
		clickByXpath("//span[contains(text(),'Search')]/parent::button");
		scrollDown("(//div[@class='mat-radio-container'])[1]");
		clickByXpath("(//div[@class='mat-radio-container'])[1]");
		
		return this;
	}	
		
	public PayeePage selectBankAndBranch()
	{
		System.out.println("Select Local Bank And Branch");
		clickByXpath("//input[@formcontrolname='pbc']");
//		enterByXpath("//input[@formcontrolname='qs']", bankName);
		
		enterByXpath("//input[@formcontrolname='qs']", "Mobeix");
		clickByXpath("(//h4[text()='Bank']/parent::div/child::mat-form-field/div/child::div/div)[3]");
		clickByXpath("//span[@class='mat-option-text' and contains(text(),'Mobeix')]");
		clickByXpath("(//h4[text()='City']/parent::div/child::mat-form-field/div/child::div/div)[3]");
		clickByXpath("//span[@class='mat-option-text' and contains(text(),'Chennai')]");
		clickByXpath("(//h4[text()='Branch']/parent::div/child::mat-form-field/div/child::div/div)[3]");
		clickByXpath("//span[@class='mat-option-text' and contains(text(),'Mobeix')]");					
		
		clickByXpath("//span[contains(text(),'Search')]/parent::button");
		scrollDown("(//div[@class='mat-radio-container'])[1]");
		clickByXpath("(//div[@class='mat-radio-container'])[1]");
		
		return this;
	}	
	
	public PayeePage enterLocalBankPayeeNickName()
	{
		System.out.println("Enter Local Bank Payee Nick Name");
		LocalBankPayeeNickName = enterByXpathWithRandomNumber("//input[@formcontrolname='pnn']", "LBPNN");
		objprop("LocalBankPayeeNickName", LocalBankPayeeNickName);
		return this;
	}	
	
	public PayeePage clickInternationalPayee()
	{
		System.out.println("Click International Payee");
		clickByXpath("//button/span[contains(text(),'International Payee')]");
		return this;
	}
	
	public PayeePage enterInternationalBankPayeeName()
	{
		System.out.println("Enter International Bank Payee Name");
		InternationalBankPayeeName = enterByXpathWithRandomNumber("//input[@formcontrolname='pn']", "IBPN");
		objprop("InternationalBankPayeeName", InternationalBankPayeeName);
		return this;
	}	
		
	public PayeePage enterInternationalBankAccountNumber()
	{
		System.out.println("Enter International Bank Account Number");
		InternationalBankPayeeAccountNumber = enterByXpathWithRandomNumbers("//input[@formcontrolname='enc_an']", "144", "8");
		objprop("InternationalBankPayeeAccountNumber", InternationalBankPayeeAccountNumber);
		return this;
	} 
	
	public PayeePage reenterInternationalBankAccountNumber()
	{
		System.out.println("Re-enter International Bank Account Number");
		enterByXpath("//input[@formcontrolname='c_enc_an']", getobjprop("InternationalBankPayeeAccountNumber"));
		return this;
	}
	
	public PayeePage enterIntAddress1(String addressFirst){
		System.out.println("Enter International Address 1");
		enterByXpath("//input[@formcontrolname='pal1']", addressFirst);
		return this;
	}
	
	public PayeePage enterIntAddress2(String addressSecond){
		System.out.println("Enter International Address 2");
		enterByXpath("//input[@formcontrolname='pal2']", addressSecond);
		return this;
	}
	
	public PayeePage selectIntCountry(String countryName)
	{
		System.out.println("Select International Country");
//		clickByXpath("//*[@formcontrolname='pac']/child::div/div/span[text()='Select']");
		clickByXpath("//*[@formcontrolname='pac']/child::div/div/span");
		clickByXpath("//span[contains(text(),'"+countryName+"')]");
		return this;
	}	
	
	public PayeePage selectIntMobileNumber(String countryCode, String mobileNumber) throws InterruptedException
	{
		System.out.println("Select Country Code and Enter Mobile Number");
		// passing country code
		clickByXpath("//div/span[contains(text(),'Cou..')]");
		clickByXpath("//span[contains(text(),'"+countryCode+"')]");
		Thread.sleep(3000);
		// Passing Mobile Number
		enterByXpath("//input[@formcontrolname='pmn']", mobileNumber);
		return this;
	}
	
	public PayeePage selectInternationalPayeeBank()
	{
		System.out.println("Select International Payee Bank");
		clickByXpath("//input[@formcontrolname='pbcc']");
//		enterByXpath("//input[@formcontrolname='qs']", bankName);
		enterByXpath("//input[@formcontrolname='qs']", "Mobeix");
		clickByXpath("//span[contains(text(),'Search')]/parent::button");
		
//		clickByXpath("//span[contains(text(),'Select')]/preceding::h4[text()='Bank']");
//		clickByXpath("//span[@class='mat-option-text' and contains(text(),'Bank of Sydney')]");
//		clickByXpath("//span[contains(text(),'Select')]/preceding::h4[contains(text(),'City')]");
//		clickByXpath("//span[@class='mat-option-text' and contains(text(),'Chennai')]");
//		clickByXpath("//span[contains(text(),'Select')]/preceding::h4[text()='Branch']");
//		clickByXpath("//span[@class='mat-option-text' and contains(text(),'')]");					
		
		clickByXpath("//span[contains(text(),'Search')]/parent::button");
		scrollDown("(//div[@class='mat-radio-container'])[1]");
		clickByXpath("(//div[@class='mat-radio-container'])[1]");
		
		return this;
	}	
	
	public PayeePage enterInternationalBankPayeeNickName()
	{
		System.out.println("Enter International Bank Payee Nick Name");
		InternationalBankPayeeNickName = enterByXpathWithRandomNumber("//input[@formcontrolname='pnn']", "IBPNN");
		objprop("InternationalBankPayeeNickName", InternationalBankPayeeNickName);
		return this;
	}	
	
	public PayeePage verifyPayeeSuccessMessage()
	{
		System.out.println("Verify Payee Success Message");
		verifyElementisPresent("//*[contains(text(),'Success! The payee added successfully.')]", "CASA Account Success Message");
		verifyTextByXpath("//*[contains(text(),'Success! The payee added successfully.')]", "Success! The payee added successfully.");
		return this;
	}

	public PayeePage clickAnotherPayeeButton()
	{
		System.out.println("Click Another Payee Button");
		clickByXpath("//button/span[contains(text(),'Add Another Payee')]");
		return this;
	}
	
	public PayeePage clickNewTransferButton()
	{
		System.out.println("Click New Transfer Button");
		clickByXpath("//button/span[contains(text(),'New Transfer')]");
		return this;
	}
	
	public PayeePage clickConfirmBtn()
	{
		System.out.println("Click Confirm button");
		clickByXpath("//button/span[text()='Confirm']");
		return this;
	}	
	
	public PayeePage clickOKbtn() {
		System.out.println("Click OK button");
		clickByXpath("//button/span[contains(text(),'OK')]");
		return this;
	}
	
	// View, Edit and Delete Link
	public PayeePage searchSameBankPayee()
	{
		System.out.println("Search Same Bank Payee");
		enterByXpath("//input[@formcontrolname='searchField']",getobjprop("SameBankPayeeNickName"));
		return this;
	}
	
	public PayeePage clickPayeeViewLink()
	{
		System.out.println("Click Payee View Link");
//		clickByXpath("//div[contains(text(),'"+getobjprop("SameBankPayeeNickName")+"')]/parent::div/parent::div/parent::div/child::div/div/span/p[contains(text(),'View')]");
		clickByXpath("//span/p[contains(text(),'View')]");
		return this;
	}	
	
	public PayeePage verifySameBankPayeeDetails()  {
		System.out.println("Verify Same Bank Payee Details");
		verifyTextByXpath("(//span[contains(text(),'Payee Type')]/parent::div/parent::div/parent::div/following::div)[1]/div/div/span", "Same Bank Payee");
//		verifyTextByXpath("((//span[contains(text(),'Payee Account')]/parent::div/parent::div/parent::div/following::div)[1]/div/div)[1]", getobjprop("SameBankPayeeAccountNumber"));
//		verifyTextByXpath("((//span[contains(text(),'Payee Name')]/parent::div/parent::div/parent::div/following::div)[1]/div/div)[1]", getobjprop("SameBankPayeeNickName"));
//		verifyTextByXpath("((//span[contains(text(),'Payee Nick')]/parent::div/parent::div/parent::div/following::div)[1]/div/div)[1]", getobjprop("SameBankPayeeNickName"));

		verifyElementisPresent("((//span[contains(text(),'Payee Account')]/parent::div/parent::div/parent::div/following::div)[1]/div/div)[1]", "Same Bank Payee Account Number");
		verifyElementisPresent("((//span[contains(text(),'Payee Name')]/parent::div/parent::div/parent::div/following::div)[1]/div/div)[1]", "Same Bank Payee Name");
		verifyElementisPresent("((//span[contains(text(),'Payee Nick')]/parent::div/parent::div/parent::div/following::div)[1]/div/div)[1]", "Same Bank Payee Nick Name");
		return this;
	}
	
	public PayeePage searchLocalBankPayee()
	{
		System.out.println("Search Local Bank Payee");
		enterByXpath("//input[@formcontrolname='searchField']",getobjprop("LocalBankPayeeNickName"));
		return this;
	}
	
	public PayeePage verifyLocalBankPayeeDetails()  {
		System.out.println("Verify Local Bank Payee Details");
		System.out.println("Verify Same Bank Payee Details");
		verifyTextByXpath("(//span[contains(text(),'Payee Type')]/parent::div/parent::div/parent::div/following::div)[1]/div/div/span", "Local Bank Payee");
//		verifyTextByXpath("((//span[contains(text(),'Payee Account')]/parent::div/parent::div/parent::div/following::div)[1]/div/div)[1]", getobjprop("LocalBankPayeeAccountNumber"));
		verifyTextByXpath("((//span[contains(text(),'Payee Name')]/parent::div/parent::div/parent::div/following::div)[1]/div/div)[1]", getobjprop("LocalBankPayeeName"));
		verifyTextByXpath("((//span[contains(text(),'Payee Nick')]/parent::div/parent::div/parent::div/following::div)[1]/div/div)[1]", getobjprop("LocalBankPayeeNickName"));
		
		verifyElementisPresent("((//span[contains(text(),'Payee Account')]/parent::div/parent::div/parent::div/following::div)[1]/div/div)[1]", "Local Bank Payee Account Number");
//		verifyElementisPresent("((//span[contains(text(),'Payee Name')]/parent::div/parent::div/parent::div/following::div)[1]/div/div)[1]", "Local Bank Payee Name");
//		verifyElementisPresent("((//span[contains(text(),'Payee Nick')]/parent::div/parent::div/parent::div/following::div)[1]/div/div)[1]", "Local Bank Payee Nick Name");
		return this;
	}
		
	public PayeePage searchInternationalBankPayee()
	{
		System.out.println("Search International Bank Payee");
		enterByXpath("//input[@formcontrolname='searchField']",getobjprop("InternationalBankPayeeNickName"));
		return this;
	}
	
	public PayeePage verifyInternationalBankPayeeDetails()  {
		System.out.println("Verify International Bank Payee Details");
		System.out.println("Verify Same Bank Payee Details");
		verifyTextByXpath("(//span[contains(text(),'Payee Type')]/parent::div/parent::div/parent::div/following::div)[1]/div/div/span", "International Payee");
//		verifyTextByXpath("((//span[contains(text(),'Payee Account')]/parent::div/parent::div/parent::div/following::div)[1]/div/div)[1]", getobjprop("InternationalBankPayeeAccountNumber"));
		verifyTextByXpath("((//span[contains(text(),'Payee Name')]/parent::div/parent::div/parent::div/following::div)[1]/div/div)[1]", getobjprop("InternationalBankPayeeName"));
		verifyTextByXpath("((//span[contains(text(),'Payee Nick')]/parent::div/parent::div/parent::div/following::div)[1]/div/div)[1]", getobjprop("InternationalBankPayeeNickName"));
		
		verifyElementisPresent("((//span[contains(text(),'Payee Account')]/parent::div/parent::div/parent::div/following::div)[1]/div/div)[1]", "International Bank Payee Account Number");
//		verifyElementisPresent("((//span[contains(text(),'Payee Name')]/parent::div/parent::div/parent::div/following::div)[1]/div/div)[1]", "International Bank Payee Name");
//		verifyElementisPresent("((//span[contains(text(),'Payee Nick')]/parent::div/parent::div/parent::div/following::div)[1]/div/div)[1]", "International Bank Payee Nick Name");
		return this;
	}
	
	public PayeePage clickBackButton()
	{
		System.out.println("Click Back Button");
		clickByXpath("//span[contains(text(),'Back')]");
		return this;
	}
	
	public PayeePage clickBackHomeButton()
	{
		System.out.println("Click Back Home Button");
		clickByXpath("//span[contains(text(),'Back Home')]");
		return this;
	}
	
	public PayeePage clickEditLink()
	{
		System.out.println("Click Payee Edit Link");
//		clickByXpath("//div[contains(text(),'"+getobjprop("SameBankPayeeNickName")+"')]/parent::div/parent::div/parent::div/child::div/div/span/p[contains(text(),'Edit')]");
		clickByXpath("//span/p[contains(text(),'Edit')]");
		return this;
	}	
	
	public PayeePage verifyPayeeUpdateSuccessMessage()  {
		System.out.println("Verify Payee Update Success Message");
		verifyElementisPresent("//h3[contains(text(),'Success! The payee has been updated successfully.')]", "Success! The payee has been updated successfully.");
		return this;
	}
	
	public PayeePage clickDeleteLink()
	{
		System.out.println("Click Payee Delete Link");
//		clickByXpath("//div[contains(text(),'"+getobjprop("SameBankPayeeNickName")+"')]/parent::div/parent::div/parent::div/child::div/div/span/p[contains(text(),'Delete')]");
		clickByXpath("//span/p[contains(text(),'Delete')]");
		return this;
	}	

	public PayeePage clickDeletePayeeButton()
	{
		System.out.println("Click Delete Payee Button");
		clickByXpath("//button/span[contains(text(),'Delete Payee')]");
		return this;
	}	
	
	public PayeePage verifyPayeeDeleteSuccessMessage()  {
		System.out.println("Verify Payee Delete Success Message");
		verifyElementisPresent("//h3[contains(text(),'Success! Your payee has been deleted successfully')]", "Success! Your payee has been deleted successfully");
		return this;
	}
	
	
	
	
	
	
	
	
	public PayeePage userLogOut() throws InterruptedException {
		System.out.println("Logout the User");
		Thread.sleep(2000);
		clickByXpath("(//span[contains(text(), 'Logout')])[2]");
		return this;
	}
}
