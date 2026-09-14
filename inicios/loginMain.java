package inicios;
import java.util.Scanner;


public class loginMain {
    public static void main(String[]args){

        Scanner sc = new Scanner(System.in);
        
        loginManager manager = new loginManager();
        int option;
        int ampt = 0;

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
                    manager.registerUser(username, email, password);
                    System.out.println("User registered successfully!");
                }
                case 2 ->{
                    System.out.print("Enter username: ");
                    String username = sc.nextLine();
                    System.out.print("Enter password: ");
                    String password = sc.nextLine();
                    boolean userFound = manager.loginUser(username, password);
                   
                    if (userFound) {
                        System.out.println("Welcome, " + username + "!");
                        ampt = 0; // Reset attempts after successful login
                    }else{
                        
                        System.out.println("Login failed. Invalid username or password.");
                        ampt++;
                        if (ampt >= 3) {
                            System.out.println("Too many failed login attempts. Exiting the system.");
                            option = 3; // Exit the loop
                        }else{
                            System.out.println("You have " + (3 - ampt) + " attempts remaining.");
                        }
                    }
                }
                case 3 -> {System.out.println("Exiting the system. Goodbye!"); break;}

                default -> System.out.println("Invalid option. Please try again.");
                    
            }


        }while(option !=3);
        sc.close();


    }

    
}