import org.testng.annotations.Test;
import utilities.CommonOps;

import static workflows.ElectronWorkflows.*;


public class ElectronTests extends CommonOps {
    @Test
    public void addTodoTask() {
        addTask("new task");
    }

    @Test
    public void deleteTaskByLocation() throws InterruptedException {
        Thread.sleep(2000);
        deleteTask(1);
        Thread.sleep(2000);
    }
}