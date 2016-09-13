import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by karan.mehndiratta on 04-09-2016.
 */
public class Pdp
{
    WebDriver wb;
    WebDriverWait wait;

    String text="Upgrade order to Snapdeal Gold";
    public Pdp(WebDriver wb)
    {
        this.wb=wb;
    }

    @FindBy(id="buy-button-id")
    WebElement button;

    @FindBy(id="add-cart-button-id")
    WebElement addcart;

    @FindBy(xpath=".//*[@id='pdp-pincode-rp']/div[3]/div/div[6]/i")
    WebElement sdgold;

    @FindBy(name="email")
    WebElement uname;

    @FindBy(xpath = ".//*[@id='softBundleDiv']/div[1]")
    WebElement bundle;

    @FindBy(xpath=".//li[@attrid='Silver']")
    WebElement color;

    @FindBy(xpath = "//*[@id='attribute-select-0']/ul/li[1]")
    WebElement productAttribute;

    public void pdpbuy()
    {

            wait = new WebDriverWait(wb, 30);
            wait.until(ExpectedConditions.visibilityOf(button));
            wait.until(ExpectedConditions.elementToBeClickable(button));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='searcharea-overlay']")));
            button.click();
    }

    public void pdpbuybundle() {

        try {
            wait = new WebDriverWait(wb, 30);

            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_PAGE_UP);
            robot.keyRelease(KeyEvent.VK_PAGE_UP);
            System.out.println("bjhhjvbhj");

        }catch (Exception e)
        {
            System.out.println("bjhbhj");
            e.printStackTrace();
        }
        wait.until(ExpectedConditions.visibilityOf(button));
        wait.until(ExpectedConditions.elementToBeClickable(button));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='searcharea-overlay']")));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout-continue"))).click();
        button.click();
    }



    public void pdpcart()
    {
        wait =new WebDriverWait(wb,30);
        wait.until(ExpectedConditions.visibilityOf(addcart));
        addcart.click();
    }
    public void pdppin()
    {
        wait=new WebDriverWait(wb,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pincode-check")));
        wb.findElement(By.id("pincode-check")).sendKeys("124001");
        wb.findElement(By.id("pincode-check-bttn")).click();
    }
    public void pdpgold()
    {
        wait=new WebDriverWait(wb,30);
        try
        {
            wait.until(ExpectedConditions.visibilityOf(sdgold));
            System.out.println("sd gold it is");
        } catch (Exception e)
        {
            System.out.println("not sd gold");
        }

    }

    public void pdpbundle()
    {
        try {
            wait= new WebDriverWait(wb,30);

            wait.until(ExpectedConditions.elementToBeClickable(button));
            wait.until(ExpectedConditions.visibilityOf(bundle));
            bundle.click();

        }catch (Exception e)
        {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("searcharea-overlay")));
            bundle.click();
        }

    }

    public void buylogin()
    {
        wait=new WebDriverWait(wb,20);
        wait.until(ExpectedConditions.visibilityOf(uname));
        uname.sendKeys("shwetasahni09@gmail.com");
        wb.findElement(By.id("login-continue")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("w_password")));
        wb.findElement(By.id("w_password")).sendKeys("harshil@99");
        wb.findElement(By.id("login-done")).click();


    }
    public void pdpdeliver()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='confirm-address']/div[6]/ul/li[1]/div/div[1]/div[2]/div/span")));
        wb.findElement(By.xpath(".//*[@id='confirm-address']/div[6]/ul/li[1]/div/div[1]/div[2]/div/span")).click();
    }
}
