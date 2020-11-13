package Tests;

import org.junit.AfterClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pageobjects.HomePage;

import static Tests.TestSuite.driverFactory;

public class HomePay {
    public static WebDriver driver = driverFactory.getDriver();

    HomePage takeHomePay = new HomePage(driver);

    @BeforeEach
    public void individualSetUp(){
        takeHomePay.goTo();
    }

    @Test
    public void noPayFrequencySelected(){
        takeHomePay.enterAmountPaid("1500");
        takeHomePay.clickContinue();
        takeHomePay.payFrequencyDisplayed();


    }

    @Test
    public void enterZeroAmountPaid(){
        takeHomePay.enterAmountPaid("0");
        takeHomePay.selectMonthlyPay();
        takeHomePay.clickContinue();
        takeHomePay.amountErrorDisplayed();
    }

    @Test
    public void enterNoAmountPaid(){
        takeHomePay.selectMonthlyPay();
        takeHomePay.clickContinue();
        takeHomePay.amountErrorDisplayed();

    }

    @Test
    public void exceed7DayWeekly(){
        takeHomePay.enterAmountPaid("200");
        takeHomePay.selectDailyPay();
        takeHomePay.clickContinue();
        takeHomePay.enterHowManyAWeek("8");
        takeHomePay.clickContinue();
        takeHomePay.dayExceedErrorDisplayed();
    }




}
