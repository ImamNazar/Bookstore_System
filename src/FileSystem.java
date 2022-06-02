
import java.io.*;
import java.io.IOException;

public class FileSystem {
    private static String FILE_PATH = "DB\\";

    File file;
    private String fileName;

    public FileSystem(String fileName) {
        this.fileName = fileName;
        
        createANewFile();
    }
    
    public boolean createANewFile() {
        try {
            file = new File(FILE_PATH + fileName);
            if (file.createNewFile()){
                System.out.println("File Created: " + file.getName());
                return true;
            }
            
            System.out.println("File Already Exisit !");
            return false;
        } catch(IOException e) {
            System.out.println("Something went wrong with creating file" + e);
            return false;
        }
    };
    
    public BufferedReader readAFile() {
        if(!createANewFile()){
            try {
                FileReader reader = new FileReader(file);
                BufferedReader buffer = new BufferedReader(reader);

                return buffer;
            } catch (IOException e) {
                System.out.println("Something went wrong with Reading the file" + e);
            }
        }
        
        return null;
    };
    
    public boolean writeDataToFile(String record) {
        try {
            file.createNewFile();
            FileWriter newWriter = new FileWriter(file, true);
            BufferedWriter newBuffer = new BufferedWriter(newWriter);

            newBuffer.write(record);
            newBuffer.newLine();
            newBuffer.close();
            newWriter.close();

            return true;
        } catch (IOException e) {
            System.out.println("Something went wrong with writing" + e);
            return false;
        }
    };
}
