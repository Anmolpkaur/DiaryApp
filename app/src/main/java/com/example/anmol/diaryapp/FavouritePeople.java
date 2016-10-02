package com.example.anmol.diaryapp;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FavouritePeople extends AppCompatActivity {

    private  static Button maddperson;
    private  static EditText ename;
    private  static EditText equality;
    private  static EditText edesc;
    Context context=this;
    DbHelperClass dbobj;
    SQLiteDatabase sqldb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite_people);
        addpersonBtnclick();
    }


    public void addpersonBtnclick()
    {
        maddperson=(Button)findViewById(R.id.addperson);
        ename=(EditText)findViewById(R.id.namefill);
        equality=(EditText)findViewById(R.id.qualityfill);
        edesc=(EditText)findViewById(R.id.descfill);
        maddperson.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        String namef=ename.getText().toString();
                        String qual=equality.getText().toString();
                        String descn=edesc.getText().toString();
                        dbobj=new DbHelperClass(context);
                        sqldb=dbobj.getWritableDatabase();
                        dbobj.addInDB(namef,qual,descn,sqldb);
                        Toast.makeText(FavouritePeople.this,"Person data added!",Toast.LENGTH_LONG).show();
                       dbobj.close();
                    }
                }
        );
    }
}
