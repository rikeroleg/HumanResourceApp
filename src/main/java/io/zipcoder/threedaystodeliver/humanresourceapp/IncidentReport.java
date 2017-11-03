package io.zipcoder.threedaystodeliver.humanresourceapp;

import java.util.ArrayList;

public class IncidentReport {

    private ArrayList<Person> personsInvolved = new ArrayList<>(10);
    public enum IncidentCategory {
        type1,
        type2,
        type3,
        type4
    }
    private IncidentCategory incidentCategory;
    private ArrayList<String> description = new ArrayList<>(10);
    private int id;
    private static int nextId = 1;

    public IncidentReport(IncidentCategory category, String initialDescription) {
        incidentCategory = category;
        description.add(initialDescription);
        id = nextId;
        nextId++;
        IncidentReportWarehouse.addIncident(this);
    }

    public ArrayList<Person> getPersonsInvolved() {
        return personsInvolved;
    }

    public IncidentCategory getIncidentCategory() {
        return incidentCategory;
    }

    public ArrayList<String> getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public void addPersonToIncidentReport(Person person) {
        personsInvolved.add(person);
        person.addIncidentReport(this);
    }

    public void removePersonFromIncidentReport(Person person) {
        personsInvolved.remove(person);
        person.removeIncidentReport(this);
    }

    public void updateIncidentReport(IncidentCategory category) {
        incidentCategory = category;
    }

    public void updateIncidentReport(String nextDescription) {
        description.add(nextDescription);
    }
}
