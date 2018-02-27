package com.otash.android.khashar.adapters;

/**
 * Created by Otabek Nazarov on 2/19/2018.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.otash.android.khashar.R;
import com.otash.android.khashar.models.Event;

import java.util.ArrayList;
import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder>
    implements Filterable{

    private List<Event> mEvents;
    private List<Event> mEventsFiltered;

    public EventAdapter(List<Event> events) {
        this.mEvents = events;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public EventAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                      int viewType) {
        // create a new view
        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.event_layout, null);

        // create ViewHolder

        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        // - get data from your itemsData at this position
        // - replace the contents of the view with that itemsData

        viewHolder.txtViewTitle.setText(mEvents.get(position).getTitle());
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    mEventsFiltered = mEvents;
                } else {
                    List<Event> filteredList = new ArrayList<>();
                    for (Event row : mEvents) {

                        // name match condition. this might differ depending on your requirement
                        // here we are looking for name or phone number match
                        if (row.getLocation().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(row);
                        }
                    }

                    mEventsFiltered = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = mEventsFiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                mEventsFiltered = (ArrayList<Event>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    // inner class to hold a reference to each item of RecyclerView
    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView txtViewTitle;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);

            txtViewTitle = (TextView) itemLayoutView.findViewById(R.id.item_title);
        }
        /*
        @Override
        public void onClick(View view) {
            Toast.makeText(view.getContext(), "haaha", Toast.LENGTH_SHORT);
        }*/
    }


    // Return the size of your itemsData (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mEvents.size();
    }
}
