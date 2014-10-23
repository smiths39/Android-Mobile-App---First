package com.myfirstapp.sean;

import java.util.Locale;
import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class TextVoice extends Activity implements OnClickListener {

	static final String[] texts = {
		"I am the one who knocks!", 
		"Because I say so", 
		"We're done when I say we're done", 
		"If that’s true, if you don’t know who I am, then maybe your best course would be to tread lightly", 
		"You're goddamn right", 
		"Stay out of my territory" 
	};
	
	TextToSpeech tts;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.textvoice);
		
		Button b = (Button) findViewById(R.id.bTextToVoice);
		b.setOnClickListener(this);
		
		tts = new TextToSpeech(TextVoice.this, new TextToSpeech.OnInitListener() {
			
			@Override
			public void onInit(int status) {
				// TODO Auto-generated method stub
				if (status != TextToSpeech.ERROR) {
					tts.setLanguage(Locale.US);
				}
			}
		});
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		if (tts != null) {
			tts.stop();
			tts.shutdown();
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Random r = new Random();
		String random = texts[r.nextInt(6)];
		
		tts.speak(random, TextToSpeech.QUEUE_FLUSH, null);
	}
}
