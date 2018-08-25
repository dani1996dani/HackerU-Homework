package com.home.homework220818;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class ListNameFragment extends android.app.Fragment {

    List<String> names;
    ArrayAdapter<String> arrayAdapter;
    private AdapterView.OnItemClickListener onItemClickListener;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View result = inflater.inflate(R.layout.fragment_list_names,container,false);
        ListView listNames = result.findViewById(R.id.listNames);
        listNames.setAdapter(arrayAdapter);
        listNames.setOnItemClickListener(onItemClickListener);



        return result;
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public void setArrayAdapter(ArrayAdapter<String> arrayAdapter) {
        this.arrayAdapter = arrayAdapter;
    }
}
