package sopadeletras.sopaletras.controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sopadeletras.sopaletras.entities.WordSearchInput;
import sopadeletras.sopaletras.entities.WordSearchOutput;
import sopadeletras.sopaletras.services.WordSearchService;

/**
 *
 * @author milton-adrian
 */
@RestController
public class WordSearchController {
    // verifica que este respondiendo, devolviendo true
    @RequestMapping(value= "/", method=RequestMethod.GET)
    public boolean ping() {
        return true;
    }
    // realiza la busqueda y objtiene los valores de la matrix
    @RequestMapping(value= "/search-horandvert/", method=RequestMethod.POST)
    public WordSearchOutput search(@RequestBody WordSearchInput wordSearchInput) {
        char[][] matrix = fillMatrix(wordSearchInput.getRows(),wordSearchInput.getSearchword());
        String word = wordSearchInput.getWord();
        boolean wordFound = WordSearchService.search(matrix, word);
        // si encuentra la palabra retorna en el contains true, en caso contrario retorna false
        if(wordFound) {
            return new WordSearchOutput(wordSearchInput.getSearchword(),
                    wordSearchInput.getRows(),
                    wordSearchInput.getWord(),
                    true,
                    0,
                    0
            );
        } else {
            return new WordSearchOutput(wordSearchInput.getSearchword(),
                    wordSearchInput.getRows(),
                    wordSearchInput.getWord(),
                    false
                    );
        }
    }

    //crea la sopa de letras y particion de las filas y columnas
    private char[][] fillMatrix(int rows, String searchword) {
        char [][] matrix = new char[rows][];
        int amount = searchword.length() / rows;
        int col = 0;
        for (int i = 0; i < searchword.length(); i+=amount) {
            matrix[col] = searchword.substring(i, i + amount).toCharArray();
            col++;
        }
        // searchword.contains()
        return matrix;
    }
}