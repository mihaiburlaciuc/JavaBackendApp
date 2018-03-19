import hierarchical_structure.Place;
import hierarchical_structure.World;
import main.CommandIO;
import main.ReadData;

import java.io.IOException;
import java.text.ParseException;

public class Main {
    private static final String fileName = "in.txt";

    private Main() {

    }

    public static void main(String[] args) {
        try {
            ReadData.ReadDataFromFile(fileName);
            try {
                CommandIO.startSession();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
