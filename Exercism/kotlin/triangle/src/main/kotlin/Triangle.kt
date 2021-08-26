class Triangle<out T : Number>(val a: T, val b: T, val c: T) {

    init {
        if (a == 0 || b == 0 || c == 0) throw IllegalArgumentException()
        if (a.toDouble() + b.toDouble() < c.toDouble()
            || b.toDouble() + c.toDouble() < a.toDouble()
            || a.toDouble() + c.toDouble() < b.toDouble()) throw IllegalArgumentException()
        if (a.toDouble() + b.toDouble() == c.toDouble()
            || b.toDouble() + c.toDouble() == a.toDouble()
            || a.toDouble() + c.toDouble() == b.toDouble()) throw IllegalArgumentException()
    }

    val isEquilateral: Boolean = (a == b && b == c)
    val isIsosceles: Boolean = (a == b || b == c || c == a)
    val isScalene: Boolean = (a != b && b != c)
}