package com.example.hackitall2021.Database;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hackitall2021.R;

import java.util.ArrayList;
import java.util.List;

public class CountryListAdapter extends ArrayAdapter<Country> {

    private Context context;
    private List<Country> countries;
    private List<Country> filteredCountries = new ArrayList<>();

    public CountryListAdapter(Context context, List<Country> countries) {
        super(context, R.layout.autocomplete_custom_layout, countries);
        this.context = context;
        this.countries = countries;
    }

    @Override
    public int getCount() {
        return filteredCountries.size();
    }

    @Override
    public Filter getFilter() {
        return new CountryFilter(this, countries);
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        Country country = filteredCountries.get(position);
        view = LayoutInflater.from(context).inflate(R.layout.autocomplete_custom_layout, parent, false);
        TextView textViewName = (TextView) view.findViewById(R.id.textViewName);
        ImageView imageViewPhoto = (ImageView) view.findViewById(R.id.imageViewPhoto);
        textViewName.setText(country.getName());
        Context context = this.getContext().getApplicationContext();
        int resourceId = context.getResources().getIdentifier("c" + country.getCountryID(), "drawable", context.getPackageName());
        //imageViewPhoto.setImageResource();
        imageViewPhoto.setImageResource(resourceId);
        imageViewPhoto.setMaxWidth(100);
        return view;
    }

    private class CountryFilter extends Filter {
        CountryListAdapter countryListAdapter;
        List<Country> originalList;
        List<Country> filteredList;

        public CountryFilter(CountryListAdapter countryListAdapter, List<Country> originalList) {
            super();
            this.countryListAdapter = countryListAdapter;
            this.originalList = originalList;
            this.filteredList = new ArrayList<>();
        }

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            filteredList.clear();
            final FilterResults results = new FilterResults();
            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(originalList);
            } else {
                final String filterPattern = constraint.toString().toLowerCase().trim();
                for (final Country country : originalList) {
                    if (country.getName().toLowerCase().contains(filterPattern)) {
                        filteredList.add(country);
                    }
                }
            }
            results.values = filteredList;
            results.count = filteredList.size();
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            countryListAdapter.filteredCountries.clear();
            countryListAdapter.filteredCountries.addAll((List) results.values);
            countryListAdapter.notifyDataSetChanged();
        }
    }
}
