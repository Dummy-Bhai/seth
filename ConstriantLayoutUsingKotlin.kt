package com.example.layoutswithkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class ConstriantLayoutUsingKotlin : AppCompatActivity() {
    lateinit var n: EditText;
    lateinit var a: EditText;
    lateinit var b: Button;
    lateinit var d: TextView;
    lateinit var name:String;
    lateinit var age:String;
    lateinit var result:String;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constriant_layout_using_kotlin)


        n = findViewById(R.id.get_name);
        a = findViewById(R.id.get_age);
        d = findViewById(R.id.dispaly_data);
        b = findViewById(R.id.get_detail);

        b.setOnClickListener() {
            name=n.text.toString().trim();
            age=a.text.toString().trim();

            if (name.isEmpty() || age.isEmpty()){
                Toast.makeText(this,"PLease Enter Details!!!", Toast.LENGTH_LONG).show();
            }else{
                result="Welcome "+name+"......"+"\nYour Age is "+age;
                d.setText(result);
            }
        }
    }
}