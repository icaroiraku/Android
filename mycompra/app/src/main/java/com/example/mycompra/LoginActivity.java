package com.example.mycompra;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class LoginActivity extends AppCompatActivity {

    private Button ativar_cadastro;
    private EditText login_cadastro, senha_cadastro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        ativar_cadastro = (Button) findViewById(R.id.ativar_cadastro);
        login_cadastro = (EditText) findViewById(R.id.login_cadastro);
        senha_cadastro = (EditText) findViewById(R.id.senha_cadastro);


        ativar_cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ativarCadastro();
            }
        });


    }


    private void ativarCadastro() {

        String name = login_cadastro.getText().toString();
        String password = senha_cadastro.getText().toString();


        if (TextUtils.isEmpty(name)) {
            Toast.makeText(this, "Entre com seu e-mail..", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Entre com sua senha..", Toast.LENGTH_SHORT).show();
        } else {


            ValidateNameEmail(name, password);

        }
    }

    private void ValidateNameEmail(final String name, final String password) {

        final DatabaseReference RootRef;
        RootRef = FirebaseDatabase.getInstance().getReference();

        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
              if (!(dataSnapshot.child("Users").child(name).exists()))
              {
                 HashMap<String, Object> userdatamap = new HashMap<>();
                 userdatamap.put("nome", name);
                  userdatamap.put("password", password);

                  RootRef.child("User").child(name).updateChildren(userdatamap)
                          .addOnCompleteListener(new OnCompleteListener<Void>(){

                              @Override
                              public void onComplete(@NonNull  Task<Void> task)
                              {
                                    if (task.isSuccessful()){

                                        Toast.makeText(LoginActivity.this, "parabens" , Toast.LENGTH_SHORT).show();


                                    }

                              }

              });
              {
                  Toast.makeText(LoginActivity.this, "this" + name + "already exists." , Toast.LENGTH_SHORT).show();


                  Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                  startActivity(intent);
              }
              }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
