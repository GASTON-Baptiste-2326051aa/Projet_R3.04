package models;

import models.creatures.Creature;
import models.creatures.Doctor;
import models.services.Service;

/**
 * Class Hospital
 */
public class Hospital {
    private String name;
    private final int serviceMax;
    private Service[] services;
    private Doctor[] doctors;

    /**
     * constructor of the class Hospital
     * @param name the name of the hospital
     * @param serviceMax the number max of service in the hospital
     * @param services the number of service in the hospital
     * @param doctors the list of doctor in the hospital
     */
    public Hospital(String name, int serviceMax, Service[] services, Doctor[] doctors) {
        this.name = name;
        this.serviceMax = serviceMax;
        this.services = services;
        this.doctors = doctors;
    }

    /**
     * constructor of the class Hospital
     * @param serviceMax the number max of service in the hospital
     */
    public Hospital(int serviceMax){
        this.name = null;
        this.serviceMax = serviceMax;
        this.services = null;
        this.doctors = null;
    }

    /**
     * return this.name
     * @return this.name
     */
    public String getName() {
        return name;
    }

    /**
     * define the new value of this.name
     * @param name the new value of this.name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * return the max amount of service in the hospital
     * @return the max amount of service in the hospital
     */
    public int getServiceMax() {
        return serviceMax;
    }

    /**
     * return the list of service in the hospital
     * @return the list of service in the hospital
     */
    public Service[] getServices() {
        return services;
    }

    /**
     *  define the services of the hospital
     * @param services the new value of this.services
     */
    public void setServices(Service[] services) {
        this.services = services;
    }

    /**
     * return the list of doctor in the hospital
     * @return the doctor in the hospital
     */
    public Doctor[] getDoctor() {
        return doctors;
    }

    /**
     * define the new value of this.doctor
     * @param doctors the new value of this.doctor
     */
    public void setDoctor(Doctor[] doctors) {
        this.doctors = doctors;
    }

    /**
     * return the number of creature in the hospital
     * @return the number of creature in the hospital
     */
    public int getCreatureNow() {
        int creatureNow = 0;
        for (Service service : services) {
            creatureNow += service.getCreatureNow();
        }
        return creatureNow;
    }

    /**
     * return the list of creature in the hospital
     * @return the creature in the hospital
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
     * start the hospital simulation
     */
    public void run(){

    }

    /**
     * main function
     * @param args the arguments of the main function
     */
    public static void main(String[] args) {
        Hospital hospital = new Hospital(10);
        hospital.run();
    }
}
