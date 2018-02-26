package com.otash.android.khashar.fragments;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.otash.android.khashar.R;
import com.otash.android.khashar.models.Event;

/**
 * Created by Otabek Nazarov on 2/26/2018.
 */

public class NewEventFragment extends Fragment {

    private EditText mNewEventTitle;
    private EditText mNewEventDescription;
    private EditText mNewEventLocation;
    private Button mNewEventButton;
    private FirebaseDatabase mDatabase;
    private DatabaseReference mEventsDatabaseReference;

    public NewEventFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_new_event, container, false);

        mNewEventButton = (Button) v.findViewById(R.id.new_event_button);
        mNewEventTitle = (EditText) v.findViewById(R.id.new_event_title);
        mNewEventDescription = (EditText) v.findViewById(R.id.new_event_description);
        mNewEventLocation = (EditText) v.findViewById(R.id.new_event_location);

        mDatabase = FirebaseDatabase.getInstance();
        mEventsDatabaseReference = mDatabase.getReference().child("events");
        mNewEventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Event event = new Event(mNewEventTitle.getText().toString(),
                        mNewEventDescription.getText().toString(),
                        mNewEventLocation.getText().toString());
                mEventsDatabaseReference.push().setValue(event);
                getActivity().onBackPressed();
            }
        });

        return v;
    }
}
