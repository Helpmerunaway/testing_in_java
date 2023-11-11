package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class WorkWithWindows {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        // неявное ожидание 10 сек
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // неявное ожидание 10 сек
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        JavascriptExecutor js = (JavascriptExecutor) driver;


        try {
            driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
            Thread.sleep(5000);

            // получаем дискриптор текущего окна и сохраняем в переменную
            String window1 = driver.getWindowHandle();

            // открываем новое окно
            js.executeScript("window.open()");

            // получаем все окна в виде набора строк
            Set<String> currentWindows = driver.getWindowHandles();

            // назначаем второму окну пусто
            String window2 = null;
            // перебираем список
            for (String window: currentWindows) {
                // создаем условие - проверяем на эквивалентность с первым окном
                if (!window.equals(window1)) {
                    // если окно не равно первому окну тогда записываем его во вторую переменную и выходим из цикла
                    window2 = window;
                    break;
                }
            };
            // меняемся на окно 2
            driver.switchTo().window(window2);
            driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
            // закрываем текущую вкладку
            driver.close();
            // возвращаемся на первое окно
            driver.switchTo().window(window1);


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            driver.quit();
        }
    }
}
