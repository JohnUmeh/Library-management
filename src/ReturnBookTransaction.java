//Class for return transaction
public class ReturnBookTransaction implements Transaction{
    private final Book book; //Book to be returned
    private final Member member; //Member returning the book


    //Constructor for transactions
    public ReturnBookTransaction(Book book, Member member){
        this.book = book;
        this.member = member;
    }

    //Overriding to borrow book with details
    @Override
    public void process(){
        if (book.isBookBorrowed()) {
            book.returnBook();
            System.out.println(book.getTitle() + " has been returned by " + member.getMemberName());
        } else {
            System.out.println(book.getTitle() + " was not borrowed. Thank you");
        }
    }

}
