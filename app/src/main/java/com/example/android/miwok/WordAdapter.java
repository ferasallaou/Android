package com.example.android.miwok;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Feras on 8/4/16.
 */
public class WordAdapter extends ArrayAdapter<Word> {
    private MediaPlayer mp;
    private int colorResourceVal;

    public WordAdapter(Activity context, ArrayList<Word> wordList, int colorResource)
    {
        super(context, 0, wordList);
        this.colorResourceVal = colorResource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final Word currentItem = getItem(position);
        View listItemView = convertView;
        if (listItemView == null)
        {
           listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        TextView OriginalTextView = (TextView) listItemView.findViewById(R.id.original);
        OriginalTextView.setText(currentItem.getmDefaultTranslation());

        TextView TranslationTextView = (TextView) listItemView.findViewById(R.id.translate);
        TranslationTextView.setText(currentItem.getmMiwokTranslation());

        ImageView ourImageView = (ImageView) listItemView.findViewById(R.id.image);
        if (currentItem.hasImage())
        {
            ourImageView.setImageResource(currentItem.getmImageLink());
            ourImageView.setVisibility(View.VISIBLE);
        }else{
         ourImageView.setVisibility(View.GONE);
        }

        View textContainer = (View) listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(), colorResourceVal);
        textContainer.setBackgroundColor(color);

        listItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                releaseMediaPlayer();
                mp = MediaPlayer.create(getContext(), currentItem.getAudioFile());
                mp.start();
            }
        });
        return listItemView;


    }
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mp != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mp.release();


            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mp = null;
        }
    }
    private MediaPlayer.OnCompletionListener onCompletionListner = new MediaPlayer.OnCompletionListener()
    {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();


        }
    };



}