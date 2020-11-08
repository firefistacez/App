package com.example.app;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Fire extends AppCompatActivity {
    EditText etNumber;
    ImageButton btCall;

    Member member;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        member = new Member();

        etNumber = findViewById(R.id.et_number);
        btCall = findViewById(R.id.bt_call);

        btCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = etNumber.getText().toString();
                String s = "tel:"+phone;
            }
        });
    }
}