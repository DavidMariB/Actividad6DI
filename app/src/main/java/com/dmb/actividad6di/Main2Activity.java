package com.dmb.actividad6di;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    ListView lista;
    ArrayList<RecyclerItems> items = new ArrayList<RecyclerItems>();
    MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        RecyclerItems item1 = new RecyclerItems("Invitado");
        RecyclerItems item2 = new RecyclerItems("Organizador");
        RecyclerItems item3 = new RecyclerItems("Revisor");
        RecyclerItems item4 = new RecyclerItems("Autor");

        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);

        lista = (ListView) findViewById(R.id.listView);
        adapter = new MyAdapter(this, items);
        lista.setAdapter(adapter);
        lista.setLongClickable(true);

        onItemClick();
    }

    private void onItemClick(){
        lista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            public boolean onItemLongClick(AdapterView<?> arg0, View v, int index, long arg3) {
                RecyclerItems item = adapter.getItem(index);
                Toast.makeText(Main2Activity.this, "Se ha seleccionado: "+item.getTitle(), Toast.LENGTH_SHORT).show();
                return true;
            }
        });

    }
}
