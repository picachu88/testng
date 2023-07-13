package com.boray.cases;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import com.boray.config.TestConfig;
import com.boray.model.AddUserCase;
import com.boray.utils.DatabaseUtil;

public class AddUserTest {
	
	@Test(dependsOnGroups = "loginSuccess",description = "添加用户接口测试")
	public void addUser() throws IOException, InterruptedException {
		SqlSession session=DatabaseUtil.getSqlSession();
		AddUserCase addUserCase=session.selectOne("addUserCase", 1);
		
        System.out.println(addUserCase.toString());
        System.out.println(TestConfig.addUserUrl);
	}
	

}
