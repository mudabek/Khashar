package com.otash.android.khashar.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Otabek Nazarov on 2/23/2018.
 */

public class User {
    private String mUsername;
    private String mLocation;
    private List<Event> mEvents;

    public User(){}

    public User(String username) {
        mUsername = username;
        mEvents = new ArrayList<Event>();
    }

    public User(String username, String location) {
        mUsername = username;
        mLocation = location;
    }

    public String getUsername () {
        return mUsername;
    }

    public void setUsername(String username) {
        mUsername = username;
    }

    public String getLocation() {
        return mLocation;
    }

    public void setLocation(String location) {
        mLocation = location;
    }

    public void addEvent (Event event) {
        mEvents.add(event);
    }
}
