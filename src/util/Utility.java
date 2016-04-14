package util;

/**
 * Created by Sphiinx on 4/13/2016.
 */
public class Utility {

    /**
     * Gets the current time from the mark.
     *
     * @param startTime The start time.
     * @return The time from the mark.
     */
    public static long timeFromMark(long startTime) {
        return System.currentTimeMillis() - startTime;
    }

}

