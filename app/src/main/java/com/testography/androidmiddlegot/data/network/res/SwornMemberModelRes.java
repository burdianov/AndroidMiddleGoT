package com.testography.androidmiddlegot.data.network.res;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.testography.androidmiddlegot.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class SwornMemberModelRes {

    @SerializedName("url")
    @Expose
    private String id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("born")
    @Expose
    private String born;

    @SerializedName("died")
    @Expose
    private String died;

    @SerializedName("titles")
    @Expose
    private List<String> titles = new ArrayList<>();

    @SerializedName("aliases")
    @Expose
    private List<String> aliases = new ArrayList<>();

    @SerializedName("father")
    @Expose
    private String father;

    @SerializedName("mother")
    @Expose
    private String mother;

    public String getId() {
        return String.valueOf(Utils.getIdFromUri(this.id));
    }

    public String getName() {
        return name;
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
}
