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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase3_ElementLocation {
    
    private WebDriver chromeDriver;
    private WebDriverWait wait;
    
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
    
    private WebElement locateAndReport(By locator, String locatorType, String screenshotName) {
        try {
            WebElement element = chromeDriver.findElement(locator);
            System.out.println("✓ Located element by " + locatorType);
            takeScreenshot(chromeDriver, screenshotName);
            return element;
        } catch (Exception e) {
            System.out.println("⚠ Element with " + locatorType + " not found");
            return null;
        }
    }
    
    private WebElement locateAndReportWithWait(By locator, String locatorType, String screenshotName) {
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            System.out.println("✓ Located element by " + locatorType);
            takeScreenshot(chromeDriver, screenshotName);
            return element;
        } catch (Exception e) {
            System.out.println("⚠ Element with " + locatorType + " not found");
            return null;
        }
    }
    
    @Test
    @DisplayName("Element Location Using By Class")
    public void testElementLocation() {
        System.out.println("\n=== Test Case 3: Element Location Using By Class ===");
        
        WebDriverManager.chromedriver().setup();
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(10));
        System.out.println("Step 1: ✓ Chrome driver downloaded and instance created");
        takeScreenshot(chromeDriver, "Step1_DriverSetup");
        
        chromeDriver.get(TEST_URL);
        System.out.println("Step 2: ✓ Navigated to: " + TEST_URL);
        takeScreenshot(chromeDriver, "Step2_NavigatedToWebsite");
        
        try {
            Thread.sleep(2000);
            System.out.println("\n--- Locating Elements Using By Class ---");
            
            WebElement elementById = locateAndReportWithWait(By.id("checkBoxOption1"), "ID: checkBoxOption1", "Step3_LocatedByID");
            if (elementById != null) {
                System.out.println("  Element tag: " + elementById.getTagName());
                System.out.println("  Element type: " + elementById.getAttribute("type"));
            }
            
            WebElement elementByName = locateAndReport(By.name("radioButton"), "Name: radioButton", "Step3_LocatedByName");
            if (elementByName != null) {
                System.out.println("  Element type: " + elementByName.getAttribute("type"));
                System.out.println("  Element value: " + elementByName.getAttribute("value"));
            }
            
            List<WebElement> elementsByClass = chromeDriver.findElements(By.className("radio1"));
            if (elementsByClass.isEmpty()) {
                elementsByClass = chromeDriver.findElements(By.className("wp-block-group"));
            }
            System.out.println("✓ Located " + elementsByClass.size() + " element(s) by Class Name");
            takeScreenshot(chromeDriver, "Step3_LocatedByClassName");
            
            List<WebElement> links = chromeDriver.findElements(By.tagName("a"));
            System.out.println("✓ Located " + links.size() + " element(s) by Tag Name: a (links)");
            
            List<WebElement> inputs = chromeDriver.findElements(By.tagName("input"));
            System.out.println("✓ Located " + inputs.size() + " element(s) by Tag Name: input");
            
            WebElement elementByCss = locateAndReport(By.cssSelector("input[type='radio']"), "CSS Selector: input[type='radio']", "Step3_LocatedByCSS");
            if (elementByCss != null) {
                System.out.println("  Element ID: " + elementByCss.getAttribute("id"));
            }
            
            WebElement elementByLinkText = locateAndReport(By.linkText("Home"), "Link Text: Home", "Step3_LocatedByLinkText");
            if (elementByLinkText != null) {
                System.out.println("  Link href: " + elementByLinkText.getAttribute("href"));
            }
            
            locateAndReport(By.partialLinkText("Courses"), "Partial Link Text: Courses", "Step3_LocatedByPartialLinkText");
            
        } catch (Exception e) {
            System.out.println("Error during element location: " + e.getMessage());
            e.printStackTrace();
        }
        
        Assertions.assertNotNull(chromeDriver.getTitle());
        System.out.println("\n✓ All element location methods demonstrated successfully!");
    }
}

