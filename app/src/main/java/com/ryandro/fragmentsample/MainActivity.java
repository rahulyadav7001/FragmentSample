package com.ryandro.fragmentsample;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends Activity implements Fragment_Simple.MyInterface, MyFragmentOne.MyDataUpdateListener {
    Button btn_one, btn_two;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    String TAG = MainActivity.class.getSimpleName();
    Date date;
    DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
    private UserDO userDO;
    String myData = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_one = findViewById(R.id.btn_one);
        btn_two = findViewById(R.id.btn_two);
        TAG += "_TAG";
        Log.d(TAG, dateFormat.format(new Date()) + " onCreate Method is Called");
        myData = "Welcome to Silver Axis";
        userDO = new UserDO("John", "12232", "Parker", "Male");

        btn_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager = getFragmentManager();
                Fragment_Simple fragment_simple = new Fragment_Simple();
                Bundle argu = new Bundle();
                argu.putString("DATA_VALUE", myData);
                fragment_simple.setArguments(argu);
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.fragment_one, fragment_simple);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        btn_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyFragmentOne myFragmentOne = new MyFragmentOne();
                Bundle myData = new Bundle();
                myData.putSerializable("USER_DATA", userDO);
                fragmentManager = getFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                myFragmentOne.setArguments(myData);
                fragmentTransaction.add(R.id.fragment_two, myFragmentOne);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, dateFormat.format(new Date()) + " onStart Method is Called");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, dateFormat.format(new Date()) + " onResume Method is Called");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, dateFormat.format(new Date()) + " onPause Method is Called");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, dateFormat.format(new Date()) + " onStop Method is Called");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, dateFormat.format(new Date()) + " onRestart Method is Called");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, dateFormat.format(new Date()) + " onDestroy Method is Called");

    }

    @Override
    public void onDataChanged(UserDO userDO) {
        this.userDO = userDO;
        Fragment_Simple.udateData(userDO);
    }

    @Override
    public void OnUpdateData(String myData) {
        MyFragmentOne.setData(myData);
    }
}
