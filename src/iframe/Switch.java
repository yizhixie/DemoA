package iframe;

import java.util.Set;

import org.openqa.selenium.WebDriver;

public class Switch {
	private WebDriver driver;
	private String currentwindow;
	
	public Switch(WebDriver driver){
		this.driver=driver;
		currentwindow =driver.getWindowHandle();
	}
	public void toSpecificWindow(String partialTitleNme){
		Set<String> handles = driver.getWindowHandles();
		String titlename;
		for(String handle:handles){
			titlename=driver.switchTo().window(handle).getTitle();
			if(titlename.contains(partialTitleNme))
				break;
		}
	}
	public void backToCurrentWindow(){
		driver.switchTo().window(currentwindow);
	}
}
//更改内容，测试Guthup的同步性