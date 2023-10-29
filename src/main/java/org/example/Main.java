package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ruslan\\IdeaProjects\\testing_in_java\\src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        // неявное ожидание - при поиске элементов по умолчанию ожидаем 10 секунд
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // явное ожидание - будет ждать появляения указанного элемента 10 секунд
        WebElement element = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("123"))));
        driver.get("https://google.com");

        WebElement input = driver.findElement(By.xpath("//textarea[@name='q']"));
        input.click();

        driver.quit();

    }
}