//create the book class
public class Book {
    private final String title;
    private final String author;
    private boolean isBookBorrowed;

//Constructor to get a book
public Book(String title, String author){
    this.title = title;
    this.author = author;
    this.isBookBorrowed = false; //by default, the books are not borrowed
}
//set methods to get book title, author and borrow status
    public String getTitle(){
    return title;
    }
    public String getAuthor(){
    return author;
    }
    public boolean isBookBorrowed(){
    return isBookBorrowed;
    }
//set methods to borrow and return book
    public void borrowBook(){
    this.isBookBorrowed = true;
    }
    public void returnBook(){
    this.isBookBorrowed = false;
    }
//Overriding toString to print details of title and author
    @Override
    public String toString(){
    return "Book " + title +" By "+ author;
    }
}