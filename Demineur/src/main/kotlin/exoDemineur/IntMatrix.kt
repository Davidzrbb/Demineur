package exoDemineur

class IntMatrix(column: Int, line: Int) {

    private val matrix: List<MutableList<Int?>> = List(line) { MutableList(column) { null } }

    private operator fun get(i: Int, j: Int): Int? {
        return matrix[i][j]
    }

    operator fun set(line: Int, column: Int, value: Int) {
        matrix[line][column] = value
    }

    operator fun times(other: IntMatrix): IntMatrix {
        val result = IntMatrix(matrix.size, other.matrix[0].size)
        for (i in 0 until matrix[0].size) {
            for (j in 0 until other.matrix[0].size) {
                for (k in 0 until matrix[0].size) {
                    result[i, j] = (result[i, j] ?: 0) + (matrix[i][k] ?: 0) * (other.matrix[k][j] ?: 0)
                }
            }
        }
        return result
    }

    operator fun timesAssign(other: IntMatrix) {
        for (i in 0 until matrix[0].size) {
            for (j in 0 until other.matrix[0].size) {
                for (k in 0 until matrix[0].size) {
                    this[i, j] = (this[i, j] ?: 0) + (matrix[i][k] ?: 0) * (other.matrix[k][j] ?: 0)
                }
            }
        }
    }

    override fun toString(): String {
        return matrix.joinToString(
            prefix = "", postfix = "", separator = """
            |
            """.trimMargin()
        ) { it -> it.joinToString(prefix = "[", postfix = "]\n") { it?.toString() ?: "-" } }
    }
}