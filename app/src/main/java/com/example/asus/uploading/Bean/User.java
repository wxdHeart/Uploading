package com.example.asus.uploading.Bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class User {
    @Id(autoincrement = true)
    private Long id;
    private String content;
    private String conadd;
    @Generated(hash = 1755041777)
    public User(Long id, String content, String conadd) {
        this.id = id;
        this.content = content;
        this.conadd = conadd;
    }
    @Generated(hash = 586692638)
    public User() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getContent() {
        return this.content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getConadd() {
        return this.conadd;
    }
    public void setConadd(String conadd) {
        this.conadd = conadd;
    }

}
