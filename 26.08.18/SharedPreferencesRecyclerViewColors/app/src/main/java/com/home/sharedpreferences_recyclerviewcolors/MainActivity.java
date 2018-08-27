package com.home.sharedpreferences_recyclerviewcolors;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnRecyclerViewItemClickedListener {

    RecyclerView recyclerView;
    LinearLayout mainLayout;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences = getSharedPreferences("myPrefs",MODE_PRIVATE);
        String initialColor = preferences.getString("color","none");

        mainLayout = findViewById(R.id.mainLayout);
        List<String> colors = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            colors.add("red");
            colors.add("green");
            colors.add("blue");
            colors.add("yellow");
            colors.add("gray");
        }

        changeBackgroundColor(initialColor);



        recyclerView = findViewById(R.id.listColors);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ColorAdapter(colors, this));

    }

    @Override
    public void onClicked(String color) {
        changeBackgroundColor(color);
    }

    public void changeBackgroundColor(String color){
        switch (color) {
            case "red":
                mainLayout.setBackgroundResource(R.color.red);
                break;

            case "blue":
                mainLayout.setBackgroundResource(R.color.blue);
                break;

            case "green":
                mainLayout.setBackgroundResource(R.color.green);
                break;

            case "yellow":
                mainLayout.setBackgroundResource(R.color.yellow);
                break;

            case "gray":
                mainLayout.setBackgroundResource(R.color.gray);
                break;
            default:

                break;
        }

        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("color",color).commit();
    }
}
