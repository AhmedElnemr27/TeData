package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageBase {

    WebDriver driver;

    public void PageBase(WebDriver driver){
        PageFactory.initElements(driver,"this");
    }
}
