package com.example.luisfernandomedinallorenti.mesatopicos.Vista.modelo;

import android.content.ContentValues;

import com.example.luisfernandomedinallorenti.mesatopicos.Vista.datos.SQLConstantes;

public class Pedido {
    private int idPedido;
    private int Nro;
    private String fecha;
    private int producto_id;

    public Pedido(){}

    public Pedido(int nro, String fecha, int producto_id) {
        this.Nro = nro;
        this.fecha = fecha;
        this.producto_id = producto_id;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int id) {
        this.idPedido = id;
    }

    public int getNro() {
        return Nro;
    }

    public void setNro(int nro) {
        Nro = nro;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getProducto_id() {
        return producto_id;
    }

    public void setProducto_id(int producto_id) {
        this.producto_id = producto_id;
    }

    //Contenedor
    public ContentValues toValues(){
        ContentValues contentValues=new ContentValues(4);
        contentValues.put(SQLConstantes.PEDIDO_COLUMN_NRO,Nro);
        contentValues.put(SQLConstantes.PEDIDO_COLUMN_FECHA,fecha);
        contentValues.put(SQLConstantes.PEDIDO_COLUMN_ARICULO_ID,producto_id);
        return contentValues;
    }
}
