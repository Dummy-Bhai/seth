package com.example.usamasqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InsertData extends AppCompatActivity {

    EditText rollno,name,age;
    Button insert_btn;
    String r,n,a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_data);

        rollno=findViewById(R.id.get_rollno);
        name=findViewById(R.id.get_name);
        age=findViewById(R.id.get_age);
        insert_btn=findViewById(R.id.insert_btn);

        DatabaseHandler dh=new DatabaseHandler(this);

        insert_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                r=rollno.getText().toString().trim();
                n=name.getText().toString().trim();
                a=age.getText().toString().trim();

                Boolean i=dh.addData(r,n,a);
                if (i==true){
                    Toast.makeText(InsertData.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(InsertData.this, "Not Inserted", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}