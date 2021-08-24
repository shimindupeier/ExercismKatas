
object SumOfMultiples {

    fun sum(factors: Set<Int>, limit: Int): Int {
        val allNaturalNumber = ((1 until limit).step(1).toList())
        val filteredList = allNaturalNumber.filter { i -> factors.filter { it != 0 }.any { i % it == 0 } }.toList()

        return filteredList.sum()
    }
}