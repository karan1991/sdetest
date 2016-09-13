import com.thoughtworks.selenium.Selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

/**
 * Created by karan.mehndiratta on 03-09-2016.
 */
 public class Login {
    WebDriver wb;
    WebDriverWait wait;

    public Login(WebDriver wb)
    {
        this.wb=wb;
    }



    @FindBy(xpath ="//*[@id='sdHeader']/div[4]/div[2]/div/div[3]/div[3]/div/span[2]/i" )
    WebElement account;

    @FindBy(xpath = "//span[contains(@class,'accountBtn')]")
    WebElement loginaccount;

    @FindBy(id="userName")
    WebElement username;

    @FindBy(id="checkUser")
    WebElement checkuser;

    @FindBy(id="j_password_login_uc")
    WebElement password;

    @FindBy(id="submitLoginUC")
    WebElement submit;

    public void login()
    {

        wait = new WebDriverWait(wb,30);

        wb.get("http://www.snapdeal.com/");
        wb.manage().window().maximize();


        account.click();
        loginaccount.click();

        wb.switchTo().frame("loginIframe");

        wait.until(ExpectedConditions.visibilityOf(username));
        username.sendKeys("shwetasahni09@gmail.com");
        checkuser.click();

        wait.until(ExpectedConditions.visibilityOf(password));
        password.sendKeys("harshil@99");
        submit.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
