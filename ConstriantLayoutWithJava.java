package com.example.layoutswithjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ConstriantLayoutWithJava extends AppCompatActivity {
    EditText n,a;
    TextView d;
    Button b;
    String name,age,result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constriant_layout_with_java);


        n=findViewById(R.id.get_name);
        a=findViewById(R.id.get_age);
        d=findViewById(R.id.dispaly_data);
        b=findViewById(R.id.get_detail);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name=n.getText().toString().trim();
                age=a.getText().toString().trim();
                if (name.isEmpty() || age.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Please Enter Details", Toast.LENGTH_SHORT).show();
                }else{
                    result="Welcome "+name+"........!!!"+"\nYour age is "+age;
                    d.setText(result);
                }
            }
        });
    }
}