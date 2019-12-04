package library;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Alexander Bazo on 16/11/15.
 * Modified by Lukas Jackermeier on 03/12/19
 */
public class LibraryApp {
    private static final int MAX_NUMBER_OF_MEDIA_IN_LIBRARY = 3;
    private static Media[] library;
    private static Scanner scanner;


    public static void main(String[] args) throws IOException {
        initScanner();
        initLibrary();
        saveMedia();
        printMedia();
        scanner.close();
    }

    private static void initScanner() {
        scanner = new Scanner(System.in);
    }

    private static void initLibrary() {
        library = new Media[MAX_NUMBER_OF_MEDIA_IN_LIBRARY];
    }

    private static void saveMedia() throws IOException {
        for (int i = 0; i < library.length; i++) {
            readAndSaveSingleMedia(i);
        }
    }

    private static void printMedia() {
        System.out.println(library.length + " items stored in library: ");
        for (int i = 0; i < library.length; i++) {
            System.out.println(library[i]);
        }
    }

    /*
     * Diese Methode erwartet eine Benutzereingabe (entweder "1" für Buch oder "2" für DVD)
     * Je nach Eingabe wird die entsprechende Methode zum Eingaben der Media-Details aufgerufen
     * Das neue Buch- bzw. DVD - Objekt wird dann am Index int indexInLibrary in dem Media Array gespeichert
     * Falls eine falsche Zahl eingegeben wird, wird die Methode im letzten else-Block erneut rekursiv aufgerufen
     * Falls gar keine Zahl, sondern z.B. ein String eingegeben wird, wird ein Fehler geworfen und das Programm würde abstürzen
     * Dieser Fall wird mit Hilfe eines try-catch Blocks abgefangen. Im catch-Block wird dann ein Hinweis angezeigt und die
     * Methode wird neu aufgerufen
     */
    private static void readAndSaveSingleMedia(int indexInLibrary) throws InputMismatchException {
        try {
            System.out.println("Insert media type (1 = Book, 2 = DVD): ");
            int mediaType = scanner.nextInt();
            if (mediaType == 1) {
                Book book = readBookInformation();
                library[indexInLibrary] = book;
            } else if (mediaType == 2) {
                DVD dvd = readDVDInformation();
                library[indexInLibrary] = dvd;
            } else {
                System.out.println("Error, please enter correct media type.");
                readAndSaveSingleMedia(indexInLibrary);
            }
        } catch (InputMismatchException e) {
            resetScanner();
            System.out.println("Error, please enter correct media type.");
            readAndSaveSingleMedia(indexInLibrary);
        }
    }

    /*
     * Diese Methode erwartet eine Folge von Benutzereingaben, und erzeugt dann aus den eingegebenen Werten
     * ein neues Objekt der Klasse 'Book'. Dieses neue Objekt wird dann zurückgegeben ('returned').
     * Auch hier werden Fehleingaben abgefangen und die Methode dann neu gestartet.
     */
    private static Book readBookInformation() throws InputMismatchException {
        try {
            int year = readYear();
            String title = readTitle();
            System.out.println("Author: ");
            String author = scanner.nextLine();
            System.out.println("Number of pages: ");
            int numberOfPages = scanner.nextInt();
            resetScanner();
            Book book = new Book(year, title, author, numberOfPages);
            return book;
        } catch (InputMismatchException e) {
            resetScanner();
            System.out.println("Unexpected Input. Please try again.");
            return readBookInformation();
        }
    }

    /*
     * readDVDInformation() funktioniert genau wie readBookInformation(), nur werden andere Werte eingelesen
     * um statdessen ein Objekt der Klasse DVD zu erstellen und zurückzugeben
     */
    private static DVD readDVDInformation() throws InputMismatchException {
        try {
            int year = readYear();
            String title = readTitle();
            System.out.println("Runtime (minutes): ");
            int runtimeInMinutes = scanner.nextInt();
            resetScanner();
            System.out.println("Bonus material included (true/false): ");
            boolean hasBonusMaterial = scanner.nextBoolean();
            resetScanner();
            DVD dvd = new DVD(year, title, runtimeInMinutes, hasBonusMaterial);
            return dvd;
        } catch (InputMismatchException e) {
            resetScanner();
            System.out.println("Unexpected Input. Please try again.");
            return readDVDInformation();
        }
    }


    private static int readYear() {
        System.out.println("Year: ");
        int year = scanner.nextInt();
        resetScanner();
        return year;
    }

    private static String readTitle() {
        System.out.println("Title: ");
        String title = scanner.nextLine();
        return title;
    }

    /*
     * resetScanner() positioniert den Scanner wieder am Anfang der nächsten Zeile. Dies ist nötig, da beim auslesen
     * von primitiven Datentypen wie z.B. bei nextInt() nicht in die nächste Zeile weitergerückt wird
     */
    private static void resetScanner() {
        scanner.nextLine();
    }


}
