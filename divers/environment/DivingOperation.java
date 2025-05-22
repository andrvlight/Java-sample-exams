package environment;

import java.util.ArrayList;
import java.util.HashSet;

import person.divers.Diver;
import environment.collectables.Artefact;
import environment.marker.Color;
import person.Dumper;
import person.util.InvalidOperation;
import person.util.WrongArtefact;


public class DivingOperation {
    private final ArrayList<Diver> teams;
    private final ArrayList<Artefact> allArtefacts;

    public DivingOperation(int totalTeams) {
        if (totalTeams % 3 != 0)
            throw new IllegalArgumentException("Number of teams must be divisible by 3");

        this.teams = new ArrayList<>();
        this.allArtefacts = new ArrayList<>();

        Color[] colors = Color.values();
        for (int i = 0; i < totalTeams; i++) {
            String teamId = "T" + (i + 1);
            Color teamColor = colors[(i + 1) % 3];
            teams.add(new Diver(teamId, teamColor));
        }
    }

    private void registerArtefacts(Artefact... artefacts) {
        for (Artefact artefact : artefacts) {
            if (artefact.getColor() == Color.GREEN) 
                registerArtefact(artefact); 
        }
    }

    private void registerArtefact(Artefact artefact) {
        if (!allArtefacts.contains(artefact))
            allArtefacts.add(artefact);            
    }

    public void prepareOperation(int n) {
        if (n <= 0)
            throw new InvalidOperation("Number of artefacts must be > 0");

        ArrayList<Artefact> dumpedArtefacts = Dumper.dumpArtefacts();

        boolean hasGreen = false;
        int[] toCheck = {0, 2, dumpedArtefacts.size() / 2, dumpedArtefacts.size() - 1};

        for (int i : toCheck) {
            if (i >= 0 && i < dumpedArtefacts.size()) 
                if (dumpedArtefacts.get(i).getColor == Color.GREEN) {
                    hasGreen = true;
                    break;
                }
        }

        if (!hasGreen)
            throw new InvalidOperation("No green artefacts found in required position");

        registerArtefacts(dumpedArtefacts.toArray(new Artefact[0]));
    }

    public HashSet<Artefact> conductOperation() {
        HashSet<Artefact> retrievedArtefacts = new HashSet<>();
        
        for (Diver diver : teams) {
            diver.tagArtefacts(allArtefacts);
            
            for (Artefact artefact : allArtefacts) {
                if (diver.tryToGetArtefact(artefact)) {
                    for (Artefact retrievedArtefact : diver.getArtefacts()) {
                        retrievedArtefacts.add(retrievedArtefact);
                    }
                } else if (diver.getColor() == Color.RED) {
                    try {
                        diver.forceInsertArtefact(artefact);
                        for (Artefact retrievedArtefact : diver.getArtefacts()) {
                            retrievedArtefacts.add(retrievedArtefact);
                        }
                    } catch (WrongArtefact e) {
                        continue;
                    }
                }
            }
        }
        
        return retrievedArtefacts;
    }


}