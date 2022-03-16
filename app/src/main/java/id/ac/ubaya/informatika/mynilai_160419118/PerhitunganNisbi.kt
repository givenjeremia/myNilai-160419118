package id.ac.ubaya.informatika.mynilai_160419118

class PerhitunganNisbi {

     fun Nisbi(nts:String , nas:String):String{
        var ntsInt = 0
        var nasInt = 0
        if (nts == ""){
           ntsInt = 0
        }
        else if (nas == ""){
           nasInt = 0
        }
        else{
           ntsInt = nts.toInt()
           nasInt = nas.toInt()
        }
        var nilaiAkhir = (0.4 *ntsInt) + (0.6 * nasInt)
        var nisbi = ""
        if (nilaiAkhir >=81) nisbi = "A"
        else if (nilaiAkhir >= 73 && nilaiAkhir < 81) nisbi = "AB"
        else if (nilaiAkhir >= 73 && nilaiAkhir < 81) nisbi = "AB"
        else if (nilaiAkhir >= 66 && nilaiAkhir < 73) nisbi = "B"
        else if (nilaiAkhir >= 60 && nilaiAkhir < 66) nisbi = "BC"
        else if (nilaiAkhir >= 55 && nilaiAkhir < 60) nisbi = "C"
        else if (nilaiAkhir >= 40 && nilaiAkhir < 55) nisbi = "D"
        else nisbi = "E"
        return  nisbi
    }

}