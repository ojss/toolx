package com.projectx.toolx;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class TemperatureActivity extends ActionBarActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);
        setTitle("Temperature");
       }

    public void toCelsius(View v) {
        double x,z;
        EditText inpuz = (EditText) findViewById(R.id.editPower);
        TextView ans = (TextView) findViewById(R.id.textView4);
        ImageView imageView= (ImageView) findViewById(R.id.imageView3;
            x = Double.parseDouble(inpuz.getText().toString());
        z=(x - 32.0f) * (5.0f / 9.0f);
        v.refreshDrawableState();
        if(z>40) {imageView.setImageResource(R.drawable.thermometer_2);}
        ans.setText(Double.toString(z));
    }
    public void toFahrenheit(View v) {
        double x,z;
        EditText inpuz = (EditText) findViewById(R.id.editPower);
        ImageView imageView= (ImageView) findViewById(R.id.imageView3);
        TextView ans = (TextView) findViewById(R.id.textView4);
        x=Double.parseDouble(inpuz.getText().toString());
        z=((x * (9.0f / 5.0f)) + 32.0f);
        v.refreshDrawableState();
        if(z>104) {imageView.setImageResource(R.drawable.thermometer_2);}
        ans.setText(Double.toString(z));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_temperature, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}