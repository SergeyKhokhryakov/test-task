package ru.ostrovcy.qademo.pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
  protected StartPage startPage = new StartPage();
  protected MainPage mainPage = MainPage.getInstance();
  protected TestData data = new TestData();

  @BeforeAll
  static void init() {
    Configuration.browserSize = "1920x1080";
    Configuration.baseUrl = "https://demoqa.com";
    Configuration.pageLoadTimeout = 60000; // очень долго грузиться любой браузер!!!!
    SelenideLogger.addListener(" Allure", new AllureSelenide());
  }
}
