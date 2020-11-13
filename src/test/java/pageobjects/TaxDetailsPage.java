package pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TaxDetailsPage extends BasePage {
    public TaxDetailsPage(WebDriver driver) {
        super(driver);
    }

    private static final By NO_TO_STATE_PENSION = By.id("overStatePensionAge-2");
    private static final By NO_SCOTTISH_TAX = By.id("payScottishRate-2");
    private static final By CHECK_STATE_PENSION_AGE = By.cssSelector(".govuk-details__summary");
    private static final By STATE_PENSION_AGE_LINK = By.cssSelector("a[href='https://www.gov.uk/state-pension-age' ]");
    private static final By NO_STATE_PENSION_ERROR = By.cssSelector("a[href='#overStatePensionAge']");
    private static final By INPUT_TAX_CODE = By.id("taxCode");
    private static final By TAX_CODE_ERROR = By.cssSelector("a[href='#taxCode']");



    public void clickNoToStatePension(){
        WebElement noPension = driver.findElement(NO_TO_STATE_PENSION);
        noPension.click();
    }

    public void clickNoToScotIncomeTax(){
        WebElement noScotIT = driver.findElement(NO_SCOTTISH_TAX);
        noScotIT.click();
    }



    public void clickCheckStatePensionAge(){
        waitAndClick(CHECK_STATE_PENSION_AGE);
    }

    public void openStatePensionAgeTab(){
        waitAndClick(STATE_PENSION_AGE_LINK);

    }

    public void noStatePensionOptionError(){
        WebElement alertBox = driver.findElement(NO_STATE_PENSION_ERROR);
        Assert.assertTrue(elementIsVisible(alertBox));
    }

    public void enterTaxCode(String taxcode){
        findAndType(INPUT_TAX_CODE,taxcode);
    }

    public void taxCodeErrorDisplayed(){
        WebElement alertBox = driver.findElement(TAX_CODE_ERROR);
        Assert.assertTrue(elementIsVisible(alertBox));
    }



}

