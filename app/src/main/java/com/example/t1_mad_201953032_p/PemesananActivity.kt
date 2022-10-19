package com.example.t1_mad_201953032_p

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.text.DecimalFormat
import java.text.NumberFormat

class PemesananActivity : AppCompatActivity() {
    private lateinit var etNomor: EditText
    private lateinit var etNama: EditText
    private lateinit var etJumlah: EditText
    private lateinit var rbMakanan: RadioButton
    private lateinit var rbMinuman: RadioButton
    private lateinit var tvHargaRupiah: TextView
    private lateinit var tvTotalRupiah: TextView
    private lateinit var cbCutlery: CheckBox
    private lateinit var btnPesan: Button
    private var nomor: String = ""
    private var nama: String = ""
    private var jenis: String = ""
    private var cutlery: String = ""
    private var jumlah: Int = 0
    private var harga: Int = 0
    private var total: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pemesanan)

        etNomor = findViewById(R.id.etNomor)
        etNama = findViewById(R.id.etNama)
        etJumlah = findViewById(R.id.etJumlah)
        rbMakanan = findViewById(R.id.rbMakanan)
        rbMinuman = findViewById(R.id.rbMinuman)
        tvHargaRupiah = findViewById(R.id.tvHargaRupiah)
        tvTotalRupiah = findViewById(R.id.tvTotalRupiah)
        cbCutlery = findViewById(R.id.cbCutlery)
        btnPesan = findViewById(R.id.btnPesan)

        rbMakanan.setOnClickListener {
            harga = 6000
            jenis = rbMakanan.text.toString()
            tvHargaRupiah.setText("Rp 6000");
            hitungTotal()
        }

        rbMinuman.setOnClickListener {
            harga = 3000
            jenis = rbMinuman.text.toString()
            tvHargaRupiah.setText("Rp 3000");
            hitungTotal()
        }

        etJumlah.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) { }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                jumlah = etJumlah.text.toString().toInt()
                hitungTotal()
            }

            override fun afterTextChanged(p0: Editable?) { }
        })

        cbCutlery.setOnClickListener {
            cutlery = ""
            if(cbCutlery.isChecked) {
                cutlery = cbCutlery.text.toString()
            }
        }

        btnPesan.setOnClickListener {
            nomor = etNomor.text.toString()
            nama = etNama.text.toString()

            Toast.makeText(this@PemesananActivity, "Nomor Pesanan : " + nomor + "\n" +
                    "Nama Pemesan : " + nama + "\n" +
                    "Jenis Pesanan : " + jenis + "\n" +
                    "Harga @ : Rp " + harga.toString() + "\n" +
                    "Jumlah Pesanan : " + jumlah.toString() + "\n" +
                    "Total Bayar : Rp " + total.toString() + "\n" + cutlery, Toast.LENGTH_LONG)
                .show()
        }
    }

    fun hitungTotal() {
        total = harga * jumlah
        tvTotalRupiah.setText("Rp " + total.toString())
    }
}