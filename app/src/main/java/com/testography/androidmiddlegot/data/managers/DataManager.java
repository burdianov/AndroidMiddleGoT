package com.testography.androidmiddlegot.data.managers;

import com.testography.androidmiddlegot.data.network.RestService;
import com.testography.androidmiddlegot.data.network.ServiceGenerator;
import com.testography.androidmiddlegot.data.network.res.HouseModelRes;
import com.testography.androidmiddlegot.data.network.res.SwornMemberModelRes;

import retrofit2.Call;

public class DataManager {
    private static DataManager INSTANCE = null;

    private RestService mRestService;

    private DataManager() {
        mRestService = ServiceGenerator.createService(RestService.class);
    }

    public static DataManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DataManager();
        }
        return INSTANCE;
    }

    //region ========== Network ==========

    public Call<HouseModelRes> getHouseFromNetwork(int id) {
        return mRestService.getHouse(id);
    }

    public Call<SwornMemberModelRes> getSwornMemberFromNetwork(int id) {
        return mRestService.getSwornMember(id);
    }
    //endregion
}
