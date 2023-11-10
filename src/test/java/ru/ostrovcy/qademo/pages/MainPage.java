package ru.ostrovcy.qademo.pages;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import ru.ostrovcy.qademo.components.Category;
import ru.ostrovcy.qademo.components.Navigation;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
//  private String locatorElements = "//h5[text()='Elements']";
//  private String locatorAlertsFrameWindows = "//div[text()='Alerts, Frame & Windows']";
  private Category category = new Category();
  private Navigation menu = new Navigation();
  private TextBoxPage textBoxPage = new TextBoxPage();

  @Step("1.\tПерейти на https://demoqa.com/")
  public MainPage open() {
    Selenide.open("/");
    return this;
  }

  public MainPage goToElements() {
    goToCategory(menu.toElements());
    return this;
  }

  public MainPage goToAlertsFrameWindows() {
    goToCategory(menu.toAlertsFrameWindows());
    return this;
  }

  public void goToCategory(String locator) {
    $x(locator).click();
  }


  public MainPage openButtonsPage() {
    category.openButtons();
    return this;
  }
  public MainPage openBrowserWindowsPage() {
    category.openBrowserWindows();
    return this;
  }
  public MainPage openAlertsPage() {
    category.openAlerts();
    return this;
  }


  public MainPage goToRubric(String locator) {
    return this;

  }
  public void open(String locator){
    menu.toRubrics().$(byText(locator)).click();
  }


}
