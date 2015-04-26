package com.projectx.toolx;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class AreaActivity extends ActionBarActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area);
        setTitle("Power");
    }


    public void kW_to_hp(View v){
        EditText inp_area = (EditText)findViewById(R.id.editPower);
        TextView converted_ans = (TextView)findViewById(R.id.textAns);
        TextView multiplier = (TextView)findViewById(R.id.textView6);
        double kW =
               Double.parseDouble(inp_area.getText().toString());
        double ans =kW/0.745699872;
        int ans2 = (int) (ans/220);
        v.refreshDrawableState();
        converted_ans.setText(Double.toString(ans)+" hp");
        multiplier.setText("X"+Integer.toString(ans2));
    }

    public void hp_to_kW(View v){
        EditText inp_area = (EditText)findViewById(R.id.editPower);
        TextView converted_ans = (TextView)findViewById(R.id.textAns);
        TextView multiplier = (TextView)findViewById(R.id.textView6);
        double hp =
                Double.parseDouble(inp_area.getText().toString());
        double ans = hp*0.745699872;
        int ans2 = (int) (ans/220);
        v.refreshDrawableState();
        converted_ans.setText(Double.toString(ans)+" kW");
        multiplier.setText("X"+Integer.toString(ans2));
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
