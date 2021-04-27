package pages.internetBanking;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

public class AccountsPage extends wrappers.ProjectWrappers  {
		
	public AccountsPage(RemoteWebDriver driver, ExtentTest test)throws Exception{
		this.driver = driver;
		this.test = test;
		openQAIBApplication();
//		openQAApplication();
	}
	
	public AccountsPage loginUsingSMS() throws InterruptedException {
		enterUserName()
	  	.enterPassword()
	  	.takeMeDirectlyTo("Dashboard")
	  	.clickSignInBtn()
	  	.select2FAType("SMS OTP")
	  	.enterSMSOTP()
	  	.clickSubmitBtn2FAPage();
		return this;
	}
		
	public AccountsPage clickUserName() throws InterruptedException{
		System.out.println("Click the User Name");
		Thread.sleep(3000);
		clickById("login_input_username");
		return this;
	}
	
	public AccountsPage enterUserName() throws InterruptedException{
		System.out.println("Enter the User Name");
		Thread.sleep(8000);
		enterByXpath("(//input[@placeholder='Enter'])[1]", "autouser111");
//		enterByXpath("(//input[@placeholder='Enter'])[1]", "debituser23");
		return this;
	}
	
	public AccountsPage clickPassword(){
		System.out.println("Click the Password");
		clickById("login_input_password");
		return this;
	}
	
	public AccountsPage enterPassword(){
		System.out.println("Enter the Password");
		enterByXpath("(//input[@placeholder='Enter'])[2]", "Password12");
//		enterByXpath("(//input[@placeholder='Enter'])[2]", "Qwerty789");
		return this;
	}
	
	public AccountsPage takeMeDirectlyTo(String page)
	{
		System.out.println("Select any one take me directly option");
		clickByXpath("//mat-select[@formcontrolname='directTo']");
	    clickByXpath("//span[@class='mat-option-text'][contains(text(),'"+page+"')]");
		return this;
	}

	public AccountsPage clickSignInBtn()
	{
		System.out.println("Click Sign In button");
		clickByXpath("//button[@type='submit']");
		return this;
	}
		
	public AccountsPage clickNextBtn()
	{
		System.out.println("Click Next button");
		clickByXpath("//button/span[text()='Next']");
		return this;
	}	
	
	public AccountsPage select2FAType(String auth)
	{
		System.out.println("Select 2FA Type");
		clickByXpath("//div//span[text()='Select']");
	    clickByXpath("//span[@class='mat-option-text'][contains(text(),'"+auth+"')]");
		return this;
	}
	
	public AccountsPage enterSMSOTP() throws InterruptedException
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

	public AccountsPage clickResendCodeLink()
	{
		System.out.println("Click Resend Code Link");
		clickByXpath("//span[contains(text(),'Resend code')]");
		return this;
	}
	
	public AccountsPage clickSubmitBtn2FAPage()
	{
		System.out.println("Click Submit button");
		clickByXpath("//button/span[contains(text(),'Submit')]");
		return this;
	}
	
	public AccountsPage verifyDashboardTitle() throws InterruptedException
	{
		System.out.println("Verify Dashboard title");
		verifyElementisPresent("//span[contains(text(), 'Dashboard')]", "Dashboard");
		return this;
	}
	
	public AccountsPage clickAccountsTab() throws InterruptedException
	{
		System.out.println("Click  Accounts Tab");
		clickByXpath("(//span[contains(text(),'Accounts')])[1]");
		return this;
	}
	
	public AccountsPage verifyAccountOverviewHeading() throws InterruptedException
	{
		System.out.println("Verify Account Overview Heading");
		verifyElementisPresent("//div[contains(text(),'Account Overview')]", "Account Overview Heading");
		verifyTextByXpath("//div[contains(text(),'Account Overview')]", "Account Overview");
		return this;
	}
	
	public AccountsPage verifyAccountOverviewPageElements() throws InterruptedException
	{
		System.out.println("Verify Account Overview Page Elements");
		verifyElementisPresent("//span/following::h4[contains(text(),'CASA Accounts')]", "CASA Accounts");
		verifyElementisPresent("//span/following::h4[contains(text(),'Loan Accounts')]", "Loan Accounts");
		verifyElementisPresent("//span/following::h4[contains(text(),'Term Deposits')]", "Term Deposits");
		verifyElementisPresent("(//div[contains(text(),'Account Details')])[1]", "Account Details");
		verifyElementisPresent("(//div[contains(text(),'Pay Bills')])[1]", "Pay Bills");
		verifyElementisPresent("(//div[contains(text(),'Transfer')])[1]", "Transfer");
		return this;
	}
	
	public AccountsPage verifyCASAAccountSummary() throws InterruptedException
	{
		System.out.println("Verify Account Summary");
//		verifyElementisPresent("(//div[@class='mx-rb-float-r'])[1]", "CASA Account Summary");
		verifyElementisPresent("(//div[@id='opertaiveAccounts']//app-over-view/descendant::div[contains(text(),'INR')])[2]/following-sibling::div", "CASA Account Summary");
		return this;
	}	
	
