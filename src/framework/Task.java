package framework;

import java.awt.*;

/**
 * Created by Sphiinx on 4/20/2016.
 */
public interface Task {

    boolean validate();

    void execute() throws InterruptedException, AWTException;

    String toString();

}

