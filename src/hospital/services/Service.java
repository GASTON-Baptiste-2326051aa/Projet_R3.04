package hospital.services;

import hospital.Hospital;
import hospital.entity.Patient;

import java.util.*;

/**
 * Service
 */
public class Service extends Thread {
    /**
     * The name of the service
     */
    private String name;
    /**
     * The surface of the service
     */
    private float surface;
    /**
     * The max amount of patient than the service could get
     */
    private final int patientMax;
    /**
     * The actual number of patients inside the service
     */
    private int patientNow = 0;
    /**
     * The patients inside the service
     */
    private Collection<Patient> patients;
    /**
     * The budget of the service
     */
    private int budget;
    /**
     * The Hospital
     */
    private final Hospital hospital;

    /**
     * The type of creature in the service
     */
    private int race = 8;

    /**
     * Constructor of a medical service
     * @param name the name of the service
     * @param surface the surface of the service
     * @param patientMax the max amount of patient than the service could get
     * @param budget the budget of the service
     */
    public Service(String name, float surface, int patientMax, int budget) {
        this.name = name;
        this.surface = surface;
        this.patientMax = patientMax;
        this.patients = new ArrayList<>();
        this.budget = budget;
        this.hospital= new Hospital();
    }

    /**
     * Constructor of a medical service
     * @param name the name of the service
     * @param surface the surface of the service
     * @param patientMax the max amount of patient than the service could get
     * @param budget the budget of the service
     * @param hospital the hospital where the service is
     */
    public Service(String name, float surface, int patientMax, int budget, Hospital hospital) {
        this.name = name;
        this.surface = surface;
        this.patientMax = patientMax;
        this.patients = new ArrayList<>();
        this.budget = budget;
        this.hospital = hospital;
    }

    /**
     * Constructor of a medical service
     *
     * @param name        the name of the service
     * @param surface     the surface of the service
     * @param patientMax the max amount of patient than the service could get
     * @param budget      the budget of the service
     * @param patients   the patients inside the service
     */
    public Service(String name, float surface, int patientMax, int budget, Collection<Patient> patients, Hospital hospital) {
        this.name = name;
        this.surface = surface;
        this.patientMax = patientMax;
        this.patients = patients;
        this.budget = budget;
        this.hospital = hospital;
    }

    /**
     * Constructor of a medical service
     *
     * @param name        the name of the service
     * @param surface     the surface of the service
     * @param patientMax the max amount of patient than the service could get
     * @param budget      the budget of the service
     * @param patients   the patients inside the service
     * @param race       the race of the patient inside the service
     */
    public Service(String name, float surface, int patientMax, int budget, Collection<Patient> patients, Hospital hospital, int race) {
        this.name = name;
        this.surface = surface;
        this.patientMax = patientMax;
        this.patients = patients;
        this.budget = budget;
        this.hospital = hospital;
        this.race = race;
    }

    /**
     * Return the name of a service
     * @return the name of a service
     */
    public String getServiceName() {
        return name;
    }

    /**
     * Set the name of a service
     * @param name the name of a service
     */
    public void setServiceName(String name) {
        this.name = name;
    }

    /**
     * Return the surface of a service
     * @return the surface of a service
     */
    public float getSurface() {
        return surface;
    }

    /**
     * Set the surface of a service
     * @param surface the surface of a service
     */
    public void setSurface(float surface) {
        this.surface = surface;
    }

    /**
     * Get the max number of patients inside a service
     * @return the max number of patients inside a service
     */
    public int getPatientMax() {
        return patientMax;
    }

    /**
     * Get the actual number of patients inside a service
     * @return the actual number of patients inside a service
     */
    public int getPatientNow() {
        return patientNow;
    }

    /**
     * Set the number of patients inside a service
     */
    public void setPatientNow() {
        this.patientNow = this.patients.size();
    }

    /**
     * Return all the patients inside a service
     *
     * @return all the patients inside a service
     */
    public Collection<Patient> getPatients() {
        sortIllnessAndMorale();
        return patients;
    }

    /**
     * Set all the patient inside a service
     * @param patients all the patient inside a service
     */
    public void setPatients(Collection<Patient> patients) throws IllegalArgumentException {
        Patient patient1;
        if (patients == null) {
            throw new IllegalArgumentException("The patients list is empty.");
        }
        if (patients.isEmpty()) {
            throw new IllegalArgumentException("The patients list is empty.");
        }
        patient1 = patients.iterator().next();
        for (Patient patient : patients) {
            if (!patient.getClass().equals(patient1.getClass())) {
                throw new IllegalArgumentException("The patients are not the same type.");
            }
        }
        for (Patient patient : patients) {
            if (isFull()) {
                throw new IllegalArgumentException("The service is full");
            }
            if (isPatientInService(patient)) {
                throw new IllegalArgumentException(patient.getName() + " is already in the service.");
            }
            patient.setService(this);
        }
        this.patients = patients;
        sortIllnessAndMorale();
    }

    /**
     * Return the budget of a service
     * @return the budget of a service
     */
    public int getBudget() {
        return budget;
    }

    /**
     * Set the budget of a service
     * @param budget the budget of a service
     */
    public void setBudget(int budget) {
        this.budget = budget;
        System.out.println("The budget of the service is now " + budgetToString(budget) + ".");
    }

    /**
     * return the hospital where the service is
     * @return the hospital where the service is
     */
    public Hospital getHospital() {
        return this.hospital;
    }

