package handling.website.enums;

/**
 * Created by death on 5/19/2016.
 */
public enum ModeType {

    BEGINNER("//*[@id=\"site-navigation\"]/div[2]/ul/li/ul/li[1]/a"),
    EASY_HARD("//*[@id=\"site-navigation\"]/div[2]/ul/li/ul/li[2]/a"),
    EXPERT("//*[@id=\"site-navigation\"]/div[2]/ul/li/ul/li[3]/a");

    private final String xPath;

    ModeType(String xPath) {
        this.xPath = xPath;
    }

    public String getModexPath() {
        return xPath;
    }


}
