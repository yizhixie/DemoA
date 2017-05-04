package practiceone;
import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class LaunchChrome {
	private static WebDriver chromewb=null;
	private static DesiredCapabilities caps=null;
	private String projectpath = System.getProperty("user.dir");
	@BeforeClass
	public void starChrome(){
		System.setProperty("webdriver.chrome.driver",projectpath+"/tool/chromedriver.exe");
		caps=DesiredCapabilities.chrome();//静态类可以不用new，直接定义就可以了
		//以下是设置安全级别，使得IE浏览器的安全级别与IEDriverServer一致
		//caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		//将IE切换到Inprivate模式，可以避免Cache和cookie缓存的影响，发现因Cache和cookie而导致没有发现新出现的问题
		caps.setCapability("chrome.switches",Arrays.asList("--start-maximized"));
		//caps.setCapability("ignoreZoomSetting",true);
		chromewb =new ChromeDriver(caps);
	}
	@Test
	public void searchOnbaidu(){
		chromewb.get("http://www.baidu.com");//无需证书时，如果没有够没证书呢？？网址会成为不信任的网址。。。。
		//IE怎样承认不信任网址,我们需要添加下行:iewb.get("javascript:document.getElementById('overridelink').click();");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@AfterClass
	public void releaseIEDriver(){
		chromewb.quit();
	}
}
