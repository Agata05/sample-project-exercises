package selenium.pageobjects;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import selenium.Pages;

@Slf4j
public class DropdownListPage extends Pages {

    DropdownListPage(final WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "s13")
    private WebElement s13dropdown;

    @FindBy(css = "tbody tr td:nth-of-type(2) code")
    private WebElement testDropdownOption;

    @FindBy(css = "tbody tr td:nth-of-type(3) code")
    private WebElement expectedValue;

    public void selectOptionFromDropDown(String optionText) {
        log.info("Select option: " + optionText);
        Select dropdown = new Select(s13dropdown);
        dropdown.selectByVisibleText(optionText);
    }

    public String getTestDropDownOption() {
        log.info("Get test drop down option");
        return testDropdownOption.getText();
    }
}
