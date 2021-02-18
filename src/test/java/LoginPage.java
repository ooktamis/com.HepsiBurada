import com.thoughtworks.gauge.Step;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BaseTest {

    WebDriver driver;
    @Test
    @Step("HepsiBurada Redirect to HomePage")
    public void OpenHB() {
        Start();
        System.out.println("* Scenario One Successful *");

    }
    @Test
    @Step("Redirect to User Login Page")
    public void LoginButtonClick() throws InterruptedException {
        ButtonClick_Func(By.xpath("//*[@id=\"myAccount\"]/span/span[1]"));
        Thread.sleep(2000);
        ButtonClick_Func(By.xpath("//*[@id=\"login\"]"));
        System.out.println("** Second Scenario Successful **");
    }
    @Test
    @Step("Login with user mail and user password <email> <password>")
    public void UserInformation(String userMail, String userPassword) throws InterruptedException {
        Thread.sleep(2000);
        AssertTitle("Üye Giriş Sayfası & Üye Ol - Hepsiburada");
        SendKeys_Func(By.id("txtUserName"), (userMail));
        SendKeys_Func(By.id("txtPassword"), (userPassword));
        ButtonClick_Func(By.id("btnLogin"));
        System.out.println("Signed in Successfully");
        System.out.println("*** Third Scenario Successful ***");
    }
    @Test
    @Step("Username Control <name>")
    public void controlName(String name) throws InterruptedException {
        Thread.sleep(5000);
        AssertTitle("Türkiye'nin En Büyük Online Alışveriş Sitesi Hepsiburada.com");
        String userName = NameControl(By.xpath("//*[@id=\"myAccount\"]/span/a/span[2]"));
        Thread.sleep(5000);
        System.out.println(userName);
        if(NameResult(name,userName)==true)
            System.out.println("Your username has been successfully matched");
        else
            System.out.println("Your username could not be matched");
        System.out.println("**** The fourth scenario worked successfully ****");
    }
    @Test
    @Step("Sign out")
    public void SignOut() throws InterruptedException {
        Thread.sleep(2000);
        Finish();
        System.out.println("<3 <3 <3 Project Successful Congratulations <3 <3 <3");
        System.out.println("***** Fifth scenario worked successfully *****");

    }
}
