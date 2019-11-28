package com.example.lista_datos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button agregar, ver;
    Spinner spinner1;
    ArrayList<Alumno> datalum = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GenerarSpinner();
        agregar = findViewById(R.id.button);
        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Agregar(view);
                Limpiar();
            }
        });

        ver = (Button) findViewById(R.id.button3);
        ver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Activity2();
            }
        });
    }

    public void Agregar(View view) {
        String nombre = ((EditText)findViewById(R.id.editText)).getText().toString();
        String apellido = ((EditText)findViewById(R.id.editText2)).getText().toString();
        String numc = ((EditText)findViewById(R.id.editText3)).getText().toString();
        String genero = validar();

        if(nombre.length() != 0){
            if(apellido.length() != 0){
                if(numc.length() != 0){
                    if(numc.length() == 10){
                        if(genero != "mal"){
                            Alumno nuevo = new Alumno(nombre,apellido,numc, genero);
                            datalum.add(nuevo);
                        }
                    }
                    else{
                        Toast.makeText(this, MainActivity.this.getString(R.string.incv), Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(this,  MainActivity.this.getString(R.string.inc), Toast.LENGTH_SHORT).show();
                }
            }
            else{
                Toast.makeText(this,MainActivity.this.getString(R.string.iape) , Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(this,MainActivity.this.getString(R.string.inom) , Toast.LENGTH_SHORT).show();
        }
    }


    public void Limpiar(){
        EditText Nombre = (EditText) findViewById(R.id.editText);
        EditText Apellido = (EditText) findViewById(R.id.editText2);
        EditText Numerocuenta = (EditText) findViewById(R.id.editText3);

        Nombre.setText("");
        Apellido.setText("");
        Numerocuenta.setText("");

    }

    public void Activity2() {
        Intent ni = new Intent(getApplicationContext(), List.class);
        ni.putExtra("datos",datalum);
        startActivity(ni);
    }

    public void GenerarSpinner(){
        spinner1 = (Spinner) findViewById(R.id.spinner);
        String [] opciones = {"Masculino","Femenino"};
        ArrayAdapter <String> adapt = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, opciones);
        spinner1.setAdapter(adapt);
    }

    public String validar(){
        String seleccion = spinner1.getSelectedItem().toString();
        if (seleccion.equals("Masculino"))
            return "Masculino";
        else if(seleccion.equals("Femenino"))
            return "Femenino";
        else
            return "mal";
    }


}
