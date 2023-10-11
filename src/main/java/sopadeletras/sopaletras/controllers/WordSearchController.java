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
    @RequestMapping(value= "/", method=RequestMethod.GET)
    public boolean ping() {
        return true;
    }
    @RequestMapping(value= "/search-horandvert/", method=RequestMethod.POST)
    public WordSearchOutput search(@RequestBody WordSearchInput wordSearchInput) {
        char[][] matrix = fillMatrix(wordSearchInput.getRows(),wordSearchInput.getSearchword());
        String word = wordSearchInput.getWord();
        boolean wordFound = WordSearchService.search(matrix, word);
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

    private char[][] fillMatrix(int rows, String searchword) {
        char [][] matrix = new char[rows][];
        int amount = searchword.length() / rows;
        int col = 0;
        for (int i = 0; i < searchword.length(); i+=amount) {
            matrix[col] = searchword.substring(i, i + amount).toCharArray();
            col++;
        }
        return matrix;
    }
}

