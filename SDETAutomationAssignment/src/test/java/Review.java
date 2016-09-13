import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by karan.mehndiratta on 03-09-2016.
 */
public class Review {

    WebDriver wb;
    WebDriverWait wait;
   public Review(WebDriver wb)
   {

       this.wb=wb;
   }
    @FindBy(id="make-payment")
    WebElement makepayment;

    @FindBy(xpath="//*[@id='addr2Info']/span")
    WebElement adress;

    @FindBy(xpath ="//input[@name='fullName']")
    WebElement name;

    @FindBy(xpath =".//*[@id='confirm-address']/div[6]/ul/li[1]/div/div[2]/div[1]/span")
    WebElement ripple;

    @FindBy(id ="address" )
    WebElement myaddress;

    @FindBy(xpath = ".//*[@id='shipping-address-form']/div/div[10]/div/div[2]/label/span[1]")
    WebElement check;

    @FindBy(name="email")
    WebElement uname;

    @FindBy(id="delivery-modes-continue")
    WebElement delmode;


    public void review()
    {
        wait= new WebDriverWait(wb,30);
        wait.until(ExpectedConditions.visibilityOf(makepayment));
        makepayment.click();
    }


    public void changeaddress()
    {
        wait=new WebDriverWait(wb,30);
        wait.until(ExpectedConditions.visibilityOf(adress));
        adress.click();

        wait.until(ExpectedConditions.visibilityOf(ripple));
        System.out.println("Reached to ripple : " + ripple.toString());
        ripple.click();

        wait.until(ExpectedConditions.visibilityOf(name));
        name.clear();
        name.sendKeys("karn mehndiratta");
        myaddress.clear();
        myaddress.sendKeys("604/23\n" + "DLF colony");
        //check.click();
        delmode.click();
    }



}