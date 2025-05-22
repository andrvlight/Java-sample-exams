package environment.collectables;

import environment.marker.Color;

public class Sample extends Artefact {
    
    private boolean tagged;
    
    public Sample(String locationData, Color color) {
        super (locationData, color);
        this.setRigidStructure(false);
    }

    @Override
    public void extendLocationData (String locationData) {
        this.locationData += locationData;
    }

    @Override
    public Sample retrieve () {
        if (getRigidStructure || tagged) {
            int length = locationData.length() + color.toString()length();
            if (length > 9 && length < 14) 
                locationData += "#OK";
            else 
                locationData += "#NO";
        }

        return this;
    }

    public void tag() {
        tagged = true;
        setRigidStructure(!getRigidStructure());
    }
}