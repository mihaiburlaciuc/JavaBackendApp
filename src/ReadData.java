import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ReadData {
    public static void ReadDataFromFile(String fileName) throws ParseException {
        String currentEntry;

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((currentEntry = bufferedReader.readLine()) != null) {
                String[] currentEntrySplitter = currentEntry.split(" ");
                Country tempCountry = new Country(currentEntrySplitter[0]);
                District tempDistrict = new District(currentEntrySplitter[1]);
                City tempCity = new City(currentEntrySplitter[2]);

                System.out.println(tempCity.getName());

                String locationName = currentEntrySplitter[3];
                Double avgPricePerDay = Double.parseDouble(currentEntrySplitter[4]);
                Date startDate = new SimpleDateFormat("dd/MM/yyyy").parse(currentEntrySplitter[5]);
                Date endDate = new SimpleDateFormat("dd/MM/yyyy").parse(currentEntrySplitter[6]);
                ArrayList<String> activities = new ArrayList<>();
                for (int i = 7; i < currentEntrySplitter.length; i++) {
                    activities.add(currentEntrySplitter[7]);
                }
                Place tempPlace = new Place(locationName, avgPricePerDay, startDate, endDate, activities);

                tempCity.addLocationElement(tempPlace);
                tempDistrict.addLocationElement(tempCity);
                tempCountry.addLocationElement(tempDistrict);

                World.getInstance().addLocationElement(tempCountry);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
