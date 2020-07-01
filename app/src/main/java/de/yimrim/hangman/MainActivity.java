package de.yimrim.hangman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button b;
    private EditText et;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b = findViewById(R.id.sendChar);
        et = findViewById(R.id.etChar);
        b.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {

        String word = et.getText().toString();
        Intent toGuess = new Intent(this,GuessActivity.class);
        toGuess.putExtra("word",word);
        startActivity(toGuess);
        this.finish();

    }


}