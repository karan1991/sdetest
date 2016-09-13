import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by karan.mehndiratta on 04-09-2016.
 */
public class Cancel
{
    WebDriver wb;
    WebDriverWait wait;

    @FindBy(id="requestProcessStatus")
    WebElement requestProcessStatus;

    @FindBy(xpath = "//*[@id='cancellationReasonsNonCOD']/div[1]")
    WebElement cancel_dropdown;

    @FindBy(xpath = "//*[@id='sdPopup']/div[4]")
    WebElement cancel_reason;

    @FindBy(xpath = "//*[@id='sdHeader']/div[4]/div[2]/div/div[3]/div[3]/div/span[2]")
    WebElement account_tab;

    @FindBy(xpath = ".//*[@id='sdHeader']//li/a[1]")
    WebElement open_ordersPage;

    @FindBy(id = "submitCancellationCOD")
    WebElement cancel_button;

    public Cancel(WebDriver wb)
    {
        this.wb=wb;
    }

    public void goToOrdersPage()
    {
        wait = new WebDriverWait(wb,30);
        wait.until(ExpectedConditions.visibilityOf(account_tab));
        account_tab.click();
        wait.until(ExpectedConditions.visibilityOf(open_ordersPage));
        open_ordersPage.click();

    }

    public void cancelOrder() {
        wait = new WebDriverWait(wb, 5);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span/div[1]/span[1]/a/span")));
        wb.findElement(By.xpath("//span/div[1]/span[1]/a/span")).click();

        wait.until(ExpectedConditions.visibilityOf(cancel_dropdown));
        cancel_dropdown.click();

        wait.until(ExpectedConditions.visibilityOf(cancel_reason));
        cancel_reason.click();

        wait.until(ExpectedConditions.visibilityOf(cancel_button));
        cancel_button.click();
    }
}
