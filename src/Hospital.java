public class Hospital {
    private String name;
    private final int serviceMax;
    private Service[] services;
    private Medecin[] medecins;

    public Hospital(String name, int serviceMax, Service[] services, Medecin[] medecins) {
        this.name = name;
        this.serviceMax = serviceMax;
        this.services = services;
        this.medecins = medecins;
    }

    public Hospital(int serviceMax){
        this.name = null;
        this.serviceMax = serviceMax;
        this.services = null;
        this.medecins = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getServiceMax() {
        return serviceMax;
    }

    public Service[] getServices() {
        return services;
    }

    public void setServices(Service[] services) {
        this.services = services;
    }

    public Medecin[] getMedecins() {
        return medecins;
    }

    public void setMedecins(Medecin[] medecins) {
        this.medecins = medecins;
    }

    public int getCreatureNow() {
        int creatureNow = 0;
        for (Service service : services) {
            creatureNow += service.getCreatureNow();
        }
        return creatureNow;
    }

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

    public void run(){

    }

    public static void main(String[] args) {
        Hospital hospital = new Hospital(10);

    }
}
