package com.nikharsachdeva.triviaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.nikharsachdeva.triviaapp.Database.QuizDataSource;
import com.nikharsachdeva.triviaapp.History.AnswersModel;
import com.nikharsachdeva.triviaapp.History.History;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static com.nikharsachdeva.triviaapp.Questions.FirstQuestion.CRICKETER;
import static com.nikharsachdeva.triviaapp.MainActivity.NAME;
import static com.nikharsachdeva.triviaapp.Questions.SecondQuestion.COLORS;

public class Summary extends AppCompatActivity {

    String Name, Cricketer;
    List<String> colorsList = new ArrayList<>();
    public static final String TAG = "myTag";
    Button finish_btn, history_btn;
    TextView hello_name, answer_one, answer_two;
    QuizDataSource quizDataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        initViews();
        getAnswers();
        setAnswers();
        onClickListeners();
    }

    private void onClickListeners() {
        finish_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveAndFinish();
            }
        });

        history_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveAndHistory();
            }
        });
    }

    private void saveAndHistory() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        String currentDateandTime = sdf.format(new Date());
        AnswersModel answersModel = new AnswersModel(currentDateandTime, "0", Name, Cricketer, answer_two.getText().toString());
        quizDataSource.insertItem(answersModel);

        Intent intent = new Intent(Summary.this, History.class);
        startActivity(intent);

    }

    private void saveAndFinish() {

        Intent intent = new Intent(Summary.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        String currentDateandTime = sdf.format(new Date());
        AnswersModel answersModel = new AnswersModel(currentDateandTime, "0", Name, Cricketer, answer_two.getText().toString());
        quizDataSource.insertItem(answersModel);

    }

    private void getAnswers() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            Name = bundle.getString(NAME);
            Cricketer = bundle.getString(CRICKETER);
            colorsList = bundle.getStringArrayList(COLORS);
        }
    }

    private void setAnswers() {
        hello_name.setText("Hello " + Name + ",");
        answer_one.setText(Cricketer);
        answer_two.setText(colorsList.toString().replace("[", "").replace("]", ""));
    }

    private void initViews() {
        finish_btn = findViewById(R.id.finish_btn);
        history_btn = findViewById(R.id.history_btn);
        hello_name = findViewById(R.id.hello_name);
        answer_one = findViewById(R.id.answer_one);
        answer_two = findViewById(R.id.answer_two);
        quizDataSource = new QuizDataSource(this);
        quizDataSource.open();

    }
}