	//Account Overview - Savings Accounts
	public AccountsPage clickSavingsAccounts() throws InterruptedException
	{
		System.out.println("Click Savings Accounts in Account Overview");
		clickByXpath("//span/following::h4[contains(text(),'Savings Accounts')]");
		return this;
	}
	
	public AccountsPage verifySavingsAccountsElements() throws InterruptedException
	{
		System.out.println("Verify Savings Accounts elements in Account Overview Page");
		verifyElementisPresent("(//div[contains(text(),'Account Details')])[1]", "Account Details");
		verifyElementisPresent("(//div[contains(text(),'Pay Bills')])[1]", "Pay Bills");
		verifyElementisPresent("(//div[contains(text(),'Transfer')])[1]", "Transfer");
		return this;
	}
	
	//Savings Accounts - Accounts Details
	public AccountsPage clickAccountDetails() throws InterruptedException
	{
		System.out.println("Click Accounts Details Link in Account Overview");
		clickByXpath("(//div[contains(text(),'Account Details')])[1]");
		return this;
	}
			
	//Savings Accounts - Pay Bills
	public AccountsPage clickPayBills() throws InterruptedException
	{
		System.out.println("Click Pay Bills Link in Account Overview");
		clickByXpath("(//div[contains(text(),'Pay Bills')])[1]");
		return this;
	}
	
	public AccountsPage searchPayBill() throws InterruptedException
	{
		System.out.println("Search Pay Bills in Account Overview");
		enterByXpath("//input[@placeholder='Search with biller name']", "Tamil Nadu Electricity Board");
		return this;
	}
	
	public AccountsPage verifyPayBillPageElements() throws InterruptedException
	{
		System.out.println("Verify Pay Bill Page elements in Account Overview Page");
		verifyElementisPresent("(//div[contains(text(),'Biller Name')])[1]", "Biller Name");
		verifyElementisPresent("(//div[contains(text(),'Biller Nickname')])[1]", "Biller Nickname");
		verifyElementisPresent("(//div[contains(text(),'Outstanding Amount')])[1]", "Outstanding Amount");
		verifyElementisPresent("(//div[contains(text(),'Actions')])[1]", "Actions");
		return this;
	}
	
	public AccountsPage clickPayLink() throws InterruptedException
	{
		System.out.println("Click Pay Link in Account Overview");
		clickByXpath("//span[text()='Pay ']");
		return this;
	}
	
	public AccountsPage verifyPayBillDetails() throws InterruptedException
	{
		System.out.println("Verify Pay Bill Page Details in Account Overview Page");
		verifyElementisPresent("(//h4[contains(text(),'Nickname')]/following::div)[1]", "Nickname");
		verifyElementisPresent("(//h4[contains(text(),'Auto')]/following::div)[1]", "Auto Pay ");
		verifyElementisPresent("//mat-select[@formcontrolname='currency']", "Currency");
		verifyElementisPresent("//button/div[contains(text(),'Now')]", "Now Button");
		verifyElementisPresent("//button/div[contains(text(),'Later')]", "Later Button");
		return this;
	}
	
	public AccountsPage selectCurrency() throws InterruptedException
	{
		System.out.println("Select Currency in Pay Bill flow");
		clickByXpath("//mat-select[@formcontrolname='currency']");
		clickByXpath("//span[@class='mat-option-text' and contains(text(),'INR')]");		
		return this;
	}
	
	public AccountsPage clickNowBtn() throws InterruptedException
	{
		System.out.println("Click Now Btn in Pay Bill");
		clickByXpath("//button/div[contains(text(),'Now')]");
		return this;
	}
	
	public AccountsPage clickConfirmAndPayBtn() throws InterruptedException
	{
		System.out.println("Click Confirm And Pay Btn in Pay Bill");
		clickByXpath("//button/span[contains(text(),'Confirm & Pay')]");
		return this;
	}
	
	public AccountsPage clickEnableAutopayLink() throws InterruptedException
	{
		System.out.println("Click Enable Autopay Link in Pay Bill");
		clickByXpath("//span[contains(text(),'Enable')]");
		return this;
	}
	
	public AccountsPage verifyPayBillSuccessMessage()
	{
		System.out.println("Verify Pay Bill Success Message");
		verifyElementisPresent("//*[contains(text(),'Success ! Your request for payment submitted successfully.')]", "Pay Bill Success Message");
		verifyTextByXpath("//*[contains(text(),'Success ! Your request for payment submitted successfully.')]", "Success ! Your request for payment submitted successfully.");
		return this;
	}
	
	public AccountsPage clickDownloadReceiptBtn() throws InterruptedException
	{
		System.out.println("Click Download Receipt in Pay Bill");
		clickByXpath("//span[contains(text(),'Download Receipt')]");
		return this;
	}
	
	public AccountsPage clickPayBillsBtn() throws InterruptedException
	{
		System.out.println("Click Pay Bills Btn in Pay Bill");
		clickByXpath("//button/span[contains(text(),'Pay Bills')]");
		return this;
	}
	
