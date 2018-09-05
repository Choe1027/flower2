package com.lazyfish.back;

import com.lazyfish.core.pojo.BackUser;
import com.lazyfish.core.service.BackUserService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BackApplicationTests {

    @Autowired
    private BackUserService backUserService;

    @Test
    public void contextLoads() {
        BackUser backUser = new BackUser();
        backUser.setId(2L);
        backUser.setName("aaa");
        backUser.setMobile("66666");
        backUserService.update(backUser);
    }

}
