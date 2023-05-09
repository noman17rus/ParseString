import kotlin.math.cbrt

fun main(args: Array<String>) {
    val s = "Павел+79267654352Сергей89267865432игорь+79509875678миХаил89267654657"
    var numbers = s.filter { it.isDigit() }
    val symbols = s.filter { it.isLetter() }
    val phoneNumbersList = mutableListOf<String>()
    var x = 0
    for (i in 0..numbers.length) {
        val xyz = addPlus(numbers.substring(x, x + 11))
        x += 11
        phoneNumbersList.add(xyz)
        if (x >= numbers.length) break
    }


    val z = s.split('9').toMutableList()
    val names = mutableListOf<String>()
    for (i in 0..z.size-1) {
        z[i] = z[i].filter { it.isLetter() }.toLowerCase().capitalize()
        if (z[i] != "") {
            names.add(z[i])
        }
    }

    val mapNamesAndNumbers = mutableMapOf<String, String>()
    for (i in 0..phoneNumbersList.size-1) {
        mapNamesAndNumbers.put(names[i], phoneNumbersList[i])
    }

    for (i in mapNamesAndNumbers) {
        println("Имя: ${i.key}, телефон: ${i.value}")
    }



}

fun addPlus(s: String): String {
    var list = s.toMutableList()
    if (list.first() == '7') {
        list.add(0, '+')
    } else if (list.first() == '8') {
        list.add(0, '+')
        list[1] = '7'
    }
    val result = list.toCharArray().concatToString()
    return result
}
