package cn.sisyphe.demo.user.web;

import cn.sisyphe.demo.core.base.Pagination;
import cn.sisyphe.demo.user.model.User;
import cn.sisyphe.demo.user.service.UserService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ：Jerry
 * @date ：Created in 2019/4/21 0:01
 * @description：${description}
 */
@RequestMapping("/api/demo")
@RestController
@Api(description = "Demo")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "find")
    @GetMapping("/find")
    public List<User> findList() {
        List<User> users = userService.list();
        return users;
    }

    @ApiOperation(value = "findPage")
    @GetMapping("/findPage")
    public PageInfo<User> findPage() {
        Pagination pagination = new Pagination(0,2);
        PageInfo<User> users = userService.listByEntityAndPage(null,pagination);
        return users;
    }

    @ApiOperation(value = "save")
    @PostMapping("/save")
    public User save(@RequestBody User user) {
        userService.save(user);
        return user;
    }

    @ApiOperation(value = "delete")
    @DeleteMapping("/delete/{id}")
    public int delete(@PathVariable("id") Long id) {
        userService.remove(id);
        return 1;
    }

    @ApiOperation(value = "detail")
    @GetMapping("/detail/{id}")
    public User detail(@PathVariable("id") Long id) {
        User user = userService.get(id);
        return user;
    }

    @ApiOperation(value = "test1")
    @GetMapping("/test/{userName}")
    public User test1(@PathVariable("userName") String userName) {
        User user = userService.selectByUserName(userName);
        return user;
    }

    @ApiOperation(value = "test like")
    @GetMapping("/testLike/{userName}")
    public List<User> test2(@PathVariable("userName") String userName) {
        List<User> users = userService.selectByExample(userName);
        return users;
    }
}
