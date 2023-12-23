package com.example.sampleat;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
public class DatabaseHelper extends SQLiteOpenHelper{

    public static final String DATABASE_NAME= "Parent1.db";
    //Table-1 user details
    public static final String TABLE_NAME= "details_table";
    public static final String COL_1= "NAME";
    public static final String COL_2= "EMAIL";
    public static final String COL_3= "PHONE";
    public static final String COL_4= "USERNAME";




    //Table-2 Food Feeding
    private static final String TABLE_FEEDING = "feeding";
    private static final String COLUMN_FEEDING_TIME ="time";
    private static final String COLUMN_FEEDING_CALORIES ="calories" ;







    //Table-3 Diapers
    private static final String TABLE_DIAPER = "diaper";
    private static final String COLUMN_DIAPER_POOP_TIME = "poop_time";
    private static final String COLUMN_DIAPER_DIAPER_TIME = "diaper_time";
    private static final String COLUMN_DIAPER_COLOR = "color";
    private static final String COLUMN_DIAPER_CONSISTENCY = "consistency";


    //Table -4 BreastFeeding
    private static final String TABLE_BFEEDING = "bfeeding";
    private static final String COLUMN_BFEEDING_DATE = "date";
    private static final String COLUMN_BFEEDING_TIME = "time";

    //Table-5 Sleeping
    public static final String TABLE_SLEEPING = "sleeping";
    public static final String COLUMN_SLEEPING_DATE = "date";
    public static final String COLUMN_SLEEPING_START_TIME = "start_time";
    public static final String COLUMN_SLEEPING_STOP_TIME = "stop_time";
    public static final String COLUMN_SLEEPING_ELAPSED_TIME = "elapsed_time";



    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_NAME + "( NAME TEXT,EMAIL TEXT, PHONE TEXT, USERNAME TEXT)");

        String CREATE_FEEDING_TABLE = "CREATE TABLE " + TABLE_FEEDING + "("
                + COLUMN_FEEDING_TIME + " TEXT,"
                + COLUMN_FEEDING_CALORIES + " TEXT"
                + ")";
        sqLiteDatabase.execSQL(CREATE_FEEDING_TABLE);

        String CREATE_DIAPER_TABLE = "CREATE TABLE " + TABLE_DIAPER + "("
                + COLUMN_DIAPER_POOP_TIME + " TEXT,"
                + COLUMN_DIAPER_DIAPER_TIME + " TEXT,"
                + COLUMN_DIAPER_COLOR + " TEXT,"
                + COLUMN_DIAPER_CONSISTENCY + " TEXT"
                + ")";
        sqLiteDatabase.execSQL(CREATE_DIAPER_TABLE);

        String CREATE_BFEEDING_TABLE = "CREATE TABLE " + TABLE_BFEEDING + "("
                + COLUMN_BFEEDING_DATE + " TEXT,"
                + COLUMN_FEEDING_TIME + " TEXT"
                + ")";
        sqLiteDatabase.execSQL(CREATE_BFEEDING_TABLE);

        String CREATE_SLEEPING_TABLE = "CREATE TABLE " + TABLE_SLEEPING + "("
                + COLUMN_SLEEPING_DATE + " TEXT,"
                + COLUMN_SLEEPING_START_TIME + " TEXT,"
                + COLUMN_SLEEPING_STOP_TIME + " TEXT,"
                + COLUMN_SLEEPING_ELAPSED_TIME + " TEXT"
                + ")";
        sqLiteDatabase.execSQL(CREATE_SLEEPING_TABLE);
    }




    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_FEEDING);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_DIAPER);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_BFEEDING);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_SLEEPING);
        onCreate(sqLiteDatabase);
    }



    public boolean insertUserData(String name, String email, String phone,String username){
        SQLiteDatabase sqLiteDatabase= this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put(COL_1,name);
        contentValues.put(COL_2,email);
        contentValues.put(COL_3,phone);
        contentValues.put(COL_4,username);
        long result = sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        return result != -1;
    }

    public boolean insertFeedingData(String time, String calories) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_FEEDING_TIME, time);
        values.put(COLUMN_FEEDING_CALORIES, calories);
        long result2=sqLiteDatabase.insert(TABLE_FEEDING, null, values);
        return result2 != -1;


    }

    public boolean insertDiaperData(String poopTime, String diaperTime, String color, String consistency) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_DIAPER_POOP_TIME, poopTime);
        values.put(COLUMN_DIAPER_DIAPER_TIME, diaperTime);
        values.put(COLUMN_DIAPER_COLOR, color);
        values.put(COLUMN_DIAPER_CONSISTENCY, consistency);
        long result3= sqLiteDatabase.insert(TABLE_DIAPER, null, values);
        return result3 != -1;
        //sqLiteDatabase.close();
    }
    public boolean insertBFeedingData(String date, String time) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_BFEEDING_DATE, date);
        values.put(COLUMN_BFEEDING_TIME, time);
        long result4= sqLiteDatabase.insert(TABLE_BFEEDING, null, values);
        return result4 != -1;
        //sqLiteDatabase.close();
    }


    public boolean insertSleepingData(String date, String startTime, String stopTime, String elapsedTime) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_SLEEPING_DATE, date);
        values.put(COLUMN_SLEEPING_START_TIME, startTime);
        values.put(COLUMN_SLEEPING_STOP_TIME, stopTime);
        values.put(COLUMN_SLEEPING_ELAPSED_TIME, elapsedTime);
        long result5=sqLiteDatabase.insert(TABLE_SLEEPING, null, values);
        return result5 != -1;
        //sqLiteDatabase.close();
    }









    public Cursor getUserData() {
        SQLiteDatabase sqLiteDatabase= this.getWritableDatabase();
        Cursor res1 = sqLiteDatabase.rawQuery("select * from " + TABLE_NAME, null);
        return res1;
    }


    public Cursor getFoodData() {
        SQLiteDatabase sqLiteDatabase= this.getWritableDatabase();
        Cursor res2 = sqLiteDatabase.rawQuery("select * from " + TABLE_FEEDING, null);
        return res2;
    }


    public Cursor getDiaperData() {
        SQLiteDatabase sqLiteDatabase= this.getWritableDatabase();
        Cursor res3 = sqLiteDatabase.rawQuery("select * from " + TABLE_DIAPER, null);
        return res3;
    }

    public Cursor getBreastFeedingData() {
        SQLiteDatabase sqLiteDatabase= this.getWritableDatabase();
        Cursor res4 = sqLiteDatabase.rawQuery("select * from " + TABLE_BFEEDING, null);
        return res4;
    }
    public Cursor getSleepingData() {
        SQLiteDatabase sqLiteDatabase= this.getWritableDatabase();
        Cursor res4 = sqLiteDatabase.rawQuery("select * from " + TABLE_SLEEPING, null);
        return res4;
    }
















}