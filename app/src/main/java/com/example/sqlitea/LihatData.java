package com.example.sqlitea;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LihatData extends AppCompatActivity {
    TextView tNama2, tTelp2;
    String nama, id, telp;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_data);

        Bundle bundle = getIntent().getExtras();
        nama = bundle.getString("b");
        setContentView(R.layout.detail_data);
        tNama2 = findViewById(R.id.tvNamaKontak);
        tTelp2 = findViewById(R.id.tvNomorTelepon);

        id = getIntent().getStringExtra("id");
        nama = getIntent().getStringExtra("nama");
        telp = getIntent().getStringExtra("telpon");

        setTitle("Edit Data");
        tNama2.setText(nama);
        tTelp2.setText(telp);
    }
}
