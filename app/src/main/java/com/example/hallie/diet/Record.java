package com.example.hallie.diet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class Record extends AppCompatActivity {

    private ImageButton mimgArrow;
    private LinearLayout mlyBlock;
    boolean isExpand; //是否翻轉

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        mimgArrow = (ImageButton) findViewById(R.id.ibtn_displayArrow);
        mlyBlock = (LinearLayout) findViewById(R.id.ly_displayBlock);

        mimgArrow.setOnClickListener(new MyTurnListener());  //翻轉監聽
    }

    public void click_add(View view) {
        Intent in = new Intent(this, Mealtype.class);
        startActivity(in);
    }


    //箭頭翻轉、隱藏、顯示
    private  class MyTurnListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            isExpand = !isExpand;
            int durationMillis = 200;

            if(isExpand && mlyBlock.getVisibility() == View.GONE){
                mlyBlock.setVisibility(View.VISIBLE);
                //翻轉icon
                RotateAnimation animation = new RotateAnimation(0, 180, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                animation.setDuration(durationMillis);
                animation.setFillAfter(true);
                mimgArrow.startAnimation(animation);
            } else{
                mlyBlock.setVisibility(View.GONE);
                //翻轉icon
                RotateAnimation animation = new RotateAnimation(180, 0, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                animation.setDuration(durationMillis);
                animation.setFillAfter(true);
                mimgArrow.startAnimation(animation);
            }

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
                Myinfo_Dialog md = new Myinfo_Dialog();
                md.show(getSupportFragmentManager(), null);

                return super.onOptionsItemSelected(item);

            case R.id.icon_home:
                Intent it = new Intent(this, MainActivity.class);
                startActivity(it);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    //navBar end
}
