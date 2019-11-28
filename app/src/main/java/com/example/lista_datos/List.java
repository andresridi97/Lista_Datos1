package com.example.lista_datos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

public class List extends AppCompatActivity {
    ListView listv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listv = (ListView) findViewById(R.id.list);
        ArrayList<Alumno> datalum = (ArrayList<Alumno>) getIntent().getSerializableExtra("datos");
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.list_item_andres, datalum);
        listv.setAdapter(arrayAdapter);

        listv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String texto = "ID: " + position;
                Toast.makeText(getApplicationContext(), texto, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
