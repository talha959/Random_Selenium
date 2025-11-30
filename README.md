# Selenium Testing Project - Usability and Functionality Testing

This project demonstrates Selenium WebDriver test cases for usability and functionality testing using Apache NetBeans IDE.

## Project Overview

This project includes:
- ✅ Chrome and Firefox driver setup
- ✅ Element location using various By strategies
- ✅ Performing actions on web elements
- ✅ Comprehensive test cases for usability and functionality testing

## Prerequisites

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

## Step-by-Step Setup Instructions

### Step 1: Download Selenium Driver

The project uses **WebDriverManager** which automatically downloads the appropriate driver version for your browser. No manual download is required!

However, if you want to manually download drivers:

#### For Chrome:
1. Check your Chrome version: Chrome Menu → Help → About Google Chrome
2. Download ChromeDriver from: https://chromedriver.chromium.org/downloads
3. Extract and note the location

#### For Firefox:
1. Check your Firefox version: Firefox Menu → Help → About Firefox
2. Download GeckoDriver from: https://github.com/mozilla/geckodriver/releases
3. Extract and note the location

**Note:** The project uses WebDriverManager, so manual download is optional.

### Step 2: Create Project in NetBeans

1. **Open NetBeans IDE**

2. **Create New Project:**
   - File → New Project
   - Select: **Maven** → **Java Application**
   - Click **Next**

3. **Project Configuration:**
   - Project Name: `SeleniumTesting`
   - Project Location: Choose your desired location
   - Group ID: `com.selenium`
   - Artifact ID: `selenium-testing`
   - Version: `1.0-SNAPSHOT`
   - Package: `com.selenium.tests`
   - Click **Finish**

4. **Import Existing Project (Alternative):**
   - File → Open Project
   - Navigate to this project folder
   - Select the project and click **Open Project**

### Step 3: Configure Maven Dependencies

1. **Open `pom.xml`** in NetBeans
2. The dependencies are already configured:
   - Selenium Java (4.15.0)
   - WebDriverManager (5.6.2)
   - JUnit 5 (5.10.0)

3. **Download Dependencies:**
   - Right-click on project → **Build** (or press F11)
   - NetBeans will automatically download all dependencies
   - Wait for "BUILD SUCCESS" message

### Step 4: Verify Project Structure

Your project should have this structure:
```
SeleniumTesting/
├── pom.xml
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── selenium/
│   │               └── tests/
│   │                   └── SeleniumTestCases.java
│   └── test/
│       └── java/
│           └── com/
│               └── selenium/
│                   └── tests/
│                       └── SeleniumTestCases.java
└── README.md
```

## Running Test Cases

### Method 1: Run Individual Test

1. Open `SeleniumTestCases.java`
2. Right-click on any test method (e.g., `testChromeDriverSetup`)
3. Select **Run File** (or press Shift+F6)
4. Watch the browser open and execute the test

### Method 2: Run All Tests

1. Right-click on `SeleniumTestCases.java`
2. Select **Test File** (or press Alt+F6)
3. All test methods will execute sequentially

### Method 3: Run from Test Navigator

1. Open **Window** → **Navigator** (or press Ctrl+7)
2. Navigate to **Test Files** tab
3. Right-click on test class → **Run**

## Test Cases Description

### Test Case 1: Chrome Driver Setup and Navigation
- **Purpose:** Verify Chrome driver setup and basic navigation
- **Steps:**
  1. Downloads Chrome driver automatically
  2. Creates Chrome driver instance
  3. Navigates to test website
  4. Verifies page title

### Test Case 2: Firefox Driver Setup and Navigation
- **Purpose:** Verify Firefox driver setup and basic navigation
- **Steps:**
  1. Downloads Firefox driver automatically
  2. Creates Firefox driver instance
  3. Navigates to test website
  4. Verifies page title

### Test Case 3: Element Location Using By Class
- **Purpose:** Demonstrate various element location strategies
- **Locators Demonstrated:**
  - `By.id()` - Locate by element ID
  - `By.name()` - Locate by name attribute
  - `By.className()` - Locate by CSS class
  - `By.tagName()` - Locate by HTML tag
  - `By.cssSelector()` - Locate by CSS selector
  - `By.xpath()` - Locate by XPath expression
  - `By.linkText()` - Locate link by exact text
  - `By.partialLinkText()` - Locate link by partial text

### Test Case 4: Performing Actions on Web Elements
- **Purpose:** Demonstrate actions on located elements
- **Actions Demonstrated:**
  - `clear()` - Clear input field
  - `sendKeys()` - Enter text
  - `getAttribute()` - Get element attribute
  - `isDisplayed()` - Check visibility
  - `isEnabled()` - Check if enabled
  - `getText()` - Get element text
  - `click()` - Click element

### Test Case 5: Comprehensive Usability and Functionality Test
- **Purpose:** Complete end-to-end test scenario
- **Combines:** All previous concepts in one test

## Screenshot Guide

