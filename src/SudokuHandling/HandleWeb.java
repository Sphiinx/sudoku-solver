package SudokuHandling;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


/**
 * Created by Sphiinx on 4/13/2016.
 */
public class HandleWeb {

    public static WebDriver driver;

    public static void openWebsite(String website) {
        driver = new FirefoxDriver();
        driver.get(website);
    }

    /**
     * Gets the element by the xPath.
     *
     * @param context The context.
     * @param xpath   The Xpath.
     * @return The context element.
     */
    public static WebElement getElementXPath(SearchContext context, String xpath) {
        try {
            return context.findElement(By.xpath(xpath));
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Gets the element by the CSS tag.
     *
     * @param context The context.
     * @param css     The CSS tag.
     * @return The context element.
     */
    public static WebElement getElementCSS(SearchContext context, String css) {
        try {
            return context.findElement(By.cssSelector(css));
        } catch (Exception e) {
            return null;
        }
    }

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

