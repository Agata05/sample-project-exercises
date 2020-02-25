package selenium.testcases;

import lombok.val;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import selenium.pageobjects.StartPage;
import selenium.pageobjects.ThreeButtonsPage;

import static org.assertj.core.api.Assertions.assertThat;

public class ThreeButtonsTest extends BaseTest {

    private ThreeButtonsPage threeButtonsPage;

    @BeforeClass
    public void setup() {
        startPage = new StartPage(getDriver())
                .open();
    }

    @Test(priority = 1)
    public void checkIfCorrectTitleIsDisplayed() {
        val startPageTitle = startPage.getTitle();
        assertThat(startPageTitle).as("Page title").contains(START_PAGE_TITLE);
    }

    @Test(priority = 2)
    public void checkIfExerciseBtn1IsDisplayedAndEnabled() {
        val isExerciseButton1Displayed = startPage.isExerciseButton1Displayed();
        val isExerciseButton1Enabled = startPage.isExerciseButton1Enabled();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(isExerciseButton1Displayed, "Is Exercise Button 1 displayed?");
        softAssert.assertTrue(isExerciseButton1Enabled, "Is Exercise Button 1 enabled?");
        softAssert.assertAll();
    }

    @Test(priority = 3)
    public void checkThreeButtonsSolution() {
        threeButtonsPage = startPage.navigateToThreeButtonsPage();
        val buttonOrder = threeButtonsPage.getButtonsOrder();
        buttonOrder.forEach(threeButtonsPage::clickButton);
        threeButtonsPage.clickbuttonCheckSolution();
        val solutionText = threeButtonsPage.getTrailText();
        val expectedSolutionText = threeButtonsPage.getTrailExpectedText();
        val answerText = threeButtonsPage.getTrailText();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(solutionText, expectedSolutionText);
        softAssert.assertEquals(answerText, CHECK_SOLUTION_POSITIVE_TEXT);
        softAssert.assertAll();
    }
}
