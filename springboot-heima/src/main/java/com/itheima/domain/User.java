package com.itheima.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by lwx on 2019/2/23.
 *
 * 用户实体类
 */
@Entity
@Table(name = "user")
public class User implements Serializable{

    @Id
    @Column(name = "id") //跟数据库的字段名一致
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username") //在windows系统下不区分大小写，在Linux下严格区分
    private String username;

    @Column(name = "address")
    private String address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
