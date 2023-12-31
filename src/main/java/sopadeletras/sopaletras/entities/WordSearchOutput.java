package sopadeletras.sopaletras.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

// clase hija que hereda de la clase principal WordSearchInput
@JsonIgnoreProperties(ignoreUnknown = true)
public class WordSearchOutput extends WordSearchInput {
    private boolean contains;
    private Integer start_row;
    private Integer start_col;

    //constructor
    public WordSearchOutput(String searchword, int rows, String word, boolean contains) {
        super(searchword, rows, word);
        this.contains = contains;
    }

    public WordSearchOutput(String searchword, int rows, String word, boolean contains, int start_row, int start_col) {
        super(searchword, rows, word);
        this.contains = contains;
        this.start_row = start_row;
        this.start_col = start_col;
    }

    public boolean isContains() {
        return contains;
    }

    public void setContains(boolean contains) {
        this.contains = contains;
    }
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Integer getStart_row() {
        return start_row;
    }

    public void setStart_row(Integer start_row) {
        this.start_row = start_row;
    }
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Integer getStart_col() {
        return start_col;
    }

    public void setStart_col(Integer start_col) {
        this.start_col = start_col;
    }
}
