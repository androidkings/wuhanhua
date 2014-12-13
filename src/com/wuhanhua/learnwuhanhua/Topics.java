package com.wuhanhua.learnwuhanhua;



import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import android.os.Bundle;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Topics extends Activity {
	  private Button GtBtn;
	   private Button NbBtn;
	   private Button DrBtn;
	   
	   private Button FdBtn;
	   
	   private SoundPool soundPool;
		private int soundID;
		private int soundID2,soundID3,soundID4;
		
		boolean plays = false, loaded = false;
		float actVolume, maxVolume, volume;
		AudioManager audioManager;
		int counter;
		


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.topics);

		GtBtn = (Button)findViewById(R.id.Greetings);
		GtBtn.setOnClickListener(new OnClickListener() {
			

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
					Intent intent = new Intent();
			    	 intent.setClass(Topics.this,Greetings.class);
			    		Topics.this.startActivity(intent);
			    		
				}
		   });
		
		NbBtn = (Button)findViewById(R.id.Numbers);
		NbBtn.setOnClickListener(new OnClickListener() {
				

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
					Intent intent = new Intent();
			    	 intent.setClass(Topics.this,Numbers.class);
			    		Topics.this.startActivity(intent);
			    		
				}
		   });
		
		DrBtn = (Button)findViewById(R.id.Directions);
		DrBtn.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
					Intent intent = new Intent();
			    	 intent.setClass(Topics.this,Directions.class);
			    		Topics.this.startActivity(intent);
			    		
				}
		   });
		
		FdBtn = (Button)findViewById(R.id.Food);
		FdBtn.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
					Intent intent = new Intent();
			    	 intent.setClass(Topics.this,Food.class);
			    		Topics.this.startActivity(intent);
			    		
				}
		   });


		//Hardware buttons setting to adjust the media sound
		this.setVolumeControlStream(AudioManager.STREAM_MUSIC);

		// the counter will help us recognize the stream id of the sound played  now
		counter = 0;

		// Load the sounds
		soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
		soundPool.setOnLoadCompleteListener(new OnLoadCompleteListener() {
			@Override
			public void onLoadComplete(SoundPool tsoundPool, int sampleId, int status) {
				loaded = true;
			}
		});
		soundID = soundPool.load(this, R.raw.greetings, 1);
		soundID2 = soundPool.load(this, R.raw.numbers, 1);
		soundID3 = soundPool.load(this, R.raw.directions, 1);
		soundID4 = soundPool.load(this, R.raw.food, 1);
		
		

	}
// Is the sound loaded does it already play?
	public void playSound(View v) {
			if (loaded && !plays) {
				soundPool.play(soundID, volume, volume, 1, 0, 1f);
				counter = counter++;
				Toast.makeText(this, "Played sound", Toast.LENGTH_SHORT).show();
				
		
				
				
			}
			
		
		}
	
	public void playSound2(View v) 
	{
			if (loaded && !plays) 
			{
				soundPool.play(soundID2, volume, volume, 1, 0, 1f);
				counter = counter++;
				Toast.makeText(this, "Played sound", Toast.LENGTH_SHORT).show();
			}
	}
	
	public void playSound3(View v) 
	{
			if (loaded && !plays) 
			{
				soundPool.play(soundID3, volume, volume, 1, 0, 1f);
				counter = counter++;
				Toast.makeText(this, "Played sound", Toast.LENGTH_SHORT).show();
			}
	}
	
	public void playSound4(View v) 
	{
			if (loaded && !plays) 
			{
				soundPool.play(soundID4, volume, volume, 1, 0, 1f);
				counter = counter++;
				Toast.makeText(this, "Played sound", Toast.LENGTH_SHORT).show();
			}
	}
	

		
		
		
		
		
	}





	
	
	



