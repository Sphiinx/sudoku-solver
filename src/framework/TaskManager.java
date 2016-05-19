package framework;

import java.util.ArrayList;

/**
 * Created by Sphiinx on 4/20/2016.
 */
public class TaskManager {

    private ArrayList<Task> taskList = new ArrayList<>();
    private String status;

    public void addTask(final Task... tasks) {
        for (Task task : tasks) {
            if (!taskList.contains(task)) {
                taskList.add(task);
            }
        }
    }

    public void removeTask(Task task) {
        if (taskList.contains(task)) {
            taskList.remove(task);
        }
    }

    public void clearTasks() {
        taskList.clear();
    }

    public int getTaskCount() {
        return taskList.size();
    }

    public Task getValidTask() {
        for (Task task : taskList) {
            if (task.validate()) {
                return task;
            }
        }
        return null;
    }
}