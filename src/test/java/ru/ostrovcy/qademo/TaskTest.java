package ru.ostrovcy.qademo;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

/**
 * Using Faker library
 * Using Datafaker library
 */

public class TaskTest {
  String userName = "Петров Иван Сергеевич";
  String userEmail = "test@gmail.com";
  String currentAddress = "134009 Москва, ул. Ватутина, д.1";
  String permanentAddress = "100203 Москва, ул. Новые Черемушки, д.125, кв. 99";
  String promptText = "Test name";

  @BeforeAll
  public static void init() {
    Configuration.browserSize = "1920x1080";
    Configuration.baseUrl = "https://demoqa.com";
    Configuration.pageLoadTimeout = 60000; // очень долго грузиться любой браузер!!!!
    SelenideLogger.addListener(" Allure", new AllureSelenide());
  }

  @Test
  public void test() {
    open("/");
//      assertThat(1).isEqualTo(1);


    $x("//h5[text()='Elements']").click();
    $(".element-list.collapse.show").$(byText("Text Box")).click();
    $("input#userName").setValue(userName);
    $("input#userEmail").setValue(userEmail);
    $("textarea#currentAddress").setValue(currentAddress);
    $("textarea#permanentAddress").setValue(permanentAddress);
    $x("//button[text()='Submit']").click();
    SelenideElement response = $("#output");
    response.should(appear);
    response.$("#name").shouldHave(text(userName));
    response.$("#email").shouldHave(text(userEmail));
    response.$("#currentAddress").shouldHave(text(currentAddress));
    response.$("#permanentAddress").shouldHave(text(permanentAddress));


    $(".element-list.collapse.show").$(byText("Buttons")).click();
    $x("//button[text()='Click Me']").click();
    $("#dynamicClickMessage").should(appear).shouldHave(text("You have done a dynamic click"));

    $("button#rightClickBtn").contextClick();
    $("#rightClickMessage").should(appear).shouldHave(text("You have done a right click"));

    $("button#doubleClickBtn").doubleClick();
    $("#doubleClickMessage").should(appear).shouldHave(text("You have done a double click"));
    $x("//div[text()='Elements']").click();


    $x("//div[text()='Alerts, Frame & Windows']").click();
    $(".element-list.collapse.show").$(byText("Browser Windows")).click();
    $("#tabButton").click();
//    Set<String> windowHandles = getWebDriver().getWindowHandles();
//    String windowHandle = getWebDriver().getWindowHandle();
    Selenide.switchTo().window(1);
    Selenide.closeWindow();
    Selenide.switchTo().window(0);

    $("#windowButton").click();
    Selenide.switchTo().window(1);
    Selenide.closeWindow();
    Selenide.switchTo().window(0);

    $(".element-list.collapse.show").$(byText("Alerts")).click();
    $("button#alertButton").click();
    Selenide.switchTo().alert().accept();

    $("button#timerAlertButton").click();
    Configuration.timeout = 6000; // alert will appear after 5 seconds
    Selenide.switchTo().alert().accept();
    Configuration.timeout = 4000; // set default value

    $("button#confirmButton").click();
    Selenide.switchTo().alert().accept();
    String green = "rgba(40, 167, 69, 1)"; // для chrome
    $("#confirmResult")
            .should(appear)
            .shouldHave(text("You selected \nOk"))
            .shouldHave(cssValue("color", green));

    $("button#promtButton").click();
    Alert alert = switchTo().alert();
    alert.sendKeys(promptText);
    alert.accept();
    $("#promptResult")
            .should(appear)
            .shouldHave(text("You entered \n" + promptText))
            .shouldHave(cssValue("color", green));

    System.out.println();


  }
}
