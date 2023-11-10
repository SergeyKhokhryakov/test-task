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
  public ButtonsPage click() {
    $x("//button[text()='Click Me']").click();
    return this;
  }

  @Step("10.\tНажать на кнопку «Right Click me»")
  public ButtonsPage contextClick(){
    $("button#rightClickBtn").contextClick();
    return this;
  }

  @Step("12.\tНажать на кнопку «Double Click me»")
  public ButtonsPage doubleClick(){
    $("button#doubleClickBtn").doubleClick();
    return this;
  }

  @Step("9.\tПроверить, что появился текст «You have done a dynamic click»")
  public ButtonsPage verifyClickResult(String value) {
    verifyResult("#dynamicClickMessage", value);
    return this;
  }

  @Step("11.\tПроверить, что появился текст «You have done a right click»")
  public ButtonsPage verifyContextClickResult(String value) {
    verifyResult("#rightClickMessage", value);
    return this;
  }

  @Step("13.\tПроверить, что появился текст «You have done a double click»")
  public void verifyDoubleClickResult(String value) {
    verifyResult("#doubleClickMessage", value);
  }

  public void verifyResult(String key, String value) {
    $(key).should(appear).shouldHave(text(value));
  }

}
