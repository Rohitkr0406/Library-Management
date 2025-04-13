import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library lib = new Library();
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Library\n");

        Book b1 = new Book("Atomic Habits","James Clear","B0001");
        Book b2 = new Book("The Alchemist", "Paulo Coelho", "B002");
        Book b3 = new Book("Wings of Fire", "A.P.J. Abdul Kalam", "B003");
        Book b4 = new Book("The Dark Knight", "James Clear", "B004");
        Book b5 = new Book("How to Win Friends & Influence People", "Dale Carnegie's", "B005");
        Book b6 = new Book("Man’s Search for Meaning","Viktor Frank", "B006");
        Book b7 = new Book("You are a Badass", "Jen Sincero", "B007");
        Book b8 = new Book("The Alchemist", "Viktor Frank", "B008");
        Book b9 = new Book("Thinking, Fast and Slow", "Daniel Kahneman", "B009");

        lib.addBook(b1, b2, b3, b4, b5, b6, b7, b8, b9);
        System.out.println("=====================================");
        System.out.println("Books in the library:");
        lib.showAvailableBooks();
        System.out.println("=====================================");
        String name = "";

        while(true){
            System.out.println("1. Register User\n2. Login User\n3. Exit\n");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); 
            if(choice == 1){
                System.out.print("Enter your name: ");
                name = sc.nextLine();
                lib.registUser(name);
            }
            else if(choice == 2){
                System.out.print("Enter your ID: ");
                int ID = sc.nextInt();
                User user = lib.loginUser(ID);
                if(user != null){
                    while(true){
                        System.out.println("=====================================");
                        System.out.println("Welcome " + user.name + "\n");
                        if(user.isFirstLogin){
                            System.out.println("Note: Since this is your first login, you need to borrow a book first");
                            user.isFirstLogin = false;
                        }
                        System.out.println("\n1. View Available Books\n2. Borrow Book\n3. Return Book\n4. View Borrowed Books\n5. Logout");
                        System.out.print("\nEnter your choice: ");
                        int choice1 = sc.nextInt();
                        if(choice1 == 1){
                            System.out.println("=====================================");
                            lib.showAvailableBooks();
                            System.out.println("=====================================");
                        }
                        else if(choice1 == 2){
                            System.out.print("Enter Book ID: ");
                            String bookID = sc.next();
                            boolean found = false;
                            for(Book book : lib.books){
                                if(book.getBookID().equals(bookID)){
                                    found = true;
                                    user.borrowedbook(book,lib);
                                }
                            }
                            if(!found){
                                System.out.println("Book not found");
                            }
                        }
                        else if(choice1 == 3){
                            if(user.isFirstLogin){
                                System.out.println("You need to borrow a book first");
                                continue;
                            }
                            if(user.borrowedbooks.isEmpty()){
                                System.out.println("No books available to return");
                                continue;
                            }
                            System.out.print("Enter Book ID: ");
                            String bookID = sc.next();
                            boolean found = false;
                            for(Book book : lib.books){
                                if(book.getBookID().equals(bookID)){
                                    found = true;
                                    user.returnbook(book,lib);
                                }
                            }
                            if(!found){
                                System.out.println("Book not found");
                            }
                        }
                        else if(choice1 == 4){
                            System.out.println("=====================================");
                            System.out.println("Borrowed Books:");
                            System.out.println("=====================================");
                            if(user.borrowedbooks.isEmpty()){
                                System.out.println("No books available");
                            }
                            else{
                                user.viewbooks();
                            }
                            System.out.println("=====================================");
                        }
                        else if(choice1 == 5){
                            System.out.println("Logged out successfully");
                            break;
                        }
                        else{
                            System.out.println("Invalid choice");
                        }
                    }
                }
                else{
                    System.out.println("User not found");
                }                       
            }
            else if(choice == 3){
                System.out.println("Exiting...");
                break;
            }
            else{
                System.out.println("Invalid choice");
            }
        }
        sc.close();

    }
}