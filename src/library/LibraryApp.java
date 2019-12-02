package library;

import acm.program.ConsoleProgram;

import java.time.Year;

/**
 * Created by Alexander Bazo on 16/11/15.
 */
public class LibraryApp extends ConsoleProgram {
    private static final int MAX_NUMBER_OF_MEDIA_IN_LIBRARY = 3;
    private Media[] library;

    @Override
    public void run() {
        initLibrary();
        saveMedia();
        printMedia();
    }

    private void initLibrary() {
        library = new Media[MAX_NUMBER_OF_MEDIA_IN_LIBRARY];
    }

    private void saveMedia() {
        for(int i = 0; i < library.length; i++) {
            readAndSaveSingleMedia(i);
        }
    }

    private void printMedia() {
        println(library.length + " items stored in library: ");
        for(int i = 0; i < library.length; i++) {
            println(library[i]);
        }
    }

    private void readAndSaveSingleMedia(int indexInLibrary) {
        int mediaType = readInt("Insert media type (1 = Book, 2 = DVD): ", 1, 2);
        if(mediaType == 1) {
            Book book = readBookInformation();
            library[indexInLibrary] = book;
        } else if(mediaType == 2) {
            DVD dvd = readDVDInformation();
            library[indexInLibrary] = dvd;
        }
    }

    private Book readBookInformation() {
        int year = readYear();
        String title = readTitle();
        String author = readLine("Author: ");
        int numberOfPages = readInt("Number of pages: ");
        Book book = new Book(year, title, author, numberOfPages);
        return book;
    }

    private DVD readDVDInformation() {
        int year = readYear();
        String title = readTitle();
        int runtimeInMinutes = readInt("Runtime (minutes): ");
        boolean hasBonusMaterial = readBoolean("Bonus material included (true/false): ");
        DVD dvd = new DVD(year, title, runtimeInMinutes, hasBonusMaterial);
        return dvd;
    }

    private int readYear() {
        int year = readInt("Year: ");
        return year;
    }

    private String readTitle() {
        String title = readLine("Title: ");
        return title;
    }


}
