package selenium.pageobjects;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.Pages;

@Slf4j
public class StartPage extends Pages {

    public StartPage(final WebDriver driver) {
        super(driver);
    }

    @Override
    public StartPage open() {
        super.open();
        return this;
    }

    @FindBy(css = "a[href*='exercise1']")
    private WebElement exerciseLink1;

    @FindBy(css = "a[href*='exercise3']")
    private WebElement exerciseLink3;

    public String getTitle() {
        return driver.getTitle();
    }

    public boolean isExerciseButton1Displayed() {
        return exerciseLink1.isDisplayed();
    }

    public boolean isExerciseButton1Enabled() {
        return exerciseLink1.isEnabled();
    }

    public ThreeButtonsPage navigateToThreeButtonsPage() {
        log.info("Navigate to Three Buttons Page");
        exerciseLink1.click();
        return new ThreeButtonsPage(driver);
    }

    public DropdownListPage navigateToDropdownPage() {
        log.info("Navigate to Dropdown List Page");
        exerciseLink3.click();
        return new DropdownListPage(driver);
    }
}
