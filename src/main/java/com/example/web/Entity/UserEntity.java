package com.example.web.Entity;

//实体类  用来保存用户信息，所有对数据库操作  或 对用户操作  都可以用到这个类
public class UserEntity {
    //用户id 不可重复且自增
    private int id;
    //用户名字 不能为空
    private String name;
    //用户密码 默认为空
    private String password;
    //用户所属小组 不能为空
    private int groupID;
    //所属权限 我这里是没有用到的，本来想做个权限的
    private int Jurisdiction;
    //其实还有两个属性，一个创建时间，一个修改时间，这里没有设计到实体类中，避免失误操作，以留证据。

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getGroupID() {
        return groupID;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }

    public int getJurisdiction() {
        return Jurisdiction;
    }

    public void setJurisdiction(int jurisdiction) {
        Jurisdiction = jurisdiction;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", groupID=" + groupID +
                ", Jurisdiction=" + Jurisdiction +
                '}';
    }
}
