package selenium.testcases;

import selenium.SeleniumTestWrapper;
import selenium.pageobjects.StartPage;

public class BaseTest extends SeleniumTestWrapper {

    StartPage startPage;
    static final String START_PAGE_TITLE = "AntyCaptcha";
    static final String CHECK_SOLUTION_POSITIVE_TEXT = "OK. Good answer";
}
