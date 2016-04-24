package tasks;

import api.HandleWeb;
import data.Vars;
import framework.AbstractTask;

/**
 * Created by Sphiinx on 4/13/2016.
 */
public class EndProgram extends AbstractTask {

    @Override
    public void execute() {
        HandleWeb.driver.quit();
        System.exit(0);
    }

    @Override
    public boolean validate() {
        return Vars.get().solved >= Vars.get().numberToSolve;
    }
}

