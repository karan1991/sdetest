import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by karan.mehndiratta on 04-09-2016.
 */
public class Category {
    WebDriver wb;
    WebDriverWait wait;
    public Category(WebDriver wb)
    {
        this.wb = wb;
    }

    @FindBy(xpath =".//*[@id='leftNavMenuRevamp']/div[1]/div[2]/ul/li[10]/a/span" )
    WebElement cat;

    @FindBy(xpath="//*[@id='category9Data']/div[3]/div/div/p[9]/a/span")
    WebElement dailyneed;

    public void category()
    {
        wait= new WebDriverWait(wb,30);

        wait.until(ExpectedConditions.visibilityOf(cat));
        cat.click();

        wait.until(ExpectedConditions.visibilityOf(dailyneed));
        dailyneed.click();

    }

}
