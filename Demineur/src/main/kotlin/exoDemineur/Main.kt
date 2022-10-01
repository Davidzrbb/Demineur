import exoDemineur.BooleanMatrix
import exoDemineur.MinesweperBoard

fun main() {
    val matrix = MinesweperBoard(5)
    matrix[0, 1] = true
    matrix[0, 3] = true
    matrix[1, 2] = true
    matrix[2, 2] = true
    println(matrix.toString())

}