package invoke_DataProvider_from_different_class;


import org.testng.annotations.DataProvider;

public class DataproviderClass 
{
  
  @DataProvider(name="serviceprovider")
  public Object[][] Dateprovide() 
  {
    return new Object[][] 
    		{
    			{ "deshan1","deshan1@123","deshan1@gmail.com" },
    			{ "deshan2","deshan2@123","deshan2@gmail.com" },
    			{ "deshan3","deshan3@123","deshan3@gmail.com" },
    			
    		};
  }
}
