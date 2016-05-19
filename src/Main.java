/**
 * Created by Sphiinx on 4/12/2016.
 */

import api.HandleWeb;
import data.Vars;
import framework.Task;
import framework.TaskManager;
import gui.GUI;
import tasks.EndProgram;
import tasks.GetWebMatrix;
import tasks.WriteWebMatrix;

import java.awt.*;

public class Main {

    private static TaskManager taskManager = new TaskManager();
    private static GUI gui = new GUI();

    public static void main(String[] args) throws InterruptedException, AWTException {
        addCollection();
        initializeGUI();
        HandleWeb.openURL("http://www.sudoku.com");
        loop();
    }

    private static void addCollection() {
        taskManager.addTask(new GetWebMatrix(), new WriteWebMatrix(), new EndProgram());
    }

    private static void loop() throws InterruptedException, AWTException {
        while (!Vars.get().stopProgram) {
            Task task = taskManager.getValidTask();
            if (task != null) {
                task.execute();
                Thread.sleep(100);
            }
        }
    }

    private static void initializeGUI() throws InterruptedException {
        EventQueue.invokeLater(() -> {
            try {
                Thread.sleep(50);
                gui.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        do
            Thread.sleep(10);
        while (!Vars.get().guiComplete);
    }

}

