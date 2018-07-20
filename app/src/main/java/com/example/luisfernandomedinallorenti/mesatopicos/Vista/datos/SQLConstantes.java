package com.example.luisfernandomedinallorenti.mesatopicos.Vista.datos;

public class SQLConstantes {
    public static final String BD_NAME="carrito.db";
    public static final String TABLE_PEDIDO="pedido";
    public static final String TABLE_ARTICULO="articulo";

    public static final String PEDIDO_COLUMN_ID="idPedido";
    public static final String PEDIDO_COLUMN_NRO="nro";
    public static final String PEDIDO_COLUMN_FECHA="fecha";
    public static final String PEDIDO_COLUMN_ARICULO_ID="articulo_id";

    public static final String ARTICULO_COLUMN_ID="idarticulo";
    public static final String ARTICULO_COLUMN_NOMBRE="nombre";
    public static final String ARTICULO_COLUMN_PRECIO="precio";

    public static final String SQL_CREATE_TABLE_ARTICULO=
            "CREATE TABLE "+TABLE_ARTICULO+"("+
                    ARTICULO_COLUMN_ID+" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "+
                    ARTICULO_COLUMN_NOMBRE+" TEXT NOT NULL,"+
                    ARTICULO_COLUMN_PRECIO+" TEXT);";

    public static final String SQL_CREATE_TABLE_PEDIDO=
                "CREATE TABLE "+TABLE_PEDIDO+"("+
                        PEDIDO_COLUMN_ID+" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "+
                        PEDIDO_COLUMN_NRO+" INTEGER NOT NULL,"+
                        PEDIDO_COLUMN_FECHA+" DATE,"+
                        PEDIDO_COLUMN_ARICULO_ID+" INT);";

    public static final String[] ALL_ARTICULOS_COLUMNS={ARTICULO_COLUMN_ID, ARTICULO_COLUMN_NOMBRE,ARTICULO_COLUMN_PRECIO};
    public static final String[] ALL_PEDIDOS_COLUMNS={PEDIDO_COLUMN_ID,PEDIDO_COLUMN_NRO,PEDIDO_COLUMN_FECHA,PEDIDO_COLUMN_ARICULO_ID};
    public static final String SQL_DELETE="DROP TABLE"+TABLE_ARTICULO;
    public static final String SELECT_ALL_ARTICULO="SELECT * FROM"+TABLE_ARTICULO;
    public static final String SELECT_ALL_PEDIDO="SELECT * FROM"+TABLE_PEDIDO;
}
