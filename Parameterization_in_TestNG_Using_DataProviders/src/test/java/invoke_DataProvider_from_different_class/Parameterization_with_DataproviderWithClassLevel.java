package invoke_DataProvider_from_different_class;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;

public class Parameterization_with_DataproviderWithClassLevel 
{
	WebDriver driver;
  @Test(dataProvider="serviceprovider",dataProviderClass=DataproviderClass.class)
  public void Test1(String username,String password,String email) 
  {
	  driver.get("https://www.linkedin.com/");
	  driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
	  driver.findElement(By.xpath("//a[contains(text(),'Join now')]")).click();
	  driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys(username);
	  driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys(password);
	  driver.findElement(By.xpath("//input[@id='join-email']")).sendKeys(email);
  }
  @BeforeTest
  public void beforeTest()
  {
	  System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
	  ChromeOptions option=new ChromeOptions();
	  driver=new ChromeDriver(option);
	  driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest()
  {
	driver.close();  
  }

}
