import java.util.ArrayList;
import java.util.Arrays;

public class Library {
    ArrayList<User> users = new ArrayList<User>();
    private int userID = 1;
    ArrayList<Book> books = new ArrayList<Book>();

    public User registUser(String name){
        User user = new User(name, userID++);
        users.add(user);
        System.out.println("User ID: " + user.ID + " with User name: "+user.name +".\nRegistered successfully\n");
        return user;
    }

    public User loginUser(int ID){
        for(User user : users){
            if(user.ID == ID){
                System.out.println("\nWelcome back " + user.name + "\n");
                return user;
            }
        }
        System.out.println("User not found\n");
        return null;
    }

    void addBook(Book... b){
        this.books.addAll(Arrays.asList(b));
    }

    void removebook(String bookID){
        for(int i = 0; i < books.size(); i++){
            if(books.get(i).getBookID().equals(bookID)){
                System.out.println("Removed Book: " + books.get(i));
                books.remove(i);
                return;
            }
        }
        System.out.println("Book: "+bookID + " not found");
    }

    void showAvailableBooks(){
        for (Book book : books) {
            System.out.println(book);
        }
    }

    void lendBook(Book book,User user){
        if(book.borrow()){
            user.borrowedbooks.add(book);
            System.out.println("\nLending Book: " + book + " to user: " + user.name + "\nwhose ID: " + user.ID +"\n");
            return ;
        }
        else{
            System.out.println("Sorry, " + book.getTitle() + " is already borrowed");
            return ;
        }
    }

    boolean acceptReturn(Book book,User user){
        if(book.returnbook()){
            user.borrowedbooks.remove(book);
            System.out.println("Your return is accepted");
            return true;
        }
        else{
            System.out.println("Book ID: " + book.getBookID() + " is already in the library");
            return false;
        }
    }
    

}
