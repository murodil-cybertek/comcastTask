package net.comcast.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.testng.Assert.*;

public class GoogleHomePage {
    WebDriver driver; //driver to use in this class

    //passing webdriver object using constructor
    //In @Test: GoogleHomePage gp = new GoogleHomePage(driver);
    public GoogleHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "q")
    public WebElement searchField;

    public void searchFor(String item) {
        searchField.sendKeys(item + Keys.ENTER);
    }

    public void isCurrentPage() {
        assertEquals(driver.getTitle(), "Google");
    }

}
