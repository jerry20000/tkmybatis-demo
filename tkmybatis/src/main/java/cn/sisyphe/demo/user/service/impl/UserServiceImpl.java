package cn.sisyphe.demo.user.service.impl;

import cn.sisyphe.demo.core.base.service.BaseServiceImpl;
import cn.sisyphe.demo.user.mapper.UserMapper;
import cn.sisyphe.demo.user.model.User;
import cn.sisyphe.demo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：Jerry
 * @date ：Created in 2019/4/20 23:54
 * @description：${description}
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<UserMapper,User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectByUserName(String userName) {
        return userMapper.selectByUserName(userName);
    }

    @Override
    public List<User> selectByExample(String userName) {
        return userMapper.selectByUserExample(userName);
    }
}
