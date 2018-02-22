package com.otash.android.khashar.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.otash.android.khashar.activities.EventActivity;
import com.otash.android.khashar.adapters.EventAdapter;
import com.otash.android.khashar.R;
import com.otash.android.khashar.utilities.RecyclerItemClickListener;
import com.otash.android.khashar.models.Event;


/**
 * Created by Otabek Nazarov on 2/13/2018.
 */


public class EventListFragment extends Fragment {
    public EventListFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_events_list, container, false);
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        final Event events[] = {new Event("Event 1", "NY", "Go out and help people"), new Event("Event 2", "Grinnell", "All for one")};
        final EventAdapter mAdapter = new EventAdapter(events);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getContext(), recyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        Intent i = new Intent(getActivity(), EventActivity.class);
                        i.putExtra(EventFragment.EXTRA_EVENT_ID, events[position]);
                        startActivity(i);
                    }

                    @Override public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                })
        );


        return rootView;

    }
}
