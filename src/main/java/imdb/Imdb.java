package imdb;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Imdb
{

	public By movie_name = By.xpath("//td[contains(@class,'titleColumn')]//a");
	public By imdb_rating = By.xpath("//td[contains(@class,'imdbRating')]/strong");
	public By release_date = By.xpath("//td[contains(@class,'titleColumn')]/span");
	public By orderButton = By.xpath("//span[contains(@title,'order')]");
	public By dropdown = By.xpath("//select[@name='sort']");

	List<WebElement> movie_list;
	static WebDriver driver;
	static WebDriverWait wait;

	//opens browser and navigates to specific URL.
	@BeforeClass
	public void openbrowser() {
		driver = new ChromeDriver();
		wait=new WebDriverWait(driver, 5);
		driver.get("https://www.imdb.com/chart/toptv/?sort=us,desc&mode=simple&page=1");
		driver.manage().window().maximize();
	}

	//	Fetches movie list on release date basis , sorts the data and compares with site's data
	//	changes order in ascending and then performs the same. 
	@Test(priority = 1)
	public void sortbyReleaseDate() {
		List<Integer> movie_year_list = new ArrayList<Integer>();
		List<Integer> movie_year_list_new = new ArrayList<Integer>();
		List<Integer> movie_year_list_asc = new ArrayList<Integer>();
		List<Integer> movie_year_list_asc_new = new ArrayList<Integer>();
		
		
		movie_list = driver.findElements(movie_name);
		Assert.assertEquals(movie_list.size(), 250);
		List<WebElement> movie_year = driver.findElements(release_date);
		List<WebElement> movie_rating = driver.findElements(imdb_rating);
		
		for (int i = 0; i < movie_list.size(); i++) {
			System.out.print(movie_list.get(i).getText() + " " + movie_rating.get(i).getText() + " "
					+ movie_year.get(i).getText());
			System.out.println("");
			movie_year_list.add(Integer.parseInt(movie_year.get(i).getText().replace("(", "").replace(")", "")));
		}
		movie_year_list_new.addAll(movie_year_list);
		Comparator c = Collections.reverseOrder();
		Collections.sort(movie_year_list,c);
		
		
		driver.findElement(orderButton).click();
		List<WebElement> movie_year_asc = driver.findElements(release_date);
		for (int i = 0; i < movie_list.size(); i++) {
			movie_year_list_asc
					.add(Integer.parseInt(movie_year_asc.get(i).getText().replace("(", "").replace(")", "")));
		}
		movie_year_list_asc_new.addAll(movie_year_list_asc);
		Collections.sort(movie_year_list_asc);
		
		
		SoftAssert softassert= new SoftAssert();
		softassert.assertEquals(movie_year_list_new, movie_year_list);
		softassert.assertEquals(movie_year_list_asc_new, movie_year_list_asc);
		softassert.assertAll();
	}
	
	//	Fetches movie list on rating basis , sorts the data and compares with site's data
	//	changes order in ascending and then performs the same. 
	@Test(priority = 2)
	public void sortbyRating() {
		List<Float> movie_imdb_list = new ArrayList<Float>();
		List<Float> movie_imdb_list_new = new ArrayList<Float>();
		List<Float> movie_imdb_list_asc = new ArrayList<Float>();
		List<Float> movie_imdb_list_asc_new = new ArrayList<Float>();


		Select imdbrating = new Select(driver.findElement(dropdown));
		imdbrating.selectByVisibleText("IMDb Rating");

		List<WebElement> movie_rating_new = driver.findElements(imdb_rating);
		for (int i = 0; i < movie_list.size(); i++) {
			movie_imdb_list.add(Float.parseFloat(movie_rating_new.get(i).getText()));
		}
		movie_imdb_list_new.addAll(movie_imdb_list);
		Comparator c = Collections.reverseOrder();
		Collections.sort(movie_imdb_list,c);
		

		driver.findElement(orderButton).click();

		List<WebElement> movie_imdb_asc = driver.findElements(imdb_rating);
		for (int i = 0; i < movie_list.size(); i++) {
			movie_imdb_list_asc.add(Float.parseFloat(movie_imdb_asc.get(i).getText()));
		}
		movie_imdb_list_asc_new.addAll(movie_imdb_list_asc);
		Collections.sort(movie_imdb_list_asc);
		
		Assert.assertEquals(movie_imdb_list_new, movie_imdb_list);
		Assert.assertEquals(movie_imdb_list_asc_new, movie_imdb_list_asc);
		
	}
	@AfterClass
	public void quitbrowser(){
		driver.quit();
	}
}
