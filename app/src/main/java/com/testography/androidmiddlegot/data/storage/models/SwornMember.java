package com.testography.androidmiddlegot.data.storage.models;

import com.testography.androidmiddlegot.data.network.res.SwornMemberModelRes;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Unique;

import java.util.ArrayList;

@Entity(active = true, nameInDb = "SWORN_MEMBERS")
public class SwornMember {

    @Id
    private Long id;

    @NotNull
    @Unique
    private String remoteId;

    private String houseRemoteId;
    private String name;
    private String born;
    private String died;
    private ArrayList<String> titles;
    private ArrayList<String> aliases;
    private String father;
    private String mother;
    private String words;

    public SwornMember(SwornMemberModelRes swornMemberModelRes, int
            houseRemoteId, String words) {
        this.houseRemoteId = String.valueOf(houseRemoteId);
        this.remoteId = swornMemberModelRes.getId();
        this.name = swornMemberModelRes.getName();
        this.born = swornMemberModelRes.getBorn();
        this.died = swornMemberModelRes.getDied();
        this.titles = swornMemberModelRes.getTitles();
        this.aliases = swornMemberModelRes.getAliases();
        this.father = swornMemberModelRes.getFather();
        this.mother = swornMemberModelRes.getMother();
        this.words = words;
    }

    public Long getId() {
        return id;
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

    public String getHouseRemoteId() {
        return houseRemoteId;
    }

    public void setHouseRemoteId(String houseRemoteId) {
        this.houseRemoteId = houseRemoteId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBorn() {
        return born;
    }

    public void setBorn(String born) {
        this.born = born;
    }

    public String getDied() {
        return died;
    }

    public void setDied(String died) {
        this.died = died;
    }

    public ArrayList<String> getTitles() {
        return titles;
    }

    public void setTitles(ArrayList<String> titles) {
        this.titles = titles;
    }

    public ArrayList<String> getAliases() {
        return aliases;
    }

    public void setAliases(ArrayList<String> aliases) {
        this.aliases = aliases;
    }

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public String getMother() {
        return mother;
    }

    public void setMother(String mother) {
        this.mother = mother;
    }

    public String getWords() {
        return words;
    }

    public void setWords(String words) {
        this.words = words;
    }
}