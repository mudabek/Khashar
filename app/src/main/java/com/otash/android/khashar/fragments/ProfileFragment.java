package com.otash.android.khashar.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.otash.android.khashar.R;

/**
 * Created by Otabek Nazarov on 2/13/2018.
 */

public class ProfileFragment extends Fragment {

    private EditText username;
    private EditText location;
    private Button enterButton;
    private FirebaseAuth mFirebaseAuth;
    private DatabaseReference mDatabase;

    public ProfileFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profile, container, false);
        mFirebaseAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        username = (EditText) v.findViewById(R.id.profile_username);
        location = (EditText) v.findViewById(R.id.profile_location);

        enterButton = (Button) v.findViewById(R.id.profile_button);
        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //mDatabase.child("users").child("username").push().setValue(username.getText());
                mDatabase.child("users").child(mFirebaseAuth.getCurrentUser().getDisplayName())
                        .child("location").setValue(location.getText().toString());
                mDatabase.child("users").child(mFirebaseAuth.getCurrentUser().getDisplayName())
                        .child("username").setValue(username.getText().toString());
            }
        });

        mDatabase.child("users").child(mFirebaseAuth.getCurrentUser().getDisplayName())
                .child("username").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String name = dataSnapshot.getValue(String.class);
                username.setText(name);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mDatabase.child("users").child(mFirebaseAuth.getCurrentUser().getDisplayName())
                .child("location").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String loc = dataSnapshot.getValue(String.class);
                location.setText(loc);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return v;
    }
}
