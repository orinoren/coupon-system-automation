package coupons.infra.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends AbstractPage {


    @FindBy(id = "emailInput")
    private WebElement emailInput;

    @FindBy(id = "passwordInput")
    private WebElement passwordInput;

    @FindBy(id = "loginBtn")
    private WebElement loginBtn;


    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public LoginPage fillEmailInput(String text) {
        new WebDriverWait(this.driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOf(this.emailInput)).
                sendKeys(text);
        return this;
    }

    public LoginPage fillPasswordInput(String text) {
        new WebDriverWait(this.driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOf(this.passwordInput)).
                sendKeys(text);
        return this;
    }

    public CustomerMainPage clickOnLoginBtnAndGoToCustomerPage() {
        new WebDriverWait(this.driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.elementToBeClickable(this.loginBtn)).
                click();
        return new CustomerMainPage(this.driver);
    }
}
