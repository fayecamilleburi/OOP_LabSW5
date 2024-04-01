import java.io.*;
import java.util.*;

public class AuthorDA {
    private HashMap<String, Author> authorMap;

    public HashMap<String, Author> getAuthorMap() {
        return authorMap;
    }

    public AuthorDA() {
        try {
            Scanner authorFile = new Scanner(new FileReader("Author.csv"));

            authorMap = new HashMap<>();

            authorFile.nextLine();

            while(authorFile.hasNext()) {

                authorMap = new HashMap<>();
                String authorLineData = new String();
                authorLineData = authorFile.nextLine();

                String[] authorLineDataSpecific = new String[2];
                authorLineDataSpecific = authorLineData.split(",");

                Author author = new Author();
                author.setName(authorLineDataSpecific[0].trim());
                author.setBio(authorLineDataSpecific[1].trim());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}