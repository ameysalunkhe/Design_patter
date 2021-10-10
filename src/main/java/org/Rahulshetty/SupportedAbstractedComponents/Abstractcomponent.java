package org.Rahulshetty.SupportedAbstractedComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class Abstractcomponent {

    WebElement sectionElement;
    WebDriver driver;
    public Abstractcomponent(WebDriver driver, By sectionElement) {
        this.driver=driver;
        this.sectionElement=driver.findElement(sectionElement);
    }

    public WebElement findelement(By findelementBy) {
         return sectionElement.findElement(findelementBy);
    }
    public List<WebElement> findelements(By findelementBy) {
        return sectionElement.findElements(findelementBy);
    }
    public void waitForElementToDisappear(By findBy)
    {
        WebDriverWait wait=new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
    }

}
