package ru.yandex.praktikum;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.praktikum.pages.ImportantQuestion;

public class ImportantQuestionTest {
    private WebDriver driver;

    @Test
    public void CheckImportantQuest() {
        driver = new ChromeDriver();
        driver.get(Setup.BASE_URL);
        ImportantQuestion importantQuestion = new ImportantQuestion(driver);
        importantQuestion.checkAllQuestionText();

    }

    @After
    public void CheckImportantQuestClose() {
        driver.quit();
    }
}
