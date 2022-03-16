package id.ac.ubaya.informatika.mynilai_160419118

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.cardViewP1
import kotlinx.android.synthetic.main.activity_main.cardViewP2
import kotlinx.android.synthetic.main.activity_main.txtNameP1
import kotlinx.android.synthetic.main.activity_main.txtNameP2
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    //VARIABLE FOR INTENT TO MAIN ACTIVITY AFTER btnPlayAgain
    val mNamep1 = "mNamep1"
    val mNamep2 = "mNamep2"
    var mColorp1 = "mColorp1"
    var mColorp2 = "mColorp2"

    //VARIABLE FOR INTENT FROM MAIN ACTIVITY
    val rNameP1 = "rNamep1"
    val rNameP2 = "rNamep2"
    var rColorp1 = "rColorp1"
    var rColorp2 = "rColorp2"
    val rWinner = "rWinner"
    val rlose = "rLose"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        //GET DATA FROM MAIN ACTIVITY
        val rNameP1Out = intent.getStringExtra(rNameP1)
        val rNameP2Out = intent.getStringExtra(rNameP2)
        var rColorP1Out = intent.getStringExtra(rColorp1)
        var rColorP2Out = intent.getStringExtra(rColorp2)
        val rWinnerOut = intent.getStringExtra(rWinner)
        val rLoseOut = intent.getStringExtra(rlose)

        if(rWinnerOut == "DRAW"){
            txtNameResultP1.setText(rNameP1Out)
            txtNameResultP2.setText(rNameP2Out)
            txtTurnResultP1.setText("DRAW")
            txtTurnResultP2.setText("DRAW")
        }
        else{
            txtNameResultP1.setText(rNameP1Out)
            txtNameResultP2.setText(rNameP2Out)
            txtTurnResultP1.setText("$rNameP1Out $rWinnerOut")
            txtTurnResultP2.setText("$rNameP2Out $rLoseOut")
        }

        cardViewP1.setBackgroundColor(Color.parseColor(rColorP1Out.toString()))
        cardViewP2.setBackgroundColor(Color.parseColor(rColorP2Out.toString()))

        btnPlayAgain.setOnClickListener {
            setContentView(R.layout.activity_main)
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra(mNamep1,rNameP1Out.toString())
            intent.putExtra(mNamep2,rNameP2Out.toString())
            intent.putExtra(mColorp1,rColorP1Out.toString())
            intent.putExtra(mColorp2,rColorP2Out.toString())
            startActivity(intent)
        }
        btnHistory.setOnClickListener {
//            setContentView(R.layout.activity_history_list)
            startActivity(Intent(this,HistoryListActivity::class.java))
        }
    }
}