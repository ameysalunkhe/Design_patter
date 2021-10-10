package org.Rahulshetty;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

public class BaseTest {

    public WebDriver initializeDriver()
    {
        System.setProperty("webdriver.chrome.driver","D://Study//Selenium course//Selenium browser drivers//Chrome Driver//Chrome driver  94.0.4606.61//chromedriver_win32//chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        return driver;

    }

    public List<HashMap<String, String>> getJasonData(String jsonFilePath) throws IOException {
        String jsonContent= FileUtils.readFileToString(new File(jsonFilePath), StandardCharsets.UTF_8);
        ObjectMapper mapper=new ObjectMapper();
        List<HashMap<String,String>> data= mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>() {});

        return data;


    }
}
