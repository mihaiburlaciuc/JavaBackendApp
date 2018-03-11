import java.util.ArrayList;
import java.util.Collection;

public class Place {
    private String name;
    private String city;
    private Double avgPricePerDay;
    private Collection<String> activities = new ArrayList<>();

    public Place(String name, String city, Double avgPricePerDay, Collection<String> activities) {
        this.name = name;
        this.city = city;
        this.avgPricePerDay = avgPricePerDay;
        this.activities = activities;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public Double getAvgPricePerDay() {
        return avgPricePerDay;
    }

    public Collection<String> getActivities() {
        return activities;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setAvgPricePerDay(Double avgPricePerDay) {
        this.avgPricePerDay = avgPricePerDay;
    }

    public void setActivities(Collection<String> activities) {
        this.activities = activities;
    }
}
