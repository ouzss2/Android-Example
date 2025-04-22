package com.example.tp4_list;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class NoteActivity extends AppCompatActivity {

    Button save;
    EditText name , note,note1,note2,note3,note4,note5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        save = findViewById(R.id.save);
        note1 = findViewById(R.id.Aws);
        note2 = findViewById(R.id.android);
        note3 = findViewById(R.id.uiux);
        note4 = findViewById(R.id.ios);
        note5 = findViewById(R.id.java);
        note = findViewById(R.id.bigdat);
        name = findViewById(R.id.stdname);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent();
                intent.putExtra("n",note.getText().toString());
                intent.putExtra("n1",note1.getText().toString());
                intent.putExtra("n2",note2.getText().toString());
                intent.putExtra("n3",note3.getText().toString());
                intent.putExtra("n4",note4.getText().toString());
                intent.putExtra("n5",note5.getText().toString());
                intent.putExtra("name",name.getText().toString());
                setResult(RESULT_OK,intent);
                finish();
            }
        });


    }
}