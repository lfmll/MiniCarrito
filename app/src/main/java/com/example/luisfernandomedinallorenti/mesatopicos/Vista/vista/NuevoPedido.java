package com.example.luisfernandomedinallorenti.mesatopicos.Vista.vista;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import android.widget.Toast;

import com.example.luisfernandomedinallorenti.mesatopicos.R;
import com.example.luisfernandomedinallorenti.mesatopicos.Vista.datos.Data;
import com.example.luisfernandomedinallorenti.mesatopicos.Vista.modelo.Articulo;
import com.example.luisfernandomedinallorenti.mesatopicos.Vista.modelo.Pedido;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class NuevoPedido extends AppCompatActivity {
    private ListView listView;
    private ArrayAdapter<String> arrayAdapter;
    private EditText numero;
    private Button btnGuardarPedido;

    Data data;
    Articulo articulo;
    Pedido pedido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_pedido);

        /***********Mostrar Lista Articulos*********/
        articulo=new Articulo();
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

        /*********Guardar Pedido*********/
        pedido=new Pedido();
        numero=(EditText)findViewById(R.id.editNro);
        btnGuardarPedido=(Button)findViewById(R.id.btnGuardarPedido);
        btnGuardarPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nro=Integer.parseInt(numero.getText().toString());
                SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
                Date date=new Date();
                String fecha=dateFormat.format(date).toString();

                //Seleccionar Lista de Articulos
                SparseBooleanArray checked=listView.getCheckedItemPositions();
                ArrayList<String>selectedItems=new ArrayList<String>();
                int posicion;
                Pedido pedido;
                for (int i=0;i<checked.size();i++){
                    posicion=checked.keyAt(i);
                    pedido=new Pedido(nro,fecha,posicion);
                    data.open();
                    data.insertarPedido(pedido);
                    data.close();
                }

                Toast.makeText(getApplicationContext(),"Pedido Guardado",Toast.LENGTH_LONG).show();
            }
        });

    }
}
