package com.example.web.Entity;

import java.util.Date;

public class markdownEntity {
    private int id;
    private String titly;
    private String author;
    private String typeOfLog;
    private String text;
    private Date create_time;
    private Date update_time;

    @Override
    public String toString() {
        return "markdownEntity{" +
                "id=" + id +
                ", titly='" + titly + '\'' +
                ", author='" + author + '\'' +
                ", typeOfLog='" + typeOfLog + '\'' +
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

    public String getTypeOfLog() {
        return typeOfLog;
    }

    public void setTypeOfLog(String typeOfLog) {
        this.typeOfLog = typeOfLog;
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
