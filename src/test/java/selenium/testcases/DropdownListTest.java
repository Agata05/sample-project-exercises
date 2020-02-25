package selenium.testcases;

import lombok.val;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import selenium.pageobjects.DropdownListPage;
import selenium.pageobjects.StartPage;

public class DropdownListTest extends BaseTest {

    @BeforeClass
    public void setup() {
        startPage = new StartPage(getDriver())
                .open();
    }

    @Test
    public void checkDropdownSolution() {
        // Given
        DropdownListPage dropdownListPage = startPage.navigateToDropdownPage();
        val softAssert = new SoftAssert();
        val testDropDownOption = dropdownListPage.getTestDropDownOption();
        val expectedTrialText = dropdownListPage.getTrailExpectedText();

        // When
        dropdownListPage.selectOptionFromDropDown(testDropDownOption);
        dropdownListPage.clickbuttonCheckSolution();

        // Then
        val actualTrialText = dropdownListPage.getTrailText();
        softAssert.assertEquals(actualTrialText, expectedTrialText, "Trial text");

        // And When
        // Implemented in the same test method to demonstrate soft assert functioning.
        dropdownListPage.clickbuttonCheckSolution();

        // Then
        val checkSolutionActualText = dropdownListPage.getTrailText();
        softAssert.assertEquals(checkSolutionActualText, CHECK_SOLUTION_POSITIVE_TEXT, "Check solution text");

        softAssert.assertAll();
    }
}
