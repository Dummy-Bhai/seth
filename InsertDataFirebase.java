package com.example.firebasetutorial;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class InsertData extends AppCompatActivity {

    EditText n,a,rn;
    Button btn;
    FirebaseFirestore firestore;
    String name;
    String age;
    String rollno;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_data);

        n=findViewById(R.id.get_name);
        btn=findViewById(R.id.send_btn);
        a=findViewById(R.id.get_age);
        rn=findViewById(R.id.get_roll_no);
        firestore=FirebaseFirestore.getInstance();



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name=n.getText().toString();
                age=a.getText().toString() ;
                rollno=rn.getText().toString();
                if(name.isEmpty() || age.isEmpty() || rollno.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Please Enter Details", Toast.LENGTH_SHORT).show();
                }else{
                    addDataToFirebase(name,age,rollno);
                }
            }
        });

    }
    private void addDataToFirebase(String name, String age,String rollno){

        Details details = new Details(name,age,rollno);

        firestore.collection("Details").document(rollno)
                .set(details).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Toast.makeText(getApplicationContext(), "Successful Added", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}