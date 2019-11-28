package com.timeline.dao;

import com.timeline.TimelineApplication;
import com.timeline.dataObject.UserInfo;
import com.timeline.error.EmBussinessError;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TimelineApplication.class)
class UserDaoTest {
    @Autowired
    private UserDao userDao;
    @Test
    void findByUserId() {
        UserInfo userInfo = userDao.findByUserId(33);
        System.out.println(userInfo.getEmail());
        Assertions.assertEquals(userInfo.getEmail(),"1002376198@qq.com");
    }

    @Test
    void findByUserIdError() {
        UserInfo userInfo = userDao.findByUserId(200);
        Assertions.assertNull(userInfo.getEmail());
    }

    @Test
    void findByEmail(){
        UserInfo userInfo  = userDao.findByEmail("1002376198@qq.com");
        Assertions.assertEquals(33,userInfo.getUserId().intValue());
    }

    @Test
    void findByEmailError(){
        UserInfo userInfo  = userDao.findByEmail("1002376198");
        Assertions.assertEquals("errCode", EmBussinessError.UNKNOWN_ERROR.getErrorCode());
    }
}