import java.util.HashMap;

public class Country extends LocationElement {
    public Country(String name) {
        super(name);
        subElements = new HashMap<>();
    }

    @Override
    public void addLocationElement(LocationElement locationElement) {
        System.out.println(this.getClass() + ": " + locationElement.getName());
        locationElement.setSuperiorElement(this);
        subElements.put(locationElement.getName(), locationElement);
    }
}
