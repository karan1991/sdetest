import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
//import javafx.scene.layout.Priority;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;

/**
 * Created by karan.mehndiratta on 04-09-2016.
 */
public class SDWeb {
    Login log;
    Search search1;
    GridView products;
    Pdp buy;
    Review rev;
    Payment pay;
    Cart add;
    Category cat;
    WebDriver wb;
    WebDriverWait wait1;
    Cancel cancel;
    CancelConfirm cancelconfirm;
    ThankYou thanks;
    static String imageName;


    /**
     *The below method will save the screen shot in d drive with name
     * "screenshot.png"
     */

    public static void takeScreenshot(WebDriver wb, String imageName) {
        try {
            File scrFile = ((TakesScreenshot) wb).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File(
                    "src/main/resources/screenshots/" + imageName + "_" + System.currentTimeMillis() + ".png"));

        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }



    @BeforeClass
    public void beforeclass()
    {

        wb = new FirefoxDriver();
        log= PageFactory.initElements(wb, Login.class);
        log.login();
        search1=PageFactory.initElements(wb,Search.class);
        products=PageFactory.initElements(wb,GridView.class);
        buy=PageFactory.initElements(wb,Pdp.class);
        rev=PageFactory.initElements(wb,Review.class);
        pay =PageFactory.initElements(wb,Payment.class);
        add=PageFactory.initElements(wb,Cart.class);
        cat=PageFactory.initElements(wb,Category.class);
        cancel=PageFactory.initElements(wb,Cancel.class);
        cancelconfirm=PageFactory.initElements(wb,CancelConfirm.class);
        thanks=PageFactory.initElements(wb,ThankYou.class);

    }

/*
    @BeforeMethod
    public void beforemethod()
    {
        wb.get("http://www.snapdeal.com/");
    }*/


    /**
     * test case for buying a product after login and searching the  product.
     */
    @Test(priority = 3)
    public void buyflow()
    {
        wb.get("http://www.snapdeal.com/");
        search1.search("intex");
        products.view();
        buy.pdpbuy();
        //rev.review();
        //pay.payment();
        SDWeb.takeScreenshot(wb,"buyflow");
    }

    /**
     * Test case to cancel the bought product
     */
    @Test(priority = 30)
    public void cancel()
    {
        wb.get("http://www.snapdeal.com/");
        cancel.goToOrdersPage();
        cancel.cancelOrder();
        cancelconfirm.cancelConfirmation();
        SDWeb.takeScreenshot(wb,"cancel");
    }


    /**
     * Test case to change the  existing address
     */
    @Test(priority = 4)
    public void changeaddress() {

            wb.get("http://www.snapdeal.com/");
            search1.search("intex");
            products.view();
            buy.pdpbuy();
            rev.changeaddress();
            SDWeb.takeScreenshot(wb,"changeadress");
    }


    /**
     * Test case to buy bundled product.
     */
    @Test (priority = 1)
    public void bundle()
    {
        wb.get("http://www.snapdeal.com/");
        search1.search("i phone 6s");
        products.view();
        buy.pdpbundle();
        buy.pdpbuybundle();
        rev.review();
        SDWeb.takeScreenshot(wb,"bundle");
    }

    /**
     * Test case to check whether product is SD gold or not
     */
   @Test (priority = 2)
    public void sdgold()
    {
        wb.get("http://www.snapdeal.com/");
        search1.search("iphone 6s");
        products.view();
        buy.pdpgold();
        SDWeb.takeScreenshot(wb,"sdgold");

    }

    /**
     * Test case to buy fmcg product.
     */
    @Test (priority = 0)
    public void fmcg()
    {
        wb.get("http://www.snapdeal.com/");
        cat.category();
        products.clickFirstProductFMCG();
        buy.pdpcart();
        add.cart();
        add.continuelink();
        rev.review();
        pay.payment();
        SDWeb.takeScreenshot(wb,"fmcg");
    }

    /*@AfterClass
    public void afterclass()
    {
        wb.close();
    }*/

    @AfterSuite
    public void afterSuite() throws Exception
    {
        try {

            String path = System.getProperty("user.dir")+"\\test-output\\Custom suite\\SDETAutomationAssignment.xml";
            System.out.println(path);

            //test-output\Custom suite  System.getProperty("user.dir")+
            //File fXmlFile = new File("D:\\WebSDETTest2\\SDETAutomationAssignment\\Custom suite\\SDETAutomationAssignment.xml");

            File fXmlFile = new File(path);

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();

            int total = (Integer.valueOf(doc.getDocumentElement().getAttribute("tests")));
            int failed = (Integer.valueOf(doc.getDocumentElement().getAttribute("failures")));
            int passed = total - failed;

            int skipped = (Integer.valueOf(doc.getDocumentElement().getAttribute("failures")));

			/*
			 * System.out.println("Total : " + total); System.out.println(
			 * "Passed : " + passed); System.out.println("Failed : " + failed);
			 * System.out.println("Skipped : " + skipped);
			 */

            String timestamp = doc.getDocumentElement().getAttribute("timestamp");
            String totaltime = doc.getDocumentElement().getAttribute("time");

			/*
			 * System.out.println("timestamp : " + timestamp);
			 * System.out.println("time : " + totaltime);
			 */
            // System.out.println("root element: " +
            // doc.getDocumentElement().getNodeName());
            Node rootNode = doc.getDocumentElement();
            NodeList nList = doc.getElementsByTagName("testcase");

            MongoClient mongo = new MongoClient("localhost", 27017);
            DB db = mongo.getDB("SDET");

            //stem.out.println("Databses :" + db);

            DBCollection table = db.getCollection("abc");
            BasicDBObject document = new BasicDBObject();

            document.put("TimeStamp", timestamp);
            document.put("Total", total);
            document.put("Passed", passed);
            document.put("Failed", failed);
            document.put("Totaltime", totaltime);


            System.out.println("TimeStamp :" + timestamp);
            System.out.println("Total :" + total);
            System.out.println("Passed :" + passed);
            System.out.println("Failed :" + failed);
            System.out.println("Totaltime :" + totaltime);


            table.insert(document);

            for (int i = 0; i < nList.getLength(); i++) {
                DBCollection table1 = db.getCollection("detailed_result");
                BasicDBObject document1 = new BasicDBObject();
                String name = nList.item(i).getAttributes().getNamedItem("name").getNodeValue();
                String time = nList.item(i).getAttributes().getNamedItem("time").getNodeValue();
                document1.put("Time_Stamp", timestamp);

                document1.put("Test_Name", name);
                document1.put("Time_Taken", time);

                table1.insert(document1);

            }

        }
         catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}