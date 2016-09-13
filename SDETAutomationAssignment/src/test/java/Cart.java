import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by karan.mehndiratta on 04-09-2016.
 */
public class Cart {
    WebDriver wb;
    WebDriverWait wait;


    @FindBy(xpath ="//span[@class='cartTextSpan']")
    WebElement cart;

    @FindBy(xpath="//div[contains(@class,'item-quantity customized')]")
    WebElement quantitydropdown;

    @FindBy(xpath="//div[26]/ul/li[2]")
    WebElement selectquantity;

    @FindBy(id="checkout-continue")
    WebElement checkout;

    String shoppingCartHeadingXpath=".//*[@id='cartModal']//div[@class='cart-heading clearfix']/h3";
    String shoppingCardCloseXpath=".//span[@class='icon-font-grey-size24 close-popup-icon']/i";

    public Cart(WebDriver wb)
    {
        this.wb=wb;
    }

    public void cart()
    {
        wait=new WebDriverWait(wb,30);

        wait.until(ExpectedConditions.visibilityOf(cart));
        cart.click();

        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(shoppingCartHeadingXpath)));
            if(wb.findElement(By.xpath(shoppingCartHeadingXpath)).getText().contains("Shopping Cart is empty")){
                wb.findElement(By.xpath(shoppingCardCloseXpath)).click();

                wait.until(ExpectedConditions.visibilityOf(cart));
                cart.click();
            }
        }catch (Exception e){

        }

    }

    public void increaseQuantity()
    {
        wait=new WebDriverWait(wb, 30);
        wait.until(ExpectedConditions.visibilityOf(quantitydropdown));

        String id = quantitydropdown.getAttribute("id");
        quantitydropdown.click();

        selectquantity = wb.findElement(By.xpath(".//ul[@data-cs='"+id+"']/li[2]"));
        wait.until(ExpectedConditions.visibilityOf(selectquantity));

        selectquantity.click();
    }

    public void continuelink()
    {
        wait=new WebDriverWait(wb, 30);

                /*try {

                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("./*//*[@id='cartModal']/div[2]/div/section/div/div[1]/span/i")));
                    wb.findElement(By.xpath("./*//*[@id='cartModal']/div[2]/div/section/div/div[1]/span/i")).click();

                    //wait.until(ExpectedConditions.visibilityOf(cart));
                    //cart.click();
                } catch(Exception e){
                    wait.until(ExpectedConditions.visibilityOf(cart));
                    cart.click();
                }*/
                wait.until(ExpectedConditions.visibilityOf(quantitydropdown));
                String id = quantitydropdown.getAttribute("id");
                quantitydropdown.click();
                selectquantity = wb.findElement(By.xpath(".//ul[@data-cs='"+id+"']/li[2]"));
                wait.until(ExpectedConditions.visibilityOf(selectquantity));
                selectquantity.click();

                //wait.until(ExpectedConditions.visibilityOf(checkout));
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//*[@class='cart-overlay loader-wrapper']")));
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='searcharea-overlay']")));
                checkout.click();
            }




    }
