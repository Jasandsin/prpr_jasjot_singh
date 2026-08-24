package todo;

import java.util.List;

public class TaskManager {
    public TaskManager() {
    }

    void addTask(TodoApp todoApp) {
        if (!todoApp.currentTask.isEmpty()) {
            todoApp.tasks.add(todoApp.currentTask);
        }
    }

    String printTaskList(List<String> tasks) {
        StringBuilder taskList = new StringBuilder();
        for (int i = 0; i < tasks.size(); i++) {
            taskList.append(i + 1).append(". ").append(tasks.get(i)).append("\n");
        }
        return taskList.toString();
    }
}
