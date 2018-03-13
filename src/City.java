import java.util.HashMap;

public class City extends LocationElement {
    public City(String name) {
        super(name);
        subElements = new HashMap<>();
    }

    @Override
    public void addLocationElement(LocationElement locationElement) {
        locationElement.setSuperiorElement(this);
        subElements.put(locationElement.getName(), locationElement);
    }
}