	//Savings Accounts - Transfer
	public AccountsPage clickTransfer() throws InterruptedException
	{
		System.out.println("Click Transfer Link in Account Overview");
		clickByXpath("(//div[contains(text(),'Transfer')])[1]");
		return this;
	}
	
	public AccountsPage clickTransfersFrom() throws InterruptedException
	{
		System.out.println("Click Transfers From");
		clickByXpath("(//span[@class='ng-arrow-wrapper'])[1]");
		clickByXpath("(//div[@class='ng-option ng-star-inserted'])[1]");	
		return this;
	}
	
	public AccountsPage enterPayeeName() throws InterruptedException
	{
		System.out.println("Enter Payee Name");
		enterByXpathWithRandomNumber("//input[@formcontrolname='creditpayname']", "auto");
		return this;
	}
	
	public AccountsPage enterPayeeActNum() throws InterruptedException
	{
		System.out.println("Enter Payee Act Num");
		String PayeActNum = enterByXpathWithRandomNumbers("//input[@formcontrolname='creditaccountnumber']", "144","6");
		objprop("PayeeAccountNumber", PayeActNum);
		return this;
	}
	
	public AccountsPage reenterPayeeActNum() throws InterruptedException
	{
		System.out.println("Re-Enter Payee Act Num");
		enterByXpath("//input[@formcontrolname='creditconfirmaccountnumber']", getobjprop("PayeeAccountNumber"));
		return this;
	}
	
	public AccountsPage selectBankAndBranch() throws InterruptedException
	{
		System.out.println("Select Bank And Branch");
		clickByXpath("//input[@placeholder='Search Payee Bank & Branch']");	
		Thread.sleep(2000);
		enterByXpath("//input[@placeholder='Type your bank name, branch name or bank code']", "mobeix");
		clickSearchButton();
		scrollDown("(//div[@class='mat-radio-container'])[1]");
		clickByXpath("(//div[@class='mat-radio-container'])[1]");
		clickOKbtn();
		return this;
	}
	
	public AccountsPage selectPaymentCurrency(String Currency)
	{
		System.out.println("Select Payment Currency");
		clickByXpath("//mat-select[@formcontrolname='paymentcurrency']");
	    clickByXpath("//span[@class='mat-option-text'][contains(text(),'"+Currency+"')]");
		return this;
	}
	
	public AccountsPage enterPaymentAmount() throws InterruptedException
	{
		System.out.println("Enter Payment Amount");
		enterByXpath("//input[@placeholder='Payment Amount']", "100");	
		return this;
	}
	
	public AccountsPage clickPaymentWhen(String When) throws InterruptedException
	{
		System.out.println("Click Payment When");
		clickByXpath("//button/div[contains(text(),'"+When+"')]");
		return this;
	}
		
	public AccountsPage clickConfirmAndTransferBtn()
	{
		System.out.println("Click Confirm And Transfer button");
		clickByXpath("//button/span[text()='Confirm & Transfer']");
		return this;
	}	
		
	public AccountsPage verifyTransferSuccessMessage()
	{
		System.out.println("Verify Transfer Success Message");
		verifyElementisPresent("//*[contains(text(),'Success! Your request for Fund Transfer submitted successfully')]", "Transfer Success Message");
		verifyTextByXpath("//*[contains(text(),'Success! Your request for Fund Transfer submitted successfully')]", "Success! Your request for Fund Transfer submitted successfully");
		return this;
	}
	
	public AccountsPage clickSavePayeeBtn() throws InterruptedException
	{
		System.out.println("Click Save Payee Btn in Transfer");
		clickByXpath("//span/span[contains(text(),'Save Payee')]");
		return this;
	}
	
	public AccountsPage clickNewTransfersBtn() throws InterruptedException
	{
		System.out.println("Click New Transfer Btn in Pay Bill");
		clickByXpath("//button/span[contains(text(),'New Transfer')]");
		return this;
	}
		
	//Account Overview - Loan Accounts
	public AccountsPage clickLoanAccounts() throws InterruptedException
	{
		System.out.println("Click Loan Accounts in Account Overview");
		clickByXpath("//span/following::h4[contains(text(),'Loan Accounts')]");
		return this;
	}
	
	public AccountsPage verifyLoanAccountsElements() throws InterruptedException
	{
		System.out.println("Verify Loan Accounts elements in Account Overview Page");
		verifyElementisPresent("(//div[contains(text(),'Loan Details')])[1]", "Loan Details");
		verifyElementisPresent("(//div[contains(text(),'Pay Now')])[1]", "Pay Now");
		return this;
	}
	
	public AccountsPage verifyLoanAccountSummary() throws InterruptedException
	{
		System.out.println("Verify Loan Account Summary");
//		verifyElementisPresent("(//div[@class='mx-rb-float-r'])[last()-1]", "Loan Account Summary");
		verifyElementisPresent("(//div[@id='loanAccounts']//app-over-view/descendant::div[contains(text(),'INR')])[2]/following-sibling::div", "Loan Account Summary");
		return this;
	}
	
	//Loan Accounts - Loan Details
	public AccountsPage clickLoanDetails() throws InterruptedException
	{
		System.out.println("Click Loan Details Link in Account Overview");
		clickByXpath("(//div[contains(text(),'Loan Details')])[1]");
		return this;
	}
	
