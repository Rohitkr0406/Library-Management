public class Book {
    String title;
    String author;
    String bookID;
    boolean isBorrowed = false;

    Book(String title, String author, String bookID) {
        this.title = title;
        this.author = author;
        this.bookID = bookID;

    }

    String getTitle() {
        return title;
    }

    String getAuthor() {
        return author;
    }

    String getBookID() {
        return bookID;
    }

    boolean borrow(){
        if(!isBorrowed){
            isBorrowed = true;
            return true;
        }
        return false;
    }

    boolean returnbook(){
        if(isBorrowed){
            isBorrowed = false;
            return true;
        }
        return false;
    }

    void showinfo(){
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Book ID: " + bookID);
    }

    public String toString(){
        return "\nTitle: " + title + "\nAuthor: " + author + "\nBook ID: " + bookID + "\n";
    }
}