    /**
     * Convert the budget into a String
     * @param budget the budget
     * @return a String
     */
    public String budgetToString(int budget) {
        return switch (budget) {
            case 0 -> "non-existent";
            case 1 -> "poor";
            case 2 -> "insufficient";
            case 3 -> "low";
            default -> "correct";
        };
    }

    /**
     * Add a patient inside a service
     * @param patient a patient to add to the service if it's possible
     * @throws IllegalArgumentException if the patient is not the same type as the other patients in the service
     * @throws IllegalStateException if the service is full
     */
    public void addPatient(Patient patient) throws IllegalArgumentException, IllegalStateException {
        if (this.patients == null) {
            this.patients = new ArrayList<>();
        }
        if(isPatientInService(patient)) {
            System.out.println(patient.getName() + " is already in the service.");
            throw new IllegalStateException(patient.getName() + " is already in the service.");
        }
        if (isFull()) {
            System.out.println("The service is full.");
            throw new IllegalStateException("The service is full.");
        }
        if (!patients.isEmpty() && !patients.iterator().next().getClass().equals(patient.getClass())) {
            System.out.println("This service is only for " + patients.iterator().next().getClass().getSimpleName() + ".");
            throw new IllegalArgumentException("This service is only for " + patients.iterator().next().getClass().getSimpleName() + ".");
        }
        this.patients.add(patient);
        patient.setService(this);
        this.patientNow++;
        System.out.println(patient.getName() + " has been added to the " + getServiceName() + ".");
        sortIllnessAndMorale();
    }

    /**
     * Remove a patient from a service
     * @param patient a patient to remove from the service
     * @throws IllegalArgumentException if the patient is not in the service
     */
    public void removePatient(Patient patient) throws IllegalArgumentException {
        if (this.patients.contains(patient)) {
            this.patients.remove(patient);
            this.patientNow--;
            System.out.println(patient.getName() + " has been removed from the service.");
        }
        else {
            System.out.println(patient.getName() + " is not in the service.");
            throw new IllegalArgumentException(patient.getName() + " is not in the service.");
        }
        sortIllnessAndMorale();
    }

    /**
     * Function allowing us to swap elements in an array, used for sorting
     * @param patients the array of patient
     * @param i index to swap
     * @param j index to swap
     */
    public void swap(Patient[] patients, int i, int j) {
        Patient temp = patients[i];
        patients[i] = patients[j];
        patients[j] = temp;
    }

    /**
     * Sort every patient in the service according to their morale
     * Use a bubble sort
     */
    public void sortMorale() {
        int n = getPatients().size();
        // Filtrer uniquement les patients
        Patient[] patients = getPatients()
                .stream()
                .filter(Objects::nonNull) // Caster en Patient
                .toArray(Patient[]::new); // Convertir en tableau

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (patients[j].compareMorale(patients[j + 1])) {
                    swap(patients, j, j + 1);
                }
            }
        }
        // Met à jour la collection avec les patients triés
        this.patients = new ArrayList<>(Arrays.asList(patients));
    }

    /**
     * Test if the patient is in the service
     */
    public boolean isPatientInService(Patient patient) {
        return patients.contains(patient);
    }

    /**
     * Check if the service is full
     * @return true if the service is full, false otherwise
     */
    public boolean isFull() {
        return patientNow == patientMax;
    }

    /**
     * Sort every patient in the service according to their illness level
     * Use a bubble sort
     */
    public void sortIllnessLevel() {
        int n = getPatients().size();
        Patient[] patients = getPatients().toArray(new Patient[0]);
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (patients[j].compareIllnessLevel(patients[j + 1]))
                    swap(patients, j, j + 1);
            }
        }
        this.patients = new ArrayList<>(Arrays.asList(patients));
    }

    /**
     * sort this patient by Illness level and Morale using Quicksort
     */
    public void sortIllnessAndMorale(){
        this.patients = sortIllnessAndMorale(this.patients);
    }

    /**
     * sort the patient by Illness level and Morale using Quicksort
     *
     * @param patients the patient to sort
     * @return the patient sort by Illness level and Morale
     */
    private Collection<Patient> sortIllnessAndMorale(Collection<Patient> patients) {
        if (patients.size() < 2) {
            return patients;
        }
        Collection<Patient> less = new ArrayList<>();
        Collection<Patient> more = new ArrayList<>();
        Patient pivot = patients.toArray(new Patient[]{})[0];

        for (Patient patient : patients) {
            if (patient.compareMoraleAndIllnessLevel(pivot))
                more.add(patient);
            else less.add(patient);
        }
        Collection<Patient> tmp = new ArrayList<>(less);
        tmp.addAll(new ArrayList<>(more));
        return tmp;
    }

    /**
     * return the race than can be in the service
     * @return the race than can be in the service
     */
    public int getRace(){
        return this.race;
    }


    /**
     * Return the string representation of a service
     * @return the string representation of a service
     */
    @Override
    public String toString() {
        return "Service : " +
                "\nName='" + name + '\'' +
                "\nSurface=" + surface +
                "\nPatientMax=" + patientMax +
                "\nPatientNow=" + patientNow +
                "\nPatients=" + patients +
                "\nBudget=" + budgetToString(budget) + " ";
    }

    /**
     * Run the service
     */
    @Override
    public void run() {
        while (hospital.isRunning()) {
            for (Service service : getHospital().getServices()) {
                if (!service.getPatients().isEmpty()) {
                    for (Patient patient : service.getPatients()) {
                        patient.run();
                    }
                }
            }

        }
    }
}