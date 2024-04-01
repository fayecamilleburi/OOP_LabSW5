import java.io.*;
import java.util.*;

public class BookDA {
    
    private HashMap<String, Author> authorMap;

    public BookDA() {

        try {
            Scanner bookFile = new Scanner(new FileReader("Book.csv"));

            bookFile.nextLine();

            while(bookFile.hasNext()) {
                authorMap = new HashMap<>();
                String bookLineData = new String();
                bookLineData = bookFile.nextLine();

                String[] bookLineDataSpecific = new String[3];
                bookLineDataSpecific = bookLineData.split(",");

                Book book = new Book();
                book.setIsbn(bookLineDataSpecific[0].trim());
                book.setTitle(bookLineDataSpecific[1].trim());
                readBio(book);

                String name = "";
                String bio = "";
                Integer counter = 0;
                for (Map.Entry<String, Author> entryMap : book.getAuthorMap().entrySet()) {
                    name = entryMap.getValue().getName();
                    bio = entryMap.getValue().getBio();
                    counter++;
                }
                printReport(book);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void printReport(Book book) {
        System.out.println(book.getIsbn() + " " + book.getTitle());
        for (Map.Entry<String, Author> entryMap : book.getAuthorMap().entrySet()) {
            System.out.println("\t" + entryMap.getValue().getName() + " - " + entryMap.getValue().getBio());
        }
        System.out.println();
    }

    private void readBio(Book book) {
        AuthorDA authorDA = new AuthorDA();
        book.setAuthorMap(authorDA.getAuthorMap());
    }
}