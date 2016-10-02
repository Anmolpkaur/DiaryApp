package com.example.anmol.diaryapp;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class SeeDiaryEntries extends AppCompatActivity {

    private static TextView seeentr;
    private static Button mseebtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_diary_entries);
        seeentryBtnclick();
    }

    public void seeentryBtnclick()
    {
        seeentr=(TextView) findViewById(R.id.seearea);
        mseebtn=(Button)findViewById(R.id.seebtn);
        mseebtn.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {


                        try {
                            //Read EXTERNAL STORAGE

                            File fr= Environment.getExternalStorageDirectory();
                            File folder=new File(fr.getAbsolutePath()+"/MyDiary");
                            File fileobj=new File(folder,"Entrydatafile.txt");
                            String entryd;
                            FileInputStream fis =new FileInputStream(fileobj);
                            InputStreamReader ist = new InputStreamReader(fis);
                            BufferedReader bfr = new BufferedReader(ist);
                            StringBuffer sbf = new StringBuffer();
                            while ((entryd = bfr.readLine()) != null) {
                                sbf.append(entryd + "\n");
                            }

                            seeentr.setText(sbf.toString());

                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                }
        );
    }


}
