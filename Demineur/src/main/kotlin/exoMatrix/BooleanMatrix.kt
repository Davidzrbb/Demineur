package exoMatrix

class BooleanMatrix(column: Int, line: Int) {
    private val matrix: List<MutableList<Boolean?>> = List(line) { MutableList(column) { null } }

    operator fun set(line: Int, column: Int, value: Boolean) {
        matrix[line][column] = value
    }

    override fun toString(): String {
        return matrix.joinToString(
            prefix = "", postfix = "", separator = """
            |
            """.trimMargin()
        ) { it -> it.joinToString(prefix = "[", postfix = "]\n") { it?.toString() ?: "-" } }
    }
}