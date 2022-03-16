package id.ac.ubaya.informatika.mynilai_160419118

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_history_card.view.*
import java.util.*

class HistoryAdapter(): RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {
    class HistoryViewHolder(val view: View):RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.activity_history_card,parent,false)
        return HistoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        val history = GlobalData.pHistory[position]
        with(holder.view){
            txtGameSession.text = history.session.toString()
            Log.v("cek","TEST ${history.session}")
            txtDate.text = history.date
            txtPlayer1.setText("ahdahda")
            txtPlayer1.setText("dadaaa")
        }
    }

    override fun getItemCount()= GlobalData.pHistory.size
}