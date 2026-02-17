package Base;

import java.io.File;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import Pages.LoginPage;
import Utils.ConfigClass;

public class BaseClass {

    public WebDriver driver;
    public WebDriverWait wait;
    public LoginPage pg;
    public Properties prop;
    
    public WebDriver getDriver() {
        return driver;
    }
	
    public String tScreenshot(String screenshotname) {

	    try {
	        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

	        String path = "C:\\Users\\visha\\git\\VishalSelenium\\Practice\\Screenshots\\"
	                + screenshotname + "_" + System.currentTimeMillis() + ".png";

	        File dest = new File(path);
	        FileHandler.copy(src, dest);

	        return path;

	    } catch (Exception e) {
	        System.out.println("Screenshot failed: " + e.getMessage());
	        return null;
	    }
	}

    @BeforeClass
    @Parameters("browser")
    public void setUp(@Optional("chrome") String browser) {

        prop = ConfigClass.initProperties();

        if (browser == null || browser.trim().equals("")) {
            browser = prop.getProperty("browser");
        }

        // Browser selection
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        }
        else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }
        else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        }
        else if (browser.equalsIgnoreCase("internet")) {
            driver = new InternetExplorerDriver();
        }
        else if (browser.equalsIgnoreCase("safari")) {
            driver = new SafariDriver();
        }
        else {
            System.out.println("Browser not available!!!!");
            
        }

        
        driver.get(prop.getProperty("url"));

        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        pg = new LoginPage(driver);
    }

  // @AfterClass
  //  public void Close() {
    //    if (driver != null) {
   //       driver.quit();
      // }
  }
