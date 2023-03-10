package ru.yandex.praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AboutCustomersPage {
    private final WebDriver driver;
    private final By nameField = By.xpath(".//input[@placeholder='* Имя']");
    private final By surnameField = By.xpath(".//input[@placeholder='* Фамилия']");
    private final By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By choiceStation = By.className("select-search__input");
    private final By stationMetro = By.className("Order_Text__2broi");
    private final By phoneField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private final By nextButton = By.className("Button_Middle__1CSJM");

    public AboutCustomersPage(WebDriver driver) {

        this.driver = driver;
    }

    public void setNameField(String userName) {
        driver.findElement(nameField).sendKeys(userName);
    }

    public void setSurnameField(String userSurname) {
        driver.findElement(surnameField).sendKeys(userSurname);
    }

    public void setAddressField(String userAdress) {
        driver.findElement(addressField).sendKeys(userAdress);
    }

    public void choiceStation() {
        driver.findElement(choiceStation).click();
        driver.findElement(stationMetro).click();
    }

    public void setPhoneField(String userPhone) {
        driver.findElement(phoneField).isDisplayed();
        driver.findElement(phoneField).clear();
        driver.findElement(phoneField).sendKeys(userPhone);
    }

    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

}
