package com.home.sharedpreference_contactsbackgroundcolor;

import android.Manifest;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE = 1;
    RecyclerView recyclerView;
    List<Contact> contacts;
    SharedPreferences sharedPreferences;
    Set<String> stringSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.listContacts);
        contacts = new ArrayList<>();

        sharedPreferences = getSharedPreferences("myPrefs", MODE_PRIVATE);
        stringSet = sharedPreferences.getStringSet("blueIndex", new HashSet<String>());

        displayContacts();

    }

    public void loadContacts(List<Contact> contacts) {
        if (this.checkSelfPermission(Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, REQUEST_CODE);
        } else {
            Cursor cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);

            for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
                String name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                String number = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

                Contact newContact = new Contact(name, number, false);
                contacts.add(newContact);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CODE && grantResults[0] == PackageManager.PERMISSION_GRANTED)
            displayContacts();
    }

    public void displayContacts() {

        loadContacts(contacts);

        /** Copying contacts so that we'll have a lot of items in the list**/
        if(!contacts.isEmpty()) {
            for (int i = 0; i < 30; i++) {
                Contact contact = contacts.get(i % 3).clone();
                contacts.add(contact);
            }

            /** Setting wether an item is selected or not based on the stringSet saved in the sharedPreferences **/
            for (int i = 0; i < contacts.size(); i++) {
                if (stringSet.contains(String.valueOf(i)))
                    contacts.get(i).setSelected(true);
                else {
                    contacts.get(i).setSelected(false);
                }
            }
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ContactAdapter(contacts, this, sharedPreferences));
    }
}
