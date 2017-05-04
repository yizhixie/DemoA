package iframe;

import java.util.List;

import junit.framework.Assert;
import launch.Browsers;
import launch.BrowsersType;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import properties.ParseProperties;
import properties.Wait;

public class IFrameSwitch implements Locators{
	public static WebDriver ffwb=null;
	private String projectpath=System.getProperty("user.dir");
	
	private ParseProperties data;
	private ParseProperties locator;
	private Wait wait;
	
	@Parameters({"data","locator"})
	@BeforeClass
	public void startFirefox(@Optional("sss") String da,@Optional("sss") String loc){
		data = new ParseProperties(projectpath+da);
		locator = new ParseProperties(projectpath+loc);
		Browsers browser=new Browsers(BrowsersType.firefox);
		ffwb=browser.driver;
		wait=new Wait(ffwb);
	}
	
	@Test
	public void changeIFrame(){
		ffwb.get(data.getValue("url"));
		wait.waitForElementPresent(JQUERYHOME);
		ffwb.switchTo().frame(ffwb.findElement(By.xpath(SLIDERIFRAME)));
		Point initialPoint =ffwb.findElement(By.xpath(SLIDER)).getLocation();
		System.out.println(initialPoint);
		
		Actions dragger=new Actions(ffwb);
		dragger.dragAndDropBy(ffwb.findElement(By.xpath(SLIDER)), initialPoint.getX()+450, initialPoint.getY()).build().perform();
		initialPoint = ffwb.findElement(By.xpath(SLIDER)).getLocation();
		System.out.println(initialPoint);
		wait.waitFor(5000);
		ffwb.switchTo().defaultContent();
		ffwb.findElement(By.xpath(DRAGGABLE)).click();
		wait.waitFor(3000);
	}
	
	@Test
	public void selectItemFromDropDownList(){
		//登录京东官方网站
		ffwb.get("http://www.jd.com");
		wait.waitForElementPresent(".//*[@id='ttbar-login']/a[1]");
		ffwb.findElement(By.xpath(".//*[@id='ttbar-login']/a[1]")).click();
		//填写用户信息
		wait.waitForElementPresent(".//*[@id='content']/div/div[1]/div/div[2]/a");
		ffwb.findElement(By.xpath(".//*[@id='content']/div/div[1]/div/div[2]/a")).click();
		ffwb.findElement(By.xpath(".//*[@id='loginname']")).sendKeys("787044500@qq.com");
		ffwb.findElement(By.xpath(".//*[@id='nloginpwd']")).sendKeys("fengg20138456");
		ffwb.findElement(By.xpath(".//*[@id='loginsubmit']")).click();
		//登录个人信息
		ffwb.findElement(By.xpath("我的信息")).click();
		ffwb.findElement(By.xpath("账号信息")).click();
		//选择北京作为province
		Select province=new Select(ffwb.findElement(By.xpath("")));
		province.selectByVisibleText("北京");
		wait.waitFor(5000);
		//打印下拉框中所有的区域
		Select city = new Select(ffwb.findElement(By.xpath("")));
		List<WebElement> allcitys = city.getOptions();
		for(WebElement eachcity:allcitys){
			System.out.println(eachcity.getText());
		}	
	}
	@Test
	public void changeWindows(){
		ffwb.get("http://baidu.com");
		ffwb.findElement(By.xpath(".//*[@id='kw']")).sendKeys("selenium");
		ffwb.findElement(By.xpath(".//*[@id='su']")).submit();
		ffwb.findElement(By.xpath(".//*[@id='1']/h3/a[1]")).click();
		Switch switchW=new Switch(ffwb);
		switchW.toSpecificWindow("Web Browser Automation");
		ffwb.findElement(By.xpath("")).click();	
	}
	@Test
	public void mouseRightclickContext(){
		ffwb.get("http://www.126.com");
		ffwb.findElement(By.xpath("")).clear();
		ffwb.findElement(By.xpath("")).sendKeys("");
		ffwb.findElement(By.xpath("")).sendKeys("");
		ffwb.findElement(By.xpath("")).click();
		wait.waitFor(5000);
		Actions actions=new Actions(ffwb);
		actions.contextClick(ffwb.findElement(By.xpath(""))).build().perform();
		wait.waitFor(2000);
		ffwb.findElement(By.xpath("")).click();
		wait.waitFor(2000);
		Assert.assertEquals(ffwb.findElement(By.xpath("")).isDisplayed(), true);
	}
	@Test
	public void dragAndDrop(){
		ffwb.get("http://yixun.com");
		Point shanghai=ffwb.findElement(By.xpath("")).getLocation();
		System.out.println(shanghai);
		((JavascriptExecutor) ffwb).executeScript("window.scrollBy("+shanghai.getX()+","+shanghai.getY()+")");
		wait.waitFor(5000);
	}
	@Test
	public void dragAndDrop2(){
		ffwb.get("http://reg.163.com/agreement.shtml");
		int numberOfPixelsToDragTheScrollbarDown=5000;
		Actions dragger=new Actions(ffwb);
		dragger.moveToElement(ffwb.findElement(By.xpath(""))).clickAndHold().moveByOffset(0, numberOfPixelsToDragTheScrollbarDown);
		wait.waitFor(5000);
	}
	
	
}

