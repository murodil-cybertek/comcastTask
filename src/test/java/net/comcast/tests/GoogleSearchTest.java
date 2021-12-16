package net.comcast.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.comcast.pages.GoogleHomePage;
import net.comcast.pages.GoogleSearchResultsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;

public class GoogleSearchTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.google.com");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void googleSearchTest() {
        Assert.assertEquals(driver.getTitle(), "Google");
        WebElement searchField = driver.findElement(By.name("q"));
        searchField.sendKeys("comcast internet service"+ Keys.ENTER);

        WebElement results = driver.findElement(By.id("result-stats"));
        System.out.println("results count = " + results.getText());
    }

    @Test
    public void googleSearchPOMTest() {
        GoogleHomePage googleHomePage = new GoogleHomePage(driver);
        googleHomePage.isCurrentPage();
        googleHomePage.searchFor("comcast internet service");

        //now current page is Search results
        GoogleSearchResultsPage resultsPage = new GoogleSearchResultsPage(driver);
        System.out.println("Results count = " + resultsPage.resultsCount.getText());

        int count = resultsPage.getResultsCount();
        System.out.println("count = " + count);
        assertTrue(count > 0);
    }

}
