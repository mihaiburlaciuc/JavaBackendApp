package hierarchical_structure;

import hierarchical_structure.LocationElement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class Place extends LocationElement {
    private String city;
    private Double avgPricePerDay;
    Date startDate;
    Date endDate;
    private Collection<String> activities = new ArrayList<>();

    public Place(String name, Double avgPricePerDay, Date startDate, Date endDate, Collection<String> activities) {
        super(name);
        this.avgPricePerDay = avgPricePerDay;
        this.startDate = startDate;
        this.endDate = endDate;
        this.activities = activities;
    }

    @Override
    public void setSuperiorElement(LocationElement superiorElement) {
        super.setSuperiorElement(superiorElement);
        this.city = superiorElement.getName();
    }

    /**
     * Last element in the hierarchical structure.
     * @param locationElement
     */
    @Override
    public void addLocationElement(LocationElement locationElement) {
        return;
    }

    public String getName() {
        return super.getName();
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

    public void setCity(String city) {
        this.city = city;
    }

    public void setAvgPricePerDay(Double avgPricePerDay) {
        this.avgPricePerDay = avgPricePerDay;
    }

    public void setActivities(Collection<String> activities) {
        this.activities = activities;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }
}