	public AccountsPage clickEditAccountNickname() throws InterruptedException
	{
		System.out.println("Click Edit Nickname");
		clickByXpath("//span[contains(text(),'Edit')]");
		return this;
	}
	
	public AccountsPage enterNickName() throws InterruptedException
	{
		System.out.println("Enter Nickname");
		enterByXpathWithRandomNumber("//input[@formcontrolname='nickName']","user");
		return this;
	}
	
	public AccountsPage clickUpdateButton() throws InterruptedException
	{
		System.out.println("Click Update Button");
		clickByXpath("//button//span[contains(text(),'Update')]");
		return this;
	}
	
	public AccountsPage verifyNicknameUpdatedSuccessMessage()
	{
		System.out.println("Verify Nick Name Updated Success Message");
		verifyElementisPresent("//h2[contains(text(),'Nickname updated successfully')]", "Nickname updated successfully");
		verifyTextByXpath("//h2[contains(text(),'Nickname updated successfully')]", "Nickname updated successfully");
		return this;
	}
	
	
	public AccountsPage verifyLoanDetailsPageElements() throws InterruptedException
	{
		System.out.println("Verify Loan Details Page Elements");
		verifyElementisPresent("(//span[contains(text(),'Name')]/following::div/div/span)[1]", "Name");
		verifyElementisPresent("(//span[contains(text(),'Account Number')]/following::div/div/span)[1]", "Account Number");
		verifyElementisPresent("(//span[contains(text(),'Date of Opening')]/following::div/div/span)[1]", "Date of Opening");
		verifyElementisPresent("(//span[contains(text(),'Date of Closure')]/following::div/div/span)[1]", "Date of Closure");
		verifyElementisPresent("(//span[contains(text(),'Branch Name')]/following::div/div/span)[1]", "Branch Name");
		verifyElementisPresent("(//span[contains(text(),'Bank Code')]/following::div/div/span)[1]", "Bank Code");
		verifyElementisPresent("(//span[contains(text(),'Nickname')]/following::div/div/span)[1]", "Nickname");
		verifyElementisPresent("(//span[contains(text(),'Status')]/following::div/div/span)[1]", "Status");
		verifyElementisPresent("(//span[contains(text(),'Interest Rate')]/following::div/div/span)[1]", "Interest Rate");
		verifyElementisPresent("//div[contains(text(),'Loan Amounts')]", "Loan Amounts Heading");
		verifyElementisPresent("(//div[contains(text(),'Installments')])[2]", "Installments Heading");
		verifyElementisPresent("(//div[contains(text(),'Payment Information')])[1]", "Payment Information Heading");
		return this;
	}
	
	public AccountsPage verifyLoanDetailsData() throws InterruptedException
	{
		System.out.println("Verify Loan Details data");
		
		String Name = getTextByXpath("(//span[contains(text(),'Name')]/following::div/div/span)[1]");
		verifyTextByXpath("(//span[contains(text(),'Name')]/following::div/div/span)[1]", Name);
		
		String AccountNumber = getTextByXpath("(//span[contains(text(),'Account Number')]/following::div/div/span)[1]");
		verifyTextByXpath("(//span[contains(text(),'Account Number')]/following::div/div/span)[1]", AccountNumber);
		
		String DateOfOpening = getTextByXpath("(//span[contains(text(),'Date of Opening')]/following::div/div/span)[1]");
		verifyTextByXpath("(//span[contains(text(),'Date of Opening')]/following::div/div/span)[1]", DateOfOpening);
		
		String DateOfClosure = getTextByXpath("(//span[contains(text(),'Date of Closure')]/following::div/div/span)[1]");
		verifyTextByXpath("(//span[contains(text(),'Date of Closure')]/following::div/div/span)[1]", DateOfClosure);

		String BranchName = getTextByXpath("(//span[contains(text(),'Branch Name')]/following::div/div/span)[1]");
		verifyTextByXpath("(//span[contains(text(),'Branch Name')]/following::div/div/span)[1]", BranchName);
		
		String BankCode = getTextByXpath("(//span[contains(text(),'Bank Code')]/following::div/div/span)[1]");
		verifyTextByXpath("(//span[contains(text(),'Bank Code')]/following::div/div/span)[1]", BankCode);
		
		String Status = getTextByXpath("(//span[contains(text(),'Status')]/following::div/div/span)[1]");
		verifyTextByXpath("(//span[contains(text(),'Status')]/following::div/div/span)[1]", Status);
		
		String Nickname = getTextByXpath("(//span[contains(text(),'Nickname')]/following::div/div/span)[1]");
		verifyTextByXpath("(//span[contains(text(),'Nickname')]/following::div/div/span)[1]", Nickname);
				
		return this;
	}
			
	public AccountsPage clickLoanTransactionDetailsLink() throws InterruptedException
	{
		System.out.println("Click Loan Transaction Details Link");
		clickByXpath("//div[contains(text(),'Loan Transactions Details')]");
		return this;
	}
	
