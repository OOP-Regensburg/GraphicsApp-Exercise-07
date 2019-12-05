package library;

/**
 * Created by Alexander Bazo on 16/11/15.
 */
public class Book extends Media {
    private String author;
    private int numberOfPages;

    public Book(int year, String title, String author, int numberOfPages) {
        super(year, title);
        this.author = author;
        this.numberOfPages = numberOfPages;
    }

    public String getAuthor() {
        return author;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + author + ", " + numberOfPages + " pages";
    }
}
