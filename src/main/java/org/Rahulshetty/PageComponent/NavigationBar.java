package org.Rahulshetty.PageComponent;

import org.Rahulshetty.SupportedAbstractedComponents.Abstractcomponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationBar extends Abstractcomponent
{
    WebDriver driver;
    By flights = By.cssSelector("[title='Flights']");
    By link = By.cssSelector("a");

    public NavigationBar(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
    }
    public String getFlightAttribute()
    {
        return findelement(flights).getAttribute("class");
    }

    public int getLinkCount()
    {
       return findelements(link).size();
    }


}
