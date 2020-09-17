package com.nikharsachdeva.triviaapp.Questions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.nikharsachdeva.triviaapp.R;
import com.nikharsachdeva.triviaapp.Summary;

import java.util.ArrayList;
import java.util.List;

import static com.nikharsachdeva.triviaapp.Questions.FirstQuestion.CRICKETER;
import static com.nikharsachdeva.triviaapp.MainActivity.NAME;

public class SecondQuestion extends AppCompatActivity {

    public static final String TAG = "myTag";
    CheckBox cb_White, cb_Yellow, cb_Orange, cb_Green, cb_All;
    Button next_btn;
    List<String> checkedList = new ArrayList<>();
    String CRICKETER_RECEIVED = null;
    String NAME_RECEIVED = null;
    public static final String COLORS = "inputColor";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_question);
        CRICKETER_RECEIVED = getIntent().getStringExtra(CRICKETER);
        NAME_RECEIVED = getIntent().getStringExtra(NAME);

        initViews();
        onClickListeners();
    }

    private void onClickListeners() {

        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearList();
                if (cb_White.isChecked()) {
                    checkedList.add("White");
                }
                if (cb_Yellow.isChecked()) {
                    checkedList.add("Yellow");
                }
                if (cb_Orange.isChecked()) {
                    checkedList.add("Orange");
                }
                if (cb_Green.isChecked()) {
                    checkedList.add("Green");
                }

                if (checkedList.isEmpty()) {
                    Toast.makeText(SecondQuestion.this, "Please select at least 1 item to proceed.", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(SecondQuestion.this, Summary.class);
                    Bundle bundle = new Bundle();
                    bundle.putStringArrayList(COLORS, (ArrayList<String>) checkedList);
                    bundle.putString(NAME, NAME_RECEIVED);
                    bundle.putString(CRICKETER, CRICKETER_RECEIVED);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }
        });
    }


    private void clearList() {
        if (!checkedList.isEmpty()) {
            checkedList.clear();
        }
    }

    private void initViews() {

        cb_All = findViewById(R.id.cb_All);
        cb_White = findViewById(R.id.cb_White);
        cb_Yellow = findViewById(R.id.cb_Yellow);
        cb_Orange = findViewById(R.id.cb_Orange);
        cb_Green = findViewById(R.id.cb_Green);
        next_btn = findViewById(R.id.next_btn);

    }

    public void markAllCheckBoxes(View view) {
        if (view instanceof CheckBox) {
            if (((CheckBox) view).isChecked()) {
                cb_Green.setChecked(true);
                cb_White.setChecked(true);
                cb_Orange.setChecked(true);
                cb_Yellow.setChecked(true);
            } else {
                cb_Green.setChecked(false);
                cb_White.setChecked(false);
                cb_Orange.setChecked(false);
                cb_Yellow.setChecked(false);
            }
        }


    }
}