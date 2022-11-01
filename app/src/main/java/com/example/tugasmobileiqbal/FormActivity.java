package com.example.tugasmobileiqbal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FormActivity extends AppCompatActivity {

    Button button;
    EditText Edtnama, Edtnohp, Edtalamat, Edtpesan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        Edtnama = findViewById(R.id.editnama);
        Edtnohp = findViewById(R.id.editphone);
        Edtalamat = findViewById(R.id.editalamat);
        Edtpesan = findViewById(R.id.editpesan);

        button = findViewById(R.id.formbtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pesan1 = Edtnama.getText().toString();
                String pesan2 = Edtnohp.getText().toString();
                String pesan3 = Edtalamat.getText().toString();
                String pesan4 = Edtpesan.getText().toString();

                String semuapesan = "Nama Customer: " + pesan1 + "\n" + "Ho Hp: " + pesan2 + "\n" + "Alamat: " + pesan3 + "\n" + "Detail Pesanan: " + pesan4;

                Intent kirimWA = new Intent(Intent.ACTION_SEND);
                kirimWA.setType("text/plain");
                kirimWA.putExtra(Intent.EXTRA_TEXT, semuapesan);
                kirimWA.putExtra("jid", "6285768628231" + "@s.whatsapp.net");
                kirimWA.setPackage("com.whatsapp");

                startActivity(kirimWA);
            }
        });

    }
}