package org.Rahulshetty.PageComponent;

import org.Rahulshetty.SupportedAbstractedComponents.Abstractcomponent;
import org.Rahulshetty.SupportedAbstractedComponents.SearchAvailability;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class RoundTrip extends Abstractcomponent implements SearchAvailability {

    private By roundTrip = By.id("ctl00_mainContent_rbtnl_Trip_1");
    private By fromDropdwon=By.id("ctl00_mainContent_ddl_originStation1_CTXT");
    private By toDropdown=By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
    private By studentCheckbox=By.id("ctl00_mainContent_chk_StudentDiscount");
    private By searchButton=By.id("ctl00_mainContent_btn_FindFlights");

    public RoundTrip(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
    }

    @Override
    public void getFlightAvailability(HashMap<String,String>reservationDetails) {

        selectOriginCity(reservationDetails.get("origin"));
        selectDestinationCity(reservationDetails.get("destination"));
        findelement(studentCheckbox).click();
        findelement(searchButton).click();

    }
    public void selectOriginCity(String origin)
    {
        findelement(fromDropdwon).click();
        findelement(By.xpath("//a[@value='"+origin+"']")).click();

    }
    public void selectDestinationCity(String destination)
    {
        findelement(toDropdown).click();
        findelement(By.xpath("(//a[@value='"+destination+"'])[2]")).click();
    }

    public void makeStateReady()
    {
        findelement(roundTrip ).click();
    }


}
