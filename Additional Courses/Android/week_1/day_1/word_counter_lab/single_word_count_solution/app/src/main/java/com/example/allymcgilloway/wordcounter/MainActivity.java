package com.example.allymcgilloway.wordcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;
    Button buttonWordCount;
    Button buttonConcordance;
    WordCounter wordCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.text_to_scan);
        buttonWordCount = findViewById(R.id.button_scan);
        buttonConcordance = findViewById(R.id.button_concordance);
        textView = findViewById(R.id.text_result);

        wordCounter = new WordCounter();

    }

    public void onWordCountButtonClick(View view) {
        String textToScan = editText.getText().toString();
        Log.d("WordCounter", "Counting words in : '" + textToScan + "'");

        WordCounter wordCounter = new WordCounter();
        int numberOfWords = wordCounter.getCount(textToScan);
        textView.setText(Integer.toString(numberOfWords) + " words entered");
    }

    public void onConcordanceButtonClick(View view) {
        String textToScan = editText.getText().toString();
        Log.d("WordCounter", "Creating concordance for : '" + textToScan + "'");

        WordCounterExtended wordCounter = new WordCounterExtended(textToScan);
        textView.setText(wordCounter.toString());
    }

}
