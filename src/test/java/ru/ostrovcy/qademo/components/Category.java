package ru.ostrovcy.qademo.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class Category {
  String nameCategory;
  SelenideElement rubrics = $(".element-list.collapse.show");

  public void openTextBox(){
    open("Text Box");
  }
  public void openButtons(){
    open("Buttons");
  }
  public void openBrowserWindows(){
    open("Browser Windows");
  }
  public void openAlerts(){
    open("Alerts");
  }

  public void open(String locator){
    rubrics.$(byText(locator)).click();
  }
  public void close(){

  }

}
