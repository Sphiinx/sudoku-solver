package tasks;

import api.HandleWeb;
import data.Vars;
import framework.Task;

/**
 * Created by Sphiinx on 4/13/2016.
 */
public class EndProgram implements Task {

    public void execute() {
        HandleWeb.driver.quit();
        System.exit(0);
    }

    public boolean validate() {
        return Vars.get().solved >= Vars.get().numberToSolve;
    }
}

