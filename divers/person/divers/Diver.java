package person.divers;

import java.util.ArrayList;

import environment.collectables.Artefact;
import environment.marker.Color;
import person.util.WrongArtefact;

public class Diver {

    private final ArrayList<Artefact> artefacts;
    private final String teamId;
    private final Color specialityColor;

    public Diver(Strong teamId, Color color) {
        artefacts = new ArrayList<>();
        this.teamId = teamId;
        this.specialityColor = color;
    }

    public Diver() {
        this.teamId = "T1";
        this.specialityColor = Color.RED;
        artefacts = new ArrayList<>();
    }

    public ArrayList<Artefact> getArtefacts() {
        return new ArrayList<>(artefacts);
    }

    public Color getColor() {
        return specialityColor;
    }

    public String getTeamId() {
        return teamId;
    }

    public void tagArtefacts(ArrayList<Artefact> toTag) {
        if (specialityColor == Color.BLUE)
            return;
        for (Artefact a : toTag) 
            if (specialityColor == Color.GREEN || a.getRigidStructure())
                a.tag();
    }

    public boolean tryToGetArtefact(Artefact artefact) {
        if (artefact.getColor() != specialityColor)
            return false;
        Artefact a = artefact.retrieve();
        if (a != null) {
            artefacts.add(a);
            return true;
        }

        return false;
    }

    public void forceInsertArtefact(Artefact artefact) throws WrongArtefact {
        if (artefact.getColor() != specialityColor)
            throw new WrongArtefact("Wrong Color");
        
        Artefact a = artefact.retrieve();
        if (a == null) {
            a.tag();
            a = artefact.retrieve;
        }

        if (a == null || a.getLocationData().endsWith("#KO"))
            throw new WrongArtefact ("Got Waste");

        if (a != null)
            artefacts.add(a);
    }
}
