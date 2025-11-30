# Screenshot Guide - Step by Step Procedure

This guide provides detailed instructions for capturing screenshots of each step in the Selenium testing procedure.

## Prerequisites for Screenshots

1. **Screen Capture Tool:**
   - Windows: Snipping Tool, Print Screen, or Windows + Shift + S
   - Or use any screenshot software

2. **Organize Screenshots:**
   - Create a folder: `screenshots/` in project root
   - Name files descriptively: `01-project-structure.png`, `02-pom-xml.png`, etc.

---

## Screenshot 1: Project Setup in NetBeans

**File Name:** `01-project-structure.png`

**What to Capture:**
- NetBeans IDE window
- Projects window (left side) showing:
  - Project name: `SeleniumTesting`
  - Source Packages folder expanded
  - `com.selenium.tests` package visible
  - `SeleniumTestCases.java` file visible

**Steps:**
1. Open NetBeans IDE
2. Open the project (File → Open Project)
3. Expand the project in Projects window
4. Expand Source Packages → com.selenium.tests
5. Take screenshot

**Expected View:**
```
Projects
└── SeleniumTesting
    ├── Source Packages
    │   └── com.selenium.tests
    │       └── SeleniumTestCases.java
    ├── Test Packages
    └── pom.xml
```

---

## Screenshot 2: Maven Configuration (pom.xml)

**File Name:** `02-pom-xml-dependencies.png`

**What to Capture:**
- `pom.xml` file open in NetBeans editor
- Dependencies section visible showing:
  - selenium-java dependency
  - webdrivermanager dependency
  - junit-jupiter dependencies

**Steps:**
1. Double-click `pom.xml` in Projects window
2. Scroll to `<dependencies>` section
3. Ensure all three main dependencies are visible
4. Take screenshot

**Key Elements to Show:**
- `<dependency>` tags for Selenium
- `<dependency>` tags for WebDriverManager
- `<dependency>` tags for JUnit

---

## Screenshot 3: Chrome Driver Setup Code

**File Name:** `03-chrome-driver-setup.png`

**What to Capture:**
- `SeleniumTestCases.java` file open
- `testChromeDriverSetup()` method visible
- Code showing:
  - `WebDriverManager.chromedriver().setup();`
  - `ChromeDriver driver = new ChromeDriver();`
  - `driver.get(TEST_URL);`

**Steps:**
1. Open `SeleniumTestCases.java`
2. Navigate to `testChromeDriverSetup()` method (around line 50-80)
3. Ensure method is fully visible
4. Highlight/cursor on the method
5. Take screenshot

**Code to Show:**
```java
@Test
@DisplayName("Chrome Driver Setup and Navigation")
public void testChromeDriverSetup() {
    WebDriverManager.chromedriver().setup();
    ChromeOptions options = new ChromeOptions();
    chromeDriver = new ChromeDriver(options);
    chromeDriver.get(TEST_URL);
    // ... rest of method
}
```

---

## Screenshot 4: Firefox Driver Setup Code

**File Name:** `04-firefox-driver-setup.png`

**What to Capture:**
- `testFirefoxDriverSetup()` method visible
- Code showing:
  - `WebDriverManager.firefoxdriver().setup();`
  - `FirefoxDriver driver = new FirefoxDriver();`
  - `driver.get(TEST_URL);`

**Steps:**
1. Navigate to `testFirefoxDriverSetup()` method (around line 90-120)
2. Ensure method is fully visible
3. Take screenshot

**Code to Show:**
```java
@Test
@DisplayName("Firefox Driver Setup and Navigation")
public void testFirefoxDriverSetup() {
    WebDriverManager.firefoxdriver().setup();
    FirefoxOptions options = new FirefoxOptions();
    firefoxDriver = new FirefoxDriver(options);
    firefoxDriver.get(TEST_URL);
    // ... rest of method
}
```

---

## Screenshot 5: Element Location Using By Class

**File Name:** `05-element-location-by-class.png`

**What to Capture:**
- `testElementLocation()` method visible
- Multiple examples of `By` locators:
  - `By.id()`
  - `By.name()`
  - `By.className()`
  - `By.cssSelector()`
  - `By.xpath()`
  - `By.linkText()`

**Steps:**
1. Navigate to `testElementLocation()` method (around line 130-220)
2. Scroll to show multiple By locator examples
3. Take screenshot showing at least 4-5 different By locators

