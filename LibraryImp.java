import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LibraryImp implements LibraryInf {
    Scanner sc = new Scanner(System.in);

    ArrayList<Library> library = new ArrayList<>();
    static int i = 0;

    void getId(Library book) {
        try {
            System.out.println("Enter the Book ID: ");
            int id = sc.nextInt();
            for (Library lib : library) {
                if (lib.get_bookId() == id) {
                    throw new DuplicateId("Id already exists!!");
                }
            }
            if (id <= 0) {
                throw new LessThanZero("ID cannot be < 0");
            } else {
                sc.nextLine();
                book.set_bookId(id);
            }

        } catch (DuplicateId e) {
            System.out.println("ID already exists");
            sc.nextLine();
            getId(book);
        } catch (LessThanZero e) {
            System.out.println("Enter a vaid number");
            sc.nextLine();
            getId(book);
        }
    }

    void getName(Library book) {
        try {
            System.out.println("Enter the Book name: ");
            String bName = sc.nextLine();
            if (bName.length() > 15) {
                throw new InvalidStringLength("Book name cannot exceed 15 char's");
            } else {
                book.set_bookName(bName);
            }

        } catch (InvalidStringLength e) {
            System.out.println("Book name cannot exceed 15 char's");
            sc.nextLine();
            getName(book);
        }
    }

    void getAuthor(Library book) {
        try {
            System.out.println("Enter the Book author: ");
            String bAuthor = sc.next();
            if (bAuthor.length() > 15) {
                throw new InvalidStringLength("Author name cannot exceed 15 char's");
            } else {
                book.set_bookAuthor(bAuthor);
            }

        } catch (InvalidStringLength e) {
            System.out.println("Author name cannot exceed 15 char's");
            sc.nextLine();
            getAuthor(book);
        }
    }

    void getPrice(Library book) {
        try {
            System.out.println("Enter the Book price: ");
            long p = sc.nextLong();
            if (p <= 0) {
                throw new InvalidPriceException("InvalidInput: Book price must be greater than 0!");
            } else {
                book.set_bookPrice(p);

            }
        } catch (InvalidPriceException e) {
            System.out.println(e.getMessage());
            sc.nextLine();
            getPrice(book);
        }
    }

    @Override
    public void addBook(Library book) {
        getId(book);
        getName(book);
        getAuthor(book);
        getPrice(book);
        library.add(book);
    }

    @Override
    public void displayBooks() {
        System.out.println("----------------------------------------------------");
        System.out.println("    BOOKID   |   NAME   |   AUTHOR   |   PRICE   ");
        System.out.println("----------------------------------------------------");

        for (Library l : library) {

            if (l.get_bookName() != null) {
                System.out.println("      " + l.get_bookId() + "          " +
                        l.get_bookName() + "          " +
                        l.get_bookAuthor() + "          " +
                        l.get_bookPrice() + " ");
            } else {
                return;
            }
        }
    }

    void displayBook(Library library) {
        System.out.println("-----------------------------");
        System.out.println("Book id: " + library.get_bookId() + "\nBook name: " +
                library.get_bookName() + "\nAuthor: " +
                library.get_bookAuthor() + "\nPrice :  " +
                library.get_bookPrice() + " ");
        System.out.println("-----------------------------");
    }

    void searcByName() {
        System.out.println("Enter book name to search:");
        boolean found = false;
        String name = sc.next();
        for (Library l : library) {
            if (l.get_bookName().equalsIgnoreCase(name)) {
                displayBook(l);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Book name not found!");
        }
    }

    void searcById() {
        System.out.println("Enter book author to search:");
        boolean found = false;
        int id = sc.nextInt();
        for (Library l : library) {
            if (l.get_bookId() == (id)) {
                displayBook(l);
                found = true;
                return;
            }
        }
        if (!found) {
            System.out.println("Book author not found!");
        }
    }

    void searcByPrice() {
        System.out.println("Enter book price to search:");
        boolean found = false;
        long price = sc.nextLong();
        for (Library l : library) {
            if (l.get_bookPrice() == (price)) {
                displayBook(l);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Book price not found!");
        }
    }

    void searcByAuthor() {
        System.out.println("Enter book author to search:");
        boolean found = false;
        String author = sc.next();
        for (Library l : library) {
            if (l.get_bookAuthor().equalsIgnoreCase(author)) {
                displayBook(l);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Book author not found!");
        }
    }

    @Override
    public void searchBook() {
        int option;
        while (true) {
            System.out.println("-----------------------------");
            System.out.println("Enter your choice: ");
            System.out.println("1.SEARCH BY BOOK NAME ");
            System.out.println("2.SEARCH BY BOOK ID ");
            System.out.println("3.SEARCH BY BOOK AUTHOR");
            System.out.println("4.SEARCH BY BOOK PRICE");
            System.out.println("5.EXIT");
            System.out.println("-----------------------------");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    searcByName();
                    break;

                case 2:
                    searcById();
                    break;

                case 3:
                    searcByAuthor();
                    break;

                case 4:
                    searcByPrice();
                    break;
                case 5:
                    return;

                default:
                    System.out.println("Invalid option!");
                    break;

            }
        }
    }

}
