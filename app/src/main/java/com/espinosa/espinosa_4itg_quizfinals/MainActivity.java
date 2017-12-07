package com.espinosa.espinosa_4itg_quizfinals;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    Button btn_save, btn_next;
    EditText input_author, input_paragraph;
    FileOutputStream fosAuthor, fosParagraph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input_author = (EditText) findViewById(R.id.input_author);
        input_paragraph = (EditText) findViewById(R.id.input_paragraph);
        btn_save = (Button) findViewById(R.id.btn_save);
        btn_next = (Button) findViewById(R.id.btn_next);
    }

    public void saveQuote(View view) {
        String name = input_author.getText().toString();
        String paragraph = input_paragraph.getText().toString();
        try {
            fosAuthor = openFileOutput("quoteAuthor.txt", Context.MODE_PRIVATE);
            fosAuthor.write(name.getBytes());

            fosParagraph = openFileOutput("quoteParagraph.txt", Context.MODE_PRIVATE);
            fosParagraph.write(paragraph.getBytes());
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                fosAuthor.close();
                fosParagraph.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
        Toast.makeText(this, "Message saved!", Toast.LENGTH_SHORT).show();
    }

    public void callSecondActivity(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        //intent.putExtra("name", etName.getText().toString());
        startActivity(intent);
    }

}
