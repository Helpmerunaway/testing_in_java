package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Avito {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.avito.ru/all/transport");

        WebElement auto = driver.findElement(By.xpath("//div[@data-marker='rubricator']//a[@title='Автомобили']"));
        // получаем свойство элемента - со вкладки properties
        String param = auto.getAttribute("href");
        // выводим в принт результат
        System.out.println(param);

        WebElement benz = driver.findElement(By.xpath("//*[@title='Mercedes-Benz']/parent::*/span[@data-marker='popular-rubricator/count'][1]"));
        // получаем параметр текст без юникода
        String text = benz.getText();
        System.out.println(text);

        driver.quit();

    }
}