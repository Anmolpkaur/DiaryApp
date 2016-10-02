package com.example.anmol.diaryapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelperClass extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="Favourites";
    private static final int vers=1;
    private static final String Uname="Uname";
    private static final String  Quality="Quality";
    private static final String Description="Description";
    private static final String sqlquery="CREATE TABLE fav_people( "+Uname+" VARCHAR(20), "+Quality+" VARCHAR(20), "+Description+" VARCHAR(50));";

    public DbHelperClass(Context context)
    {
        super(context,DATABASE_NAME,null,vers);
        SQLiteDatabase obj=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase dbobj) {
        dbobj.execSQL(sqlquery);
    }

    public void addInDB(String name, String quality, String descr,SQLiteDatabase dbobj)
    {
        SQLiteDatabase objl=this.getWritableDatabase();
        ContentValues cv= new ContentValues();
        cv.put(Uname,name);
        cv.put(Quality,quality);
        cv.put(Description,descr);
        dbobj.insert("fav_people",null,cv);

    }
    public Cursor getFromdb(SQLiteDatabase sdb)
    {
        Cursor crs;
        String[] atts={Uname,Quality,Description};
        crs=sdb.query("fav_people",atts,null,null,null,null,null);
        return crs;
    }

    public void delperson(String uname,SQLiteDatabase sqdb)
    {
        String selection= Uname+" LIKE ?";
        String[] selec_args={uname};
        sqdb.delete("fav_people",selection,selec_args);
    }

    public void updateperson(String uname,String newqual,String newdesc,SQLiteDatabase sqdb)
    {
        ContentValues cv= new ContentValues();
        cv.put(Uname,uname);
        cv.put(Quality,newqual);
        cv.put(Description,newdesc);
        String[] selec_args={uname};
        String selection= Uname+" LIKE ?";
       sqdb.update("fav_people",cv,selection,selec_args);



    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
