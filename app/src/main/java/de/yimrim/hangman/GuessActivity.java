package de.yimrim.hangman;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class GuessActivity extends AppCompatActivity implements View.OnClickListener {

    private String word;
    private TextView tvGuess;
    private TextView tvFailCount;
    private EditText etChar;
    private Button sendChar;
    private HangMan hangMan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess);

        tvGuess = findViewById(R.id.tvGuess);
        tvFailCount = findViewById(R.id.tvFailCount);
        etChar = findViewById(R.id.etChar);
        sendChar = findViewById(R.id.sendChar);

        sendChar.setOnClickListener(this);
        Bundle bundle = getIntent().getExtras();
        word = bundle.getString("word");


        hangMan = new HangMan(word, 10);

        tvGuess.setText(hangMan.getDef());
    }

    @Override
    public void onClick(View v) {

        if (!hangMan.isFailed() && !hangMan.isWon()) {
            hangMan.guess(etChar.getText().toString());
            tvGuess.setText(hangMan.getDef());
            tvFailCount.setText("F: " + hangMan.getFailAmount());
            Toast.makeText(getApplicationContext(), hangMan.getAfterGuessMessage(), Toast.LENGTH_SHORT).show();
            etChar.getText().clear();
        } else {
            Intent backToMain = new Intent(this, MainActivity.class);

            if (sendChar.getText().equals("Reset Game")) {
                startActivity(backToMain);
                this.finish();
            } else {
                sendChar.setText("Reset Game");
                Toast.makeText(getApplicationContext(), "you've failed!!, please reset the game", Toast.LENGTH_SHORT).show();
            }
        }

    }
}
