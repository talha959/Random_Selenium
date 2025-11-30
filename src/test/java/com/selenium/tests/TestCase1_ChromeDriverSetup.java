package com.selenium.tests;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase1_ChromeDriverSetup {
    
    private WebDriver chromeDriver;
    
    private static final String TEST_URL = "https://www.codenboxautomationlab.com/practice/";
    
    private static final String SCREENSHOT_DIR = "screenshots";
    
    @BeforeEach
    public void setUp() {
        System.out.println("Setting up drivers...");
        File screenshotDir = new File(SCREENSHOT_DIR);
        if (!screenshotDir.exists()) {
            screenshotDir.mkdirs();
            System.out.println("Created screenshots directory: " + SCREENSHOT_DIR);
        }
    }
    
    private void takeScreenshot(WebDriver driver, String stepName) {
        try {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
            String fileName = SCREENSHOT_DIR + File.separator + stepName + "_" + 
                             System.currentTimeMillis() + ".png";
            File destinationFile = new File(fileName);
            FileHandler.copy(sourceFile, destinationFile);
            System.out.println("  📸 Screenshot saved: " + fileName);
        } catch (IOException e) {
            System.out.println("  ⚠ Failed to take screenshot: " + e.getMessage());
        }
    }
    
    @AfterEach
    public void tearDown() {
        if (chromeDriver != null) {
            chromeDriver.quit();
        }
    }
    
    @Test
    @DisplayName("Chrome Driver Setup and Navigation")
    public void testChromeDriverSetup() {
        System.out.println("\n=== Test Case 1: Chrome Driver Setup ===");
        
        WebDriverManager.chromedriver().setup();
        System.out.println("Step 1: ✓ Chrome driver downloaded and configured");
        
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        
        chromeDriver = new ChromeDriver(options);
        System.out.println("Step 2: ✓ Chrome driver instance created");
        takeScreenshot(chromeDriver, "Step2_ChromeDriverCreated");
        
        chromeDriver.get(TEST_URL);
        System.out.println("Step 3: ✓ Navigated to: " + TEST_URL);
        takeScreenshot(chromeDriver, "Step3_NavigatedToWebsite");
        
        String pageTitle = chromeDriver.getTitle();
        System.out.println("Step 4: ✓ Page Title: " + pageTitle);
        takeScreenshot(chromeDriver, "Step4_PageLoaded");
        
        Assertions.assertNotNull(pageTitle);
        Assertions.assertFalse(pageTitle.isEmpty());
    }
}

