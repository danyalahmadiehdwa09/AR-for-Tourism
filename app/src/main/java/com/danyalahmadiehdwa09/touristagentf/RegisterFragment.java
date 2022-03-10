package com.danyalahmadiehdwa09.touristagentf;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class RegisterFragment extends Fragment {


    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_register, container, false);
        Button btn = view.findViewById(R.id.btn_register);
        TextView email = view.findViewById(R.id.et_email);
        TextView pass = view.findViewById(R.id.et_password2);
        TextView username = view.findViewById(R.id.et_name);
        TextView firstname = view.findViewById(R.id.et_firstname);
        TextView lastname = view.findViewById(R.id.et_lastname);
        TextView error = view.findViewById(R.id.et_error);
        btn.setOnClickListener(v -> {
                savetoDatabase(username,email,pass);

        });
        return view;

    }

    private void savetoDatabase(TextView username, TextView email, TextView pass) {
    }

}