package com.example.ryan.testapp;


/**
 * Created by Ryan on 1/26/2018.
 */
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class NIMHtreatment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle saveInstancedState){
        return inflater.inflate(R.layout.fragment_treatments_nimh,null);
    }

}
