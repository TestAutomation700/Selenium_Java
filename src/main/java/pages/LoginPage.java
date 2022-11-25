package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.seleniumframework.demo.TestBase;

public class LoginPage extends TestBase {

    WebDriverWait wait;
    
	By userid = By.xpath("//*[@type='email']");
	By next = By.xpath("//*[text()='Next']");
	By password = By.xpath("//*[@type='password']");
	

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement user() {
		return driver.findElement(userid);
	}
	public WebElement pass() {
		return driver.findElement(password);
	}
	public WebElement clickNext() {
		return driver.findElement(next);
	}
	
	public void entercred() throws Exception {
		LoginPage login = new LoginPage(driver);
		login.user().sendKeys(propLoad().getProperty("username"));
		login.clickNext().click();
		wait = new WebDriverWait(driver,10);
		takeSnapShot(driver,"C://Users//0035G3744//Desktop//Screenshots//test.jpeg");
		try {
		wait.until(ExpectedConditions.visibilityOf(login.pass()));	
		login.pass().sendKeys(propLoad().getProperty("passkey"));
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			tearDown();
		}
		
	}
}
