package com.example.luisfernandomedinallorenti.mesatopicos.Vista.datos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.luisfernandomedinallorenti.mesatopicos.Vista.modelo.Articulo;
import com.example.luisfernandomedinallorenti.mesatopicos.Vista.modelo.Pedido;

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
    public void insertarArticulo(Articulo articulo){
        ContentValues values=articulo.toValuesA();
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
    public void insertarPedido(Pedido pedido){
        ContentValues values=pedido.toValues();
        sqLiteDatabase.insert(SQLConstantes.TABLE_PEDIDO,null,values);
    }
    public Cursor mostrarPedidos(){
        Cursor cursor=sqLiteDatabase.query(
                SQLConstantes.TABLE_PEDIDO,
                SQLConstantes.ALL_PEDIDOS_COLUMNS,
                null,null,null,null,SQLConstantes.PEDIDO_COLUMN_NRO
        );
        return cursor;
    }

    public Articulo getArticulo(String id){
        Articulo articulo=new Articulo();
        String[]whereArgs=new String[]{id};
        Cursor cursor=sqLiteDatabase.query(
            SQLConstantes.TABLE_ARTICULO,
            SQLConstantes.ALL_ARTICULOS_COLUMNS,
            SQLConstantes.SEARCH_BY_IDARTICULO,
                whereArgs,
                null,null,null
        );
        while (cursor.moveToNext()) {
            articulo.setNombre(cursor.getString(cursor.getColumnIndex(SQLConstantes.ARTICULO_COLUMN_NOMBRE)));
        }
        return articulo;
    }

}
