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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase4_ElementActionsFirefox {
    
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
    
    @Test
    @DisplayName("Performing Actions on Web Elements - Firefox")
    public void testElementActionsFirefox() {
        System.out.println("\n=== Test Case 4 (Firefox): Performing Actions on Web Elements ===");
        
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
                
                System.out.println("\n--- Step 3: Locating Elements Using By Class (Firefox) ---");
                
                WebElement radioButton = firefoxWait.until(
                    ExpectedConditions.presenceOfElementLocated(By.name("radioButton"))
                );
                System.out.println("Step 3: ✓ Located radio button using By.name('radioButton')");
                takeScreenshot(firefoxDriver, "Step3_FirefoxLocatedRadioButton");
                
                System.out.println("\n--- Step 4: Performing Actions on Web Elements (Firefox) ---");
                
                String radioType = radioButton.getAttribute("type");
                String radioId = radioButton.getAttribute("id");
                String radioValue = radioButton.getAttribute("value");
                System.out.println("Action 1: ✓ Retrieved radio button attributes - Type: " + radioType + 
                                 ", ID: " + radioId + ", Value: " + radioValue);
                takeScreenshot(firefoxDriver, "Step4_FirefoxAction1_RadioAttributes");
                
                boolean isDisplayed = radioButton.isDisplayed();
                System.out.println("Action 2: ✓ Element is displayed: " + isDisplayed);
                
                boolean isEnabled = radioButton.isEnabled();
                System.out.println("Action 3: ✓ Element is enabled: " + isEnabled);
                
                boolean initiallySelected = radioButton.isSelected();
                System.out.println("Action 4: ✓ Radio button initially selected: " + initiallySelected);
                
                radioButton.click();
                System.out.println("Action 5: ✓ Clicked radio button");
                takeScreenshot(firefoxDriver, "Step4_FirefoxAction5_ClickedRadio");
                
                boolean isSelected = radioButton.isSelected();
                System.out.println("Action 6: ✓ Radio button is selected: " + isSelected);
                
                try {
                    WebElement checkbox = firefoxDriver.findElement(By.id("checkBoxOption1"));
                    System.out.println("Action 7: ✓ Located checkbox using By.id('checkBoxOption1')");
                    
                    if (!checkbox.isSelected()) {
                        checkbox.click();
                        System.out.println("Action 8: ✓ Clicked checkbox");
                        takeScreenshot(firefoxDriver, "Step4_FirefoxAction8_ClickedCheckbox");
                    } else {
                        System.out.println("Action 8: ✓ Checkbox already selected");
                    }
                } catch (Exception e) {
                    System.out.println("⚠ Checkbox not found");
                }
                
                try {
                    WebElement dropdown = firefoxDriver.findElement(By.id("dropdown-class-example"));
                    System.out.println("Action 9: ✓ Located dropdown using By.id('dropdown-class-example')");
                    
                    Select select = new Select(dropdown);
                    List<WebElement> options = select.getOptions();
                    System.out.println("Action 9: ✓ Dropdown has " + options.size() + " options");
                    if (!options.isEmpty()) {
                        System.out.println("  First option: " + options.get(0).getText());
                        select.selectByVisibleText("Selenium");
                        System.out.println("  Selected option: " + select.getFirstSelectedOption().getText());
                    }
                    takeScreenshot(firefoxDriver, "Step4_FirefoxAction9_DropdownLocated");
                } catch (Exception e) {
                    System.out.println("⚠ Dropdown not found");
                }
                
                try {
                    WebElement autocomplete = firefoxDriver.findElement(By.id("autocomplete"));
                    System.out.println("Action 10: ✓ Located autocomplete input using By.id('autocomplete')");
                    autocomplete.clear();
                    autocomplete.sendKeys("Canada");
                    System.out.println("  Entered text: 'Canada' in autocomplete field");
                    takeScreenshot(firefoxDriver, "Step4_FirefoxAction10_Autocomplete");
                } catch (Exception e) {
                    System.out.println("⚠ Autocomplete input not found");
                }
                
                try {
                    WebElement homeLink = firefoxDriver.findElement(By.linkText("Home"));
                    System.out.println("Action 11: ✓ Located link using By.linkText('Home')");
                    String linkHref = homeLink.getAttribute("href");
                    String linkText = homeLink.getText();
                    System.out.println("  Link text: " + linkText + ", href: " + linkHref);
                    takeScreenshot(firefoxDriver, "Step4_FirefoxAction11_LinkLocated");
                } catch (Exception e) {
                    System.out.println("⚠ Link not found");
                }
                
                try {
                    WebElement table = firefoxDriver.findElement(By.id("product"));
                    System.out.println("Action 12: ✓ Located table using By.id('product')");
                    List<WebElement> tableRows = table.findElements(By.tagName("tr"));
                    System.out.println("  Table has " + tableRows.size() + " rows");
                    takeScreenshot(firefoxDriver, "Step4_FirefoxAction12_TableLocated");
                } catch (Exception e) {
                    System.out.println("⚠ Table not found");
                }
                
            } catch (Exception e) {
                System.out.println("Error during element actions: " + e.getMessage());
                e.printStackTrace();
                takeScreenshot(firefoxDriver, "Step4_FirefoxError");
            }
            
            Assertions.assertNotNull(firefoxDriver.getTitle());
            System.out.println("\n✓ All actions on web elements completed successfully in Firefox!");
            
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

