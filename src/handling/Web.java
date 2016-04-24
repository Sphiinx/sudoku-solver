package handling;

import api.HandleWeb;
import org.openqa.selenium.WebElement;


/**
 * Created by Sphiinx on 4/13/2016.
 */
public class Web {

    /**
     * Resets the current sudoku game with the difficulty options.
     *
     * @param difficultyOption The difficulty option.
     */
    public static void resetGame(String difficultyOption) {
        if (!isGameOpen("//*[@id=\"game\"]"))
            return;

        HandleWeb.getElementXPath(HandleWeb.driver, "//*[@id=\"site-navigation\"]/div[2]/ul/li").click();
        HandleWeb.getElementXPath(HandleWeb.driver, difficultyOption).click();
    }

    /**
     * Checks if the sudoku game is open.
     *
     * @param xPath The xPath of the game.
     * @return True if it's open; false otherwise.
     */
    public static boolean isGameOpen(String xPath) {
        WebElement check = HandleWeb.getElementXPath(HandleWeb.driver, xPath);
        return check != null;
    }

}

