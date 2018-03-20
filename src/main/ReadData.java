package main;

import hierarchical_structure.*;
import location_maps.ActivityMap;
import location_maps.CityMap;
import location_maps.DistrictsMap;
import location_maps.PlacesMap;

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
                Country tempCountry;
                if (World.getInstance().getElement(currentEntrySplitter[0]) == null) {
                    tempCountry = new Country(currentEntrySplitter[0]);
                } else {
                    tempCountry = (Country) World.getInstance().getElement(currentEntrySplitter[0]);
                }

                District tempDistrict;
                if (DistrictsMap.getInstance().getDistrict(currentEntrySplitter[1]) == null) {
                    tempDistrict = new District(currentEntrySplitter[1]);
                } else {
                    tempDistrict = DistrictsMap.getInstance().getDistrict(currentEntrySplitter[1]);
                }

                City tempCity;
                if (CityMap.getInstance().getCity(currentEntrySplitter[2]) == null) {
                    tempCity = new City(currentEntrySplitter[2]);
                } else {
                    tempCity = CityMap.getInstance().getCity(currentEntrySplitter[2]);
                }

                String locationName = currentEntrySplitter[3];
                Double avgPricePerDay = Double.parseDouble(currentEntrySplitter[4]);
                Date startDate = new SimpleDateFormat("dd/MM/yyyy").parse(currentEntrySplitter[5]);
                Date endDate = new SimpleDateFormat("dd/MM/yyyy").parse(currentEntrySplitter[6]);
                ArrayList<String> activities = new ArrayList<>();
                for (int i = 7; i < currentEntrySplitter.length; i++) {
                    activities.add(currentEntrySplitter[i]);
                }
                Place tempPlace = new Place(locationName, avgPricePerDay, startDate, endDate, activities);
                tempCity.addLocationElement(tempPlace);
                tempDistrict.addLocationElement(tempCity);
                tempCountry.addLocationElement(tempDistrict);
                /**
                 * Insert this place in the location_maps.ActivityMap for all activities.
                 */
                for (String activity:activities) {
                    ActivityMap.getInstance().insertPlaceToActivity(activity, tempPlace);
                }

                /**
                 * Insert the country in the hierarchical structure which has hierarchical_structure.World as root of the tree.
                 */
                World.getInstance().addLocationElement(tempCountry);

                /**
                 * Insert the place in the map that can search the hierarchical_structure.Place by its name.
                 */
                PlacesMap.getInstance().insertLocation(tempPlace.getName(), tempPlace);

                /**
                 * Insert the district in its map.
                 */
                DistrictsMap.getInstance().insertDistrict(tempDistrict.getName(), tempDistrict);

                /**
                 * Insert the city in its map.
                 */
                CityMap.getInstance().insertCity(tempCity.getName(), tempCity);


            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
