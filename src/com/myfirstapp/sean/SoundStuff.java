package com.myfirstapp.sean;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;

public class SoundStuff extends Activity implements OnClickListener, OnLongClickListener {

	SoundPool sp;
	int explosion = 0;
	MediaPlayer mp;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
		
		View v = new View(this);
		v.setOnClickListener(this);
		v.setOnLongClickListener(this);
		setContentView(v);
		
		sp = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
		explosion = sp.load(this, R.raw.explosion, 1);
		
		mp = MediaPlayer.create(this, R.raw.silent_hill_background);
	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (explosion != 0)
			sp.play(explosion, 1, 1, 0, 0, 1);
	}

	@Override
	public boolean onLongClick(View arg0) {
		// TODO Auto-generated method stub
		if (!mp.isPlaying()) {
			mp.seekTo(0);
			mp.start();
		} else {
			mp.pause();
		}
		
		return false;
	}
}
