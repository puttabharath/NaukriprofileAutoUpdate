package testData;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExtentReporterNG {
    public static ExtentReports getReportObject() {
        // Define report directory
        String reportDir = System.getProperty("user.dir") + "/reports/";
        File dir = new File(reportDir);
        if (!dir.exists()) dir.mkdirs();  // Ensure the directory exists

        // Generate timestamp for unique filename
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        String formattedDateTime = now.format(formatter);

        // Generate report filename
        String reportFile = "Naukri_Auto_Update_Profile_" + formattedDateTime + ".html";
        String reportPath = reportDir + reportFile;

        // Initialize Extent Report
        ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
        reporter.config().setReportName("Web Automation Results");
        reporter.config().setDocumentTitle("Naukri Test Results");
        reporter.config().setTheme(Theme.DARK);
        reporter.config().setEncoding("UTF-8");
        reporter.config().enableOfflineMode(true); // Ensures CSS & JS are included

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Bharath Kumar Putta");
        extent.setSystemInfo("Host Name", "Naukri App");
        extent.setSystemInfo("Environment", "Automation Script - QA");
        extent.setSystemInfo("User Name", "PBK");

        // Create a symlink to the latest report for Jenkins
        try {
            Path latestReportPath = Paths.get(reportDir + "latest.html");
            Files.deleteIfExists(latestReportPath); // Delete existing symlink
            Files.createSymbolicLink(latestReportPath, Paths.get(reportPath));
        } catch (IOException | UnsupportedOperationException e) {
            System.out.println("Could not create latest.html symlink: " + e.getMessage());
        }

        return extent;
    }
}
