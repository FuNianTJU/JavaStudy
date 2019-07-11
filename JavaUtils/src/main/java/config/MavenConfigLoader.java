package config;

import java.net.URL;

import javax.xml.parsers.ParserConfigurationException;

/**
 * maven工程中读取resource目录下配置文件
 * @author yan
 *
 */
public class MavenConfigLoader {
	public static void main(String[] args) throws ParserConfigurationException, Exception{  
        ClassLoader classLoader = MavenConfigLoader.class.getClassLoader();  
        URL resource = classLoader.getResource("config.xml");  
        String path = resource.getPath();
        System.out.println(path);  
        //InputStream resourceAsStream = classLoader.getResourceAsStream("config.xml"); 
	}

}
