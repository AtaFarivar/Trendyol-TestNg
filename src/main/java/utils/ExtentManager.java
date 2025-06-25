package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentManager {
    private static ExtentReports extent;
    private static final ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    public static ExtentReports getInstance() {
        if (extent == null) {
            // Report folder
            String reportDir = "test-Report";
            File folder = new File(reportDir);
            if (!folder.exists()) folder.mkdir();

            // Unique filename
            String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
            String reportPath = reportDir + "/Trendyol_Report_" + timestamp + ".html";

            // Spark Reporter
            ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
            spark.config().setTheme(Theme.STANDARD);
            spark.config().setDocumentTitle("Automation Test Report");

            extent = new ExtentReports();
            extent.attachReporter(spark);

            // System Info
            extent.setSystemInfo("OS", System.getProperty("os.name"));
            extent.setSystemInfo("Java Version", System.getProperty("java.version"));
            extent.setSystemInfo("Tester", System.getProperty("user.name"));
            extent.setSystemInfo("Browser", "Chrome");
        }
        return extent;
    }

    public static ThreadLocal<ExtentTest> getExtentTest() {
        return extentTest;
    }

    public static void setExtentTest(ExtentTest test) {
        extentTest.set(test);
    }

    public static void flushReport() {
        if (extent != null) {
            extent.flush();
        }
    }
}
