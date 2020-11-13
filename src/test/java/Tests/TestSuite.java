package Tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
    @Suite.SuiteClasses({
          UserJourney.class, HomePay.class, TaxDetails.class})
    public class TestSuite {

        static DriverFactory driverFactory = new DriverFactory();

        @BeforeAll
        public static void suiteSetUp(){
        }


        @AfterAll
        public static void tearDown(){
            driverFactory.getDriver().quit();
        }

    }

