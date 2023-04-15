package coupons.infra.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CustomerMainPage extends AbstractPage {

    @FindBy(id = "helloUsername")
    private WebElement helloUsername;

    @FindBy(id = "SearchBtn")
    private WebElement searchBtn;


    public CustomerMainPage(WebDriver driver) {
        super(driver);
        new WebDriverWait(this.driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOf(this.searchBtn));

    }

    public String getHelloUsernameText() {
        return this.helloUsername.getText();
    }
}
