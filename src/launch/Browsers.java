package launch;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Browsers {
	public WebDriver driver=null;
	public FirefoxProfile firefoxprofile=null;
	public static DesiredCapabilities caps=null;
	public String projectpath = System.getProperty("user.dir");
	
	public Browsers(BrowsersType browserstype){
		switch(browserstype){
		case firefox:
			System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
			File firebug = new File(projectpath+"/selenium/tool/firebug@software.joehewitt.com.xpi");
			File firepath = new File(projectpath+"/selenium/tool/FireXPath@pierre.tholence.com.xpi");
			firefoxprofile = new FirefoxProfile();
			try {
				//��װfirebug��firepath
				firefoxprofile.addExtension(firebug);
				firefoxprofile.addExtension(firepath);
				//�ƹ�֤������
				firefoxprofile.setPreference("webdriver.accept.unstrusted.certs", "true");
				//ʵ�ִ�������
//				firefoxprofile.setPreference("network.proxy.type",0);
//				firefoxprofile.setPreference("network.proxy.http","10.1.1.0");
//				firefoxprofile.setPreference("network.proxy.http_port",3128);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver=new FirefoxDriver(firefoxprofile);
			driver.manage().window().maximize();
			break;
		case ie:
			System.setProperty("webdriver.ie.driver",projectpath+"/selenium/tool/IEDriverServer32.exe");
			caps=DesiredCapabilities.internetExplorer();//��̬����Բ���new��ֱ�Ӷ���Ϳ�����
			//���������ð�ȫ����ʹ��IE������İ�ȫ������IEDriverServerһ��
			caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			//��IE�л���Inprivateģʽ�����Ա���Cache��cookie�����Ӱ�죬������Cache��cookie������û�з����³��ֵ�����
			caps.setCapability(InternetExplorerDriver.IE_SWITCHES,"-private");
			caps.setCapability("ignoreZoomSetting",true);
			driver =new InternetExplorerDriver(caps);
			driver.manage().window().maximize();
			break;
		case chrome:
			System.setProperty("webdriver.chrome.driver",projectpath+"/selenium/tool/chromedriver.exe");
			caps=DesiredCapabilities.chrome();//��̬����Բ���new��ֱ�Ӷ���Ϳ�����
			//���������ð�ȫ����ʹ��IE������İ�ȫ������IEDriverServerһ��
			//caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			//��IE�л���Inprivateģʽ�����Ա���Cache��cookie�����Ӱ�죬������Cache��cookie������û�з����³��ֵ�����
			caps.setCapability("chrome.switches",Arrays.asList("--start-maximized"));
			//caps.setCapability("ignoreZoomSetting",true);
			driver =new ChromeDriver(caps);
			driver.manage().window().maximize();
			break;
		}
	}
}
