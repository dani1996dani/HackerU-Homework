package com.home.homework220818;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private List<String> myNames= new ArrayList<>();
    private FrameLayout listContainer;
    SpecificNameFragment specificNameFragment;
    ListNameFragment listNameFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0; i < 100; i++) {
            myNames.add("Dani");
            myNames.add("Yolanda");
            myNames.add("Bonnie");
        }

        listContainer = findViewById(R.id.listContainer);

        specificNameFragment = new SpecificNameFragment();
        listNameFragment  = new ListNameFragment();


        specificNameFragment.setBtnBackClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().setCustomAnimations(android.R.animator.fade_in,android.R.animator.fade_out).replace(R.id.listContainer,listNameFragment).commit();
            }
        });



        listNameFragment.setArrayAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,myNames));
        listNameFragment.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                specificNameFragment.setDisplayedName(myNames.get(position));
                getFragmentManager().beginTransaction().setCustomAnimations(android.R.animator.fade_in,android.R.animator.fade_out).replace(R.id.listContainer,specificNameFragment).commit();
            }
        });


        getFragmentManager().beginTransaction().replace(R.id.listContainer,listNameFragment).commit();

    }
}
