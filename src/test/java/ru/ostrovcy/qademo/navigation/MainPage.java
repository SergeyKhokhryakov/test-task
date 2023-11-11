package ru.ostrovcy.qademo.navigation;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import ru.ostrovcy.qademo.pages.AlertsPage;
import ru.ostrovcy.qademo.pages.BrowserWindowsPage;
import ru.ostrovcy.qademo.pages.ButtonsPage;
import ru.ostrovcy.qademo.pages.TextBoxPage;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

/**
 * Главная страница приложения (для отработки практики)
 * Имеет левую панель навигации по категориям
 * В каждой категории сгруппированы родственные веб-элементы
 * <p>
 * Методы:
 * - openElementsCategory()
 * - openAlertsFrameWindowsCategory()
 * - openTextBoxPage()
 * - openButtonsPage()
 * - openBrowserWindowsPage()
 * - openAlertPage()
 * - onTextBoxPage()
 * - onButtonsPage()
 * - onBrowserWindowsPage()
 * - onAlertPage()
 */


public final class MainPage {
  private static volatile MainPage instance;
  private String locatorElements = "//div[text()='Elements']";
  private String locatorAlertsFrameWindows = "//div[text()='Alerts, Frame & Windows']";
//  private String locatorElements = "Elements";
//  private String locatorAlertsFrameWindows = "Alerts, Frame & Windows";
  private SelenideElement rubrics = $(".element-list.collapse.show");
  private TextBoxPage textBoxPage = new TextBoxPage();
  private ButtonsPage buttonsPage = new ButtonsPage();
  private BrowserWindowsPage browserWindowsPage = new BrowserWindowsPage();
  private AlertsPage alertsPage = new AlertsPage();

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

  public MainPage openElementsCategory() {
    scrollTo(locatorElements);
    openCategory(locatorElements);
    return getInstance();
  }

  @Step("14. Нажать на «Alerts, Frame & Windows»")
  public MainPage openAlertsFrameWindowsCategory() {
    scrollTo(locatorAlertsFrameWindows);
    openCategory(locatorAlertsFrameWindows);
    return getInstance();
  }

  @Step("3. Нажать на «Text box»")
  public TextBoxPage openTextBoxPage() {
    open("Text Box");
    hideBanners();
    return textBoxPage;
  }

  @Step("7. Нажать на «Buttons»")
  public ButtonsPage openButtonsPage() {
    open("Buttons");
    hideBanners();
    return buttonsPage;
  }

  @Step("15. Нажать на «Browser Windows»")
  public BrowserWindowsPage openBrowserWindowsPage() {
    open("Browser Windows");
    hideBanners();
    return browserWindowsPage;
  }

  @Step("20. Нажать на «Alerts»")
  public AlertsPage openAlertPage() {
    open("Alerts");
    hideBanners();
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

  private void scrollTo(String locator) {
//    $(byText(locator)).scrollTo();
    $(By.xpath(locator)).scrollTo();
  }

  //hide overlay banners
  private void hideBanners(){
    executeJavaScript("$('footer').remove()");
    executeJavaScript("$('#fixedban').remove()");
  }

}