	//Loan Accounts - Loan Details
	public AccountsPage clickPayNow() throws InterruptedException
	{
		System.out.println("Click Pay Now Link in Account Overview");
		clickByXpath("(//div[contains(text(),'Pay Now')])[1]");
		return this;
	}
	
	public AccountsPage enterLoanPaymentAmount() throws InterruptedException
	{
		System.out.println("Enter Loan Payment Amount");
		enterByXpath("//input[@formcontrolname='paymentamount']", "100");	
		return this;
	}
	
	public AccountsPage clickConfirmBtn() throws InterruptedException
	{
		System.out.println("Click Confirm Btn in Loan Pay Now");
		clickByXpath("//button/span[contains(text(),'Confirm')]");
		return this;
	}
	
	public AccountsPage verifyLoanSuccessMessage()
	{
		System.out.println("Verify Loan Payment Success Message");
		verifyElementisPresent("//*[contains(text(),'Success')]", "Loan Payment Success Message");
		verifyTextByXpath("//*[contains(text(),'Success')]", "Success ! Your request for payment submitted successfully.");
		return this;
	}
	
	public AccountsPage clickAccountDetailsBtn() throws InterruptedException
	{
		System.out.println("Click Accounts Details Btn");
		clickByXpath("//span[contains(text(),'Account Details')]");
		return this;
	}
	
	public AccountsPage clickAccountsBtn() throws InterruptedException
	{
		System.out.println("Click Accounts Btn");
		clickByXpath("//button/span[contains(text(),'Accounts')]");
		return this;
	}
		
	//Account Overview - Term Deposits
	public AccountsPage clickTermDeposits() throws InterruptedException
	{
		System.out.println("Click Term Deposits in Account Overview");
		clickByXpath("//span/following::h4[contains(text(),'Term Deposits')]");
		return this;
	}
	
	public AccountsPage verifyTermDepositsElements() throws InterruptedException
	{
		System.out.println("Verify Term Deposits elements in Account Overview Page");
		verifyElementisPresent("(//div[contains(text(),'Deposit Details')])[1]", "Deposit Details");
		return this;
	}
	
	public AccountsPage verifyDepositAccountSummary() throws InterruptedException
	{
		System.out.println("Verify Deposit Account Summary");
//		verifyElementisPresent("(//div[@class='mx-rb-float-r'])[last()]", "Deposit Account Summary");
		verifyElementisPresent("((//div[@id='opertaiveAccounts'])[2]//app-over-view/descendant::div[contains(text(),'INR')]/following-sibling::div)[1]", "Deposit Account Summary");
		return this;
	}
	
	//Account Tab DropDown flows	
	public AccountsPage clickAccountsTabDropDown() throws InterruptedException
	{
		System.out.println("Click Accounts Tab DropDown");
		clickByXpath("//span[contains(text(),'Accounts')]//following-sibling::span/span");
		Thread.sleep(4000);
		return this;
	}
	
	//Savings Account flow
	public AccountsPage clickSavingsAccountMenu() throws InterruptedException
	{
		System.out.println("Click Savings Account Menu");
		clickByXpath("//button/span[contains(text(),'Savings')]");
		return this;
	}
	
	public AccountsPage selectAccountfromDropDown() throws InterruptedException
	{
		System.out.println("Select Account from DropDown");
		clickByXpath("//div[@class='ng-select-container ng-has-value']/child::span");
		clickByXpath("//div[@class='ng-option ng-option-marked ng-star-inserted']");
		return this;
	}
	
	public AccountsPage verifyAccountsPageElements() throws InterruptedException
	{
		System.out.println("Verify Accounts Page Elements");
//		verifyElementisPresent("//div[contains(text(),'Recent Transactions')]", "Recent Transactions Heading");
		verifyElementisPresent("//div[contains(text(),'Date')]", "Date Heading");
		verifyElementisPresent("//div[contains(text(),'Narration')]", "Narration Heading");
		verifyElementisPresent("//div[contains(text(),'Amount')]", "Amount Heading");
		verifyElementisPresent("//div[contains(text(),'Running')]", "Running Balance Heading");
		return this;
	}
	
	public AccountsPage clickAccountDetailsLink() throws InterruptedException
	{
		System.out.println("Click Account Details Link");
		clickByXpath("//div[contains(text(),'Account Details')]");
		return this;
	}
	
	
	public AccountsPage verifyAccountDetailsHeading() throws InterruptedException
	{
		System.out.println("Verify Account Details Heading");
		verifyElementisPresent("//div[contains(text(),'Account Details')]", "Account Details Heading");
		return this;
	}
		
