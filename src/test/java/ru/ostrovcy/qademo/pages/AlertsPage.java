package ru.ostrovcy.qademo.pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.Alert;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class AlertsPage {
  SelenideElement rubrics = $(".element-list.collapse.show");
  String green = "rgba(40, 167, 69, 1)"; // для chrome

  @Step("20.\tНажать на «Alerts»")
  public AlertsPage open() {
    open("Alerts");
    return this;
  }

  public void open(String locator) {
    rubrics.$(byText(locator)).click();
  }

  @Step("21.\tНажать на кнопку «Click me»  рядом с Click Button to see alert")
  public AlertsPage showAlert(){
    $("button#alertButton").click();
    return this;
  }

  @Step("22.\tЗакрыть уведомление")
  public void closeModal(){
    Selenide.switchTo().alert().accept();
  }

  @Step("23.\tНажать на кнопку «Click me»  рядом с On button click, alert will appear after 5 seconds")
  public AlertsPage showAlertTimer(){
    $("button#timerAlertButton").click();
    return this;
  }

  @Step("24.\tЗакрыть уведомление")
  public void closeModalTimer(){
    Configuration.timeout = 6000; // alert will appear after 5 seconds
    Selenide.switchTo().alert().accept();
    Configuration.timeout = 4000; // set default value
  }

  @Step("25.\tНажать на кнопку «Click me»  рядом с On button click, confirm box will appear")
  public AlertsPage showConfirmBox(){
    $("button#confirmButton").click();
    return this;
  }

  @Step("26.\tНажать на кнопку «Да» в уведомление")
  public void confirmModal(){
    Selenide.switchTo().alert().accept();
  }

  @Step("27.\tПроверить, что появился текст You selected Ok")
  public void verifyConfirmResult(String value){
    verifyResult("#confirmResult", value);
  }

  @Step("28.\tНажать на кнопку «Click me»  рядом с On button click, prompt box will appear")
  public AlertsPage showPromptBox(){
    $("button#promtButton").click();
    return this;
  }

  @Step("29.\tЗаполнить поле в уведомление данными: Test name")
  public void input(String value){
    Alert alert = switchTo().alert();
    alert.sendKeys(value);
    alert.accept();
  }

  @Step("30.\tПроверить, что появился текст You entered Test name")
  public void verifyPromptResult(String value){
    verifyResult("#promptResult", "You entered \n" + value);
  }

  public void verifyResult(String key, String value){
    $(key)
            .should(appear)
            .shouldHave(text(value))
            .shouldHave(cssValue("color", green));
  }
}