package com.example.hallie.diet;

import java.util.ArrayList;

public class GroupItem {

    private String groupId;
    private String groupTitle;
    private ArrayList<ChildItem> childArray;
    private boolean isChecked;

    public GroupItem(String groupId, String groupTitle){
        this.groupId = groupId;
        this.groupTitle = groupTitle;
        childArray = new ArrayList<ChildItem>();
        //this.isChecked = false;
    }

    /*
    public void setChecked(boolean isChecked){
        this.isChecked = isChecked;
    }

    public void toggle(){
        this.isChecked = !this.isChecked;
    }

    public boolean getChecked(){
        return this.isChecked;
    }

    */
    public String getGroupId(){
        return groupId;
    }

    public String getGroupTitle(){
        return groupTitle;
    }

    public void addChildItem(ChildItem child){
        childArray.add(child);
    }

    public int getChildrenCount(){
        return childArray.size();
    }

    public ChildItem getChildItem(int index){
        return childArray.get(index);
    }


}
