package coupons.examples;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

public class TestExample {

    WebDriver driver;

    @Test
    public void testExample() {
        int a = 1;
        int b = 2;
        assertThat(a + 1).isEqualTo(b);
    }

    @Test
    @SneakyThrows
    public void testGoogle() {
        driver = WebDriverManager.chromedriver().create();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://www.google.com");
        WebElement element = driver.findElement(By.cssSelector("input.gLFyf"));

        String helloWorld = "hello world";
        element.sendKeys(helloWorld);


        WebElement submit = driver.findElement(By.cssSelector("div.FPdoLc input.gNO89b"));
        submit.click();
        boolean displayed = driver.
                findElement(By.xpath("//span[contains(text(),'\"Hello, World!\" program - Wikipedia')]")).
                isDisplayed();
        assertThat(displayed).isTrue();
        driver.quit();

    }
}
