package domain.parsingFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.FileReader;

public class ParsingXml implements Constants {

    public Root parsingXml() {

        ObjectMapper objectMapper = new XmlMapper();

        try (FileReader reader = new FileReader("it_news.json")) {

            return objectMapper.readValue(reader, Root.class);
        } catch (Exception e) {
            System.out.println("Parsing error " + e.toString());
        }

        return null;
    }
}

//    Кто мучается с XML.
//        retrofit = Retrofit.Builder()
//        .addConverterFactory(ScalarsConverterFactory.create())
//        Получаем строку, пишем парсер на JSON с помощью XmlMapper(). Получаем JSON и спокойно читаем.
//        Так можно по заданию?