package  pages.internetBanking;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

public class DashboardPage extends wrappers.ProjectWrappers  {
		
	public DashboardPage(RemoteWebDriver driver, ExtentTest test)throws Exception{
		this.driver = driver;
		this.test = test;
		openQAIBApplication();
	}
	
	public DashboardPage loginUsingSMS() throws InterruptedException {
		enterUserName()
	  	.enterPassword()
	  	.takeMeDirectlyTo("Dashboard")
	  	.clickSignInBtn()
	  	.select2FAType("SMS OTP")
	  	.enterSMSOTP()
	  	.clickSubmitBtn2FAPage();
		return this;
	}
		
	public DashboardPage clickUserName() throws InterruptedException{
		System.out.println("Click the User Name");
		Thread.sleep(3000);
		clickById("login_input_username");
		return this;
	}
	
	public DashboardPage enterUserName() throws InterruptedException{
		System.out.println("Enter the User Name");
		Thread.sleep(3000);
		enterByXpath("(//input[@placeholder='Enter'])[1]", "deposituser12");
		return this;
	}
	
	public DashboardPage clickPassword(){
		System.out.println("Click the Password");
		clickById("login_input_password");
		return this;
	}
	
	public DashboardPage enterPassword(){
		System.out.println("Enter the Password");
		enterByXpath("(//input[@placeholder='Enter'])[2]", "Qwerty321");
		return this;
	}
	
	public DashboardPage takeMeDirectlyTo(String page)
	{
		System.out.println("Select any one take me directly option");
		clickByXpath("//mat-select[@formcontrolname='directTo']");
	    clickByXpath("//span[@class='mat-option-text'][contains(text(),'"+page+"')]");
		return this;
	}

	public DashboardPage clickSignInBtn()
	{
		System.out.println("Click Sign In button");
		clickByXpath("//button[@type='submit']");
		return this;
	}
		
	public DashboardPage clickNextBtn()
	{
		System.out.println("Click Next button");
		clickByXpath("//button/span[text()='Next']");
		return this;
	}	
	
	public DashboardPage select2FAType(String auth)
	{
		System.out.println("Select 2FA Type");
		clickByXpath("//div//span[contains(text(),'Select')]");
	    clickByXpath("//span[@class='mat-option-text'][contains(text(),'"+auth+"')]");
		return this;
	}
	
	public DashboardPage enterSMSOTP() throws InterruptedException
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

	public DashboardPage clickResendCodeLink()
	{
		System.out.println("Click Resend Code Link");
		clickByXpath("//span[contains(text(),'Resend code')]");
		return this;
	}
	
	public DashboardPage clickSubmitBtn2FAPage()
	{
		System.out.println("Click Submit button");
		clickByXpath("//button/span[contains(text(),'Submit')]");
		return this;
	}
	
	public DashboardPage verifyDashboardTitle() throws InterruptedException
	{
		System.out.println("Verify Dashboard title");
		Thread.sleep(4000);
		verifyElementisPresent("//span[contains(text(), 'Dashboard')]", "Dashboard");
		return this;
	}
	
	public DashboardPage clickConfirmButton()
	{
		System.out.println("Click Confirm Button");
		clickByXpath("//span[text()='Confirm']");
		return this;
	}
	
	public DashboardPage clickSearchIcon()
	{
		System.out.println("Click Search Icon");
		clickByXpath("(//div[starts-with(@class,'search-icon')])[2]");
		return this;
	}
	
	public DashboardPage enterDetails(String details)
	{
		System.out.println("Enter the Details");
//		clickByXpath("//div//span[text()='Select']");
		enterByXpath("//input[@formcontrolname='searchField']", details);
//		clickByXpath("//span[contains(text(),'"+details+"')]");
		// Click Close icon
		clickByXpath("//div[starts-with(@class,'mx-rb-closeIcon')]"); 
		return this;
	}
			
	
	// Dynamic widget
	public DashboardPage verifyDynamicWidgets()
	{
		System.out.println("Verify Dynamic Widget");
		verifyElementisPresent("//*[@imgname='banner_img_3']", "Widget1");
		verifyElementisPresent("//*[@imgname='widget_bg.svg']", "Widget2");
		return this;
	}
	
