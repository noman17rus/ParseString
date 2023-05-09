import kotlin.math.cbrt

fun main(args: Array<String>) {
    val parser = Parser("Павел+79267654352Сергей89267865432игорь+79509875678миХаил89267654657")
    for (i in parser.parse(parser.string)) {
        println("Имя: ${i.key}, телефон: ${i.value}" )
    }
}

