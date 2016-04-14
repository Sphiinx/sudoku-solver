package tasks;

import SudokuHandling.HandleSudoku;
import SudokuHandling.HandleWeb;
import data.Variables;
import framework.Task;

/**
 * Created by Sphiinx on 4/13/2016.
 */
public class WriteWebMatrix extends Task {


    @Override
    public void execute() {
        if (!HandleWeb.isGameOpen("//*[@id=\"game\"]"))
            return;

        HandleSudoku.solve(0, 0, Variables.matrix);
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                if (HandleWeb.getElementXPath(HandleWeb.driver, "//*[@id=\"table\"]/tbody/tr[" + i + "]/td[" + j + "]/div").getText().contains(" ")) {
                    HandleWeb.getElementXPath(HandleWeb.driver, "//*[@id=\"table\"]/tbody/tr[" + i + "]/td[" + j + "]/div").click();
                    HandleWeb.getElementXPath(HandleWeb.driver, "//*[@id=\"table\"]/tbody/tr[" + i + "]/td[" + j + "]/div").sendKeys(Integer.toString(Variables.matrix[i - 1][j - 1]));
                }
            }
        }
        Variables.solved++;
        HandleSudoku.resetMatrix();
    }

    @Override
    public String toString() {
        return "Writing Matrix...";
    }

    @Override
    public boolean validate() {
        int cells = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (Variables.matrix[i][j] == 0) {
                    cells++;
                }
            }
        }
        return cells != 81;
    }
}

