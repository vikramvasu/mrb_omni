package wrappers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;

import com.google.common.base.Function;
import com.relevantcodes.extentreports.ExtentTest;

import utils.Reporter;

public class GenericWrappers extends Reporter implements Wrappers {

	public GenericWrappers(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	public RemoteWebDriver driver;
	protected Properties prop;
	public String sUrl1, sUrl2, sUrl3, sUrl4, primaryWindowHandle, sHubUrl, sHubPort, headless;

	public GenericWrappers() throws IOException {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(new File("./src/main/resources/config.properties")));
			sHubUrl = prop.getProperty("HUB");
			sHubPort = prop.getProperty("PORT");
			sUrl1 = prop.getProperty("URL1");
			sUrl2 = prop.getProperty("URL2");
			sUrl3 = prop.getProperty("URL3");
			sUrl4 = prop.getProperty("URL4");
			headless = prop.getProperty("Headless");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void loadObjects() {
		prop = new Properties();
		try {
			prop.load(new FileInputStream(new File("./src/main/resources/object.properties")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void objprop(String reference_key, String reference_value) {
		Properties pro = new Properties();
		FileInputStream in;
		try {
			in = new FileInputStream("./src/main/resources/object.properties");
			try {
				pro.load(in);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FileOutputStream out;
		try {
			out = new FileOutputStream("./src/main/resources/object.properties");
			pro.getProperty(reference_key);
			pro.setProperty(reference_key, reference_value);
			try {
				pro.store(out, "");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getobjprop(String reference_key) {
		Properties pro = new Properties();
		try {
			pro.load(new FileInputStream(new File("./src/main/resources/object.properties")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// pro.getProperty(reference_key);

		return pro.getProperty(reference_key);
	}

	public void unloadObjects() {
		prop = null;
	}

	public void invokeApp(String browser) {
		invokeApp(browser, false);
	}

	public void invokeApp(String browser, boolean bRemote) {
		try {

			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setBrowserName(browser);
			dc.setPlatform(Platform.WINDOWS);

			// this is for grid run
			if (bRemote)
				driver = new RemoteWebDriver(new URL("http://" + sHubUrl + ":" + sHubPort + "/wd/hub"), dc);
			else { // this is for local run
				if (browser.equalsIgnoreCase("chrome")) {
					System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
					if (headless.equalsIgnoreCase("true")) {
						ChromeOptions options = new ChromeOptions();
						options.setHeadless(true);
						driver = new ChromeDriver(options);
						driver.manage().window().setSize(new Dimension(1366, 613));
					}
					if (headless.equalsIgnoreCase("false")) {

						driver = new ChromeDriver();
						driver.manage().window().maximize();
					}

				} else {
					System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
					driver = new FirefoxDriver();
				}
			}

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//	driver.get(sUrl1);

			primaryWindowHandle = driver.getWindowHandle();
			reportStep("The browser:" + browser + " launched successfully", "PASS");

		} catch (Exception e) {
			e.printStackTrace();
			reportStep("The browser:" + browser + " could not be launched", "FAIL");
		}
	}

	public void openDemoIBApplication() {
		try {
			driver.get(sUrl1);
			reportStep("The URL:" + sUrl1 + " opened successfully", "PASS");
		} catch (Exception e) {
			reportStep("The browser:" + sUrl1 + " could not be opened", "FAIL");
		}
	}
	
	public void openDemoAdminApplication() {
		try {
			driver.get(sUrl2);
			reportStep("The URL:" + sUrl2 + " opened successfully", "PASS");
		} catch (Exception e) {
			reportStep("The browser:" + sUrl2 + " could not be opened", "FAIL");
		}
	}
	
	public void openQAIBApplication() {
		try {
			driver.get(sUrl3);
			reportStep("The URL:" + sUrl3 + " opened successfully", "PASS");
		} catch (Exception e) {
			reportStep("The browser:" + sUrl3 + " could not be opened", "FAIL");
		}
	}
	
	public void openQAAdminApplication() {
		try {
			driver.get(sUrl4);
			reportStep("The URL:" + sUrl4 + " opened successfully", "PASS");
		} catch (Exception e) {
			reportStep("The browser:" + sUrl4 + " could not be opened", "FAIL");
		}
	}

	public boolean scrollsearchElement(String xpath, Long pausetime, String elementXpath) {
		waitForLoad();
		elementXpath = (elementXpath != null) ? elementXpath.replace("\"", "\'") : null;
		System.out.println("Search scroll starts");
		int maxScroll;
		boolean elementFound = false;
		if (pausetime == null) {
			pausetime = 250L;
		}
		driver.manage().timeouts().implicitlyWait(pausetime, TimeUnit.MILLISECONDS);
		if (elementXpath == null) {
			maxScroll = Integer.parseInt((((JavascriptExecutor) driver)
					.executeScript("return Math.max( document.body.scrollHeight, document.body.offsetHeight,"
							+ "document.documentElement.clientHeight, document.documentElement.scrollHeight, document.documentElement.offsetHeight )")
					.toString()));
		} else {
			String jsQuerry = "return document.evaluate(\"" + elementXpath
					+ "/div\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.offsetHeight";
			String jsOutput = (((JavascriptExecutor) driver).executeScript(jsQuerry)).toString();
			maxScroll = Integer.parseInt(jsOutput);
		}
		int times = 0;
		int scrollStep = 100;
		while ((times * scrollStep) < maxScroll) {
			waitForLoad();
			driver.manage().timeouts().implicitlyWait(pausetime, TimeUnit.MILLISECONDS);
			if (elementXpath == null) {
				((JavascriptExecutor) driver).executeScript("window.scrollBy(0," + scrollStep + ");");
			} else {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollTop+=" + scrollStep + ";",
						driver.findElement(By.xpath(elementXpath)));
			}
			if (elementXpath == null) {
				maxScroll = Integer.parseInt((((JavascriptExecutor) driver)
						.executeScript("return Math.max( document.body.scrollHeight, document.body.offsetHeight,"
								+ "document.documentElement.clientHeight, document.documentElement.scrollHeight, document.documentElement.offsetHeight)")
						.toString()));
			} else {
				String jsQuerry = "return document.evaluate(\"" + elementXpath
						+ "/div\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.offsetHeight;";
				String jsOutput = (((JavascriptExecutor) driver).executeScript(jsQuerry)).toString();
				maxScroll = Integer.parseInt(jsOutput);
			}
			try {
				elementFound = driver.findElement(By.xpath(xpath)).isDisplayed();
			} catch (Exception e) {
				elementFound = false;
			}
			if (elementFound) {
				System.out.println("Element " + xpath + " found, stoping search");
				break;
			}
			times++;
		}
		if (!elementFound) {
			System.out.println("Serch of element yield no result");
		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return elementFound;

	}

	// This method will launch the browser in grid node (if remote) and maximise the

	// what is this method:This method will check in Java script that the page is
	// fully load,asynchronous elements could be still loading and the page could
	// still be, considered as fully load

	@SuppressWarnings("deprecation")
	public void waitForLoad() {

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Function<WebDriver, ?> pageLoaded = wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState")
				.equals("complete");
		try {
			while (isAsyncLoading()) {
				System.out.println("Wating for load...");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
			new FluentWait<WebDriver>(driver).withTimeout(25, TimeUnit.SECONDS).until(pageLoaded);

		} catch (TimeoutException tex) {
			System.out.println("Time out reached!");
		} finally {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	// what is this method: Wrapper to do actions in different xpaths, receives a
	// functional interface

	public void clickWrapper(String xpathVal, click click, Boolean throwException) {
		int times = 0;
		waitForLoad();
		if (xpathVal.contains("Edit")) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
		while (true) {
			try {
				click.doClick();
				break;
			} catch (StaleElementReferenceException see) {
				System.out.print("StaleElementException ocurred when clicking, " + xpathVal + " will retry");
			} catch (NoSuchElementException Nseex) {
				System.out.print("NoSuchElementException ocurred when clicking, " + xpathVal + " will retry");
			} catch (WebDriverException wdex) {
				if (wdex.getMessage().matches("(?s).* Element .* is not clickable at point .*")
						|| wdex.getMessage().contains("Element is not clickable at point")) {
					System.out.println("Trying to find the element for the " + times + " time");
					if (times < 3) {
						this.scrollAxisYToElement(xpathVal);
					} else if (times >= 3 && times < 6) {
						this.scrollAxisYToElement(xpathVal, -100 * (times - 2));
					} else if (times >= 6 && times < 9) {
						this.scrollAxisYToElement(xpathVal, 100 * (times - 5));
					} else if (times > 9) {
						if (!throwException) {
							reportStep("The element with xpath: " + xpathVal + " could not be clicked.", "FAIL");
						} else {
							throw wdex;
						}
					}
					times++;
				} else {
					System.out.println(wdex.toString());
					if (!throwException) {
						reportStep("The element with xpath: " + xpathVal + " could not be clicked.", "FAIL");
					} else {
						throw wdex;
					}
				}
			} catch (Exception e) {
				System.out.println(e);
				if (!throwException) {
					reportStep("The element with xpath: " + xpathVal + " could not be clicked.", "FAIL");
				} else {
					throw e;
				}
			}
		}
	}
	// What is this method:This method will enter the value to the text field using
	// id attribute to

	public void enterById(String idValue, String data) {
		waitForLoad();
		try {
			driver.findElement(By.id(idValue)).clear();
			driver.findElement(By.id(idValue)).sendKeys(data);
			reportStep("The data: " + data + " entered successfully in field :" + idValue, "PASS");
		} catch (NoSuchElementException e) {
			reportStep("The data: " + data + " could not be entered in the field :" + idValue, "FAIL");
		} catch (Exception e) {
			reportStep("Unknown exception occured while entering " + data + " in the field :" + idValue, "FAIL");
		}
	}

	// What is this method:This method will enter the value to the text field using
	// name attribute to

	public void enterByName(String nameValue, String data) {
		waitForLoad();
		try {
			driver.findElement(By.name(nameValue)).clear();
			driver.findElement(By.name(nameValue)).sendKeys(data);
			reportStep("The data: " + data + " entered successfully in field :" + nameValue, "PASS");

		} catch (NoSuchElementException e) {
			reportStep("The data: " + data + " could not be entered in the field :" + nameValue, "FAIL");
		} catch (Exception e) {
			reportStep("Unknown exception occured while entering " + data + " in the field :" + nameValue, "FAIL");
		}

	}

	// What is this method: This method will enter the value to the text field using
	// name attribute to

	public void enterByXpath(String xpathValue, String data) {
		waitForLoad();
		try {
			driver.findElement(By.xpath(xpathValue)).clear();
			driver.findElement(By.xpath(xpathValue)).sendKeys(data);
			reportStep("The data: " + data + " entered successfully in field :" + xpathValue, "PASS");

		} catch (NoSuchElementException e) {
			reportStep("The data: " + data + " could not be entered in the field :" + xpathValue, "FAIL");
		} catch (Exception e) {
			reportStep(e.getLocalizedMessage() + ": " + data + " in the field :" + xpathValue, "FAIL");
		}

	}
	
	public void clearTextInputByXpath(String xpathValue) {
		waitForLoad();
		try {
			driver.findElement(By.xpath(xpathValue)).click();
			driver.findElement(By.xpath(xpathValue)).clear();
			reportStep("The field : " + xpathValue + " is cleared", "PASS");

		} catch (NoSuchElementException e) {
			reportStep("The field : " + xpathValue + " is not cleared", "FAIL");
		} catch (Exception e) {
			reportStep(e.getLocalizedMessage() + " the field :" + xpathValue, "FAIL");
		}

	}
	// what is this method:This method will verify the title of the browser

	public boolean verifyTitle(String title) {
		waitForLoad();
		boolean bReturn = false;
		try {
			if (driver.getTitle().equalsIgnoreCase(title)) {
				reportStep("The title of the page matches with the value :" + title, "PASS");
				bReturn = true;
			} else
				reportStep("The title of the page:" + driver.getTitle() + " did not match with the value :" + title,
						"SUCCESS");

		} catch (Exception e) {
			reportStep("Unknown exception occured while verifying the title", "FAIL");
		}
		return bReturn;
	}

	// what is this method:This method will verify the given text matches in the
	// element text

	public void verifyTextByXpath(String xpath, String text) {
		waitForLoad();
		try {
			String sText = driver.findElementByXPath(xpath).getText();
			if (sText.equalsIgnoreCase(text)) {
				reportStep("The text: " + sText + " matches with the value :" + text, "PASS");

			} else {
				reportStep("The text: " + sText + " did not match with the value :" + text, "FAIL");
			}
		} catch (Exception e) {
			reportStep(xpath + " not found", "FAIL");
		}
	}

	public void verifyTextByText(String textFromSource, String textFromDestnation) {
		waitForLoad();
		try {
			String sText = textFromSource;
			String text = textFromDestnation;
			if (sText.equalsIgnoreCase(text)) {
				reportStep("The text: " + sText + " matches with the value :" + text, "PASS");

			} else {
				reportStep("The text: " + sText + " did not match with the value :" + text, "FAIL");

			}
		} catch (Exception e) {
			reportStep("Unknown exception occured while verifying the text", "FAIL");
		}

	}

	public void verifyTextContainsByXpath(String xpath, String text) {
		waitForLoad();
		try {
			String sText = driver.findElementByXPath(xpath).getText();
			if (sText.contains(text)) {
				reportStep("The text: " + sText + " contains the value :" + text, "PASS");
			} else {
				reportStep("The text: " + sText + " did not contain the value :" + text, "FAIL");
			}
		} catch (Exception e) {
			reportStep("Unknown exception occured while verifying the title", "FAIL");
		}
	}

	// what is this method:This method will verify the given text is available in
	// the element text

	public void verifyTextById(String id, String text) {
		waitForLoad();
		try {
			String sText = driver.findElementById(id).getText();
			if (sText.equalsIgnoreCase(text)) {
				reportStep("The text: " + sText + " matches with the value :" + text, "PASS");
			} else {
				reportStep("The text: " + sText + " did not match with the value :" + text, "FAIL");
			}
		} catch (Exception e) {
			reportStep("Unknown exception occured while verifying the title", "FAIL");
		}
	}

	// what is this method: This method will verify the given text is available in
	// the element text

	public void verifyTextContainsById(String id, String text) {
		waitForLoad();
		try {
			String sText = driver.findElementById(id).getText();
			if (sText.contains(text)) {
				reportStep("The text: " + sText + " contains the value :" + text, "PASS");
			} else {
				reportStep("The text: " + sText + " did not contain the value :" + text, "FAIL");
			}
		} catch (Exception e) {
			reportStep("Unknown exception occured while verifying the title", "FAIL");
		}
	}

	// what is this method: This method will close all the browsers

	public void quitBrowser() {
		try {
			driver.quit();
		} catch (Exception e) {
			reportStep("The browser:" + driver.getCapabilities().getBrowserName() + " could not be closed.", "FAIL");
		}
	}

	public void closeBrowser() {
		try {
			driver.close();
			reportStep("The browser is closed", "PASS", false);
		} catch (Exception e) {
			reportStep("The browser could not be closed", "FAIL", false);
		}
	}

	private void reportStep(String string, String string2, boolean b) {
		// TODO Auto-generated method stub

	}

	public void closeAllBrowsers() {
		try {
			driver.quit();
			reportStep("The opened browsers are closed", "PASS", false);
		} catch (Exception e) {
			reportStep("Unexpected error occured in Browser", "FAIL", false);
		}
	}

	// what is this method: This method will click the element using id as locator

	public void clickById(String id) {

		try {
			driver.findElement(By.id(id)).click();
			reportStep("The element with id: " + id + " is clicked.", "PASS");

		} catch (Exception e) {
			reportStep("The element with id: " + id + " could not be clicked.", "FAIL");
		}
	}

	// what is this method:This method will click the element using id as locator

	public void clickByClassName(String classVal) {
		try {
			driver.findElement(By.className(classVal)).click();
			reportStep("The element with class Name: " + classVal + " is clicked.", "PASS");
		} catch (Exception e) {
			reportStep("The element with class Name: " + classVal + " could not be clicked.", "FAIL");
		}
	}

	// what is this method: This method will click the element using id as locator

	public void clickByClassNameNoSnap(String classVal) {
		try {
			driver.findElement(By.className(classVal)).click();
			// reportStep("The element with class Name: "+classVal+" is clicked.", "PASS");
		} catch (Exception e) {
			// reportStep("The element with class Name: "+classVal+" could not be clicked.",
			// "FAIL");
		}
	}

	public void clickByName(String name) {
		try {
			driver.findElement(By.name(name)).click();
			reportStep("The element with name: " + name + " is clicked.", "PASS");
		} catch (Exception e) {
			reportStep("The element with name: " + name + " could not be clicked.", "FAIL");
		}
	}

	public void clickByLink(String name) {
		try {
			driver.findElement(By.linkText(name)).click();
			reportStep("The element with link name: " + name + " is clicked.", "PASS");
		} catch (Exception e) {
			reportStep("The element with link name: " + name + " could not be clicked.", "FAIL");
		}
	}

	// what is this method: scrolls the window to the element described by the xpath
	// using java script

	public void scrollAxisYToElement(String xpath) {
		Point hoverItem = driver.findElement(By.xpath(xpath)).getLocation();
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0," + (hoverItem.getY()) + ");");
	}
	
	public void scrollHorizontal() {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(1000,0)", "");
	}
	
	public void scrollAxisYToElement(String xpath, int offset) {
		Point hoverItem = driver.findElement(By.xpath(xpath)).getLocation();
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0," + (hoverItem.getY() + offset) + ");");
	}

	public void scrollElement(String xpath, int scrollby) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollTop+=" + scrollby + ";",
				driver.findElement(By.xpath(xpath)));
	}

	public void clickByElement(WebElement element, String xpath) {
		click c = () -> {
			this.waitForLoad();
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(element)).click();
			reportStep("The element : " + element + " is clicked.", "PASS");
		};
		clickWrapper(xpath, c, false);
	}

	public String randomGenerator(String data) {
		@SuppressWarnings("unused")
		Random random = new Random();
		int randomNumber = (int) (Math.random() * 50000 + 1);
		String randomText = data + randomNumber;
		System.out.println("Random password generated is " + randomText);
		return randomText;
	}

	public void verifyValuesAreEqual(String s1, String s2) {
		try {
			if (s1.equalsIgnoreCase(s2)) {
				reportStep("The compared values " + s1 + " & " + s2 + " are equal", "PASS");
			} else {
				reportStep("The compared values " + s1 + " & " + s2 + " are not equal", "FAIL");
			}
		} catch (Exception e) {
			reportStep("The compared values " + s1 + " & " + s2 + " are not equal", "FAIL");
		}

	}

	public String getTempPassword(String s) {
		String result = null;
		try {
			String[] str = s.split("successfully.");
			String[] str1 = str[1].split("-");
			result = str1[0].trim();
			System.out.println(result);
			reportStep("The temporary password is fetched successfully and the password is: " + result, "PASS");
		} catch (Exception e) {
			System.out.println("error");
			reportStep("The temporary password is not fetched ", "FAIL");
		}
		return result;
	}

	public String getTempPassword1(String s) {
		String result = null;
		try {
			String[] str = s.split("reference.");
			String[] str1 = str[1].split("has");
			result = str1[0].trim();
			System.out.println(result);
			reportStep("The reference number is fetched successfully and the referencenumber is: " + result, "PASS");
		} catch (Exception e) {
			System.out.println("error");
			reportStep("The temporary password is not fetched ", "FAIL");
		}

		return result;

	}

	public String enterByXpathWithRandomNumber(String xpathValue, String data) {
		waitForLoad();
		int random = 0;
		try {
			random = (int) (Math.random() * 5000 + 1);
			System.out.println(data + random);
			driver.findElement(By.xpath(xpathValue)).clear();
			driver.findElement(By.xpath(xpathValue)).sendKeys(data + random);
			reportStep("The data: " + data + " entered successfully in field :" + xpathValue, "PASS");

		} catch (NoSuchElementException e) {
			reportStep("The data: " + data + " could not be entered in the field :" + xpathValue, "FAIL");
		} catch (Exception e) {
			reportStep(e.getLocalizedMessage() + ": " + data + " in the field :" + xpathValue, "FAIL");
		}
		return data + random;
	}
	
	public void clickByXpath(String xpathVal) {
		waitForLoad();
		click c = () -> {
			driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);				
			this.waitForLoad();
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathVal))).click();
			reportStep("The element : " + xpathVal + " is clicked.", "PASS");
		};
		clickWrapper(xpathVal, c, false);
	}

	public void clickByXpathThrowException(String xpathVal) {
		click c = () -> {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// this.waitForLoad();
			// WebDriverWait wait = new WebDriverWait(driver, 5);
			// wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathVal))).click();
			reportStep("The element : " + xpathVal + " is clicked.", "PASS");
		};
		clickWrapper(xpathVal, c, true);
	}

	public void doubleClickByXpath(String xpathVal) {
		click c = () -> {
			this.waitForLoad();
			this.scrollAxisYToElement(xpathVal);
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathVal)));
			Actions action = new Actions(driver);
			action.doubleClick(driver.findElement(By.xpath(xpathVal)));
			reportStep("The element : " + xpathVal + " is clicked.", "PASS");
		};
		clickWrapper(xpathVal, c, false);
	}

	@FunctionalInterface
	private interface click {
		void doClick();
	}

	public boolean isAsyncLoading() {
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.MILLISECONDS);
		int loadingElements = 0;
		loadingElements += driver
				.findElements(By.xpath("//div[@class='slds-spinner slds-spinner--small slds-spinner--brand']")).size();
		loadingElements += driver.findElements(By.xpath("//div[@class='slds-spinner_container slds-grid']")).size();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return (loadingElements == 0) ? false : true;
	}

	// what is this method:This method will click the element

	public void clickByElement(WebElement element) {
		try {
			element.click();
		} catch (Exception e) {
			throw e;
		}
	}

	// what is this method:This method will click the element and will take no
	// snapshots

	public void clickByElementNoSnap(WebElement element) {
		try {
			element.click();
		} catch (Exception e) {
		}
	}

	// what is this method:This method will wait for the element defined by an xpath
	// to be clickable for

	void waitclickable(String xpath) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
	}

	public void clickByXpathNoSnap(String xpathVal) {
		try {
			driver.findElement(By.xpath(xpathVal)).click();

		} catch (Exception e) {
			// reportStep("The element with xpath: "+xpathVal+" could not be clicked.",
			// "FAIL");
		}
	}

	// what is this method:This method will mouse over on the element using xpath as
	// locator

	public void mouseOverByXpath(String xpathVal) {
		try {
			new Actions(driver).moveToElement(driver.findElement(By.xpath(xpathVal))).build().perform();
			reportStep("The mouse over by xpath : " + xpathVal + " is performed.", "PASS");
		} catch (Exception e) {
			reportStep("The mouse over by xpath : " + xpathVal + " could not be performed.", "FAIL");
		}
	}
	
	public void mouseOverByLinkText(String linkName) {
		try {
			new Actions(driver).moveToElement(driver.findElement(By.linkText(linkName))).build().perform();
			reportStep("The mouse over by link : " + linkName + " is performed.", "PASS");
		} catch (Exception e) {
			reportStep("The mouse over by link : " + linkName + " could not be performed.", "FAIL");
		}
	}

	public String getTextByXpath(String xpathVal) {
		String bReturn = "";
		try {
			return driver.findElement(By.xpath(xpathVal)).getText();
		} catch (Exception e) {
			reportStep("The element with xpath: " + xpathVal + " could not be found.", "FAIL");
		}
		return bReturn;
	}

	public String getTextById(String idVal) {
		String bReturn = "";
		try {
			return driver.findElementById(idVal).getText();
		} catch (Exception e) {
			reportStep("The element with id: " + idVal + " could not be found.", "FAIL");
		}
		return bReturn;
	}

	// This method will select the drop down value using id as locator

	public void selectVisibileTextById(String id, String value) {
		try {
			new Select(driver.findElement(By.id(id))).selectByVisibleText(value);
			;
			reportStep("The element with id: " + id + " is selected with value :" + value, "PASS");
		} catch (Exception e) {
			reportStep("The value: " + value + " could not be selected.", "FAIL");
		}
	}

	public void selectVisibileTextByXPath(String xpath, String value) {
		try {
			new Select(driver.findElement(By.xpath(xpath))).selectByVisibleText(value);
			;
			reportStep("The element with xpath: " + xpath + " is selected with value :" + value, "PASS");
		} catch (Exception e) {
			reportStep("The value: " + value + " could not be selected.", "FAIL");
		}
	}

	public void selectIndexById(String id, String value) {
		try {
			new Select(driver.findElement(By.id(id))).selectByIndex(Integer.parseInt(value));
			reportStep("The element with id: " + id + " is selected with index :" + value, "PASS");
		} catch (Exception e) {
			reportStep("The index: " + value + " could not be selected.", "FAIL");
		}
	}

	public void switchToParentWindow() {
		try {
			Set<String> winHandles = driver.getWindowHandles();
			for (String wHandle : winHandles) {
				driver.switchTo().window(wHandle);
				break;
			}
		} catch (Exception e) {
			reportStep("The window could not be switched to the first window.", "FAIL");
		}
	}

	public void switchToLastWindow() {
		try {
			Set<String> winHandles = driver.getWindowHandles();
			for (String wHandle : winHandles) {
				driver.switchTo().window(wHandle);
			}
		} catch (Exception e) {
			reportStep("The window could not be switched to the last window.", "FAIL");
		}
	}

	public void acceptAlert() {
		try {
			driver.switchTo().alert().accept();
		} catch (NoAlertPresentException e) {
			reportStep("The alert could not be found.", "FAIL");
		} catch (Exception e) {
			reportStep("The alert could not be accepted.", "FAIL");
		}

	}

	// accept the alert and no snapshot is taken
	public void acceptAlertNoSnap() {
		try {
			driver.switchTo().alert().accept();
		} catch (NoAlertPresentException e) {
			// reportStep("The alert could not be found.", "FAIL");
		} catch (Exception e) {
			// reportStep("The alert could not be accepted.", "FAIL");
		}

	}

	public String getAlertText() {
		String text = null;
		try {
			driver.switchTo().alert().dismiss();
		} catch (NoAlertPresentException e) {
			reportStep("The alert could not be found and not visible in related section.", "FAIL");
		} catch (Exception e) {
			reportStep("The alert could not be accepted and not visible in related section.", "FAIL");
		}
		return text;
	}

	public void dismissAlert() {
		try {
			driver.switchTo().alert().dismiss();
		} catch (NoAlertPresentException e) {
			reportStep("The alert could not be found.", "FAIL");
		} catch (Exception e) {
			reportStep("The alert could not be accepted.", "FAIL");
		}
	}

	public long takeSnap() {
		long number = (long) Math.floor(Math.random() * 9000000000L) + 900000000L;
		try {
			FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE),
					new File("./reports/images/" + number + ".jpg"));
		} catch (WebDriverException e) {
		} catch (IOException e) {
			reportStep("The snapshot could not be taken", "WARN");
		}
		return number;
	}

