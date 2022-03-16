
package id.ac.ubaya.informatika.mynilai_160419118

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.util.Log
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_edit.*
import kotlinx.android.synthetic.main.activity_edit.view.*
import kotlinx.android.synthetic.main.activity_nilai_card.view.*

class NilaiAdapter(): RecyclerView.Adapter<NilaiAdapter.NilaiViewHolder>() {
    class  NilaiViewHolder(val v: View):RecyclerView.ViewHolder(v)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NilaiViewHolder {
        val inflater =  LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.activity_nilai_card,parent,false)
        return  NilaiViewHolder(view)
    }

    override fun onBindViewHolder(holder: NilaiViewHolder, position: Int  ) {
        val nilai = Global.nilai[position]
        with(holder.v){
            textViewNamaDanKodeMataKuliah.text = "${nilai.namaSingkatMataKuliah} (${nilai.kodeMatakuliah})"
            var nisbiTampil = nilai.nisbi
            Log.v("aa",nisbiTampil);
            //Check Button
            if(nilai.nas == "" && nilai.nts == "" ) {
                checkBoxNTS.isChecked = false
                checkBoxNAS.isChecked = false
            }
            else if (nilai.nas == "") checkBoxNTS.isChecked = true
            else if (nilai.nts == "") checkBoxNAS.isChecked = true
            else{
                checkBoxNTS.isChecked = true
                checkBoxNAS.isChecked = true
                textViewNisbi.text = nisbiTampil
            }

            //Mengubah Warna Card View Berdasarkan NISBI
            if (nisbiTampil == "A"){
                cardView.setCardBackgroundColor(Color.parseColor("#5DADE2"));
            }
            else if(nisbiTampil == "AB"){
                cardView.setCardBackgroundColor(Color.parseColor("#2CC7CC"));
            }
            else if(nisbiTampil == "B"){
                cardView.setCardBackgroundColor(Color.parseColor("#58D68D"));
            }
            else if(nisbiTampil == "BC"){
                cardView.setCardBackgroundColor(Color.parseColor("#52BE80"));
            }
            else if (nisbiTampil == "C"){
                cardView.setCardBackgroundColor(Color.parseColor("#F7DC6F"));
            }
            else if(nisbiTampil == "D"){
                cardView.setCardBackgroundColor(Color.parseColor("#F0B27A"));
            }
            else {
                cardView.setCardBackgroundColor(Color.parseColor("#F1948A"));
            }
            //Button
//            buttonEdit.setOnClickListener(){
//                val intent = Intent(context,EditActivity::class.java)
//                intent.putExtra(Global.EXTRA_KodeMatkull,nilai.kodeMatakuliah)
//                intent.putExtra(Global.EXTRA_NamaMatkull,nilai.namaMataKuliah)
//                intent.putExtra(Global.EXTRA_NamaSingkatMatkull, nilai.namaSingkatMataKuliah)
//                intent.putExtra(Global.EXTRA_NTS,nilai.nts)
//                intent.putExtra(Global.EXTRA_NAS, nilai.nas)
//                intent.putExtra(Global.EXTRA_Position , position)
//                context.startActivity(intent)
//            }
            buttonDelete.setOnClickListener(){
                AlertDialog.Builder(context).apply {
                    setMessage("Hapus Mata Kuliah ${nilai.namaMataKuliah} ?")
                    setPositiveButton("Hapus") { _, _->
                        //Hapus Dari ArrayList
                        Global.nilai.removeAt(position)
                        //Update Data Di Recyler View
                        this@NilaiAdapter.notifyDataSetChanged()
                        Toast.makeText(context, "Mata Kuliah ${nilai.namaMataKuliah} Berhasil Di Hapus", Toast.LENGTH_SHORT).show()
                    }
                    setNegativeButton("Batal",null)
                    create().show()
                }


            }

        }

    }

    override fun getItemCount() = Global.nilai.size

}