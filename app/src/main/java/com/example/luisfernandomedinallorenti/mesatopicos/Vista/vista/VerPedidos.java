package com.example.luisfernandomedinallorenti.mesatopicos.Vista.vista;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.luisfernandomedinallorenti.mesatopicos.R;
import com.example.luisfernandomedinallorenti.mesatopicos.Vista.datos.Data;
import com.example.luisfernandomedinallorenti.mesatopicos.Vista.modelo.Articulo;

public class VerPedidos extends AppCompatActivity {
    private ListView listPedido;
    private ArrayAdapter<String>arrayAdapter;
    Data data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_pedidos);

        listPedido=(ListView)findViewById(R.id.listPedido);
        arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
        Articulo articulo;
        data=new Data(getApplicationContext());
        data.open();
        String id,nro,fecha;

        Cursor cursor=data.mostrarPedidos();
        if (cursor.moveToFirst()){
            do{
                nro=cursor.getString(1);
                fecha=cursor.getString(2);
                id=cursor.getString(3);
                articulo=data.getArticulo(id);
                arrayAdapter.add("Nro:"+nro+"-"+"\n"+"Fecha: "+fecha+"\n"+articulo.getNombre());
            }while (cursor.moveToNext());
            listPedido.setAdapter(arrayAdapter);
        }else {
            Toast.makeText(getApplicationContext(),"NO hay pedidos",Toast.LENGTH_LONG).show();
            this.finish();
        }
        data.close();
    }
}
