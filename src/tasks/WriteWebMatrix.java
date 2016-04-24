package tasks;


import api.HandleWeb;
import framework.AbstractTask;
import handling.HandleSudoku;
import handling.Web;
import data.Vars;

/**
 * Created by Sphiinx on 4/13/2016.
 */
public class WriteWebMatrix extends AbstractTask {


    @Override
    public void execute() {
        if (!Web.isGameOpen("//*[@id=\"game\"]"))
            return;


        HandleSudoku.solve(0, 0, Vars.get().matrix);
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                if (HandleWeb.getElementXPath(HandleWeb.driver, "//*[@id=\"table\"]/tbody/tr[" + i + "]/td[" + j + "]/div").getText().contains(" ")) {
                    HandleWeb.getElementXPath(HandleWeb.driver, "//*[@id=\"table\"]/tbody/tr[" + i + "]/td[" + j + "]/div").click();
                    HandleWeb.getElementXPath(HandleWeb.driver, "//*[@id=\"table\"]/tbody/tr[" + i + "]/td[" + j + "]/div").sendKeys(Integer.toString(Vars.get().matrix[i - 1][j - 1]));
                }
            }
        }
        Vars.get().solved++;
        HandleSudoku.resetMatrix();
    }

    @Override
    public boolean validate() {
        int cells = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (Vars.get().matrix[i][j] == 0) {
                    cells++;
                }
            }
        }
        return cells != 81;
    }
}

