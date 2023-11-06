package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ExpectedConditions {
    public static void main(String[] args) {
    System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            driver.get("https://pagination.js.org/");
            Thread.sleep(2000);
            // получаем список номеров 1-10 на первой странице
            List<WebElement> elements = driver.findElements(By.xpath("//div[@class='data-container']/ul/li"));
            // получаем список страниц
            List<WebElement> pages = driver.findElements(By.xpath("//div[@class='paginationjs-pages']/ul/li"));

            // забираем информацию об номере 6
            String text = elements.get(5).getText();
            // выводим его в принт
            System.out.println(text);

            // перелистываем на страницу 2
            pages.get(2).click();
            // проверяем что 6 номера нет - ожидаем что 6 нумера нет
            wait.until(org.openqa.selenium.support.ui.ExpectedConditions.stalenessOf(elements.get(5)));
            // получаем список номеров 11-20 на второй странице
            elements = driver.findElements(By.xpath("//div[@class='data-container']/ul/li"));
            // забираем информацию об номере 16
                text = elements.get(5).getText();
            // выводим его в принт
            System.out.println(text);


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            driver.quit();
        }
    }
}
