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
import com.google.firebase.firestore.FirebaseFirestore;

public class UpdateData extends AppCompatActivity {

    EditText n,a,rn;
    Button btn;
    FirebaseFirestore firebaseFirestore;

    String name,age,rollno;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data);

        firebaseFirestore=FirebaseFirestore.getInstance();
        rn=findViewById(R.id.current_rollno);
        a=findViewById(R.id.update_age);
        n=findViewById(R.id.update_name);
        btn=findViewById(R.id.update_btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name=n.getText().toString();
                age=a.getText().toString();
                rollno=rn.getText().toString();

                if (name.length()==0 || age.length()==0 ||rollno.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Please Enter", Toast.LENGTH_SHORT).show();
                }else{
                    firebaseFirestore.collection("Details").document(rollno)
                            .update("age",age,"name",name)
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    Toast.makeText(getApplicationContext(), "Value Updated", Toast.LENGTH_LONG).show();
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            });
                }

            }
        });

    }
}