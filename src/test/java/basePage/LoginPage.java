package basePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {


	//constructor
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	//Locaters
	
	//WebElement username = driver.findElement(By.ID("user-name")).sendKeys("test@123");
	
	@FindBy(id="user-name") 
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="login-button")
	WebElement loginButton;
	
	//Actions
	
	public void setUserName(String user)
	{
		username.sendKeys(user);
	}

	public void setPassword(String pass)
	{
		password.sendKeys(pass);
	}
	
	public void clickLogin()
	{
		loginButton.click();
	}

	
	
	
	
	
}
