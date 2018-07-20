package com.example.luisfernandomedinallorenti.mesatopicos.Vista.vista;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.luisfernandomedinallorenti.mesatopicos.R;
import com.example.luisfernandomedinallorenti.mesatopicos.Vista.datos.Data;
import com.example.luisfernandomedinallorenti.mesatopicos.Vista.modelo.articulo;

public class NuevoPedido extends AppCompatActivity {
    private ListView listView;
    private ArrayAdapter<String> arrayAdapter;
    Data data;
    articulo art;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_pedido);

        art=new articulo();
        listView=(ListView)findViewById(R.id.listaArticulos);
        arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_multiple_choice);
        String nombre,precio;
        data=new Data(getApplicationContext());
        data.open();
        Cursor cursor=data.mostrarArticulos();
        if (cursor.moveToFirst()){
            do {
                nombre=cursor.getString(1);
                precio=cursor.getString(2);
                arrayAdapter.add(nombre+" - "+precio+" Bs");
            }while (cursor.moveToNext());
            listView.setAdapter(arrayAdapter);
            listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        }else {
            Toast.makeText(getApplication(),"No hay datos",Toast.LENGTH_SHORT).show();
            this.finish();
        }
        data.close();

    }
}
