package com.testography.androidmiddlegot.ui.adapters;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.testography.androidmiddlegot.R;
import com.testography.androidmiddlegot.ui.activities.MainActivity;
import com.testography.androidmiddlegot.ui.activities.SwornMemberActivity;

import java.util.List;

public class SwornMembersAdapter extends RecyclerView.Adapter<SwornMembersAdapter.
        SwornMemberViewHolder> {

    private MainActivity mMainActivity;
    private List<String> mSwornMembers;

    public SwornMembersAdapter(MainActivity mainActivity, List<String> swornMembers) {
        mMainActivity = mainActivity;
        mSwornMembers = swornMembers;
    }

    @Override
    public SwornMembersAdapter.SwornMemberViewHolder onCreateViewHolder(ViewGroup
                                                                                parent, int viewType) {
        View convertView = LayoutInflater.from(parent.getContext()).inflate(R
                .layout.item_sworn_member, parent, false);

        return new SwornMemberViewHolder(convertView, mMainActivity);
    }

    @Override
    public void onBindViewHolder(final SwornMembersAdapter.SwornMemberViewHolder holder, int position) {
//        holder.mSwornMemberName.setText(mSwornMembers.get(position));
        holder.mSwornMemberName.setText("SWORN MEMBER NAME");
        holder.mInfo.setText("test info info info");
    }

    @Override
    public int getItemCount() {
        return 5;
//        return mSwornMembers.size();
    }

    public static class SwornMemberViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        private MainActivity mActivity;
        private TextView mSwornMemberName;
        private TextView mInfo;
        private ImageView mHouseLogo;

        public SwornMemberViewHolder(View itemView, MainActivity mainActivity) {
            super(itemView);

            mActivity = mainActivity;
            itemView.setOnClickListener(this);

            mSwornMemberName = (TextView) itemView.findViewById(R.id.sworn_member_name_tv);
            mInfo = (TextView) itemView.findViewById(R.id.info_tv);
            mHouseLogo = (ImageView) itemView.findViewById(R.id.house_logo_iv);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(mActivity, SwornMemberActivity.class);
            intent.putExtra("name", "This is a message from the fragment");
            mActivity.startActivity(intent);
        }
    }
}