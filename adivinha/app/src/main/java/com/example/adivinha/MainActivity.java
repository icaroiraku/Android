package com.example.adivinha;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button botaoJogar;
    private TextView textoResultado;
    private String[] meuArray = {
            "valor 1",
            "Valor 2",
            "Valor 3"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoJogar = (Button) findViewById(R.id.botaoJogarId);
        textoResultado = (TextView) findViewById(R.id.resultadoid);



        Log.d("AULA", meuArray[1]);


        //textoResultado.setText("Texto alterado");

        botaoJogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Random randomico = new Random();
                int numeroAleatorio = randomico.nextInt(10);
                textoResultado.setText( "Número escolhido: " + numeroAleatorio );
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {





        return super.onOptionsItemSelected(item);
    }
}