package com.example.firebasetutorial;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class SelectData extends AppCompatActivity {

    FirebaseFirestore firebaseFirestore;
    EditText rollno;
    TextView txt;
    Button btn;
    String n,result;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_data);


        rollno=findViewById(R.id.select_roll_no);
        btn=findViewById(R.id.get_btn);
        txt=findViewById(R.id.show_txt);
        firebaseFirestore=FirebaseFirestore.getInstance();


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                n = rollno.getText().toString();
                if (n.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Please Enter", Toast.LENGTH_LONG).show();
                } else {
                    firebaseFirestore.collection("Details")
                            .document(n)
                            .get()
                            .addOnCompleteListener
                                    (new OnCompleteListener<DocumentSnapshot>() {
                                        @Override
                                        public void onComplete(@NonNull Task<DocumentSnapshot> task) {

                                            if (task.isSuccessful()){
                                                DocumentSnapshot doc = task.getResult();
                                                result = "Your Age Is "+doc.getString("age")+" "+doc.getString("name");
                                                txt.setText(result);
                                            }
                                        }
                                    }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(getApplicationContext(), "Cannot Select", Toast.LENGTH_SHORT).show();
                                }
                            });
                }
            }
        });

    }
}