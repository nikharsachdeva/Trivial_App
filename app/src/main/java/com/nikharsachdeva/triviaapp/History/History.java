package com.nikharsachdeva.triviaapp.History;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.nikharsachdeva.triviaapp.Database.QuizDataSource;
import com.nikharsachdeva.triviaapp.R;

import java.util.ArrayList;
import java.util.List;

public class History extends AppCompatActivity {

    RecyclerView history_rv;
    private QuizDataSource quizDataSource;
    List<AnswersModel> answersModelList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        initViews();

        setupRecyclerview();

    }

    private void setupRecyclerview() {
        // This line retrieves the list from database and saves in List<AnswersModel> answersModelList.
        answersModelList = quizDataSource.getAllItems();

        if (answersModelList.isEmpty()) {
            Toast.makeText(this, "No Entries Found!", Toast.LENGTH_SHORT).show();
        } else {
            HistoryAdapter adapter = new HistoryAdapter(answersModelList, History.this);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(History.this, LinearLayoutManager.VERTICAL, false);
            history_rv.setLayoutManager(layoutManager);
            history_rv.setAdapter(adapter);
        }

    }

    private void initViews() {
        history_rv = findViewById(R.id.history_rv);
        quizDataSource = new QuizDataSource(this);
        quizDataSource.open();
    }
}