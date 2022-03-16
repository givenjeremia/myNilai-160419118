package id.ac.ubaya.informatika.mynilai_160419118

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.graphics.toColorInt
import kotlinx.android.synthetic.main.activity_players.*
import java.nio.file.attribute.AclEntry

class PlayersActivity : AppCompatActivity() {

    //INTENS
    val mNameP1 = "mNamep1"
    val mNameP2 = "mNamep2"
    var mColorp1 = "mColorp1"
    var mColorp2 = "mColorp2"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_players)

        //SET ADAPTER FOR COLOR PLAYER IN COMBOBOX
        val adapter = ArrayAdapter(this,R.layout.myspinner_layout,GlobalData.colorPlayer)
        adapter.setDropDownViewResource(R.layout.my_spinner_item_layout)

        spinnerColorPlayer1.adapter = adapter
        spinnerColorPlayer2.adapter = adapter

        val nameP1 = txtNamePlayer1.text
        val nameP2 = txtNamePlayer2.text

        //SET BUTTON PLAY AND ALERT
        buttonPlay.setOnClickListener {
            var clrP1 = spinnerColorPlayer1.selectedItemPosition
            var colorP1 = GlobalData.colorPlayer[clrP1].color
            var clrP2 = spinnerColorPlayer2.selectedItemPosition
            var colorP2 = GlobalData.colorPlayer[clrP2].color

            if(colorP1== colorP2){
                val builder = AlertDialog.Builder(this)
                with(builder){
                    setTitle("ALERT!")
                    setMessage("Player Color Can't be the Same")
                    setPositiveButton("Okee",null)
                }
                builder.show()
            }
            else{
                //MAKE INTENT TO MAIN ACTIVITY
                val intentToMain = Intent(this,MainActivity::class.java)
                intentToMain.putExtra(mNameP1,nameP1.toString())
                intentToMain.putExtra(mNameP2,nameP2.toString())
                intentToMain.putExtra(mColorp1,colorP1.toString())
                intentToMain.putExtra(mColorp2,colorP2.toString())
                startActivity(intentToMain)

            }

        }
    }
}