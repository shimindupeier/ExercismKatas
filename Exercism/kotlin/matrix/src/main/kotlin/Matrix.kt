class Matrix(private val matrixAsString: String) {

    fun column(colNr: Int): List<Int> = matrixAsString
        .split("\n")
        .map { i -> i.split(" ").filter { j -> j.isNotEmpty() } }
        .map { i -> i[colNr-1] }
        .map { it.toInt() }


    fun row(rowNr: Int): List<Int> = matrixAsString
        .split("\n")
        .map { i -> i.split(" ").filter { j -> j.isNotEmpty() } }
        .elementAt(rowNr-1)
        .map { it.toInt() }
}