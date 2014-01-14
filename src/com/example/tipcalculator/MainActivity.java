package com.example.tipcalculator;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	public EditText etBillTotal;
	public TextView tvTip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etBillTotal = (EditText) findViewById(R.id.etBillTotal);
        tvTip = (TextView) findViewById(R.id.tvTip);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public void processTip(View v, int percentage) {
    	try {
    		double billTotal = Double.parseDouble(etBillTotal.getText().toString());
        	double tip = billTotal * percentage / 100;
        	String tipString = String.format("$%.2f", tip);
        	tvTip.setText(tipString);
    	} catch (NumberFormatException e) {
    		tvTip.setText(R.string.invalid_number_warning);
    		Toast.makeText(getApplicationContext(), R.string.invalid_number_warning, Toast.LENGTH_SHORT).show();
    	}
    }
    
    public void process10Percent(View v) {
    	processTip(v, 10);
    }
    
    public void process15Percent(View v) {
    	processTip(v, 15);
    }
    
    public void process20Percent(View v) {
    	processTip(v, 20);
    }
}
