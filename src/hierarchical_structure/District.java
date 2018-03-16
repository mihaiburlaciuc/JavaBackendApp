package hierarchical_structure;

import java.util.HashMap;

public class District extends LocationElement {
    public District(String name) {
        super(name);
        subElements = new HashMap<>();
    }

    @Override
    public void addLocationElement(LocationElement locationElement) {
        locationElement.setSuperiorElement(this);
        subElements.put(locationElement.getName(), locationElement);
    }
}
