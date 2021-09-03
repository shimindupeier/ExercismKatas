ut:String) {
    //TODO: Implement proper constructor
    init{
        if (input.contains(Regex("[^0-9]")))
            throw IllegalArgumentException()
    }
    private val inputLongList =input.map { it.toString().toLong() }.toList()
    fun getLargestProduct(span:Int): Long{
        if (span == 0) return 1
        if (span < 0
            || (inputLongList.size < span)) throw IllegalArgumentException()
        val lspList =inputLongList.windowed(span, 1).toList()
            .map { it.reduce { acc, i ->acc *i } }
        return lspList.max()!!
    }
}
