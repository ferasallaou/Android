package com.example.android.miwok;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ColorsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);



        final ArrayList<Word> colors = new ArrayList<Word>();
        colors.add(new Word("red","weṭeṭṭi", R.drawable.color_red, R.raw.color_red));
        colors.add(new Word("green","chokokki", R.drawable.color_green, R.raw.color_green));
        colors.add(new Word("brown","ṭakaakki", R.drawable.color_brown, R.raw.color_brown));
        colors.add(new Word("gray","ṭopoppi", R.drawable.color_gray, R.raw.color_gray));
        colors.add(new Word("black","kululli", R.drawable.color_black, R.raw.color_black));
        colors.add(new Word("white","kelelli", R.drawable.color_white, R.raw.color_white));
        colors.add(new Word("dusty yellow","ṭopiisә", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        colors.add(new Word("mustard yellow","chiwiiṭә", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));

        final WordAdapter colorsWordAdapter = new WordAdapter(this, colors, R.color.category_colors);
        ListView newList = (ListView) findViewById(R.id.list);
        newList.setAdapter(colorsWordAdapter);

    }


}
