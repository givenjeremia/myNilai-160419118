package id.ac.ubaya.informatika.mynilai_160419118

import java.util.ArrayList

object GlobalData {
    val colorPlayer = arrayOf(
        ColorPlayer(1,"Red"),
        ColorPlayer(2,"Yellow"),
        ColorPlayer(3,"Blue"),
        ColorPlayer(4,"Green"),
        ColorPlayer(5,"Purple")
    )

    var playerName1 = ""
    var playerName2 = ""
    var colorP1 = ""
    var colorP2 = ""
    var gameSession = 0


    val pHistory:ArrayList<History> = arrayListOf()
}