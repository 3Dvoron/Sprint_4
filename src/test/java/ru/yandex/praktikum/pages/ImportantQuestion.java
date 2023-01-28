package ru.yandex.praktikum.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ImportantQuestion {
    private final By[] questionSelectors = {By.id("accordion__heading-0"),
            By.id("accordion__heading-1"),
            By.id("accordion__heading-2"),
            By.id("accordion__heading-3"),
            By.id("accordion__heading-4"),
            By.id("accordion__heading-5"),
            By.id("accordion__heading-6"),
            By.id("accordion__heading-7"),};
    private final By[] questionSelectorsText = {By.xpath(".//div[@id ='accordion__panel-0']/p"),
            By.xpath(".//div[@id ='accordion__panel-1']/p"),
            By.xpath(".//div[@id ='accordion__panel-2']/p"),
            By.xpath(".//div[@id ='accordion__panel-3']/p"),
            By.xpath(".//div[@id ='accordion__panel-4']/p"),
            By.xpath(".//div[@id ='accordion__panel-5']/p"),
            By.xpath(".//div[@id ='accordion__panel-6']/p"),
            By.xpath(".//div[@id ='accordion__panel-7']/p"),};
    private final String[] expectedText = {"Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
            "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
            "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
            "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
            "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
            "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
            "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
            "Да, обязательно. Всем самокатов! И Москве, и Московской области."};
    private final WebDriver driver;

    public ImportantQuestion(WebDriver driver) {

        this.driver = driver;
    }

    public void checkQuestionText(By selectorQusetsion, By selectorText, String expectedText) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0, 2800);");
        driver.findElement(selectorQusetsion).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectorText));
        String actual = driver.findElement(selectorText).getText();
        Assert.assertEquals(actual, expectedText);
    }

    public void checkAllQuestionText() {
        for (int i = 0; i < questionSelectors.length; i++) {
            checkQuestionText(questionSelectors[i], questionSelectorsText[i], expectedText[i]);
        }
    }

}
