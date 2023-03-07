package domain.fileDownloader;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class FileDownloaderXml {
    public final String URL = "https://api2.kiparo.com/static/it_news.xml";

    public void fileDownloaderXml() {
        InputStream inputStream = null;
        FileOutputStream outputStream = null;

        try {
            java.net.URL url = new URL(URL);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                inputStream = httpURLConnection.getInputStream();

                File file = new File("it_news.xml");
                outputStream = new FileOutputStream(file);

                int byteRead = -1;
                byte[] buffer = new byte[1024];
                while ((byteRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, byteRead);
                }
            }
        } catch (IOException e) {
            System.out.println("Internet connection error " + e.toString());
        } finally {
            try {

                inputStream.close();
                outputStream.close();
            } catch (IOException e) {
            }
        }
    }
}
