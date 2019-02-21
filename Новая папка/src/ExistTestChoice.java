import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.By.ByName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;



@RunWith(Parameterized.class)

public class ExistTestChoice {
	public static WebDriver drv = null;
	private static int testCount = 15;
	
	private int count = 1;

	private void init(int perem) {
		switch (perem) {
		case 1: {
			System.setProperty("webdriver.chrome.driver", "/Users/ilyascholokov/Downloads/libs/chromedriver");
			drv = new ChromeDriver();
			break;
		}
		case 2: {
			System.setProperty("webdriver.opera.driver", "/Users/ilyascholokov/Downloads/libs/operadriver");
			drv = new OperaDriver();
			break;
		}
//		case 3: {
//			System.setProperty("webdriver.safari.driver", "/Users/ilyascholokov/Downloads/libs/safaridriver");
//			drv = new SafariDriver();
//			break;
//		}
//      case 4: {
//			System.setProperty("webdriver.firefox.driver", "/Users/ilyascholokov/Downloads/libs/geckodriver");
//		FirefoxOptions capabilities = new FirefoxOptions();
//		capabilities.setCapability("marionette", true);
//		  drv = new FirefoxDriver();
//			break;
//		}
		
		}
		
          drv.get("https://sprex24.github.io/");
		//drv.get("file:///Users/ilyascholokov/Desktop/testjs/source.html");

	}

	public ExistTestChoice(int perem) {
		if (count == 1) {
			init(perem);
		}
	}

	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][] { { 1 }, { 2 }};      // { 3 }, { 4 } };
		return Arrays.asList(data);
	}

	@After
	public void counter() {
		count++;
		if (count > testCount) {
			count = 1;
		}
		drv.close();
		drv.quit();
	}


	@Before
	public void refresh() {
		drv.navigate().refresh();
	}

	@Test

	public void test01() {
		String exp = "1";
		drv.findElement(ById.id("myInput")).sendKeys("a");
		drv.findElement(By.className("addBtn")).click();
		String act = drv.findElement(ByName.name("result")).getText();
		assertEquals(exp, act);

	}

	@Test

	public void test02() {
		String exp = "2";
		drv.findElement(ById.id("myInput")).sendKeys("aAa");
		drv.findElement(By.className("addBtn")).click();
		String act = drv.findElement(ByName.name("result")).getText();
		assertEquals(exp, act);
	}

	

	@Test

	public void test03() {
		String exp = "3";
		drv.findElement(ById.id("myInput")).sendKeys("aAaAa");
		drv.findElement(By.className("addBtn")).click();
		String act = drv.findElement(ByName.name("result")).getText();
		assertEquals(exp, act);
	}

	
	@Test

	public void test10() {
		String exp = "45";
		String word= " ";
		for (int i = 1; i < 10; i++) {
		    word+="a";
			drv.findElement(ById.id("myInput")).sendKeys(word);
			drv.findElement(By.className("addBtn")).click();
		}

		String act = drv.findElement(ByName.name("result")).getText();
		assertEquals(exp, act);

	}

	
	//realjob===========
/*	
	@Test
	public void test20() {
		String exp = "999999";
			drv.findElement(ById.id("butt6")).click();
			drv.findElement(ById.id("butt6")).click();
			drv.findElement(ById.id("butt6")).click();
			drv.findElement(ById.id("butt6")).click();
			drv.findElement(ById.id("butt6")).click();
			drv.findElement(ById.id("butt6")).click();
			
			
			drv.findElement(ById.id("butt+")).click();
			
			
			drv.findElement(ById.id("butt3")).click();
			drv.findElement(ById.id("butt3")).click();
			drv.findElement(ById.id("butt3")).click();
			drv.findElement(ById.id("butt3")).click();
			drv.findElement(ById.id("butt3")).click();
			drv.findElement(ById.id("butt3")).click();
		
			drv.findElement(ById.id("butt=")).click();
		String act = drv.findElement(ById.id("answ")).getAttribute("value");
		assertEquals(exp, act);
	}
	*/
	
	
}
