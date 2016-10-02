package com.example.anmol.diaryapp;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static Button mstartbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startBtnclick();
    }

    public void startBtnclick()
    {

        mstartbtn=(Button)findViewById(R.id.startbtn);

        mstartbtn.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        Intent intent=new Intent(MainActivity.this,DiaryOptions.class);
                        startActivity(intent);

                    }
                }
        );
    }


}