	public AccountsPage verifyAccountDetailsPageElements() throws InterruptedException
	{
		System.out.println("Verify Account Details Page Elements");
		verifyElementisPresent("(//span[contains(text(),'Name')]/following::div/div/span)[1]", "Name");
		verifyElementisPresent("(//span[contains(text(),'Account Number')]/following::div/div/span)[1]", "Account Number");
		verifyElementisPresent("(//span[contains(text(),'Account Type')]/following::div/div/span)[1]", "Account Type");
		verifyElementisPresent("(//span[contains(text(),'Branch Name')]/following::div/div/span)[1]", "Branch Name");
		verifyElementisPresent("(//span[contains(text(),'Bank Code')]/following::div/div/span)[1]", "Bank Code");
//		verifyElementisPresent("(//span[contains(text(),'Nickname')]/following::div/div/span)[1]", "Nickname");
		verifyElementisPresent("(//span[contains(text(),'Status')]/following::div/div/span)[1]", "Status");
		verifyElementisPresent("(//span[contains(text(),'Customer ID')]/following::div/div/span)[1]", "Customer ID");
		verifyElementisPresent("(//span[contains(text(),'Holding Type')]/following::div/div/span)[1]", "Holding Type");
		return this;
	}
	
	public AccountsPage verifyAccountDetailsData() throws InterruptedException
	{
		System.out.println("Verify Account Details Data");
		
		String Name = getTextByXpath("(//span[contains(text(),'Name')]/following::div/div/span)[1]");
		verifyTextByXpath("(//span[contains(text(),'Name')]/following::div/div/span)[1]", Name);
		
		String AccountNumber = getTextByXpath("(//span[contains(text(),'Account Number')]/following::div/div/span)[1]");
		verifyTextByXpath("(//span[contains(text(),'Account Number')]/following::div/div/span)[1]", AccountNumber);
		
		String AccountType = getTextByXpath("(//span[contains(text(),'Account Type')]/following::div/div/span)[1]");
		verifyTextByXpath("(//span[contains(text(),'Account Type')]/following::div/div/span)[1]", AccountType);

		String BranchName = getTextByXpath("(//span[contains(text(),'Branch Name')]/following::div/div/span)[1]");
		verifyTextByXpath("(//span[contains(text(),'Branch Name')]/following::div/div/span)[1]", BranchName);
		
		String BankCode = getTextByXpath("(//span[contains(text(),'Bank Code')]/following::div/div/span)[1]");
		verifyTextByXpath("(//span[contains(text(),'Bank Code')]/following::div/div/span)[1]", BankCode);
		
		String Status = getTextByXpath("(//span[contains(text(),'Status')]/following::div/div/span)[1]");
		verifyTextByXpath("(//span[contains(text(),'Status')]/following::div/div/span)[1]", Status);
		
//		String Nickname = getTextByXpath("(//span[contains(text(),'Nickname')]/following::div/div/span)[1]");
//		verifyTextByXpath("(//span[contains(text(),'Nickname')]/following::div/div/span)[1]", Nickname);
		
		String CustomerID = getTextByXpath("(//span[contains(text(),'Customer ID')]/following::div/div/span)[1]");
		verifyTextByXpath("(//span[contains(text(),'Customer ID')]/following::div/div/span)[1]", CustomerID);
		
		return this;
	}
	
	public AccountsPage clickAccountSummaryArrowLink() throws InterruptedException
	{
		System.out.println("Click Account Summary Arrow Link");
		clickByXpath("(//div[@class='mx-rb-arrow-right-icon mx-rb-arrow-right-icon-class mx-rb-cursor-pointer'])[1]");
		return this;
	}
		
	public AccountsPage clickAccountTransactionDetailsLink() throws InterruptedException
	{
		System.out.println("Click Account Transaction Details Link");
		clickByXpath("//div[contains(text(),'Account Transactions Details')]");
		return this;
	}
	
	public AccountsPage verifyAccountTransactionsDetailsHeading() throws InterruptedException
	{
		System.out.println("Verify Account Transactions Details Heading");
		verifyElementisPresent("//div[contains(text(),'Account Transactions Details')]", "Account Transactions Details Heading");
		return this;
	}
	
	public AccountsPage clickEmailStatementBtn() throws InterruptedException
	{
		System.out.println("Click Email Statement Btn");
		clickByXpath("//span[contains(text(),'Email Statement')]");
		return this;
	}
	
	public AccountsPage clickLast10Btn() throws InterruptedException
	{
		System.out.println("Click Last 10 Btn");
		clickByXpath("//div[contains(text(),'Last 10')]");
		return this;
	}
	
	public AccountsPage clickLast30Btn() throws InterruptedException
	{
		System.out.println("Click Last 30 Btn");
		clickByXpath("//div[contains(text(),'Last 30')]");
		return this;
	}
	
	public AccountsPage clickLast3MonthsBtn() throws InterruptedException
	{
		System.out.println("Click Last 3 Months Btn");
		clickByXpath("//div[contains(text(),'Last 3 Months')]");
		return this;
	}
	
	public AccountsPage selectCustomStatement() throws InterruptedException
	{
		System.out.println("Select Custom Statement");
		clickCustomStatementBtn();
		selectStartDateForCustomStatement("1", "Feb" , "2021");
		selectEndDateForCustomStatement("1", "Apr" , "2021");
		clickViewStatementBtn();
		return this;
	}
	
	public AccountsPage clickCustomStatementBtn() throws InterruptedException
	{
		System.out.println("Click Custom Statement Btn");
		clickByXpath("//div[contains(text(),'Custom')]");
		clickByXpath("//input[@formcontrolname='sd']");
		return this;
	}
	
