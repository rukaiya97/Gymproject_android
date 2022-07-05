package com.example.arrayadapter;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Loginpage extends AppCompatActivity {
    private EditText Username,Password;
    private TextView login;
    private Button Login;
    private Button SIGNIN;
//    DatabaseConnection db;
//    Connection con;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);

        Username = findViewById(R.id.usname);
        Password = findViewById(R.id.pwd);
        Login = findViewById(R.id.btn);
        SIGNIN = findViewById(R.id.btn2);
//        db = new DatabaseConnection();
        SIGNIN = findViewById(R.id.btn2);

     Login.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             if(Username.getText().toString().isEmpty() || Password.getText().toString().isEmpty()){
                 Toast.makeText(Loginpage.this, "Please fill empty space", Toast.LENGTH_LONG).show();
             }

             Intent intent = new Intent(Loginpage.this, MainActivity.class);
             startActivity(intent);
//             else
//
//             {
////                 try {
////                     String insertQuery = "select username, password from Usser where username = ? and password = ?";
////                     PreparedStatement ps = con.prepareStatement(insertQuery);
////                     ps.setString(1, Username.getText() .toString() .trim());
////                     ps.setString(2, Password.getText().toString() .trim());
////
////                     ResultSet i = ps.executeQuery();
////                     if (i.next()){
////                         SharedPreferences preferences = getSharedPreferences("username", Context.MODE_PRIVATE);
////                         SharedPreferences.Editor editor = preferences.edit();
////                         editor.putString("username", i.getString("username"));
////                         editor.apply();
////
////                         Toast.makeText(Loginpage.this, "Login Successfull", Toast.LENGTH_LONG).show();
////                         Username.setText("");
////                         Password.setText("");
////
////
////                     }else {
////                         AlertDialog.Builder dialog = new AlertDialog.Builder(Loginpage.this);
////                         dialog.setTitle("User not found");
////                         dialog.setMessage("Either your password or username is incorrct or you are registerd");
////                         dialog.setCancelable(true);
////                         dialog.create().show();
////                     }
////                 }catch (Exception e){
////                     e.printStackTrace();
////                 }
//
//             }
//
         }

     });



     SIGNIN.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             Intent intent = new  Intent(Loginpage.this, SignUp.class);
             startActivity(intent);

             //Toast.makeText(Loginpage.this, "Save successful!", Toast.LENGTH_SHORT).show();
         }

     });
    }


}