package environment.collectables;

import environment.marker.Marked;
import environment.marker.Color;

import java.util.Objects;

public abstract class Artefact implements Marked {
    protected String locationData;
    protected Color color;
    private boolean rigidStructure;

    public Artefact (String locationData, Color color) {
        if (locationData == null || locationData.size() < 3)
            throw new IllegalArgumentException;
        this.locationData = locationData;
        this.color = color;
        this.rigidStructure = true;
    }

    public Color getColor() {
        return this.color;
    }

    public String getLocationData() {
        return this.locationData;
    }

    public boolean getRigidStructure() {
        return this.rigidStructure;
    }

    public void setRigidStructure(boolean rigidStructure) {
        this.rigidStructure = rigidStructure;
    }

    public abstract void extendLocationData (String newData);

    public abstract Artefact retrieve();

    @Override
    public String toString() {
        return "LocationData: " + locationData + ", Color: " + color + ", isRigid: " + rigidStructure;
    }

    @Override 
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (this == obj)
            return true;
        if (!(obj instanceof Artefact other))
            return false;

        return  rigidStructure == other.rigidStructure &&
            Objects.equals(locationData, other.locationData) &&
            Objects.equals(color, other.color);
    } 

    @Override 
    public int hashCode() {
        return Objects.hash(locationData, color, rigidStructure);
    }
}