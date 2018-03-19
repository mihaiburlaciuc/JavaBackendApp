package main;

import hierarchical_structure.Place;

import java.util.Comparator;

public class PlacePriceComparator implements Comparator<Place> {
    @Override
    public int compare(Place place, Place t1) {
        if (place.getAvgPricePerDay() < t1.getAvgPricePerDay()) {
            return -1;
        } else if (place.getAvgPricePerDay().equals(t1.getAvgPricePerDay())) {
            return 0;
        }

        return 1;
    }
}
