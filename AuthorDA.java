import java.io.*;
import java.util.*;

public class AuthorDA {
    private HashMap<String, Author> authorMap;

    public HashMap<String, Author> getAuthorMap() {
        return authorMap;
    }

    public AuthorDA(String authorName) {
        try {
            Scanner authorFile = new Scanner(new FileReader("Author.csv"));

            authorMap = new HashMap<>();

            authorFile.nextLine();

            Integer key = 0;
            while(authorFile.hasNext()) {
                String authorLineData = new String();
                authorLineData = authorFile.nextLine();

                String[] authorLineDataSpecific = new String[2];
                authorLineDataSpecific = authorLineData.split(",");

                if (authorName.equals(authorLineDataSpecific[0].trim())) {
                    Author author = new Author();
                    author.setBio(authorLineDataSpecific[1].trim());

                    authorMap.put(authorName+key, author);
                    key++;
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}