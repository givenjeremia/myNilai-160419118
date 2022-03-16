package id.ac.ubaya.informatika.mynilai_160419118

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    //VARIABLE FOR GET INTENT FROM MAIN
    val mNamep1 = "mNamep1"
    val mNamep2 = "mNamep2"
    var mColorp1 = "mColorp1"
    var mColorp2 = "mColorp2"

    //INTENT FROM MAIN TO RESULT
    val rNameP1 = "rNamep1"
    val rNameP2 = "rNamep2"
    var rColorp1 = "rColorp1"
    var rColorp2 = "rColorp2"
    var rWinner = "rWinner"
    var rLose = "rLose"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //GET DATA FROM PLAYER ACTIVITY
        val nameP1Out = intent.getStringExtra(mNamep1)
        val nameP2Out = intent.getStringExtra(mNamep2)
        var colorP1Out = intent.getStringExtra(mColorp1)
        var colorP2Out = intent.getStringExtra(mColorp2)

        txtNameP1.setText(nameP1Out)
        txtNameP2.setText(nameP2Out)

        cardViewP1.setBackgroundColor(Color.parseColor(colorP1Out.toString()))
        cardViewP2.setBackgroundColor(Color.parseColor(colorP2Out.toString()))

        //ALERT BACK BUTTON
    }

    //FUNCTION OF THE GAME
    //GIVE ID IN THE BUTTON
    fun btnClick(view: View){
        val btnSelected = view as Button
        var cellId = 0
        when(btnSelected.id){
            R.id.button1 -> cellId = 1
            R.id.button2 -> cellId = 2
            R.id.button3 -> cellId = 3
            R.id.button4 -> cellId = 4
            R.id.button5 -> cellId = 5
            R.id.button6 -> cellId = 6
            R.id.button7 -> cellId = 7
            R.id.button8 -> cellId = 8
            R.id.button9 -> cellId = 9
        }
        theGame(cellId,btnSelected)
    }
    var activePlayer = 0
    var player1: ArrayList<Int> = arrayListOf<Int>()
    var player2: ArrayList<Int> = arrayListOf<Int>()

    fun theGame(cellId:Int,btnSelected:Button){
        val nameP1 = intent.getStringExtra(mNamep1)
        val nameP2 = intent.getStringExtra(mNamep2)

        if(activePlayer == 1){
            txtTurnP1.text = "$nameP2 Turn"
            txtTurnP2.text = "Your Turn"
            btnSelected.text = "X"
            player1.add(cellId)
            activePlayer = 2
        }
        else{
            txtTurnP1.text = "Your Turn"
            txtTurnP2.text = "$nameP1 Turn"
            btnSelected.text = "O"
            player2.add(cellId)
            activePlayer = 1
        }
        btnSelected.isEnabled = false
        cekWin()
    }

    fun cekWin() {
        var winner = 0

        val intentToResult = Intent(this,ResultActivity::class.java)
        val nameP1 = intent.getStringExtra(mNamep1)
        val nameP2 = intent.getStringExtra(mNamep2)
        var colorP1 = intent.getStringExtra(mColorp1)
        var colorP2 = intent.getStringExtra(mColorp2)

        val date = Calendar.getInstance().time.toString()

        //WINNER X
        //WINNER HORIZONTAL
        if(button1.text == "X" && button2.text == "X" && button3.text == "X"){winner = 1}
        if(button4.text == "X" && button5.text == "X" && button6.text == "X"){winner = 1}
        if(button7.text == "X" && button8.text == "X" && button9.text == "X"){winner = 1}

        //WINNER VERTICAL
        if(button1.text == "X" && button4.text == "X" && button7.text == "X"){winner = 1}
        if(button2.text == "X" && button5.text == "X" && button8.text == "X"){winner = 1}
        if(button3.text == "X" && button6.text == "X" && button9.text == "X"){winner = 1}

        //WINNER DIAGONAL
        if(button1.text == "X" && button5.text == "X" && button9.text == "X"){winner = 1}
        if(button3.text == "X" && button5.text == "X" && button7.text == "X"){winner = 1}

        //WINNER O
        //WINNER HORIZONTAL
        if(button1.text == "O" && button2.text == "O" && button3.text == "O"){winner = 2}
        if(button4.text == "O" && button5.text == "O" && button6.text == "O"){winner = 2}
        if(button7.text == "O" && button8.text == "O" && button9.text == "O"){winner = 2}

        //WINNER VERTICAL
        if(button1.text == "O" && button4.text == "O" && button7.text == "O"){winner = 2}
        if(button2.text == "O" && button5.text == "O" && button8.text == "O"){winner = 2}
        if(button3.text == "O" && button6.text == "O" && button9.text == "O"){winner = 2}

        //WINNER DIAGONAL
        if(button1.text == "O" && button5.text == "O" && button9.text == "O"){winner = 2}
        if(button3.text == "O" && button5.text == "O" && button7.text == "O"){winner = 2}

        //DRAW
        if(winner==0 && player1.size + player2.size ==9){
            val session = GlobalData.gameSession++
            val builder = AlertDialog.Builder(this)
            with(builder){
                setTitle("GAME OVER!")
                setMessage("Game is Draw")
                setPositiveButton("NOOO!"){_,_ ->
                    //MAKE INTENT TO RESULT ACTIVITY
                    intentToResult.putExtra(rNameP1,nameP1.toString())
                    intentToResult.putExtra(rNameP2,nameP2.toString())
                    intentToResult.putExtra(rColorp1,colorP1.toString())
                    intentToResult.putExtra(rColorp2,colorP2.toString())
                    intentToResult.putExtra(rWinner,"DRAW")
                    intentToResult.putExtra(rLose,"DRAW")
                    startActivity(intentToResult)
                }
            }
            builder.show()
            GlobalData.pHistory.add(History(
                session,
                date,
                nameP1.toString(),
                nameP2.toString()
            ))
        }
        //PLAYER 1 WINNER
        if(winner == 1){
            val session = GlobalData.gameSession ++
            val builder = AlertDialog.Builder(this)
            with(builder) {
                setTitle("GAME OVER!")
                setMessage("$nameP1 is Win!")
                setPositiveButton("HORRAY!") { _, _ ->
                    //MAKE INTENT TO RESULT ACTIVITY
                    intentToResult.putExtra(rNameP1,nameP1.toString())
                    intentToResult.putExtra(rNameP2,nameP2.toString())
                    intentToResult.putExtra(rColorp1,colorP1.toString())
                    intentToResult.putExtra(rColorp2,colorP2.toString())
                    intentToResult.putExtra(rWinner,"WIN")
                    intentToResult.putExtra(rLose,"LOSE")
                    startActivity(intentToResult)
                }
                builder.show()
            }
            GlobalData.pHistory.add(History(
                session,
                date,
                nameP1.toString(),
                nameP2.toString()
            ))
        }
        //PLAYER 2 WINNER
        if(winner == 2){
            val session = GlobalData.gameSession ++
            val builder = AlertDialog.Builder(this)
            with(builder){
                setTitle("GAME OVER!")
                setMessage("$nameP2 is Win!")
                setPositiveButton("HORRAY!"){_,_ ->
                    //MAKE INTENT TO RESULT ACTIVITY
                    intentToResult.putExtra(rNameP1,nameP1.toString())
                    intentToResult.putExtra(rNameP2,nameP2.toString())
                    intentToResult.putExtra(rColorp1,colorP1.toString())
                    intentToResult.putExtra(rColorp2,colorP2.toString())
                    intentToResult.putExtra(rWinner,"LOSE")
                    intentToResult.putExtra(rLose,"WIN")
                    startActivity(intentToResult)
                }
            builder.show()
            }
            GlobalData.pHistory.add(History(
                session,
                date,
                nameP1.toString(),
                nameP2.toString()
            ))
        }
    }
}