package com.qa.company.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import com.qa.company.constants.FrameworkConstants;
import com.qa.company.enums.ConfigProperties;

public final class PropertyUtils {

	private PropertyUtils(){

	}

	private static Properties prop = new Properties();
	private static final Map<String, String> CONFIGMAP = new HashMap<>();

	static{
		try{
			FileInputStream fis = new FileInputStream(FrameworkConstants.getConfigfilepath());
			prop.load(fis);

			/*for(Object key: prop.keySet()){
				CONFIGMAP.put(String.valueOf(key), String.valueOf(prop.get(key)));
			}*/

			for(Map.Entry<Object, Object> entry: prop.entrySet()){
				CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim());
			}

			//prop.entrySet().forEach(entry->CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue())));

		}
		catch(FileNotFoundException e){
			e.printStackTrace();	
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}

	public static String getValue(ConfigProperties key) throws Exception{
		if(Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))){
			throw new Exception("Property name " + key + " not found. Please enter correct property key.");
		}
		return CONFIGMAP.get(key.name().toLowerCase());
	}
}