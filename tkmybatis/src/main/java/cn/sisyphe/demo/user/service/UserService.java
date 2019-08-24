package cn.sisyphe.demo.user.service;

import cn.sisyphe.demo.core.base.service.BaseService;
import cn.sisyphe.demo.user.model.User;

import java.util.List;

/**
 * @author ：Jerry
 * @date ：Created in 2019/4/20 23:53
 * @description：${description}
 */
public interface UserService extends BaseService<User> {

    User selectByUserName(String userName);

    List<User> selectByExample(String sample);

}
