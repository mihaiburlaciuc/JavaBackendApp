package main;

import hierarchical_structure.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public class Utility {

    public static ArrayList<Place> getPlacesFromCountryByDate(String countryName, Date start, Date end) {
        Country country = (Country) World.getInstance().getElement(countryName);
        ArrayList<Place> places = new ArrayList<>();


        for(Map.Entry<String, LocationElement> districtEntry : country.getSubElements().entrySet()) {
            places.addAll(getPlacesFromDistrictByDate((District) districtEntry.getValue(), start, end));
        }

        return places;
    }

    public static ArrayList<Place> getPlacesFromDistrictByDate(District district,
                                                               Date start,
                                                               Date end) {
        ArrayList<Place> places = new ArrayList<>();

        for(Map.Entry<String, LocationElement> cityEntry : district.getSubElements().entrySet()) {
            places.addAll(getPlacesFromCityByDate((City) cityEntry.getValue(), start, end));
        }

        return places;
    }

    public static ArrayList<Place> getPlacesFromCityByDate(City city,
                                                           Date start,
                                                           Date end) {
        ArrayList<Place> places = new ArrayList<>();

        for(Map.Entry<String, LocationElement> placeEntry : city.getSubElements().entrySet()) {
            Place tempPlace = (Place) placeEntry.getValue();

            if (tempPlace.getStartDate().compareTo(start) <= 0
                    && tempPlace.getEndDate().compareTo(end) >= 0) {
                places.add(tempPlace);
            }
        }
        return places;
    }
}
