//This library will maintain a list of books and the mebers
import java.util.ArrayList;
import java.util.List;


public class Library {
    private final List<Book> books = new ArrayList<>();
    private final List<Member> members = new ArrayList<>();

//add a new book to library
public void addBook(Book book){
    books.add(book);
}
//add a new member to library
    public void addMember(Member member){
    members.add(member);
    }

//find book by title
    public Book findBookByTitle(String title){
        for (Book book : books){
            if (book.getTitle().equalsIgnoreCase(title)){
                return book;
            }
        }
        return null;
    }

//find book by author
    public List<Book> findBookByAuthor(String author){
        List<Book> authorFound = new ArrayList<>();
        for (Book book : books){
            if (book.getAuthor().equalsIgnoreCase(author)){
                authorFound.add(book);

            }
        }
        return authorFound;
        }

//find member by memberID
    public Member findMemberById(int memberId){
        for (Member member : members){
            if (member.getMemberId() == memberId){
                return member;
            }
        }
        return null;
    }

//find member by name
    public List<Member> findMemberByName(String memberName){
            List<Member> memberFound = new ArrayList<>();
        for (Member member : members){
            if (member.getMemberName().equalsIgnoreCase(memberName)){
                memberFound.add(member);
            }
        }
        return memberFound;
    }

//show the list of available books
    public void availableBooks(){
        System.out.println("The available books: ");
        for (Book book : books){
            if (!book.isBookBorrowed()){
                System.out.println(book);
            }
        }
    }
}
