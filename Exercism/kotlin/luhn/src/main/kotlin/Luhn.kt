object Luhn {

    fun isValid(candidate: String): Boolean {
        val condenseStr = candidate.replace(" ", "")

        if (condenseStr.length < 2 || condenseStr.contains(Regex("[^0-9]")) ) return false

        val intArray = condenseStr.map { it.toString().toInt() }.toIntArray()
        val list1 = intArray.slice (intArray.size-2 downTo 0 step 2)
        val list2 = intArray.slice(intArray.size-1 downTo 0 step 2 )
        val sum = list1.map { it * 2 }.sumBy { i -> if (i > 9) i - 9 else i } + list2.sum()

        return (sum % 10 == 0)
    }
}
