package com.lanyou.lpc.aaa;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initData();
    }

    private void initData() {
        BottomNavigationView  navigationItemView =  findViewById(R.id.bottomNavigationView);
      navigationItemView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){

          @Override
          public boolean onNavigationItemSelected(@NonNull MenuItem item) {
              switch (item.getItemId()){
                  case R.id.navigation_home:
                      Toast.makeText(Main3Activity.this, "HOME", Toast.LENGTH_SHORT).show();
                      break;
                  case R.id.navigation_dashboard:
                      Toast.makeText(Main3Activity.this, "DashBoard", Toast.LENGTH_SHORT).show();
                      break;
                  case R.id.navigation_notifications:
                      Toast.makeText(Main3Activity.this, "Notifications", Toast.LENGTH_SHORT).show();
                      break;
                      default:break;
              }
              return true;
          }
      });
    }
}
