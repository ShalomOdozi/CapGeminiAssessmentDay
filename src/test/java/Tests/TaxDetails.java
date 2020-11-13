package Tests;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pageobjects.HomePage;
import pageobjects.TaxDetailsPage;

import static Tests.TestSuite.driverFactory;

public class TaxDetails {
    public static WebDriver driver = driverFactory.getDriver();

    HomePage takeHomePay = new HomePage(driver);
    TaxDetailsPage taxDetails = new TaxDetailsPage(driver);

    @BeforeEach
    public void individualSetUp(){
        takeHomePay.goTo();
    }

    @Test
    public void checkStatePensionAge(){
        takeHomePay.enterAmountPaid("1500");
        takeHomePay.selectMonthlyPay();
        takeHomePay.clickContinue();
        taxDetails.clickCheckStatePensionAge();
        taxDetails.openStatePensionAgeTab();
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals("https://www.gov.uk/state-pension-age",currentURL);

    }

    @Test
    public void statePensionIsNotSelected(){
        takeHomePay.enterAmountPaid("1500");
        takeHomePay.selectMonthlyPay();
        takeHomePay.clickContinue();
        takeHomePay.clickContinue();
        taxDetails.noStatePensionOptionError();


    }

    @Test
    public void incorrectTaxCodeEntered(){
        takeHomePay.enterAmountPaid("1500");
        takeHomePay.selectMonthlyPay();
        takeHomePay.clickContinue();
        taxDetails.clickNoToStatePension();
        takeHomePay.clickContinue();
        taxDetails.enterTaxCode("pop");
        takeHomePay.clickContinue();
        taxDetails.taxCodeErrorDisplayed();


    }
}
