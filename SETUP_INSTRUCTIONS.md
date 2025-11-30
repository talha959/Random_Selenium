# Quick Setup Instructions for NetBeans

## Step 1: Download Selenium Driver

**Automatic Method (Recommended):**
- The project uses WebDriverManager which automatically downloads drivers
- No manual download needed!
- Just run the tests and drivers will be downloaded automatically

**Manual Method (Optional):**
1. **For Chrome:**
   - Visit: https://chromedriver.chromium.org/downloads
   - Download version matching your Chrome browser
   - Extract chromedriver.exe
   - Note the location (e.g., `C:\selenium\chromedriver.exe`)

2. **For Firefox:**
   - Visit: https://github.com/mozilla/geckodriver/releases
   - Download latest version for Windows
   - Extract geckodriver.exe
   - Note the location (e.g., `C:\selenium\geckodriver.exe`)

## Step 2: Create/Open Project in NetBeans

### Option A: Create New Maven Project
1. Open NetBeans
2. File → New Project
3. Select: **Maven** → **Java Application**
4. Click **Next**
5. Enter:
   - Project Name: `SeleniumTesting`
   - Group ID: `com.selenium`
   - Artifact ID: `selenium-testing`
   - Version: `1.0-SNAPSHOT`
6. Click **Finish**

### Option B: Open Existing Project
1. File → Open Project
2. Navigate to this folder
3. Select the project folder
4. Click **Open Project**

## Step 3: Configure Dependencies

1. Open `pom.xml` file
2. Dependencies are already configured:
   - Selenium Java 4.15.0
   - WebDriverManager 5.6.2
   - JUnit 5.10.0

3. **Download Dependencies:**
   - Right-click project → **Build** (F11)
   - Or: Right-click project → **Reload Project**
   - Wait for "BUILD SUCCESS"

## Step 4: Verify Project Structure

Your project should have:
```
SeleniumTesting/
├── pom.xml
└── src/
    └── test/
        └── java/
            └── com/
                └── selenium/
                    └── tests/
                        └── SeleniumTestCases.java
```

## Step 5: Run Tests

### Run Single Test:
1. Open `SeleniumTestCases.java`
2. Right-click on any test method (e.g., `testChromeDriverSetup`)
3. Select **Run File** (Shift+F6)

### Run All Tests:
1. Right-click on `SeleniumTestCases.java`
2. Select **Test File** (Alt+F6)

### Expected Behavior:
- Browser will open automatically
- Test will navigate to website
- Test will perform actions
- Browser will close after test
- Results shown in Output window

## Step 6: Select a Random Website

The test uses `https://www.amazon.com` by default.

**To change the website:**
1. Open `SeleniumTestCases.java`
2. Find line: `private static final String TEST_URL = "https://www.amazon.com";`
3. Change to your desired website, for example:
   - `"https://www.google.com"`
   - `"https://www.github.com"`
   - `"https://www.wikipedia.org"`

## Troubleshooting

### Issue: "Driver not found"
**Solution:** 
- Ensure internet connection (WebDriverManager needs to download)
- Check firewall settings
- Try: Right-click project → Clean and Build

### Issue: "Browser doesn't open"
**Solution:**
- Verify Chrome/Firefox is installed
- Check browser version
- Try updating WebDriverManager version in pom.xml

### Issue: "Maven dependencies error"
**Solution:**
1. Right-click project → **Reload Project**
2. Tools → Options → Java → Maven
3. Check Maven home directory
4. Try: Right-click project → **Build with Dependencies**

### Issue: "Tests fail"
**Solution:**
- Check internet connection
- Verify test website is accessible
- Check browser is up to date
- Increase wait times in test code

## Quick Test Checklist

- [ ] Project opens in NetBeans
- [ ] pom.xml has all dependencies
- [ ] Maven build succeeds
- [ ] Test file compiles without errors
- [ ] Browser opens when running test
- [ ] Test completes successfully
- [ ] Output window shows test results

## Next Steps

1. Run all test cases
2. Take screenshots following `SCREENSHOT_GUIDE.md`
3. Review test output in NetBeans
4. Modify test cases as needed
5. Add more test scenarios

## Important Notes

- **WebDriverManager** automatically handles driver downloads
- Tests will open real browser windows (not headless)
- Make sure you have stable internet connection
- Browser windows will close automatically after tests
- All test output is printed to console

