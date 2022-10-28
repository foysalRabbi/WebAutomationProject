package AppHooks;

import com.google.common.io.Files;
import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;
import io.cucumber.java.Before;
import io.cucumber.java.After;

import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ApplicationHooks {
    private DriverFactory driverFactory;
    private WebDriver driver;
    private ConfigReader configReader;
    Properties prop;

    @Before(order = 0)
    public void getProperty() throws FileNotFoundException {
        configReader = new ConfigReader();
        prop = configReader.init_prop();
    }

    @Before(order = 1)
    public void launchBrowser() {
        String browserName = prop.getProperty("browser");
        driverFactory = new DriverFactory();
        driver = driverFactory.init_driver(browserName);
    }

//    @After(order = 0)
//    public void quitBrowser() {
//        driver.quit();
//    }

    @After(order = 1)
    public void tearDown(Scenario scenario) {
        String screenshotName = scenario.getName().replaceAll(" ", "_");
        byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs((OutputType.BYTES));
        scenario.attach(sourcePath, "image/png", screenshotName);
    }

//    @After(order = 1)
//    public void afterScenarioLocal(Scenario scenario) {
//        if (scenario.isFailed()) {
//
//            String screenshotName = scenario.getName().replaceAll(" ", "_");
//            try {
//                //Tham takes a screenshot from the driver at save it to the specified location
//                File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//
//
//                //Building up the destination path for the screenshot to save
//                //Also make sure to create a folder 'screenshots' with in the cucumber-report folder
//                File destinationPath = new File(System.getProperty("I.dir") + "/report/screenshots/" + screenshotName + ".png");
//
//                //Copy taken screenshot from source location to destination location
//                Files.copy(scrFile, destinationPath);
//
//            } catch (IOException e) {
//            }
//        }
//
//    }

}
