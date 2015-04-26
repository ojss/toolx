package com.projectx.toolx;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class DistanceActivity extends ActionBarActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distance);
        setTitle("Distance");
    }

    public void toMiles(View v) {
        EditText edtDist = (EditText)findViewById(R.id.editDistance);
        TextView ansText = (TextView)findViewById(R.id.textView4);
        double kilo =
                Double.parseDouble(edtDist.getText().toString());

        double milans = kilo * 0.62137;
        v.refreshDrawableState();
        ansText.setText(Double.toString(milans));

    }

    public void toKilometers(View v) {
        EditText edtDist = (EditText)findViewById(R.id.editDistance);
        TextView ansText = (TextView)findViewById(R.id.textView4);

        double miles =
                Double.parseDouble(edtDist.getText().toString());

        double kilans =
                miles / 0.62137;

        v.refreshDrawableState();

        ansText.setText(Double.toString(kilans));

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_unit_convertor, menu);
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