	public void selectValueById(String id, String value) {
		try {
			new Select(driver.findElement(By.id(id))).selectByValue(value);
			// driver.findElement(By.id(id)).sendKeys(Keys.TAB);
			reportStep("The element with id: " + id + " is selected with value :" + value, "PASS");

		} catch (Exception e) {
			reportStep("The value: " + value + " could not be selected.", "FAIL");

		}

	}

	public WebElement findElementByXpath(String xpath, int timeout, WebElement iframe) {
		waitForLoad();
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
		List<WebElement> frames = null;
		if (iframe == null) {
			frames = driver.findElements(By.xpath("//iframe"));
		} else {
			try {
				driver.switchTo().frame(iframe);
			} catch (Exception ex) {
				return null;
			}
		}
		for (int i = 0; i < timeout * 2; i++) {
			try {
				WebElement element = driver.findElement(By.xpath(xpath));
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				driver.switchTo().defaultContent();
				return element;
			} catch (NoSuchElementException enfe) {

			}
		}
		if (frames == null) {
			System.out.println("Element " + xpath + " not found");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.switchTo().defaultContent();
			return null;
		} else if (frames.size() > 0) {
			for (WebElement webElement : frames) {
				WebElement ret = findElementByXpath(xpath, timeout, webElement);
				if (ret != null) {
					driver.switchTo().defaultContent();
					return ret;
				}
			}
		}
		return null;
	}

