package practiceone;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LaunchFF {
	private WebDriver ffwb=null;
	private FirefoxProfile firefoxprofile=null;
	private String projectpath=System.getProperty("user.dir");
	@BeforeClass
	public void startFirefox(){
		System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		File firebug = new File(projectpath+"/tool/firebug@software.joehewitt.com.xpi");
		File firepath = new File(projectpath+"/tool/FireXPath@pierre.tholence.com.xpi");
		firefoxprofile = new FirefoxProfile();
		try {
			//安装firebug和firepath
			firefoxprofile.addExtension(firebug);
			firefoxprofile.addExtension(firepath);
			//绕过证书问题
			firefoxprofile.setPreference("webdriver.accept.unstrusted.certs", "true");
			//实现代理上网
//			firefoxprofile.setPreference("network.proxy.type",0);
//			firefoxprofile.setPreference("network.proxy.http","10.1.1.0");
//			firefoxprofile.setPreference("network.proxy.http_port",3128);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ffwb=new FirefoxDriver(firefoxprofile);
	}
	@Test
	public void searchOnBaidu(){
		ffwb.get("http://www.baidu.com");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@AfterClass
	public void releaseFFDriver(){
		ffwb.quit();
	}
}
