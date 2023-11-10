package ru.ostrovcy.qademo.components;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static com.codeborne.selenide.Selenide.$;


public class Navigation {
  private String locatorElements = "//h5[text()='Elements']";
  private String locatorAlertsFrameWindows = "//div[text()='Alerts, Frame & Windows']";
  SelenideElement rubrics = $(".element-list.collapse.show");

  public String toElements() {
    return locatorElements;
  }

  public String toAlertsFrameWindows() {
    return locatorAlertsFrameWindows;
  }

  public SelenideElement toRubrics() {
    return rubrics;
  }
}
