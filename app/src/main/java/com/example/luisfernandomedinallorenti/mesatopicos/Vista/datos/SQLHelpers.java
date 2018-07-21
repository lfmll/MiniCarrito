package com.example.luisfernandomedinallorenti.mesatopicos.Vista.datos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLHelpers extends SQLiteOpenHelper{
    public static final int DB_VERSION=1;

    public SQLHelpers(Context context){
        super(context,SQLConstantes.BD_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQLConstantes.SQL_CREATE_TABLE_ARTICULO);
        db.execSQL(SQLConstantes.SQL_CREATE_TABLE_PEDIDO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQLConstantes.SQL_DELETE_ARTICULO);
        db.execSQL(SQLConstantes.SQL_DELETE_PEDIDO);
        onCreate(db);
    }
}
