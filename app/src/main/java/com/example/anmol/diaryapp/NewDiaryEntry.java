package com.example.anmol.diaryapp;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class NewDiaryEntry extends AppCompatActivity {


    private static EditText entryarea;
    private static EditText date;
    private static Button addentrybtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_diary_entry);
        addentryBtnclick();
    }

    public void addentryBtnclick()
    {
        entryarea=(EditText)findViewById(R.id.editText);
        date=(EditText)findViewById(R.id.date);
        addentrybtn=(Button)findViewById(R.id.button5);
        addentrybtn.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View v)
                    {
                       String entrydat=entryarea.getText().toString();
                        String dateis=date.getText().toString();
                        String entrydata="\n"+dateis+"\n"+entrydat;

                        try {
                            //EXTERNAL STORAGE
                           String state;
                            File fileobj,fileobj1;
                            state=Environment.getExternalStorageState();
                            if(Environment.MEDIA_MOUNTED.equals(state))
                            {
                                File fr= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);
                                File fr1= getApplicationContext().getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);

                                File folder1=new File(fr1.getAbsolutePath()+"/MyDiary1");
                                File folder=new File(fr.getAbsolutePath()+"/MyDiary");
                                if(!folder.exists()) {
                                    folder.mkdir();
                                }
                                if(!folder1.exists()) {
                                    folder.mkdir();
                                }
                                fileobj=new File(folder,"Entrydatafile.txt");
                                fileobj1=new File(folder1,"Entrydatafile1.txt");

                                FileOutputStream fos=new FileOutputStream(fileobj);
                                FileOutputStream fos1=new FileOutputStream(fileobj1);

                                fos.write(entrydata.getBytes());
                                fos.close();
                                fos1.write(entrydata.getBytes());
                                fos1.close();
                                Toast.makeText(getApplicationContext(),"Entry Saved",Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                Toast.makeText(getApplicationContext(),"SD Card not found",Toast.LENGTH_SHORT).show();
                            }


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
