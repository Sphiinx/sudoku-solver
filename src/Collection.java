import framework.Task;
import tasks.EndProgram;
import tasks.GetWebMatrix;
import tasks.WriteWebMatrix;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Sphiinx on 4/13/2016.
 */
public class Collection {

    public static ArrayList<Task> tasks = new ArrayList<>();

    public static void addCollection() {
        Collections.addAll(tasks, new GetWebMatrix(), new WriteWebMatrix(), new EndProgram());
    }

}

