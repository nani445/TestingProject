package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import basePage.LoginPage;

public class LoginTest extends BaseClass {
	 @Test
	  public void testLogin() 
	  {
		  LoginPage lp = new LoginPage(driver);
		  lp.setUserName("standard_user");
		  lp.setPassword("secret_sauce");
		  lp.clickLogin();
		  
		  Assert.assertEquals(true, true);
	  }
	  
	 

	
	
	
	
	
	
	
	
}
