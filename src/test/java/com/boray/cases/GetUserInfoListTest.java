package com.boray.cases;

import java.io.IOException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.boray.config.TestConfig;
import com.boray.utils.DatabaseUtil;

public class GetUserInfoListTest {

    @Test(dependsOnGroups="loginSuccess",description = "获取用户列表")
    public void getUserListInfo() throws IOException, InterruptedException {

        SqlSession session = DatabaseUtil.getSqlSession();
        
//        System.out.println(getUserListCase.toString());
//        System.out.println(TestConfig.getUserListUrl);
        

        JSONObject jsonObject = getJsonResult();
        JSONArray resultJson=jsonObject.getJSONArray("data");

        Thread.sleep(2000);
//        List<User> userList = session.selectList("getUserListCase");
//        for(User u : userList){
//            System.out.println("list获取的user:"+u.toString());
//        }
//        JSONArray userListJson = new JSONArray(userList);

//        Assert.assertEquals(userListJson.length(),resultJson.length());
//        for(int i = 0;i<resultJson.length();i++){
//            JSONObject expect = (JSONObject) resultJson.get(i);
//            JSONObject actual = (JSONObject) userListJson.get(i);
            
            Assert.assertEquals(jsonObject.getString("msg"), "操作成功");
            Assert.assertEquals(jsonObject.getInt("code"), 200);
            Assert.assertNotNull(resultJson);
//        }
    }
    
    private JSONObject getJsonResult() throws IOException {
        HttpGet get = new HttpGet(TestConfig.getUserListUrl);
        
        //设置请求头,设置token
        get.setHeader("content-type","application/json");
        get.setHeader("Authorization", TestConfig.store);
        
        String result=null;
        CloseableHttpResponse response=null;
        JSONObject jsonObject=null;
        //执行get方法
        try {
        response = TestConfig.defaultHttpClient.execute(get);
        //获取响应结果
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        jsonObject=new JSONObject(result);
        }catch(Exception e) {
        	e.printStackTrace();
        }finally {
        	if(response != null) {
        		response.close();
        	}
        }
//        System.out.println("result:"+result);      
//        System.out.println("jsonArray:"+jsonArray.toString());
        
        return jsonObject;

    }
}
