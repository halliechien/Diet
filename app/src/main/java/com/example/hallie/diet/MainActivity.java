package com.example.hallie.diet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }





    public void click_record(View view) {
        Intent in = new Intent(this, Record.class);
        startActivity(in);
    }

    public void click_cale(View view) {
    }

    //navBar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.index_icon, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Myinfo_Dialog md = new Myinfo_Dialog();
        md.show(getSupportFragmentManager(), null);

//        int id = item.getItemId();
//        if(id == R.id.icon_member){
//            Intent in = new Intent(this, Myinfo_Q.class);
//            startActivity(in);
//        }
        return super.onOptionsItemSelected(item);
    }
    //navBar end

}
