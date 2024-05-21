package stepdefinitions;

import io.cucumber.java.After;

import static DriverFactory.DriverInitialization.driver;

public class HooksWebdriver {


    @After
    public void QuitBrowser()  {

        driver.quit();

    }
}
