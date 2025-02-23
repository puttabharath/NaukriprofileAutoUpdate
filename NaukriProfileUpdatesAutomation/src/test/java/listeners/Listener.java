package listeners;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pages.BaseClass;
import testData.ExtentReporterNG;

public class Listener extends BaseClass implements ITestListener {
    private ExtentTest test;
    private final ExtentReports extent = ExtentReporterNG.getReportObject();
    private final ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.get().log(Status.PASS, "✅ Test Passed");

        WebDriver driver = getDriverInstance(result);
        if (driver != null) {
            try {
                String filePath = getScreenshot(result.getMethod().getMethodName(), driver);
                extentTest.get().addScreenCaptureFromPath(filePath, "Pass Screenshot");
            } catch (IOException e) {
                extentTest.get().log(Status.WARNING, "⚠️ Failed to capture pass screenshot: " + e.getMessage());
            }
        } else {
            extentTest.get().log(Status.WARNING, "⚠️ Driver instance is null, pass screenshot not captured.");
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        extentTest.get().fail(result.getThrowable());

        WebDriver driver = getDriverInstance(result);
        if (driver != null) {
            try {
                String filePath = getScreenshot(result.getMethod().getMethodName(), driver);
                extentTest.get().addScreenCaptureFromPath(filePath, "Fail Screenshot");
            } catch (IOException e) {
                extentTest.get().log(Status.FAIL, "⚠️ Failed to capture fail screenshot: " + e.getMessage());
            }
        } else {
            extentTest.get().log(Status.FAIL, "⚠️ Driver instance is null, fail screenshot not captured.");
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }

    // Helper method to get WebDriver instance from test class
    private WebDriver getDriverInstance(ITestResult result) {
        try {
            return (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
        } catch (Exception e) {
            extentTest.get().log(Status.WARNING, "⚠️ Failed to fetch WebDriver instance: " + e.getMessage());
            return null;
        }
    }
}
