package ObjRepo;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class cartPage {
	WebDriver driver;
    public cartPage(WebDriver driver) {
    		this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Cart title
    public String getCarttitle() {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        By cartTitle =
                By.xpath("//span[@data-test='title']");

        WebElement title = wait.until(
                ExpectedConditions.refreshed(
                        ExpectedConditions.visibilityOfElementLocated(
                                cartTitle
                        )
                )
        );

        return title.getText();
    }

    // Continue Shopping button
    @FindBy(xpath = "//button[@id=\"continue-shopping\"]")
    private WebElement continuebtn;

    public WebElement getContinuebtn() {
        return continuebtn;
    }

    // Checkout button
    @FindBy(xpath = "//button[@id=\"checkout\"]")
    private WebElement checkoutbtn;

    public WebElement getCheckoutbtn() {
        return checkoutbtn;
    }

    // Products inside cart
    @FindBy(xpath = "//div[@class=\"cart_item\"]")
    private List<WebElement> cartitems;

    public List<String> getCartitems() {

        List<String> cartitm = new ArrayList<>();

        for (WebElement ci : cartitems) {
            cartitm.add(ci.getText());
        }

        return cartitm;
    }

    public int getCartItemCount() {

        return cartitems.size();
    }

    // Remove buttons
    @FindBy(xpath = "//button[contains(@id,'remove')]")
    private List<WebElement> removeButtons;

    public List<WebElement> getRemoveButtons() {

        return removeButtons;
    }
    public void clickRemoveButton() {
        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        By removeButton =
                By.xpath("//button[contains(@id,'remove')]");

        wait.until(
                ExpectedConditions.elementToBeClickable(removeButton)
        ).click();

        // Wait until the cart becomes empty
        wait.until(
                ExpectedConditions.invisibilityOfElementLocated(
                        By.xpath("//div[@class='cart_item']")
                )
        );
    }

    // Click Checkout
    public void clickCheckout() {

        checkoutbtn.click();
    }
}