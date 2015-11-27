package com.nhc.nhcparsedemo.data;

import com.parse.ParseClassName;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ProgressCallback;
import com.parse.SaveCallback;

/**
 * Created by NHC on 18/11/15.
 */
@ParseClassName("Channel")
public class Channel extends ParseObject {
    private String name;
    private ParseFile file;

    public Channel(){}

    public Channel(String name, ParseFile jsonFile) {
        setName(name);
        setJsonFile(jsonFile);
    }

    public String getName() {
        if (name == null) name = getString("name");
        return name;
    }

    public void setName(String name) {
        this.name = name;
        put("name", name);
    }

    /**
    * This won't download the file, use ParseFile.getData() to get data of the file
    */
    public ParseFile getFile() {
        if (file == null) file = getParseFile("json");
        return file;
    }

    public void setJsonFile(ParseFile file) {
        this.file = file;
        put("json", file);
    }
    /**
     * The method saveAllInBackground() will upload file to server too,
     * but it doesn't have a progress callback. This method provide a progress callback
     * to track upload progress
     */
    public void saveAllInBackground(final SaveCallback saveCallback, final ProgressCallback progressCallback) {
        file.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null) {
                    Channel.super.saveInBackground(new SaveCallback() {
                        @Override
                        public void done(ParseException e) {
                            saveCallback.done(e);
                        }
                    });
                }
                else {
                    saveCallback.done(e);
                }
            }
        }, new ProgressCallback() {
            @Override
            public void done(Integer percentDone) {
                progressCallback.done(percentDone);
            }
        });
    }
}
