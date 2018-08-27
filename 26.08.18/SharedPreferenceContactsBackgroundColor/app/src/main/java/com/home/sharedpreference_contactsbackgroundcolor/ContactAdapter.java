package com.home.sharedpreference_contactsbackgroundcolor;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactAdapter extends RecyclerView.Adapter<ContactViewHolder> {

    private List<Contact> contacts;
    Context context;
    private SharedPreferences preferences;
    SharedPreferences.Editor editor;

    public ContactAdapter(List<Contact> contacts, Context context, SharedPreferences sharedPreferences) {
        this.contacts = contacts;
        this.context = context;
        this.preferences = sharedPreferences;
        editor = preferences.edit();
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.contact_item, viewGroup, false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ContactViewHolder viewHolder, final int i) {
        final Contact contact = contacts.get(i);
        viewHolder.txtName.setText(contact.getName() + i);
        viewHolder.txtNumber.setText(contact.getNumber());
        if (contact.isSelected())
            viewHolder.txtName.setBackgroundColor(context.getResources().getColor(R.color.lightblue));
        else {
            viewHolder.txtName.setBackgroundColor(0xffffffff);
        }

        viewHolder.txtName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contacts.get(i).setSelected(true);
                viewHolder.txtName.setBackgroundColor(context.getResources().getColor(R.color.lightblue));
                Set<String> set = new HashSet<>(preferences.getStringSet("blueIndex", new HashSet<String>()));
                set.add(String.valueOf(i));
                //editor.remove("blueIndex");
                editor.putStringSet("blueIndex", set).commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }
}

class ContactViewHolder extends RecyclerView.ViewHolder {

    TextView txtName, txtNumber;

    public ContactViewHolder(@NonNull View itemView) {
        super(itemView);
        txtName = itemView.findViewById(R.id.txtName);
        txtNumber = itemView.findViewById(R.id.txtNumber);
    }
}
