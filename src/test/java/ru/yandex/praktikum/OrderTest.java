package ru.yandex.praktikum;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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

    @Test
    public void HeaderButtonFlowTest() {

        driver = new ChromeDriver();
        driver.get(Setup.BASE_URL);

        MainPage mainPage = new MainPage(driver);
        if (name.equals("Виталий")) {
            mainPage.clickHeaderOrderButton();
        } else {
            mainPage.clickMainOrderButton();
        }
        AboutCustomersPage aboutCustomersPage = new AboutCustomersPage(driver);
        aboutCustomersPage.setNameField(name);
        aboutCustomersPage.setSurnameField(surname);
        aboutCustomersPage.setAdressField(address);
        aboutCustomersPage.choiseStation();
        aboutCustomersPage.setPhoneField(phone);
        aboutCustomersPage.clickNextButton();

        RentInfoPage rentInfoPage = new RentInfoPage(driver);
        rentInfoPage.choiseStartDate();
        rentInfoPage.choisePeriodRent();
        rentInfoPage.clickCheckboxColor();
        rentInfoPage.setCommentField(comment);
        rentInfoPage.clickOrderButton();

        OrderModal orderModal = new OrderModal(driver);
        orderModal.checkOpenPopup();
        orderModal.clickConfirmButton();
        orderModal.checkOpenPopapOrderCreate();
    }

    @After
    public void HeaderButtonFlowTestsClose() {
        driver.quit();
    }
}
