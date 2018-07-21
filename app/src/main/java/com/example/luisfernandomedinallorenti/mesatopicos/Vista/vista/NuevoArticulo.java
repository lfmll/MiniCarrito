package com.example.luisfernandomedinallorenti.mesatopicos.Vista.vista;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.luisfernandomedinallorenti.mesatopicos.R;
import com.example.luisfernandomedinallorenti.mesatopicos.Vista.datos.Data;
import com.example.luisfernandomedinallorenti.mesatopicos.Vista.modelo.Articulo;

public class NuevoArticulo extends AppCompatActivity {
    private EditText nombre,precio;
    private Button GuardarArticulo;
    public Data data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_articulo);

        nombre=(EditText)findViewById(R.id.editNombre);
        precio=(EditText)findViewById(R.id.editPrecio);
        GuardarArticulo=(Button)findViewById(R.id.btnRegistrarArticulo);

        GuardarArticulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nom=nombre.getText().toString();
                String pre=precio.getText().toString();
                Articulo articulo=new Articulo(nom,pre);
                data=new Data(getApplicationContext());
                data.open();
                data.insertarArticulo(articulo);
                Toast.makeText(getApplicationContext(),"Articulo Creado",Toast.LENGTH_LONG).show();
                data.close();
                finish();
            }
        });
    }
}
