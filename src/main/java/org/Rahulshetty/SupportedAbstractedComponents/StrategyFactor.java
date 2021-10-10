package org.Rahulshetty.SupportedAbstractedComponents;

import org.Rahulshetty.PageComponent.MultiTrip;
import org.Rahulshetty.PageComponent.RoundTrip;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StrategyFactor  {

    WebDriver driver;
    By sectionElement=By.id("flightSearchContainer");

    public StrategyFactor(WebDriver driver) {
        this.driver=driver;
    }

    public SearchAvailability createStrategy(String strategyType)
    {
        if (strategyType.equalsIgnoreCase("multitrip")) {
            return new MultiTrip(driver,sectionElement);
        }
        if (strategyType.equalsIgnoreCase("Roundtrip")){
            return new RoundTrip(driver,sectionElement);
        }
        return null;
    }
}
