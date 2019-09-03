package com.example.web.Entity;


import java.util.Date;

//文章的数据实体类
public class ArticleEntity {
    private int id;                        //文章的编号
    private String titly;                  //文章的titly
    private String author;                 //作者
    private int proportion;                //文章的比重
    private int groupID;                  //分类
    private String picture;                //图片地址
    private String briefIntroduction;      //简介
    private String text;                   //正文
    private Date create_time;              //创建时间
    private Date update_time;              //修改时间

    @Override
    public String toString() {
        return "ArticleEntity{" +
                "id=" + id +
                ", titly='" + titly + '\'' +
                ", author='" + author + '\'' +
                ", proportion=" + proportion +
                ", groupID=" + groupID +
                ", picture='" + picture + '\'' +
                ", briefIntroduction='" + briefIntroduction + '\'' +
                ", text='" + text + '\'' +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitly() {
        return titly;
    }

    public void setTitly(String titly) {
        this.titly = titly;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getProportion() {
        return proportion;
    }

    public void setProportion(int proportion) {
        this.proportion = proportion;
    }

    public int getGroupID() {
        return groupID;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getBriefIntroduction() {
        return briefIntroduction;
    }

    public void setBriefIntroduction(String briefIntroduction) {
        this.briefIntroduction = briefIntroduction;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }
}
