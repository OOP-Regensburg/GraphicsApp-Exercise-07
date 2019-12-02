package library;

import java.time.Year;

/**
 * Created by Alexander Bazo on 16/11/15.
 */
public class Media {

    private static int mediaCount = 0;
    private int id;
    private int year;
    private String title;

    public Media(int year, String title) {
        mediaCount++;
        this.id = mediaCount;
        this.year = year;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public int getYear() {
        return year;
    }


    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return id+": " + title + " (" + year + ")";
    }
}
