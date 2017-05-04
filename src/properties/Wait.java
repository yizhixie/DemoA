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
	 * 方法一：一直等到元素出现
	 * @param locator
	 */
	public void waitForElementPresent(String locator){
		try{
			new WebDriverWait(driver,timeout).until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
		}catch(Exception e){
			
		}
	}
	/**
	 * 方法二：一直等到元素有效
	 * @param locator
	 */
	public void waitForElementIsEnable(String locator){
		try{
			new WebDriverWait(driver,timeout).until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
		}catch(Exception e){
			
		}
	}
	/**
	 * 方法三：等待timeout时间段
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
