package ru.yandex.praktikum.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ImportantQuestion {
    private final WebDriver driver;

    public ImportantQuestion(WebDriver driver) {

        this.driver = driver;
    }

    public void checkQuestionText(By selectorQuestion, By selectorText, String expectedText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0, 2800);");
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectorQuestion));
        driver.findElement(selectorQuestion).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectorText));
        String actual = driver.findElement(selectorText).getText();
        Assert.assertEquals(actual, expectedText);
    }
}
