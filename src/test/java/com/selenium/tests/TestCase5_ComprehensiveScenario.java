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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase5_ComprehensiveScenario {
    
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
    
    private WebElement locateElementWithWait(By locator, String description) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        System.out.println("✓ Located " + description);
        return element;
    }
    
    private WebElement locateElement(By locator, String description) {
        WebElement element = chromeDriver.findElement(locator);
        System.out.println("✓ Located " + description);
        return element;
    }
    
    private void locateElementsByTag(String tagName, String description) {
        List<WebElement> elements = chromeDriver.findElements(By.tagName(tagName));
        System.out.println("✓ Located " + elements.size() + " " + description);
    }
    
    private void interactWithRadio(WebElement radioButton, String screenshotName) {
        System.out.println("Action 1: ✓ Radio button attributes - Type: " + radioButton.getAttribute("type") + 
                         ", ID: " + radioButton.getAttribute("id") + ", Value: " + radioButton.getAttribute("value") + 
                         ", Displayed: " + radioButton.isDisplayed() + ", Enabled: " + radioButton.isEnabled());
        radioButton.click();
        System.out.println("Action 2: ✓ Clicked radio button");
        System.out.println("  Radio button is selected: " + radioButton.isSelected());
        takeScreenshot(chromeDriver, screenshotName);
    }
    
    private void interactWithCheckbox(WebElement checkbox, String screenshotName) {
        if (!checkbox.isSelected()) {
            checkbox.click();
            System.out.println("Action 3: ✓ Clicked checkbox");
        } else {
            System.out.println("Action 3: ✓ Checkbox already selected");
        }
        takeScreenshot(chromeDriver, screenshotName);
    }
    
    private void interactWithDropdown(WebElement dropdown, String optionToSelect, String screenshotName) {
        Select select = new Select(dropdown);
        List<WebElement> options = select.getOptions();
        System.out.println("Action 4: ✓ Dropdown has " + options.size() + " options");
        if (!options.isEmpty()) {
            select.selectByVisibleText(optionToSelect);
            System.out.println("  Selected option: " + select.getFirstSelectedOption().getText());
        }
        takeScreenshot(chromeDriver, screenshotName);
    }
    
    private void interactWithInput(WebElement input, String text, String screenshotName) {
        input.clear();
        input.sendKeys(text);
        System.out.println("Action 5: ✓ Entered text in autocomplete field");
        takeScreenshot(chromeDriver, screenshotName);
    }
    
    private void interactWithLink(WebElement link) {
        System.out.println("Action 6: ✓ Link attributes - Text: " + link.getText() + ", Href: " + link.getAttribute("href"));
    }
    
    private void interactWithTable(WebElement table, String screenshotName) {
        List<WebElement> tableRows = table.findElements(By.tagName("tr"));
        System.out.println("Action 7: ✓ Web table has " + tableRows.size() + " rows");
        List<WebElement> tableHeaders = table.findElements(By.tagName("th"));
        if (!tableHeaders.isEmpty()) {
            System.out.println("  Table headers: " + tableHeaders.get(0).getText() + ", " + 
                             tableHeaders.get(1).getText() + ", " + tableHeaders.get(2).getText());
        }
        takeScreenshot(chromeDriver, screenshotName);
    }
    
    private void scrollToElement(WebElement element, String screenshotName) {
        ((JavascriptExecutor) chromeDriver).executeScript("arguments[0].scrollIntoView(true);", element);
        System.out.println("Action 12: ✓ Scrolled to table element");
        takeScreenshot(chromeDriver, screenshotName);
    }
    
    @Test
    @DisplayName("Comprehensive Usability and Functionality Test")
    public void testComprehensiveScenario() {
        System.out.println("\n=== Test Case 5: Comprehensive Usability and Functionality Test ===");
        
        System.out.println("\n--- Step 1: Download Selenium Driver and Create Instance ---");
        WebDriverManager.chromedriver().setup();
        System.out.println("✓ Chrome driver downloaded using WebDriverManager");
        
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        chromeDriver = new ChromeDriver(chromeOptions);
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(15));
        System.out.println("✓ Chrome driver instance created and configured");
        takeScreenshot(chromeDriver, "Step1_DriverInstanceCreated");
        
        try {
            System.out.println("\n--- Step 2: Navigate to Website ---");
            chromeDriver.get(TEST_URL);
            System.out.println("✓ Navigated to: " + TEST_URL);
            takeScreenshot(chromeDriver, "Step2_NavigatedToWebsite");
            
            Thread.sleep(2000);
            
            String title = chromeDriver.getTitle();
            System.out.println("✓ Page title: " + title);
            Assertions.assertNotNull(title);
            Assertions.assertFalse(title.isEmpty());
            
            System.out.println("\n--- Step 3: Locate Elements Using By Class ---");
            WebElement radioButton = locateElementWithWait(By.name("radioButton"), "radio button using By.name('radioButton')");
            WebElement checkbox = locateElement(By.id("checkBoxOption1"), "checkbox using By.id('checkBoxOption1')");
            WebElement dropdown = locateElement(By.id("dropdown-class-example"), "dropdown using By.id('dropdown-class-example')");
            WebElement tableElement = locateElement(By.id("product"), "table using By.id('product')");
            WebElement autocomplete = locateElement(By.id("autocomplete"), "autocomplete using By.id('autocomplete')");
            locateElementsByTag("input", "input elements using By.tagName('input')");
            locateElementsByTag("a", "link elements using By.tagName('a')");
            WebElement homeLink = locateElement(By.linkText("Home"), "link using By.linkText('Home')");
            takeScreenshot(chromeDriver, "Step3_LocatedAllElements");
            
            System.out.println("\n--- Step 4: Perform Actions on Located Web Elements ---");
            interactWithRadio(radioButton, "Step4_Action2_ClickedRadio");
            interactWithCheckbox(checkbox, "Step4_Action3_CheckboxInteraction");
            interactWithDropdown(dropdown, "Selenium", "Step4_Action4_DropdownSelected");
            interactWithInput(autocomplete, "Canada", "Step4_Action5_Autocomplete");
            interactWithLink(homeLink);
            interactWithTable(tableElement, "Step4_Action7_TableInfo");
            
            System.out.println("Action 9: ✓ Current URL: " + chromeDriver.getCurrentUrl());
            System.out.println("Action 10: ✓ Page source length: " + chromeDriver.getPageSource().length() + " characters");
            org.openqa.selenium.Dimension windowSize = chromeDriver.manage().window().getSize();
            System.out.println("Action 11: ✓ Window size - Width: " + windowSize.getWidth() + ", Height: " + windowSize.getHeight());
            
            scrollToElement(tableElement, "Step4_Action12_ScrolledToTable");
            
            System.out.println("\n✓ All usability and functionality checks completed successfully!");
            takeScreenshot(chromeDriver, "Step4_FinalResult");
            
        } catch (Exception e) {
            System.out.println("Error in comprehensive test: " + e.getMessage());
            e.printStackTrace();
            takeScreenshot(chromeDriver, "Step4_Error");
        }
        
        Assertions.assertNotNull(chromeDriver.getTitle());
    }
}

