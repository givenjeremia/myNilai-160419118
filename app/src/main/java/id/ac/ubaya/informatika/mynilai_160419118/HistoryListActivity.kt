package id.ac.ubaya.informatika.mynilai_160419118

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_history_list.*

class HistoryListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //SETUP THE RECYLERVIEW USING ADAPTER
        val linierLayoutManager = LinearLayoutManager(this)
        with(recyclerView){
            this.layoutManager = linierLayoutManager
            setHasFixedSize(true)
            this.adapter = HistoryAdapter()
        }
    }
}