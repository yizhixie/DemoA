package testng;
import org.testng.annotations.*;
public class Test001 {	
	@BeforeTest
	public void beforeTest(){
		System.out.println("BeforeTest");
	}
	@BeforeClass
	public void beforeClass(){
		/**
		 * BeforeClass中放的一般都是诸如打开关闭浏览器、登录登出账户等数据准备阶段的事情
		 * 因为BeforeClass和AfterClass只执行一次
		 */
		System.out.println("BeforeClass");
	}
	@BeforeMethod
	public void beforeMethod(){
		/**
		 * BeforeMethod模块紧跟Test模块，每执行一次Test都要执行BeforeMethod一次
		 */
		System.out.println("BeforeMethod");
	}
	@Test
	public void aTest(){
		/**
		 * 所有的测试用例都是放在Test模块中
		 */
		System.out.println("aTest");
	}
	@Test
	public void bTest(){
		System.out.println("bTest");
	}
	@Test
	public void cTest(){
		System.out.println("cTest");
	}
	@Test
	public void dTest(){
		System.out.println("dTest");
	}
	
	@AfterMethod
	public void afterMethod(){
		System.out.println("afterMethod");
	}
	
	@AfterClass
	public void afterClass(){
		System.out.println("afterClass");
	}
	@AfterTest
	public void afterTest(){
		System.out.println("afterTest");
	}
}
