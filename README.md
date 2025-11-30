# Selenium Testing Project - Usability and Functionality Testing

This project demonstrates Selenium WebDriver test cases for usability and functionality testing using Apache NetBeans IDE. The project implements all requirements for Q3 assignment with comprehensive test coverage for both Chrome and Firefox browsers.

## 📋 Project Overview

This project includes:
- ✅ Chrome and Firefox driver setup and navigation
- ✅ Element location using all 8 By locator strategies
- ✅ Performing actions on web elements
- ✅ Comprehensive test cases for usability and functionality testing
- ✅ Step-by-step screenshots for all procedures
- ✅ Single entry point (TestSuite) to run all tests

## 🎯 Assignment Requirements (Q3)

This project fulfills all requirements:

1. ✅ **Download selenium driver** for Chrome or Firefox (using WebDriverManager)
2. ✅ **Create instance** for Chrome/Firefox driver
3. ✅ **Select a random website** and navigate to it (`https://www.codenboxautomationlab.com/practice/`)
4. ✅ **Locate elements** on web using By class (8 different strategies)
5. ✅ **Perform actions** on located web elements
6. ✅ **Usability testing** - Element visibility, enabled state, window management
7. ✅ **Functionality testing** - Form interactions, navigation, data extraction
8. ✅ **Screenshots** of all procedure steps saved automatically

## 📁 Project Structure

```
Random_Selenium/
├── pom.xml                                    # Maven configuration
├── README.md                                  # This file
├── screenshots/                               # Auto-generated test screenshots
│   └── [64+ screenshot files]
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── selenium/
│   │               └── tests/
│   └── test/
│       └── java/
│           └── com/
│               └── selenium/
│                   └── tests/
│                       ├── TestCase1_ChromeDriverSetup.java
│                       ├── TestCase2_FirefoxDriverSetup.java
│                       ├── TestCase3_ElementLocation.java
│                       ├── TestCase3_ElementLocationFirefox.java
│                       ├── TestCase4_ElementActions.java
│                       ├── TestCase4_ElementActionsFirefox.java
│                       ├── TestCase5_ComprehensiveScenario.java
│                       ├── TestCase5_ComprehensiveScenarioFirefox.java
│                       └── TestSuite.java                    # Single entry point
└── target/                                    # Compiled classes
```

## 🔧 Prerequisites

1. **Java Development Kit (JDK) 11 or higher**
   - Download from: https://www.oracle.com/java/technologies/downloads/
   - Verify installation: `java -version`

2. **Apache NetBeans IDE**
   - Download from: https://netbeans.apache.org/
   - Version 12.0 or higher recommended

3. **Maven** (usually bundled with NetBeans)
   - Verify: `mvn -version`

4. **Chrome Browser** or **Firefox Browser**
   - Chrome: https://www.google.com/chrome/
   - Firefox: https://www.mozilla.org/firefox/

## 🚀 Quick Start Guide

### Step 1: Open Project in NetBeans

1. **Open NetBeans IDE**

2. **Import Existing Project:**
   - File → Open Project
   - Navigate to this project folder (`Random_Selenium`)
   - Select the project and click **Open Project**

### Step 2: Download Maven Dependencies

1. **Right-click on project** → **Reload Project**
   - OR
2. **Right-click on project** → **Build** (or press F11)
   - NetBeans will automatically download all dependencies
   - Wait for "BUILD SUCCESS" message

**Dependencies included:**
- Selenium Java (4.15.0)
- WebDriverManager (5.6.2)
- JUnit 5 (5.10.0)
- JUnit Platform Suite (1.10.0)

### Step 3: Run All Tests (Single Entry Point)

**Recommended Method - Run All Tests at Once:**

1. **Open `TestSuite.java`** in NetBeans
2. **Right-click on `TestSuite.java`**
3. **Select "Run File"** (or press Shift+F6)
4. All 8 test cases will execute sequentially
5. Watch the browser open and execute tests
6. Check the `screenshots/` folder for all captured screenshots

**Alternative - Run Individual Test:**

1. Open any test file (e.g., `TestCase1_ChromeDriverSetup.java`)
2. Right-click on the test method
3. Select **Run File** (or press Shift+F6)

## 📝 Test Cases Description

### Test Case 1: Chrome Driver Setup and Navigation
- **File:** `TestCase1_ChromeDriverSetup.java`
- **Purpose:** Verify Chrome driver setup and basic navigation
- **Steps:**
  1. Downloads Chrome driver automatically using WebDriverManager
  2. Creates Chrome driver instance
  3. Navigates to test website: `https://www.codenboxautomationlab.com/practice/`
  4. Verifies page title
  5. Captures screenshots at each step

### Test Case 2: Firefox Driver Setup and Navigation
- **File:** `TestCase2_FirefoxDriverSetup.java`
- **Purpose:** Verify Firefox driver setup and basic navigation
- **Steps:**
  1. Downloads Firefox driver automatically using WebDriverManager
  2. Creates Firefox driver instance
  3. Navigates to test website
  4. Verifies page title
  5. Handles Firefox not installed gracefully
