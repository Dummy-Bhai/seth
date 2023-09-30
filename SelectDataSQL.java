package com.example.usamasqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SelectData extends AppCompatActivity {

    EditText rollno;
    Button select_btn;
    TextView display;
    String r;
    String name,age,result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_data);

        rollno=findViewById(R.id.current_rollno);
        select_btn=findViewById(R.id.select_btn);
        display=findViewById(R.id.display_data);
        DatabaseHandler dh=new DatabaseHandler(this);

        select_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                r=rollno.getText().toString().trim();
                Details details=dh.selectData(r);
                name=details.getName();
                age=details.getAge();
                result=name+age;
                display.setText(result);
            }
        });
    }
}