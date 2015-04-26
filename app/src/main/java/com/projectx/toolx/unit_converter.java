package com.projectx.toolx;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class unit_converter extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_unit_convertor);

    }
    public void tListener(View view)
    {
        Intent intent = new Intent(getApplicationContext(), TemperatureActivity.class);
        startActivity(intent);
    }
    public void dListener(View view)
    {

        Intent intent = new Intent(getApplicationContext(), DistanceActivity.class);
        startActivity(intent);
    }
    public void wListener(View view)
    {
        Intent intent = new Intent(getApplicationContext(), WeightActivity.class);
        startActivity(intent);
    }
    public void aListener(View view)
    {
        Intent intent = new Intent(getApplicationContext(), AreaActivity.class);
        startActivity(intent);
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
