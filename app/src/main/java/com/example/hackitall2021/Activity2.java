package com.example.hackitall2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;

import com.example.hackitall2021.Database.Country;
import com.example.hackitall2021.Database.CountryListAdapter;
import com.example.hackitall2021.Database.InputLoader;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Activity2 extends AppCompatActivity {

    private AutoCompleteTextView autoCompleteTextViewCountry;
    private Button searchButton;
    private Button buttonCovid;
    private Button buttonAir;
    private Button buttonWeather;
    private TextView alertLevel;
    List<Country> countryList;

    private static Country countrystatic;
    private static int type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        init();
        loadData();
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Country country = getCountryByName(autoCompleteTextViewCountry.getText().toString());
                alertLevel.setText("ALERT LEVEL: " + country.getLevel());
                if(country.getLevel() >= 3) {
                    alertLevel.setTextColor(getResources().getColor(R.color.rosucovid));
                }
                buttonCovid.setText("COVID 19\n14 Day Notification Rate " + country.getCase_rate() + "‰");
                buttonAir.setText("AIR QUALITY\nAQI 2020 (PM2.5): " + country.getAqi() + " µg/m³");
                buttonWeather.setText(country.getCapital() + ", " + country.getName() + "\n" + country.getDescription() + " " + country.getTemperature() + "°C");

                if(country.getDescription().equals("Rain")) {
                    buttonWeather.setCompoundDrawablesWithIntrinsicBounds(R.drawable.rain, 0, 0, 0);
                } else if(country.getDescription().equals("Light snow") || country.getDescription().equals("Snow")) {
                    buttonWeather.setCompoundDrawablesWithIntrinsicBounds(R.drawable.snow, 0, 0, 0);
                } else if(country.getDescription().equals("Cloudy")) {
                    buttonWeather.setCompoundDrawablesWithIntrinsicBounds(R.drawable.cloudy, 0, 0, 0);
                } else if(country.getDescription().equals("Fair") || country.getDescription().equals("Clear")) {
                    buttonWeather.setCompoundDrawablesWithIntrinsicBounds(R.drawable.sun, 0, 0, 0);
                }

                buttonCovid.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        type = 1;
                        countrystatic = country;
                        Intent intent = new Intent(getApplicationContext(), Activity3.class);
                        startActivity(intent);
                    }
                });

                buttonWeather.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        type = 2;
                        countrystatic = country;
                        Intent intent = new Intent(getApplicationContext(), Activity3.class);
                        startActivity(intent);
                    }
                });

            }
        });
    }

    private void init() {
        autoCompleteTextViewCountry = findViewById(R.id.autoCompleteTextViewCountry);
        searchButton = findViewById(R.id.search_button);
        buttonAir = findViewById(R.id.albastru);
        buttonCovid = findViewById(R.id.rosu);
        buttonWeather = findViewById(R.id.verde);
        alertLevel = findViewById(R.id.textView2);
        countryList = new ArrayList<>();
    }

    private void loadData() {
        //autoCompleteTextViewCountry.setHint(getText(R.string.search_country));
        //autoCompleteTextViewCountry.setThreshold(1);
        try {
            InputStream inputStream = getAssets().open("database.json");
            InputLoader inputLoader = new InputLoader(inputStream);
            inputLoader.readData();
            this.countryList = inputLoader.getCountriesList();

            CountryListAdapter adapter = new CountryListAdapter(getApplicationContext(), inputLoader.getCountriesList());
            autoCompleteTextViewCountry.setAdapter(adapter);
            autoCompleteTextViewCountry.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                    autoCompleteTextViewCountry_onItemClick(adapterView, view, position, id);
                }

            });
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void autoCompleteTextViewCountry_onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        Country country = (Country) adapterView.getItemAtPosition(position);
        autoCompleteTextViewCountry.setText(country.getName());
        //buttonCovid.setText("Incidenta COVID-19: " + country.getCase_rate());
        //textViewId.setText(product.getId());
        //textViewName.setText(product.getName());
        //textViewPrice.setText(String.valueOf(product.getPrice()));
        //textViewDescription.setText(product.getDescription());
        //imageViewPhoto.setImageResource(product.getPhoto());
    }

    private Country getCountryByName(String name) {
        Country searchCountry;
        for(Country country : this.countryList) {
            if(country.getName().compareToIgnoreCase(name) == 0) {
                return country;
            }
        }
        return null;
    }

    public static Country getCountry() {
        return countrystatic;
    }

    public static int getType() {
        return type;
    }
}