package exoMatrix

class IntMatrix(column: Int, line: Int) {

    private val matrix: List<MutableList<Int?>> = List(line) { MutableList(column) { null } }

    private operator fun get(i: Int, j: Int): Int? {
        return matrix[i][j]
    }

    operator fun set(line: Int, column: Int, value: Int) {
        matrix[line][column] = value
    }

    operator fun times(other: IntMatrix): IntMatrix {
        //on surchage la fonction * pour faire la multiplication de deux matrices
        //on vérifie que les matrices sont de même taille
        if (matrix.size == other.matrix.size || matrix[0].size == other.matrix[0].size) {
            //on crée une nouvelle matrice de la même taille que les deux matrices
            val result = IntMatrix(matrix.size, other.matrix[0].size)
            //on parcourt  la première matrice
            for (i in 0 until matrix[0].size) {
                //on parcourt  la deuxième matrice
                for (j in 0 until other.matrix[0].size) {
                    //on reparcourt  la première matrice
                    for (k in 0 until matrix[0].size) {
                        //on fait la multiplication des deux matrices et on l'ajoute à la matrice résultat à la position i,j
                        result[i, j] = (result[i, j] ?: 0) + (matrix[i][k] ?: 0) * (other.matrix[k][j] ?: 0)
                    }
                }
            }
            return result
        }
        return other; //on retourne la matrice other si les matrices ne sont pas de même taille
    }

    operator fun timesAssign(other: IntMatrix) {
        //on surchage la fonction *= pour faire la multiplication de deux matrices
        //on vérifie que les matrices sont de même taille
        if (matrix.size == other.matrix.size || matrix[0].size == other.matrix[0].size) {
            //on parcourt  la première matrice
            for (i in 0 until matrix[0].size) {
                //on parcourt  la deuxième matrice
                for (j in 0 until other.matrix[0].size) {
                    //on reparcourt  la première matrice
                    for (k in 0 until matrix[0].size) {
                        //on fait la multiplication des deux matrices et on l'ajoute à la matrice other directement car pas besoin de temporaire car on additionne à la valeur de base
                        this[i, j] = (this[i, j] ?: 0) + (matrix[i][k] ?: 0) * (other.matrix[k][j] ?: 0)
                    }
                }
            }
        }
    }

    override fun toString(): String {
        var result = ""
        for (i in 0 until matrix.size) {
            for (j in 0 until matrix[0].size) {
                result += matrix[i][j]
                result += " "
            }
            result += "\n"
        }
        return result
    }
}