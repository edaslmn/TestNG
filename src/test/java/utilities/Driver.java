package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {

    public static WebDriver driver;


    public static WebDriver  getDriver(){

        String kullanilacakBrowser = ConfigReader.getProperty("browser");
        // configuration properties dosyasindan browser tercihini aldik

        // isterseniz bir emniyet sigortası ekleyebiliriz

        if (kullanilacakBrowser == null){
            kullanilacakBrowser = "chrome";
        }

        if (driver == null){

            switch (kullanilacakBrowser){

                case "edge" :
                    driver = new EdgeDriver();
                    break;
                case "firefox" :
                    driver = new FirefoxDriver();
                    break;
                case "safari" :
                    driver = new SafariDriver();
                    break;
                default:
                    driver = new ChromeDriver();
            }

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
        }

        return driver;
    }

    public static void quitDriver(){
        driver.quit();
        driver = null;
    }
}