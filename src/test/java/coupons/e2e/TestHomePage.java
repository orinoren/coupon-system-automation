package coupons.e2e;

import coupons.AbstractTest;
import coupons.infra.po.HomePage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestHomePage extends AbstractTest {

    @Test
    public void testClickOnEnterAsGuest() {
        driver.findElement(By.id("EnterAsGuest")).click();
        boolean searchBtn = driver.findElement(By.id("SearchBtn")).isDisplayed();
        assertThat(searchBtn).isTrue();

    }

    @Test
    public void testLoginWithCustomer() {
        var homePage = new HomePage(this.driver);
        String helloUsernameText = homePage.
                clickOnLoginAsUserButton().
                fillEmailInput("amiro@walla.com").
                fillPasswordInput("Amie@#!#324").
                clickOnLoginBtnAndGoToCustomerPage().
                getHelloUsernameText();
        assertThat(helloUsernameText).contains("amir");

    }


}
