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
		caps=DesiredCapabilities.chrome();//��̬����Բ���new��ֱ�Ӷ���Ϳ�����
		//���������ð�ȫ����ʹ��IE������İ�ȫ������IEDriverServerһ��
		//caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		//��IE�л���Inprivateģʽ�����Ա���Cache��cookie�����Ӱ�죬������Cache��cookie������û�з����³��ֵ�����
		caps.setCapability("chrome.switches",Arrays.asList("--start-maximized"));
		//caps.setCapability("ignoreZoomSetting",true);
		chromewb =new ChromeDriver(caps);
	}
	@Test
	public void searchOnbaidu(){
		chromewb.get("http://www.baidu.com");//����֤��ʱ�����û�й�û֤���أ�����ַ���Ϊ�����ε���ַ��������
		//IE�������ϲ�������ַ,������Ҫ�������:iewb.get("javascript:document.getElementById('overridelink').click();");
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
