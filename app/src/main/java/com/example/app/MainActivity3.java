package com.example.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity3 extends AppCompatActivity {
    EditText fireNumber, hospitalNumber, policeNumber;
    Button btnDisplay;

    Member member;

    FirebaseAuth firebaseAuth;
    DatabaseReference reff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Intent intent1=getIntent();
        String mName = intent1.getStringExtra("Name");
        int mAge = Integer.parseInt(intent1.getStringExtra("Age"));
        String mAddress = intent1.getStringExtra("Address");
        int mNumber = Integer.parseInt(intent1.getStringExtra("Number"));
        long mGNumber1 = Long.parseLong(intent1.getStringExtra("Guardian Number1"));
        long mGNumber2 = Long.parseLong(intent1.getStringExtra("Guardian Number2"));
        String email = intent1.getStringExtra("Email");
        String password = intent1.getStringExtra("Password");

        fireNumber = (EditText)findViewById(R.id.fireNumber);
        hospitalNumber = (EditText)findViewById(R.id.hospitalNumber);
        policeNumber = (EditText)findViewById(R.id.policeNumber);

        btnDisplay = (Button)findViewById(R.id.btnDisplay);

        firebaseAuth = FirebaseAuth.getInstance();
        member = new Member();
        reff = FirebaseDatabase.getInstance().getReference().child("Member");

        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long fireNum = Long.parseLong(fireNumber.getText().toString().trim());
                long hospNum = Long.parseLong(hospitalNumber.getText().toString().trim());
                long polNum = Long.parseLong(policeNumber.getText().toString().trim());
                member.setName(mName);
                member.setAge(mAge);
                member.setAddress(mAddress);
                member.setNumber(mNumber);
                member.setgNumber1(mGNumber1);
                member.setgNumber2(mGNumber2);
                member.setEmail(email);
                member.setPassword(password);
                member.setFireNumber(fireNum);
                member.setHospitalNumber(hospNum);
                member.setPoliceNumber(polNum);

                reff.child(mName).setValue(member);

                Toast.makeText(MainActivity3.this, "Registered Successfully", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
                startActivity(intent);
            }
        });
    }
}