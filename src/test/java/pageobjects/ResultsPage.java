package pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResultsPage extends BasePage {
    public ResultsPage(WebDriver driver) {
        super(driver);
    }

    private static final By GET_RESULTS = By.id("button-get-results");
    private static final By YEARLY_PAY_BOX = By.cssSelector(".govuk-panel");
    private static final By MONTHLY_PAY_BOX = By.cssSelector("a[href='#MONTHLY']");
    private static final By WEEKLY_PAY_BOX = By.cssSelector("a[href='#WEEKLY']");



    public void clickGetResults(){waitAndClick(GET_RESULTS);}

    public void yearlyPayDisplayed(){
        WebElement greenBox = driver.findElement(YEARLY_PAY_BOX);
        Assert.assertTrue(elementIsVisible(greenBox));

    }
    public void clickMonthlyTab(){
        waitAndClick(MONTHLY_PAY_BOX);
    }

    public void monthlyPayDisplayed(){
        WebElement greenBox = driver.findElement(MONTHLY_PAY_BOX);
        Assert.assertTrue(elementIsVisible(greenBox));


    }

    public void clickWeeklyTab(){waitAndClick(WEEKLY_PAY_BOX);}

    public void weeklyPayDisplayed(){
        WebElement greenBox = driver.findElement(WEEKLY_PAY_BOX);
        Assert.assertTrue(elementIsVisible(greenBox));

    }
}
