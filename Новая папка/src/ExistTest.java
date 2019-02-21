import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.By.ByName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExistTest {
	public static WebDriver drv;
	
@BeforeClass
public static void startDriver() {
	System.setProperty("webdriver.chrome.driver", "/Users/ilyascholokov/Downloads/libs/chromedriver");
	  drv = new ChromeDriver();
	  drv.get("https://sprex24.github.io/");
	  
}

@AfterClass
   public static void quit() {
	drv.quit();
	
}

@Before
public void refresh() 
{
	drv.navigate().refresh();
	}


	@Test
	//проверка работы инпута
	 public void test1() {
	  String exp = "qwerty";
	  drv.findElement(ById.id("myInput")).sendKeys("qwerty");
	  String act = drv.findElement(ById.id("myInput")).getAttribute("value");
	  
	  assertEquals(exp, act);
	  
	 }
	
	@Test
	 public void test2() {
		//проверка пустого ввода
		  String exp = null;
		  String act = drv.findElement(ByName.name("result")).getAttribute("value");
		  
		  assertEquals(exp, act);
		  //assertTrue(act == exp || act.isEmpty());
		 }
	
	

}
