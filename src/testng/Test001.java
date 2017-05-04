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
		 * BeforeClass�зŵ�һ�㶼������򿪹ر����������¼�ǳ��˻�������׼���׶ε�����
		 * ��ΪBeforeClass��AfterClassִֻ��һ��
		 */
		System.out.println("BeforeClass");
	}
	@BeforeMethod
	public void beforeMethod(){
		/**
		 * BeforeMethodģ�����Testģ�飬ÿִ��һ��Test��Ҫִ��BeforeMethodһ��
		 */
		System.out.println("BeforeMethod");
	}
	@Test
	public void aTest(){
		/**
		 * ���еĲ����������Ƿ���Testģ����
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
