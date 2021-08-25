class Triangle<out T : Number>(val a: T, val b: T, val c: T) {

    val isEquilateral: Boolean = (a == b && b == c)
    val isIsosceles: Boolean = (a == b || b == c || c == a)
    val isScalene: Boolean = (a != b && b != c)
}
