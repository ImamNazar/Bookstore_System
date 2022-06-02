
import java.io.*;

// OOP - Encapsulation
public class Book {
    FileSystem fs = new FileSystem("books.txt");

    private int id;
    private String name;
    private String Category;
    private float price;
    private int bookCount;

    public Book() {
    }

    public Book(int id, String name, String Category, float price) {
        this.id = id;
        this.name = name;
        this.Category = Category;
        this.price = price;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getBookCount() {
        return bookCount;
    }

    public void setBookCount(int bookCount) {
        this.bookCount = bookCount;
    }

    public boolean addNewBook() {
        
        if(!fs.createANewFile()){
            String record = id + " " + name + " " + Category + " " + price;
            System.err.println(id + " " + name + " " + Category + " " + price);
            return fs.writeDataToFile(record);
        }

        return false;
    }
    
    public String viewAllBooks () {
        String book, allBooks = " ";
        String[] words = null;
        int count = 0;

        BufferedReader books = fs.readAFile();

        try {
            while ((book = books.readLine()) != null) {     
                words = book.split(" ");
                allBooks = allBooks + words[0] + "\t" + words[1] + "\t" + words[2] + "\t" + words[3] + "\n";
                count++;
                
            }
        } catch (Exception e) {
        }

        setBookCount(count);
        return allBooks;
    }
    
    public boolean searchbook (String keyword) {
        boolean isFound = false;
         
        try {
            String[] words = null;
            
            BufferedReader books = fs.readAFile();
            String book;
            
            outerloop:
            while ((book = books.readLine()) != null) {              
                words = book.split(" ");
                
                for (String word : words) {
                    if (word.equals(keyword)) {
                        isFound = true;
                        
                        this.setId(Integer.parseInt(words[0]));
                        this.setName(words[1]);
                        this.setCategory(words[2]);
                        this.setPrice(Float.parseFloat(words[3]));
                        
                        break outerloop;
                    }
                }
            }
        } catch (Exception e) {
        }
        
        return isFound;
    }
}
