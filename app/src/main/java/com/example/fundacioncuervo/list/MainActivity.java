package com.example.fundacioncuervo.list;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView txt;
    private ListView lista;

    /*private String productos[] = {"Computadora", "Mouse", "Dulces", "Hojas",
            "Lapices", "Lentes","Reloj", "Cuchara", "Celular", "Mesa", "Refrigerador",
            "Horno", "Audifonos"};

    private String categoria[] = {"Electronica","Electronica","Dulceria","Papeleria","Papeleria","Moda","Perfumeria",
            "Hogar", "Electronicos", "Hogar", "Electrodomesticos", "Electrodomesticos", "Electronica"};*/

    private List<String>lproductos = new ArrayList<>();
    private List<String>lcategoria = new ArrayList<>();

    private void actualizarTabla(){
        String productos[] = new String [lproductos.size()];
        lproductos.toArray(productos);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, productos);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long
                    id) {
                txt.setText("Categoria elegido: " + lcategoria.get(position));
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        txt = (TextView) findViewById(R.id.textView);
        lista = (ListView) findViewById(R.id.lista);
        actualizarTabla();

    }


    public void llamaVentana(View w){
        Log.e("Verifica Click","Click");
        Intent i = new Intent(this,ActivityAgregar.class);
        startActivityForResult(i,1234);
    }


    @Override

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
       /* String cad = data.getStringExtra("Producto");
        Toast.makeText(this,cad,Toast.LENGTH_LONG).show();
        String c = data.getStringExtra("Categoria");
        Toast.makeText(this,c,Toast.LENGTH_LONG).show();*/
        lproductos.add(data.getStringExtra("Producto"));
        lcategoria.add(data.getStringExtra("Categoria"));
        actualizarTabla();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater i = getMenuInflater();
        i.inflate(R.menu.menu,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.op_salir:
                Toast.makeText(this,"salir",Toast.LENGTH_SHORT).show();
                finish();
            case  R.id.op_info:
                Toast.makeText(this,"Informacion",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}


