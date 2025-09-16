package TestUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReportCCPOC {

static ExtentReports extent;
	
	public static ExtentReports getReportObject() {
	
	String path = System.getProperty("user.dir")+"//reports//index.html";
	ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	reporter.config().setReportName("career Bridge");
	reporter.config().setDocumentTitle("Results");
	
	extent =new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("Tester", "Annu");
	return extent;
	}
	
	
}
