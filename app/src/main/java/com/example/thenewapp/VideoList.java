package com.example.thenewapp;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.Request;

/**
 * Created by 秦聪 on 2017/8/3.
 */

public class VideoList extends Fragment {
    private RecyclerView mRecyclerView;
    private List<List<String>> videoData;
    private MyAdapter myAdapter;
    private OkHttpClient okHttpClient;

    String res;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        videoData = new ArrayList<List<String>>();
        //videoData = initVideoData();
        final View view = inflater.inflate(R.layout.video_list, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyler_view);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2, LinearLayoutManager.VERTICAL, false));

        //mRecyclerView.setAdapter(myAdapter);
        //mAdapter.notifyDataSetChanged()
        final Handler mHandler = new Handler() {
            public void handleMessage(Message msg) {
                myAdapter = new MyAdapter(videoData);
                mRecyclerView.setAdapter(myAdapter);
            }
        };
        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder().url("http://119.29.173.76/getvideomessage.php").build();
                try {
                Response response = client.newCall(request).execute();
                    if (response.isSuccessful()) {
                        res = response.body().string();
                    } else {
                        throw new IOException("Unexpected code " + response);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Gson gson=new Gson();
                Log.w("qincong", res);
                videoData=initVideoData();
                String s2=gson.toJson(videoData);
                videoData = gson.fromJson(res,
                        new TypeToken<List<List<String>>>() {
                        }.getType());
                mHandler.sendMessage(new Message());
            }
        }).start();

        return view;
    }


    private static List<List<String>> initVideoData() {
        List<List<String>> videoData = new ArrayList<List<String>>();
        List<String> video_1 = new ArrayList<>();
        video_1.add("http:001");
        video_1.add("喜羊羊");
        video_1.add("youku_1");
        videoData.add(video_1);
        List<String> video_2 = new ArrayList<>();
        video_2.add("http:002");
        video_2.add("灰太狼");
        video_2.add("youku_2");
        videoData.add(video_2);
        List<String> video_3 = new ArrayList<>();
        video_3.add("http:002");
        video_3.add("灰太狼");
        video_3.add("youku_2");
        videoData.add(video_3);
        List<String> video_4 = new ArrayList<>();
        video_4.add("http:002");
        video_4.add("灰太狼");
        video_4.add("youku_2");
        videoData.add(video_4);

        return videoData;
    }
}
