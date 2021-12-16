package net.comcast.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchResultsPage {

    WebDriver driver;

    public GoogleSearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "result-stats")
    public WebElement resultsCount;

    //About 54,100,000 results (0.58 seconds)
    public int getResultsCount() {
        String[] resultArr = resultsCount.getText().split(" ");
        return Integer.parseInt(resultArr[1].replace(",",""));
    }
}
