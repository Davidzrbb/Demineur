package exoMatrix

fun main(args: Array<String>) {

    val matrixInt = IntMatrix(5, 5)
    matrixInt[0, 0] = 1

    val matrixInt2 = IntMatrix(5, 5)
    matrixInt2[0, 0] = 1

    val matrixInt3 = matrixInt * matrixInt2
    println(matrixInt3.toString())

    matrixInt3 *= matrixInt2
    println(matrixInt3.toString())

}