import java.io.*;
import java.util.*;

public class AuthorDA {
    private HashMap<String, Author> Author;

    public HashMap<String, Author> getAuthor() {
        return Author;
    }

    public AuthorDA() {
        try {
            Scanner authorFile = new Scanner(new FileReader("Author.csv"));
            authorFile.nextLine();

            Author = new HashMap<>();

            while(authorFile.hasNext()) {
                String authorLineData = new String();
                authorLineData = authorFile.nextLine();

                String[] authorLineDataSpecific = new String[2];
                authorLineDataSpecific = authorLineData.split(",");

                Author author = new Author();
                author.setName(authorLineDataSpecific[0].trim());
                author.setBio(authorLineDataSpecific[1].trim());

                Author.put(author.getName(), author);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}