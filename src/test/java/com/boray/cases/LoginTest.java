package com.boray.cases;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.boray.config.TestConfig;
import com.boray.model.InterfaceName;
import com.boray.model.LoginCase;
import com.boray.model.User;
import com.boray.utils.ConfigFile;
import com.boray.utils.DatabaseUtil;
import com.boray.utils.YamlUtil;


public class LoginTest {

	@BeforeTest(groups="loginSuccess",description = "测试准备工作")
	public void beforeTest(){
		TestConfig.defaultHttpClient=HttpClientBuilder.create().build(); 
		TestConfig.loginUrl=ConfigFile.getUrl(InterfaceName.LOGIN);
		TestConfig.getUserListUrl=ConfigFile.getUrl(InterfaceName.GETUSERLIST);
		TestConfig.updateUserInfoUrl=ConfigFile.getUrl(InterfaceName.UPDATEUSERINFO);
		TestConfig.addUserUrl=ConfigFile.getUrl(InterfaceName.ADDUSER);
	}
	
	@AfterTest(description = "测试结束")
	public void afterTest() throws IOException{
		
		//资源释放和数据清理
		TestConfig.defaultHttpClient.close();
		
	}
	
	@Test(groups="loginSuccess",dataProvider = "getYamlData",description = "")
	public void loginSuccess(Map<String,String> param) throws IOException {
		SqlSession session = DatabaseUtil.getSqlSession();
		
		//去数据源查询数据，与接口返回的实际数据进行校验
		User user=session.selectOne("loginCase",param.get("userName"));
	
		LoginCase loginCase = new LoginCase();
		loginCase.setUserName(param.get("userName"));
		loginCase.setPassword(param.get("password"));
		loginCase.setExpectedMsg(param.get("expectedMsg"));
		loginCase.setExpectedCode(param.get("expectedCode"));
		
//        System.out.println(loginCase.toString());
//        System.out.println(TestConfig.loginUrl);
        
        String result = getResult(loginCase);
        
//        System.out.println(result);
        
        JSONObject jsonObj=new JSONObject(result);
        String token=jsonObj.getString("data");
        
//        System.out.println("token:"+token);
        
        TestConfig.store = token;
        
        Assert.assertEquals(jsonObj.getString("msg"), param.get("expectedMsg"));
        Assert.assertEquals(jsonObj.getInt("code"), Integer.parseInt(param.get("expectedCode")));
        
	}
	
//	@Ignore
    @Test(dataProvider = "getYamlData",description = "")
    public void loginFail(Map<String,String> param) throws IOException {
        SqlSession session = DatabaseUtil.getSqlSession();
        User user=session.selectOne("loginCase",param.get("userName"));
        
//        System.out.println(loginCase.toString());
//        System.out.println(TestConfig.loginUrl);
        
        LoginCase loginCase = new LoginCase();
		loginCase.setUserName(param.get("userName"));
		loginCase.setPassword(param.get("password"));
		loginCase.setExpectedMsg(param.get("expectedMsg"));
		loginCase.setExpectedCode(param.get("expectedCode"));
        
        String result = getResult(loginCase);
        JSONObject jsonObj=new JSONObject(result);
        
        Assert.assertEquals(jsonObj.getString("msg"), param.get("expectedMsg"));
        Assert.assertEquals(jsonObj.getInt("code"), Integer.parseInt(param.get("expectedCode")));
    }
    
    @DataProvider
    public  Object[][] getYamlData(Method method){
    	List<Map<String, String>> yamlList = null;
    	Object[][] testdata = null;
    	
    	if(method.getName().equals("loginSuccess")) {
    		yamlList = YamlUtil.getYamlList("loginSuccess");	
    	}else if(method.getName().equals("loginFail")){
    		yamlList = YamlUtil.getYamlList("loginFail");    		
    	}
    	testdata=new Object[yamlList.size()][];
    	for(int i=0;i<yamlList.size();i++) {
    		testdata[i] = new Object[]{yamlList.get(i)};	
    		
			/*
			 * for(int row=0;row<testdata.length;row++){ for(int
			 * col=0;col<testdata[row].length;col++){
			 * System.out.println(testdata[row][col]+" "); }}
			 */
    	}
    	
    	return testdata;
    }
    
        
    private String getResult(LoginCase loginCase) throws IOException {
        HttpPost post = new HttpPost(TestConfig.loginUrl);
        JSONObject param = new JSONObject();
        
        param.put("userName",loginCase.getUserName());
        param.put("password",loginCase.getPassword());
        
        //设置请求头
        post.setHeader("content-type","application/json");
        //添加参数
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);
        //响应结果
        String result = null;
        CloseableHttpResponse response=null;
        try {
        //执行post方法
        response = TestConfig.defaultHttpClient.execute(post);
        //获取响应结果
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        }catch(Exception e) {
        	System.out.println("HTTP 请求异常："+e);
        }finally {
        if(response != null) {
        	response.close();
        }
        
        }
        return result;
    }
	
}
