package stepdefinitions;

import DriverFactory.DriverInitialization;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import pages.Launchpage;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static com.google.common.collect.Multimaps.asMap;


public class LaunchAppformpage extends DriverInitialization {

    Launchpage launchpage = new Launchpage(DriverInitialization.Passbrowser());

    public LaunchAppformpage() throws IOException, InvalidFormatException {
    }

    @Given("User is able to open the browser" )
    public void userIsAbleToOpenTheBrowser() throws IOException {
        launchpage.OpenPage();
    }

    @And("User Enters Name" )
    public void userEntersName() {

    }

    @And("User Enters Name {string}" )
    public void userEntersName(String Name) {
        launchpage.EnterDetails(Name);
    }

    @And("User Enters Email {string}" )
    public void userEntersEmail(String Email) {
        launchpage.EnterEmail(Email);
    }

    @And("Enter the details" )
    public void enterTheDetails(DataTable dataTable) {

        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

        String Nametitle = data.get(0).get("Name" );
        String Emailtitle = data.get(0).get("Email" );

        System.out.println(Nametitle);
        System.out.println(Emailtitle);

        launchpage.Entervalues(Nametitle, Emailtitle);



    }

    @And("Get values from the excel" )
    public void getValuesFromTheExcel() {
        launchpage.GetDatatable();
        launchpage.selectGender();
    }



    @And("Get values from the excel {string} and {}")
    public void getValuesFromTheExcelAnd(String sheetname, Integer Rownumber) throws IOException, InvalidFormatException {
        launchpage.readmultipleValuesFromExcel(sheetname,Rownumber);
    }
}