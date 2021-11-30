package workflows;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.CommonOps;


public class ElectronWorkflows extends CommonOps {

    @Step
    public static void addTask(String task) {
        action = new Actions(driver);
        todoPage.getTxt_enterTask().sendKeys(task);
        action.sendKeys(Keys.RETURN).build().perform();

    }

    @Step
    public static void deleteTask(int index) {
        action.moveToElement(todoPage.getTaskByLocation(index)).click().build().perform();
        todoPage.getBtn_deleteTaskByLocation(index).click();
    }
}