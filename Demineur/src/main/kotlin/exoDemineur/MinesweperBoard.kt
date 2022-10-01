package exoDemineur

open class MinesweperBoard(private val size: Int) : BooleanMatrix(size, size) {

    private fun getBoardHints(): IntMatrix {
        val bombes = IntMatrix(size, size)
        //on parcour la matrice
        for (line in 0 until size) {
            for (column in 0 until size) {
                //on verifie que la case n'est pas une bombe
                if (matrix[line][column] != true) {
                    //on stock une variable qui va compter le nombre de bombes autour de la case
                    var bombe = 0
                    //on parcour les cases à coté de la case
                    for (parallele in -1..1) {
                        //on parcour les cases au dessus de la case
                        for (perpendiculaire in -1..1) {
                            //on vérifie que la ligne n'est pas hors de la matrice
                            if (line + parallele >= 0 && line + parallele < size) {
                                //on vérifie que la colonne n'est pas hors de la matrice
                                if (column + perpendiculaire >= 0 && column + perpendiculaire < size) {
                                    //on vérifie que la case n'est pas la case actuelle
                                    if (parallele != 0 || perpendiculaire != 0) {
                                        //incrementation du nombre de bombes
                                        if (matrix[line + parallele][column + perpendiculaire] == true) {
                                            bombe++
                                        }
                                    }
                                }
                            }
                        }
                    }
                    //on stock le nombre de bombes dans la matrice
                    bombes[line, column] = bombe
                }
            }
        }
        //on remplace les bombes par des -1 pour les différencier et les remplacer dans le toString
        for (i in 0 until size) {
            for (j in 0 until size) {
                if (matrix[i][j] == true) {
                    bombes[i, j] = -1
                }
            }
        }

        return bombes
    }

    override fun toString(): String {
        var result = getBoardHints().toString()
        result = result.replace("-1", "*")
        result = result.replace("0", ".")
        result = result.replace("[", "")
        result = result.replace("]", "")
        result = result.replace(",", " ")
        return result
    }

}