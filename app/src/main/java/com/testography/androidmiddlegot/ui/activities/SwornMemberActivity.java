package com.testography.androidmiddlegot.ui.activities;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;
import android.widget.TextView;

import com.testography.androidmiddlegot.R;
import com.testography.androidmiddlegot.data.managers.DataManager;
import com.testography.androidmiddlegot.data.storage.models.DaoSession;
import com.testography.androidmiddlegot.data.storage.models.SwornMember;
import com.testography.androidmiddlegot.data.storage.models.SwornMemberDao;
import com.testography.androidmiddlegot.ui.adapters.SwornMemberInfoAdapter;

import java.util.ArrayList;
import java.util.List;

public class SwornMemberActivity extends BaseActivity {

    private Toolbar mToolbar;
    private ListView mListView;

    private SwornMemberInfoAdapter mListAdapter;

    private List<List<String>> mInfo;
    private List<String> mWords;
    private List<String> mBorn;
    private List<String> mTitles;
    private List<String> mAliases;
    private TextView mNameFather;
    private TextView mNameMother;
    private CollapsingToolbarLayout mCollapsingToolbarLayout;

    private DaoSession mDaoSession;
    private String mRemoteId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sworn_member);

        mCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);

        mListView = (ListView) findViewById(R.id.sworn_member_info_lv);

        mDaoSession = DataManager.getInstance().getDaoSession();

        mRemoteId = getIntent().getStringExtra("remoteId").toString();

        mNameFather = (TextView) findViewById(R.id.father_name);
        mNameMother = (TextView) findViewById(R.id.mother_name);

        setContent();

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setupToolbar();
    }

    private List<SwornMember> getSwornMemberFromDb() {
        List<SwornMember> membersList = new ArrayList<>();

        try {
            membersList = mDaoSession.queryBuilder(SwornMember.class)
                    .where(SwornMemberDao.Properties.RemoteId.eq(mRemoteId))
                    .build()
                    .list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return membersList;
    }

    private void setContent() {

        SwornMember swornMember;

        swornMember = getSwornMemberFromDb().get(0);

        if (swornMember != null) {
            mInfo = new ArrayList<>();

            mWords = new ArrayList<>();
            mWords.add("Words");
            mWords.add(swornMember.getWords());
            mInfo.add(mWords);

            mBorn = new ArrayList<>();
            mBorn.add("Born");
            mBorn.add(swornMember.getBorn());
            mInfo.add(mBorn);

            mTitles = new ArrayList<>();
            mTitles.add("Titles");
            mTitles.add(swornMember.getTitles());
            mInfo.add(mTitles);

            mAliases = new ArrayList<>();
            mAliases.add("Aliases");
            mAliases.add(swornMember.getAliases());
            mInfo.add(mAliases);

            mListAdapter = new SwornMemberInfoAdapter(this, mInfo);

            mListView.setAdapter(mListAdapter);

            String fathersName = swornMember.getFather();
            String mothersName = swornMember.getMother();

            if (fathersName.trim() == "") {
                mNameFather.setText("-");
            } else {
                mNameFather.setText(fathersName);
            }

            if (mothersName.trim() == "") {
                mNameMother.setText("-");
            } else {
                mNameMother.setText(fathersName);
            }
            CollapsingToolbarLayout toolbar = (CollapsingToolbarLayout)
                    findViewById(R.id.collapsing_toolbar);
            toolbar.setTitle(swornMember.getName());
        }
    }

    private void setupToolbar() {
        setSupportActionBar(mToolbar);

        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }
}
