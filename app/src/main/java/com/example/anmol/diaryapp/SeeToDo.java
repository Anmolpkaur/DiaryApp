package com.example.anmol.diaryapp;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SeeToDo extends AppCompatActivity {

    private static TextView todo_area;
    private static EditText sdate;
    private  static Button see_to_do;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_to_do);
        show_todo();
    }

    public void show_todo()
    {
        see_to_do=(Button)findViewById(R.id.button6);
        todo_area=(TextView)findViewById(R.id.todoarea);
        sdate=(EditText)findViewById(R.id.dateff);
        see_to_do.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View v)
                    {
                         String ssdate=sdate.getText().toString();
                        SharedPreferences todo_pref=SeeToDo.this.getSharedPreferences(getString(R.string.TODO_LIST_PREFS),MODE_PRIVATE);
                        String todo_entries=todo_pref.getString(ssdate,"NO DATA FOUND");
                        todo_area.setText(todo_entries);
                    }
                }
        );


    }
}
