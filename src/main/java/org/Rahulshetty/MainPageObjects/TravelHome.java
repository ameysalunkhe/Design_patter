package org.Rahulshetty.MainPageObjects;
import org.Rahulshetty.PageComponent.FooterNav;
import org.Rahulshetty.PageComponent.NavigationBar;
import org.Rahulshetty.SupportedAbstractedComponents.SearchAvailability;
import org.Rahulshetty.SupportedAbstractedComponents.StrategyFactor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class TravelHome {
    By sectionElement=By.id("traveller-home");
    By headersectionElement=By.id("buttons");
    SearchAvailability  searchAvailability;
    WebDriver driver;

    public TravelHome(WebDriver driver) {
        this.driver=driver;
    }

    public void goTo() {
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
    }

    public NavigationBar getNavigationBar() {
        return new NavigationBar(driver,headersectionElement);
    }

    public FooterNav getFooterNav(){
        return new FooterNav(driver,sectionElement);
    }

    public void setBookingStrategy(String strategyType) {
        StrategyFactor strategyFactor = new StrategyFactor(driver);
        searchAvailability = strategyFactor.createStrategy(strategyType);
        this.searchAvailability = searchAvailability;
    }

    public void getFlightAvailability(HashMap<String,String> reservationDetails) {
        searchAvailability.getFlightAvailability(reservationDetails);
    }
    public String getTitle()
    {
        System.out.println("Hello from getTitle");
        return driver.getTitle();

    }
}