**Code to Show:**
```java
// Example 1: By ID
WebElement elementById = driver.findElement(By.id("nav-logo-sprites"));

// Example 2: By Name
WebElement elementByName = driver.findElement(By.name("field-keywords"));

// Example 3: By CSS Selector
WebElement elementByCss = driver.findElement(By.cssSelector("input[type='text']"));

// Example 4: By XPath
WebElement elementByXpath = driver.findElement(By.xpath("//input[@id='search']"));
```

---

## Screenshot 6: Element Actions Code

**File Name:** `06-element-actions.png`

**What to Capture:**
- `testElementActions()` method visible
- Actions on elements:
  - `clear()`
  - `sendKeys()`
  - `getAttribute()`
  - `isDisplayed()`
  - `click()`

**Steps:**
1. Navigate to `testElementActions()` method (around line 230-320)
2. Show code performing actions on elements
3. Take screenshot

**Code to Show:**
```java
searchBox.clear();
searchBox.sendKeys("laptop");
String placeholder = searchBox.getAttribute("placeholder");
boolean isDisplayed = searchBox.isDisplayed();
searchButton.click();
```

---

## Screenshot 7: Running Test from NetBeans

**File Name:** `07-run-test-menu.png`

**What to Capture:**
- Right-click context menu on test method
- Options visible:
  - "Run File"
  - "Test File"
  - "Debug File"

**Steps:**
1. Right-click on `testChromeDriverSetup()` method name
2. Context menu appears
3. Take screenshot showing the menu

**Alternative:**
- Show the green play button next to test method
- Or show Test Navigator window with test methods

---

## Screenshot 8: Browser Opens During Test Execution

**File Name:** `08-browser-opens.png`

**What to Capture:**
- Chrome or Firefox browser window
- Browser opened by Selenium
- Test website loaded (Amazon.com)
- Browser address bar showing URL
- Page content visible

**Steps:**
1. Run `testChromeDriverSetup()` or `testFirefoxDriverSetup()`
2. Wait for browser to open automatically
3. Browser should navigate to test website
4. Take screenshot of browser window

**Important:**
- Browser should be maximized or clearly visible
- URL in address bar should be visible
- Page should be fully loaded

---

## Screenshot 9: Test Output in NetBeans

**File Name:** `09-test-output.png`

**What to Capture:**
- NetBeans Output window
- Test execution results
- Console output showing:
  - "=== Test Case 1: Chrome Driver Setup ==="
  - "✓ Chrome driver downloaded and configured"
  - "✓ Chrome driver instance created"
  - "✓ Navigated to: ..."
  - Test results (PASSED/FAILED)

**Steps:**
1. Run a test case
2. Open Output window: Window → Output (or press Ctrl+4)
3. Select "Output" tab
4. Scroll to show test execution output
5. Take screenshot

**Expected Output:**
```
=== Test Case 1: Chrome Driver Setup ===
✓ Chrome driver downloaded and configured
✓ Chrome driver instance created
✓ Navigated to: https://www.amazon.com
✓ Page Title: Amazon.com. Spend less. Smile more.
```

---

## Screenshot 10: Element Interaction in Browser

**File Name:** `10-element-interaction.png`

**What to Capture:**
- Browser window with test website
- Search box with text entered (e.g., "laptop")
- Text visible in search field
- Browser dev tools (optional) showing element inspection

**Steps:**
1. Run `testElementActions()` test
2. Browser opens and navigates to website
3. Test enters text in search box
4. Take screenshot showing:
   - Search box with text
   - Browser window
   - Text clearly visible

**Optional Enhancement:**
- Open browser DevTools (F12)
- Inspect the search element
- Show element highlighted in DevTools
- Take screenshot

---

## Screenshot 11: Multiple By Locators in Action

**File Name:** `11-multiple-locators.png`

**What to Capture:**
- Browser DevTools open
- Elements panel showing HTML
- Different locators being used:
  - Element with ID
  - Element with class
  - Element with name attribute

**Steps:**
1. Run `testElementLocation()` test
2. When browser opens, press F12 to open DevTools
3. Go to Elements tab
4. Use "Select element" tool (Ctrl+Shift+C)
5. Click on different elements
6. Show how different locators identify elements
7. Take screenshot

