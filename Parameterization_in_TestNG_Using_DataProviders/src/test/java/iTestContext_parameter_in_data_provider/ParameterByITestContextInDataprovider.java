package iTestContext_parameter_in_data_provider;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;

public class ParameterByITestContextInDataprovider 
{
 
	
	WebDriver driver;
	
	@BeforeTest(groups={"A","B"})
	  public void beforeTest()
	  {
		  System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		  ChromeOptions option=new ChromeOptions();
		  driver=new ChromeDriver(option);
		  driver.manage().window().maximize();
	  }
	
	
	  @Test(dataProvider = "serviceprovider",groups="A")
	  public void Test1(String username,String password,String email) 
	  {
		  driver.get("https://www.linkedin.com/");
		  driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		  driver.findElement(By.xpath("//a[contains(text(),'Join now')]")).click();
		  driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys(username);
		  driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys(password);
		  driver.findElement(By.xpath("//input[@id='join-email']")).sendKeys(email);
	  }
	  
	  
	  @Test(dataProvider = "serviceprovider",groups="B")
	  public void Test2(String username,String password,String email) 
	  {
		  driver.get("https://www.linkedin.com/");
		  driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		  driver.findElement(By.xpath("//a[contains(text(),'Join now')]")).click();
		  driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys(username);
		  driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys(password);
		  driver.findElement(By.xpath("//input[@id='join-email']")).sendKeys(email);
	  }

	  @DataProvider(name="serviceprovider")
	  public Object[][] dp(ITestContext c) 
	  {
		  
		  Object[][] grouparray=null;
		  
		  for(String group : c.getIncludedGroups())
		  {
			  if(group.equalsIgnoreCase("A"))
			  {
				  grouparray=new Object[][]
						  {
								  	{ "deshan1","deshan1@123","deshan1@gmail.com" },
									{ "deshan2","deshan2@123","deshan2@gmail.com" },
									{ "deshan3","deshan3@123","deshan3@gmail.com" },
						  };
						  
						  break;
			  }
			  else
			  {
				  if(group.equalsIgnoreCase("B"))
				  {
					  grouparray=new Object[][]
							  {
								    { "desone1","desone1@123","desone1@gmail.com" },
									{ "desone2","desone2@123","desone2@gmail.com" },
									{ "desone3","desone3@123","desone3@gmail.com" },
							  };
				  }
		
			  }
		  }
		  
		return grouparray;
	  }
  

  @AfterTest
  public void afterTest()
  {
	driver.close();  
  }

}
