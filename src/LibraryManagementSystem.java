import java.util.Scanner;

/**
 * The LibraryManagementSystem class serves as the main entry point for a library management system.
 * It allows users to manage books and members, facilitating transactions like borrowing and returning books.
 */
public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library Hezekaiah = new Library();  // Create a new Library instance
        Scanner scanner = new Scanner(System.in);

        // Add new books and members to the library
        Hezekaiah.addBook(new Book("My Sister The Serial Killer", "Oyinkan Braithwaite"));
        Hezekaiah.addBook(new Book("Stay With Me", "Ayobami Adebayo"));
        Hezekaiah.addBook(new Book("The Madhouse", "T.J. Benson"));
        Hezekaiah.addMember(new Member("King Ledly"));
        Hezekaiah.addMember(new Member("Craig Ballamy"));
        Hezekaiah.addMember(new Member("Constantine John"));

        // Create a loop to handle transactions
        while (true) {
            // Display transaction options
            System.out.println("\n1. Show Available Books");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. Exit");
            System.out.println("Choose desired option:");
            int option = scanner.nextInt(); // Let user select desired transaction
            scanner.nextLine(); // Clear next line

            switch (option) {
                // Transaction to display books that are currently not borrowed
                case 1:
                    Hezekaiah.availableBooks();
                    break;

                // Transaction to borrow a book
                case 2:
                    System.out.println("Enter member ID number: ");
                    int memberId = scanner.nextInt();
                    scanner.nextLine(); // Clear next line
                    Member member = Hezekaiah.findMemberById(memberId);
                    if (member != null) { // Check if this is a member of the library
                        System.out.print("What is the book title: ");
                        String title = scanner.nextLine();
                        Book book = Hezekaiah.findBookByTitle(title);
                        if (book != null) { // Check if the book is available
                            Transaction nowBorrow = new BorrowBookTransaction(book, member);
                            nowBorrow.process(); // Process the borrowing transaction
                        } else {
                            System.out.println("Book not found");
                        }
                    } else {
                        System.out.println("Member not found");
                    }
                    break;

                // Transaction to return a borrowed book
                case 3:
                    System.out.print("Enter member ID: ");
                    memberId = scanner.nextInt();
                    scanner.nextLine();
                    member = Hezekaiah.findMemberById(memberId);
                    if (member != null) {
                        System.out.print("Enter book title: ");
                        String title = scanner.nextLine();
                        Book book = Hezekaiah.findBookByTitle(title);
                        if (book != null) { // Check if the book is available
                            Transaction nowReturn = new ReturnBookTransaction(book, member);
                            nowReturn.process(); // Process the return transaction
                        } else {
                            System.out.println("Book not found");
                        }
                    } else {
                        System.out.println("Member not found");
                    }
                    break;

                case 4:
                    System.out.println("Exiting system now. See you next time");
                    return;

                default:
                    System.out.println("Invalid choice selected");
            }
        }
    }
}
