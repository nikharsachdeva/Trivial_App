package com.nikharsachdeva.triviaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.nikharsachdeva.triviaapp.Database.MyDBOpenHelper;
import com.nikharsachdeva.triviaapp.Database.QuizDataSource;
import com.nikharsachdeva.triviaapp.History.History;
import com.nikharsachdeva.triviaapp.Questions.FirstQuestion;

public class MainActivity extends AppCompatActivity {

    EditText name_et;
    Button next_btn;
    public static final String NAME = "inputName";
    ImageView history_image;

    private QuizDataSource quizDataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createDatabase();
        initViews();
        onClickListeners();
    }

    private void createDatabase() {
        quizDataSource = new QuizDataSource(this);
        quizDataSource.open();
    }

    private void onClickListeners() {
        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isValid()) {
                    Intent intent = new Intent(MainActivity.this, FirstQuestion.class);
                    intent.putExtra(NAME, name_et.getText().toString());
                    startActivity(intent);
                }
            }
        });

        history_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, History.class);
                startActivity(intent);
            }
        });

    }

    private boolean isValid() {

        boolean allow = true;
        if (!name_et.getText().toString().matches("^[A-Za-z\\s]+$")) {
            name_et.setError("Invalid Name");
            allow = false;
        }

        return allow;
    }

    private void initViews() {
        name_et = findViewById(R.id.name_et);
        next_btn = findViewById(R.id.next_btn);
        history_image = findViewById(R.id.history_image);
    }

    // helps to survive configuration changes

    @Override
    protected void onResume() {
        super.onResume();
        quizDataSource.open();
    }

    @Override
    protected void onPause() {
        super.onPause();
        quizDataSource.close();
    }
}