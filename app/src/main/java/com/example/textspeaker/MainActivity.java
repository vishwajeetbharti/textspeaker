package com.example.textspeaker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText text;
    Button speak;
    TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (EditText) findViewById(R.id.editTextTextPersonName);
        speak =(Button) findViewById(R.id.button);
        speak.setOnClickListener(this);
        textToSpeech= new TextToSpeech(getBaseContext(),
                new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int i) {
                        if(i!= TextToSpeech.ERROR){
                            Toast.makeText(MainActivity.this, "@string/success", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
        textToSpeech.setLanguage(Locale.UK);
    }

    @Override
    public void onClick(View view) {
        String value = text.getText().toString();
        textToSpeech.speak(value, TextToSpeech.QUEUE_FLUSH,null);
    }
}