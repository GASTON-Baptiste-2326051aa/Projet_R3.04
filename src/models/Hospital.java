package models;

import models.creatures.Creature;
import models.creatures.Doctor;
import models.services.Service;

public class Hospital {
    private String name;
    private final int serviceMax;
    private Service[] services;
    private Doctor[] doctors;

    /**
     * Constructor of the class Hospital
     * @param name the name of the hospital
     * @param serviceMax the maximum number of services in the hospital
     * @param services the list of services in the hospital
     * @param doctors the list of doctors in the hospital
     */
    public Hospital(String name, int serviceMax, Service[] services, Doctor[] doctors) {
        this.name = name;
        this.serviceMax = serviceMax;
        this.services = services != null ? services : new Service[serviceMax];
        this.doctors = doctors != null ? doctors : new Doctor[0];
    }

    /**
     * Constructor of the class Hospital
     * @param serviceMax the maximum number of services in the hospital
     */
    public Hospital(int serviceMax) {
        this.name = null;
        this.serviceMax = serviceMax;
        this.services = new Service[serviceMax];
        this.doctors = new Doctor[0];
    }

    /**
     * Return the name of the hospital
     * @return the name of the hospital
     */
    public String getName() {
        return this.name;
    }

    /**
     * Set the name of the hospital
     * @param name the new name of the hospital
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Return the maximum number of services in the hospital
     * @return the maximum number of services in the hospital
     */
    public int getServiceMax() {
        return serviceMax;
    }

    /**
     * Return the list of services in the hospital
     * @return the services in the hospital
     */
    public Service[] getServices() {
        return services;
    }

    /**
     * Set the list of services in the hospital
     * @param services the new list of services in the hospital
     */
    public void setServices(Service[] services) {
        this.services = services;
    }

    /**
     * Return the list of doctors in the hospital
     * @return the doctors in the hospital
     */
    public Doctor[] getDoctors() {
        return doctors;
    }

    /**
     * Set the list of doctors in the hospital
     * @param doctors the new list of doctors in the hospital
     */
    public void setDoctors(Doctor[] doctors) {
        this.doctors = doctors;
    }

    /**
     * Return the current number of creatures in the hospital
     * @return the current number of creatures in the hospital
     */
    public int getCreatureNow() {
        int creatureNow = 0;
        for (Service service : services) {
            creatureNow += service.getCreatureNow();
        }
        return creatureNow;
    }

    /**
     * Return the list of creatures in the hospital
     * @return the creatures in the hospital
     */
    public Creature[] getCreatures() {
        Creature[] creatures = new Creature[getCreatureNow()];
        int i = 0;
        for (Service service : services) {
            for (Creature creature : service.getCreatures()) {
                creatures[i++] = creature;
            }
        }
        return creatures;
    }

    /**
     * start the hospital
     */
    public void run() {
        // TODO
    }

    public static void main(String[] args) {
        Hospital hospital = new Hospital(10);
        hospital.run();
    }
}