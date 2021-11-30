import org.testng.annotations.Test;
import utilities.CommonOps;

import static workflows.ElectronWorkflows.*;


public class ElectronTests extends CommonOps {
    @Test
    public void addTodoTask() {
        addTask("new task");
    }

    @Test
    public void deleteTaskByLocation() {
        deleteTask(1);
    }
}