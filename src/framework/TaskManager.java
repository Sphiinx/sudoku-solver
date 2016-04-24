package framework;

import java.util.ArrayList;

/**
 * Created by Sphiinx on 4/20/2016.
 */
public class TaskManager {

    private ArrayList<AbstractTask> taskList = new ArrayList<>();
    private String status;

    public void addTask(final AbstractTask... tasks) {
        for (AbstractTask abstractTask : tasks) {
            if (!taskList.contains(abstractTask)) {
                taskList.add(abstractTask);
            }
        }
    }

    public void removeTask(AbstractTask abstractTask) {
        if (taskList.contains(abstractTask)) {
            taskList.remove(abstractTask);
        }
    }

    public void clearTasks() {
        taskList.clear();
    }

    public int getTaskCount() {
        return taskList.size();
    }

    public AbstractTask getValidTask() {
        for (AbstractTask abstractTask : taskList) {
            if (abstractTask.validate()) {
                return abstractTask;
            }
        }
        return null;
    }
}