package com.qindy.shiro;

import com.qindy.entity.UserInfo;
import org.springframework.stereotype.Component;

/**
 * @author qindongyun
 * @Description:
 * @date 2018/10/16
 */
@Component
public class UserInfoService {

    public UserInfo findByUsername(String username){
        UserInfo userInfo = new UserInfo();
        userInfo.setName(username);
        userInfo.setSalt("salt");
        userInfo.setPassword("123");
        userInfo.setUsername(username);
        return userInfo;
    }
}
