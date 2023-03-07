package domain.parsingFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileReader;

public class ParsingJson implements Constants {

    public Root parsingJson() {

        ObjectMapper objectMapper = new ObjectMapper();

        try (FileReader reader = new FileReader("it_news.json")) {


            return objectMapper.readValue(reader, Root.class);
        } catch (Exception e) {
            System.out.println("Parsing error " + e.toString());
        }

        return null;
    }
}