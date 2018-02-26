package com.otash.android.khashar.activities;

import android.support.v4.app.Fragment;

import com.otash.android.khashar.fragments.NewEventFragment;

/**
 * Created by Otabek Nazarov on 2/26/2018.
 */

public class NewEventActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new NewEventFragment();
    }

}
