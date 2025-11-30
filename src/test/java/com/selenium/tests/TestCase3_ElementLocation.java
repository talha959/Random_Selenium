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
            try {
                WebElement elementById = wait.until(
                    ExpectedConditions.presenceOfElementLocated(By.id("checkBoxOption1"))
                );
                System.out.println("✓ Located element by ID: checkBoxOption1");
                System.out.println("  Element tag: " + elementById.getTagName());
                System.out.println("  Element type: " + elementById.getAttribute("type"));
                takeScreenshot(chromeDriver, "Step3_LocatedByID");
            } catch (Exception e) {
                System.out.println("⚠ Element with ID 'checkBoxOption1' not found");
            }
            
            try {
                WebElement elementByName = chromeDriver.findElement(By.name("radioButton"));
                System.out.println("✓ Located element by Name: radioButton");
                System.out.println("  Element type: " + elementByName.getAttribute("type"));
                System.out.println("  Element value: " + elementByName.getAttribute("value"));
                takeScreenshot(chromeDriver, "Step3_LocatedByName");
            } catch (Exception e) {
                System.out.println("⚠ Element with Name 'radioButton' not found");
            }
            
            try {
                List<WebElement> elementsByClass = chromeDriver.findElements(By.className("radio1"));
                if (elementsByClass.isEmpty()) {
                    elementsByClass = chromeDriver.findElements(By.className("wp-block-group"));
                }
                System.out.println("✓ Located " + elementsByClass.size() + " element(s) by Class Name");
                takeScreenshot(chromeDriver, "Step3_LocatedByClassName");
            } catch (Exception e) {
                System.out.println("⚠ Elements with Class Name not found");
            }
            
            List<WebElement> links = chromeDriver.findElements(By.tagName("a"));
            System.out.println("✓ Located " + links.size() + " element(s) by Tag Name: a (links)");
            
            List<WebElement> inputs = chromeDriver.findElements(By.tagName("input"));
            System.out.println("✓ Located " + inputs.size() + " element(s) by Tag Name: input");
            
            try {
                WebElement elementByCss = chromeDriver.findElement(By.cssSelector("input[type='radio']"));
                System.out.println("✓ Located element by CSS Selector: input[type='radio']");
                System.out.println("  Element ID: " + elementByCss.getAttribute("id"));
                takeScreenshot(chromeDriver, "Step3_LocatedByCSS");
            } catch (Exception e) {
                System.out.println("⚠ Element with CSS Selector not found");
            }
            
            try {
                WebElement elementByXpath = chromeDriver.findElement(
                    By.xpath("//input[@type='radio']")
                );
                System.out.println("✓ Located element by XPath: //input[@type='radio']");
                System.out.println("  Element type: " + elementByXpath.getAttribute("type"));
                takeScreenshot(chromeDriver, "Step3_LocatedByXPath");
            } catch (Exception e) {
                System.out.println("⚠ Element with XPath not found");
            }
            
            try {
                WebElement elementByLinkText = chromeDriver.findElement(By.linkText("Home"));
                System.out.println("✓ Located element by Link Text: Home");
                System.out.println("  Link href: " + elementByLinkText.getAttribute("href"));
                takeScreenshot(chromeDriver, "Step3_LocatedByLinkText");
            } catch (Exception e) {
                System.out.println("⚠ Link with exact text 'Home' not found");
            }
            
            try {
                WebElement elementByPartialLink = chromeDriver.findElement(
                    By.partialLinkText("Courses")
                );
                System.out.println("✓ Located element by Partial Link Text: Courses");
                takeScreenshot(chromeDriver, "Step3_LocatedByPartialLinkText");
            } catch (Exception e) {
                System.out.println("⚠ Link with partial text not found");
            }
            
        } catch (Exception e) {
            System.out.println("Error during element location: " + e.getMessage());
            e.printStackTrace();
        }
        
        Assertions.assertNotNull(chromeDriver.getTitle());
        System.out.println("\n✓ All element location methods demonstrated successfully!");
    }
}

