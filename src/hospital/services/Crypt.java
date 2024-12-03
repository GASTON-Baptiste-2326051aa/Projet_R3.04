package hospital.services;

import hospital.entity.Patient;
import hospital.entity.Patient;
import hospital.race.behavior.Revive;

import java.util.Collection;

/**
 * Crypt
 */
public class Crypt extends Service {
    /**
     * The ventilation level of the crypt
     */
    private int ventilationLevel; // Niveau de ventilation (de 1 à 10, par exemple)
    /**
     * The temperature of the crypt
     */
    private float temperature; // Température en degrés Celsius

    /**
     * Constructor of a crypt
     * @param name the name of the crypt
     * @param surface the surface of the crypt
     * @param patientMax the max number of patients
     * @param budget the budget of the crypt
     * @param ventilationLevel the ventilation level of the crypt
     * @param temperature the temperature of the crypt
     */
    public Crypt(String name, float surface, int patientMax, int budget, int ventilationLevel, float temperature) {
        super(name, surface, patientMax, budget);
        this.ventilationLevel = ventilationLevel;
        this.temperature = temperature;
    }

    /**
     * Get the ventilation level of the crypt
     * @return the ventilation level
     */
    public int getVentilationLevel() {
        return ventilationLevel;
    }

    /**
     * Set the ventilation level of the crypt
     * @param ventilationLevel the new ventilation level
     */
    public void setVentilationLevel(int ventilationLevel) {
        if (ventilationLevel < 1 || ventilationLevel > 10) {
            System.out.println("Ventilation level must be between 1 and 10.");
        } else {
            this.ventilationLevel = ventilationLevel;
        }
    }

    /**
     * Get the temperature of the crypt
     * @return the temperature
     */
    public float getTemperature() {
        return temperature;
    }

    /**
     * Set the temperature of the crypt
     * @param temperature the new temperature
     */
    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    /**
     * Override the addPatient method to ensure only regenerative patients can be added
     * @param patient a patient to add
     * @throws IllegalArgumentException if the patient is not a regenerative patient
     * @throws IllegalStateException if the service is full or the patient is already in the service
     */
    @Override
    public void addPatient(Patient patient) throws IllegalArgumentException{
        if (patient instanceof Revive) { // vérifier si c'est un mort vivant
            super.addPatient(patient);
        } else {
            System.out.println("Only regenerative patients are allowed in a crypt.");
            throw new IllegalArgumentException("Only regenerative patients are allowed in a crypt");
        }
    }


    public void setPatients(Collection<Patient> patients) throws IllegalArgumentException {
        Patient patient1;
        if (patients == null) {
            throw new IllegalArgumentException("The patients list is empty");
        }
        if (patients.isEmpty()) {
            throw new IllegalArgumentException("The patients list is empty");
        }
        patient1 = patients.iterator().next();
        if (!(patient1 instanceof Revive)) {
            throw new IllegalArgumentException("Only regenerative patients are allowed in a crypt");
        }
        for (Patient patient : patients) {
            if (!patient.getClass().equals(patient1.getClass())) {
                throw new IllegalArgumentException("The patients are not the same type");
            }
        }
        super.setPatients(patients);
    }
    /**
     * Override the budget revision to include ventilation and temperature checks
     * Faut finir la méthode
     */
    @Override
    public void setBudget(int budget) {
        super.setBudget(budget);
        System.out.println("Budget revised considering ventilation (Level " + ventilationLevel
                + ") and temperature (" + temperature + "°C).");
    }

    /**
     * Run the crypt
     */
    @Override
    public void run(){
        for (Patient patient : getPatients()) {
            patient.run();
        }
        System.out.println(getName() + " is running");
    }

    /**
     * Return the string representation of the crypt
     * @return the string representation of the crypt
     */
    @Override
    public String toString() {
        return "Crypt{" +
                "name=" + getServiceName()  +
                ", surface=" + getSurface() +
                ", patientMax=" + getPatientMax() +
                ", patientNow=" + getPatientNow() +
                ", budget=" + budgetToString(getBudget()) +
                ", ventilationLevel=" + ventilationLevel +
                ", temperature=" + temperature +
                "}";
    }
}
