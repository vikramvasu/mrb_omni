package wrappers;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import utils.DataInputProvider;

public class ProjectWrappers extends GenericWrappers {
	
	public ProjectWrappers() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public String browserName;
	public String dataSheetName;
		

	@BeforeSuite(alwaysRun=true)
	public void beforeSuite(){
		startResult();
	}

	@BeforeTest(alwaysRun=true)
	public void beforeTest(){
		loadObjects();
	}
	
	@BeforeMethod(alwaysRun=true)
	public void beforeMethod(){
		test = startTestCase(TestCaseName, TestDescription);
		test.assignCategory(Application);
		test.assignAuthor(Authors);
		invokeApp(browserName);
		/*CreateCycle cc = new CreateCycle();
		cc.CreateCycle();*/
	}
		
	@AfterSuite(alwaysRun=true)
	public void afterSuite() throws IOException{
		//endResult();
		//JiraApiRequests.updateJiraStatus("DBP","Unscheduled","Regression test suite ","result");
	}

	@AfterTest(alwaysRun=true)
	public void afterTest(){
		unloadObjects();
		
	}
	
	@AfterMethod(alwaysRun=true)
	public void afterMethod() throws IOException{
		endTestcase();
		quitBrowser();
		endResult();
	//	JiraApiRequests.updateJiraStatus("DBP","Unscheduled",CreateCycle.CycleName+" ","result");
		 		
	}
	
	@DataProvider(name="fetchData")
	public Object[][] getData1(){
		return DataInputProvider.getSheet0(dataSheetName);		
	}	
	
	@DataProvider(name="fetchData1")
	public Object[][] getData2(){
		return DataInputProvider.getSheet1(dataSheetName);		
	}
	@DataProvider(name="fetchData2")
	public Object[][] getData3(){
		return DataInputProvider.getSheet2(dataSheetName);	
}
	@DataProvider(name="fetchData3")
	public Object[][] getData4(){
		return DataInputProvider.getSheet3(dataSheetName);
}
	@DataProvider(name="fetchData4")
	public Object[][] getData5(){
		return DataInputProvider.getSheet4(dataSheetName);
}
	@DataProvider(name="fetchData5")
	public Object[][] getData6(){
		return DataInputProvider.getSheet5(dataSheetName);
}
	@DataProvider(name="fetchData6")
	public Object[][] getData7(){
		return DataInputProvider.getSheet6(dataSheetName);
}
	@DataProvider(name="fetchData7")
	public Object[][] getData8(){
		return DataInputProvider.getSheet7(dataSheetName);
}
	@DataProvider(name="fetchData8")
	public Object[][] getData9(){
		return DataInputProvider.getSheet8(dataSheetName);
}
	@DataProvider(name="fetchData9")
	public Object[][] getData10(){
		return DataInputProvider.getSheet9(dataSheetName);
}

}