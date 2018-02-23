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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.otash.android.khashar.R;

/**
 * Created by Otabek Nazarov on 2/13/2018.
 */

public class ProfileFragment extends Fragment {

    private EditText username;
    private EditText location;
    private Button enter;
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

        enter = (Button) v.findViewById(R.id.profile_button);
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDatabase.child("users").child("username").setValue(username.getText());
                mDatabase.child("users").child("location").setValue(location.getText());
            }
        });

        username.setText(mFirebaseAuth.getCurrentUser().getDisplayName());
        //location.setText(mFirebaseAuth.getCurrentUser().ge)
        return v;
    }
}
