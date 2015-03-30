package com.example.ex15sensores;

import android.support.v7.app.ActionBarActivity;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class MainActivity extends ActionBarActivity implements SensorEventListener{
	private SensorManager sensorManager;
	private View mlayout;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mlayout= findViewById(R.id.Layout);
		sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onSensorChanged(SensorEvent event) {
		// TODO Auto-generated method stub
		if(event.sensor.getType()==Sensor.TYPE_PROXIMITY){
			   if(event.values[0]<5){
				   mlayout.setBackgroundColor(Color.GREEN);
			   }
			   else{
				   mlayout.setBackgroundColor(Color.RED);
			   }
			    
			  }
		
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	 protected void onResume() {
	  super.onResume();
	  sensorManager.registerListener(this,
	    sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY),
	    SensorManager.SENSOR_DELAY_NORMAL);
	 }
	
	@Override
	 protected void onPause() {
	  super.onPause();
	  sensorManager.unregisterListener(this);
	 }
	
	

	
}
