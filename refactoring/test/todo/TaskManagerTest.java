package todo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskManagerTest {

    @Test
    void emptyTaskList() {
        TaskManager taskManager = new TaskManager();
        assertEquals("", taskManager.printTaskList());
    }

    @Test
    void addTask(){
        TaskManager taskManager = new TaskManager();
        taskManager.addTask("Gamen");
        assertEquals("1. Gamen\n", taskManager.printTaskList());
    }

    @Test
    void EmptyTaskIsNotAdded(){
        TaskManager taskManager = new TaskManager();
        taskManager.addTask("");
        assertEquals("", taskManager.printTaskList());
    }

    @Test
    void ClearTasks(){
        TaskManager taskManager = new TaskManager();
        taskManager.addTask("Gamen");
        taskManager.addTask("Einkaufen");
        taskManager.clear();
        assertEquals("", taskManager.printTaskList());
    }

    @Test
    void  RightNumberOrder(){
        TaskManager taskManager = new TaskManager();
        taskManager.addTask("Gamen");
        taskManager.addTask("Einkaufen");
        taskManager.addTask("gym");
        taskManager.addTask("Steuern");
        assertEquals("1. Gamen\n" + "2. Einkaufen\n" + "3. gym\n" + "4. Steuern\n", taskManager.printTaskList());
    }

}