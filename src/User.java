import java.util.ArrayList;

public class User {
    String name;
    int ID;
    ArrayList<Book > borrowedbooks = new ArrayList<>();
    boolean isFirstLogin;

    User(String name, int ID){
        this.name = name;
        this.ID = ID;
        this.isFirstLogin = true;
    }

    void borrowedbook(Book book,Library lib){
        lib.lendBook(book,this);
    }

    void returnbook(Book book,Library lib){
        lib.acceptReturn(book,this);
    }

    void viewbooks(){
        if(borrowedbooks.isEmpty()){
            System.out.println("No books available");
        }
        else{
            System.out.print("\n");
            for(Book book:borrowedbooks){
                System.out.println(book);
                System.out.print("\n");
            }
        }
        return;
    }
}