package com.example.hallie.diet;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Mealtype extends AppCompatActivity {

    ArrayList<GroupItem> mgroups;
    ExpandableListView melv_dietType;
    ElvAdapter madapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mealtype);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        mgroups = new ArrayList<GroupItem>();
        getJsonObject();
        melv_dietType = (ExpandableListView) findViewById(R.id.elv_dietType);
        madapter = new ElvAdapter(this, mgroups);
        melv_dietType.setAdapter(madapter);
        melv_dietType.setOnChildClickListener(madapter);


    }

    private void getJsonObject(){
        String jsonStr = "{'CommunityUsersResult':[{'CommunityUsersList':[{'fullName':'蛋餅(1份)','childNumber':'1','childName':'蛋餅'}"
                +",{'fullName':'燒餅(1份)','childNumber':1','childName':'燒餅'}],'groupId':1, 'groupTitle':'中式早點'},{'CommunityUsersList':[{'fullName':'吐司(2片)','childNumber':'2','childName':'吐司'}"
                +",{'fullName':'麵包(1個)','childNumber':'1','childName':'麵包'}],'groupId':2, 'groupTitle':'西式早點'}]}";


        try {
            JSONObject CommunityUsersRestultObj = new JSONObject(jsonStr);
            JSONArray groupList = CommunityUsersRestultObj.getJSONArray("CommunityUsersResult");

            for(int i=0; i<groupList.length(); i++){
                JSONObject groupObj = (JSONObject)groupList.get(i);
                GroupItem group = new GroupItem(groupObj.getString("groupId"),groupObj.getString("groupTitle"));
                JSONArray childrenList = groupObj.getJSONArray("CommunityUsersList");

                for(int j=0; j<childrenList.length(); j++){
                    JSONObject childObj = (JSONObject) childrenList.get(j);
                    ChildItem cd = new ChildItem(childObj.getString("fullName"), childObj.getString("childNumber"),
                            childObj.getString("childName"));
                    group.addChildItem(cd);
                }
                mgroups.add(group);
            }
        }  catch (JSONException e) {
            e.printStackTrace();
        }
    }

        //navBar
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.activity_icon, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {

            int id = item.getItemId();
            switch(id){
                case android.R.id.home:
                    this.finish();
                    break;
                case R.id.icon_member:
                    Intent in = new Intent(this, Myinfo_Q.class);
                    startActivity(in);
                    break;
                case R.id.icon_home:
                    Intent it = new Intent(this, MainActivity.class);
                    startActivity(it);
                    break;
            }
            return super.onOptionsItemSelected(item);
        }
        //navBar end


}
