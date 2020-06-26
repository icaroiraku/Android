package com.example.mycompra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{

    private Button inicia_login, inicia_inicial;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        inicia_login = (Button) findViewById(R.id.inicia_login);
        inicia_inicial = (Button) findViewById(R.id.inicia_inicial);



        inicia_inicial.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view)
            {

                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }

        });



    }
}
