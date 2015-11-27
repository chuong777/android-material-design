package com.nhc.nhcparsedemo;

import android.app.Application;

import com.nhc.nhcparsedemo.data.Channel;
import com.nhc.nhcparsedemo.data.Student;
import com.parse.Parse;
import com.parse.ParseObject;

/**
 * Created by NHC on 18/11/15.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(this, "mg3tlwUKbMwbcvY95xKPtoVYy17UAY8dYfyyK74C", "14RKRJ2EwLaNyAnl8CaIqqx2OQ6xPCd7KC8R0rM6");
        ParseObject.registerSubclass(Student.class);
        ParseObject.registerSubclass(Channel.class);
    }
}
