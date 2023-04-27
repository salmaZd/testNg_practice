import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Parameters {

	public WebDriver driver;
	String myURL = "https://www.demoblaze.com/index.html#";
	SoftAssert softAssert = new SoftAssert();
	String expectedTitle = "STORE";

	
	@BeforeTest
	  public void beforeTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(myURL);
		
	  }
	
	
	

}
