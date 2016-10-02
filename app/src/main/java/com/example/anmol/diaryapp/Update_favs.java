package com.example.anmol.diaryapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Update_favs extends AppCompatActivity {


    private  static Button mupdateper;
    private  static EditText oldname;
    private  static EditText newqual;
    private  static EditText newdesc;
    Context context=this;
    DbHelperClass dbobj;
    SQLiteDatabase sqldb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_favs);
        updatepersonBtnclick();
    }

    public void updatepersonBtnclick()
    {
        mupdateper=(Button)findViewById(R.id.updateperson);
        oldname=(EditText)findViewById(R.id.namfill);
        newqual=(EditText)findViewById(R.id.qualityfill2);
        newdesc=(EditText)findViewById(R.id.descfill2);

        mupdateper.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        String namef=oldname.getText().toString();
                        String nqual=newqual.getText().toString();
                        String ndescn=newdesc.getText().toString();
                        dbobj=new DbHelperClass(context);
                        sqldb=dbobj.getWritableDatabase();
                        dbobj.updateperson(namef,nqual,ndescn,sqldb);
                        Toast.makeText(Update_favs.this,"Person data updated!",Toast.LENGTH_LONG).show();
                        dbobj.close();
                    }
                }
        );
    }
}
