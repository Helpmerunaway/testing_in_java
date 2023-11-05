package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class DragAndDrop {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        // неявное ожидание - при поиске элементов по умолчанию ожидаем 10 секунд
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        try {
            driver.get("https://crossbrowsertesting.github.io/drag-and-drop");
            Thread.sleep(2000);
            WebElement element_drag = driver.findElement(By.id("draggable"));
            WebElement element_drop = driver.findElement(By.id("droppable"));

            Actions actions = new Actions(driver);
            // метод для драг енд дропа
            actions.
                    moveToElement(element_drag).
                    clickAndHold().
                    moveToElement(element_drop).
                    release().
                    build().
                    perform();

            // или
            // actions.dragAndDrop(element_drag, element_drop);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            Thread.sleep(2000);
            driver.quit();
        }
        }


}
