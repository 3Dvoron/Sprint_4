package ru.yandex.praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private final WebDriver driver;
    private final By headerButtonOrder = By.xpath(".//button[@class='Button_Button__ra12g']");
    private final By mainButtonOrder = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button");

    public MainPage(WebDriver driver) {

        this.driver = driver;
    }

    public void clickHeaderOrderButton() {
        driver.findElement(headerButtonOrder).click();
    }

    public void clickMainOrderButton() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0, 2000);");
        driver.findElement(mainButtonOrder).click();
    }
}
