
public class Library {
    private int bookId;
    private String bookName;
    private String bookAuthor;
    private long bookPrice;

    Library() {

    }

    Library(int bookId, String bookName, String bookAuthor, long bookPrice) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookPrice = bookPrice;
    }

    int get_bookId() {
        return this.bookId;
    }

    void set_bookId(int bookId) {
        this.bookId = bookId;
    }

    String get_bookName() {
        return this.bookName;
    }

    void set_bookName(String bookName) {
        this.bookName = bookName;
    }

    String get_bookAuthor() {
        return this.bookAuthor;
    }

    void set_bookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    long get_bookPrice() {
        return this.bookPrice;
    }

    void set_bookPrice(long bookPrice) {
        this.bookPrice = bookPrice;
    }
}
