import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

/**
 * Created by karan.mehndiratta on 03-09-2016.
 */
public class Search {

    WebDriver wb;
    public Search(WebDriver wb)
    {
        this.wb=wb;
    }

    @FindBy(id="inputValEnter")
    WebElement searchbox;

    @FindBy(xpath=".//*[@id='sdHeader']/div[4]/div[2]/div/div[2]/div[3]/div/div/ul/li[3]/a")
    WebElement phone;


    public void search(String abc)
    {
        WebDriverWait wait = new WebDriverWait(wb, 30);

        wait.until(ExpectedConditions.visibilityOf(searchbox));
        searchbox.sendKeys(abc);

        wait.until(ExpectedConditions.visibilityOf(phone));
        phone.click();

    }
}