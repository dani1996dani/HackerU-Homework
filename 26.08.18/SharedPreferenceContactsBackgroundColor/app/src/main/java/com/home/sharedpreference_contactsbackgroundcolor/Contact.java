package com.home.sharedpreference_contactsbackgroundcolor;

public class Contact implements Cloneable{

    private String name;
    private String number;
    private boolean isSelected;


    public Contact(String name, String number,boolean isSelected) {
        this.name = name;
        this.number = number;
        this.isSelected = isSelected;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                '}';
    }

    @Override
    protected Contact clone() {
        Contact contact = new Contact(this.name,this.number,this.isSelected);
        return contact;
    }
}
