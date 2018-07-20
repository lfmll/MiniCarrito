package com.example.luisfernandomedinallorenti.mesatopicos.Vista.modelo;

import android.content.ContentValues;

import com.example.luisfernandomedinallorenti.mesatopicos.Vista.datos.SQLConstantes;

public class articulo {
    private int idArticulo;
    private String nombre;
    private String precio;

    public articulo(){
    }

    public articulo(String nombre, String precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
    public ContentValues toValuesA(){
        ContentValues contentValuesA=new ContentValues(2);
        contentValuesA.put(SQLConstantes.ARTICULO_COLUMN_NOMBRE,nombre);
        contentValuesA.put(SQLConstantes.ARTICULO_COLUMN_PRECIO,precio);
        return contentValuesA;
    }
}
