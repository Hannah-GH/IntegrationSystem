package util;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;


/**
 * 配置管理器，专门读取配置文件，提供给系统的各个部分访问可配置的信息
 * @author luMinO
 *
 */
public class ConfigManager {
	private static String CONFIGPATH = "/Users/guhan/Documents/IntegrationSystem/Retail/config/config.xml";
	
	private static List<Pair> dic = new LinkedList<Pair>();
	
	private static Document doc;
	
	//直接在构造方法里面初始化没用，因为没有ConfigManager对象被初始化出来
	static{
		initialize();
	}
	
	/**
	 * 读取配置文件，加载配置文件中的变量替换表
	 */
	private static void initialize() {
		doc = loadXML(CONFIGPATH);
		
		Element root = doc.getRootElement();
		Element replaces = root.element("replaces");
		
		List<Element> pairs = replaces.elements("pair");
		for(Element pair: pairs){
			String key = pair.elementText("key");
			String value = pair.elementText("value");
			
			dic.add(new Pair(key, value));
		}
		
		if( root.elementText("debug").trim().equals("true") ){
			Logger.setDebugMode(true);
		}
	}

	/**
	 * 所有的配置信息均通过键值对来访问，所以其他逻辑在使用key访问配置的值的时候其实是硬编码的
	 * @param key
	 * @return
	 */
	public static String getValue(String key){
		Element root = doc.getRootElement();
		Element e = root.element(key);
		
		if( e!=null ){
			String text = e.getText();
			String result = translate(text).trim();
			
			Logger.debug("获取配置参数"+key+" = "+result);
			return result;
		}else{
			Logger.debug("请求参数"+key+"为空");
			return null;
		}
	}
	
	/**
	 * 将配置文本中的内容和字典值进行比对，替换可以匹配的部分
	 * @param text
	 * @return
	 */
	private static String translate(String text) {
		for( Pair p: dic ){
			String key = p.key;
			
			if( text.contains(key) ){
				String result = text.replaceFirst(key, p.value);
				return result;
			}
		}
		
		return text;
	}

	/**
	 * 读取指定的配置文件
	 * @param string 配置文件的文件名
	 * @return
	 */
	private static Document loadXML(String path) {
		try {
			InputStream inputStream = new FileInputStream(new File(path));
			
			Document document = new SAXReader().read(inputStream);  
			
			return document;
			
		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();
		}   
		
		return null;
	}
}

/**
 * 由替换表所使用的内部类，其实就是键值对
 * @author luMinO
 *
 */
class Pair{
	String key;
	String value;
	
	public Pair(String key, String value) {
		this.key = key;
		this.value = value;
	}
	
}
