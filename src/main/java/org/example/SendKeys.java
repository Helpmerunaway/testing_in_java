package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SendKeys {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        // неявное ожидание - при поиске элементов по умолчанию ожидаем 10 секунд
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://udemy.com");

        WebElement element = driver.findElement(By.xpath("//input[@name='q']"));
        element.click();
        element.clear();
        element.sendKeys("Java", Keys.ENTER);




        driver.quit();

    }
}