package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {

    WebDriver driver = new ChromeDriver();


    WebElement login_input = driver.findElement(By.cssSelector("#user-name"));
    WebElement password_input = driver.findElement(By.cssSelector("#password"));
    WebElement enter = driver.findElement(By.cssSelector("#login-button"));

    public void login (String login, String password) {
        login_input.sendKeys(login);
        password_input.sendKeys(password);
        enter.click();
    };

}
