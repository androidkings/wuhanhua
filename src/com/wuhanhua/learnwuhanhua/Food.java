package com.wuhanhua.learnwuhanhua;

import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Food extends Topics{

	private Button gobackBtn ;
	private SoundPool soundPool;
	private int soundID;
	private int soundID2,soundID3,soundID4,soundID5;
	
	boolean plays = false, loaded = false;
	float actVolume, maxVolume, volume;
	AudioManager audioManager;
	int counter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.food);
		
		// AudioManager audio settings for adjusting the volume
				audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
				actVolume = (float) audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
				maxVolume = (float) audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
				volume = actVolume / maxVolume;
				
				gobackBtn = (Button)findViewById(R.id.GoBack);
				gobackBtn.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent intent = new Intent();
						 intent.setClass(Food.this,Topics.class);
				    	 Food.this.startActivity(intent);
				    	 
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
				soundID = soundPool.load(this, R.raw.rice, 1);
				soundID2 = soundPool.load(this, R.raw.noodles, 1);
				soundID3 = soundPool.load(this, R.raw.beef, 1);
				soundID4 = soundPool.load(this, R.raw.pork, 1);
				soundID5 = soundPool.load(this, R.raw.chicken, 1);

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
			public void playSound5(View v) 
			{
					if (loaded && !plays) 
					{
						soundPool.play(soundID5, volume, volume, 1, 0, 1f);
						counter = counter++;
						Toast.makeText(this, "Played sound", Toast.LENGTH_SHORT).show();
					}
			}
			
		

	
	
	

}