	public void scrollDown(String xpath) {
		WebElement Element=driver.findElement(By.xpath(xpath));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", Element);
		
	}
	
	public void scrollDownTillPageEnd() {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public void scrollUp() {
	//	((JavascriptExecutor)driver).executeScript("window.scrollTo(0,document.body.scrollTop)");
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0, -document.body.scrollHeight);");
	}
	
	@Override
	public boolean ScrollUp() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrollDownInBrowser(int val) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void verifyTextByAccessebilityID() {
		// TODO Auto-generated method stub

	}

	@Override
	public void clickByAccessebilityID() {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterByAccessebilityID() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean zoomInApp() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean closeApp() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean screenOrientation() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hideKeyBoard() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getNetworkConnection() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrollsearchElement() {
		// TODO Auto-generated method stub
		return false;
	}

	public void verifyElementReadOnly(String xpath, String ElementName) {
		waitForLoad();

		try {
			String sText = driver.findElementByXPath(xpath).getAttribute("readonly");
			if (sText.equalsIgnoreCase("true")) {
				reportStep("The " + ElementName + " is Read Only", "PASS");

			} else {
				reportStep("The " + ElementName + " is Editable", "FAIL");
			}
		} catch (Exception e) {
			reportStep(xpath +" of "+ ElementName +" not found", "FAIL");
		}
	}
	
	public void verifyElementisPresent(String xpath, String ElementName) {
		waitForLoad();
		try {
			if (driver.findElements(By.xpath(xpath)).size() != 0) {
				System.out.println(ElementName + " is Present");
				reportStep("The " + ElementName + " is Present", "PASS");
			} else {
				System.out.println(ElementName + " is Absent");
				reportStep("The " + ElementName + " is Absent", "FAIL");
			}
		} catch (Exception e) {
			reportStep(xpath + " not found", "FAIL");
		}
	}

	public void verifyElementisPresentById(String id, String ElementName) {
		waitForLoad();
		try {
			if (driver.findElements(By.id(id)).size() != 0) {
				System.out.println(ElementName + " is Present");
				reportStep("The " + ElementName + " is Present", "PASS");
			} else {
				System.out.println(ElementName + " is Absent");
				reportStep("The " + ElementName + " is Absent", "FAIL");
			}
		} catch (Exception e) {
			reportStep(id + " not found", "FAIL");
		}
	}
	
	public String enterByXpathWithRandomNumbers(String xpath, String prefix, String suffix) {
		waitForLoad();
		Random rand = new Random();
		long random = 0;
		try {
			random = (long)(rand.nextDouble()*1000000000000L);
			System.out.println(prefix + random + suffix);
			driver.findElement(By.xpath(xpath)).clear();
			driver.findElement(By.xpath(xpath)).sendKeys(prefix + random + suffix);
			reportStep("The data: " + prefix + random + suffix + " entered successfully in field :" + xpath, "PASS");

		} catch (NoSuchElementException e) {
			reportStep("The data: " + prefix + random + suffix + " could not be entered in the field :" + xpath, "FAIL");
		} catch (Exception e) {
			reportStep(e.getLocalizedMessage() + ": " + prefix + random + suffix + " in the field :" + xpath, "FAIL");
		}
		return prefix + random + suffix;
	}
	
	public void mouseOverById(String id) {
		try {
			new Actions(driver).moveToElement(driver.findElement(By.id(id))).build().perform();
			reportStep("The mouse over by xpath : " + id + " is performed.", "PASS");
		} catch (Exception e) {
			reportStep("The mouse over by xpath : " + id + " could not be performed.", "FAIL");
		}
	}
	
	@Override
	public boolean Scrolldown() {
		// TODO Auto-generated method stub
		return false;
	}

}
