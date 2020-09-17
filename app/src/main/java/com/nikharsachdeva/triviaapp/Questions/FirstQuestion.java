package com.nikharsachdeva.triviaapp.Questions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.nikharsachdeva.triviaapp.R;

import static com.nikharsachdeva.triviaapp.MainActivity.NAME;

public class FirstQuestion extends AppCompatActivity {

    private static final String TAG = "myTag";
    RadioGroup radio_group_cricketer;
    Button next_btn;
    String NAME_RECEIVED = null;
    public static final String CRICKETER = "inputCricketer";

    int selectedRadioId;
    RadioButton selectedRadioButton;
    String selectedCricketerName = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_question);
        NAME_RECEIVED = getIntent().getStringExtra(NAME);
        initViews();
        onClickListners();
    }

    private void onClickListners() {

        radio_group_cricketer.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                selectedRadioId = radio_group_cricketer.getCheckedRadioButtonId();
                selectedRadioButton = (RadioButton) radio_group_cricketer.findViewById(selectedRadioId);
                selectedCricketerName = selectedRadioButton.getText().toString();

            }
        });

        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (selectedRadioId == 0) {
                    Toast.makeText(FirstQuestion.this, "Please select any one choice to proceed.", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(FirstQuestion.this, SecondQuestion.class);
                    //Passing these values from Activity A to B via Intent
                    intent.putExtra(NAME, NAME_RECEIVED);
                    intent.putExtra(CRICKETER, selectedCricketerName);
                    startActivity(intent);
                }
            }
        });
    }

    private void initViews() {
        next_btn = findViewById(R.id.next_btn);
        radio_group_cricketer = findViewById(R.id.radio_group_cricketer);

    }
}