package utils;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public abstract class Reporter {
	public ExtentTest test;
	public static ExtentReports extent;
	public String TestCaseName, TestDescription, Application, Authors;


	public void reportStep(String desc, String status) {

		long snapNumber =90000000l;

		try {
			snapNumber= takeSnap();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Write if it is successful or failure or information
		if(status.toUpperCase().equals("PASS")){
			test.log(LogStatus.PASS, desc+test.
					addScreenCapture("./../reports/images/"+snapNumber+".jpg"));
		}else if(status.toUpperCase().equals("FAIL")){
			test.log(LogStatus.FAIL, desc+test.addScreenCapture("./../reports/images/"+snapNumber+".jpg"));
			throw new RuntimeException("FAILED");
		}else if(status.toUpperCase().equals("INFO")){
			test.log(LogStatus.INFO, desc);
		}
	}

	public abstract long takeSnap();


	public ExtentReports startResult(){
		try {
			extent = new ExtentReports("./reports/result.html", true);
			//extent = new ExtentReports("./reports/result.html", false);
			//extent.loadConfig(new File("./extent-config.xml"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return extent;
	}

	public ExtentTest startTestCase(String TestCaseName, String TestDescription){
		test = extent.startTest(TestCaseName, TestDescription);
		return test;
	}

	public void endResult(){		
		extent.flush();
	}

	public void endTestcase(){
		extent.endTest(test);
	}

}
