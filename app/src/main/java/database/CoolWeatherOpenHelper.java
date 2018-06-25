package database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2018/6/25.
 */

public class CoolWeatherOpenHelper extends SQLiteOpenHelper {

    public static final String CREATE_PROVINCE="create table Privince("
                    +"id integer primary key autoincrement"
                    +"privince_name text,"
                    +"privince_code text)";
    public static final String CREATE_CITY="create table City("
            +"id integer primary key autoincrement"
            +"city_name text,"
            +"city_code text"
            +"province_id int)";
    public static final String CREATE_COUNTRY="create table Country("
            +"id integer primary key autoincrement"
            +"country_name text,"
            +"country_code text"
            +"city_id int)";

    public CoolWeatherOpenHelper(Context context, String DBname, SQLiteDatabase.CursorFactory factory, int version){
        super(context,DBname,factory,version);

    }
    public void onCreate(SQLiteDatabase db){
        db.execSQL(CREATE_PROVINCE);
        db.execSQL(CREATE_CITY);
        db.execSQL(CREATE_COUNTRY);
    }

    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){

    }



}
