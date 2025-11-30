package com.selenium.tests;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("Selenium Test Suite - All Test Cases")
@SelectClasses({
    TestCase1_ChromeDriverSetup.class,
    TestCase2_FirefoxDriverSetup.class,
    TestCase3_ElementLocation.class,
    TestCase3_ElementLocationFirefox.class,
    TestCase4_ElementActions.class,
    TestCase4_ElementActionsFirefox.class,
    TestCase5_ComprehensiveScenario.class,
    TestCase5_ComprehensiveScenarioFirefox.class
})
public class TestSuite {
}

