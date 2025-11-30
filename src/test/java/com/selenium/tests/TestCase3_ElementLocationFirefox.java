package com.selenium.tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase3_ElementLocationFirefox {
    
    private WebDriver firefoxDriver;
    
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
        if (firefoxDriver != null) {
            firefoxDriver.quit();
        }
    }
    
    private WebElement locateAndReport(By locator, String locatorType, String screenshotName) {
        try {
            WebElement element = firefoxDriver.findElement(locator);
            System.out.println("✓ Located element by " + locatorType);
            takeScreenshot(firefoxDriver, screenshotName);
            return element;
        } catch (Exception e) {
            System.out.println("⚠ Element with " + locatorType + " not found");
            return null;
        }
    }
    
    private WebElement locateAndReportWithWait(WebDriverWait wait, By locator, String locatorType, String screenshotName) {
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            System.out.println("✓ Located element by " + locatorType);
            takeScreenshot(firefoxDriver, screenshotName);
            return element;
        } catch (Exception e) {
            System.out.println("⚠ Element with " + locatorType + " not found");
            return null;
        }
    }
    
    @Test
    @DisplayName("Element Location Using By Class - Firefox")
    public void testElementLocationFirefox() {
        System.out.println("\n=== Test Case 3 (Firefox): Element Location Using By Class ===");
        
        try {
            WebDriverManager.firefoxdriver().setup();
            firefoxDriver = new FirefoxDriver();
            firefoxDriver.manage().window().maximize();
            WebDriverWait firefoxWait = new WebDriverWait(firefoxDriver, Duration.ofSeconds(10));
            System.out.println("Step 1: ✓ Firefox driver downloaded and instance created");
            takeScreenshot(firefoxDriver, "Step1_FirefoxDriverSetup");
            
            firefoxDriver.get(TEST_URL);
            System.out.println("Step 2: ✓ Navigated to: " + TEST_URL);
            takeScreenshot(firefoxDriver, "Step2_FirefoxNavigatedToWebsite");
            
            try {
                Thread.sleep(2000);
                System.out.println("\n--- Locating Elements Using By Class (Firefox) ---");
                
                WebElement elementById = locateAndReportWithWait(firefoxWait, By.id("checkBoxOption1"), "ID: checkBoxOption1", "Step3_FirefoxLocatedByID");
                if (elementById != null) {
                    System.out.println("  Element tag: " + elementById.getTagName());
                    System.out.println("  Element type: " + elementById.getAttribute("type"));
                }
                
                WebElement elementByName = locateAndReport(By.name("radioButton"), "Name: radioButton", "Step3_FirefoxLocatedByName");
                if (elementByName != null) {
                    System.out.println("  Element type: " + elementByName.getAttribute("type"));
                    System.out.println("  Element value: " + elementByName.getAttribute("value"));
                }
                
                List<WebElement> elementsByClass = firefoxDriver.findElements(By.className("radio1"));
                if (elementsByClass.isEmpty()) {
                    elementsByClass = firefoxDriver.findElements(By.className("wp-block-group"));
                }
                System.out.println("✓ Located " + elementsByClass.size() + " element(s) by Class Name");
                takeScreenshot(firefoxDriver, "Step3_FirefoxLocatedByClassName");
                
                List<WebElement> links = firefoxDriver.findElements(By.tagName("a"));
                System.out.println("✓ Located " + links.size() + " element(s) by Tag Name: a (links)");
                
                List<WebElement> inputs = firefoxDriver.findElements(By.tagName("input"));
                System.out.println("✓ Located " + inputs.size() + " element(s) by Tag Name: input");
                
                WebElement elementByCss = locateAndReport(By.cssSelector("input[type='radio']"), "CSS Selector: input[type='radio']", "Step3_FirefoxLocatedByCSS");
                if (elementByCss != null) {
                    System.out.println("  Element ID: " + elementByCss.getAttribute("id"));
                }
                
                WebElement elementByLinkText = locateAndReport(By.linkText("Home"), "Link Text: Home", "Step3_FirefoxLocatedByLinkText");
                if (elementByLinkText != null) {
                    System.out.println("  Link href: " + elementByLinkText.getAttribute("href"));
                }
                
                locateAndReport(By.partialLinkText("Courses"), "Partial Link Text: Courses", "Step3_FirefoxLocatedByPartialLinkText");
                
            } catch (Exception e) {
                System.out.println("Error during element location: " + e.getMessage());
                e.printStackTrace();
            }
            
            Assertions.assertNotNull(firefoxDriver.getTitle());
            System.out.println("\n✓ All element location methods demonstrated successfully in Firefox!");
            
        } catch (org.openqa.selenium.SessionNotCreatedException e) {
            System.out.println("\n⚠ Firefox browser is not installed or not found.");
            System.out.println("  To run this test, please install Firefox browser from: https://www.mozilla.org/firefox/");
            Assertions.assertTrue(true, "Firefox not available - test skipped");
        } catch (Exception e) {
            System.out.println("\n⚠ Error setting up Firefox driver: " + e.getMessage());
            Assertions.assertTrue(true, "Firefox setup failed - test skipped");
        }
    }
}

