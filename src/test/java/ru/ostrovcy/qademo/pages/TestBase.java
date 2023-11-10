package ru.ostrovcy.qademo.pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
  protected MainPage startPage = new MainPage();
  protected TextBoxPage textBoxPage = new TextBoxPage();
  protected ButtonsPage buttonsPage = new ButtonsPage();
  protected BrowserWindowsPage browserWindowsPage = new BrowserWindowsPage();
  protected AlertsPage alertsPage = new AlertsPage();
  protected MainPage mainPage = startPage;
  protected TestData data = new TestData();

  @BeforeAll
  static void init() {
    Configuration.browserSize = "1920x1080";
    Configuration.baseUrl = "https://demoqa.com";
    Configuration.pageLoadTimeout = 60000; // очень долго грузиться любой браузер!!!!
    SelenideLogger.addListener(" Allure", new AllureSelenide());
  }
}
