package com.lingzhuo.jiufeng.utils;

import android.content.Context;
import android.media.MediaPlayer;

import com.lingzhuo.jiufeng.R;

/**
 * Created by Wang on 2016/7/9.
 */
public class MusicUtils {
    public static MediaPlayer mediaPlayer;
    public static int position = 0;

    public static void playMusic(int position, Context context) {
        stopMusic();
        switch (position) {
            case 0:
                mediaPlayer = MediaPlayer.create(context, R.raw.song1);
                break;
            case 1:
                mediaPlayer = MediaPlayer.create(context, R.raw.song2);
                break;
            case 2:
                mediaPlayer = MediaPlayer.create(context, R.raw.song3);
                break;
            case 3:
                mediaPlayer = MediaPlayer.create(context, R.raw.song4);
                break;
        }
        mediaPlayer.start();
    }

    public static void stopMusic() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
    }

}
