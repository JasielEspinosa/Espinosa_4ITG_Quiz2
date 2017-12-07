package com.espinosa.espinosa_4itg_quizfinals;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SecondActivity extends AppCompatActivity {

    TextView tv_name, tv_paragraph;
    Button btn_back;
    FileInputStream fisAuthor, fisParagraph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tv_name = (TextView) findViewById(R.id.tv_name);
        tv_paragraph = (TextView) findViewById(R.id.tv_paragraph);
        btn_back = (Button) findViewById(R.id.btn_back);

        StringBuffer buffer = new StringBuffer();
        int read = 0;
        try {
            fisAuthor = openFileInput("quoteAuthor.txt");
            while ((read = fisAuthor.read()) != -1) {
                buffer.append((char) read);
                tv_name.setText(buffer.toString() + " SAID");
            }
            buffer.delete(0, buffer.length());
            fisParagraph = openFileInput("quoteParagraph.txt");
            while ((read = fisParagraph.read()) != -1) {
                buffer.append((char) read);
                tv_paragraph.setText("\""+buffer.toString()+"\"");
            }
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                fisAuthor.close();
                fisParagraph.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }

    public void callMainActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
