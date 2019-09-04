package Parameterization_in_TestNG_Using_DataProviders;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;

public class Demo_DataProviders 
{
	WebDriver driver;
  @Test(dataProvider = "serviceProvider")
  public void Test1(String username, String password,String email) 
  {
	  driver.get("https://www.linkedin.com/");
	  driver.findElement(By.xpath("//a[contains(text(),'Join now')]")).click();
	  driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys(username);
	  driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys(password);
	  driver.findElement(By.xpath("//input[@id='join-email']")).sendKeys(email);
  }

  @DataProvider(name="serviceProvider")
  public Object[][] dp() 
  {
    return new Object[][] 
    {
       {"deshan1", "deshan@123" , "deshan1@gmail.com" },
       {"deshan2", "deshan@456" , "deshan2@gmail.com" },
       {"deshan3", "deshan@789" , "deshan3@gmail.com"},
    };
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
