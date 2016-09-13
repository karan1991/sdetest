import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by karan.mehndiratta on 03-09-2016.
 */
public class Payment {
    WebDriver wb;
    WebDriverWait wait;
    public Payment(WebDriver wb)
    {

        this.wb=wb;
    }

    @FindBy(xpath = "//*[@id='payment-nav-id']/div[5]/span")
    WebElement cashondel;

    @FindBy(id="make-payment-button")
    WebElement  placeorder;

    public void payment()
    {
        wait= new WebDriverWait(wb,50);

        wait.until(ExpectedConditions.visibilityOf(cashondel));
        cashondel.click();

        wait.until(ExpectedConditions.visibilityOf(placeorder));
        placeorder.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
