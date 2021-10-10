package org.Rahulshetty.PageComponent;

import org.Rahulshetty.SupportedAbstractedComponents.Abstractcomponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FooterNav extends Abstractcomponent {
    WebDriver driver;
    By flights = By.cssSelector("[title='Flights']");
    By link=By.cssSelector("a");

    public FooterNav(WebDriver driver, By sectionElement) {
        super(driver,sectionElement);
    }


    public String getFlightAttribute() {

        return findelement(flights).getAttribute("class");

        //driver.findElement(flights).click();
    }
    public int getLinkCount()
    {
        return findelements(link).size();
    }


}