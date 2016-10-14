package com.testography.androidmiddlegot.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.testography.androidmiddlegot.R;
import com.testography.androidmiddlegot.data.managers.DataManager;
import com.testography.androidmiddlegot.data.network.res.HouseModelRes;
import com.testography.androidmiddlegot.data.network.res.SwornMemberModelRes;
import com.testography.androidmiddlegot.utils.NetworkStatusChecker;
import com.testography.androidmiddlegot.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashScreenActivity extends AppCompatActivity {

    private Button mGoToButton;
    private DataManager mDataManager;
    private List<String> mSwornMembersUri;
    private List<Integer> mSwornMembersId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        mDataManager = DataManager.getInstance();

        mGoToButton = (Button) findViewById(R.id.go_to_btn);

        mGoToButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SplashScreenActivity.this,
                        MainActivity.class);

                ArrayList<String> testData = new ArrayList<>();
//                testData.add("Vasilica");
//                testData.add("Petrica");
//                testData.add("Jorica");

                intent.putExtra("test", testData);
                startActivity(intent);
                finish();
            }
        });

        loadHouses();
    }

    private void loadHouses() {
        if (NetworkStatusChecker.isNetworkAvailable(this)) {
            Call<HouseModelRes> call = mDataManager.getHouseFromNetwork(40);

            call.enqueue(new Callback<HouseModelRes>() {
                @Override
                public void onResponse(Call<HouseModelRes> call, Response<HouseModelRes> response) {
                    try {
                        if (response.code() == 200) {
                            HouseModelRes houseModelRes = response.body();

                            int houseId = Utils.getIdFromUri(houseModelRes.getId());
                            String words = houseModelRes.getWords();

                            mSwornMembersUri = houseModelRes.getSwornMembers();
                            mSwornMembersId = getSwornMembersIdFromUri(mSwornMembersUri);

                            fetchSwornMembers(mSwornMembersId, houseId, words);
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

    private void fetchSwornMembers(List<Integer> swornMembersId, int houseId,
                                   String words) {
        for (Integer id : swornMembersId) {
            Call<SwornMemberModelRes> call = mDataManager.getSwornMemberFromNetwork(id);

            call.enqueue(new Callback<SwornMemberModelRes>() {
                @Override
                public void onResponse(Call<SwornMemberModelRes> call, Response<SwornMemberModelRes> response) {
                    try {
                        SwornMemberModelRes swornMemberModelRes = response.body();

                    } catch (NullPointerException e) {
                        Log.e("Fetch SwornMember error", e.toString());
                    }
                }

                @Override
                public void onFailure(Call<SwornMemberModelRes> call, Throwable t) {

                }
            });
        }
    }


    private List<Integer> getSwornMembersIdFromUri(List<String> swornMembersUri) {

        List<Integer> result = new ArrayList<>();

        for (String uri : swornMembersUri) {
            result.add(Utils.getIdFromUri(uri));
        }
        return result;
    }
}
