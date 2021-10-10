package org.Rahulshetty;
import org.Rahulshetty.MainPageObjects.TravelHome;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class DemoTest extends BaseTest{

WebDriver driver;
    TravelHome travelHome;
@BeforeTest
public void driverSetup()
{
    driver=initializeDriver();
    travelHome = new TravelHome(driver);
}
    @Test(dataProvider = "getData")
    public void flightTest(HashMap<String,String>reservationDetails)
    {
        travelHome.goTo();
        System.out.println(travelHome.getFooterNav().getFlightAttribute());
        System.out.println(travelHome.getFooterNav().getLinkCount());
        System.out.println(travelHome.getNavigationBar().getFlightAttribute());
        System.out.println(travelHome.getNavigationBar().getLinkCount());
//        travelHome.setBookingStrategy(new MultiTrip(driver,sectionElement));
        travelHome.setBookingStrategy("multitrip");
        travelHome.getFlightAvailability (reservationDetails);

    }
    @AfterTest
    public void driverCloseup()
    {
        driver.quit();
    }

    @DataProvider
    public Object[][] getData() throws IOException {

    List<HashMap<String,String>> list=getJasonData(System.getProperty("user.dir")+"//src//main//java//org//Rahulshetty//DataLoads//reservationDetails.json");
    return new Object[][]
        {
                {list.get(0)},{list.get(1)}
        };
    }


}
