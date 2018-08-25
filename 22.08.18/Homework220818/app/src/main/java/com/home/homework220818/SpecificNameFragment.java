package com.home.homework220818;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class SpecificNameFragment extends Fragment {

    private View.OnClickListener btnBackClickListener;
    private String displayedName;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View result = inflater.inflate(R.layout.fragment_specific_name,container,false);
        Button btnBack = result.findViewById(R.id.btnBack);
        TextView textName = result.findViewById(R.id.txtName);
        textName.setText(displayedName);
        btnBack.setOnClickListener(btnBackClickListener);

        return result;
    }

    public void setBtnBackClickListener(View.OnClickListener btnBackClickListener) {
        this.btnBackClickListener = btnBackClickListener;
    }

    public void setDisplayedName(String displayedName) {
        this.displayedName = displayedName;
    }
}
