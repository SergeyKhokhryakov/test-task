package ru.ostrovcy.qademo.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class BrowserWindowsPage {

  SelenideElement rubrics = $(".element-list.collapse.show");

  public void open(String locator){
    rubrics.$(byText(locator)).click();
  }

  @Step("16.\tНажать на кнопку «New Tab»")
  public BrowserWindowsPage openNewTab(){
    $("#tabButton").click();
    return this;
  }

  @Step("17.\tЗакрыть новую вкладку")
  public void closeNewTab(){
    close();
  }

  @Step("18.\tНажать на кнопку «New window»")
  public BrowserWindowsPage openNewWindow(){
    $("#windowButton").click();
    return this;
  }

  @Step("19.\t Закрыть новое окно")
  public void closeNewWindow(){
    close();
  }

  private void close(){
    Selenide.switchTo().window(1);
    Selenide.closeWindow();
    Selenide.switchTo().window(0);
  }

}
