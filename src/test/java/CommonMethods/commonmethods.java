package CommonMethods;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static DriverFactory.DriverInitialization.driver;

public class commonmethods {


    public void TakeSCreenshot() {

        // Take screenshot and save it as a file
        File Scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        String filename = new SimpleDateFormat("yyyyMMddhhmmss'.png'").format(new Date());

        String destinationPath = "C:\\Users\\DELL\\Sai\\FormsTesting\\target\\Screenshots\\";


        try {

            File Des = new File(destinationPath + filename);
            FileUtils.copyFile(Scr, Des);

        } catch (IOException e) {
            e.printStackTrace();

        }}

        public void sample() {
            System.out.println("Sample");
        }
    }