	public AccountsPage selectStartDateForCustomStatement(String Date, String Month, String Year) throws InterruptedException
	{
		System.out.println("Select Start Date For Custom Statement");
//		clickByXpath("//input[@formcontrolname='sd']");
		clickByXpath("//div[@class='dropdowns ng-star-inserted'][2]");
		clickByXpath("//span[@class='mat-option-text'][contains(text(),'"+Year+"')]");
		clickByXpath("//div[@class='dropdowns ng-star-inserted'][1]");
		clickByXpath("//span[@class='mat-option-text'][contains(text(),'"+Month+"')]");
		Actions DOB = new Actions(driver);
		DOB.moveToElement(driver.findElement(By.xpath("//tbody/tr//td//span[contains(text(),'"+Date+"')]"))).click().perform();
//		clickByXpath("//td[@class='active available end-date in-range start-date today ng-star-inserted']");
		return this;
	}
	
	public AccountsPage selectEndDateForCustomStatement(String Date, String Month, String Year) throws InterruptedException
	{
		System.out.println("Select End Date For Custom Statement");
		clickByXpath("//input[@formcontrolname='ed']");
		clickByXpath("//div[@class='dropdowns ng-star-inserted'][2]");
		clickByXpath("//span[@class='mat-option-text'][contains(text(),'"+Year+"')]");
		clickByXpath("//div[@class='dropdowns ng-star-inserted'][1]");
		clickByXpath("//span[@class='mat-option-text'][contains(text(),'"+Month+"')]");
		Actions DOB = new Actions(driver);
		DOB.moveToElement(driver.findElement(By.xpath("//tbody/tr//td//span[contains(text(),'"+Date+"')]"))).click().perform();
//		clickByXpath("//td[@class='active available end-date start-date today ng-star-inserted']");
		return this;
	}
	
	public AccountsPage downloadStatement() throws InterruptedException
	{
		System.out.println("Download Statement");
		Thread.sleep(3000);
		clickById("downloadBtn");
	    clickByXpath("//div[@class='option ng-star-inserted'][contains(text(),'PDF')]");
		return this;
	}	
	
	public AccountsPage clickViewStatementBtn() throws InterruptedException
	{
		System.out.println("Click View Statement Btn");
		Thread.sleep(3000);
		clickByXpath("//span[contains(text(),'View')]");
		return this;
	}
	
	public AccountsPage clickBackBtn() throws InterruptedException
	{
		System.out.println("Click Back Btn");
		clickByXpath("//button/span[contains(text(),'Back')]");
		return this;
	}
	
	//Term Deposit Account flow
	public AccountsPage clickTermDepositDetails() throws InterruptedException
	{
		System.out.println("Click Term Deposit Details");
		clickByXpath("//div[contains(text(),'Deposit Details')]");
		return this;
	}
	
	public AccountsPage verifyTermDepositPageElements() throws InterruptedException
	{
		System.out.println("Verify Term Deposit Page Elements");
		verifyElementisPresent("(//span[contains(text(),'Name')]/following::div/div/span)[1]", "Name");
		verifyElementisPresent("(//span[contains(text(),'Account Number')]/following::div/div/span)[1]", "Account Number");
		verifyElementisPresent("(//span[contains(text(),'Date of Opening')]/following::div/div/span)[1]", "Date of Opening");
		verifyElementisPresent("(//span[contains(text(),'Branch Name')]/following::div/div/span)[1]", "Branch Name");
		verifyElementisPresent("(//span[contains(text(),'Bank Code')]/following::div/div/span)[1]", "Bank Code");
		verifyElementisPresent("(//span[contains(text(),'Nickname')]/following::div/div/span)[1]", "Nickname");
		verifyElementisPresent("(//span[contains(text(),'Status')]/following::div/div/span)[1]", "Status");
		verifyElementisPresent("(//span[contains(text(),'Date of Maturity')]/following::div/div/span)[1]", "Date of Maturity");
//		verifyElementisPresent("(//span[contains(text(),'Holding Type')]/following::div/div/span)[1]", "Holding Type");
		verifyElementisPresent("(//span[contains(text(),'Deposit Tenure')]/following::div/div/span)[1]", "Deposit Tenure");
		verifyElementisPresent("(//span[contains(text(),'Rate of Interest')]/following::div/div/span)[1]", "Rate of Interest");
		verifyElementisPresent("(//span[contains(text(),'Maturity Options')]/following::div/div/span)[1]", "Maturity Options");
		return this;
	}
	
