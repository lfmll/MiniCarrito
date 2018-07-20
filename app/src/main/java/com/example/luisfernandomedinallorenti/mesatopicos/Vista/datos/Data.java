package com.example.luisfernandomedinallorenti.mesatopicos.Vista.datos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.luisfernandomedinallorenti.mesatopicos.Vista.modelo.articulo;

public class Data {
    private Context context;
    private SQLiteDatabase sqLiteDatabase;
    private SQLiteOpenHelper sqLiteOpenHelper;

    public Data(Context context) {
        this.context = context;
        sqLiteOpenHelper=new SQLHelpers(context);
        sqLiteDatabase=sqLiteOpenHelper.getWritableDatabase();
    }

    public void open(){
        sqLiteDatabase=sqLiteOpenHelper.getWritableDatabase();
    }
    public void close(){
        sqLiteOpenHelper.close();
    }
    //Metodos
    public void insertarArticulo(articulo art){
        ContentValues values=art.toValuesA();
        sqLiteDatabase.insert(SQLConstantes.TABLE_ARTICULO,null,values);
    }

    public Cursor mostrarArticulos(){
        Cursor cursor=sqLiteDatabase.query(
                SQLConstantes.TABLE_ARTICULO,
                SQLConstantes.ALL_ARTICULOS_COLUMNS,
                null,null,null,null,null
        );
        return cursor;
    }

}
