package com.sqa.ra.framework;

import java.io.InputStream;
import java.util.Properties;

public class RAPropertyManager {
	private static Properties prop;

	private RAPropertyManager() {

	}

	public static Properties getProprties() {
		try {

			if (prop == null) {
				InputStream input = ClassLoader.getSystemClassLoader()
						.getResourceAsStream("automation.properties");
				 prop = new Properties();
				prop.load(input);
			}
			// InputStream input=new
			// FileInputStream("C:\\QA_Training\\qa_training_workspace\\JPETTestProject\\src\\com\\jpet\\framework\\jpet.properties");

			return prop;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return null;
		
		
	}
	public static  String getProperty(String key){
		String value=System.getProperty(key);
		//String value=getProprties().getProperty(key);
		//System.out.println("value of key="+key+" value"+value);
		if(value==null){
			//value=System.getProperty(key);
			 value=getProprties().getProperty(key);
		}
		//System.out.println("value of key="+key+" value"+value);
		return value;
	}

}
