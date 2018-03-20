package hierarchical_structure;

import java.util.HashMap;

public abstract class LocationElement {
    private String name;
    protected HashMap<String, LocationElement> subElements;
    protected LocationElement superiorElement;

    public void setSuperiorElement(LocationElement superiorElement) {
        this.superiorElement = superiorElement;
    }

    public LocationElement(String name) {
        this.name = name;
    }

    public LocationElement getElement(String name) {
        return subElements.get(name);
    }

    public HashMap<String, LocationElement> getSubElements() {
        return subElements;
    }

    public String getName() {
        return name;
    };

    public abstract void addLocationElement(LocationElement locationElement);

    public LocationElement getSuperiorElement() {
        return superiorElement;
    }
}
