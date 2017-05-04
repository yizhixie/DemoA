package practiceone;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LaunchIE {
	private static WebDriver iewb=null;
	private static DesiredCapabilities caps=null;
	private String projectpath = System.getProperty("user.dir");
	
	@BeforeClass
	public void starIE(){
		System.setProperty("webdriver.ie.driver",projectpath+"/tool/IEDriverServer32.exe");
		caps=DesiredCapabilities.internetExplorer();//��̬����Բ���new��ֱ�Ӷ���Ϳ�����
		//���������ð�ȫ����ʹ��IE������İ�ȫ������IEDriverServerһ��
		caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		//��IE�л���Inprivateģʽ�����Ա���Cache��cookie�����Ӱ�죬������Cache��cookie������û�з����³��ֵ�����
		caps.setCapability(InternetExplorerDriver.IE_SWITCHES,"-private");
		caps.setCapability("ignoreZoomSetting",true);
		iewb =new InternetExplorerDriver(caps);	
		iewb.manage().window().maximize();
	}
	@Test
	public void searchOnbaidu(){
		iewb.get("http://www.baidu.com");//����֤��ʱ�����û�й�û֤���أ�����ַ���Ϊ�����ε���ַ��������
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
		iewb.quit();
	}
}
