package person;

import java.util.ArrayList;

import environment.collectables.Artefact;

public class Dumper() {
    
    public Dumper() {

    }

    public static ArrayList<Artefact> dumpArtefacts(int n) {
        ArrayList<Artefact> artefacts = new ArrayList<>();
        Color[] colors = Color.values();
        for (int i = 0; i < n; i++) {
            Color current = colors[(i + 1) % Colors.length()];

            if (i % 2 == 0)
                artefacts.add(new Waste(locationData, color));
            else 
                artefacts.add(new Sample(locationData, color));
        }
        return artefacts;
    }
}