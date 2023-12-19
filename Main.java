
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int option;
        Scanner sc = new Scanner(System.in);

        LibraryFactory lib = new LibraryFactory();

        LibraryInf li = lib.getObject();
        // Library l = new Library();
        while (true) {
            System.out.println("-----------------------------");
            System.out.println("Enter your choice: ");
            System.out.println("1.ADD BOOK ");
            System.out.println("2.SEARCH BOOK ");
            System.out.println("3.DISPLAY BOOK");
            System.out.println("4.EXIT");
            System.out.println("-----------------------------");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    li.addBook(new Library());
                    break;

                case 2:
                    li.searchBook();
                    break;

                case 3:

                    li.displayBooks();
                    break;

                case 4:
                    return;
                default:
                    break;

            }
        }

    }
}
