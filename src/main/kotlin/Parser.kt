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
        var count = 0
        for (i in numbers.indices) {
            val number = addPlus(numbers.substring(count, count + 11))
            count += 11
            phoneNumbersList.add(number)
            if (count >= numbers.length) break
        }
        return phoneNumbersList.toList()
    }

    private fun takeNames(string: String): List<String> {
        val names = mutableListOf<String>()
        val splitList = string.split('9')
        for (i in splitList.indices) {
            if (splitList[i].filter { it.isLetter() } != "") {
                names.add(splitList[i].filter { it.isLetter() }.toLowerCase().capitalize())
            }
        }
        return names.toList()
    }

    fun parse(string: String): Map<String, String> {
        val phoneNumbers = takeNumbers(string)
        val names = takeNames(string)
        val phonesAndNames = mutableMapOf<String, String>()
        for (i in phoneNumbers.indices) {
            phonesAndNames[names[i]] = phoneNumbers[i]
        }
        return phonesAndNames
    }
}


