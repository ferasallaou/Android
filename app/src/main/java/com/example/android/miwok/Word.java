package com.example.android.miwok;

/**
 * Created by Feras on 8/4/16.
 */
public class Word {

    private String mDefaultTranslation;
    private String mMiwokTranslation;

    private int audioFile;

    private int mImageLink = -1;

    public Word(String mDefault, String mMiWok, int mImage, int audioFileID)
    {
        this.mDefaultTranslation = mDefault;
        this.mMiwokTranslation = mMiWok;
        this.mImageLink = mImage;
        this.audioFile = audioFileID;
    }

    public Word(String mDefault, String mMiWok, int audioFileID)
    {
        this.mDefaultTranslation = mDefault;
        this.mMiwokTranslation = mMiWok;
        this.audioFile = audioFileID;
    }

    public String getmDefaultTranslation()
    {
        return this.mDefaultTranslation;
    }

    public String getmMiwokTranslation()
    {
        return this.mMiwokTranslation;
    }

    public int getmImageLink() { return this.mImageLink;}

    public boolean hasImage()
    {
    if (mImageLink == -1)
        return false;
        else
        return true;
    }

    public int getAudioFile() {return this.audioFile; }


    @Override
    public String toString() {
        return "Word{" +
                "mDefaultTranslation='" + mDefaultTranslation + '\'' +
                ", mMiwokTranslation='" + mMiwokTranslation + '\'' +
                ", audioFile=" + audioFile +
                ", mImageLink=" + mImageLink +
                '}';
    }
}
