package com.boray.utils;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.yaml.snakeyaml.Yaml;

public class YamlUtil {

	private static Map<String, List<Map<String, String>>> readYamlUtil(){
		Map<String, List<Map<String, String>>> map=null;
		Yaml yaml=new Yaml();
		InputStream inputStream = YamlUtil.class.getClassLoader().getResourceAsStream("testdata.yml");
		map=yaml.load(inputStream);
		return map;
	}
	
	public static List<Map<String,String>> getYamlList(String part){
		Map<String, List<Map<String,String>>> map = readYamlUtil();
		List<Map<String,String>> mpVlaue = null;
		mpVlaue = map.get(part);
		return mpVlaue;
		}
	
	
//	public static List<Map<String,String>> getYamlList(String part){
//		List<Map<String,String>> list=new ArrayList<Map<String,String>>();
//		Map<String, Map<String, String>> map = readYamlUtil();
//		
//		for(Entry<String, Map<String, String>> mp:map.entrySet()) {
//				Map<String, String> mpVlaue = mp.getValue();
//				HashMap<String, String> tmp = new HashMap<String, String>();
//				for(Entry<String, String> namepass:mpVlaue.entrySet()) {
//					String uname = namepass.getKey();
//					String passw = namepass.getValue();
//					tmp.put(uname, passw);
//				}
//				list.add(tmp);
//		}
//		
//		return list;
//		}	
}
