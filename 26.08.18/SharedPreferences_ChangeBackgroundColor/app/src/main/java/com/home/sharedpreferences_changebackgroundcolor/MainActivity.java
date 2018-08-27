package com.home.sharedpreferences_changebackgroundcolor;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout mainLayout;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainLayout = findViewById(R.id.mainLayout);
        preferences = this.getSharedPreferences("myPrefs", MODE_PRIVATE);
        String initialColor = preferences.getString("color", "none");
        setBackgroundColor(initialColor);
    }

    public void changeColor(View view) {
        String tag = (String) view.getTag();

        setBackgroundColor(tag);

        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("color", tag).commit();


    }

    public void setBackgroundColor(String color) {
        switch (color) {
            case "red":
                mainLayout.setBackgroundColor(getResources().getColor(R.color.red, null));
                break;

            case "green":
                mainLayout.setBackgroundColor(getResources().getColor(R.color.green, null));
                break;

            case "blue":
                mainLayout.setBackgroundColor(getResources().getColor(R.color.blue, null));
                break;
            default:
                mainLayout.setBackgroundColor(getResources().getColor(R.color.none, null));
                break;
        }
    }
}
