package properties;

import junit.framework.Assert;
import launch.Browsers;
import launch.BrowsersType;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class XpathProperties {
	public static WebDriver ffwb=null;
	private FirefoxProfile firefoxprofile=null;
	private String projectpath=System.getProperty("user.dir");
	
	private ParseProperties data;
	private ParseProperties locator;
	private Wait wait;
	
	@Parameters({"data","locator"})
	@BeforeClass
	public void startFirefox(String da,String loc){
		data = new ParseProperties(projectpath+da);
		locator = new ParseProperties(projectpath+loc);
		Browsers browser=new Browsers(BrowsersType.firefox);
		ffwb=browser.driver;
		wait=new Wait(ffwb);
	}
	
	@Test
	public void accessMail(){
		
		
		ffwb.get(data.getValue("url"));
		ffwb.findElement(By.xpath(locator.getValue("username"))).clear();
		ffwb.findElement(By.xpath(locator.getValue("username"))).sendKeys(data.getValue("username"));
		ffwb.findElement(By.xpath(locator.getValue("password"))).sendKeys(data.getValue("password"));
		ffwb.findElement(By.xpath(locator.getValue("submit"))).click();
		
		wait.waitForElementPresent(locator.getValue("homepage"));
		Assert.assertEquals(ffwb.findElement(By.xpath(locator.getValue("sendbox"))).isDisplayed(), true);
		wait.waitFor(10000);
	}
}
