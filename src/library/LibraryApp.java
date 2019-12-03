package library;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Alexander Bazo on 16/11/15.
 * Modified by Lukas Jackermeier on 03/12/19
 */
public class LibraryApp {
    private static final int MAX_NUMBER_OF_MEDIA_IN_LIBRARY = 3;
    private static Media[] library;
    private static BufferedReader reader;


    public static void main(String[] args) throws IOException {
        initBufferedReader();
        initLibrary();
        saveMedia();
        printMedia();
        reader.close();
    }

    // BufferedReader erlaubt es uns, Nutzereingaben aus der Konsole mithilfe der Methode readLine() auszulesen
    private static void initBufferedReader() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    private static void initLibrary() {
        library = new Media[MAX_NUMBER_OF_MEDIA_IN_LIBRARY];
    }

    private static void saveMedia() throws IOException {
        for(int i = 0; i < library.length; i++) {
            readAndSaveSingleMedia(i);
        }
    }

    private static void printMedia() {
        System.out.println(library.length + " items stored in library: ");
        for(int i = 0; i < library.length; i++) {
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
    private static void readAndSaveSingleMedia(int indexInLibrary) throws IOException, NumberFormatException {
        try {
            System.out.println("Insert media type (1 = Book, 2 = DVD): ");
            int mediaType = Integer.parseInt(reader.readLine());
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
        } catch (NumberFormatException e) {
            System.out.println("Error, please enter correct media type.");
            readAndSaveSingleMedia(indexInLibrary);
        }
    }

    /*
     * Diese Methode erwartet eine Folge von Benutzereingaben, und erzeugt dann aus den eingegebenen Werten
     * ein neues Objekt der Klasse 'Book'. Dieses neue Objekt wird dann zurückgegeben ('returned').
     * Auch hier werden Fehleingaben abgefangen und die Methode dann neu gestartet.
     */
    private static Book readBookInformation() throws IOException, NumberFormatException {
        try {
            int year = readYear();
            String title = readTitle();
            System.out.println("Author: ");
            String author = reader.readLine();
            System.out.println("Number of pages: ");
            int numberOfPages = Integer.parseInt(reader.readLine());
            Book book = new Book(year, title, author, numberOfPages);
            return book;
        } catch (NumberFormatException e) {
            System.out.println("Unexpected Input. Please try again.");
            return readBookInformation();
        }
    }

    /*
     * readDVDInformation() funktioniert genau wie readBookInformation(), nur werden andere Werte eingelesen
     * um statdessen ein Objekt der Klasse DVD zu erstellen und zurückzugeben
     * Aufpassen bei boolean: parseBoolean(String s) ist true, falls der eingegebene String "true" ist.
     * Sollte es irgendeine beliebige andere Eingabe sein, wird immer false zurückgegeben.
     */
    private static DVD readDVDInformation() throws IOException, NumberFormatException {
        try {
            int year = readYear();
            String title = readTitle();
            System.out.println("Runtime (minutes): ");
            int runtimeInMinutes = Integer.parseInt(reader.readLine());
            System.out.println("Bonus material included (true/false): ");
            boolean hasBonusMaterial = Boolean.parseBoolean(reader.readLine());
            DVD dvd = new DVD(year, title, runtimeInMinutes, hasBonusMaterial);
            return dvd;
        } catch (NumberFormatException e) {
            System.out.println("Unexpected Input. Please try again.");
            return readDVDInformation();
        }
    }

    /*
     * Hierbei gilt es zu beachten, dass reader.readLine() immer einen String ausließt. Sollte man die Eingabe als int
     * speichern wollen, muss dieser zuerst in den passenden Datentyp umgewandelt werden. Dies passiert mit Integer.parse(String s)
     */
    private static int readYear() throws IOException {
        System.out.println("Year: ");
        int year = Integer.parseInt(reader.readLine());
        return year;
    }

    private static String readTitle() throws IOException {
        System.out.println("Title: ");
        String title = reader.readLine();
        return title;
    }


}
