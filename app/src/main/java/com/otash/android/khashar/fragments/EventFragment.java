package com.otash.android.khashar.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.otash.android.khashar.R;
import com.otash.android.khashar.models.Event;

/**
 * Created by Otabek Nazarov on 2/20/2018.
 */

public class EventFragment extends Fragment {
    public static final String EXTRA_EVENT_ID =
            "com.otash.android.khashar.event_id";

    private Event mEvent;
    private TextView mTitle;
    private TextView mLocation;
    private TextView mDescription;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mEvent = (Event)getActivity().getIntent().getSerializableExtra(EXTRA_EVENT_ID);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_event, container, false);
        mTitle = (TextView) v.findViewById(R.id.event_title);
        mLocation = (TextView) v.findViewById(R.id.event_location);
        mDescription = (TextView) v.findViewById(R.id.event_description);
        mTitle.setText(mEvent.getTitle());
        mLocation.setText(mEvent.getLocation());
        mDescription.setText(mEvent.getDescription());
        return v;
    }
}
