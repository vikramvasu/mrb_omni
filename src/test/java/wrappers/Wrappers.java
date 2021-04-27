package wrappers;


public interface Wrappers {


	//This method will launch the given browser and maximize the browser and set the

	public void invokeApp(String browser);


	//This method will enter the value to the text field using id attribute to locate



	// This method will enter the value to the text field using name attribute to locate


	public void enterByName(String nameValue, String data);		

	//This method will enter the value to the text field using xpath attribute to locate

	public void enterByXpath(String xpathValue, String data);

// this method will Scrolldown the screen
	boolean Scrolldown();
	// this method will Scrollup the screen
	boolean ScrollUp();
	boolean scrollDownInBrowser(int val);

	// this method will use for wait the loading 
	public void waitForLoad();
	// this method will verify the AccessebilityID
	public void verifyTextByAccessebilityID();
	//// this method will click the AccessebilityID
	public void clickByAccessebilityID();
	// this method will be use for enter the accessibility id
	public void enterByAccessebilityID();
	//This method will verify the title of the browser 

	public boolean verifyTitle(String title);

	//This method will verify the given text-The locator of the object in id

	public void verifyTextById(String id, String text);

	//This method will verify the given text-The locator of the object in xpath


	public void verifyTextByXpath(String xpath, String text);

	//This method will verify the given text-The text to be verified

	public void verifyTextContainsByXpath(String xpath, String text);
	//This method will verify the given text-The text to be verified

	public void verifyTextContainsById(String id, String text);

	//This method will click the element using id as locator

	public void clickById(String id);

	//This method will click the element using id as locator

	public void clickByClassName(String classVal);

	//This method will click the element using name as locator

	public void clickByName(String name);

	//This method will click the element using link name as locator

	public void clickByLink(String name);

	//This method will click the element using xpath as locator

	public void clickByXpath(String xpathVal);

	// This method will get the text of the element using id as locator- The id (locator) of the element 
	public String getTextById(String idVal);

	//This method will get the text of the element using xpath as locator

	public String getTextByXpath(String xpathVal);

	//This method will select the drop down visible text using id as locator-The value to be selected (visibletext) from the dropdown 

	public void selectVisibileTextById(String id, String value);
//This method will zoomin the app
	boolean zoomInApp();

	public void selectIndexById(String id, String value);
	//This method will close the app
	boolean closeApp();
	
//This method will rotate the screen
	boolean screenOrientation();
	//This method will hide the keyboard
	boolean hideKeyBoard();

	boolean getNetworkConnection();
	//This method will scroll the search element
	boolean scrollsearchElement();

	//This method will switch to the parent Window

	public void switchToParentWindow();

	// This method will move the control to the last window
	public void switchToLastWindow();

	//This method will accept the alert opened

	public void acceptAlert();

	//This method will close all the browsers
	public void quitBrowser();

	public void selectValueById(String id, String value);

}
