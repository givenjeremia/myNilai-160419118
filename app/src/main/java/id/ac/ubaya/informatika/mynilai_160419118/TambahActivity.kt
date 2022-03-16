package id.ac.ubaya.informatika.mynilai_160419118

import android.app.AlertDialog
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_tambah.*

class TambahActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah)
        var cekKodeMatkul = false
        var cekNamaSingkat = false
        var cekNilai= false
        var nts = ""
        var nas = ""
        buttonTambahMatkul.setOnClickListener(){
            val kodeMatkull = editTextKodeMataKuliah.text.toString()
            val namaSingkatMatkull = editTextNamaSingkat.text.toString()
            val namaMatkul = editTextNamaMataKuliah.text.toString()
            //Cek Bila User Tidak Menginputkan Salah Satu Dari NTS / NAS
            when {
                editTextNAS.text.toString().isEmpty() && editTextNTS.text.toString().isEmpty() -> {
                    nts = ""
                    nas = ""
                }
                editTextNTS.text.toString().isEmpty() -> {
                    nts = ""
                    nas = editTextNAS.text.toString()
                }
                editTextNAS.text.toString().isEmpty() -> {
                    nts = editTextNTS.text.toString()
                    nas = ""
                }
                else -> {
                    nts = editTextNTS.text.toString()
                    nas = editTextNAS.text.toString()
                }
            }
            //Cek Agar Yang Di Inputkan Tidak Kosong
            if (kodeMatkull.isNotEmpty() && namaMatkul.isNotEmpty() && namaSingkatMatkull.isNotEmpty() ){
                //Melakukan Pengecekan Kode Mata Kuliah
                if (kodeMatkull.trim().length != 8){
                    cekKodeMatkul = false
                    AlertDialog.Builder(this).apply {
                        setMessage("Kode Matkul Harus 8 Karakter")
                        setPositiveButton("Oke" ,null)
                        create().show()
                    }
                }
                else cekKodeMatkul = true
                //Melakukan Pengecekan Nama Singkat
                if (namaSingkatMatkull.contains(" ")){
                    cekNamaSingkat = false
                    AlertDialog.Builder(this).apply {
                        setMessage("Nama Singkat Tidak Boleh Ada Spasi")
                        setPositiveButton("Oke" ,null)
                        create().show()
                    }

                }
                else cekNamaSingkat = true
                //Melakukan Pengecekan NTS DAN NAS
                var ntsCek = 0
                var nasCek = 0
                if (nts ==""){
                    var ntsCek = 0
                }
                else if (nas == ""){
                    var ntsCek = 0
                }
                else{
                    ntsCek = nts.toInt()
                    nasCek = nas.toInt()
                }
                if (ntsCek >= 0 && ntsCek <= 100 && nasCek >=0 && nasCek <=100) cekNilai = true
                else{
                    cekNilai= false
                    AlertDialog.Builder(this).apply {
                        setMessage("NTS/NAS hanya boleh di antara 0 hingga 100")
                        setPositiveButton("Oke" ,null)
                        create().show()
                    }
                }
            }
            else{
                AlertDialog.Builder(this).apply {
                    setMessage("Ada Yang Belum Di Isi Nih")
                    setPositiveButton("Oke" ,null)
                    create().show()
                }
            }

            //Perhitungan Nilai Akhir
            //Pengecekan Nisbi
            if (cekKodeMatkul && cekNamaSingkat && cekNilai){
                val nisbi = PerhitunganNisbi().Nisbi(nts,nas)
                Global.nilai.add(Nilai(kodeMatkull,namaMatkul,namaSingkatMatkull,nts,nas, nisbi))
                Global.NilaiNumber++
                AlertDialog.Builder(this).apply {
                    setMessage("Nilai Berhasil Di Tambahkan")
                    setPositiveButton("Ok") { _, _->
//                        startActivity(Intent(this@TambahActivity , MainActivity::class.java))
                    }
                    create().show()
                }

            }

        }
    }
}