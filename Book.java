import java.util.*;

public class Book {

    private String isbn;
    private String title;
    private String authorName;
    private HashMap<String, Author> authorMap;

    //Setter methods
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setAuthorMap(HashMap<String, Author> authorMap) {
        this.authorMap = authorMap;
    }

    //Getter methods
    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public HashMap<String, Author> getAuthorMap() {
        return authorMap;
    }
}