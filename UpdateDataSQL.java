package com.example.usamasqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateData extends AppCompatActivity {

    EditText rollno,name,age;
    Button update_btn;
    String r,n,a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data);

        rollno=findViewById(R.id.get_rollno);
        name=findViewById(R.id.get_name);
        age=findViewById(R.id.get_age);
        update_btn=findViewById(R.id.update_btn);

        DatabaseHandler dh=new DatabaseHandler(this);

        update_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                r=rollno.getText().toString().trim();
                n=name.getText().toString().trim();
                a=age.getText().toString().trim();

                Boolean i=dh.updateData(r,n,a);
                if (i==true){
                    Toast.makeText(UpdateData.this, "Data Updated", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(UpdateData.this, "Not Updated", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}