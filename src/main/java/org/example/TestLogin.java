package org.example;

import org.example.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestLogin {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        // неявное ожидание 10 сек
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // неявное ожидание 10 сек
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            driver.get("https://www.saucedemo.com/");
            Thread.sleep(2000);

            LoginPage lp = new LoginPage();
            lp.login("standard_user", "secret_sauce");


        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

}
