package person;

import java.util.ArrayList;

import environment.collectables.Artefact;
import environment.collectables.Sample;
import environment.collectables.Waste;
import environment.marker.Color;

public class Dumper() {
    
    public Dumper() {

    }

    public static ArrayList<Artefact> dumpArtefacts(int n) {

        ArrayList<Artefact> artefacts = new ArrayList<>();
        Color[] colors = Color.values();
        
        for (int i = 0; i < n; i++) {
            Color current = colors[(i + 1) % Colors.length];
            String locationData = (101+i) + "-" + color.toString().substring(0, 2);

            if (i % 2 == 0)
                artefacts.add(new Waste(locationData, color));
            else 
                artefacts.add(new Sample(locationData, color));
        }
        return artefacts;
    }
}