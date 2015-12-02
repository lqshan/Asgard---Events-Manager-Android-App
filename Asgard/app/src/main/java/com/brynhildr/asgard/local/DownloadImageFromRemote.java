package com.brynhildr.asgard.local;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;

import com.brynhildr.asgard.DBLayout.events.EventDatabase;
import com.brynhildr.asgard.entities.Event;
import com.brynhildr.asgard.global.MyApplication;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by lqshan on 12/2/15.
 */
public class DownloadImageFromRemote extends AsyncTask<String, Integer, Bitmap> {
    private static final String TAG = "HttpGetImageTask";
    private static final String base_URL = "http://52.34.9.132/static/posters/";

    protected Bitmap doInBackground(String... para1) {
        String data = "";
        String ImageURL = base_URL + para1[0];
        Bitmap posterBitmap = null;
        System.out.println("Start to perform background task, " + ImageURL);
        try {
            posterBitmap = getBitmapFromURL(ImageURL);
        } catch (Exception exception) {
            Log.e(TAG, "Exception");
        }
        return posterBitmap;
    }

    protected void onProgressUpdate(Integer... progress) {
        //setProgressPercent(progress[0]);
    }

    protected void onPostExecute(String result) {
        //showDialog("Downloaded " + result + " bytes");
    }

    public Bitmap getBitmapFromURL(String src) {
        try {
            java.net.URL url = new java.net.URL(src);
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            return BitmapFactory.decodeStream(input);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
