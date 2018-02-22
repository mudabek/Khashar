package com.otash.android.khashar.activities;

import android.support.v4.app.Fragment;

import com.otash.android.khashar.fragments.EventFragment;

public class EventActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new EventFragment();
    }
}
