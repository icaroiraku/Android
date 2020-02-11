package com.example.justjava1;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;


import android.view.View;

import android.widget.TextView;

import java.text.NumberFormat;


public class MainActivity extends AppCompatActivity {

    int quantity = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void increment(View view){
        this.quantity++;

        display(this.quantity);

    }


    public void decrement(View view){
        this.quantity--;
        display(this.quantity);


    }



    public void submitOrder(View view){
        String priceMessage= "Total " + NumberFormat.getCurrencyInstance().format(quantity*5) ;
        priceMessage =  priceMessage + "\n Muito obrigado!!";
        displayMessage(priceMessage);

    }


    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    private void displayMessage(String number){
        TextView priceTextView = (TextView) findViewById(R.id.prince_text_view);
        priceTextView.setText(number);
    }
}