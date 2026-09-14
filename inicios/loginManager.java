package inicios;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class loginManager {
    private static final String CSV_FILE = System.getProperty("user.dir") + File.separator + "users.csv";
    public int ampt = 0;
    private ArrayList<User> users = new ArrayList<>();

    public loginManager() {
        File file = new File(CSV_FILE);
        if (!file.exists()) {
            try {
                file.createNewFile();
                System.out.println("CSV file created: " + CSV_FILE);
            } catch (IOException e) {
                System.out.println("Error creating CSV file: " + e.getMessage());
            }
        }
        loadUsersFromCSV();
    }

    public void registerUser(String username, String email, String password) {
        User newUser = new User(username, email, password);
        users.add(newUser);
        saveUsersToCSV();
    }

    public boolean loginUser(String username, String password) {
        loadUsersFromCSV();
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true; // Login successful
            }
        }

        return false; // Login failed
    }

    private void loadUsersFromCSV() {
        users = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 3) {
                    String username = data[0];
                    String email = data[1];
                    String password = data[2];
                    User user = new User(username, email, password);
                    users.add(user);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading users from CSV: " + e.getMessage());
        }
    }

    private void saveUsersToCSV() {
        try (java.io.FileWriter writer = new java.io.FileWriter(CSV_FILE)) {
            for (User user : users) {
                writer.write(user.getUsername() + "," + user.getEmail() + "," + user.getPassword() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error saving users to CSV: " + e.getMessage());
        }
    }
}