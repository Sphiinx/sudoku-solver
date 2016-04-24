package api;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Sphiinx on 4/23/2016.
 */
public class HandleWeb {

    public static WebDriver driver;

    /**
     * Opens the website with the given String.
     *
     * @param url The url to open.
     */
    public static void openURL(String url) {
        driver = new FirefoxDriver();
        driver.get(url);
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
     * Gets the element by the CSS Selector tag.
     *
     * @param context The context.
     * @param cssSelector     The CSS Selector tag.
     * @return The context element.
     */
    public static WebElement getElementCSSSelector(SearchContext context, String cssSelector) {
        try {
            return context.findElement(By.cssSelector(cssSelector));
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Gets the element by the link text.
     *
     * @param context The context.
     * @param text     The link text.
     * @return The context element.
     */
    public static WebElement getElementText(SearchContext context, String text) {
        try {
            return context.findElement(By.linkText(text));
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Gets the element by the class name.
     *
     * @param context The context.
     * @param className     The class name.
     * @return The context element.
     */
    public static WebElement getElementClass(SearchContext context, String className) {
        try {
            return context.findElement(By.className(className));
        } catch (Exception e) {
            return null;
        }
    }

}

