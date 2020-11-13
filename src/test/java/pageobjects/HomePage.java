package pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    private static String URL = "https://www.tax.service.gov.uk/estimate-paye-take-home-pay/your-pay";

    private static final By INPUT_AMOUNT = By.cssSelector("input[name = 'amount']");
    private static final By SELECT_MONTHLY = By.id("period-4");
    private static final By CONTINUE = By.id("button-continue");
    private static final By START_AGAIN = By.id("restart-button");
    private static final By PAY_FREQ_ERROR = By.cssSelector("a[href = '#period'");
    private static final By SELECT_HOURLY = By.id("period");
    private static final By AMOUNT_ERROR = By.cssSelector("a[href ='#amount']");
    private static final By INPUT_HOURS_WEEKLY = By.id("how-many-a-week");
    private static final By SELECT_DAILY = By.id("period-2");
    private static final By DAY_EXCEED_ERROR = By.cssSelector("a[href='#how-many-a-week']");

    public void goTo(){
        driver.get(URL);

    }

    public void enterAmountPaid(String amount){ findAndType(INPUT_AMOUNT, amount); }


    public void selectMonthlyPay(){
        WebElement monthly = driver.findElement(SELECT_MONTHLY);
        monthly.click();
    }

    public void selectHourlyPay(){
        WebElement hourly = driver.findElement(SELECT_HOURLY);
        hourly.click();
    }

    public void selectDailyPay(){
        WebElement daily = driver.findElement(SELECT_DAILY);
        daily.click();
    }

    public void enterHowManyAWeek(String number){findAndType(INPUT_HOURS_WEEKLY, number);}

    public void clickContinue(){ waitAndClick(CONTINUE);}



    public void clickStartAgain(){waitAndClick(START_AGAIN);}


    public void payFrequencyDisplayed(){
        WebElement alert = driver.findElement(PAY_FREQ_ERROR);
        Assert.assertTrue(elementIsVisible(alert));
    }

    public void amountErrorDisplayed(){
        WebElement alertBox = driver.findElement(AMOUNT_ERROR);
        Assert.assertTrue(elementIsVisible(alertBox));
    }

    public void dayExceedErrorDisplayed(){
        WebElement alertBox = driver.findElement(DAY_EXCEED_ERROR);
        Assert.assertTrue(elementIsVisible(alertBox));
    }



}
