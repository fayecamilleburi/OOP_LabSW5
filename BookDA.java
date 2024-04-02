import java.io.*;
import java.util.*;

public class BookDA {
    private HashMap<String, Author> Author;

    public BookDA() {
        try {
            Scanner bookFile = new Scanner(new FileReader("Book.csv"));
            bookFile.nextLine();

            while (bookFile.hasNext()) {
                Author = new HashMap<>();
                String bookLineData = new String();
                bookLineData = bookFile.nextLine();

                String[] bookLineDataSpecific = new String[2];
                bookLineDataSpecific = bookLineData.split(",");

                Book book = new Book();
                book.setIsbn(bookLineDataSpecific[0].trim());
                book.setTitle(bookLineDataSpecific[1].trim());

                readDetails(book);
                printReport(book);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void printReport(Book book) {
        for (Map.Entry<String, Author> entryMap : book.getAuthorMap().entrySet()) {
            System.out.println(book.getIsbn() + " " + book.getTitle());
            System.out.println("\t" + entryMap.getValue().getName() +
                               " - " + entryMap.getValue().getBio());
            System.out.println();
        }
    }

    private void readDetails(Book book) {
        AuthorDA authorDA = new AuthorDA();
        book.setAuthor(authorDA.getAuthor());
    }
}