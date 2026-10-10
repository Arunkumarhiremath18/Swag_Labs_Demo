package ObjRepo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPageYourInfo {
	WebDriver driver;
    public CheckoutPageYourInfo(WebDriver driver) {
    		this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    // Checkout page title
    @FindBy(xpath = "//span[@class=\"title\"]")
    private WebElement CheckoutTitle;

    // First name field
    @FindBy(xpath = "//input[@id='first-name']")
    private WebElement Fname;

    // Last name field
    @FindBy(xpath = "//input[@id='last-name']")
    private WebElement Lname;

    // Postal code field
    @FindBy(xpath = "//input[@id='postal-code']")
    private WebElement Postalcode;

    // Continue button
    @FindBy(xpath = "//input[@id='continue']")
    private WebElement ContinueBtn;

    // Cancel button
    @FindBy(xpath = "//button[@id='cancel']")
    private WebElement CancelBtn;

    // Error message
    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement errorMessage;

    public String getCheckoutTitle() {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        By titleLocator = By.xpath("//span[@class='title']");

        WebElement title = wait.until(
                ExpectedConditions.refreshed(
                        ExpectedConditions.visibilityOfElementLocated(
                                titleLocator
                        )
                )
        );

        return title.getText();
    }

    // Enter first name
    public void enterFirstName(String fname) {

        Fname.clear();
        Fname.sendKeys(fname);
    }

    // Enter last name
    public void enterLastName(String lname) {

        Lname.clear();
        Lname.sendKeys(lname);
    }

    // Enter postal code
    public void enterPostalCode(String postalcode) {

        Postalcode.clear();
        Postalcode.sendKeys(postalcode);
    }

    // Click Continue
    public void clickContinue() {

        ContinueBtn.click();
    }

    // Click Cancel
    public void clickCancel() {

        CancelBtn.click();
    }

    // Check first name field
    public boolean isFirstNameDisplayed() {

        return Fname.isDisplayed();
    }

    // Check last name field
    public boolean isLastNameDisplayed() {

        return Lname.isDisplayed();
    }

    // Check postal code field
    public boolean isPostalCodeDisplayed() {

        return Postalcode.isDisplayed();
    }

    // Check Continue button
    public boolean isContinueDisplayed() {

        return ContinueBtn.isDisplayed();
    }

    // Check Cancel button
    public boolean isCancelDisplayed() {

        return CancelBtn.isDisplayed();
    }

    // Check error message
    public boolean isErrorDisplayed() {

        return errorMessage.isDisplayed();
    }

    // Enter all checkout information
    public void Info(
            String fname,
            String lname,
            String postalcode)
            throws InterruptedException {

        enterFirstName(fname);
        enterLastName(lname);
        enterPostalCode(postalcode);

        clickContinue();

        Thread.sleep(2000);
    }
}