/**
 * Created by Sphiinx on 4/12/2016.
 */

import SudokuHandling.HandleWeb;
import data.Variables;
import framework.Task;
import gui.GUI;

import java.awt.*;

public class Main {

    private static GUI gui = new GUI();

    public static void main(String[] args) throws InterruptedException {
        Collection.addCollection();
        initializeGUI();
        HandleWeb.openWebsite("http://www.sudoku.com");
        loop();
    }

    private static void loop() {
        while (!Variables.stopProgram) {
            Collection.tasks.stream().filter(Task::validate).forEach(task -> {
                Variables.status = task.toString();
                task.execute();
                try {
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
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
        while (!Variables.guiComplete);
    }

}