	// QUICK LINK
	public DashboardPage verifyQuickLinkWidget()
	{
		System.out.println("Verify Quick Link Widget");
		verifyElementisPresent("//div[@class='mxQuicklinkContainer']", "Quick Link Widget");
		return this;
	}
	
	public DashboardPage verifyCardWidget()
	{
		System.out.println("Verify Card Widget");
		verifyElementisPresent("//h4[contains(text(),'Cards')]/parent::div/parent::div", "Card Widget");
		return this;
	}
	
	
	public DashboardPage verifyAccountWidget()
	{
		System.out.println("Verify Account Widget");
		verifyElementisPresent("//h4[contains(text(),'Accounts')]/parent::div/parent::div", "Account Widget");
		return this;
	}
	
	public DashboardPage verifyScheduleWidget()
	{
		System.out.println("Verify Schedule Widget");
		verifyElementisPresent("//*[contains(text(),'Scheduled')]/parent::div/parent::div", "Schedule Widget");
		return this;
	}
	public DashboardPage verifySwipingCard()
	{
		System.out.println("Verify Swiping Card");
		verifyElementisPresent("//div[@class='mx-rb-swiper-card']", "Swiping Card");
		return this;
	}
	
	public DashboardPage verifyMonitor()
	{
		System.out.println("Verify Monitor in the Card Section");
		verifyElementisPresent("//*[@class='chartjs-render-monitor']", "Monitor");
		return this;
	}
	
	
	public DashboardPage verifyOneTimeTransferLabel()
	{
		System.out.println("Verify One Time Transfer Label");
		verifyElementisPresent("//*[contains(text(),'One Time Transfer')]", "One Time Transfer");
		return this;
	}
	
	
	public DashboardPage verifyPayBillsLabel()
	{
		System.out.println("Verify Pay Bills Label");
		verifyElementisPresent("//*[contains(text(),'Pay Bills')]", "Pay Bills");
		return this;
	}
	
	
	public DashboardPage verifyAddBillerLabel()
	{
		System.out.println("Verify Add Biller Label");
		verifyElementisPresent("//*[contains(text(),'Add Biller')]", "Add Biller");
		return this;
	}
	
	public DashboardPage verifyManageCardsLabel()
	{
		System.out.println("Verify Manage Cards Label");
		verifyElementisPresent("//*[contains(text(),'Manage Cards')]", "Manage Cards");
		return this;
	}
	
	public DashboardPage verifyCardsLabel()
	{
		System.out.println("Verify Cards Label");
		verifyElementisPresent("//h4[contains(text(),'Cards')]", "Cards");
		return this;
	}
	
	
	public DashboardPage verifyLoanLabel()
	{
		System.out.println("Verify Loan Label");
		verifyElementisPresent("//button/div[contains(text(),'Loans')]", "Loans");
		clickByXpath("//button/div[contains(text(),'Loans')]");
		return this;
	}
	
	public DashboardPage verifyDepositsLabel()
	{
		System.out.println("Verify Deposit Label");
		verifyElementisPresent("//button/div[contains(text(),'Deposits')]", "Deposits");
		clickByXpath("//button/div[contains(text(),'Deposits')]");
		return this;
	}
	
	public DashboardPage verifyOperativeLabel()
	{
		System.out.println("Verify Operative Label");
		verifyElementisPresent("//button/div[contains(text(),'Operative')]", "Operative");
		clickByXpath("//button/div[contains(text(),'Operative')]");
		return this;
	}
			
	public DashboardPage userLogOut() throws InterruptedException {
		System.out.println("Logout the User");
		Thread.sleep(2000);
		clickByXpath("(//span[contains(text(), 'Logout')])[2]");
		return this;
	}
}
