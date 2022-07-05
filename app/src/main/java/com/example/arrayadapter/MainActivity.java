package com.example.arrayadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.arrayadapter.Model.Client;
import com.example.arrayadapter.Service.ClientApi;
import com.example.arrayadapter.Service.RetrofitService;

import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

initializer();

    }

    public void initializer(){
        Spinner spn1,spn2;
        EditText First_name,Last_name, Email, Address;
        Button submit,reset;

        spn1 = (Spinner) findViewById(R.id.GENDER);
        spn2=(Spinner) findViewById(R.id.TIME);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.GENDERLIST, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spn1.setAdapter(adapter);

        ArrayAdapter<CharSequence> main = ArrayAdapter.createFromResource(this,
                R.array.TIMELIST, android.R.layout.simple_spinner_item);
        main.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spn2.setAdapter(main);


        First_name=findViewById(R.id.First_name);
        Last_name=findViewById(R.id.LASTNAME);
        Email=findViewById(R.id.EMAIL);
        Address=findViewById(R.id.ADDRESS);
       submit=(Button)  findViewById(R.id.submit);
       reset=(Button)  findViewById(R.id.RESET);

        RetrofitService retrofitService = new RetrofitService();
        ClientApi clientApi = retrofitService.getRetrofit().create(ClientApi.class);
       submit.setOnClickListener(view->{
           String fname=String.valueOf(First_name.getText());
           String lname=String.valueOf(Last_name.getText());
           String email=String.valueOf(Email.getText());
           String address=String.valueOf(Address.getText());
           String Gender = spn1.getSelectedItem().toString();
           String Time = spn2.getSelectedItem().toString();
           Client client=new Client();

           client.setFname(fname);
           client.setLname(lname);
           client.setEmail(email);
           client.setAddress(address);
           client.setGender(Gender);
           client.setTime(Time);


           clientApi.save(client)
                   .enqueue(new Callback<Client>() {
                       @Override
                       public void onResponse(Call<Client> call, Response<Client> response) {
                           Toast.makeText(MainActivity.this, "Save successful!", Toast.LENGTH_SHORT).show();
                       }

                       @Override
                       public void onFailure(Call<Client> call, Throwable t) {
                           Toast.makeText(MainActivity.this, "Save failed!!!", Toast.LENGTH_SHORT).show();
                           Logger.getLogger(MainActivity.class.getName()).log(Level.SEVERE, "Error occurred", t);

                       }
                   });

       });


    }
}