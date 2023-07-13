package com.boray.utils;

import java.util.Locale;
import java.util.ResourceBundle;

import com.boray.model.InterfaceName;

public class ConfigFile {
	
	private static ResourceBundle bundle = ResourceBundle.getBundle("application", Locale.CHINA);
	
	public static String getUrl(InterfaceName name) {
		String ipPort=bundle.getString("test.url");
		String uri = null;
		String testUrl;
		
		if(name == InterfaceName.LOGIN) {
			uri=bundle.getString("login.uri");			
		} 
					
		if(name == InterfaceName.GETUSERLIST) {
			uri=bundle.getString("getUserList.uri");			
		} 
		
		if(name == InterfaceName.UPDATEUSERINFO) {
			uri=bundle.getString("updateUserInfo.uri");			
		} 
		if(name == InterfaceName.ADDUSER) {
			uri=bundle.getString("addUser.uri");			
		} 
		
		testUrl=ipPort+uri;
		
		return testUrl;

	}
}
