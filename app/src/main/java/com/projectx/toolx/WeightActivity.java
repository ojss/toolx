package com.projectx.toolx;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class WeightActivity extends ActionBarActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);
        setTitle("Weight");
    }

    public void toPounds(View view) {
        EditText edtDist = (EditText)findViewById(R.id.editWeight);
        TextView ansText = (TextView)findViewById(R.id.textView5);
        ImageView imageView = (ImageView)findViewById(R.id.imageView4);
        double kilo =
                Double.parseDouble(edtDist.getText().toString());

        double poundans = kilo * 2.2046;
        view.refreshDrawableState();
        imageView.setImageResource(R.drawable.weight);
        ansText.setText(Double.toString(poundans));
    }

    public void toKilograms(View view) {
        ImageView imageView = (ImageView)findViewById(R.id.imageView4);
        EditText edtDist = (EditText)findViewById(R.id.editWeight);
        TextView ansText = (TextView)findViewById(R.id.textView5);
        double pounds =
                Double.parseDouble(edtDist.getText().toString());

        double kiloans = pounds /2.2046;
        view.refreshDrawableState();
        imageView.setImageResource(R.drawable.weight_2);
        ansText.setText(Double.toString(kiloans));
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
