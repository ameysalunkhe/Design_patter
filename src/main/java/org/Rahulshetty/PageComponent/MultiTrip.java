package org.Rahulshetty.PageComponent;

import org.Rahulshetty.SupportedAbstractedComponents.Abstractcomponent;
import org.Rahulshetty.SupportedAbstractedComponents.SearchAvailability;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.function.Consumer;

public class MultiTrip extends Abstractcomponent implements SearchAvailability {
    private By multiTrip=By.id("ctl00_mainContent_rbtnl_Trip_2");
    private By popup = By.id("MultiCityModelAlert");
    private By from1=By.id("ctl00_mainContent_ddl_originStation1_CTXT");
    private By destination1=By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
    private By destination_2=By.id("ctl00_mainContent_ddl_originStation2_CTXT");
    private By studentCheckbox=By.id("ctl00_mainContent_chk_StudentDiscount");
    private By searchButton=By.id("ctl00_mainContent_btn_FindFlights");

    public MultiTrip(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
    }

    @Override
    public void getFlightAvailability(HashMap<String,String> reservationDetails) {
        makeStateReady(s->selectOriginCity(reservationDetails.get("origin")));
        selectDestinationCity(reservationDetails.get("destination"));
        selectDestinationCity2(reservationDetails.get("destination2"));
        findelement(searchButton).click();

    }

    public void selectOriginCity(String origin) {
        findelement(from1).click();
        findelement(By.xpath("//a[@value='"+origin+"']")).click();
    }

    public void selectDestinationCity(String destination) {
        findelement(destination1).click();
        findelement(By.xpath("(//a[@value='"+destination+"'])[2]")).click();
    }

    public void selectDestinationCity2(String destination2) {
        findelement(destination_2).click();
        findelement(By.xpath("(//a[@value='"+destination2+"'])[3]")).click();
    }

    public void makeStateReady(Consumer<MultiTrip> consumer)
    {
        System.out.println("inside make stateready");
        findelement(multiTrip).click();
        findelement(popup).click();
        waitForElementToDisappear(popup);
        consumer.accept(this);
        System.out.println("makestatready done");

    }
}
