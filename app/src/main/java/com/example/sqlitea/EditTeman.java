package com.example.sqlitea;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sqlitea.database.DBController;
import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;

public class EditTeman extends AppCompatActivity {
    private TextInputEditText tNama2, tTelp2,tId;
    private Button edtBtn;
    String nama,telp,id;
    DBController controller = new DBController(this);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_data);

        tNama2 = (TextInputEditText) findViewById(R.id.editNama);
        tTelp2 = (TextInputEditText) findViewById(R.id.editTelpon);
        edtBtn = (Button) findViewById(R.id.buttonEdit);

        id = getIntent().getStringExtra("id");
        nama = getIntent().getStringExtra("nama");
        telp = getIntent().getStringExtra("telpon");

        setTitle("Edit Data");
        tNama2.setText(nama);
        tTelp2.setText(telp);


        edtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tNama2.getText().toString().equals("") || tTelp2.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Data Belum Terisi Semua !", Toast.LENGTH_SHORT).show();
                } else {
                    nama = tNama2.getText().toString();
                    telp = tTelp2.getText().toString();
                    HashMap<String, String> qvalues = new HashMap<>();
                    qvalues.put("id", id);
                    qvalues.put("nama", nama);
                    qvalues.put("telp", telp);

                    controller.editData(qvalues);
                    callHome();
                }
            }
        });
    }
    private void callHome() {
        Intent intent = new Intent(EditTeman.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
