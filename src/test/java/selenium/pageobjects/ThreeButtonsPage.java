package selenium.pageobjects;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.Pages;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class ThreeButtonsPage extends Pages {

    ThreeButtonsPage(final WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "btnButton1")
    private WebElement buttonB1;

    @FindBy(name = "btnButton2")
    private WebElement buttonB2;

    @FindBy(css = "tbody tr td:nth-of-type(2) code")
    private List<WebElement> buttonTypes;


    private void clickButtonB1() {
        log.info("Click button B1");
        buttonB1.click();
    }

    private void clickButtonB2() {
        log.info("Click button B2");
        buttonB2.click();
    }

    public List<ButtonType> getButtonsOrder() {
        return buttonTypes.stream()
                .map(WebElement::getText)
                .map(ButtonType::valueOf)
                .collect(Collectors.toList());
    }

    public void clickButton(ButtonType buttonType) {
        log.info("click button: " + buttonType);
        switch (buttonType) {
            case B1:
                clickButtonB1();
                break;
            case B2:
                clickButtonB2();
                break;
            default:
                throw new IllegalStateException("Unexpected button type: " + buttonType);
        }

    }

    public enum ButtonType {
        B1,
        B2
    }
}
