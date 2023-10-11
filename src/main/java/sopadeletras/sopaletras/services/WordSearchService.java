package sopadeletras.sopaletras.services;

public class WordSearchService {

    // hacer un seguimiento
    static boolean[][] visited;
    public static boolean search(char[][] matrix, String word) {
        //Obtener el número de filas son igual a la longitud del tablero
        int rows = matrix.length;
        int cols = matrix[0].length;
        visited = new boolean[rows][cols];
        // si encuentra el primera caracter, va llamar al metodo searchWord
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j ++){
                if (word.charAt(0) == matrix[i][j] && searchWord(i, j, 0, word, matrix)) {
                    return true;
                }
            }
        }
        return  false;
    }

    // realiza la busqueda de las siguientes letras, si las encuentra retorna true, en caso contrario retorna false
    public static boolean searchWord(int i, int j,int index, String word, char[][]matrix) {
        if (index == word.length()) {
            return  true;
        }
        if ( i < 0 || i >= matrix.length ||
             j < 0 || j >= matrix[i].length ||
             word.charAt(index) != matrix[i][j] || visited[i][j] ) {
               return false;
        }

        visited[i][j] = true;

        // realiza la busqueda dentro de la matrix buscando las palabras que coincida, si coinciden devuelve true
        if (searchWord(i +1,  j, index + 1, word, matrix) ||
            searchWord(i - 1, j, index + 1, word, matrix)||
            searchWord(i, j + 1, index + 1, word, matrix) ||
            searchWord(i, j - 1, index + 1, word, matrix)) {
                return  true;
        }
        visited[i][j] = true;
        return false;
    }
}
