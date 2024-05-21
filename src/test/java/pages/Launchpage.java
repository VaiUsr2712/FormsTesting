package pages;

import CommonMethods.commonmethods;
import ConfigReader.ConfigSetup;
import ConfigReader.ExcelReader;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.formula.functions.Na;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Launchpage {

    ExcelReader reader = new ExcelReader();



    WebDriver localdriver;
    ConfigSetup configSetup = new ConfigSetup();
    Properties usr = configSetup.propload();
    commonmethods c= new commonmethods();
    ExcelReader excelReader=new ExcelReader();

    @FindBy(css = "#name")
    private WebElement Name;

    @FindBy(xpath="//input[@id=\"email\"]")
    private WebElement email;

    @FindBy(xpath="//label[text()='Male']//parent::div//input")
    private WebElement genmale;

    @FindBy(xpath="//label[text()='Female']//parent::div//input")
    private WebElement genfemale;

    @FindBy(xpath="//label[text()='Other']//parent::div//input")
    private WebElement genother;

    public Launchpage(WebDriver driver) throws IOException, InvalidFormatException {
        this.localdriver = driver;
        PageFactory.initElements(driver, this);
    }


    public void OpenPage() {
        localdriver.get(usr.getProperty("url" ));
        localdriver.manage().window().maximize();
    }

    public void EnterDetails(String Username) {
        Name.sendKeys(Username);
        c.TakeSCreenshot();
    }
    public void EnterEmail(String Email) {
        email.sendKeys(Email);
        c.TakeSCreenshot();
    }

    public void Entervalues(String namevalue, String emailvalue){
        Name.sendKeys(namevalue);
        email.sendKeys(emailvalue);
        c.TakeSCreenshot();
    }
    public void GetDatatable(){
        Name.sendKeys(excelReader.personname);
        email.sendKeys(excelReader.mailid);
        c.TakeSCreenshot();
    }
    public void selectGender(){
        if(excelReader.Gender.equals("Male")){
            genmale.click();
        } else if (excelReader.Gender.equals("Female")) {

            genfemale.click();
        }
        else{
            genother.click();
        }

        c.TakeSCreenshot();
    }
public void readmultipleValuesFromExcel(String sheetname , Integer rownumber) throws IOException, InvalidFormatException {

        List<Map<String, String>> testdata = reader.getData("C:\\Users\\DELL\\Sai\\FormsTesting\\target\\test-classes\\Excel\\datatablevalues.xlsx", sheetname);
    String namefromExcel = testdata.get(rownumber).get("Name");

   String EmailfromExcel  = testdata.get(rownumber).get("Email");

    String genfromExcel = testdata.get(rownumber).get("Gender");



    System.out.println(namefromExcel);

    System.out.println(EmailfromExcel);


    System.out.println(genfromExcel);


    Name.sendKeys(namefromExcel);
    email.sendKeys(EmailfromExcel);
    c.TakeSCreenshot();
}
}
