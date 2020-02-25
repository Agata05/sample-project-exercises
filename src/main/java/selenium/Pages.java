package selenium;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.configurations.TypedProperties;

@Slf4j
public abstract class Pages extends SeleniumFunctions {

    @FindBy(id = "solution")
    private WebElement buttonCheckSolution;

    @FindBy(id = "trail")
    private WebElement trailBox;

	@FindBy(xpath = "//td[contains(text(),'Trail set to')]/code")
	private WebElement trialExpectedBox;

    private final static TypedProperties testConfig = new TypedProperties("/test_config.properties");

    public Pages(final WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    private String baseUrl = testConfig.getValue("base_url");


    protected void open(String path) {
        driver.get(baseUrl + path);
    }

    protected Pages open() {
        driver.get(baseUrl);
        return this;
    }

    public void clickbuttonCheckSolution() {
        log.info("Click button CheckSolution");
        buttonCheckSolution.click();
    }

    public String getTrailText() {
		val trailText = trailBox.getText();
        log.info("Collected text from trail box: " + trailText);
        return trailText;
    }

	public String getTrailExpectedText() {
		val trailExpectedText = trialExpectedBox.getText();
		log.info("Collected text from trail box: " + trailExpectedText);
		return trailExpectedText;
	}
}
