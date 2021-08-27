class Series(input: String, span: Int) {
    // TODO: Implement proper constructor
    init {
        if (input.isEmpty() && span == 0) getLargestProduct(0)
        else if ((input.length < span)
            || input.isEmpty()
            || input.contains(Regex("[^0-9]"))
            || span < 0)
            throw IllegalArgumentException()
    }

    private val inputLongList = input.map { it.toString().toLong() }.toList()

    fun getLargestProduct(span: Int): Long? {
        if (span == 0) return 1

        val lspList = inputLongList.windowed(span, 1).toList()
            .map { i -> i.reduce { acc, i -> acc * i } }
        return lspList.max()
    }
}
