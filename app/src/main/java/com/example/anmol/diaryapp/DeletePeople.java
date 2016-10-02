package com.example.anmol.diaryapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeletePeople extends AppCompatActivity {

    private  static Button mdelperson;
    private  static EditText etname;
    Context context=this;
    DbHelperClass dbobj;
    SQLiteDatabase sqldb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_people);
        delpersonBtnclick();
    }

    public void delpersonBtnclick()
    {
        mdelperson=(Button)findViewById(R.id.delperson);
        etname=(EditText)findViewById(R.id.namefill2);

        mdelperson.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        String namef=etname.getText().toString();

                        dbobj=new DbHelperClass(context);
                        sqldb=dbobj.getReadableDatabase();
                        dbobj.delperson(namef,sqldb);
                        Toast.makeText(DeletePeople.this,"Person data deleted!",Toast.LENGTH_LONG).show();
                        dbobj.close();
                    }
                }
        );
    }
}
