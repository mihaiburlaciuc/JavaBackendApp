import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadData {
    public static void ReadDataFromFile(String fileName) {
        String currentEntry;

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((currentEntry = bufferedReader.readLine()) != null) {
                String[] currentEntrySplitter = currentEntry.split(" ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
