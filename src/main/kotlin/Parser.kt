class Parser(val string: String) {


    private fun addPlus(string: String): String {
        val list = string.toMutableList()
        if (list.first() == '7') {
            list.add(0, '+')
        } else if (list.first() == '8') {
            list.add(0, '+')
            list[1] = '7'
        }
        return list.toCharArray().concatToString()
    }

    private fun takeNumbers(string: String): List<String> {
        val phoneNumbersList = mutableListOf<String>()
        val numbers = string.filter { it.isDigit() }
        var x = 0
        for (i in 0..numbers.length - 1) {
            val number = addPlus(numbers.substring(x, x + 11))
            x += 11
            phoneNumbersList.add(number)
            if (x >= numbers.length) break
        }
        return phoneNumbersList.toList()
    }

    private fun takeNames(string: String): List<String> {
        val splitList = string.split('9').toMutableList()
        val names = mutableListOf<String>()
        for (i in 0..splitList.size - 1) {
            splitList[i] = splitList[i].filter { it.isLetter() }.toLowerCase().capitalize()
            if (splitList[i] != "") {
                names.add(splitList[i])
            }
        }
        return names.toList()
    }

    fun parse(string: String): Map<String, String> {
        val phoneNumbers = takeNumbers(string)
        val names = takeNames(string)
        val phonesAndNames = mutableMapOf<String, String>()
        for (i in 0..names.size-1) {
            phonesAndNames.put(names[i], phoneNumbers[i])
        }
        return phonesAndNames
    }
}


