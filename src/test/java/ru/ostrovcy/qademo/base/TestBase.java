package ru.ostrovcy.qademo.base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import ru.ostrovcy.qademo.navigation.MainPage;
import ru.ostrovcy.qademo.navigation.StartPage;

public class TestBase {
  protected StartPage startPage = new StartPage();
  protected MainPage mainPage = MainPage.getInstance();
  protected TestData data = new TestData();
  private final static String BASE_URL = "https://demoqa.com";

  @BeforeAll
  static void init() {
    Configuration.browserSize = "1920x1080";
    Configuration.baseUrl = BASE_URL;
    // для параметра Configuration.pageLoadTimeout не хватает значения по умолчанию (30 сек.),
    // https://demoqa.com имеет проблемы в загрузке контента страницы (Stalled, CAUTION: request isn't finished yet!) продолжительностью более 26 сек.
    Configuration.pageLoadTimeout = 60000;
    SelenideLogger.addListener(" Allure", new AllureSelenide());
  }
}
