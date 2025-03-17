package id.ac.ub.papb.recycler1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    TextView tvNim2, tvNama2;
    Button btnTambahItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        tvNim2 = findViewById(R.id.tvNim2);
        tvNama2 = findViewById(R.id.tvNama2);
        btnTambahItem = findViewById(R.id.btnTambahItem);

        // Ambil data dari Intent
        String nim = getIntent().getStringExtra("NIM");
        String nama = getIntent().getStringExtra("NAMA");

        // Tampilkan data
        tvNim2.setText("NIM : " + nim);
        tvNama2.setText("Nama : " + nama);

        // Event klik tombol "Tambah Item"
        btnTambahItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity2.this, MainActivity.class);
                startActivity(intent);
                finish(); // Menutup Activity2 agar tidak menumpuk
            }
        });
    }
}
