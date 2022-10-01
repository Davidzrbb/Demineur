package exoMatrix

abstract class Matrix<T>(column: Int, line: Int) {

    val matrix: List<MutableList<T?>> = List(line) { MutableList(column) { null } }

    operator fun set(line: Int, column: Int, value: T) {
        matrix[line][column] = value
    }

    fun isSquare(): Boolean {
        return matrix.size == matrix[0].size
    }

    override fun toString(): String {
        return matrix.joinToString(
            prefix = "", postfix = "", separator = """
            |
            """.trimMargin()
        ) { it -> it.joinToString(prefix = "[", postfix = "]\n") { it?.toString() ?: "-" } }
    }
}