package com.example.hackitall2021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.hackitall2021.Database.Country;

public class Activity3 extends AppCompatActivity {

    private Button back;
    private TextView title;
    private TextView text;
    private Country country;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covid);
        init();
        if(Activity2.getType() == 1) {
            title.setText("COVID-19");
            text.setText("14 Day Notification Rate: " + country.getCase_rate() + "‰\n"
                    + "New Cases: " + country.getNewCases() + "\n" + "New Deaths: "
                    + country.getNewDeaths() + "\n" + "Cases in last 7 days per 1M people: "
                    + country.getAvgCases() + "\n" + "Deaths in last 7 days per 1M people: "
                    + country.getAvgDeaths());
        } else if(Activity2.getType() == 2) {
            title.setText("Weather in " + country.getCapital() + ", " + country.getName());
            text.setText(country.getTemperature() + "°C "  + country.getDescription() +
                    "\n" + "Pressure: " + country.getPressure() + "mb\n" + "Humidity: "
                    + country.getHumidity() + "%");
        }
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void init() {
        back = findViewById(R.id.button2);
        title = findViewById(R.id.titletext);
        text = findViewById(R.id.texttext);
        country = Activity2.getCountry();
    }
}