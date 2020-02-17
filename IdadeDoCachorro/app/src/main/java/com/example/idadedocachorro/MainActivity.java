package com.example.idadedocachorro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText caixaTexto;
    private Button botaoIdade;
    private TextView resultadoIdade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        caixaTexto = (EditText)findViewById(R.id.caixaTextoId);
        botaoIdade = (Button) findViewById(R.id.botaoIdadeId);
        resultadoIdade = (TextView) findViewById(R.id.resultadoIdadeId);

        botaoIdade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String textoDigitado = caixaTexto.getText().toString();

                if ( textoDigitado. isEmpty() ){

                    resultadoIdade.setText( " nenhum numero digitado! " );
                }else{

                    int valorDigitado = Integer.parseInt( textoDigitado);
                    int valorResultadoFinal = valorDigitado * 7;

                    resultadoIdade.setText( " A idade do cachorro e: " + valorResultadoFinal + " anos! ");

                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu){


        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        int id = item.getItemId();



        return super.onOptionsItemSelected(item);
    }
}
