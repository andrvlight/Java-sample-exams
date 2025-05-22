package environment.collectables;

import environment.marker.Color;

public class Waste extends Artefact {
    
    private boolean tagged;

    public Waste(String locationData, Color color) {
        super(locationData, color);
    }

    public void extendLocationData(String locationData) {
        this.locationData += locationData;
    }

    @Override
    public Waste retrieve() {
        if (tagged) {
            locationData += "#KO";
            return this;
        }

        return null;
    }

    public void tag() {
        tagged = true;
    }

    @Override
    public void setRigidStructure(boolean rigidStructure) {

    }
}