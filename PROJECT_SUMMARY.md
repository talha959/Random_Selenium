# Selenium Testing Project - Summary

## Project Overview

This project implements comprehensive Selenium WebDriver test cases for usability and functionality testing using Apache NetBeans IDE.

## Requirements Fulfilled

✅ **Step 1: Download Selenium Driver**
- Implemented using WebDriverManager for automatic driver management
- Supports both Chrome and Firefox drivers
- No manual download required

✅ **Step 2: Select Random Website**
- Test website: https://www.amazon.com
- Can be easily changed in `SeleniumTestCases.java` (line 33)

✅ **Step 3: Locate Elements Using By Class**
- Implemented 8 different By locator strategies:
  - `By.id()`
  - `By.name()`
  - `By.className()`
  - `By.tagName()`
  - `By.cssSelector()`
  - `By.xpath()`
  - `By.linkText()`
  - `By.partialLinkText()`

✅ **Step 4: Perform Actions on Web Elements**
- Implemented multiple element actions:
  - `clear()` - Clear input fields
  - `sendKeys()` - Enter text
  - `click()` - Click elements
  - `getAttribute()` - Get element attributes
  - `isDisplayed()` - Check visibility
  - `isEnabled()` - Check if enabled
  - `getText()` - Get element text

## Project Structure

```
Random_Selenium/
├── pom.xml                          # Maven configuration
├── README.md                        # Complete documentation
├── SCREENSHOT_GUIDE.md             # Detailed screenshot instructions
├── SETUP_INSTRUCTIONS.md           # Quick setup guide
├── PROJECT_SUMMARY.md              # This file
└── src/
    └── test/
        └── java/
            └── com/
                └── selenium/
                    └── tests/
                        └── SeleniumTestCases.java  # All test cases
```

## Test Cases Implemented

### Test Case 1: Chrome Driver Setup and Navigation
- **File:** `SeleniumTestCases.java`
- **Method:** `testChromeDriverSetup()`
- **Demonstrates:**
  - Automatic Chrome driver download
  - Chrome driver instance creation
  - Website navigation
  - Page title verification

### Test Case 2: Firefox Driver Setup and Navigation
- **File:** `SeleniumTestCases.java`
- **Method:** `testFirefoxDriverSetup()`
- **Demonstrates:**
  - Automatic Firefox driver download
  - Firefox driver instance creation
  - Website navigation
  - Page title verification

### Test Case 3: Element Location Using By Class
- **File:** `SeleniumTestCases.java`
- **Method:** `testElementLocation()`
- **Demonstrates:**
  - All 8 By locator strategies
  - Finding single and multiple elements
  - Error handling for missing elements

### Test Case 4: Performing Actions on Web Elements
- **File:** `SeleniumTestCases.java`
- **Method:** `testElementActions()`
- **Demonstrates:**
  - Text input
  - Element clearing
  - Attribute retrieval
  - Visibility checks
  - Element interaction

### Test Case 5: Comprehensive Usability and Functionality Test
- **File:** `SeleniumTestCases.java`
- **Method:** `testComprehensiveScenario()`
- **Demonstrates:**
  - Complete end-to-end test scenario
  - Combining all concepts
  - Usability testing
  - Functionality testing

## Key Features

1. **Automatic Driver Management**
   - Uses WebDriverManager library
   - Automatically downloads correct driver version
   - No manual configuration needed

2. **Multiple Browser Support**
   - Chrome browser support
   - Firefox browser support
   - Easy to extend for other browsers

3. **Comprehensive Element Location**
   - 8 different locator strategies
   - Examples for each strategy
   - Error handling included

4. **Extensive Element Actions**
   - Text input/output
   - Click operations
   - Attribute access
   - State checking

5. **Detailed Documentation**
   - Step-by-step setup instructions
   - Screenshot guide with 14 screenshots
   - Troubleshooting section
   - Code explanations

## Technologies Used

- **Java 11** - Programming language
- **Selenium WebDriver 4.15.0** - Browser automation
- **WebDriverManager 5.6.2** - Driver management
- **JUnit 5.10.0** - Testing framework
- **Maven** - Build and dependency management
- **Apache NetBeans** - IDE

## How to Use

1. **Open Project in NetBeans:**
   - File → Open Project
   - Select this folder

2. **Build Project:**
   - Right-click project → Build (F11)
   - Wait for dependencies to download

3. **Run Tests:**
   - Open `SeleniumTestCases.java`
   - Right-click on test method → Run File
   - Or: Right-click on class → Test File

4. **View Results:**
   - Check Output window for test results
   - Browser will open during test execution
   - All steps are logged to console

## Screenshots Required

Follow `SCREENSHOT_GUIDE.md` for detailed instructions on capturing:
1. Project structure
2. Maven configuration
3. Chrome driver setup code
4. Firefox driver setup code
5. Element location code
6. Element actions code
7. Running tests
8. Browser execution
9. Test output
10. Element interaction
11. Multiple locators
12. Test results
13. File structure
14. Maven build

## Code Highlights

### Creating Driver Instance
```java
// Chrome
WebDriverManager.chromedriver().setup();
ChromeDriver driver = new ChromeDriver();

// Firefox
WebDriverManager.firefoxdriver().setup();
FirefoxDriver driver = new FirefoxDriver();
```

### Locating Elements
```java
// By ID
WebElement element = driver.findElement(By.id("element-id"));

// By CSS Selector
WebElement element = driver.findElement(By.cssSelector("input[type='text']"));

// By XPath
WebElement element = driver.findElement(By.xpath("//input[@id='search']"));
```

### Performing Actions
```java
element.clear();
element.sendKeys("text");
element.click();
String value = element.getAttribute("attribute");
```

## Expected Output

When running tests, you should see:
```
=== Test Case 1: Chrome Driver Setup ===
✓ Chrome driver downloaded and configured
✓ Chrome driver instance created
✓ Navigated to: https://www.amazon.com
✓ Page Title: Amazon.com. Spend less. Smile more.
```

## Troubleshooting

See `README.md` and `SETUP_INSTRUCTIONS.md` for detailed troubleshooting guide.

Common issues:
- Driver not found → Check internet connection
- Browser doesn't open → Verify browser installation
- Maven errors → Reload project
- Test failures → Check website accessibility

## Documentation Files

1. **README.md** - Complete project documentation
2. **SCREENSHOT_GUIDE.md** - Step-by-step screenshot instructions
3. **SETUP_INSTRUCTIONS.md** - Quick setup guide
4. **PROJECT_SUMMARY.md** - This summary document

## Next Steps

1. ✅ Project structure created
2. ✅ Test cases implemented
3. ✅ Documentation written
4. ⏳ Take screenshots (follow SCREENSHOT_GUIDE.md)
5. ⏳ Run all tests
6. ⏳ Verify all functionality

## Notes

- All tests include detailed console output
- Browser windows open during execution (not headless)
- Tests are designed to be educational and demonstrative
- Code includes comments explaining each step
- Error handling included for robustness

## Author

Selenium Testing Project - Educational Purpose

## License

For educational use only.

