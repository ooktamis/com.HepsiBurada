import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {

    public void setBrowser(String url){
        System.setProperty("webdriver.chrome.driver", "src/Driver/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();//Tam ekran moduna gecmemizi sagliyor.
        BaseTest.setDriver(driver);//driveri set ettik
        BaseTest.getDriver().get(url);//set ettikten sonra

    }
}
