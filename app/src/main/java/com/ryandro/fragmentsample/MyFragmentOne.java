package com.ryandro.fragmentsample;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyFragmentOne extends Fragment {
    String TAG = MyFragmentOne.class.getSimpleName();
    private UserDO userDO;
    private static TextView tv_data;
    private MyDataUpdateListener listener;
    private Button btn_updateData;

    Date date;
    DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        TAG += "_TAG";
        Log.d(TAG, dateFormat.format(new Date()) + " OnStart Method is Called");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, dateFormat.format(new Date()) + " onCreate Method is Called");
        userDO = (UserDO) getArguments().getSerializable("USER_DATA");
        listener = (MyDataUpdateListener) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        Log.d(TAG, dateFormat.format(new Date()) + " onCreateView Method is Called");
        tv_data = (TextView) view.findViewById(R.id.tv_data);
        btn_updateData = (Button) view.findViewById(R.id.btn_updateData);
        btn_updateData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Fragment One Button CLicked:", Toast.LENGTH_SHORT).show();
                userDO.setGender("Female");
                if (userDO != null) {
                    tv_data.setText("Name : " + userDO.getUserName() + "\n Last Name: " + userDO.getUserLastName() +
                            "\n UserId : " + userDO.getUserId() + "\n Gender: " + userDO.getGender());
                }
                listener.onDataChanged(userDO);
            }
        });

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

    protected interface MyDataUpdateListener {
        public void onDataChanged(UserDO userDO);
    }

    public static void udateData(UserDO userDO) {
        if (userDO != null) {
            tv_data.setText("Name : " + userDO.getUserName() + "\n Last Name: " + userDO.getUserLastName() +
                    "\n UserId : " + userDO.getUserId() + "\n Gender: " + userDO.getGender());
        }
    }

    public static void setData(String myData){
        tv_data.setText(myData);
    }
}
