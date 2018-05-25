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

import static android.content.ContentValues.TAG;

public class MainActivity extends Activity {
    Button btn_one, btn_two;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    String TAG = MainActivity.class.getSimpleName();

    Date date ;
    DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_one = findViewById(R.id.btn_one);
        btn_two = findViewById(R.id.btn_two);
        Log.d(TAG, dateFormat.format(new Date()) + " onCreate Method is Called");


        btn_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager = getFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.fragment_one, new Fragment_Simple());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        btn_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager = getFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.fragment_one, new MyFragmentOne());
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
}
