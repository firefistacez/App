package com.example.app;

import android.Manifest;
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

public class MainActivity2 extends AppCompatActivity {

    EditText txtName, txtAge, txtAddress, txtNumber, txtGNumber1, txtGNumber2, fireNumber, hospitalNumber, policeNumber;
    Button btnDisplay;

    String mName="";
    int mAge=0;
    String mAddress="";
    long mNumber=0;
    long mGNumber1=0;
    long mGNumber2=0;
    long fireNum=0;
    long hospNum=0;
    long polNum=0;


    Member member;

    private final static int REQUEST_CODE_ASK_PERMISSIONS = 1;
    private static final String[] REQUIRED_SDK_PERMISSIONS = new String[] {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.WRITE_EXTERNAL_STORAGE };
    private static final int WRITE_EXTERNAL_STORAGE_CODE = 1;

    FirebaseAuth firebaseAuth;
    DatabaseReference reff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent1 = getIntent();
        String email = intent1.getStringExtra("Email");
        String password = intent1.getStringExtra("Password");

        txtName = (EditText)findViewById(R.id.name);
        txtAge = (EditText)findViewById(R.id.age);
        txtAddress = (EditText)findViewById(R.id.address);
        txtNumber = (EditText)findViewById(R.id.number);
        txtGNumber1 = (EditText)findViewById(R.id.gNumber1);
        txtGNumber2 = (EditText)findViewById(R.id.gNumber2);
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
                mName = txtName.getText().toString().trim();
                mAge = Integer.parseInt(txtAge.getText().toString().trim());
                mAddress = txtAddress.getText().toString().trim();
                mNumber = Long.parseLong(txtNumber.getText().toString().trim());
                mGNumber1 = Long.parseLong(txtGNumber1.getText().toString().trim());
                mGNumber2 = Long.parseLong(txtGNumber2.getText().toString().trim());
                fireNum = Long.parseLong(fireNumber.getText().toString().trim());
                hospNum = Long.parseLong(hospitalNumber.getText().toString().trim());
                polNum = Long.parseLong(policeNumber.getText().toString().trim());
                if(mName.isEmpty() || mAge==0 || mAddress.isEmpty() || mNumber==0 || mGNumber1==0 || mGNumber2==0 || fireNum==0 || hospNum==0 || polNum ==0){
                    Toast.makeText(MainActivity2.this, "Empty Fields", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity2.this, MainActivity2.class));
                }
                else{
                    member.setName(mName);
                    member.setAge(mAge);
                    member.setAddress(mAddress);
                    member.setNumber(mNumber);
                    member.setgNumber1(mGNumber1);
                    member.setgNumber2(mGNumber2);
                    member.setEmail(email);
                    member.setPassword(password);
                    member.setPoliceNumber(polNum);
                    member.setFireNumber(fireNum);
                    member.setHospitalNumber(hospNum);

                    reff.child(mName).setValue(member);

                    Intent intent = new Intent(MainActivity2.this, MainActivity4.class);
                    startActivity(intent);
                }
            }
        });
    }
}