package inicios;
import java.util.Scanner;
import java.util.ArrayList;

public class loginMain {
    public static void main(String[]args){

        Scanner sc = new Scanner(System.in);
        ArrayList<User> users = new ArrayList<>();
        int option;

        System.out.println("Welcome to the login system");
        do{
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Select an option: ");
            option = sc.nextInt();
            sc.nextLine(); // Consume the newline character

            switch (option) {
                case 1 ->{
                    System.out.print("Enter username: ");
                    String username = sc.nextLine();
                    System.out.print("Enter email: ");
                    String email = sc.nextLine();
                    System.out.print("Enter password: ");
                    String password = sc.nextLine();
                    User newUser = new User(username, email, password);
                    users.add(newUser);
                }
                case 2 ->{
                    System.out.print("Enter username: ");
                    String username = sc.nextLine();
                    System.out.print("Enter password: ");
                    String password = sc.nextLine();
                    boolean userFound = false;
                    for (User user : users) {
                        if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                            System.out.println("Login successful!");
                            userFound = true;
                            break;
                        }
                    }
                    if (!userFound) {
                        System.out.println("Invalid username or password.");
                    }
                }
                case 3 -> {System.out.println("Exiting the system. Goodbye!"); break;}

                default -> System.out.println("Invalid option. Please try again.");
                    
            }


        }while(option !=3);
        sc.close();


    }

    
}









