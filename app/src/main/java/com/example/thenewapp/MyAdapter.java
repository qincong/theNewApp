package com.example.thenewapp;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 秦聪 on 2017/8/3.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHloder>{
    private List<List<String>> video_data;
    public MyAdapter(List<List<String>> video_data) {
        this.video_data=video_data;
        Log.w("qincong","data has"+video_data.size()+"xiang");
    }
    @Override
    public ViewHloder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        ViewHloder vh=new ViewHloder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHloder holder, int position) {
        //holder.img.setImageResource(R.drawable.img);
        String s=video_data.get(position).get(1);
        holder.videoName.setText(video_data.get(position).get(1));



    }

    @Override
    public int getItemCount() {
        return video_data.size();
    }

    class ViewHloder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView videoName;
        public ViewHloder(View itemView) {
            super(itemView);
            img=(ImageView)itemView.findViewById(R.id.video_img);
            videoName=(TextView)itemView.findViewById(R.id.video_name);
        }
    }
}
