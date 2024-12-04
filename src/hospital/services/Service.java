package hospital.services;

import hospital.Hospital;
import hospital.entity.Patient;
import hospital.race.behavior.Contaminate;
import hospital.race.behavior.Demoralize;
import hospital.race.behavior.Revive;

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
        System.out.println(patient.getName() + " has been added to the service.");
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
     * sort the patient by Illness level and Morale using Quicksort
     *
     * @param patients the patient to sort
     * @return the patient sort by Illness level and Morale
     */
    private Patient[] sortIllnessAndMorale(Patient[] patients) {
        if (patients.length < 2) {
            return patients;
        }
        List<Patient> less = new ArrayList<>();
        List<Patient> more = new ArrayList<>();
        Patient pivot = patients[0];

        for (Patient patient : patients) {
            if (patient.compareMoraleAndIllnessLevel(pivot))
                more.add(patient);
            else less.add(patient);
        }
        List<Patient> tmp = new ArrayList<>(Arrays.asList(sortIllnessAndMorale(less.toArray(new Patient[0]))));
        tmp.add(pivot);
        tmp.addAll(Arrays.asList(sortIllnessAndMorale(more.toArray(new Patient[0]))));
        return tmp.toArray(new Patient[0]);
    }

    /**
     * a patient contaminate the service
     */
    public void contaminate(Contaminate contaminate) {

    }

    /**
     * a patient demoralise the service
     */
    public void demoralize(Demoralize demoralize) {

    }

    /**
     * a patient revive in the service
     */
    public void revive(Revive revive) {

    }

    /**
     * Return the string representation of a service
     * @return the string representation of a service
     */
    @Override
    public String toString() {
        return "Service{" +
                "name='" + name + '\'' +
                ", surface=" + surface +
                ", patientMax=" + patientMax +
                ", patientNow=" + patientNow +
                ", patients=" + patients +
                ", budget=" + budgetToString(budget) +
                "}";
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