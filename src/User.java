
import java.io.BufferedReader;

// OOP - Encapsulation
public class User {
    FileSystem fs = new FileSystem("users.txt");

    private String name;
    private String username;
    private String password;
    private String role;
    private int userCount;

    public User() {
    }

    // OOP - Polymorphism
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String name, String username, String password, String role) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getUserCount() {
        return userCount;
    }

    public void setUserCount(int userCount) {
        this.userCount = userCount;
    }

    public String viewAllUsers () {
        String user, allUsers = " ";
        String[] words = null;
        int count = 0;

        BufferedReader books = fs.readAFile();

        try {
            while ((user = books.readLine()) != null) {    
                words = user.split(" ");
                allUsers = allUsers + words[0] + "\t" +  words[1] + "\t" +  words[3] + "\n";
                count++;
            }
        } catch (Exception e) {
        }
        
        setUserCount(count);
        return allUsers;
    }

    public boolean validateLogin() {
        try {
            String[] words = null;
            
            BufferedReader users = fs.readAFile();
            String user;

            while ((user = users.readLine()) != null) {              
                words = user.split(" ");

                if (words[1].equals(username) && words[2].equals(password)) {
                    this.setName(words[0]);
                    this.setUsername(words[1]);
                    this.setRole(words[3]);
                    return true;
                }
            }
        } catch (Exception e) {
        }
        
        return false;
    }
    
    public boolean addNewUser() {
        if(!fs.createANewFile()){
            String record = name + " " + username+ " " + password + " " + role;
            
            return fs.writeDataToFile(record);
        }

        return false;
    }
}
