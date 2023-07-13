package com.boray.cases;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import com.boray.config.TestConfig;
import com.boray.model.UpdateUserInfoCase;
import com.boray.utils.DatabaseUtil;

public class UpdateUserTest {
	
    @Test(dependsOnGroups = "loginSuccess",description = "更改用户信息")
    public void updateUserInfo() throws IOException, InterruptedException {
        SqlSession session = DatabaseUtil.getSqlSession();
        UpdateUserInfoCase updateUserInfoCase = session.selectOne("updateUserInfoCase",1);
        System.out.println(updateUserInfoCase.toString());
        System.out.println(TestConfig.updateUserInfoUrl);
    }
}
