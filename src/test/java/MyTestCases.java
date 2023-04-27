import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;

public class MyTestCases extends Parameters {
	
	
	
  @Test
  public void check_the_title() {
	  
	  String myActualTitle = driver.getTitle();
	  
	  softAssert.assertEquals(myActualTitle,expectedTitle);
	  softAssert.assertAll();
	  
	  
	  
  }
  
  @Test
  public void checkImageDrawer() {
	  List<WebElement> myImages = driver.findElements(By.className("img-fluid"));
	  
	  boolean myImageCheck1 = myImages.get(0).getAttribute("src")==myImages.get(1).getAttribute("src");
	  boolean myImageCheck2 = myImages.get(1).getAttribute("src")==myImages.get(2).getAttribute("src");
	  boolean myImageCheck3 = myImages.get(2).getAttribute("src")==myImages.get(0).getAttribute("src");
	  
	  softAssert.assertEquals(myImageCheck1, false,"IMAGE 1 WITH 2:: ");
	  softAssert.assertEquals(myImageCheck2, false, "IMAGE 2 WITH 3:: ");
	  softAssert.assertEquals(myImageCheck3, false, "IMAGE 3 WITH 1:: ");


	  softAssert.assertAll();
	  
  }
  
  
  
  @Test(invocationCount = 8)
  public void validate_contact_imfo() throws InterruptedException {
	  
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	  
	  String emails_name [] = {"a1@gmail.net","a9gmail.edu", "uu887@gmail.com", "@gmail.com"};
	  Random email_index = new Random();
	  int index = email_index.nextInt(4);


	  
	  driver.findElement(By.xpath("//*[@id=\"navbarExample\"]/ul/li[2]/a")).click();
	  
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//*[@id=\"recipient-email\"]")).sendKeys(emails_name[index]);
	  Thread.sleep(1000);
	  
	  String myValue = driver.findElement(By.xpath("//*[@id=\"recipient-email\"]")).getAttribute("value");
	  
//	  System.out.println(myValue);
	  
	  
	  System.out.println("*******************");
	  String regex = "^[A-Za-z0-9+_.-]+@(.+)+.(.+)$";
	  Pattern pattern = Pattern.compile(regex);
	  Matcher matcher = pattern.matcher(emails_name[index]);
	  System.out.println(emails_name[index] +" : "+ matcher.matches());
	  System.out.println("*******************");
	  
	  
	  driver.findElement(By.xpath("//*[@id=\"recipient-email\"]")).clear();
	  driver.findElement(By.xpath("//*[@id=\"exampleModal\"]/div/div/div[1]/button/span")).click();
	  
	  boolean my_check_process = matcher.matches();
	  softAssert.assertEquals(my_check_process, true, "EMAIL STRICTURE IS NOT VALID ::");
	  softAssert.assertAll();
	  


	  
  }
  

}
