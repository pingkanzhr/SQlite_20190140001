package com.example.sqlitea;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.example.sqlitea.adapter.TemanAdapter;
import com.example.sqlitea.database.DBController;
import com.example.sqlitea.database.Teman;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    Button btnsimpan;

    private RecyclerView recyclerView;
    private TemanAdapter adapter;
    private ArrayList<Teman> temanArrayList;
    DBController controller = new DBController(this);
    String id,nm,tlp;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        fab = findViewById(R.id.floatingBtn);
        BacaData();
        adapter = new TemanAdapter(temanArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,TemanBaru.class);
                startActivity(intent);
            }
        });
    }

    private void BacaData() {
        ArrayList<HashMap<String,String >> daftarTeman = controller.getAllTeman();
        temanArrayList = new ArrayList<>();
        //Memindah dari hasil query kedalam Teman
        for (int i=0;i<daftarTeman.size();i++){
            Teman teman = new Teman();
            teman.setId(daftarTeman.get(i).get("id"));
            teman.setNama(daftarTeman.get(i).get("nama"));
            teman.setTelpon(daftarTeman.get(i).get("telpon"));
            //Pindah dari teman.java ke dalam Arraylist teman di adapter
            temanArrayList.add(teman);
        }
    }
}