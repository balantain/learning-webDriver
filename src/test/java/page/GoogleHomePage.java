package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleHomePage extends AbstractPage{
    private String URL = "https://www.google.com/";


    @FindBy(name = "q")
    WebElement gSearch;

    public GoogleHomePage(WebDriver driver) {
        super(driver);
    }


    public GoogleHomePage openPage(){
        driver.get(URL);
        return this;
    }

    public void searchForTerm(String term){
        gSearch.sendKeys(term);
        gSearch.sendKeys(Keys.ENTER);
    }
}
