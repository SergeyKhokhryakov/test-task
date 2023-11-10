package ru.ostrovcy.qademo.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ButtonsPage {
  SelenideElement rubrics = $(".element-list.collapse.show");

  @Step("7.\tНажать на «Buttons»")
  public ButtonsPage open() {
    open("Buttons");
    return this;
  }
  public void open(String locator){
    rubrics.$(byText(locator)).click();
  }

  @Step("8.\tНажать на кнопку «Click me»")
  public void click() {
    $x("//button[text()='Click Me']").click();
  }

  @Step("10.\tНажать на кнопку «Right Click me»")
  public void contextClick(){
    $("button#rightClickBtn").contextClick();
  }

  @Step("12.\tНажать на кнопку «Double Click me»")
  public void doubleClick(){
    $("button#doubleClickBtn").doubleClick();
  }

  @Step("9.\tПроверить, что появился текст «You have done a dynamic click»")
  public void verifyClickResult(String value) {
    verifyResult("#dynamicClickMessage", value);
  }

  @Step("11.\tПроверить, что появился текст «You have done a right click»")
  public void verifyContextClickResult(String value) {
    verifyResult("#rightClickMessage", value);
  }

  @Step("13.\tПроверить, что появился текст «You have done a double click»")
  public void verifyDoubleClickResult(String value) {
    verifyResult("#doubleClickMessage", value);
  }

  public void verifyResult(String key, String value) {
    $(key).should(appear).shouldHave(text(value));
  }

}
