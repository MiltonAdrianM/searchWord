package sopadeletras.sopaletras.entities;

//clase padre
public class WordSearchInput {
    private String searchword;
    private int rows;
    private String word;

    // constructor
    public WordSearchInput(String searchword, int rows, String word) {
        this.searchword = searchword;
        this.rows = rows;
        this.word = word;
    }

    public String getSearchword() {
        return searchword;
    }

    public void setSearchword(String searchword) {
        this.searchword = searchword;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
