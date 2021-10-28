package test;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.GmailPage;
import page.GoogleHomePage;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class CreateNewTabTest {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void startBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testNewTabOpening() throws AWTException {
        GoogleHomePage ghp = new GoogleHomePage(driver).openPage();

        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");

//      String handle = driver.getWindowHandle(); // возвращает дескриптор вкладки

        List<String> handles = new ArrayList<>(driver.getWindowHandles()); // возвращает Set дескрипторов вкладок
        driver.switchTo().window(handles.get(1)); // т.к. вкладки 2, то мы переключаемся на последнюю открытую вкладку
        GmailPage gmailPage = new GmailPage(driver).openPage();

        driver.switchTo().window(handles.get(0)); // переключаемся к первой вкладке
        ghp.searchForTerm("gmail.com");
    }

    @AfterMethod(alwaysRun = true)
    public void quitBrowser(){
        driver.quit();
        driver = null;
    }
}





//-------------------- Var.1 ------------------------------
//      JavascriptExecutor js = (JavascriptExecutor) driver;
//      js.executeScript("window.open()"); // откроет пустую вкладку

//      ((JavascriptExecutor) driver).executeScript("window.open('https://google.com')"); // откроет вкладку с URL
//-------------------- Var.2 ------------------------------
//        Robot robot = new Robot();
//        robot.keyPress(KeyEvent.VK_CONTROL);
//        robot.keyPress(KeyEvent.VK_T);
//        robot.keyRelease(KeyEvent.VK_CONTROL);
//        robot.keyRelease(KeyEvent.VK_T);
//        Thread.sleep(3000);
//-------------------- Var. 3 --------НЕ РАБОТАЕТ!!!!!!!!!!!!!!!!!---------------------
//        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
//        Thread.sleep(3000);
//        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
//        driver.switchTo().window(tabs.get(0));
//        Thread.sleep(3000);