package com.home.sharedpreferences_recyclerviewcolors;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ColorAdapter extends RecyclerView.Adapter<ColorViewHolder> {

    private List<String> colors;
    private OnRecyclerViewItemClickedListener onRecyclerViewItemClickedListener;

    public ColorAdapter(List<String> colors,OnRecyclerViewItemClickedListener onRecyclerViewItemClickedListener) {
        this.colors = colors;
        this.onRecyclerViewItemClickedListener = onRecyclerViewItemClickedListener;
    }

    @NonNull
    @Override
    public ColorViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.color_item, viewGroup, false);
        return new ColorViewHolder(view,onRecyclerViewItemClickedListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ColorViewHolder viewHolder, int i) {
        viewHolder.colorText.setText(colors.get(i));
        viewHolder.colorText.setTag(colors.get(i));
    }

    @Override
    public int getItemCount() {
        return colors.size();
    }

}

class ColorViewHolder extends RecyclerView.ViewHolder {

    TextView colorText;
    OnRecyclerViewItemClickedListener recyclerViewItemClickedListener;

    public ColorViewHolder(@NonNull View itemView,OnRecyclerViewItemClickedListener onRecyclerViewItemClickedListener) {
        super(itemView);
        colorText = itemView.findViewById(R.id.txtColor);
        recyclerViewItemClickedListener = onRecyclerViewItemClickedListener;

        colorText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recyclerViewItemClickedListener.onClicked((String) colorText.getTag());
            }
        });

    }
}

interface OnRecyclerViewItemClickedListener {
    void onClicked(String color);
}