- **Note:** Test will be skipped if Firefox is not installed

### Test Case 3: Element Location Using By Class
- **File:** `TestCase3_ElementLocation.java` (Chrome)
- **File:** `TestCase3_ElementLocationFirefox.java` (Firefox)
- **Purpose:** Demonstrate all 8 element location strategies
- **Locators Demonstrated:**
  - `By.id()` - Locate by element ID
  - `By.name()` - Locate by name attribute
  - `By.className()` - Locate by CSS class
  - `By.tagName()` - Locate by HTML tag
  - `By.cssSelector()` - Locate by CSS selector
  - `By.xpath()` - Locate by XPath expression
  - `By.linkText()` - Locate link by exact text
  - `By.partialLinkText()` - Locate link by partial text
- **Screenshots:** Captured for each locator type

### Test Case 4: Performing Actions on Web Elements
- **File:** `TestCase4_ElementActions.java` (Chrome)
- **File:** `TestCase4_ElementActionsFirefox.java` (Firefox)
- **Purpose:** Demonstrate actions on located elements
- **Actions Demonstrated:**
  - `click()` - Click radio buttons, checkboxes
  - `sendKeys()` - Enter text in input fields
  - `clear()` - Clear input fields
  - `getAttribute()` - Get element attributes
  - `isDisplayed()` - Check element visibility
  - `isEnabled()` - Check if element is enabled
  - `isSelected()` - Check selection state
  - `getText()` - Get element text
  - Dropdown selection using `Select` class
  - Table interaction

### Test Case 5: Comprehensive Usability and Functionality Test
- **File:** `TestCase5_ComprehensiveScenario.java` (Chrome)
- **File:** `TestCase5_ComprehensiveScenarioFirefox.java` (Firefox)
- **Purpose:** Complete end-to-end test scenario combining all concepts
- **Includes:**
  - All 4 required steps in one test
  - Usability testing (visibility, enabled state, window management)
  - Functionality testing (form interactions, navigation, data extraction)
  - Multiple element interactions
  - JavaScript execution (scrolling)
  - Comprehensive screenshots

## 🖼️ Screenshots

### Automatic Screenshot Capture

All test cases automatically capture screenshots at each step:
- Screenshots are saved in the `screenshots/` directory
- Each screenshot has a unique timestamp
- Screenshot naming format: `StepName_timestamp.png`

### Screenshot Locations

Screenshots are captured for:
- ✅ Driver setup and initialization
- ✅ Website navigation
- ✅ Element location (each locator type)
- ✅ Element actions (each action performed)
- ✅ Final results
- ✅ Error states (if any)

### Viewing Screenshots

1. Navigate to the `screenshots/` folder in your project
2. Screenshots are organized by test case and step
3. Open any `.png` file to view the captured screen

## 🎮 Running Tests

### Method 1: Run All Tests (Recommended)

**Using TestSuite (Single Entry Point):**

1. Open `src/test/java/com/selenium/tests/TestSuite.java`
2. Right-click on `TestSuite.java`
3. Select **Run File** (or press Shift+F6)
4. All 8 test cases execute in sequence

**Using Maven Command:**
```bash
mvn test -Dtest=TestSuite
```

### Method 2: Run Individual Test File

1. Open any test file (e.g., `TestCase1_ChromeDriverSetup.java`)
2. Right-click on the file
3. Select **Run File** (or press Shift+F6)

### Method 3: Run Individual Test Method

1. Open any test file
2. Right-click on a specific test method (e.g., `testChromeDriverSetup()`)
3. Select **Run File** (or press Shift+F6)

### Method 4: Run from Test Navigator

1. Open **Window** → **Navigator** (or press Ctrl+7)
2. Navigate to **Test Files** tab
3. Expand test classes
4. Right-click on test method → **Run**

## 📊 Test Execution Output

When you run tests, you'll see:

1. **Console Output:**
   - Step-by-step progress messages
   - Screenshot save confirmations
   - Test results and assertions

2. **Browser Windows:**
   - Chrome/Firefox will open automatically
   - Tests will interact with the website
   - Browser closes after test completion

3. **Screenshots:**
   - All screenshots saved in `screenshots/` folder
   - Each screenshot shows the state at that step

## 🔍 Code Examples

### Step 1: Download Selenium Driver and Create Instance

```java
// Chrome Driver
WebDriverManager.chromedriver().setup();
ChromeOptions options = new ChromeOptions();
options.addArguments("--start-maximized");
ChromeDriver driver = new ChromeDriver(options);

// Firefox Driver
WebDriverManager.firefoxdriver().setup();
FirefoxOptions options = new FirefoxOptions();
FirefoxDriver driver = new FirefoxDriver(options);
```

### Step 2: Navigate to Website

```java
private static final String TEST_URL = "https://www.codenboxautomationlab.com/practice/";
driver.get(TEST_URL);
```

### Step 3: Locate Elements Using By Class

