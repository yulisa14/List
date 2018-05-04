package com.example.fundacioncuervo.list;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class ActivityAgregar extends AppCompatActivity {

    private EditText nombre;
    private Spinner mySpinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);


        String categoria[] = {"Electronica","Hogar","Papeleria","Moda","Bebes",
                "Dulceria", "Farmacia", "Perfumeria", "Carnes", "Deportes"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,categoria);

        nombre = (EditText) findViewById(R.id.nombre);
        mySpinner = (Spinner) findViewById(R.id.mySpinner);
        mySpinner.setAdapter(adapter);


    }
    public  void  guardar(View w){
        Intent i = new Intent();
        i.putExtra("Producto",nombre.getText().toString());
        i.putExtra("Categoria",mySpinner.getSelectedItem().toString());
        setResult(RESULT_OK,i);
        finish();
    }
}

