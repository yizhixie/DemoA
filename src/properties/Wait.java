package properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {
	private WebDriver driver;
	private int timeout=10;
	
	public Wait(WebDriver driver){
		this.driver=driver;
	}
	/**
	 * ����һ��һֱ�ȵ�Ԫ�س���
	 * @param locator
	 */
	public void waitForElementPresent(String locator){
		try{
			new WebDriverWait(driver,timeout).until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
		}catch(Exception e){
			
		}
	}
	/**
	 * ��������һֱ�ȵ�Ԫ����Ч
	 * @param locator
	 */
	public void waitForElementIsEnable(String locator){
		try{
			new WebDriverWait(driver,timeout).until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
		}catch(Exception e){
			
		}
	}
	/**
	 * ���������ȴ�timeoutʱ���
	 * @param timeout
	 */
	public void waitFor(long timeout){
		try {
			Thread.sleep(timeout);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