```java
// By ID
WebElement element = driver.findElement(By.id("checkBoxOption1"));

// By Name
WebElement element = driver.findElement(By.name("radioButton"));

// By Class Name
List<WebElement> elements = driver.findElements(By.className("radio1"));

// By Tag Name
List<WebElement> links = driver.findElements(By.tagName("a"));

// By CSS Selector
WebElement element = driver.findElement(By.cssSelector("input[type='radio']"));

// By XPath
WebElement element = driver.findElement(By.xpath("//input[@type='radio']"));

// By Link Text
WebElement link = driver.findElement(By.linkText("Home"));

// By Partial Link Text
WebElement link = driver.findElement(By.partialLinkText("Courses"));
```

### Step 4: Perform Actions on Located Web Elements

```java
// Click element
element.click();

// Enter text
element.sendKeys("Canada");

// Clear field
element.clear();

// Get attribute
String value = element.getAttribute("type");

// Check states
boolean isDisplayed = element.isDisplayed();
boolean isEnabled = element.isEnabled();
boolean isSelected = element.isSelected();

// Dropdown selection
Select select = new Select(dropdown);
select.selectByVisibleText("Selenium");

// Get text
String text = element.getText();
```

## 🐛 Troubleshooting

### Issue: Driver not found
**Solution:**
- Ensure WebDriverManager dependency is in `pom.xml`
- Check internet connection (WebDriverManager downloads drivers automatically)
- Try: Right-click project → Clean and Build
- Verify browser is installed

### Issue: Browser doesn't open
**Solution:**
- Verify browser is installed (Chrome or Firefox)
- Check browser version compatibility
- Try updating WebDriverManager version in `pom.xml`
- Check if browser executable is in PATH

### Issue: Tests fail with timeout
**Solution:**
- Increase wait time in test code (currently 10-15 seconds)
- Check internet connection
- Verify test website is accessible: `https://www.codenboxautomationlab.com/practice/`
- Try running test again

### Issue: Maven dependencies not downloading
**Solution:**
- Right-click project → **Reload Project**
- Tools → Options → Java → Maven → Check Maven settings
- Try: Right-click project → **Build with Dependencies**
- Check internet connection
- Verify Maven is properly configured in NetBeans

### Issue: Firefox tests skipped
**Solution:**
- Firefox tests will be skipped if Firefox browser is not installed
- This is expected behavior - install Firefox to run Firefox tests
- Chrome tests will still run successfully

### Issue: Screenshots not saving
**Solution:**
- Check if `screenshots/` directory exists (created automatically)
- Verify write permissions in project directory
- Check console output for screenshot save confirmations

## 📚 Additional Resources

- **Selenium Documentation:** https://www.selenium.dev/documentation/
- **WebDriverManager:** https://github.com/bonigarcia/webdrivermanager
- **JUnit 5 Documentation:** https://junit.org/junit5/docs/current/user-guide/
- **Test Website:** https://www.codenboxautomationlab.com/practice/

## 📋 Test Files Summary

| Test File | Browser | Description |
|-----------|---------|-------------|
| `TestCase1_ChromeDriverSetup.java` | Chrome | Driver setup and navigation |
| `TestCase2_FirefoxDriverSetup.java` | Firefox | Driver setup and navigation |
| `TestCase3_ElementLocation.java` | Chrome | Element location using By class |
| `TestCase3_ElementLocationFirefox.java` | Firefox | Element location using By class |
| `TestCase4_ElementActions.java` | Chrome | Actions on web elements |
| `TestCase4_ElementActionsFirefox.java` | Firefox | Actions on web elements |
| `TestCase5_ComprehensiveScenario.java` | Chrome | Comprehensive test |
| `TestCase5_ComprehensiveScenarioFirefox.java` | Firefox | Comprehensive test |
| `TestSuite.java` | Both | **Single entry point to run all tests** |

## ✨ Features

- ✅ **Automatic Driver Management** - WebDriverManager handles driver downloads
- ✅ **Cross-Browser Testing** - Tests for both Chrome and Firefox
- ✅ **Comprehensive Coverage** - All 8 By locator strategies demonstrated
- ✅ **Automatic Screenshots** - Every step captured automatically
- ✅ **Error Handling** - Graceful handling of missing browsers
- ✅ **Detailed Logging** - Step-by-step console output
- ✅ **Single Entry Point** - TestSuite runs all tests at once
- ✅ **Modular Design** - Each test case in separate file

## 📝 Notes

- The project uses **WebDriverManager** for automatic driver management (no manual download needed)
- Tests use **JUnit 5** for test framework
- All tests include detailed console output for debugging
- Browser windows will open during test execution (not headless by default)
- Screenshots are automatically saved in the `screenshots/` directory
- Test website: `https://www.codenboxautomationlab.com/practice/`
- Firefox tests will be skipped if Firefox is not installed (Chrome tests will still run)

## 👨‍💻 Usage in Apache NetBeans

1. **Open Project:** File → Open Project → Select `Random_Selenium`
2. **Build Project:** Right-click project → Build (F11)
3. **Run All Tests:** Open `TestSuite.java` → Right-click → Run File (Shift+F6)
4. **View Results:** Check Output window and `screenshots/` folder

## 📄 License

This project is for educational purposes only.

---

**Created for Q3 Assignment - Selenium Testing with Apache NetBeans**
