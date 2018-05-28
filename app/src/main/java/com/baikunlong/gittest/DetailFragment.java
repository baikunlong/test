package com.baikunlong.gittest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by baikunlong on 2018/5/22.
 */

class DetailFragment extends Fragment {
    public static DetailFragment newInstance(int index) {
        DetailFragment f = new DetailFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("index", index);
        f.setArguments(bundle);
        return f;
    }

    public int getShownIndex(){
        return getArguments().getInt("index",0);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(container==null)
            return null;
        TextView text = new TextView(getActivity());
//        text.setText(Data.DETAIL[getShownIndex()]);
        text.setText(DataBase.getPersons().get(getShownIndex()).getName());
//        text.setText("啊啊啊啊啊啊啊啊啊");
        return text;
    }
}
