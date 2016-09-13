import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by karan.mehndiratta on 04-09-2016.
 */
public class ThankYou {

    WebDriver wb;
    WebDriverWait wait;

    @FindBy(className = "alert-text")
    WebElement Order_ID;

    public  ThankYou(WebDriver wb)
    {
        this.wb=wb;
    }

    public void getOrderID() {
        wait = new WebDriverWait(wb, 5);

        wait.until(ExpectedConditions.visibilityOf(Order_ID));
        System.out.println(Order_ID.getText());
    }
}
