package com.example.arrayadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {
    private  Button SignUp;
    private EditText username,password,confirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        SignUp = findViewById(R.id.btn1);
        username = findViewById(R.id.usname);
        password = findViewById(R.id.pwd);
        confirmPassword = findViewById(R.id.pwd1);


        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(SignUp.this, "Save successful!", Toast.LENGTH_SHORT).show();
               Intent intent = new Intent(SignUp.this, Loginpage.class);
               startActivity(intent);
            }
        });



//        SignUp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(SignUp.this, Loginpage.class);
//                startActivity(intent);
//            }
//        });
//

    }
}