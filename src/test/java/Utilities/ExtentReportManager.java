package Utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener {
	 public ExtentSparkReporter sparkReporter; // UI of the report
	    public ExtentReports extent; // Populate common info on the report
	    public ExtentTest test; // Create test cases in the report and update status of test methods

	    // This method is called before any test starts
	    public void onStart(ITestContext context) {
	        // Specify the path of the report
	        String reportPath = "C:\\Users\\hp\\eclipse-workspace\\TestingProject\\report\\myReport.html";
	        sparkReporter = new ExtentSparkReporter(reportPath);

	        // Set configurations for the report
	        sparkReporter.config().setDocumentTitle("Automation Report");  // Set document title
	        sparkReporter.config().setReportName("Functional Testing");    // Set report name
	        sparkReporter.config().setTheme(Theme.DARK);                    // Set the theme to dark

	        // Initialize ExtentReports and attach the reporter
	        extent = new ExtentReports();
	        extent.attachReporter(sparkReporter);

	        // Set system information (optional)
	        extent.setSystemInfo("Computer Name", "localhost");
	        extent.setSystemInfo("Environment", "QA");
	        extent.setSystemInfo("Tester Name", "pavan");
	        extent.setSystemInfo("OS", "Windows");
	        extent.setSystemInfo("Browser Name", "Chrome");
	    }

	    // This method is called when a test method succeeds
	    public void onTestSuccess(ITestResult result) {
	        test = extent.createTest(result.getName()); // Create a new entry in the report
	        test.log(Status.PASS, "Test case PASSED: " + result.getName()); // Log success
	    }

	    // This method is called when a test method fails
	    public void onTestFailure(ITestResult result) {
	        test = extent.createTest(result.getName()); // Create a new entry in the report
	        test.log(Status.FAIL, "Test case FAILED: " + result.getName()); // Log failure
	        test.log(Status.FAIL, "Failure cause: " + result.getThrowable()); // Log the exception cause
	    }

	    // This method is called when a test method is skipped
	    public void onTestSkipped(ITestResult result) {
	        test = extent.createTest(result.getName()); // Create a new entry in the report
	        test.log(Status.SKIP, "Test case SKIPPED: " + result.getName()); // Log skipped test
	    }

	    // This method is called after all tests are finished
	    public void onFinish(ITestContext context) {
	        extent.flush();  // Write the report to the file
	    }

}
