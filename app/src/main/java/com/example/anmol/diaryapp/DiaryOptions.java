package com.example.anmol.diaryapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static android.support.v4.app.ActivityCompat.startActivity;

public class DiaryOptions extends AppCompatActivity {


    private static Button mseediary;
    private static Button mnewentry;
    private static Button mcreatetodo;
    private static Button mseetodo;
    private static Button maddfav;
    private static Button mseefav;
    private static Button mdelfav;
    private static Button mupdfav;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary_options);
        SeediaryBtnclick();
        NewEntryBtnclick();
        Createtodoclick();
        Seetodoclick();
        addfavclick();
        seefavclick();
        delfavclick();
        updfavclick();
    }



    public void SeediaryBtnclick()
    {
        mseediary=(Button)findViewById(R.id.seediary);
        mseediary.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        Intent intent=new Intent(DiaryOptions.this,SeeDiaryEntries.class);
                        startActivity(intent);
                    }
                }
        );
    }


    public void NewEntryBtnclick()
    {
        mnewentry=(Button)findViewById(R.id.newentry);
        mnewentry.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        Intent intent=new Intent(DiaryOptions.this,NewDiaryEntry.class);
                        startActivity(intent);
                    }
                }
        );
    }

    public void  Createtodoclick()
    {
       mcreatetodo=(Button)findViewById(R.id.createtodo);
        mcreatetodo.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        Intent intent=new Intent(DiaryOptions.this,CreateToDo.class);
                        startActivity(intent);
                    }
                }
        );
    }

    public void Seetodoclick()
    {
        mseetodo=(Button)findViewById(R.id.seetodo);
        mseetodo.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        Intent intent=new Intent(DiaryOptions.this,SeeToDo.class);
                        startActivity(intent);
                    }
                }
        );
    }

    public void addfavclick()
    {
        maddfav=(Button)findViewById(R.id.addfav);
        maddfav.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        Intent intent=new Intent(DiaryOptions.this,FavouritePeople.class);
                        startActivity(intent);
                    }
                }
        );
    }

    public void seefavclick()
    {
        mseefav=(Button)findViewById(R.id.seefav);
        mseefav.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        Intent intent=new Intent(DiaryOptions.this,SeeFavourites.class);
                        startActivity(intent);
                    }
                }
        );
    }

    public void updfavclick()
    {
        mupdfav=(Button)findViewById(R.id.updfav);
        mupdfav.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        Intent intent=new Intent(DiaryOptions.this,Update_favs.class);
                        startActivity(intent);
                    }
                }
        );
    }

    public void delfavclick()
    {
        mdelfav=(Button)findViewById(R.id.delfav);
        mdelfav.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        Intent intent=new Intent(DiaryOptions.this,DeletePeople.class);
                        startActivity(intent);
                    }
                }
        );
    }


}
