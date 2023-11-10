package ru.ostrovcy.qademo.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class TextBoxPage {
  private String locatorElements = "//h5[text()='Elements']";
  SelenideElement rubrics = $(".element-list.collapse.show");
  SelenideElement response = $("#output");

  @Step("2.	Нажать на «Elements»")
  public TextBoxPage goToElements() {
    goToCategory(locatorElements);
    return this;
  }

  public void goToCategory(String locator) {
    $x(locator).click();
  }

  @Step("3.\tНажать на «Text box»")
  public TextBoxPage open() {
      goToElements().open("Text Box");
    return this;
  }
  public void open(String locator){
    rubrics.$(byText(locator)).click();
  }

  @Step("4.\tЗаполнить поля: Full Name, Email, Current Address, Permanent Address")
  public TextBoxPage inputFields(String name, String email, String currentAddress, String permanentAddress){
    setUserName(name);
    setUserEmail(email);
    setCurrentAddress(currentAddress);
    setPermanentAddress(permanentAddress);
    return this;
  }

  public TextBoxPage setUserName(String value) {
    $("input#userName").setValue(value);
    return this;
  }

  public TextBoxPage setUserEmail(String value) {
    $("input#userEmail").setValue(value);
    return this;
  }

  public TextBoxPage setCurrentAddress(String value) {
    $("textarea#currentAddress").setValue(value);
    return this;
  }

  public TextBoxPage setPermanentAddress(String value) {
    $("textarea#permanentAddress").setValue(value);
    return this;
  }

  @Step("5.\tНажать на кнопку «Submit»")
  public TextBoxPage sendForm(){
    $("#submit").click();
    return this;
  }

  @Step("6.\tПроверить, что данные в блоке сохранены корректно")
  public void verifyBlockResult(String name, String email, String currentAddress, String permanentAddress){
    verifyModalAppears();
    verifyResult("name", name);
    verifyResult("email", email);
    verifyResult("currentAddress", currentAddress);
    verifyResult("permanentAddress", permanentAddress);
  }

  public TextBoxPage verifyResult(String key, String value) {
    response.$("#" + key).shouldHave(text(value));
    return this;
  }

  public TextBoxPage verifyModalAppears() {
    response.should(appear);
    return this;
  }



}
