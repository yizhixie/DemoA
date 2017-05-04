package groups;

import launch.Browsers;
import launch.BrowsersType;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MultipleBrowsers {
	private Browsers browser=null;
	private WebDriver driver=null;
	
	@Parameters({"platform"})//通过Parameter传参数，实现了数据与代码的分离，便于管理
	@BeforeMethod(groups="browsers")
	/**
	 * 选择浏览器，并打开它
	 */
	public void inital(String platform){
		if(platform.equals("FF"))
			browser=new Browsers(BrowsersType.firefox);
		else if(platform.equals("chrome"))
			browser=new Browsers(BrowsersType.chrome);
		else
			browser=new Browsers(BrowsersType.ie);
		
		driver=browser.driver;
	}
	@Test(groups=("submodule1"))
	public void testSubModule1(){
		driver.get("http://www.baidu.com");
		System.out.println("---testSubModule1---");
	}
	@Test(groups=("submodule2"))
	public void testSubModule2(){
		driver.get("http://www.bing.com");
		System.out.println("---testSubModule2---");
	}
	@Test(groups=("submodule3"))
	public void testSubModule3(){
		driver.get("http://www.360.com");
		System.out.println("---testSubModule3---");
	}
	@Test(groups=("submodule4"))
	public void testSubModule4(){
		driver.get("http://www.so.com");
		System.out.println("---testSubModule4---");
	}
	@AfterMethod(groups="browsers")
	public void release(){
		driver.quit();
	}
}
