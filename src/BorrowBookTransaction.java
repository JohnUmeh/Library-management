//Class to implement borrow book process interface

public class BorrowBookTransaction implements Transaction{
    private final Book book; //Book to be borrowed
    private final Member member; //member borrowing the book


    //Constructor for transactions
    public BorrowBookTransaction(Book book, Member member){
        this.book = book;
        this.member = member;
    }

    //Overriding to borrow book with details
    @Override
    public void process(){
        if (!book.isBookBorrowed()) {
            book.borrowBook();
            System.out.println(book.getTitle() + " has been borrowed by " + member.getMemberName());
        } else {
            System.out.println(book.getTitle() + " is already borrowed, sorry!");
        }
    }

}
