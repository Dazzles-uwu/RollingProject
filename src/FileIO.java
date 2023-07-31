import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class FileIO {

    private String fileName;

    public FileIO()
    {

    }

    public FileIO(String name)
    {
        this.fileName = name;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String readFile()
    {
        String fileContent = "";
        try
        {
            FileReader reader = new FileReader("students.txt");

            Scanner fileInput = new Scanner(reader);
            while (fileInput.hasNextLine())
            {
                fileContent += fileInput.nextLine() + "\n";
            }
        }
        catch (Exception e)
        {
            System.out.println("Error in reading from file! Exiting...");
        }
        return fileContent;
    }

    public void writeFile(String line)
    {
        try
        {
            FileWriter writer = new FileWriter(University.FILE_NAME);
            line += "\n";
            writer.append(line);
        }
        catch (Exception e)
        {
            System.out.println("Error in writing to file! Exiting...");
        }
    }
}
