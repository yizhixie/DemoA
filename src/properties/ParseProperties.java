package properties;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class ParseProperties {
	/**
	 * ��ʵ����һ��Properties����
	 */
	private Properties pro= new Properties();
	String value=null;
	
	public ParseProperties(String propertiespath){//��д���캯��
		this.loadProperties(propertiespath);
	}
	/**
	 * �ȶ���Properties�е����ݵ�Pro������
	 * @param propertiespath
	 */
	private void loadProperties(String propertiespath){
		try {
			InputStream in= new FileInputStream(propertiespath);
			InputStreamReader inr= new InputStreamReader(in);
			BufferedReader br= new BufferedReader(inr);
			pro.load(br);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * �ٴ�Pro�����л�ȡkeyname��ֵ
	 * @param keyname
	 * @return
	 */
	public String getValue(String keyname){
		value=pro.getProperty(keyname).trim();
		try {
			value=new String(value.getBytes("UTF-8"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}
	
	public static void main(String[] args){
		ParseProperties pp=new ParseProperties("C:\\Users\\Administrator\\workspace\\selenium\\tool\\test.properties");
		System.out.println(pp.getValue("url"));
	}
}
