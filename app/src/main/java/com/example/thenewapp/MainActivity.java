package com.example.thenewapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toast.makeText(getApplicationContext(),"sd",Toast.LENGTH_SHORT).show();
        final ArrayList<LinearLayout> linearLayoutArrayList=new ArrayList<>();
        linearLayoutArrayList.add((LinearLayout)findViewById(R.id.tab_1));
        linearLayoutArrayList.add((LinearLayout)findViewById(R.id.tab_2));
        linearLayoutArrayList.add((LinearLayout)findViewById(R.id.tab_3));
        linearLayoutArrayList.add((LinearLayout)findViewById(R.id.tab_4));

        final ArrayList<ImageView> img_list=new ArrayList<ImageView>();
        img_list.add((ImageView)((LinearLayout)linearLayoutArrayList.get(0).getChildAt(1)).getChildAt(0));
        img_list.add((ImageView)((LinearLayout)linearLayoutArrayList.get(1).getChildAt(1)).getChildAt(0));
        img_list.add((ImageView)((LinearLayout)linearLayoutArrayList.get(2).getChildAt(1)).getChildAt(0));
        img_list.add((ImageView)((LinearLayout)linearLayoutArrayList.get(3).getChildAt(1)).getChildAt(0));
        for(final LinearLayout linearLayout:linearLayoutArrayList) {
            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    img_list.get(0).setImageResource(R.mipmap.thunder_unclick);
                    img_list.get(1).setImageResource(R.mipmap.dance_unclick);
                    img_list.get(2).setImageResource(R.mipmap.chat_unclick);
                    img_list.get(3).setImageResource(R.mipmap.me_unclick);
                    switch(linearLayoutArrayList.indexOf(linearLayout)) {
                        case 0:
                            img_list.get(0).setImageResource(R.mipmap.thunder);
                            break;
                        case 1:
                            img_list.get(1).setImageResource(R.mipmap.dance);
                            break;
                        case 2:
                            img_list.get(2).setImageResource(R.mipmap.chat);
                            break;
                        case 3:
                            img_list.get(3).setImageResource(R.mipmap.me);
                            break;
                    }
                }
            });
        }

    }
}
