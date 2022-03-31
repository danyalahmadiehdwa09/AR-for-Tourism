package com.danyalahmadiehdwa09.touristagentf;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.io.IOException;

import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LoginFragment extends Fragment {


    public LoginFragment() {
        // Required empty public constructor
    }

    public static Thread login = new Thread(new Runnable() {
        private OkHttpClient client = new OkHttpClient();
        public String username;
        public String password;

        @Override
        public void run() {
            RequestBody requestBody = new MultipartBody.Builder()
                    .setType(MultipartBody.FORM)
                    .addFormDataPart("username", username)
                    .addFormDataPart("password", password)
                    .build();


            Log.d("string",String.valueOf(username));
            Log.d("string",String.valueOf(password));

            Request request = new Request.Builder()
                    .url("http://127.0.0.1:5000/login")
                    .post(requestBody)
                    .build();

            try (Response response = client.newCall(request).execute()) {
                if (response.isSuccessful()){
                    Log.d("rep","it worked");
                }
                if (!response.isSuccessful()) try {
                    Log.d("rep","did not worked");
                    throw new IOException("Unexpected code " + response);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    });

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_login, container, false);
        Button btn = view.findViewById(R.id.btn_login);
        TextView user = view.findViewById(R.id.et_name);
        TextView pass = view.findViewById(R.id.et_password);
        TextView error = view.findViewById(R.id.et_error);
        btn.setOnClickListener(v -> {
             Thread login = new Thread(new Runnable() {
                private OkHttpClient client = new OkHttpClient();
                public String username = String.valueOf(user.getText());
                public String password = String.valueOf(pass.getText());

                @Override
                public void run() {
                    RequestBody requestBody = new MultipartBody.Builder()
                            .setType(MultipartBody.FORM)
                            .addFormDataPart("username", username)
                            .addFormDataPart("password", password)
                            .build();


                    Log.d("string",String.valueOf(username));
                    Log.d("string",String.valueOf(password));

                    Request request = new Request.Builder()
                            .url("http://127.0.0.1:5000/login")
                            .post(requestBody)
                            .build();

                    try (Response response = client.newCall(request).execute()) {
                        if (response.isSuccessful()){
                            Log.d("rep","it worked");
                        }
                        if (!response.isSuccessful()) try {
                            Log.d("rep","did not worked");
                            throw new IOException("Unexpected code " + response);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
             login.start();
//            OkHttpClient client = new OkHttpClient();
//
//            RequestBody requestBody = new MultipartBody.Builder()
//                    .setType(MultipartBody.FORM)
//                    .addFormDataPart("username", String.valueOf(username.getText()))
//                    .addFormDataPart("password", String.valueOf(pass.getText()))
//                    .build();
//
//
//            Log.d("string",String.valueOf(username.getText()));
//            Log.d("string",String.valueOf(pass.getText()));
//
//            Request request = new Request.Builder()
//                    .url("http://127.0.0.1:5000/login")
//                    .post(requestBody)
//                    .build();
//
//            try (Response response = client.newCall(request).execute()) {
//                if (response.isSuccessful()){
//                    Log.d("rep","it worked");
//                }
//                if (!response.isSuccessful()) try {
//                    Log.d("rep","did not worked");
//                    throw new IOException("Unexpected code " + response);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }



        });
        return view;
    }

}