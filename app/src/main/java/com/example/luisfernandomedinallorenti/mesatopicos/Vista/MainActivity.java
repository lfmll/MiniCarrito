package com.example.luisfernandomedinallorenti.mesatopicos.Vista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.luisfernandomedinallorenti.mesatopicos.R;
import com.example.luisfernandomedinallorenti.mesatopicos.Vista.vista.NuevoArticulo;
import com.example.luisfernandomedinallorenti.mesatopicos.Vista.vista.NuevoPedido;
import com.example.luisfernandomedinallorenti.mesatopicos.Vista.vista.VerPedidos;

public class MainActivity extends AppCompatActivity {
    private Button abrirArticulo,abrirPedido,verPedidos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        abrirArticulo=(Button)findViewById(R.id.btnArticulo);
        abrirPedido=(Button)findViewById(R.id.btnPedido);
        verPedidos=(Button)findViewById(R.id.btnVerPedidos);
        abrirArticulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(), NuevoArticulo.class);
                        startActivityForResult(intent,0);
            }
        });
        abrirPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(), NuevoPedido.class);
                startActivityForResult(intent,0);
            }
        });
        verPedidos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(), VerPedidos.class);
                startActivityForResult(intent,0);
            }
        });
    }
}
