package ru.ostrovcy.qademo;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.ostrovcy.qademo.base.TestBase;

public class TaskTest extends TestBase {

  String promptText = "Test name";


  @Test
  @Owner("Хохряков Сергей")
  @Description("Данный тест разработан в соотвествии с тестовым заданием")
  @Feature("Фичи: \"Elements\", \"Alerts, Frame & Windows\"")
  @Story("Элементы на странице demoqa.com")
  @Severity(SeverityLevel.CRITICAL)
  @DisplayName("Позитивный тест: Шаги с аннотацией @Step")

  public void test() {
    startPage.open()
            .goToElementsCategory()
            .openTextBoxPage()
            .inputFields(data.getUserName(), data.getUserEmail(), data.getCurrentAddress(), data.getPermanentAddress())
            .sendForm()
            .verifyBlockResult(data.getUserName(), data.getUserEmail(), data.getCurrentAddress(), data.getPermanentAddress());

    mainPage.openButtonsPage()
            .click()
            .verifyClickResult("You have done a dynamic click")
            .contextClick()
            .verifyContextClickResult("You have done a right click")
            .doubleClick()
            .verifyDoubleClickResult("You have done a double click");

    mainPage.openAlertsFrameWindowsCategory()
            .openBrowserWindowsPage()
            .openNewTab()
            .closeNewTab();

    mainPage.onBrowserWindowsPage()
            .openNewWindow()
            .closeNewWindow();

    mainPage.openAlertPage()
            .showAlert()
            .closeModal();

    mainPage.onAlertsPage()
            .showAlertTimer()
            .closeModalTimer();

    mainPage.onAlertsPage()
            .showConfirmBox()
            .confirmModal()
            .verifyConfirmResult("You selected \nOk");

    mainPage.onAlertsPage()
            .showPromptBox()
            .input(promptText)
            .verifyPromptResult(promptText);
  }

}
