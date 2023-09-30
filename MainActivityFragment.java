package com.example.activityandfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    String Root_Frag = "root_fagment";
    Button btn1,btn2;
    FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        frameLayout=findViewById(R.id.FL);


        loadfrag(new Fragment1(),0);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadfrag(new Fragment1(),0);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadfrag(new Fragment2(),1);
            }
        });
    }

 public void loadfrag(Fragment fragment_name, int flag){
     FragmentManager fm=getSupportFragmentManager();
     FragmentTransaction ft=fm.beginTransaction();

     if (flag==0){
         ft.add(R.id.FL,fragment_name);

     }
     else{
         ft.replace(R.id.FL,fragment_name);

     }
     ft.commit();
 }
}