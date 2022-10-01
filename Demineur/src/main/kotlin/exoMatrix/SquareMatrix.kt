package exoMatrix

open class SquareMatrix<T>(size: Int) : Matrix<T>(size, size) {
    override fun toString(): String {
        return matrix.joinToString(
            prefix = "", postfix = "", separator = """
            |
            """.trimMargin()
        ) { it -> it.joinToString(prefix = "[", postfix = "]\n") { it?.toString() ?: "-" } }
    }
}
