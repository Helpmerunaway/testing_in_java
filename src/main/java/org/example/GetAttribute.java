package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class GetAttribute {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://devby.io/");
        WebElement enter = driver.findElement(By.xpath("//div//a[@class='navbar__nav-item']//*[@class ='d-inline-block']"));
        // проверка вёрстки с помощью метода getcssvalue
        String param = enter.getCssValue("display");

        System.out.println(param);

        enter.click();
        Assert.assertEquals(param, "block");

        driver.quit();

    }
}
