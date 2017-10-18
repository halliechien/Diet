package com.example.hallie.diet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.ArrayList;


public class ElvAdapter extends BaseExpandableListAdapter
                            implements ExpandableListView.OnChildClickListener {

    private Context mcontext;
    private ArrayList<GroupItem> mgroups;

    public ElvAdapter(Context mcontext, ArrayList<GroupItem> mgroups){
        this.mcontext = mcontext;
        this.mgroups = mgroups;
    }


    @Override
    public int getGroupCount() {
        return mgroups.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return mgroups.get(groupPosition).getChildrenCount();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return mgroups.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return mgroups.get(groupPosition).getChildItem(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupItem gp = (GroupItem) getGroup(groupPosition);

        if (convertView == null){
            LayoutInflater lain = (LayoutInflater)mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = lain.inflate(R.layout.activity_group_item, null);
        }

        TextView tv = (TextView)convertView.findViewById(R.id.tv_groupTitle);
        tv.setText(gp.getGroupTitle());

       /*
        CheckBox checkBox = (CheckBox) convertView.findViewById(R.id.chbGroup);
        checkBox.setChecked(gp.getChecked());

        checkBox.setOnClickListener(new Group_CheckBox_Click(groupPosition));
        */
        return convertView;
    }
    /*
    class Group_CheckBox_Click implements View.OnClickListener{
        private int groupPosition;

        Group_CheckBox_Click(int grouupPosition){
            this.groupPosition = grouupPosition;
        }

        @Override
        public void onClick(View v) {
            mgroups.get(groupPosition).toggle();

            //
            int childrenCount = mgroups.get(groupPosition).getChildrenCount();
            boolean groupIsChecked = mgroups.get(groupPosition).getChecked();
            for(int i=0; i<childrenCount; i++)
                mgroups.get(groupPosition).getChildItem(i).setChecked(groupIsChecked);

            notifyDataSetChanged();
        }
    }*/


    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        ChildItem ci = mgroups.get(groupPosition).getChildItem(childPosition);

        if(convertView == null){
            LayoutInflater lain = (LayoutInflater)mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = lain.inflate(R.layout.activity_child_item, null);
        }

        TextView tv = convertView.findViewById(R.id.tv_child);
        tv.setText(ci.getFullName());

        CheckBox cb = convertView.findViewById(R.id.cb_childSelect);
        cb.setChecked(ci.getChecked());

        cb.setOnClickListener(new Child_CheckBox_Click(groupPosition, childPosition));

        return convertView;
    }

    class Child_CheckBox_Click implements View.OnClickListener{
        private int groupPosition;
        private int childPosition;

        Child_CheckBox_Click(int grouupPosition, int childPosition){
            this.groupPosition = grouupPosition;
            this.childPosition = childPosition;
        }

        @Override
        public void onClick(View view) {
            handleClick(childPosition, groupPosition);
        }
    }

    public void handleClick(int childPosition, int groupPosition){
        mgroups.get(groupPosition).getChildItem(childPosition).toggle();

        /*
        int childrenCount = mgroups.get(groupPosition).getChildrenCount();
        boolean childrenAlIsChecked = true;
        for(int i=0; i<childrenCount; i++){
            if(!mgroups.get(groupPosition).getChildItem(i).getChecked())
                childrenAlIsChecked = false;
        }
        mgroups.get(groupPosition).setChecked(childrenAlIsChecked);
        */
          notifyDataSetChanged();

    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }


    @Override
    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
        handleClick(childPosition,groupPosition);
        return true;
    }
}
