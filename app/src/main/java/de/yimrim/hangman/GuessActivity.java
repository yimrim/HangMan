package de.yimrim.hangman;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class GuessActivity extends AppCompatActivity implements View.OnClickListener {

    private String word;
    private TextView tvGuess;
    private EditText etChar;
    private Button sendChar;
    private HangMan hangMan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess);

        tvGuess = findViewById(R.id.tvGuess);
        etChar = findViewById(R.id.etChar);
        sendChar = findViewById(R.id.sendChar);

        sendChar.setOnClickListener(this);
        Bundle bundle = getIntent().getExtras();
        word = bundle.getString("word");


        hangMan = new HangMan(word,10);

        tvGuess.setText(hangMan.getDef());
    }

    @Override
    public void onClick(View v) {

        if (!hangMan.isFailed() && !hangMan.isWon()){
            hangMan.guess(word);
            tvGuess.setText(hangMan.getDef());
            Toast toast = Toast.makeText(getApplicationContext(),hangMan.getAfterGuessMessage(),Toast.LENGTH_SHORT);
            toast.show();
        }

    }
}
