package com.example.anmol.diaryapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SeeFavourites extends AppCompatActivity {

    private  static Button mseeperson;
    private  static TextView tfavlist;
    Context context=this;
    DbHelperClass dbobj;
    SQLiteDatabase sqldb;
    Cursor ans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_favourites);
        seepersonBtnclick();
    }

    public void seepersonBtnclick()
    {
        mseeperson=(Button)findViewById(R.id.seepersons);
        tfavlist=(TextView) findViewById(R.id.favlist);

        mseeperson.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View v)
                    {

                        dbobj=new DbHelperClass(context);
                        sqldb=dbobj.getReadableDatabase();
                         ans=dbobj.getFromdb(sqldb);
                        String display="\n";
                       if(ans.moveToFirst())
                       {
                           do {
                               String nam,quali,des;
                               nam=ans.getString(0);
                               quali=ans.getString(1);
                               des=ans.getString(2);
                               display=display+"\n"+nam+"\n"+quali+"\n"+des+"\n";

                               }while(ans.moveToNext());

                       }
                        tfavlist.setText(display);

                        dbobj.close();
                    }
                }
        );
    }
}
