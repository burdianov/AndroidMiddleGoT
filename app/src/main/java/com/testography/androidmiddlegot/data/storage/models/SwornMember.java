package com.testography.androidmiddlegot.data.storage.models;

import com.testography.androidmiddlegot.data.network.res.SwornMemberModelRes;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Unique;

import java.util.List;

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
    private List<String> titles;
    private List<String> aliases;
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

    public String getHouseRemoteId() {
        return this.houseRemoteId;
    }

    public void setHouseRemoteId(String houseRemoteId) {
        this.houseRemoteId = houseRemoteId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBorn() {
        return born;
    }

    public String getDied() {
        return died;
    }

    public List<String> getTitles() {
        return titles;
    }

    public List<String> getAliases() {
        return aliases;
    }

    public String getFather() {
        return father;
    }

    public String getMother() {
        return mother;
    }

    public String getWords() {
        return words;
    }
}