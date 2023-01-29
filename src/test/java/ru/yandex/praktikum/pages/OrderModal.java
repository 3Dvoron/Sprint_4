package ru.yandex.praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderModal {
    private final WebDriver driver;
    private final By popup = By.xpath(".//div[@class = 'Order_Modal__YZ-d3']");
    private final By confirmOrderButton = By.xpath(".//div[@class = 'Order_Buttons__1xGrp']/button[text()='Да']");
    private final By createOrderModalText = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ']");

    public OrderModal(WebDriver driver) {
        this.driver = driver;
    }

    public void checkOpenPopup() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(popup));
    }

    public void clickConfirmButton() {
        driver.findElement(confirmOrderButton).click();
    }

    public void checkOpenPopapOrderCreate() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(createOrderModalText));
    }
}
