package com.example.thenewapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 秦聪 on 2017/8/3.
 */

public class VideoList extends Fragment {
    private RecyclerView mRecyclerView;
    private List<List<String>> videoData;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        videoData = initVideoData();
        View view=inflater.inflate(R.layout.video_list,container,false);
        mRecyclerView=(RecyclerView)view.findViewById(R.id.recyler_view);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),2,LinearLayoutManager.VERTICAL,false));
        mRecyclerView.setAdapter(new MyAdapter(videoData));
        return view;
    }
    private static List<List<String>> initVideoData() {
        List<List<String>> videoData= new ArrayList<List<String>>();
        List<String> video_1=new ArrayList<>();
        video_1.add("http:001");
        video_1.add("喜羊羊");
        video_1.add("youku_1");
        videoData.add(video_1);
        List<String> video_2=new ArrayList<>();
        video_2.add("http:002");
        video_2.add("灰太狼");
        video_2.add("youku_2");
        videoData.add(video_2);
        List<String> video_3=new ArrayList<>();
        video_3.add("http:002");
        video_3.add("灰太狼");
        video_3.add("youku_2");
        videoData.add(video_3);
        List<String> video_4=new ArrayList<>();
        video_4.add("http:002");
        video_4.add("灰太狼");
        video_4.add("youku_2");
        videoData.add(video_4);

        return videoData;
    }
}
