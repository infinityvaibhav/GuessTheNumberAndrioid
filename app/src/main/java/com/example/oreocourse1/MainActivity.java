package com.example.oreocourse1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button guessButton;
    EditText valueEditText;
    static int mNumber = 15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        guessButton = findViewById(R.id.guess_button);
        valueEditText = findViewById(R.id.value_edit_text);
        generateRandomNumber();

        guessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateUserValue();
            }
        });
    }

    private void validateUserValue() {

        String userValueInString = valueEditText.getText().toString().trim();
        if (!userValueInString.matches("")) {
            int userInput = Integer.parseInt(valueEditText.getText().toString().trim());
            if (userInput < mNumber) {
                showToastMessageAndResetEditText(getString(R.string.text_higher));
            } else if (userInput > mNumber) {
                showToastMessageAndResetEditText(getString(R.string.text_lower));
            } else {
                showToastMessageAndResetEditText(getString(R.string.text_passed));
                generateRandomNumber();

            } } else {
            showToastMessageAndResetEditText(getString(R.string.empty_error_message_edit_text));
        }

    }

    private void generateRandomNumber() {
        Random random = new Random();
        mNumber = random.nextInt(21);
    }

    private void showToastMessageAndResetEditText(String message) {
        valueEditText.setText("");
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}
