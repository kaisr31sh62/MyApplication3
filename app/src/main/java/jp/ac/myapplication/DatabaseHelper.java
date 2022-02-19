package jp.ac.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private final static String DB_NAME = "MySampleDatabase";
    private final static int DB_VERSION = 1;
    private final static String CREATE_TABLE = "create table post(_id integer primary key autoincrement , name text not null ,others text)";

    //コンストラクタ
    public DatabaseHelper(@Nullable Context context) {
        super(context, DB_NAME,null, DB_VERSION);
        //DBを作成
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //サンプルデータベース作成
        db.execSQL(CREATE_TABLE);

        //Contentvaluesクラスを利用したサンプルデータの作成
        ContentValues contentValues = new ContentValues();
        contentValues.put("name","トランペット");

        contentValues.put("others","hello");
        //インサートする
        db.insert("post" , null, contentValues );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
