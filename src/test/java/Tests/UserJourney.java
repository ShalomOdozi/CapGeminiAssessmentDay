package Tests;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pageobjects.HomePage;
import pageobjects.ResultsPage;
import pageobjects.TaxDetailsPage;

import static Tests.TestSuite.driverFactory;

public class UserJourney {

    public static WebDriver driver = driverFactory.getDriver();

    HomePage takeHomePay = new HomePage(driver);
    TaxDetailsPage taxDetails = new TaxDetailsPage(driver);
    ResultsPage resultspage = new ResultsPage(driver);

    @BeforeEach
    public void individualSetUp(){
        takeHomePay.goTo();
    }


    @Test
    public void howYouGotPaidMonthly(){
      takeHomePay.enterAmountPaid("1500");
      takeHomePay.selectMonthlyPay();
      takeHomePay.clickContinue();
      taxDetails.clickNoToStatePension();
      takeHomePay.clickContinue();
      takeHomePay.clickContinue();
      taxDetails.clickNoToScotIncomeTax();
      takeHomePay.clickContinue();
      resultspage.clickGetResults();
      String currentURL = driver.getCurrentUrl();
      Assert.assertEquals("https://www.tax.service.gov.uk/estimate-paye-take-home-pay/your-results?", currentURL);

    }

    @Test
    public void startTaxServiceAgain(){
        takeHomePay.enterAmountPaid("1500");
        takeHomePay.selectMonthlyPay();
        takeHomePay.clickContinue();
        taxDetails.clickNoToStatePension();
        takeHomePay.clickContinue();
        takeHomePay.clickContinue();
        taxDetails.clickNoToScotIncomeTax();
        takeHomePay.clickContinue();
        resultspage.clickGetResults();
        takeHomePay.clickStartAgain();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("https://www.tax.service.gov.uk/estimate-paye-take-home-pay/your-pay",currentUrl);


    }

    @Test
    public void howYouGotPaidHourly(){
        takeHomePay.enterAmountPaid("10.50");
        takeHomePay.selectHourlyPay();
        takeHomePay.clickContinue();
        takeHomePay.enterHowManyAWeek("35");
        takeHomePay.clickContinue();
        taxDetails.clickNoToStatePension();
        takeHomePay.clickContinue();
        takeHomePay.clickContinue();
        taxDetails.clickNoToScotIncomeTax();
        takeHomePay.clickContinue();
        resultspage.clickGetResults();
        resultspage.yearlyPayDisplayed();

    }

    @Test
    public void payTabsAreDisplayed(){
        takeHomePay.enterAmountPaid("1500");
        takeHomePay.selectMonthlyPay();
        takeHomePay.clickContinue();
        taxDetails.clickNoToStatePension();
        takeHomePay.clickContinue();
        takeHomePay.clickContinue();
        taxDetails.clickNoToScotIncomeTax();
        takeHomePay.clickContinue();
        resultspage.clickGetResults();
        resultspage.clickMonthlyTab();
        resultspage.monthlyPayDisplayed();
        resultspage.clickWeeklyTab();
        resultspage.weeklyPayDisplayed();

    }



}