---

## Screenshot 12: Test Results Summary

**File Name:** `12-test-results-summary.png`

**What to Capture:**
- NetBeans Test Results window
- All test cases listed:
  - ✓ testChromeDriverSetup - PASSED
  - ✓ testFirefoxDriverSetup - PASSED
  - ✓ testElementLocation - PASSED
  - ✓ testElementActions - PASSED
  - ✓ testComprehensiveScenario - PASSED
- Summary showing: "Tests run: 5, Failures: 0, Errors: 0"

**Steps:**
1. Run all tests: Right-click on test class → Test File
2. Wait for all tests to complete
3. Open Test Results window (should open automatically)
4. Take screenshot showing all test results

**Expected View:**
```
Test Results
├── ✓ testChromeDriverSetup (PASSED)
├── ✓ testFirefoxDriverSetup (PASSED)
├── ✓ testElementLocation (PASSED)
├── ✓ testElementActions (PASSED)
└── ✓ testComprehensiveScenario (PASSED)

Summary: Tests run: 5, Failures: 0, Errors: 0
```

---

## Screenshot 13: Project Files Structure

**File Name:** `13-file-structure.png`

**What to Capture:**
- Windows File Explorer or NetBeans Files window
- Project folder structure:
  - pom.xml
  - src/main/java/.../SeleniumTestCases.java
  - src/test/java/.../SeleniumTestCases.java
  - README.md

**Steps:**
1. Open Windows File Explorer
2. Navigate to project folder
3. Show folder structure
4. Or use NetBeans: Window → Files (Ctrl+2)
5. Expand project structure
6. Take screenshot

---

## Screenshot 14: Maven Build Success

**File Name:** `14-maven-build-success.png`

**What to Capture:**
- NetBeans Output window
- Maven build output
- "BUILD SUCCESS" message
- Dependencies downloaded

**Steps:**
1. Right-click project → Clean and Build
2. Wait for build to complete
3. Check Output window
4. Look for "BUILD SUCCESS"
5. Take screenshot

**Expected Output:**
```
[INFO] Scanning for projects...
[INFO] Building selenium-testing 1.0-SNAPSHOT
[INFO] Downloading dependencies...
[INFO] BUILD SUCCESS
[INFO] Total time: XX.XXX s
```

---

## Screenshot Organization Tips

1. **Create Screenshot Folder:**
   ```
   screenshots/
   ├── 01-project-structure.png
   ├── 02-pom-xml-dependencies.png
   ├── 03-chrome-driver-setup.png
   ├── 04-firefox-driver-setup.png
   ├── 05-element-location-by-class.png
   ├── 06-element-actions.png
   ├── 07-run-test-menu.png
   ├── 08-browser-opens.png
   ├── 09-test-output.png
   ├── 10-element-interaction.png
   ├── 11-multiple-locators.png
   ├── 12-test-results-summary.png
   ├── 13-file-structure.png
   └── 14-maven-build-success.png
   ```

2. **Screenshot Quality:**
   - Use high resolution (at least 1920x1080)
   - Ensure text is readable
   - Use clear, descriptive file names
   - Include relevant context in each screenshot

3. **Annotations (Optional):**
   - Use image editing software to add:
     - Arrows pointing to important elements
     - Text labels
     - Highlights on key areas

---

## Quick Reference Checklist

- [ ] Screenshot 1: Project structure in NetBeans
- [ ] Screenshot 2: pom.xml with dependencies
- [ ] Screenshot 3: Chrome driver setup code
- [ ] Screenshot 4: Firefox driver setup code
- [ ] Screenshot 5: Element location using By class
- [ ] Screenshot 6: Element actions code
- [ ] Screenshot 7: Running test menu
- [ ] Screenshot 8: Browser opens during test
- [ ] Screenshot 9: Test output in NetBeans
- [ ] Screenshot 10: Element interaction in browser
- [ ] Screenshot 11: Multiple locators demonstration
- [ ] Screenshot 12: Test results summary
- [ ] Screenshot 13: Project file structure
- [ ] Screenshot 14: Maven build success

---

## Notes

- Take screenshots in order for better documentation flow
- Ensure all screenshots are clear and readable
- Include both code and execution screenshots
- Show both successful test runs and code structure
- Keep browser windows visible and not minimized during screenshots

