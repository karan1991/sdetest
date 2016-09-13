import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by karan.mehndiratta on 04-09-2016.
 */
public class CancelConfirm {

        WebDriver wb;
        WebDriverWait wait;

        @FindBy(id ="requestProcessStatus")
        WebElement requestProcessStatus;

        public CancelConfirm(WebDriver wb)
        {
        this.wb = wb;
        }

    public void cancelConfirmation()
    {
        wait = new WebDriverWait(wb,5);

        wait.until(ExpectedConditions.visibilityOf(requestProcessStatus));
        System.out.println(requestProcessStatus.getText());

    }
}
