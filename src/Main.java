import hierarchical_structure.Place;
import hierarchical_structure.World;
import main.ReadData;

import java.text.ParseException;

public class Main {
    private static final String fileName = "in.txt";

    private Main() {

    }

    public static void main(String[] args) {
        try {
            ReadData.ReadDataFromFile(fileName);
            System.out.println(((Place) World.getInstance().getElement("RO").getElement("CT").getElement("Cta").getElement("OldTown")).getAvgPricePerDay());

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
