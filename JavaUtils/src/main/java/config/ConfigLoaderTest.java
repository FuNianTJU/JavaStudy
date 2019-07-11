package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.XMLConfiguration;
import org.junit.Test;

/**
 * 读取配置文件的集中方法
 * @author yan
 *
 */
public class ConfigLoaderTest {
	
	/**
	 * 使用org.apache.commons.configuration读取xml文件
	 * @author yan
	 */
	@Test
	public void testXmlLoader(){
		try {
			Configuration configuration = new XMLConfiguration("config.xml");
			//需要注意的是config.getString(“Account.name”)中的参数是Account.name，
			//这个参数是XPath格式的，而且不能包含xml中的根元素。
			String name = configuration.getString("Account.name");
			System.out.println("name: "+ name);
		} catch (ConfigurationException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 使用org.apache.commons.configuration读取properties文件
	 * @author yan
	 */
	@Test
	public void testPropertiesLoader(){
		try {
			Configuration config = new PropertiesConfiguration("config.properties");  
			String name = config.getString("name");  
			System.out.println("name:" + name);
		} catch (ConfigurationException e) {
			e.printStackTrace();
		}  
	}
	
	/**
	 * 使用java.util.Properties读取
	 * @author yan
	 */
	@Test
	public void testProperties(){
		try {
			InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("config.properties");
			Properties config = new Properties();
			config.load(inputStream);
			System.out.println("name:" + config.getProperty("name"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}




















