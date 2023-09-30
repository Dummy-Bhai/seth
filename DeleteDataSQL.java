package com.example.usamasqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteData extends AppCompatActivity {

    EditText current_rollno;
    Button delete_btn;
    String r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_data);

        current_rollno=findViewById(R.id.current_rollno);
        delete_btn=findViewById(R.id.delete_btn);
        DatabaseHandler dh=new DatabaseHandler(this);

        delete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                r=current_rollno.getText().toString().trim();
                Boolean i=dh.deleteData(r);
                if (i==true){
                    Toast.makeText(DeleteData.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(DeleteData.this, "Not Inserted", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}