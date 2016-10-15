package com.testography.androidmiddlegot.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.testography.androidmiddlegot.R;

import java.util.List;

public class SwornMemberInfoAdapter extends BaseAdapter {

    private List<List<String>> mInfoList;
    private Context mContext;
    private LayoutInflater mInflater;

    public SwornMemberInfoAdapter(Context context, List<List<String>> infoList) {
        mContext = context;
        mInfoList = infoList;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mInfoList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
//        return mInfoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View itemView = convertView;

        if (itemView == null) {
            itemView = mInflater.inflate(R.layout.item_info_list, parent,
                    false);
        }

        TextView label = (TextView) itemView.findViewById(R.id.label_tv);
        label.setText(mInfoList.get(position).get(0));

        TextView info = (TextView) itemView.findViewById(R.id.item_content_tv);
        info.setText(mInfoList.get(position).get(1));

        return itemView;
    }
}
