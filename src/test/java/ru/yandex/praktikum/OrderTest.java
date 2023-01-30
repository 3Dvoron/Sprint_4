package ru.yandex.praktikum;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.praktikum.pages.AboutCustomersPage;
import ru.yandex.praktikum.pages.MainPage;
import ru.yandex.praktikum.pages.OrderModal;
import ru.yandex.praktikum.pages.RentInfoPage;

@RunWith(Parameterized.class)
public class OrderTest {
    private final String name;
    private final String surname;
    private final String address;
    private final String phone;
    private final String comment;
    private WebDriver driver;

    public OrderTest(String name, String surname, String address, String phone, String comment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
        this.comment = comment;
    }

    @Parameterized.Parameters()
    public static Object[][] data() {
        return new Object[][]{
                {"Виталий", "Иванов", "Москва", "88005553535", "позвонить за 5 минут"},
                {"Евгений", "Петров", "Казань", "89151231212", "код домофона 123"}
        };
    }

    @Before
    public void configBrowser() {
        driver = new ChromeDriver();
        driver.get(Setup.BASE_URL);
    }

    @Test
    public void orderScooterHeaderFlowTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickHeaderOrderButton();
        AboutCustomersPage aboutCustomersPage = new AboutCustomersPage(driver);
        aboutCustomersPage.setNameField(name);
        aboutCustomersPage.setSurnameField(surname);
        aboutCustomersPage.setAddressField(address);
        aboutCustomersPage.choiceStation();
        aboutCustomersPage.setPhoneField(phone);
        aboutCustomersPage.clickNextButton();

        RentInfoPage rentInfoPage = new RentInfoPage(driver);
        rentInfoPage.choiceStartDate();
        rentInfoPage.choicePeriodRent();
        rentInfoPage.clickCheckboxColor();
        rentInfoPage.setCommentField(comment);
        rentInfoPage.clickOrderButton();

        OrderModal orderModal = new OrderModal(driver);
        orderModal.checkOpenPopup();
        orderModal.clickConfirmButton();
        orderModal.checkOpenPopupOrderCreate();
    }

    @After
    public void orderScooterHeaderFlowTestClose() {
        driver.quit();
    }

    @Test
    public void orderScooterMainFlowTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickMainOrderButton();
        AboutCustomersPage aboutCustomersPage = new AboutCustomersPage(driver);
        aboutCustomersPage.setNameField(name);
        aboutCustomersPage.setSurnameField(surname);
        aboutCustomersPage.setAddressField(address);
        aboutCustomersPage.choiceStation();
        aboutCustomersPage.setPhoneField(phone);
        aboutCustomersPage.clickNextButton();

        RentInfoPage rentInfoPage = new RentInfoPage(driver);
        rentInfoPage.choiceStartDate();
        rentInfoPage.choicePeriodRent();
        rentInfoPage.clickCheckboxColor();
        rentInfoPage.setCommentField(comment);
        rentInfoPage.clickOrderButton();

        OrderModal orderModal = new OrderModal(driver);
        orderModal.checkOpenPopup();
        orderModal.clickConfirmButton();
        orderModal.checkOpenPopupOrderCreate();
    }

    @After
    public void orderScooterMainFlowTestClose() {
        driver.quit();
    }
}