	public AccountsPage verifyTermDepositData() throws InterruptedException
	{
		System.out.println("Verify Term Deposit data");
		
		String Name = getTextByXpath("(//span[contains(text(),'Name')]/following::div/div/span)[1]");
		verifyTextByXpath("(//span[contains(text(),'Name')]/following::div/div/span)[1]", Name);
		
		String AccountNumber = getTextByXpath("(//span[contains(text(),'Account Number')]/following::div/div/span)[1]");
		verifyTextByXpath("(//span[contains(text(),'Account Number')]/following::div/div/span)[1]", AccountNumber);
		
		String DateOfOpening = getTextByXpath("(//span[contains(text(),'Date of Opening')]/following::div/div/span)[1]");
		verifyTextByXpath("(//span[contains(text(),'Date of Opening')]/following::div/div/span)[1]", DateOfOpening);
		
		String DateOfMaturity = getTextByXpath("(//span[contains(text(),'Date of Maturity')]/following::div/div/span)[1]");
		verifyTextByXpath("(//span[contains(text(),'Date of Maturity')]/following::div/div/span)[1]", DateOfMaturity);

		String BranchName = getTextByXpath("(//span[contains(text(),'Branch Name')]/following::div/div/span)[1]");
		verifyTextByXpath("(//span[contains(text(),'Branch Name')]/following::div/div/span)[1]", BranchName);
		
		String BankCode = getTextByXpath("(//span[contains(text(),'Bank Code')]/following::div/div/span)[1]");
		verifyTextByXpath("(//span[contains(text(),'Bank Code')]/following::div/div/span)[1]", BankCode);
		
		String Status = getTextByXpath("(//span[contains(text(),'Status')]/following::div/div/span)[1]");
		verifyTextByXpath("(//span[contains(text(),'Status')]/following::div/div/span)[1]", Status);
		
		String Nickname = getTextByXpath("(//span[contains(text(),'Nickname')]/following::div/div/span)[1]");
		verifyTextByXpath("(//span[contains(text(),'Nickname')]/following::div/div/span)[1]", Nickname);
		
		String DepositTenure = getTextByXpath("(//span[contains(text(),'Deposit Tenure')]/following::div/div/span)[1]");
		verifyTextByXpath("(//span[contains(text(),'Deposit Tenure')]/following::div/div/span)[1]", DepositTenure);
		
		return this;
	}
	
	public AccountsPage clickDepositTransactionsLink() throws InterruptedException
	{
		System.out.println("Click Deposit Transactions Details");
		clickByXpath("//div[contains(text(),'Deposit Transactions Details')]");
		return this;
	}
	
	public AccountsPage verifyDepositTransactionsDetailsHeading() throws InterruptedException
	{
		System.out.println("Verify Deposit Transactions Details Heading");
		verifyElementisPresent("//div[contains(text(),'Deposit Transactions Details')]", "Deposit Transactions Details Heading");
		return this;
	}
	
	//Loan Account flow

	public AccountsPage clickLoanAccountMenu() throws InterruptedException
	{
		System.out.println("Click Loan Account Menu");
		clickByXpath("//button/span[contains(text(),'Loan')]");
		return this;
	}
	
	public AccountsPage clickLoanStatementLink() throws InterruptedException
	{
		System.out.println("Click Loan Statement Link");
		clickByXpath("//div[contains(text(),'Loan Statement')]");
		return this;
	}
	
	public AccountsPage verifyLoanStatementHeading() throws InterruptedException
	{
		System.out.println("Verify Loan Statement Heading");
		verifyElementisPresent("//div[contains(text(),'Loan Transactions Details')]", "Loan Transactions Details Heading");
		return this;
	}
		
	public AccountsPage clickSubmitBtn()
	{
		System.out.println("Click Submit button");
		clickByXpath("//button/span[contains(text(),'Submit')]");
		return this;
	}
	
	public AccountsPage clickCancelBtn()
	{
		System.out.println("Click Cancel button");
		clickByXpath("//button/span[text()='Cancel']");
		return this;
	}
	
	public AccountsPage verifyCaneclPopUp()
	{
		System.out.println("Verify Canecl Pop Up");
		verifyElementisPresent("//p[contains(text(),'Are you sure you want to discard the changes?')]", "Cancel Pop Up");
		verifyTextByXpath("//p[contains(text(),'Are you sure you want to discard the changes?')]", "Are you sure you want to discard the changes?");
		return this;
	}
	
	public AccountsPage clickYesbtn() {
		System.out.println("Click YES button");
		clickByXpath("//button/span[contains(text(),'Yes')]");
		return this;
	}
	
	public AccountsPage clickOKbtn() {
		System.out.println("Click OK button");
		clickByXpath("//button/span[contains(text(),'OK')]");
		return this;
	}
	
	public AccountsPage clickEscapeButton()
	{
		System.out.println("Click Escape Button");
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ESCAPE).build().perform();
		return this;
	}
			
	public AccountsPage clickSearchButton()
	{
		System.out.println("Click Search Button");
		clickByXpath("//span[contains(text(),'Search')]/parent::button");
		return this;
	}	
		
	public AccountsPage enterRemarks() 
	{
		System.out.println("Enter Remarks");
		enterByXpath("//*[@formcontrolname='remarks']", "test");	
		return this;
	}
	
	public AccountsPage clickNextButton()
	{
		System.out.println("Click Next Button");
		clickByXpath("//span[contains(text(),'Next')]/parent::button");
		return this;
	}
	
	public AccountsPage userLogOut() throws InterruptedException {
		System.out.println("Logout the User");
		Thread.sleep(2000);
		clickByXpath("(//span[contains(text(), 'Logout')])[2]");
		return this;
	}
}
