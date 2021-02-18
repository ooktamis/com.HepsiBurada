import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class BaseTest {

    private static WebDriver driver;
    protected static Browser browser = new Browser();

    public static WebDriver getDriver(){ return driver; }//Burada driveri cagirdik artik getDriver ile driver diyecegiz
    public static void setDriver (WebDriver driver){ BaseTest.driver=driver; }//Buraya dirveri set ederek kullanimini sagladik

    @Before
    public void Start() {
        /*System.setProperty("webdriver.chrome.driver", "src/Driver/chromedriver.exe");
        this.driver = new ChromeDriver();
        getDriver().get("https://www.hepsiburada.com/");*/
        browser.setBrowser("https://www.hepsiburada.com/");//linki url degiskenine gönderdik

        AssertTitle("Türkiye'nin En Büyük Online Alışveriş Sitesi Hepsiburada.com");
        //ustteki satir sabitin dogru olup olmadigiini kontrolnu sagliyor eger dogru ise evam yanlis ise hata donduruyor
        //String a=driver.getTitle();//gettitle ne getiriyor kontrolünü yaptim
        //System.out.println(a);

    }
    @After
    public void Finish() {//chrome kapatiyoruz
        getDriver().quit();
    }

    public static WebElement findElement_Func(By by) {//
        return  getDriver().findElement(by);
    }

    public  static  void ButtonClick_Func(By by) {
        findElement_Func(by).click();
    }
    public static void SendKeys_Func(By by,String name){
        findElement_Func(by).sendKeys(name);
    }
    public static String NameControl(By by){//oturum oluşunca hangi isim oldugunun degerini aldik
        return findElement_Func(by).getText();
    }
public static Boolean NameResult(String HBname, String Username){//aldigimiz ismin kontrolunu saglamak icin fonskiyon
        boolean value = false;
        if (HBname.equals(Username))
            value=true;
        return value;
    }
    
    public static void AssertTitle(String title){ Assert.assertEquals(title,driver.getTitle()); }
}
