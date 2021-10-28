package page;

import org.openqa.selenium.WebDriver;

public class GmailPage extends AbstractPage{
    private static final String URL = "https://www.google.com/intl/ru/gmail/about/";

    public GmailPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public GmailPage openPage() {
        driver.get(URL);
        return this;
    }


}
