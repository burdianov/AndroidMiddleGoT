package com.testography.androidmiddlegot.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.testography.androidmiddlegot.R;
import com.testography.androidmiddlegot.data.managers.DataManager;
import com.testography.androidmiddlegot.data.network.res.HouseModelRes;
import com.testography.androidmiddlegot.data.network.res.SwornMemberModelRes;
import com.testography.androidmiddlegot.data.storage.models.House;
import com.testography.androidmiddlegot.data.storage.models.HouseDao;
import com.testography.androidmiddlegot.data.storage.models.SwornMember;
import com.testography.androidmiddlegot.data.storage.models.SwornMemberDao;
import com.testography.androidmiddlegot.utils.AppConfig;
import com.testography.androidmiddlegot.utils.ConstantsManager;
import com.testography.androidmiddlegot.utils.NetworkStatusChecker;
import com.testography.androidmiddlegot.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashScreenActivity extends BaseActivity {

    private DataManager mDataManager;

    private List<String> mSwornMembersUri;
    private List<Integer> mSwornMembersId;

    private HouseDao mHouseDao;
    private SwornMemberDao mSwornMemberDao;
    private int mTimes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        mDataManager = DataManager.getInstance();
        mTimes = 0;
        mHouseDao = mDataManager.getDaoSession().getHouseDao();
        mSwornMemberDao = mDataManager.getDaoSession().getSwornMemberDao();
        showProgress();
        loadHouses(ConstantsManager.houseOne);
        loadHouses(ConstantsManager.houseTwo);
        loadHouses(ConstantsManager.houseThree);
    }

    private void loadHouses(int houseId) {
        if (NetworkStatusChecker.isNetworkAvailable(this)) {
            Call<HouseModelRes> call = mDataManager.getHouseFromNetwork(houseId);

            call.enqueue(new Callback<HouseModelRes>() {
                @Override
                public void onResponse(Call<HouseModelRes> call, Response<HouseModelRes> response) {
                    try {
                        if (response.code() == 200) {
                            HouseModelRes houseModelRes = response.body();

                            House house = new House(houseModelRes);
                            mHouseDao.insertOrReplace(house);

                            int houseId = Utils.getIdFromUri(houseModelRes.getId());
                            String words = houseModelRes.getWords();

//                            mSwornMembersUri = houseModelRes.getSwornMembers();
//                            mSwornMembersId = getSwornMembersIdFromUri(mSwornMembersUri);

                            fetchSwornMembers(getSwornMembersIdFromUri
                                    (houseModelRes.getSwornMembers()), houseId, words);
//                            fetchSwornMembers(mSwornMembersId, houseId, words);
                        }
                    } catch (NullPointerException e) {
                        Log.e("Retrofit error: ", e.toString());
                    }
                }

                @Override
                public void onFailure(Call<HouseModelRes> call, Throwable t) {
                    // TODO: Handle the failure
                }
            });
        }
    }

    private void fetchSwornMembers(final List<Integer> swornMembersId, final int
            houseId, final String words) {

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                for (Integer id : swornMembersId) {
                    Call<SwornMemberModelRes> call = mDataManager.getSwornMemberFromNetwork(id);

                    call.enqueue(new Callback<SwornMemberModelRes>() {
                        @Override
                        public void onResponse(Call<SwornMemberModelRes> call, Response<SwornMemberModelRes> response) {
                            try {
                                SwornMemberModelRes swornMemberModelRes = response.body();
                                SwornMember swornMember = new SwornMember
                                        (swornMemberModelRes, houseId, words);

                                mSwornMemberDao.insertOrReplace(swornMember);
                            } catch (NullPointerException e) {
                                Log.e("Fetch SwornMember error", e.toString());
                            }
                        }

                        @Override
                        public void onFailure(Call<SwornMemberModelRes> call, Throwable t) {
                            // TODO: Handle the error
                        }
                    });
                }

                mTimes++;
                if (mTimes == 3) {
                    Intent intent = new Intent(SplashScreenActivity.this,
                            MainActivity.class);
                    startActivity(intent);
                    hideProgress();
                    finish();
                }
            }
        }, AppConfig.START_DELAY);
    }


    private List<Integer> getSwornMembersIdFromUri(List<String> swornMembersUri) {

        List<Integer> result = new ArrayList<>();

        for (String uri : swornMembersUri) {
            result.add(Utils.getIdFromUri(uri));
        }
        return result;
    }
}