### Screenshot 1: Project Structure in NetBeans
**What to capture:**
- NetBeans Projects window showing the project structure
- Files: `pom.xml`, `SeleniumTestCases.java`

**Steps:**
1. Open NetBeans
2. Expand the project in Projects window
3. Take screenshot

### Screenshot 2: Maven Dependencies
**What to capture:**
- `pom.xml` file open in editor
- Dependencies section visible

**Steps:**
1. Double-click `pom.xml` in Projects window
2. Scroll to dependencies section
3. Take screenshot

### Screenshot 3: Chrome Driver Setup Code
**What to capture:**
- `SeleniumTestCases.java` open
- `testChromeDriverSetup()` method visible
- Code showing `WebDriverManager.chromedriver().setup()` and `new ChromeDriver()`

**Steps:**
1. Open `SeleniumTestCases.java`
2. Navigate to `testChromeDriverSetup()` method
3. Take screenshot

### Screenshot 4: Firefox Driver Setup Code
**What to capture:**
- `testFirefoxDriverSetup()` method visible
- Code showing `WebDriverManager.firefoxdriver().setup()` and `new FirefoxDriver()`

**Steps:**
1. Navigate to `testFirefoxDriverSetup()` method
2. Take screenshot

### Screenshot 5: Element Location Code
**What to capture:**
- `testElementLocation()` method visible
- Multiple `By` locator examples visible

**Steps:**
1. Navigate to `testElementLocation()` method
2. Scroll to show various By locators
3. Take screenshot

### Screenshot 6: Element Actions Code
**What to capture:**
- `testElementActions()` method visible
- Actions like `sendKeys()`, `clear()`, `click()` visible

**Steps:**
1. Navigate to `testElementActions()` method
2. Take screenshot

### Screenshot 7: Running Test in NetBeans
**What to capture:**
- Right-click menu on test method
- "Run File" or "Test File" option visible

**Steps:**
1. Right-click on a test method
2. Take screenshot of context menu

### Screenshot 8: Test Execution - Browser Opens
**What to capture:**
- Chrome/Firefox browser window opened by Selenium
- Test website loaded
- Browser address bar showing URL

**Steps:**
1. Run a test case
2. Wait for browser to open
3. Take screenshot of browser window

### Screenshot 9: Test Output in NetBeans
**What to capture:**
- NetBeans Output window
- Test execution results
- Console output showing test steps

**Steps:**
1. Run a test case
2. Check Output window (Window → Output)
3. Take screenshot of test results

### Screenshot 10: Element Interaction
**What to capture:**
- Browser window with test website
- Search box with text entered
- Elements highlighted (if using browser dev tools)

**Steps:**
1. Run `testElementActions()` test
2. Browser should show search box with text
3. Take screenshot

## Troubleshooting

### Issue: Driver not found
**Solution:**
- Ensure WebDriverManager dependency is in `pom.xml`
- Check internet connection (WebDriverManager downloads drivers)
- Try: Right-click project → Clean and Build

### Issue: Browser doesn't open
**Solution:**
- Verify browser is installed
- Check browser version compatibility
- Try updating WebDriverManager version in `pom.xml`

### Issue: Tests fail with timeout
**Solution:**
- Increase wait time in test code
- Check internet connection
- Verify test website is accessible

### Issue: Maven dependencies not downloading
**Solution:**
- Right-click project → **Reload Project**
- Tools → Options → Java → Maven → Check Maven settings
- Try: Right-click project → **Build with Dependencies**

## Code Explanation

### Creating Driver Instance

```java
// Chrome Driver
WebDriverManager.chromedriver().setup();
ChromeDriver driver = new ChromeDriver();

// Firefox Driver
WebDriverManager.firefoxdriver().setup();
FirefoxDriver driver = new FirefoxDriver();
```

### Locating Elements

```java
// By ID
WebElement element = driver.findElement(By.id("element-id"));

// By Name
WebElement element = driver.findElement(By.name("element-name"));

// By CSS Selector
WebElement element = driver.findElement(By.cssSelector("input[type='text']"));

// By XPath
WebElement element = driver.findElement(By.xpath("//input[@id='search']"));
```

### Performing Actions

```java
// Enter text
element.sendKeys("text to enter");

// Click element
element.click();

// Clear field
element.clear();

// Get attribute
String value = element.getAttribute("attribute-name");
```

## Project Files

- **pom.xml** - Maven configuration with dependencies
- **SeleniumTestCases.java** - All test cases implementation
- **README.md** - This documentation file

## Additional Resources

- Selenium Documentation: https://www.selenium.dev/documentation/
- WebDriverManager: https://github.com/bonigarcia/webdrivermanager
- JUnit 5 Documentation: https://junit.org/junit5/docs/current/user-guide/

## Notes

- The project uses **WebDriverManager** for automatic driver management
- Tests use **JUnit 5** for test framework
- All tests include detailed console output for debugging
- Browser windows will open during test execution (not headless by default)

## Author

Selenium Testing Project - Created for educational purposes

## License

This project is for educational use only.

