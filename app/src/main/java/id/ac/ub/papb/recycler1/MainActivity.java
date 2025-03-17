package id.ac.ub.papb.recycler1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvMahasiswa;
    EditText etNim, etNama;
    Button btnSimpan;
    ArrayList<Mahasiswa> data;
    MahasiswaAdapter adapter;

    public static String TAG = "RV1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inisialisasi View
        rvMahasiswa = findViewById(R.id.rv1);
        etNim = findViewById(R.id.etNim);
        etNama = findViewById(R.id.etNama);
        btnSimpan = findViewById(R.id.btnSimpan);

        // Inisialisasi Data
        data = new ArrayList<>();
        adapter = new MahasiswaAdapter(this, data);

        rvMahasiswa.setAdapter(adapter);
        rvMahasiswa.setLayoutManager(new LinearLayoutManager(this));

        // Event Listener untuk tombol Simpan
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simpanData();
            }
        });
    }

    public void simpanData() {
        String nim = etNim.getText().toString().trim();
        String nama = etNama.getText().toString().trim();

        if (nim.isEmpty() || nama.isEmpty()) {
            Toast.makeText(this, "NIM dan Nama harus diisi!", Toast.LENGTH_SHORT).show();
            return;
        }

        // Tambahkan data ke dalam ArrayList
        Mahasiswa mhs = new Mahasiswa(nim, nama);
        data.add(mhs);

        // Update RecyclerView
        adapter.notifyDataSetChanged();

        // Kosongkan input
        etNim.setText("");
        etNama.setText("");

        // Tampilkan log untuk debugging
        Log.d(TAG, "Data tersimpan: " + nim + " - " + nama);

        // Pindah ke Activity2 sambil mengirim data
        Intent intent = new Intent(MainActivity.this, Activity2.class);
        intent.putExtra("NIM", nim);
        intent.putExtra("NAMA", nama);
        startActivity(intent);
    }
}
