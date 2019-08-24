package cn.sisyphe.demo.user.model;

import cn.sisyphe.demo.core.base.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "demo_user")
public class User extends BaseEntity {

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
