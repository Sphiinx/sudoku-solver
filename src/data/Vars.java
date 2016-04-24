package data;

/**
 * Created by Sphiinx on 4/13/2016.
 */
public class Vars {

    public static Vars vars;

    public static Vars get() {
        return vars == null ? vars = new Vars() : vars;
    }

    public static void reset() {
        vars = null;
    }

    public int[][] matrix = new int[9][9];

    public int numberToSolve;
    public int solved;

    public boolean guiComplete;
    public boolean stopProgram;

}

