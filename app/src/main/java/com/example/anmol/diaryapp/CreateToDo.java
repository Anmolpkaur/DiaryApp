package com.example.anmol.diaryapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateToDo extends AppCompatActivity {

    private static Button mtodobtn;
    private static EditText edate;
    private static EditText etodo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_to_do);
        AddtodoBtnclick();
    }

    public void AddtodoBtnclick()
    {
        mtodobtn=(Button)findViewById(R.id.maddtodo);
        edate=(EditText)findViewById(R.id.date);
        etodo=(EditText)findViewById(R.id.todo);
        mtodobtn.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        String todoentry=etodo.getText().toString();
                        String dateentry=edate.getText().toString();
                       // String fullentry=dateentry+"\n"+todoentry;
                        //SharedPreferences todo_pref=getPreferences("TODO_LIST_PREFS",MODE_PRIVATE);
                       SharedPreferences todo_pref=CreateToDo.this.getSharedPreferences(getString(R.string.TODO_LIST_PREFS),MODE_PRIVATE);
                        SharedPreferences.Editor p_edit=todo_pref.edit();
                        p_edit.putString(dateentry,todoentry);
                        p_edit.commit();
                        Toast.makeText(CreateToDo.this,"TO DO ENTRY CREATED",Toast.LENGTH_LONG).show();
                        Intent intent=new Intent(CreateToDo.this,CreateToDo.class);
                        startActivity(intent);
                    }
                }
        );
    }
}
