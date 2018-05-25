package com.ryandro.fragmentsample;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyFragmentOne extends Fragment {
    String TAG = MyFragmentOne.class.getSimpleName();

    Date date ;
    DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(TAG, dateFormat.format(new Date()) + " OnStart Method is Called");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, dateFormat.format(new Date()) + " onCreate Method is Called");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one,container,false);
        Log.d(TAG, dateFormat.format(new Date()) + " onCreateView Method is Called");
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, dateFormat.format(new Date()) + " onActivityCreated Method is Called");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, dateFormat.format(new Date()) + " onStart Method is Called");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, dateFormat.format(new Date()) + " onResume Method is Called");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, dateFormat.format(new Date()) + " onPause Method is Called");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, dateFormat.format(new Date()) + " onSaveInstanceState Method is Called");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, dateFormat.format(new Date()) + " onStop Method is Called");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, dateFormat.format(new Date()) + " onDestroyView Method is Called");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, dateFormat.format(new Date()) + " onDestroy Method is Called");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, dateFormat.format(new Date()) + " onDetach Method is Called");
    }
}
