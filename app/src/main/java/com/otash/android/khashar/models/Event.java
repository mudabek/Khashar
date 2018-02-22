package com.otash.android.khashar.models;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by Otabek Nazarov on 2/19/2018.
 */

public class Event implements Serializable {
    private UUID mId;
    private String mTitle;
    private String mLocation;
    private String mDescription;

    public Event() {
        mId = UUID.randomUUID();
    }

    public Event(String title) {
        mId = UUID.randomUUID();
        mTitle = title;
    }

    public Event(String title, String description, String location) {
        mId = UUID.randomUUID();
        mTitle = title;
        mLocation = location;
        mDescription = description;
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getLocation() {
        return mLocation;
    }

    public void setLocation(String location) {
        mLocation = location;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }
}
