package com.example.tp4_list;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lst ;
    ImageButton add;
    AutoCompleteTextView autoCompleteTextView;
    ActivityResultLauncher launcher;
    List<String> names;
    ArrayList<String> notenew;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lst = findViewById(R.id.studentList);
        add = findViewById(R.id.addstudent);
        autoCompleteTextView = findViewById(R.id.autotext);
    notenew = new ArrayList<>();
        launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),result ->{
            if (result.getResultCode() == RESULT_OK && result.getData() != null)
            {
              Intent data = result.getData();
              names.add(data.getStringExtra("name"));
              notenew.add(data.getStringExtra("n1"));
              notenew.add(data.getStringExtra("n2"));
              notenew.add(data.getStringExtra("n3"));
              notenew.add(data.getStringExtra("n4"));
              notenew.add(data.getStringExtra("n5"));
              notenew.add(data.getStringExtra("n"));
                ArrayAdapter adapter = new ArrayAdapter(this,
                        androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                        names);
                autoCompleteTextView.setAdapter(adapter);

            }
        });


add.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent i = new Intent(MainActivity.this, NoteActivity.class);
        launcher.launch(i);
    }
});




         names = new ArrayList<>();
        names.add("Sarra");
        names.add("Sami");
        names.add("Ali");


        ArrayList<String> noteSarra = new ArrayList<>();
        noteSarra.add("10.0");
        noteSarra.add("15.5");
        noteSarra.add("18.0");
        ArrayList<String> noteSami = new ArrayList<>();
        noteSami.add("10.0");
        noteSami.add("11.5");
        noteSami.add("8.0");
        ArrayList<String> noteAliAA = new ArrayList<>();
        noteAliAA.add("20.0");
        noteAliAA.add("15.5");
        noteAliAA.add("8.0");

        ArrayAdapter adapter = new ArrayAdapter(this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                names);
        autoCompleteTextView.setAdapter(adapter);

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedName = ((TextView)view).getText().toString();
                Log.v("Selected Name",selectedName);
                ListAdapter adapter1;
                if(selectedName.equals("Sarra")){
                    adapter1 = new ListAdapter(MainActivity.this, noteSarra);
                }else if (selectedName.equals("Sami")){
                    adapter1 = new ListAdapter(MainActivity.this, noteSami);

                }else if (selectedName.equals("SaAlirra")){                               adapter1 = new ListAdapter(MainActivity.this, noteAliAA);


                }else {
                    adapter1 = new ListAdapter(MainActivity.this, notenew);
                }

                lst.setAdapter(adapter1);
                lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        TextView txt = view.findViewById(R.id.mark);

                       // String Note = ((TextView)view).getText().toString();

                        Double mark = Double.parseDouble(txt.getText().toString());
                        if (mark >=10){
                            Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(getApplicationContext(),"Failed",Toast.LENGTH_SHORT).show();

                        }

                    }
                });
            }
        });

    }
}