package com.nhc.nhcparsedemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.nhc.nhcparsedemo.data.Channel;
import com.nhc.nhcparsedemo.data.Student;
import com.parse.FunctionCallback;
import com.parse.GetCallback;
import com.parse.GetDataCallback;
import com.parse.ParseCloud;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseQuery;
import com.parse.ProgressCallback;
import com.parse.SaveCallback;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        uploadFile();
//        downloadFile();
        checkCloudCode();
    }

    private void uploadData() {
        Student student1 = new Student("chuong", 23);
        student1.getEmail();
        student1.saveInBackground();
        Student student2 = new Student("nam", 18);
        student2.saveInBackground();
    }

    private void uploadFile() {
        try {
            InputStream inputStream = getAssets().open("song.mp3");
            byte[] data = new byte[inputStream.available()];
            inputStream.read(data);
            ParseFile uploadFile = new ParseFile("song.mp3", data);
            Channel channel = new Channel("song", uploadFile);
            channel.saveAllInBackground(new SaveCallback() {
                @Override
                public void done(ParseException e) {
                    Log.e("nhc", "saved");
                }
            }, new ProgressCallback() {
                @Override
                public void done(Integer percentDone) {
                    Log.e("nhc", "" + percentDone);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void downloadFile() {
        ParseQuery<Channel> query = ParseQuery.getQuery("Channel");
        query.getInBackground("qaMWnkSfYU", new GetCallback<Channel>() {
            @Override
            public void done(Channel object, ParseException e) {
                Log.e("nhc", "get done");
                ParseFile file = object.getFile();
                file.getDataInBackground(new GetDataCallback() {
                    @Override
                    public void done(byte[] data, ParseException e) {
                        Log.e("nhc", "x");
                    }
                });
            }
        });
    }

    private void checkCloudCode() {
        Map<String, Integer> params = new HashMap<>();
        params.put("num", 1);
        ParseCloud.callFunctionInBackground("checkNum", params, new FunctionCallback<Integer>() {
            @Override
            public void done(Integer object, ParseException e) {
                Log.e("nhc", "x");
            }
        });
    }
}
