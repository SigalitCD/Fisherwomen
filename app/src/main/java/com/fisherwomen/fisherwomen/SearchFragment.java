package com.fisherwomen.fisherwomen;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Jebia on 7/10/2015.
 */
public class SearchFragment  extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.search_fragment, container, false);
    }

    //TODO: implement openDetails()
    public void openDetails(View view){ }

    //TODO: implement closeDetails()
    public  void closeDetails(View view){}
}
