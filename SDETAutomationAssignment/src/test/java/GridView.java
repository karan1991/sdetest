import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by karan.mehndiratta on 04-09-2016.
 */
public class GridView {
    WebDriver  wb;
    WebDriverWait wait;
    public GridView(WebDriver wb)
    {
        this.wb=wb;
    }

    @FindBy(xpath = ".//*[@id='666936671806']/div[2]/a/img")
    WebElement categ_cart;

    @FindBy(xpath = "//div[2]/a/picture/img")
    WebElement carts;

    @FindBy(xpath=".//*[@id='662450412735']/div[2]/a/picture/img")
    WebElement FMCGProduct;

    @FindBy(xpath = ".//*[@id='632196066996']/div[2]/a/img")
    WebElement gold;

    public void view()
    {
        wait=new WebDriverWait(wb,50);
        wait.until(ExpectedConditions.visibilityOf(carts));

        carts.click();
    }

    public void clickFirstProductFMCG()
    {
        wait=new WebDriverWait(wb, 30);
        wait.until(ExpectedConditions.visibilityOf(FMCGProduct));
        FMCGProduct.click();

    }


    public void viewcat()
    {
        wait=new WebDriverWait(wb,50);
        wait.until(ExpectedConditions.visibilityOf(categ_cart));

        categ_cart.click();
    }

    public void viewgold()
    {
        wait=new WebDriverWait(wb,4);
        wait.until(ExpectedConditions.visibilityOf(gold));
        gold.click();
    }
}
