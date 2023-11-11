package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ChangeStyleAndUploadFile {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        // неявное ожидание 10 сек
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // неявное ожидание 10 сек
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        JavascriptExecutor js = (JavascriptExecutor) driver;


        try {
            driver.get("https://testpages.eviltester.com/styled/file-upload-test.html");
            Thread.sleep(5000);

            WebElement element = driver.findElement(By.id("fileinput"));

            // изменить стиль для инпута
            // js.executeScript("document.querySelector('#fileinput').setAttribute('style', 'opacity:1')");

            // отправить файл к инпуту с типом file
            element.sendKeys("C:\\example.html");
            Thread.sleep(2000);

            String title = driver.getTitle();

            Assert.assertEquals(title, "Upload a File");


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            driver.quit();
        }
    }
}
