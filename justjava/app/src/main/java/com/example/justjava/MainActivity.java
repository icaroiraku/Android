package com.example.justjava;

import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;

import android.os.Bundle;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void submitOrder(View view){
        display(1);
    }

    private void display(int number){
        TextView.quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
                quantityTextView.setText(""+number);

    }
}
