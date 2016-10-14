package com.testography.androidmiddlegot.data.storage.models;

import com.testography.androidmiddlegot.data.network.res.HouseModelRes;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Unique;

@Entity(active = true, nameInDb = "HOUSES")
public class House {

    @Id
    private Long id;

    @NotNull
    @Unique
    private String remoteId;

    @NotNull
    @Unique
    private String houseName;

    private String words;

    public House(HouseModelRes houseModelRes) {
        this.remoteId = houseModelRes.getId();
        this.houseName = houseModelRes.getName();
        this.words = houseModelRes.getWords();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRemoteId() {
        return remoteId;
    }

    public void setRemoteId(String remoteId) {
        this.remoteId = remoteId;
    }

    public String getHouseName() {
        return this.houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public String getWords() {
        return this.words;
    }

    public void setWords(String words) {
        this.words = words;
    }
}