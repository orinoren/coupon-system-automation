package coupons.infra.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends AbstractPage {

    @FindBy(id = "EnterAsGuest")
    private WebElement enterAsGuestBtn;

    @FindBy(id = "nav-loginBtn")
    private WebElement loginBtn;

    @FindBy(id="loginAsUserBtn")
    private WebElement loginAsUserBtn;


    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;

    }


    public LoginPage clickOnEnterAsGuestButton() {
        new WebDriverWait(this.driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.elementToBeClickable(this.enterAsGuestBtn)).
                click();
        return new LoginPage(this.driver);
    }

    public LoginPage clickOnLoginAsUserButton() {
        new WebDriverWait(this.driver, Duration.ofSeconds(100)).
                until(ExpectedConditions.visibilityOf(this.loginAsUserBtn)).
                click();
        return new LoginPage(this.driver);
    }
}
