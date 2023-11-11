package org.example;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WorkWithAlerts {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        // неявное ожидание 10 сек
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // неявное ожидание 10 сек
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            driver.get("https://demo.automationtesting.in/Alerts.html");
            Thread.sleep(2000);

            WebElement element_alert_with_ok = driver.findElement(By.xpath("//*[@onclick='alertbox()']"));

            // кликаем на кнопку первого алерта
            element_alert_with_ok.click();

            // дожидаемся пока алерт будет виден
            Alert alert = wait.until(org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent());
            // принять алерт - ok
            alert.accept();

            WebElement element_tab_ok_and_cancel = driver.findElement(By.xpath("//*[contains(text(), 'Alert with OK & Cancel')]"));

            // кликаем на вкладку для второго алерта
            element_tab_ok_and_cancel.click();

            WebElement element_alert_ok_and_cancel = driver.findElement(By.xpath("//*[@onclick='confirmbox()']"));

            // кликаем на кнопку для вызова алерта с отменой
            element_alert_ok_and_cancel.click();

            // дожидаемся пока алерт будет виден
            Alert cancel = wait.until(org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent());

            // жмем отмена
            cancel.dismiss();

            WebElement element_tab_with_text = driver.findElement(By.xpath("//*[contains(text(), 'Alert with Textbox')]"));

            // кликаем на вкладку для третьего алерта
            element_tab_with_text.click();

            WebElement element_alert_with_text = driver.findElement(By.xpath("//*[@onclick='promptbox()']"));

            // кликаем на кнопку для вызова алерта с текстом
            element_alert_with_text.click();

            // дожидаемся появления алерта с текстом
            Alert with_text = wait.until(org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent());

            // пишем "SUPER!" и ок
            with_text.sendKeys("Max!");
            with_text.accept();

            WebElement result = driver.findElement(By.xpath("//*[@id='demo1']"));
            String text = result.getText();
            // проверяем результат
            System.out.println(text);


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            driver.quit();
        }
    }
}
