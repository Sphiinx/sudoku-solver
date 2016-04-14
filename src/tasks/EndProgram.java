package tasks;

import SudokuHandling.HandleWeb;
import data.Variables;
import framework.Task;

/**
 * Created by Sphiinx on 4/13/2016.
 */
public class EndProgram extends Task {

    @Override
    public void execute() {
        HandleWeb.driver.quit();
        System.exit(0);
    }

    @Override
    public String toString() {
        return "Ending program...";
    }

    @Override
    public boolean validate() {
        return Variables.solved >= Variables.numberToSolve;
    }
}

