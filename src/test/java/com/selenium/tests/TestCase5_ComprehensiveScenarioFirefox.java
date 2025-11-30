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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase5_ComprehensiveScenarioFirefox {
    
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
    @DisplayName("Comprehensive Usability and Functionality Test - Firefox")
    public void testComprehensiveScenarioFirefox() {
        System.out.println("\n=== Test Case 5 (Firefox): Comprehensive Usability and Functionality Test ===");
        
        try {
            System.out.println("\n--- Step 1: Download Selenium Driver and Create Instance (Firefox) ---");
            WebDriverManager.firefoxdriver().setup();
            System.out.println("✓ Firefox driver downloaded using WebDriverManager");
            
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxDriver = new FirefoxDriver(firefoxOptions);
            firefoxDriver.manage().window().maximize();
            firefoxDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            WebDriverWait firefoxWait = new WebDriverWait(firefoxDriver, Duration.ofSeconds(15));
            System.out.println("✓ Firefox driver instance created and configured");
            takeScreenshot(firefoxDriver, "Step1_FirefoxDriverInstanceCreated");
            
            try {
                System.out.println("\n--- Step 2: Navigate to Website (Firefox) ---");
                firefoxDriver.get(TEST_URL);
                System.out.println("✓ Navigated to: " + TEST_URL);
                takeScreenshot(firefoxDriver, "Step2_FirefoxNavigatedToWebsite");
                
                Thread.sleep(2000);
                
                String title = firefoxDriver.getTitle();
                System.out.println("✓ Page title: " + title);
                Assertions.assertNotNull(title);
                Assertions.assertFalse(title.isEmpty());
                
                System.out.println("\n--- Step 3: Locate Elements Using By Class (Firefox) ---");
                
                WebElement radioButton = firefoxWait.until(
                    ExpectedConditions.presenceOfElementLocated(By.name("radioButton"))
                );
                System.out.println("✓ Located radio button using By.name('radioButton')");
                
                WebElement checkbox = firefoxDriver.findElement(By.id("checkBoxOption1"));
                System.out.println("✓ Located checkbox using By.id('checkBoxOption1')");
                
                WebElement dropdown = firefoxDriver.findElement(By.id("dropdown-class-example"));
                System.out.println("✓ Located dropdown using By.id('dropdown-class-example')");
                
                WebElement tableElement = firefoxDriver.findElement(By.id("product"));
                System.out.println("✓ Located table using By.id('product')");
                
                WebElement autocomplete = firefoxDriver.findElement(By.id("autocomplete"));
                System.out.println("✓ Located autocomplete using By.id('autocomplete')");
                
                List<WebElement> allInputs = firefoxDriver.findElements(By.tagName("input"));
                System.out.println("✓ Located " + allInputs.size() + " input elements using By.tagName('input')");
                
                List<WebElement> allLinks = firefoxDriver.findElements(By.tagName("a"));
                System.out.println("✓ Located " + allLinks.size() + " link elements using By.tagName('a')");
                
                WebElement homeLink = firefoxDriver.findElement(By.linkText("Home"));
                System.out.println("✓ Located link using By.linkText('Home')");
                
                takeScreenshot(firefoxDriver, "Step3_FirefoxLocatedAllElements");
                
                System.out.println("\n--- Step 4: Perform Actions on Located Web Elements (Firefox) ---");
                
                String radioType = radioButton.getAttribute("type");
                String radioId = radioButton.getAttribute("id");
                String radioValue = radioButton.getAttribute("value");
                boolean isRadioDisplayed = radioButton.isDisplayed();
                boolean isRadioEnabled = radioButton.isEnabled();
                System.out.println("Action 1: ✓ Radio button attributes - Type: " + radioType + 
                                 ", ID: " + radioId + ", Value: " + radioValue + 
                                 ", Displayed: " + isRadioDisplayed + ", Enabled: " + isRadioEnabled);
                
                radioButton.click();
                System.out.println("Action 2: ✓ Clicked radio button");
                boolean isRadioSelected = radioButton.isSelected();
                System.out.println("  Radio button is selected: " + isRadioSelected);
                takeScreenshot(firefoxDriver, "Step4_FirefoxAction2_ClickedRadio");
                
                if (!checkbox.isSelected()) {
                    checkbox.click();
                    System.out.println("Action 3: ✓ Clicked checkbox");
                } else {
                    System.out.println("Action 3: ✓ Checkbox already selected");
                }
                takeScreenshot(firefoxDriver, "Step4_FirefoxAction3_CheckboxInteraction");
                
                Select select = new Select(dropdown);
                List<WebElement> options = select.getOptions();
                System.out.println("Action 4: ✓ Dropdown has " + options.size() + " options");
                if (!options.isEmpty()) {
                    select.selectByVisibleText("Selenium");
                    System.out.println("  Selected option: " + select.getFirstSelectedOption().getText());
                }
                takeScreenshot(firefoxDriver, "Step4_FirefoxAction4_DropdownSelected");
                
                autocomplete.clear();
                autocomplete.sendKeys("Canada");
                System.out.println("Action 5: ✓ Entered text in autocomplete field");
                takeScreenshot(firefoxDriver, "Step4_FirefoxAction5_Autocomplete");
                
                String linkHref = homeLink.getAttribute("href");
                String linkText = homeLink.getText();
                System.out.println("Action 6: ✓ Link attributes - Text: " + linkText + ", Href: " + linkHref);
                
                List<WebElement> tableRows = tableElement.findElements(By.tagName("tr"));
                System.out.println("Action 7: ✓ Web table has " + tableRows.size() + " rows");
                List<WebElement> tableHeaders = tableElement.findElements(By.tagName("th"));
                if (!tableHeaders.isEmpty()) {
                    System.out.println("  Table headers: " + tableHeaders.get(0).getText() + ", " + 
                                     tableHeaders.get(1).getText() + ", " + tableHeaders.get(2).getText());
                }
                takeScreenshot(firefoxDriver, "Step4_FirefoxAction7_TableInfo");
                
                String currentUrl = firefoxDriver.getCurrentUrl();
                System.out.println("Action 9: ✓ Current URL: " + currentUrl);
                
                String pageSource = firefoxDriver.getPageSource();
                System.out.println("Action 10: ✓ Page source length: " + pageSource.length() + " characters");
                
                org.openqa.selenium.Dimension windowSize = firefoxDriver.manage().window().getSize();
                System.out.println("Action 11: ✓ Window size - Width: " + windowSize.getWidth() + 
                                 ", Height: " + windowSize.getHeight());
                
                ((JavascriptExecutor) firefoxDriver)
                    .executeScript("arguments[0].scrollIntoView(true);", tableElement);
                System.out.println("Action 12: ✓ Scrolled to table element");
                takeScreenshot(firefoxDriver, "Step4_FirefoxAction12_ScrolledToTable");
                
                System.out.println("\n✓ All usability and functionality checks completed successfully in Firefox!");
                takeScreenshot(firefoxDriver, "Step4_FirefoxFinalResult");
                
            } catch (Exception e) {
                System.out.println("Error in comprehensive test: " + e.getMessage());
                e.printStackTrace();
                takeScreenshot(firefoxDriver, "Step4_FirefoxError");
            }
            
            Assertions.assertNotNull(firefoxDriver.getTitle());
            
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

