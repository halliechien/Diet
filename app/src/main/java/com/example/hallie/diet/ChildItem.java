package com.example.hallie.diet;

public class ChildItem {

    private String childNumber;
    private String fullName;
    private String username;
    private boolean isChecked;

    public ChildItem(String fullName, String childNumber, String childName){
        this.fullName = fullName;
        this.childNumber = childNumber;
        this.username = childName;
        this.isChecked = false;
    }

    public void setChecked(boolean isChecked){
        this.isChecked = isChecked;
    }

    public void toggle(){
        this.isChecked = !this.isChecked;
    }

    public boolean getChecked(){
        return this.isChecked;
    }
    public String getChildNumber(){
        return childNumber;
    }

    public String getFullName(){
        return fullName;
    }

    public String getUsername(){
        return username;
    }



}
