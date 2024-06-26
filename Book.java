import java.util.*;

public class Book {

    private String isbn;
    private String title;
    private HashMap<String, Author> Author;

    //Setter methods
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(HashMap<String, Author> Author) {
        this.Author = Author;
    }

    //Getter methods
    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public HashMap<String, Author> getAuthorMap() {
        return Author;
    }
}