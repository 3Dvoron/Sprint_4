package ru.yandex.praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RentInfoPage {
    private final WebDriver driver;
    private final By startDateRentField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private final By startDataRent = By.className("react-datepicker__day--026");
    private final By rentalPeriodField = By.className("Dropdown-control");
    private final By colorScooter = By.id("black");
    private final By commentField = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    private final By orderButton = By.xpath(".//div[@class = 'Order_Buttons__1xGrp']/button[text()='Заказать']");
    private final By periodRent = By.xpath(".//div[@class='Dropdown-menu']/div[1]");

    public RentInfoPage(WebDriver driver) {
        this.driver = driver;
    }

    public void choiceStartDate() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(startDateRentField));
        driver.findElement(startDateRentField).click();
        driver.findElement(startDataRent).click();
    }

    public void choicePeriodRent() {
        driver.findElement(rentalPeriodField).click();
        driver.findElement(periodRent).click();
    }

    public void clickCheckboxColor() {
        driver.findElement(colorScooter).click();
    }

    public void setCommentField(String comment) {
        driver.findElement(commentField).clear();
        driver.findElement(commentField).sendKeys(comment);
    }

    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }
}
