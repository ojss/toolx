package com.projectx.toolx;

import android.content.Context;
import android.hardware.GeomagneticField;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
    import android.app.Activity;
    import android.hardware.Sensor;
    import android.hardware.SensorEvent;
    import android.hardware.SensorEventListener;
    import android.hardware.SensorManager;
    import android.media.MediaPlayer;
    import android.media.MediaPlayer.OnCompletionListener;
    import android.os.Bundle;
    import android.widget.ProgressBar;
    import android.widget.TextView;
    import android.widget.Toast;
    /**
     * Simple metal detector class.
     *
     *
     */
    public class metal_detector extends ActionBarActivity implements SensorEventListener {

        private TextView xTV;
        private TextView yTV;
        private TextView zTV;
        private TextView d;
        private ProgressBar mProgress;

        private SensorManager sensorManager = null;
        private float[] geomag = new float[3];


        /** Called when the activity is first created. */
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_metal_detector);
            // Set up a SensorManager
            sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
            sensorManager.registerListener(this,
                    sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD),
                    SensorManager.SENSOR_DELAY_GAME);

            // Text view setup
            xTV = (TextView) findViewById(R.id.xTV);
            yTV = (TextView) findViewById(R.id.yTV);
            zTV = (TextView) findViewById(R.id.zTV);
            d = (TextView) findViewById(R.id.textView7);
            // Initialise values.
            xTV.setText("X: 0.00");
            yTV.setText("Y: 0.00");
            zTV.setText("Z: 0.00");

            // Setup progress bar value.
            mProgress = (ProgressBar) findViewById(R.id.progress_bar);
            mProgress.setMax(100);
        }

        public void onSensorChanged(SensorEvent sensorEvent) {
            synchronized (this) {
                geomag = sensorEvent.values.clone();
// time
                long timeMillis = System.currentTimeMillis();
// get the geo magnetic field

                GeomagneticField geoField = new GeomagneticField(Float.parseFloat("21.286885"), Float.parseFloat("74.842075"), 0, timeMillis);
// calculate the field value now
                float magHere = (float) Math.sqrt(Math.pow(geomag[0], 2) + Math.pow(geomag[1], 2) + Math.pow(geomag[2], 2));
                //Metal detected.
                float magExpected = (float) Math.sqrt(Math.pow(geoField.getX(),2) + Math.pow(geoField.getY(),2) + Math.pow(geoField.getZ(),2));

                if (geomag != null) {

                    xTV.setText("X: "+Float.toString(geomag[0]));
                    yTV.setText("Y: "+Float.toString(geomag[1]));
                    zTV.setText("Z: "+Float.toString(geomag[2]));

                    mProgress.setProgress(getProgressBarValue(geomag[0]));
                    if (magHere > 1.4*magExpected || magHere < 0.6*magExpected++) {
                        //there is a high probability that some metal is close to the sensor
                    d.setText("Metal Detected");
                      //  Toast.makeText(this, "Metal detected", Toast.LENGTH_LONG).show();
                    } else {
                        //everything is normal
                        d.setText(" ");
                    }
                  /*  if( Math.abs(geomag[0]) > 50){
                      //  playAlarm();
                        Toast.makeText(this, "Metal detected", Toast.LENGTH_LONG).show(); */
                    }
                }
            }


        public void onAccuracyChanged(Sensor arg0, int arg1) {
            // TODO Auto-generated method stub

        }

        @Override
        protected void onResume() {
            super.onResume();

            // Register this class as a listener for the sensors.
            sensorManager.registerListener(this,
                    sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD),
                    SensorManager.SENSOR_DELAY_GAME);
        }

        @Override
        protected void onStop() {
            super.onStop();

            // Unregister the listener
            sensorManager.unregisterListener(this);
        }

        /**
         * Method to play an alarm sound to signal half time or full time.
         */
        private void playAlarm() {
            MediaPlayer mp = MediaPlayer.create(metal_detector.this, R.raw.buzzer);

            if(!mp.isPlaying()){ //If mediaplayer is not already playing.

                mp.start();
                mp.setOnCompletionListener(new OnCompletionListener() {

                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }

                });
            }

        }

        /**
         * Takes in a sensor value and returns a value to set the
         * progress bar to depending on the sensor value.
         * @param sensorValue
         * @return
         */
        private int getProgressBarValue(float sensorValue){
            sensorValue = Math.abs(sensorValue);

            if(sensorValue >= 10 &&  sensorValue < 30)
                return 15;
            else if(sensorValue >= 30 &&  sensorValue < 50)
                return 30;
            else if(sensorValue >= 30 &&  sensorValue < 50)
                return 30;
            else if(sensorValue >= 50 &&  sensorValue < 70)
                return 50;
            else if(sensorValue >= 70 &&  sensorValue < 100)
                return 75;
            else if(sensorValue >= 100)
                return 99;
            else
                return 0;
        }



        @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_metal_detector, menu);
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
