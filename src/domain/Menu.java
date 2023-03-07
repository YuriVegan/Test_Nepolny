package domain;

import domain.fileDownloader.FileDownloaderJson;
import domain.fileDownloader.FileDownloaderXml;
import domain.parsingFile.ParsingJson;
import domain.parsingFile.ParsingXml;
import domain.parsingFile.Root;

import java.io.IOException;

public class Menu {

    FileDownloaderJson fileDownloaderJson = new FileDownloaderJson();
    FileDownloaderXml fileDownloaderXml = new FileDownloaderXml();
    ParsingXml parsingXml = new ParsingXml();
    ParsingJson parsingJson = new ParsingJson();

    Root root = null;

    public void menu() throws java.io.IOException {
        char choice, ignore;

        for (; ; ) {
            do {
                System.out.println("Выберите действие: ");
                System.out.println(" 1. Скачать Json");
                System.out.println(" 2. Скачать Xml");
                System.out.println(" 3. Parsing Json");
                System.out.println(" 4. Parsing Xml");
                System.out.println(" 5. ...");
                System.out.println(" 6. ...");
                System.out.print("Выберите (q-выход): ");
                choice = (char) System.in.read();
                do {
                    ignore = (char) System.in.read();
                } while (ignore != '\n');
            } while (choice < '1' | choice > '6' & choice != 'q');
            if (choice == 'q') break;
            System.out.println("\n");

            switch (choice) {
                case '1':
                    fileDownloaderJson.fileDownloaderJson();
                    System.out.println("Файл Json выгружен!");
                    break;
                case '2':
                    fileDownloaderXml.fileDownloaderXml();
                    System.out.println("Файл Xml выгружен!");
                    break;
                case '3':
                    root = parsingJson.parsingJson();
                    System.out.println("parsingJson ready");
                    break;
                case '4':
                    root =  parsingXml.parsingXml();
                    System.out.println("parsingXml ready");
                    break;
                case '5':

                    break;
                case '6':

                    break;
            }
            System.out.println();
            System.out.println("Root " + root.toString());
        }
    }
}

