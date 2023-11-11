package ru.ostrovcy.qademo.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

/**
 * Главная страница приложения (для отработки практики)
 * Имеет левую панель навигации по категориям
 * В каждой категории сгруппированы родственные веб-элементы
 *
 * Методы:
 * - раскрыть категорию (expand)/свернуть категорию (collapse)
 */


public final class MainPage {
  private static volatile MainPage instance;
  private String locatorElements = "//div[text()='Elements']";
  private String locatorAlertsFrameWindows = "//div[text()='Alerts, Frame & Windows']";
  private SelenideElement rubrics = $(".element-list.collapse.show");
  private TextBoxPage textBoxPage = new TextBoxPage();
  private ButtonsPage buttonsPage = new ButtonsPage();
  private AlertsPage alertsPage = new AlertsPage();

  private BrowserWindowsPage browserWindowsPage = new BrowserWindowsPage();

  private MainPage() {
  }

  public static MainPage getInstance() {
    MainPage result = instance;
    if (result != null) {
      return result;
    }
    synchronized (MainPage.class) {
      if (instance == null) {
        instance = new MainPage();
      }
      return instance;
    }
  }

  public MainPage openElements() {
    openCategory(locatorElements);
    return getInstance();
  }

  @Step("14.\tНажать на «Alerts, Frame & Windows»")
  public MainPage openAlertsFrameWindows() {
    openCategory(locatorAlertsFrameWindows);
    return getInstance();
  }

  @Step("3.\tНажать на «Text box»")
  public TextBoxPage openTextBoxPage() {
    open("Text Box");
    return textBoxPage;
  }

  @Step("7.\tНажать на «Buttons»")
  public ButtonsPage openButtonsPage() {
    open("Buttons");
    return buttonsPage;
  }

  @Step("15.\tНажать на «Browser Windows»")
  public BrowserWindowsPage openBrowserWindowsPage() {
    open("Browser Windows");
    return browserWindowsPage;
  }

  @Step("20.\tНажать на «Alerts»")
  public AlertsPage openAlertPage() {
    open("Alerts");
    return alertsPage;
  }

  private void openCategory(String locator) {
    $x(locator).click();
  }

  private void open(String locator) {
    rubrics.$(byText(locator)).click();
  }

  public TextBoxPage onTextBoxPage() {
    return textBoxPage;
  }

  public ButtonsPage onButtonsPage() {
    return buttonsPage;
  }

  public BrowserWindowsPage onBrowserWindowsPage() {
    return browserWindowsPage;
  }

  public AlertsPage onAlertsPage() {
    return alertsPage;
  }

}

