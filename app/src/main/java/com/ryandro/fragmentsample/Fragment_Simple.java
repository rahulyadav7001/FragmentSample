package com.ryandro.fragmentsample;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class Fragment_Simple extends Fragment {
    private static TextView tv_data;
    private Button btn_upodateData;
    private String mydata;
    private MyInterface myInterface;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mydata = getArguments().getString("DATA_VALUE");
        myInterface = (MyInterface) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_simple_layout, container, false);
        tv_data = view.findViewById(R.id.tv_data);
        btn_upodateData = view.findViewById(R.id.btn_fragmentOneData);

        btn_upodateData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mydata != null) {
                    tv_data.setText(mydata);
                    myInterface.OnUpdateData(mydata);
                }
            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public static void udateData(UserDO userDO) {
        if (userDO != null) {
            tv_data.setText("Name : " + userDO.getUserName() + "\n Last Name: " + userDO.getUserLastName() +
                    "\n UserId : " + userDO.getUserId() + "\n Gender: " + userDO.getGender());
        }
    }

    public interface MyInterface {
        public void OnUpdateData(String s);
    }
}
